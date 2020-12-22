package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.dis;
@Repository
public class disDAOImpl implements disDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insert(dis dis) {
		Session session = sessionFactory.getCurrentSession();
		session.save(dis);

	}

	@Override
	public void update(String id, String comment) {
		Session session = sessionFactory.getCurrentSession();
		session.update(id, comment);

	}

	@Override
	public void delete(String id, String comment) {
		Session session = sessionFactory.getCurrentSession();
		dis dis2 = session.byId(dis.class).load(id);
		session.delete(dis2);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<dis> ShowAllComments() {
		//Session session = sessionFactory.getCurrentSession();
		return sessionFactory.getCurrentSession().createQuery("from dis").list();
	}




}
