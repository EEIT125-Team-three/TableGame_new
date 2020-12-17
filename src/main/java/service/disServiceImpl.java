package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.disDAO;
import model.dis;

@Service
public class disServiceImpl implements disService {

	@Autowired
	private disDAO disDAO;

	@Override
	@Transactional
	public List<dis> ShowAllComments() {
		return disDAO.ShowAllComments();
	}

	@Override
	@Transactional
	public void insert(dis dis) {
		disDAO.insert(dis);
	}

	@Override
	@Transactional
	public void update(String id, String comment) {
		disDAO.update(id, comment);
	}

	@Override
	@Transactional
	public void delete(String id, String comment) {
		disDAO.delete(id, comment);
	}

}
