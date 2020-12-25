package boardGame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import boardGame.dao.DiscussionDAO;
import boardGame.model.DiscussionBoard;

@Service
public class DiscussionServiceImpl implements DiscussionService {

	@Autowired
	public DiscussionDAO discussionDAO;

	@Transactional
	public List<DiscussionBoard> getListOfArtical() {
		return discussionDAO.getListOfArtical();
	}

//	@Transactional
//	public void addArtical(DiscussionBoard discussionBoard){
//		 discussionDAO.addArtical(discussionBoard);
//	}
	@Transactional
	public void editArtical(DiscussionBoard discussionBoard) {
		discussionDAO.editArtical(discussionBoard);
	}

	@Transactional
	public void deleteArtical(String distitle) {
		discussionDAO.deleteArtical(distitle);
	}

	@Override
	public boolean findDisID(Integer DiscussionBoardID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addArtical(int discussionBoardID, String distitle, String disArtical) {
		discussionDAO.addArtical(discussionBoardID, distitle, disArtical);

	}

}
