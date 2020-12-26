package boardGame.service;

import java.util.List;

import org.springframework.ui.Model;

import boardGame.model.DiscussionBoard;

public interface DiscussionService {
	public List<DiscussionBoard> getListOfArtical();

	public void editArtical(DiscussionBoard discussionBoard);

	public void deleteArtical(String distitle);
	
	public boolean findDisID (Integer DiscussionBoardID);


	public void addArtical(String distitle, String disArtical, Model model);

}
