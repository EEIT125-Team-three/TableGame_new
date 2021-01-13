package boardGame.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import boardGame.dao.DiscussionDAO;
import boardGame.dao.MemberDAO;
import boardGame.dao.ProductDAO_interface;
import boardGame.model.Cata2;
import boardGame.model.DiscussionBoard;
import boardGame.model.Product;

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
	public void editArtical(DiscussionBoard discussionBoard) {
		discussionBoard.setDisDate(new Date());
		discussionDAO.editArtical(discussionBoard);
	}

	@Override
	@Transactional
	public void deleteArtical(Integer DiscussionBoardID) {
		discussionDAO.deleteArtical(DiscussionBoardID);
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

}
