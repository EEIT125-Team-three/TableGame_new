package boardGame.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import boardGame.model.InfoBean;
import boardGame.model.MImerge;
import boardGame.model.MemberBean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.From;

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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public MImerge getSignUp(MemberBean memId, InfoBean activityId) {
		String hql = "FROM MImerge where activityId= ?1 and memId = ?2 ";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(1, activityId).setParameter(2, memId);
		List<MImerge> list = query.getResultList();
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void AddMemberActivity(MemberBean memId, InfoBean activityId) {
		MImerge sign = new MImerge(memId, activityId);
		System.out.println(sign);
		Session session =factory.getCurrentSession();
		session.save(sign);
	}

	@Override
	public void updateMemberActivity(MImerge mImerge) {
		// TODO Auto-generated method stub

	}

	@Override
	public InfoBean SearchActivity(Integer activityId) {
		InfoBean act = null;
		Session session = factory.getCurrentSession();
		act = session.get(InfoBean.class, activityId);
		return act;
	}

	@Override
	public void close() {
		factory.close();
	}

}
