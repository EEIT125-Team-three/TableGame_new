package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.config.TxNamespaceHandler;

import dao.MemberDaoInterface;
import model.MemberBean;

@Repository
//實作介面或繼承父類別,程式使用時直接寫父類別/介面名稱
public class MemberDao implements MemberDaoInterface {

	@Autowired
	SessionFactory factory;

	@SuppressWarnings("unchecked")
	@Override
	public boolean isDup(String id) {
		boolean result = false;
		String hql = "FROM MemberBean m WHERE m.id = :id0";
		Session session = factory.getCurrentSession();
		Query<MemberBean> query = session.createQuery(hql);
		List<MemberBean> list = query.setParameter("id0", id).getResultList();
		if (list.size() > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public int save(MemberBean mb) {
		int count = 0;
		Session session = factory.getCurrentSession();
		session.save(mb);
		count++;
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MemberBean> getAllMembers() {
		List<MemberBean> list = new ArrayList<>();
		String hql = "FROM MemberBean";
		Session session = factory.getCurrentSession();
		Query<MemberBean> query = session.createQuery(hql);
		list = query.getResultList();

		return list;
	}

	@Override
	public MemberBean getMember(int id) {
		MemberBean mb = null;
		Session session = factory.getCurrentSession();
		mb = session.get(MemberBean.class, id);
		return mb;
	}

	@Override
	public int deleteMember(int id) {
		int count = 0;
		Session session = factory.getCurrentSession();
		MemberBean mb = new MemberBean();
		mb.setMemId(id);
		session.delete(mb);
		count++;
		return count;
	}

	@Override
	public int updateMember(MemberBean mb) {
		int count = 0;
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(mb);
		count++;
		return count;
	}

	public boolean login(String account, String password) {
		Session session = factory.getCurrentSession();
		  if (session != null) {
			  Transaction tx = session.beginTransaction();
		   try {
			Query query = session.createQuery("From MemberBean where memAccount = ?1");
			query.setParameter(1, account);
			List<MemberBean> uBeans = query.list();
			MemberBean user =  uBeans.get(0);
//			MemberBean user = (MemberBean) session.createQuery("From MemberBean where memAccount = ?");
		    if (password.equals(user.getMemPassword())) {

		     tx.commit();
		     return true;
		    }
		   } catch (Exception exception) {
		    System.out.println("Exception occred while reading user data: "
		      + exception.getMessage());
		    tx.rollback();
		    return false;
		   }

		  } else {
		   System.out.println("DB server down.....");
		  }
		return false;
	}
}
