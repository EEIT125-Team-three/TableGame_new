package boardGame.dao;

import java.util.List;

import boardGame.model.MImerge;
import boardGame.model.MPmerge;
import boardGame.model.MemberBean;

public interface MemberDAOInterface {

	//會員登入
	public MemberBean login(String account, String password);
	
	//新增會員(註冊)
	int insertMember(MemberBean mb);
	
	//會員清單
	List<MemberBean> getAllMembers();
	
	//取出會員
	MemberBean getMember(Integer id);

	//修改會員資料
	int updateMember(MemberBean mb);

	//刪除會員
	int deleteMember(Integer id);

	//改變權限
	void changeAu(Integer id);
	
	//重複帳號
	public boolean insertDup(String account);
	
	//產品歷史查詢
	List<MPmerge> getAllViewHistory(Integer memberId);	

	//活動歷史查詢
	List<MImerge> getInfoHistory(Integer id);
}