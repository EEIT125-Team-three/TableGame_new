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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		return factory.getCurrentSession().get(InfoBean.class, activityId);
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
	public List<InfoBean> showCourseByType(String activity, String actType) {
		Session session = factory.getCurrentSession();
		String hql = "From InfoBean where activity like'%" + activity + "%' and actType like'%" + actType + "%'";
		System.out.println(hql);
		List<InfoBean> showClassByType = new ArrayList<>();
		showClassByType = session.createQuery(hql).getResultList();
		return showClassByType;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<InfoBean> showCourseByCamp(String activity, String actType) {
		Session session = factory.getCurrentSession();
		String hql = "From InfoBean where activity like'%" + activity + "%' and actType like'%" + actType + "%'";
		System.out.println(hql);
		List<InfoBean> showClassByCamp = new ArrayList<>();
		showClassByCamp = session.createQuery(hql).getResultList();
		return showClassByCamp;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<InfoBean> showTPICamp(String actArea, String actType) {
		Session session = factory.getCurrentSession();
		String hql = "From InfoBean where actArea like'%" + actArea + "%' and actType like'%" + actType + "%'";
		List<InfoBean> showTPICamp = new ArrayList<>();
		showTPICamp = session.createQuery(hql).getResultList();
		return showTPICamp;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<InfoBean> showTCHCamp(String actArea, String actType) {
		Session session = factory.getCurrentSession();
		String hql = "From InfoBean where actArea like'%" + actArea + "%' and actType like'%" + actType + "%'";
		List<InfoBean> showTCHCamp = new ArrayList<>();
		showTCHCamp = session.createQuery(hql).getResultList();
		return showTCHCamp;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<InfoBean> showKOHCamp(String actArea, String actType) {
		Session session = factory.getCurrentSession();
		String hql = "From InfoBean where actArea like'%" + actArea + "%' and actType like'%" + actType + "%'";
		List<InfoBean> showKOHCamp = new ArrayList<>();
		showKOHCamp = session.createQuery(hql).getResultList();
		return showKOHCamp;
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
		MImerge sign = new MImerge(memId, activityId, "尚未繳費");
		System.out.println(sign);
		Session session = factory.getCurrentSession();
		session.save(sign);
	}

	@Override
	public InfoBean SearchActivity(Integer activityId) {
		InfoBean act = null;
		Session session = factory.getCurrentSession();
		act = session.get(InfoBean.class, activityId);
		return act;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MImerge> getInfoHistory(Integer id) {
		return factory.getCurrentSession().createQuery("From MImerge where memId=" + id + "").list();
	}

	@Override
	public int deleteSignUp(int miId) {
		int count = 0;
		Session session = factory.getCurrentSession();
		MImerge MImerge = new MImerge();
		MImerge.setMiId(miId);
		session.delete(MImerge);
		count++;
		return count;
	}

	@Override
	public Map<String, Object> getActTypeNum() {
		Map<String, Object> ActTypeMap = new HashMap<String, Object>();
		List<String> actTypeName = new ArrayList<String>();
		actTypeName.add("'桌遊聚會'");
		actTypeName.add("'桌遊趴'");
		actTypeName.add("'桌遊研習'");
		actTypeName.add("'桌遊營'");
		List<Integer> actTypeCount = new ArrayList<Integer>();
		actTypeCount.add(factory.getCurrentSession().createQuery("select actType from InfoBean where actType = '桌遊聚會'")
				.getResultList().size());
		actTypeCount.add(factory.getCurrentSession().createQuery("select actType from InfoBean where actType = '桌遊趴'")
				.getResultList().size());
		actTypeCount.add(factory.getCurrentSession().createQuery("select actType from InfoBean where actType = '桌遊研習'")
				.getResultList().size());
		actTypeCount.add(factory.getCurrentSession().createQuery("select actType from InfoBean where actType = '桌遊營'")
				.getResultList().size());
		ActTypeMap.put("actTypeName", actTypeName);
		ActTypeMap.put("actTypeCount", actTypeCount);
		return ActTypeMap;
	}

	@Override
	public void close() {
		factory.close();
	}

	@Override
	public void updateMemberActivity(MImerge mImerge) {

	}

	public MImerge getMImergeByMImergeId(Integer MImergeId) {
		return factory.getCurrentSession().get(MImerge.class, MImergeId);
	}

}
