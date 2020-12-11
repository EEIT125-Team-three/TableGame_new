package service;

import java.util.List;

import model.MemberBean;

public interface MemberService {

	boolean isDup(String id);

	int save(MemberBean mb);

	List<MemberBean> getAllMembers();

	MemberBean getMember(int pk);

	int deleteMember(int ipk);

	int updateMember(MemberBean mb);

	public boolean login(String account, String password);

}