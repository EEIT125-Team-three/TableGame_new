package boardGame.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import boardGame.dao.DiscussionDAO;
import boardGame.dao.MemberDAO;
import boardGame.dao.ProductDAO;
import boardGame.dao.ProductDAO_interface;
import boardGame.model.Cata2;
import boardGame.model.DiscussionBoard;
import boardGame.model.Product;
import boardGame.model.ReText;

@Service
public class DiscussionServiceImpl implements DiscussionService {
	@Autowired
	MemberDAO memberDAO;
	@Autowired
	public DiscussionDAO discussionDAO;
	@Autowired
	ProductDAO_interface productDao;
	@Override
	@Transactional
	public List<DiscussionBoard> getListOfArtical() {
		return discussionDAO.getListOfArtical();
	}

	@Override
	@Transactional
	public void editArtical(Integer DiscussionBoardID,Integer disLikeNo,Integer memId,Integer cata2,String disArticle,String distitle) {
		Date toDate = new Date();
		DiscussionBoard discussionBoard = discussionDAO.getDiscussionBoardID(DiscussionBoardID);
		discussionBoard.setDisLikesNo(disLikeNo);
		discussionBoard.setDisArtical(disArticle);
		discussionBoard.setDistitle(distitle);
		discussionBoard.setMember(memberDAO.getMember(memId));
		discussionBoard.setDisDate(toDate);
		discussionBoard.setSectionNum(1);
		discussionDAO.editArtical(discussionBoard);
	}

	@Override
	@Transactional
	public void deleteArtical(Integer DiscussionBoardID) {
		discussionDAO.deleteArtical(DiscussionBoardID);
		discussionDAO.deleteAllReText(DiscussionBoardID);
	}

	@Override
	@Transactional
	public void addArtical(Integer id, String distitle, String disArtical,Integer cata2) {
		Date disDate = new Date();
		Cata2 cata = productDao.getCata2ByKeys(cata2);
		DiscussionBoard disBoard = new DiscussionBoard(memberDAO.getMember(id), distitle, disArtical, disDate, 1, cata, 0);
		discussionDAO.addArtical(disBoard) ;
	}

	@Override
	@Transactional
	public DiscussionBoard getDiscussionBoardID(Integer discussionBoardID) {
		return discussionDAO.getDiscussionBoardID(discussionBoardID);

	}
	//文章列表
	@Override
	@Transactional
	public List<DiscussionBoard> getArtList(Integer cata2) {
		
		return discussionDAO.getArtList(cata2);
	}

	// 個人留言歷史查詢
	@Override
	@Transactional
	public List<DiscussionBoard> getDisHistory(Integer id) {
		return discussionDAO.getDisHistory(id);
	}
	//文章列表-會員
//	@Override
//	public List<DiscussionBoard> getListonlyArt(Integer DiscussionBoardID) {
//		return discussionDAO.getListonlyArt(DiscussionBoardID);
//	}
	@Transactional
	@Override
	public Cata2 getCata2Name(Integer cata2) {
		return discussionDAO.getCata2Name(cata2);
	}

	@Transactional
	@Override
	public void addReText(Integer memId, Integer mainArticleId, String reTextTitle, String reText) {
		String memName = memberDAO.getMember(memId).getMemName();
		Date toDate = new Date();
		ReText rt = new ReText();
		rt.setDate(toDate);
		rt.setMemId(memId);
		rt.setMainArticleId(mainArticleId);
		rt.setReTextTitle(reTextTitle);
		rt.setReText(reText);
		rt.setMemNam(memName);
		discussionDAO.addReText(rt);		
	}
	@Transactional
	@Override
	public List<ReText> getReText(Integer mainArticleId) {
		return discussionDAO.getReText(mainArticleId);		
	}
	@Transactional
	@Override
	public void deleteReText(Integer retextId) {
		discussionDAO.deleteReText(retextId);
	}

}
