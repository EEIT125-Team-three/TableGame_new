package boardGame.controller;


import java.io.File;
import java.util.List;
import java.util.UUID;


import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import boardGame.model.MImerge;
import boardGame.model.MPmerge;
import boardGame.model.MemberBean;
import boardGame.service.HomeService;
import boardGame.service.MemberServiceInterface;
import boardGame.service.shopCarservice;

@SessionAttributes({"id", "name"})
@Controller
public class MemberController {

	@Autowired
	ServletContext context;
	
	@Autowired
	private MemberServiceInterface service;
	
	@Autowired
	HomeService hs;

	@Autowired
	shopCarservice scs;
	
	//會員登入
	@PostMapping("/login")
	public String login(Model model,
		@RequestParam("account") String account,
		@RequestParam("password") String password,
		HttpServletResponse response,
		HttpServletRequest request) {
		MemberBean mb=service.login(account, password);
		if(mb.getMemId() != null) {
			if(mb.getMemId() == 0) {
				model.addAttribute("msg","此帳號已被停權，有疑問請聯繫管理員");
				return"Member/loginPage";	
			}
			scs.checkAllCookieBuy(request, response, mb);
			model.addAttribute("id", mb.getMemId());
			hs.addSession(request.getSession(true).getId(), mb);			
			Cookie sessionId = new Cookie("sessionId", request.getSession(true).getId());
			sessionId.setMaxAge(60*60*24*365);
			sessionId.setPath(request.getContextPath());
			response.addCookie(sessionId);
			if(mb.getMemId() == 1) {
			return"Member/index";
			}else {
			return"Member/memberCenter";
			}
			
		}else {
		model.addAttribute("msg","輸入錯誤請重新輸入");
		return"Member/loginPage";	
		}
	}
	
	//重複帳號
	@PostMapping("/insertDup")
	public @ResponseBody boolean insertDup(@RequestParam("account") String account) {
		return service.insertDup(account);		
	}
	
	//權限變更
	@PostMapping("/changeAu")
	public @ResponseBody void changeAu(@RequestParam("id") Integer id) {
		service.changeAu(id);
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
		mb.setMemCheckAu(true);
		service.insertMember(mb);
		model.addAttribute("name", mb.getMemName());
		model.addAttribute("account", mb.getMemAccount());	    
	    return "Member/InsertMemberSuccess";
	}
	
	//會員清單
	@GetMapping("/showMembers")
	public String list(Model model) {
		if((Integer)model.getAttribute("id") != null && (Integer)model.getAttribute("id") == 1) {
			List<MemberBean> list = service.getAllMembers();
			model.addAttribute("allMembers",list);
			return "Member/showMembers";
		}
		return "redirect:/login";
	}
	
	
	//修改會員資料空白表單
	@GetMapping("/updateMember")
	public String getupdateMember(Model model,@RequestParam(required = false) Integer id) {
		String toNext = "Member/updateMember";
		if(id == null) {
			id = (Integer)model.getAttribute("id");
			 toNext = "Member/updateMemberPersonal";
		}
	    MemberBean mb = service.getMember(id);
	    model.addAttribute("mb", mb); 
	    return toNext;
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
		String name =UUID.randomUUID().toString().replaceAll("-", "");//使用UUID給圖片重新命名，並去掉四個“-”
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
		service.updateMember(mb);
	    return "redirect:/showMembers";
	}
	
	//刪除會員
	@GetMapping("/deleteMember")
	public String deleteMember(Model model,Integer id) { 
		if((Integer)model.getAttribute("id") != null && (Integer)model.getAttribute("id") == 1) {
			service.deleteMember(id);
			return "redirect:/showMembers";
		}
		return "redirect:/login";	   
	}			
	
	//取得會員圖片
	@PostMapping("/memberImages")
	public @ResponseBody String getMemberImages(@RequestParam(value="img", required = false) Integer id) {
		return service.getMemberImages(id);
	}
	
	
	//會員資料維護頁面
	@GetMapping("/index")
	public String toIndex(Model model,Integer id) { 
		return "redirect:/login";
	}
	
	//管理員查詢會員頁面
	@GetMapping("/search")
	public String toSearch() { 
			return "Member/search";
		}
	
	
	//產品歷史清單
	@GetMapping("/viewHistory")
	public String viewHistory(Model model) {
		List<MPmerge> list = service.getAllViewHistory((Integer)model.getAttribute("id"));
		model.addAttribute("viewHistory", list);
		return "Member/productHistory";
	}
	
	//活動歷史清單
		@GetMapping("/infoHistory")
		public String infoHistory(Model model) {
			List<MImerge> list = service.getInfoHistory((Integer)model.getAttribute("id"));
			model.addAttribute("infoHistory", list);
			return "Member/infoHistory";
		}
		
	//會員帳號查詢
	@GetMapping("/searchByMemberAccount")
	public String searchByMemberAccount(Model model, @RequestParam("account") String memAccount) {
		List<MemberBean> list = service.SearchMemberByAccount(memAccount);
		model.addAttribute("memberSearchResult",list);
		return"Member/memberSearchResult";		
	}
	
}
