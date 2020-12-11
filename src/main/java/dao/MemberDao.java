package dao;

import java.util.List;

import model.MemberBean;

public interface MemberDao {

	boolean isDup(String id);

	int save(MemberBean mb);

	List<MemberBean> getAllMembers();

	MemberBean getMember(int id);

	int deleteMember(int id);

	int updateMember(MemberBean mb);

	public boolean login(String account, String password);

}