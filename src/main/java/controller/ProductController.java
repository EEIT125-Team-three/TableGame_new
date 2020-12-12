package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Product;
import service.GameService;


@Controller
@RequestMapping("/Product")
public class ProductController {

	@Autowired
	private GameService gs;
	
	@GetMapping("/SearchAllGame")
	public String SearchAllGame(Model model) {
		System.out.println("CCC");
		List<Product>list = gs.SearchAllGame();
		model.addAttribute("allGames",list);
		return "Product/showAllGames";
		
	}
	@RequestMapping(value = "/InsertGame", method=RequestMethod.POST)
	public String InsertGame(@ModelAttribute Product gb) {
		System.out.println("DDD");	
		int result = gs.createGame(gb);
		if(result > 0) {
			return "Product/InsertGameSuccess";		
		}
		return "Product/mainpage";
		
	}
	
	
}
