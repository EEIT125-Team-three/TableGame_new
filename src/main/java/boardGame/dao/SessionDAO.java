package boardGame.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import boardGame.model.MemberBean;
import boardGame.model.SessionBean;

@Repository
public class SessionDAO {
	
	@Autowired
	SessionFactory factory;

	public MemberBean getMember(String sessionId) {
		 SessionBean sessionBean = factory.getCurrentSession().get(SessionBean.class, sessionId);
		 if(sessionBean == null) {
			 return null;
		 }
		return sessionBean.getMemberId();
	}
	
	public void addSession(SessionBean session) {
		factory.getCurrentSession().save(session);
	}
	
	public void delSession(String session) {
		Session se = factory.getCurrentSession();
		se.delete(se.get(SessionBean.class, session));
	}
}
