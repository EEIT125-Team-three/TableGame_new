package service;

import java.util.List;

import model.DiscussionBoard;

public interface DiscussionService {
	public List<DiscussionBoard> getListOfArtical();

	public boolean addArtical(DiscussionBoard discussionBoard);

	public boolean editArtical(DiscussionBoard discussionBoard);

	public boolean deleteArtical(String distitle);

}
