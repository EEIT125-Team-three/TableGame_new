package boardGame.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import boardGame.dao.DiscussionDAO;
import boardGame.dao.MemberDAO;
import boardGame.model.DiscussionBoard;


@Service
public class DiscussionServiceImpl implements DiscussionService {
	@Autowired
	MemberDAO memberDAO;
	@Autowired
	public DiscussionDAO discussionDAO;

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
	public void addArtical(Integer id,String distitle, String disArtical)  {
		Date disDate = new Date();
		discussionDAO.addArtical(new DiscussionBoard(memberDAO.getMember(id),distitle,disArtical , disDate,0 )) ;
		System.out.println(disDate);
	}

	@Override
	@Transactional
	public DiscussionBoard getDiscussionBoardID(Integer discussionBoardID) {
	return 	discussionDAO.getDiscussionBoardID(discussionBoardID);
		
	}

	



}
