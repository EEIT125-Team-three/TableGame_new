package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.MemberBean;
import service.MemberService;
import service.MemberServiceInterface;

@Controller
public class MemberController {
	
	@Autowired
	private MemberServiceInterface service;

	@GetMapping("/InsertMember")
	public String getinsertMember(Model model) {
	    MemberBean mb = new MemberBean();
	    model.addAttribute("MemberBean", mb); 
	    return "Member/InsertMember";
	}
	
	@PostMapping("/InsertMember")
	public String processinsertMember(@ModelAttribute("MemberBean") MemberBean mb) { 
	    service.insertMember(mb);
	    return "Member/InsertMemberSuccess";
	}
	
	@RequestMapping("/showMembers")
	public String list(Model model) {
		List<MemberBean> list = service.getAllMembers();
		model.addAttribute("allMembers",list);
	return "Member/showMembers";
	}
	
	
	@GetMapping("/updateMember")
	public String getupdateMember(Model model,Integer id) {
	    MemberBean mb = service.getMember(id);
	    model.addAttribute("mb", mb); 
	    return "Member/updateMember";
	}
	
	@PostMapping("/updateMember")
	public String processupdateMember(@ModelAttribute MemberBean mb) { 
	    service.updateMember(mb);
	    return "redirect:/showMembers";
	}
	
	@GetMapping("/deleteMember")
	public String deleteMember(Integer id) { 
	    service.deleteMember(id);
	    return "redirect:/showMembers";
	}
	
//	@PostMapping("/login")
//	public String login(
//		@RequestParam("account") String account,
//		@RequestParam("Password") String password,
//		
//		HttpSession session, ModelMap modelMap) {
//		if(account.equalsIgnoreCase("acc1") && password.equalsIgnoreCase("123")) {
//			session.setAttribute("username", username);
//			return "account/success";
//		} else {
//			modelMap.put("error", "Invalid Account");
//			return "account/index";
//		}
//	}

	
}
