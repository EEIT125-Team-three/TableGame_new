package boardGame.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.net.ssl.HttpsURLConnection;
import javax.transaction.Transactional;

import org.apache.commons.collections.map.HashedMap;
import org.hibernate.SessionFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import boardGame.dao.MemberDAOInterface;
import boardGame.model.District;
import boardGame.model.MImerge;
import boardGame.model.MPmerge;
import boardGame.model.MemberBean;
import boardGame.model.Region;
import boardGame.model.Road;
import net.bytebuddy.asm.Advice.Return;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

@Service
public class MemberService implements MemberServiceInterface {

	@Autowired
	SessionFactory factory;

	@Autowired
	MemberDAOInterface dao;

	@Autowired
	HomeService homeService;
	// 登入
	@Transactional
	@Override
	public MemberBean login(String account) {
		return dao.login(account);
	}

	// 新增會員(註冊)
	@Transactional
	@Override
	public int insertMember(MemberBean mb) {
		int count = 0;
		dao.insertMember(mb);
		count++;
		return count;
	}

	// 註冊重複帳號驗證
	@Transactional
	public boolean insertDup(String account) {
		return dao.insertDup(account);
	}

	// 密碼更改驗證
	@Transactional
	@Override
	public boolean passwordDup(String password) {
		return dao.passwordDup(password);
	}

	// Google帳號驗證和註冊
	@Transactional
	@Override
	public MemberBean otherInsertDup(String memEmail) {

		return dao.otherInsertDup(memEmail);
	}

	// 管理員會員清單
	@Transactional
	@Override
	public List<MemberBean> getAllMembers() {
		return dao.getAllMembers();
	}

	// 取出會員
	@Transactional
	@Override
	public MemberBean getMember(Integer id) {
		MemberBean mb = null;
		mb = dao.getMember(id);
		return mb;
	}

	// 管理員及個人會員修改會員資料
	@Transactional
	@Override
	public int updateMember(MemberBean mb) {
		int count = 0;
		dao.updateMember(mb);
		count++;
		return count;
	}

	// 透過信箱修改會員密碼
	@Transactional
	@Override
	public int setPasswordByAccount(String account, String newPassword) {
		int count = 0;
		dao.setPasswordByAccount(account, newPassword);
		count++;
		return count;
	}

	// 個人密碼修改
	@Transactional
	@Override
	public int updatePassword(String password) {
		int count = 0;
		dao.updatePassword(password);
		count++;
		return count;
	}

	// 管理員刪除會員
	@Transactional
	@Override
	public Integer deleteMember(Integer id) {
		int count = 0;
		dao.deleteMember(id);
		count++;
		return count;
	}

	// 管理員權限變更
	@Transactional
	@Override
	public void changeAu(Integer id) {
		dao.changeAu(id);
	}

	// 圖片顯示
	@Transactional
	public String getMemberImages(Integer id) {
		;
		String imgFile = "C:/memberImages/" + dao.getMember(id).getMemPic() + ".jpg";// 待處理的圖片
		InputStream in = null;
		byte[] data = null;
		// 讀取圖片位元組陣列
		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 對位元組陣列Base64編碼
		Base64.Encoder encoder = Base64.getEncoder();
		String encodedText = encoder.encodeToString(data);
		return "data:image/jpg;base64," + encodedText;
	}

	// 管理員用帳號模糊查詢會員
	@Transactional
	@Override
	public List<MemberBean> SearchMemberByAccount(String memAccount) {
		return dao.searchMemberByAccount(memAccount);
	}

	// 管理員用姓名模糊查詢會員
	@Transactional
	@Override
	public List<MemberBean> searchMemberByName(String memName) {
		return dao.searchMemberByName(memName);
	}

	// 管理員用地區模糊查詢會員
	@Transactional
	@Override
	public List<MemberBean> searchMemberByAddress(String memAddress) {
		return dao.searchMemberByAddress(memAddress);
	}

	// 管理員查詢停權會員
	@Transactional
	@Override
	public List<MemberBean> searchMemberByAu(Boolean memCheckAu) {
		return dao.searchMemberByAu(memCheckAu);
	}

	// 個人會員產品歷史查詢
	@Transactional
	@Override
	public List<MPmerge> getAllViewHistory(Integer memberId) {
		return dao.getAllViewHistory(memberId);
	}

	// 個人會員活動歷史查詢
	@Transactional
	@Override
	public List<MImerge> getInfoHistory(Integer id) {
		return dao.getInfoHistory(id);
	}

	// 男女人數
	@Transactional
	@Override
	public Map<String, Object> getGenderNumber() {
		return dao.getGenderNumber();
	}
	
	// 月份人數
		@Transactional
		@Override
		public Map<String, Object> getMonthNumber() {
			return dao.getMonthNumber();
		}

	@Transactional
	@Override
	public MemberBean getMemberByCheckId(String checkId) {
		MemberBean memberBean = dao.getMemberByCheckId(checkId);
		if (memberBean != null) {
			memberBean.setCheckId(null);
			memberBean.setMemCheckAu(true);
		}
		return memberBean;
	}

	@Transactional
	public String getMemberByAccount(String account) {
		String checkId = UUID.randomUUID().toString().replaceAll("-", "");
		List<MemberBean> memberBeans = dao.getMemberByAccount(account);
		if (memberBeans.size() > 0) {
			MemberBean memberBean = memberBeans.get(0);
			if (memberBean.getMemPassword() != null && memberBean.getCheckId() == null) {
				memberBean.setCheckId(checkId);
				JavaMail jm = new JavaMail();
				jm.newPasswordMail(checkId, memberBean.getMemMailaddress());
				return "redirect:/login";
			}
		}
		return "redirect:/forgetPassword?error=forgetPasswordAccountError";
	}
	
	
	@Transactional
	public Map<String, Integer> getMemberAddress(Integer memberId){
		Map<String, Integer> remap = new HashMap<String, Integer>();
		if(memberId != null) {
			Road road = dao.getMember(memberId).getRoad();
			if(road != null) {
				remap.put("city", road.getDistrict().getCity().getCityId());
				remap.put("district", road.getDistrict().getDistrictId());
				remap.put("road", road.getRoadId());
			}
		}
		return remap;
	}

	public Boolean checkBot(String recaptcha_response)
			throws MalformedURLException, IOException, ParseException, org.json.simple.parser.ParseException {
		String RECAPTCHA_SERVICE_URL = "https://www.google.com/recaptcha/api/siteverify";
		URL obj = new URL(RECAPTCHA_SERVICE_URL);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		con.setRequestMethod("POST");
		con.setRequestProperty("Accept-Language", "pt-BR,en;q=0.5");

		String postParams = "secret=6LcwcS0aAAAAAL49GOTUqWfMYyp6sZW5U1CK5kQq&response=" + recaptcha_response;

		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(postParams);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();

		System.out.println("Post parameters: " + postParams);
		System.out.println("Response Code: " + responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;

		StringBuffer responseb = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			responseb.append(inputLine);
		}
		in.close();
		System.out.println(responseb.toString());
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(responseb.toString());
		// System.out.println(responseb.toString());

		Boolean success = (Boolean) json.get("success");
		Double score = (Double) json.get("score");

		if (success && score >= 0.5) {
			return true;
		}
		return false;
	}


	@Override
	public List<String> getAllMemberAddress(List<MemberBean> list) {
		List<String> allMemberAddress = new ArrayList<String>();
		StringBuffer memberAddress = new StringBuffer();
		for(MemberBean memberBean : list) {
			if(memberBean.getRoad() == null) {
				allMemberAddress.add("");
				continue;
			}
			memberAddress.append(homeService.getAddress(memberBean.getRoad()));
			memberAddress.append(memberBean.getMemAddress());
			allMemberAddress.add(memberAddress.toString());
			memberAddress.delete(0, memberAddress.toString().length());
		}
		return allMemberAddress;
	}

	@Transactional
	@Override
	public Map<String,Object> getRegionNumber() {
		Map<String,Object> obj = new HashMap<String, Object>();
		List<MemberBean> allMembers = dao.getAllMembers();
		Integer regionsIntegerSize;
		Integer countInteger;
		String nowRegion;
		List<String> regions = new ArrayList<String>();
		List<Integer> regionNums = new ArrayList<Integer>();
		for(MemberBean memberBean:allMembers) {
			if(memberBean.getRoad() == null) {
				continue;
			}
			nowRegion = memberBean.getRoad().getDistrict().getCity().getRegion().getRegion();
			regionsIntegerSize = regions.size();
			countInteger = 0;
			while(countInteger<regionsIntegerSize) {
				if(regions.get(countInteger).equals(nowRegion)) {
					regionNums.set(countInteger, regionNums.get(countInteger)+1);
					break;
				}
				countInteger += 1;
			}
			if(countInteger == regionsIntegerSize) {
				regions.add(nowRegion);
				regionNums.add(1);
			}
		}
		StringBuffer stringBuffer = new StringBuffer();
		for(int i=0; i<regions.size(); i++) {
			stringBuffer.append("\"");
			stringBuffer.append(regions.get(i));
			stringBuffer.append("\"");
			regions.set(i, stringBuffer.toString());
			stringBuffer.delete(0, stringBuffer.length());
		}
		obj.put("region", regions);
		obj.put("regionNum", regionNums);
		
		return obj;
	}
	
	public String getMemberEncoder(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}

	public Boolean checkMemberEncoder(String loginMemberPassword, String checkMemberPassword ){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(loginMemberPassword,checkMemberPassword);
	}
	
}
