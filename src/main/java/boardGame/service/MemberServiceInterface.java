package boardGame.service;

import java.util.List;

import boardGame.model.MImerge;
import boardGame.model.MPmerge;
import boardGame.model.MemberBean;

public interface MemberServiceInterface {

	int insertMember(MemberBean mb);

	List<MemberBean> getAllMembers();

	MemberBean getMember(Integer id);

	int updateMember(MemberBean mb);

	public MemberBean login(String account, String password);

	Integer deleteMember(Integer id);
	
	public String getMemberImages(Integer id);

	void changeAu(Integer id);
	
	public boolean insertDup(String account);
	
	List<MPmerge> getAllViewHistory(Integer memberId);

	List<MImerge> getInfoHistory(Integer id);
}