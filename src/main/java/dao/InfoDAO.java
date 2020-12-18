package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import model.InfoBean;


public class InfoDAO implements InfoDAOInterface {
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
		InfoBean info= null;
		Session session = factory.getCurrentSession();
		info=session.get(InfoBean.class,activityId);
		return info;
	}

	@Override
	public void close() {
		factory.close();

	}
}
