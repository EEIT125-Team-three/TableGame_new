package service;

import java.util.List;

import model.MemberBean;

public interface MemberServiceInterface {

	int insertMember(MemberBean mb);

	List<MemberBean> getAllMembers();

	MemberBean getMember(Integer id);

	int updateMember(MemberBean mb);

	public MemberBean login(String account, String password);

	Integer deleteMember(Integer id);
	
	public String getMemberImages(Integer id);
}