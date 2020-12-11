package service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MemberDao;
import dao.MemberHibernateDaoImpl;

import model.MemberBean;
import service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	
	@Autowired
	SessionFactory factory;
	
	@Autowired
	MemberDao dao;

//	MemberDao dao = new MemberHibernateDaoImpl();
	
	@Override
	public boolean isDup(String id) {
		boolean result = false;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			result = dao.isDup(id);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return result;	
	}

	@Override
	public int save(MemberBean mb) {
		int count = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.save(mb);
			count++;
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<MemberBean> getAllMembers() {
		
		List<MemberBean> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			list = dao.getAllMembers();
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}	
		return list;
	}

	@Override
	public MemberBean getMember(int id) {
		MemberBean mb = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			mb = dao.getMember(id);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return mb;
	}

	@Override
	public int deleteMember(int id) {
		int count = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.deleteMember(id);
			count++;
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}		
		return count;
	}

	@Override
	public int updateMember(MemberBean mb) {
		int count = 0;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.updateMember(mb);
			count++;
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}	
		return count;
	}

	@Override
	public boolean login(String account, String password) {
		return dao.login(account, password);
	}
}
