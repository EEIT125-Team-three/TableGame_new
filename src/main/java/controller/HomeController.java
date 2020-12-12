package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.sym.Name;

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
	
	@ModelAttribute("name")
	public String name() {
		return "王";
	}
	
	@GetMapping("/")
	public String start(Model model) {
//		model.addAttribute("name", "王");
		return "homepage";
	}
	
	
	@GetMapping("/header")
	public String header(Model model, @RequestParam(value = "b", required = false) String name) {
		System.out.println(name);
		model.addAttribute("name", name);
		return "header";
	}
	
	@GetMapping("/news")
	public String news() {
		return null;
	}
	
	@GetMapping("/product")
	public String product() {
		System.out.println("BBBB");
		return "Product/mainpage";
	}
	
	@GetMapping("/shopCar")
	public String shopCar() {
		return "shopCar";
	}
	
	@GetMapping("/gossip")
	public String gossip() {
		return "gossip";
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
