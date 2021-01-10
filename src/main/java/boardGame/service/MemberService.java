package boardGame.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boardGame.dao.MemberDAOInterface;
import boardGame.model.MImerge;
import boardGame.model.MPmerge;
import boardGame.model.MemberBean;

@Service
public class MemberService implements MemberServiceInterface {

	
	@Autowired
	SessionFactory factory;
	
	@Autowired
	MemberDAOInterface dao;
	
	//登入
	@Transactional
	@Override
	public MemberBean login(String account, String password) {
		return dao.login(account, password);
	}
	
	//新增會員(註冊)
	@Transactional
	@Override
	public int insertMember(MemberBean mb) {
		int count = 0;		
			dao.insertMember(mb);
			count++;
		return count;
	}
	
	//註冊重複帳號驗證
	@Transactional
	public boolean insertDup(String account) {
		return dao.insertDup(account);
	}
	
	//管理員會員清單
	@Transactional
	@Override
	public List<MemberBean> getAllMembers() {
		return dao.getAllMembers();
	}
	
	//取出會員
	@Transactional
	@Override
	public MemberBean getMember(Integer id) {
		MemberBean mb = null;		
			mb = dao.getMember(id);
		return mb;
	}
	
    //管理員及個人會員修改會員資料
	@Transactional
	@Override
	public int updateMember(MemberBean mb) {
		int count = 0;		
			dao.updateMember(mb);
			count++;			
		return count;
	}
	
	//管理員刪除會員
	@Transactional
	@Override
	public Integer deleteMember(Integer id) {
		int count = 0;
			dao.deleteMember(id);
			count++;		
		return count;
	}	
	
	//管理員權限變更
	@Transactional
	@Override
	public void changeAu(Integer id) {
		dao.changeAu(id);
	}
	
	//圖片顯示
	@Transactional
	public String getMemberImages(Integer id) {
		;
		String imgFile = "C:/memberImages/" + dao.getMember(id).getMemPic() + ".jpg";//待處理的圖片  
        InputStream in = null;  
        byte[] data = null;  
        //讀取圖片位元組陣列  
        try   
        {  
            in = new FileInputStream(imgFile);          
            data = new byte[in.available()];  
            in.read(data);
            in.close();  
        }   
        catch (IOException e)   
        {  
            e.printStackTrace();  
        }  
        //對位元組陣列Base64編碼  
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedText = encoder.encodeToString(data);
        return "data:image/jpg;base64," + encodedText;
	}

	//管理員用帳號模糊查詢會員
	@Transactional
	@Override
	public List<MemberBean> SearchMemberByAccount(String memAccount) {
		return dao.searchMemberByAccount(memAccount);
	}
	
	//管理員用姓名模糊查詢會員
	@Transactional
	@Override
	public List<MemberBean> searchMemberByName(String memName) {
		return dao.searchMemberByName(memName);
	}
	
	//管理員用地區模糊查詢會員
	@Transactional
	@Override
	public List<MemberBean> searchMemberByAddress(String memAddress) {
		return dao.searchMemberByAddress(memAddress);
	}
	
	//管理員查詢停權會員
	@Transactional
	@Override
	public List<MemberBean> searchMemberByAu(Boolean memCheckAu) {
		return dao.searchMemberByAu(memCheckAu);
	}
	
	//個人會員產品歷史查詢
	@Transactional
	@Override
	public List<MPmerge> getAllViewHistory(Integer memberId) {
		return dao.getAllViewHistory(memberId);
	}
	
	//個人會員活動歷史查詢
	@Transactional
	@Override
	public List<MImerge> getInfoHistory(Integer id) {
		return dao.getInfoHistory(id);
	}

	//男女人數
	@Transactional
	@Override
	public Map<String, Object> getGenderNumber(){
		return dao.getGenderNumber();
	}

	//Google註冊重複帳號驗證
	@Transactional
	@Override
	public boolean otherInsertDup(String memEmail) {
		
		return dao.otherInsertDup(memEmail);
	}

	
}
