package boardGame.dao;

import java.util.List;

import boardGame.model.DiscussionBoard;

public interface DiscussionDAO {

	public List<DiscussionBoard> getListOfArtical();

	public boolean addArtical(DiscussionBoard discussionBoard);

	public boolean editArtical(DiscussionBoard discussionBoard);

	public boolean deleteArtical(String distitle);

}
