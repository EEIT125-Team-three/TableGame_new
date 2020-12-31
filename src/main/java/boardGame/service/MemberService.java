package boardGame.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

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
	
	@Transactional
	@Override
	public int insertMember(MemberBean mb) {
		int count = 0;		
			dao.insertMember(mb);
			count++;
		return count;
	}
	
	@Transactional
	@Override
	public List<MemberBean> getAllMembers() {
		return dao.getAllMembers();
	}

	@Transactional
	@Override
	public MemberBean getMember(Integer id) {
		MemberBean mb = null;		
			mb = dao.getMember(id);
		return mb;
	}

	@Transactional
	@Override
	public Integer deleteMember(Integer id) {
		int count = 0;
			dao.deleteMember(id);
			count++;		
		return count;
	}
	
	@Transactional
	@Override
	public int updateMember(MemberBean mb) {
		int count = 0;		
			dao.updateMember(mb);
			count++;			
		return count;
	}
	
	@Transactional
	@Override
	public MemberBean login(String account, String password) {
		return dao.login(account, password);
	}
	
	@Transactional
	public boolean insertDup(String account) {
		return dao.insertDup(account);
	}
	
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
	
	@Transactional
	@Override
	public void changeAu(Integer id) {
		dao.changeAu(id);
	}

	@Transactional
	@Override
	public List<MPmerge> getAllViewHistory(Integer memberId) {
		return dao.getAllViewHistory(memberId);
	}
	@Transactional
	@Override
	public List<MImerge> getInfoHistory(Integer id) {
		return dao.getInfoHistory(id);
	}

	//會員帳號查詢
	@Transactional
	@Override
	public List<MemberBean> SearchMemberByAccount(String memAccount) {
		return dao.searchMemberByAccount(memAccount);
	}
	
	
}
