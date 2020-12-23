package boardGame.controller;

import org.springframework.cglib.transform.impl.AddDelegateTransformer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testcontroller {

	@GetMapping("/exchange")
	public String test(Model model) {

		model.addAttribute("aa	a","STring");
		
		return "/NewInfo/test";
	}
	
}
