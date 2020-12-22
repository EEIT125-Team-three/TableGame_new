package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import service.GameService;
import service.HomeService;

@SessionAttributes({"id", "name"})
@Controller
public class HomeController {	
	@Autowired
	private GameService gs;
	
	@Autowired
	private HomeService hs;
	@ModelAttribute("name")
	public String name() {
	return null;
	}
	@ModelAttribute("id")
	public String id() {
	return null;
	}
	@GetMapping("/")
	public String start(Model model) {
		return "homepage";
	}
	
	
	@GetMapping("/header")
	public String header(	Model model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("id", hs.cheakSessionId(response, request, (Integer)model.getAttribute("id"), model));
		return "header";
	}
	
	@GetMapping("/SearchList")
	public String SearchList() {
		return "SearchList";
	}
	
	@GetMapping("/news")
	public String news() {
		return "NewInfoPage";
	}
	
	@GetMapping("/product")
	public String product(Model model) {
		System.out.println("BBBB");
		model.addAttribute("allGamesPage", gs.SearchAllGame());
		model.addAttribute("allGames",gs.SearchGameByPage(new Integer(1)));
		return "Product/mainpage";
	}
	
	@GetMapping("/shopCar")
	public String shopCar() {
		return "shopCar";
	}
	
	@GetMapping("/gossip")
	public String gossip() {
		return "DiscussionBoard/gossip";
	}
	
	@GetMapping("/login")
	public String login(Model model, HttpServletRequest request) {
		if(model.getAttribute("id") != null || hs.checkCookieHasSessionId(request)) {
			return "Member/index";
		}
		return "Member/loginPage";	
	}
	
	@GetMapping("/connect")
	public String connect() {
		return null;
	}
	@PostMapping("/logout")
	public String logout(HttpServletResponse response,
			HttpServletRequest request,
			SessionStatus sessionStatus) {
		hs.logout(response, request, sessionStatus);
		return "redirect:/";
	}
	@GetMapping("/memberImages")
	public @ResponseBody String getmemberImages() {
		System.out.println("AS");
		return "A.img";
	}
}
