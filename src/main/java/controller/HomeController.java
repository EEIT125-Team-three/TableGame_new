package controller;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import model.Product;
import service.GameService;

//@SessionAttributes({"name"})
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
//	public String name() {
//		return "王";
//	}
	
	@GetMapping("/")
	public String start(Model model) {
		return "homepage";
	}
	
	
	@GetMapping("/header")
	public String header(Model model) {
		model.addAttribute("name", "ssssss");
		return "header";
	}
	
	@GetMapping("/SearchList")
	public String SearchList() {
		return "SearchList";
	}
	
	@GetMapping("/NewInfoPage")
	public String news() {
		return "NewInfoPage";
	}
	
	@GetMapping("/product")
	public String product(Model model) {
		System.out.println("BBBB");
		List<Product>list=gs.SearchAllGame();
		List<Product>list1=gs.SearchGameByPage(1);
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
}
