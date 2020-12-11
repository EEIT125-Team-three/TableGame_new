package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/")
	public String start() {
		return "homepage";
	}
	
	@GetMapping("/header")
	public String header() {
		return "homepage";
	}
	
	@GetMapping("/news")
	public String news() {
		return null;
	}
	
	@GetMapping("/product")
	public String product() {
		return "Product/mainpage";
	}
	
	@GetMapping("/shopCar")
	public String shopCar() {
		System.out.println("AAA");
		return "shopCar";
	}
	
	@GetMapping("/gossip")
	public String gossip() {
		return "gossip";
	}
	
	@GetMapping("/member")
	public String member() {
		return null;
	}
	
	@GetMapping("/connect")
	public String connect() {
		return null;
	}
}
