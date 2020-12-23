package boardGame.dao;

import java.util.List;

import boardGame.model.dis;

public interface disDAO {

	public void insert(dis dis);

	public void update(String id, String comment);

	public void delete(String id, String comment);

	public List<dis> ShowAllComments();

}
