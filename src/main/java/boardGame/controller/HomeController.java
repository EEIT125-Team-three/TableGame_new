package boardGame.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import boardGame.service.GameService;
import boardGame.service.HomeService;

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
		return "frontPage";
	}
	
	
	@GetMapping("/header")
	public String header(	Model model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("id", hs.cheakSessionId(response, request, (Integer)model.getAttribute("id"), model));
		return "header";
	}
	@GetMapping("/homepage")
	public String homepage() {
		return "homepage";
	}
	@GetMapping("/footer")
	public String footer() {
		return "footer";
	}
	
	@GetMapping("/SearchList")
	public String SearchList() {
		return "SearchList";
	}
	
	@GetMapping("/NewInfoPage")
	public String news() {
		return "NewInfo/NewInfoPage";
	}
	
	@GetMapping("/product")
	public String product(Model model) {
		System.out.println("BBBB");
		if(model.getAttribute("id")!=null && (Integer)model.getAttribute("id")==1) {
				model.addAttribute("name", gs.ViewCount_analized_name());
				model.addAttribute("viewCount", gs.ViewCount_analized_count());
				return "Product/manager_page";
		}else {
			model.addAttribute("allGamesPage", gs.SearchAllGame());
			model.addAttribute("allGames",gs.SearchGameByPage(new Integer(1)));
			return "Product/mainpage";
		}
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
			if((Integer)model.getAttribute("id")==1) {
				return "Member/index";
			}else {
				return "Member/memberCenter";	
			}		
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
		return "redirect:/homepage";
	}
	
	@GetMapping("/source")
	public String source() {
		return "source";
	}
}
