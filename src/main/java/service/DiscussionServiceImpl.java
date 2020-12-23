package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DiscussionDAO;
import model.DiscussionBoard;

@Service
public class DiscussionServiceImpl implements DiscussionService{
	
	@Autowired 
	public DiscussionDAO discussionDAO;
	
	public List<DiscussionBoard> getListOfArtical() {
		return discussionDAO.getListOfArtical();
	}
	public boolean addArtical(DiscussionBoard discussionBoard){
		return discussionDAO.addArtical(discussionBoard);
	}
	public boolean editArtical(DiscussionBoard discussionBoard) {
		return discussionDAO.editArtical(discussionBoard);
	}
	
	public boolean deleteArtical(String distitle) {
		return discussionDAO.deleteArtical(distitle);
	}
}
