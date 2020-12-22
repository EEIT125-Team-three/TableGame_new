package controller;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import service.GameService;
import service.HomeService;

@SessionAttributes({"id"})
@Controller
public class HomeController {	
	@Autowired
	private GameService gs;
	
	@Autowired
	private HomeService hs;
//	@ModelAttribute("id")
//	public Integer id(HttpServletRequest request, HttpServletResponse response, Model model) {
//		return hs.cheakSessionId(response, request, (Integer)model.getAttribute("id"));
//	}

	@GetMapping("/")
	public String start(Model model) {
		return "homepage";
	}
	
	
	@GetMapping("/header")
	public String header(	Model model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("id", hs.cheakSessionId(response, request, (Integer)model.getAttribute("id")));
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
	public String login() {
		return "Member/loginPage";
	}
	
	@GetMapping("/connect")
	public String connect() {
		return null;
	}
	@PostMapping("logout")
	public String logout(HttpServletResponse response,
			HttpServletRequest request,
			SessionStatus sessionStatus) {
		hs.logout(response, request, sessionStatus);
		return "redirect:/";
	}
}
