package boardGame.dao;

import java.util.List;

import boardGame.model.DiscussionBoard;

public interface DiscussionDAO {

	public List<DiscussionBoard> getListOfArtical();

	public void addArtical(DiscussionBoard discussionBoard);

	public void editArtical(DiscussionBoard discussionBoard);

	public void deleteArtical(Integer DiscussionBoardID);

	public DiscussionBoard getDiscussionBoardID (Integer DiscussionBoardID);

	//個人留言歷史查詢
	List<DiscussionBoard> getDisHistory(Integer id);
}
