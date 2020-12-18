package service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.disDAO;
import dao.disDAOImpl;
import model.dis;
import net.bytebuddy.asm.Advice.Return;

@Service
public class disServiceImpl implements disService {

	@Autowired
	private disDAOImpl disDAO;

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

	@Transactional
	
	public  List<dis> getData(String action, String id, String comment , String named, String time ){
		switch (action) {
		case "insert":
			List<dis> listDis = new ArrayList<dis>();
			listDis.add(new dis(id, null, comment, null));
			disDAO.insert(listDis.get(0));
			return listDis;
		case "delete":
			List<dis> listDis2 = new ArrayList<dis>();
			listDis2.remove(id);
			disDAO.delete(id, comment);
			return listDis2;
//		case "update":
//			List<dis> listDis3 = new ArrayList<dis>();
//			
//			disDAO.update(id, comment);
//			return listDis3;	
			default:
			break;
		}
	return null;
}
}
