package service;


import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.InfoDAOInterface;
import model.InfoBean;

@Service
public class InfoServiceImpl implements InfoService {
	@Autowired
	InfoDAOInterface dao;
	
	@Transactional
	@Override
	public boolean idExists(String activityId) {
		boolean exist = false;
		exist = dao.idExists(activityId);
		return exist;
	}

	@Transactional
	@Override
	public int updateInfo(InfoBean inf) {
		int count = 0;
		dao.updateInfo(inf);
		count++;
		return count;
	}

	@Transactional
	@Override
	public int saveInfo(InfoBean inf) {
		int count = 0;
		dao.saveInfo(inf);
		count++;
		return count;
	}

	@Transactional
	@Override
	public InfoBean getInfo(Integer activityId) {
		InfoBean info = null;
		info = dao.getInfo(activityId);
		return info;
	}

	@Transactional
	@Override
	public List<InfoBean> getAllInfos() {
		return dao.getAllInfos();
	}

	@Transactional
	@Override
	public int deleteInfo(int activity_id) {
		int count = 0;
		dao.deleteInfo(activity_id);
		count++;
		return count;
	}

	@Override
	public void close() {
		dao.close();

	}

}