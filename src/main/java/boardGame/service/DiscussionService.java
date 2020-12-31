package boardGame.service;

import java.util.List;

import org.springframework.ui.Model;

import boardGame.model.DiscussionBoard;

public interface DiscussionService {
	public List<DiscussionBoard> getListOfArtical();

	public void editArtical(DiscussionBoard discussionBoard);

	public void deleteArtical(Integer DiscussionBoardID);
	
	public void addArtical(Integer id,String distitle, String disArtical );

	public DiscussionBoard getDiscussionBoardID(Integer discussionBoardID);

	//個人留言歷史查詢
	List<DiscussionBoard> getDisHistory(Integer id);
}
