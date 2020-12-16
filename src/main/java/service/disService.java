package service;

import java.util.List;

import model.dis;

public interface disService {
	
	public void insert(dis dis);

	public void update(String id, String comment);

	public void delete(String id, String comment);

	public List <dis> ShowAllComments();


}
