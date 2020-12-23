package boardGame.service;

import java.util.List;

import boardGame.model.dis;

public interface disService {
	
	public void insert(dis dis);

	public void update(String id, String comment);

	public void delete(String id, String comment);

	public List <dis> ShowAllComments();

	public List<dis> getData(String action, String id, String comment, String named, String time);

	


}
