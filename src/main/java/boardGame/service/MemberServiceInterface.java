package boardGame.service;

import java.util.List;
import java.util.Map;

import boardGame.model.MImerge;
import boardGame.model.MPmerge;
import boardGame.model.MemberBean;

public interface MemberServiceInterface {

	//登入
	public MemberBean login(String account, String password);
	
	//新增會員(註冊)
	int insertMember(MemberBean mb);

	//註冊重複帳號驗證
	public boolean insertDup(String account);
	
	//管理員會員清單
	List<MemberBean> getAllMembers();

	//取出會員
	MemberBean getMember(Integer id);

	//管理員及個人會員修改會員資料
	int updateMember(MemberBean mb);

	//管理員刪除會員
	Integer deleteMember(Integer id);
	
	//管理員權限變更
	void changeAu(Integer id);
	
	//圖片顯示
	public String getMemberImages(Integer id);
		
	//管理員用帳號模糊查詢會員
	public List<MemberBean> SearchMemberByAccount(String memAccount);
	
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
	
	//Google註冊重複帳號驗證
	public boolean otherInsertDup(String memEmail);

}