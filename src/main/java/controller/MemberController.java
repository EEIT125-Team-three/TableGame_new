package controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import model.MemberBean;
import service.MemberServiceInterface;

@Controller
public class MemberController {
	
	@Autowired
	private MemberServiceInterface service;

	//會員登入
	@PostMapping("/login")
	public String login(Model model,
		@RequestParam("account") String account,
		@RequestParam("password") String password) {
		boolean mb=service.login(account, password);
		if(mb) {
		return"Member/index";
		}else {
		model.addAttribute("msg","輸入錯誤請重新輸入");
		return"Member/loginPage";	
		}
	}
	//新增會員空白表單
	@GetMapping("/InsertMember")
	public String getinsertMember(Model model) {
	    MemberBean mb = new MemberBean();
	    model.addAttribute("MemberBean", mb); 
	    return "Member/InsertMember";
	}
	
	//新增會員(註冊)
	@PostMapping("/InsertMember")
	public String processinsertMember(@ModelAttribute("MemberBean") MemberBean mb) { 
	    service.insertMember(mb);
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
	public String processupdateMember(@ModelAttribute MemberBean mb) { 
	    service.updateMember(mb);
	    return "redirect:/showMembers";
	}
	
	//刪除會員
	@GetMapping("/deleteMember")
	public String deleteMember(Integer id) { 
	    service.deleteMember(id);
	    return "redirect:/showMembers";
	}	
		
}
