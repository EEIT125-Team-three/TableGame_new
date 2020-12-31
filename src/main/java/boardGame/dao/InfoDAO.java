package boardGame.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import boardGame.model.InfoBean;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InfoDAO implements InfoDAOInterface {
	@Autowired
	SessionFactory factory;

	@SuppressWarnings("unchecked")
	@Override
	public boolean idExists(String activityId) {
		boolean exist = false;
		String hql = "FROM InfoTable WHERE activityId = :uid";
		Session session = factory.getCurrentSession();
		Query<InfoBean> query = session.createNamedQuery(hql);
		List<InfoBean> list = (List<InfoBean>) query.setParameter("uid", activityId).getSingleResult();
		if (list.size() > 0) {
			exist = true;
		}
		return exist;
	}

	@Override
	public int updateInfo(InfoBean inf) {
		int count = 0;
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(inf);
		count++;
		return count;
	}

	@Override
	public int saveInfo(InfoBean inf) {
		int count = 0;
		Session session = factory.getCurrentSession();
		session.save(inf);
		count++;
		return count;
	}

	@Override
	public int deleteInfo(int activityId) {
		int count = 0;
		Session session = factory.getCurrentSession();
		InfoBean info = new InfoBean();
		info.setActivityId(activityId);
		session.delete(info);
		count++;
		return count;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<InfoBean> getAllInfos() {
		String hql = "FROM InfoBean";
		List<InfoBean> allInfos = new ArrayList<>();
		Session session = factory.getCurrentSession();
		allInfos = session.createQuery(hql).getResultList();
		return allInfos;
	}

	@Override
	public InfoBean getInfo(Integer activityId) {
		InfoBean info = null;
		Session session = factory.getCurrentSession();
		info = session.get(InfoBean.class, activityId);
		return info;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<InfoBean> showActivityByArea(String actArea, String activity) {
		Session session = factory.getCurrentSession();
		String hql = "From InfoBean where actArea like'%" + actArea + "%' and activity like'%" + activity + "%'";
		System.out.println(hql);
		List<InfoBean> showActByArea = new ArrayList<>();
		showActByArea = session.createQuery(hql).getResultList();
		System.out.println(showActByArea);
		return showActByArea;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<InfoBean> showAllActivity(String activity) {
		Session session = factory.getCurrentSession();
		String hql = "From InfoBean where activity like'%" + activity + "%'";
		List<InfoBean> showAllAct = new ArrayList<>();
		showAllAct = session.createQuery(hql).getResultList();
		System.out.println(showAllAct);
		return showAllAct;

	}

	@Override
	public void close() {
		factory.close();
	}
}
