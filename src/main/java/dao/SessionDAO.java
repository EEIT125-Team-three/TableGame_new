package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.MemberBean;
import model.SessionBean;

@Repository
public class SessionDAO {
	
	@Autowired
	SessionFactory factory;

	public MemberBean getMember(String sessionId) {
		return factory.getCurrentSession().get(SessionBean.class, sessionId).getMemberId();
	}
	
	public void addSession(SessionBean session) {
		factory.getCurrentSession().save(session);
	}
	
	public void delSession(String session) {
		Session se = factory.getCurrentSession();
		se.delete(se.get(SessionBean.class, session));
	}
}
