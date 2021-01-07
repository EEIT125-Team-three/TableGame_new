package boardGame.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import boardGame.model.MImerge;
import boardGame.model.MPmerge;
import boardGame.model.MemberBean;

@Repository
public class MemberDAO implements MemberDAOInterface {

	@Autowired
	SessionFactory factory;

	// 登入
	@SuppressWarnings("unchecked")
	@Override
	public MemberBean login(String account, String password) {
		MemberBean memberBean = new MemberBean();
		Session session = factory.getCurrentSession();
		Query<MemberBean> query = session
				.createQuery("From MemberBean where memAccount = :account and memPassword =:pwd");
		List<MemberBean> list = query.setParameter("account", account).setParameter("pwd", password).getResultList();
		if (list.size() > 0) {
			if (list.get(0).isMemCheckAu()) {
				return list.get(0);
			} 
				memberBean.setMemId(0);
		}
		return memberBean;
	}

	// 新增會員(註冊)
	@Override
	public int insertMember(MemberBean mb) {
		int count = 0;
		Session session = factory.getCurrentSession();
		session.save(mb);
		count++;
		return count;
	}
	
	// 註冊重複帳號驗證
	@SuppressWarnings("unchecked")
	@Override
	public boolean insertDup(String account) {
		Session session = factory.getCurrentSession();
		Query<MemberBean> query = session.createQuery("From MemberBean where memAccount = :account");
		List<MemberBean> list = query.setParameter("account", account).getResultList();
		if (list.size() > 0) {
			return true;
		}
		return false;
	}
	
	//管理員會員清單
	@SuppressWarnings("unchecked")
	@Override
	public List<MemberBean> getAllMembers() {
		String hql = "FROM MemberBean";
		Session session = factory.getCurrentSession();
		Query<MemberBean> query = session.createQuery(hql);
		List<MemberBean> list = query.getResultList();
		return list;
	}

	// 取出會員
	@Override
	public MemberBean getMember(Integer id) {
		return factory.getCurrentSession().get(MemberBean.class, id);
	}

	//管理員及個人會員修改會員資料
	@Override
	public int updateMember(MemberBean mb) {
		int count = 0;
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(mb);
		count++;
		return count;
	}

	//管理員刪除會員
	@Override
	public int deleteMember(Integer id) {
		int count = 0;
		Session session = factory.getCurrentSession();
		MemberBean mb = session.get(MemberBean.class, id);
		session.delete(mb);
		count++;
		return count;
	}

	//管理員權限變更
	@Override
	public void changeAu(Integer id) {
		MemberBean memberBean = factory.getCurrentSession().get(MemberBean.class, id);
		memberBean.setMemCheckAu(!memberBean.isMemCheckAu());
	}
	
	//管理員用帳號模糊查詢會員
	@SuppressWarnings("unchecked")
	@Override
	public List<MemberBean> searchMemberByAccount(String memAccount) {
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean where memAccount like'%" + memAccount + "%'";
		return session.createQuery(hql).getResultList();
	}
	
	//管理員用姓名模糊查詢會員
	@SuppressWarnings("unchecked")
	@Override
	public List<MemberBean> searchMemberByName(String memName) {
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean where memName like'%" + memName + "%'";
		return session.createQuery(hql).getResultList();
	}
	
	//管理員用地區模糊查詢會員
	@SuppressWarnings("unchecked")
	@Override
	public List<MemberBean> searchMemberByAddress(String memAddress) {
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean where memAddress like'%" + memAddress + "%'";
		return session.createQuery(hql).getResultList();
	}
	
	//管理員查詢停權會員
	@SuppressWarnings("unchecked")
	@Override
	public List<MemberBean> searchMemberByAu(Boolean memCheckAu) {
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean where memCheckAu = 0";
		return session.createQuery(hql).getResultList();
	}
	
	//個人會員產品歷史查詢
	@SuppressWarnings("unchecked")
	@Override
	public List<MPmerge> getAllViewHistory(Integer memberId) {
		return factory.getCurrentSession()
				.createQuery("From MPmerge where memId=" + memberId + " order by viewCount desc").list();
	}

	//個人會員活動歷史查詢
	@SuppressWarnings("unchecked")
	@Override
	public List<MImerge> getInfoHistory(Integer id) {
		return factory.getCurrentSession().createQuery("From MImerge where memId=" + id + "").list();
	}

	@Override
	public List<Integer> getGenderNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
