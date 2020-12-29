package boardGame.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import boardGame.model.MPmerge;
import boardGame.model.MemberBean;

@Repository
public class MemberDAO implements MemberDAOInterface {

	@Autowired
	SessionFactory factory;

	//會員登入
	@SuppressWarnings("unchecked")
	@Override
	public MemberBean login(String account, String password) {
		MemberBean memberBean = new MemberBean();
		Session session = factory.getCurrentSession();
		Query<MemberBean> query = session
				.createQuery("From MemberBean where memAccount = :account and memPassword =:pwd");
		List<MemberBean> list = query.setParameter("account", account).setParameter("pwd", password).getResultList();
		if (list.size() > 0) {
			if(list.get(0).isMemCheckAu()) {
				return list.get(0);			
			}
			else {
				memberBean.setMemId(0);
			}
		}
		return memberBean;
	}
	
	//註冊帳號重複確認
		@SuppressWarnings("unchecked")
		@Override
		public boolean insertDup(String account) {
			Session session = factory.getCurrentSession();
			Query<MemberBean> query = session
					.createQuery("From MemberBean where memAccount = :account");
			List<MemberBean> list = query.setParameter("account", account).getResultList();
			if (list.size() > 0) {
			return 	true;
			}
			return false;
		}
	
	//新增會員(註冊)
	@Override
	public int insertMember(MemberBean mb) {
		int count = 0;
		Session session = factory.getCurrentSession();
		session.save(mb);
		count++;
		return count;
	}
	
	//取出會員
	@Override
	public MemberBean getMember(Integer id) {
		return factory.getCurrentSession().get(MemberBean.class, id);
	}
	
	//會員清單
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
	
	//修改會員資料
	@Override
	public int updateMember(MemberBean mb) {
		int count = 0;
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(mb);
		count++;
		return count;
	}
	
	//刪除會員
	@Override
	public int deleteMember(Integer id) {
		int count = 0;
		Session session = factory.getCurrentSession();
		MemberBean mb = session.get(MemberBean.class, id);
		session.delete(mb);
		count++;
		return count;
	}
	
	//權限變更
	@Override
	public void changeAu(Integer id) {
		MemberBean memberBean = factory.getCurrentSession().get(MemberBean.class, id);
		memberBean.setMemCheckAu(!memberBean.isMemCheckAu());
	}

	//產品歷史清單
	@SuppressWarnings("unchecked")
	@Override
	public List<MPmerge> getAllViewHistory(Integer memberId) {
		return factory.getCurrentSession().createQuery("From MPmerge where memId=" + memberId + " order by viewCount desc").list();
	}
	
}
