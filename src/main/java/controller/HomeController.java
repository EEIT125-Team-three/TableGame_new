package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.net.CookieStore;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import model.Product;
import service.GameService;
import service.GameServiceImpl;

//@SessionAttributes({"name", "id"})
@Controller
public class HomeController {
//	@GetMapping("/welcome")
//	public String welcome(Model model, 
//			@RequestParam(value = "code", required = false) String code, 
//			@RequestParam(value = "number", required = false, defaultValue = "1") Integer number, 
//			@RequestParam(value = "type", required = false) String type, 
//			@RequestParam(value = "Score", required = false, defaultValue = "1.0") Double Score) {
//		model.addAttribute("title", "welcome");
//		model.addAttribute("subtitle", "get out");
//		model.addAttribute("code", code);
//		model.addAttribute("number", number);
//		model.addAttribute("type", type);
//		model.addAttribute("score", Score+1.1);
//		return "welcome";
//	}
	
	@Autowired
	private GameService gs;
	
//	@ModelAttribute("name")
//	public String name(HttpServletRequest request) {
//		Cookie[] cookies = request.getCookies();
//		for(Cookie cookie : cookies) {
//			if(cookie.getName().equals("name")) {
//				return cookie.getValue();
//				
//			}
//		}
//		return null;
//	}
//	@ModelAttribute("id")
//	public String id(HttpServletRequest request) {
//		Cookie[] cookies = request.getCookies();
//		for(Cookie cookie : cookies) {
//			if(cookie.getName().equals("id")) {
//				return cookie.getValue();
//			}
//		}
//		return null;
//	}
	
	@GetMapping("/")
	public String start(Model model) {
		return "homepage";
	}
	
	
	@GetMapping("/header")
	public String header(	Model model) {
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
		List<Product>list=gs.SearchAllGame();
		List<Product>list1=gs.SearchGameByPage(new Integer(1));
		model.addAttribute("allGamesPage",list);
		model.addAttribute("allGames",list1);
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
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("name")) {
				cookie.setMaxAge(0);
				cookie.setPath("/TestVersion");
				response.addCookie(cookie);
			}
			else if(cookie.getName().equals("id")) {
				cookie.setMaxAge(0);
				cookie.setPath("/TestVersion");
				response.addCookie(cookie);
			}
		}
		sessionStatus.setComplete();
		return "redirect:/";
	}
}
