package boardGame.dao;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	//密碼更改驗證
	@SuppressWarnings("unchecked")
	@Override
	public boolean passwordDup(String password) {
		Session session = factory.getCurrentSession();
		Query<MemberBean> query = session.createQuery("From MemberBean where memPassword = :password");
		List<MemberBean> list = query.setParameter("password",password).getResultList();
		if(list.size()>0) {
			return true;
		}	
		return false;
	}
	
	//Google帳號驗證和註冊
	@SuppressWarnings("unchecked")
	@Override
	public MemberBean otherInsertDup(String memEmail) {
		Session session = factory.getCurrentSession();
		Query<MemberBean> query = session.createQuery("From MemberBean where memAccount = :email");
		List<MemberBean> list = query.setParameter("email", memEmail).getResultList();
		if (list.size() > 0) {
			return list.get(0);
		}
			return new MemberBean();
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
	
	//透過信箱設定會員資料
		@SuppressWarnings("unchecked")
		@Override
		public int setPasswordByAccount(String account, String newpassword) {
			int count = 0;
			System.out.println(newpassword);
			System.out.println(account);
			Session session = factory.getCurrentSession();
			Query<MemberBean> query = session.createQuery("From MemberBean where memAccount = :account");
			MemberBean mb = query.setParameter("account", account).getSingleResult();
			mb.setMemPassword(newpassword);
			mb.setCheckId(null);
//			session.saveOrUpdate(mb);
			count++;
			return count;
		}
	
	//個人密碼修改
	@Override
	public int updatePassword(String password) {
		int count = 0;
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(password);
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
	
	//男女人數
	@Override
	public Map<String, Object> getGenderNumber() {
		
		Map<String, Object> genderMap = new HashMap<String, Object>();
		
		List<String> genderName = new ArrayList<String>();
		genderName.add("'男孩'");
		genderName.add("'女孩'");
		
		List<Integer> genderCount = new ArrayList<Integer>();
		
		genderCount.add(factory.getCurrentSession().createQuery("select memGender from MemberBean where memGender ='男孩'").getResultList().size());
		genderCount.add(factory.getCurrentSession().createQuery("select memGender from MemberBean where memGender ='女孩'").getResultList().size());
		
		genderMap.put("genderName", genderName);
		genderMap.put("genderCount", genderCount);
		
		return genderMap;
	}

	//註冊信驗證確認
	@SuppressWarnings("unchecked")
	public MemberBean getMemberByCheckId(String checkId) {
		List<MemberBean> memberBeans = factory.getCurrentSession().createQuery("from MemberBean where checkId='" + checkId + "'").getResultList();
		if(memberBeans.size() > 0) {
			return memberBeans.get(0);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<MemberBean> getMemberByAccount(String account) {
		return factory.getCurrentSession().createQuery("From MemberBean where memAccount='" + account + "'").getResultList();
	}
}
