package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import model.Product;
import service.GameService;

@Controller
public class ProductController {

	@Autowired
	GameService gs;
	
	@GetMapping("/allproducts")
	public String list(Model model) {
		List<Product>list = gs.SearchAllGame();
		model.addAttribute("")
	}
}
