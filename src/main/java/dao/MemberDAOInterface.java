package dao;

import java.util.List;

import model.MemberBean;

public interface MemberDAOInterface {

	boolean isDup(String id);

	//新增會員(註冊)
	int insertMember(MemberBean mb);
	//會員清單
	List<MemberBean> getAllMembers();

	MemberBean getMember(int id);

	//刪除會員
	int deleteMember(int id);
	//修改會員資料
	int updateMember(MemberBean mb);

	public boolean login(String account, String password);

}