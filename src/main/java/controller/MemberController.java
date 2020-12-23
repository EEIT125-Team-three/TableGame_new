package controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import model.MemberBean;
import service.HomeService;
import service.MemberServiceInterface;

@SessionAttributes({"id", "name"})
@Controller
public class MemberController {

	@Autowired
	ServletContext context;
	
	@Autowired
	private MemberServiceInterface service;
	
	@Autowired
	HomeService hs;
	
//	@ModelAttribute("id")
//	public Integer id(HttpServletRequest request, HttpServletResponse response, Model model) {
//		return hs.cheakSessionId(response, request, (Integer)model.getAttribute("id"));
//	}

//	private Map<String, MemberBean> SessionId = new HashMap<String, MemberBean>();
	
	//會員登入
	@PostMapping("/login")
	public String login(Model model,
		@RequestParam("account") String account,
		@RequestParam("password") String password,
		HttpServletResponse response,
		HttpServletRequest request) {
		MemberBean mb=service.login(account, password);
		if(mb.getMemId() != null) {
			model.addAttribute("id", mb.getMemId());
			hs.addSession(request.getSession(true).getId(), mb);			
			Cookie sessionId = new Cookie("sessionId", request.getSession(true).getId());
			sessionId.setMaxAge(60*60*24*365);
			sessionId.setPath(request.getContextPath());
			response.addCookie(sessionId);
			if(mb.getMemId() == 9) {
			return"Member/index";
			}else {
			return"homepage";
			}
			
		}else {
		model.addAttribute("msg","輸入錯誤請重新輸入");
		return"Member/loginPage";	
		}
	}
	
	//FB登入
	@RequestMapping(value = "/userInfo")
	@ResponseBody
	public String getUserInfo(String userInfo) {
		System.out.println(userInfo);
		return userInfo;
	}
	
	
	//新增會員空白表單
	@GetMapping("/InsertMember")
	public String getinsertMember(Model model) {
	    MemberBean mb = new MemberBean();
	    model.addAttribute("MemberBean", mb); 
	    return "Member/InsertMember";
	}
	
	
	//新增會員(註冊)+大頭貼上傳
	@PostMapping("/InsertMember")
	public String processinsertMember(
			Model model,
			@ModelAttribute("MemberBean") MemberBean mb,
			@RequestParam(value="file",required=false) CommonsMultipartFile file,
			HttpServletRequest request,
			RedirectAttributes attr)throws Exception { 
	    
		String name =UUID.randomUUID().toString().replaceAll("-", "");//使用UUID給圖片重新命名，並去掉四個“-”
//		String name =mb.getMemAccount();
//		String imageName=file.getOriginalFilename();//獲取圖片名稱
		//String contentType=file.getContentType(); //獲得檔案型別（可以判斷如果不是圖片，禁止上傳）
		//String suffixName=contentType.substring(contentType.indexOf("/")+1); 獲得檔案字尾名
		String ext = FilenameUtils.getExtension(file.getOriginalFilename());//獲取檔案的副檔名
//		String filePath =  (this.getClass().getClassLoader().getResource("/../../").getPath() + "memberImages").substring(1);//設定圖片上傳路徑
//		String filePath =  "C:\\Users\\Student\\Desktop\\新增資料夾\\TableGame_new\\src\\main\\webapp\\resources\\memberImages";//設定圖片上傳路徑
		String filePath = "C:/memberImages";//設定圖片上傳路徑
		File imagePath = new File(filePath);
		File fileImage = new File(filePath+"/"+name + ".jpg");
		if  (!imagePath .exists()  && !imagePath .isDirectory())      
		{ 
			
			imagePath .mkdir();    
		} 
		file.transferTo(fileImage);//把圖片儲存路徑儲存到資料庫
		//重定向到查詢所有使用者的Controller，測試圖片回顯
		mb.setMemPic(name);
		mb.setMemRefund(0);
		service.insertMember(mb);
		model.addAttribute("name", mb.getMemName());
		model.addAttribute("account", mb.getMemAccount());	    
	    return "Member/InsertMemberSuccess";
	}
	
	//會員清單
	@RequestMapping("/showMembers")
	public String list(Model model) {
		List<MemberBean> list = service.getAllMembers();
		model.addAttribute("allMembers",list);
	return "Member/showMembers";
	}
	
	//修改會員資料空白表單
	@GetMapping("/updateMember")
	public String getupdateMember(Model model,Integer id) {
	    MemberBean mb = service.getMember(id);
	    model.addAttribute("mb", mb); 
	    return "Member/updateMember";
	}
	
	//修改會員資料
	@PostMapping("/updateMember")
	public String processupdateMember(
			Model model,
			@ModelAttribute MemberBean mb,
			@RequestParam Integer memId,  
			@RequestParam(value="file",required=false) CommonsMultipartFile file,
			HttpServletRequest request,
			RedirectAttributes attr)throws Exception{	
		String name =UUID.randomUUID().toString().replaceAll("-", "");
		String ext = FilenameUtils.getExtension(file.getOriginalFilename());//獲取檔案的副檔名
		String filePath =  "C:\\Users\\Student\\Desktop\\新增資料夾\\TableGame_new\\src\\main\\webapp\\resources\\memberImages";//設定圖片上傳路徑
		File imagePath = new File(filePath);
		File fileImage = new File(filePath+"/"+name + "." + ext);
		if  (!imagePath .exists()  && !imagePath .isDirectory())      
		{ 
			imagePath .mkdir();    
		} 
		file.transferTo(fileImage);//把圖片儲存路徑儲存到資料庫
		//重定向到查詢所有使用者的Controller，測試圖片回顯
		mb.setMemPic("memberImages/"+name + "." + ext);
		service.updateMember(mb);
	    return "redirect:/showMembers";
	}
	
	//刪除會員
	@GetMapping("/deleteMember")
	public String deleteMember(Integer id) { 
	    service.deleteMember(id);
	    return "redirect:/showMembers";
	}			
	
	//取得會員圖片
	@PostMapping("/memberImages")
	public @ResponseBody String getMemberImages(@RequestParam(value="img", required = false) Integer id) {
        return service.getMemberImages(id);
	}
	
}
