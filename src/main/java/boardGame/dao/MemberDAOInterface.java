package boardGame.dao;

import java.util.List;
import java.util.Map;

import boardGame.model.District;
import boardGame.model.MImerge;
import boardGame.model.MPmerge;
import boardGame.model.MemberBean;

public interface MemberDAOInterface {

	//登入
	public MemberBean login(String account);
	
	//新增會員(註冊)
	int insertMember(MemberBean mb);
	
	//註冊重複帳號驗證
	public boolean insertDup(String account);
	
	//密碼更改驗證
	public boolean passwordDup(String password);
	
	//Google帳號驗證和註冊
	public MemberBean otherInsertDup(String memEmail);	
	
	//管理員會員清單
	List<MemberBean> getAllMembers();
	
	//取出會員
	MemberBean getMember(Integer id);

	//管理員及個人會員修改會員資料
	int updateMember(MemberBean mb);
	
	//個人密碼修改
	public int updatePassword(String password);
	
	//透過信箱修改會員密碼
	public int setPasswordByAccount(String account, String newPassword);	

	//管理員刪除會員
	int deleteMember(Integer id);

	//管理員權限變更
	void changeAu(Integer id);
	
	//管理員用帳號模糊查詢會員
	public List<MemberBean> searchMemberByAccount(String memAccount);
	
	//管理員用姓名模糊查詢會員
	public List<MemberBean> searchMemberByName(String memName);
	
	//管理員用地區模糊查詢會員
	public List<MemberBean> searchMemberByAddress(String memAddress);
	
	//管理員查詢停權會員
	public List<MemberBean> searchMemberByAu(Boolean memCheckAu);
	
	//個人會員產品歷史查詢
	List<MPmerge> getAllViewHistory(Integer memberId);	

	//個人會員活動歷史查詢
	List<MImerge> getInfoHistory(Integer id);
	
	//男女人數
	public Map<String, Object> getGenderNumber();

	public MemberBean getMemberByCheckId(String checkId);

	public List<MemberBean> getMemberByAccount(String account);

	Map<String, Object> getMonthNumber();

}