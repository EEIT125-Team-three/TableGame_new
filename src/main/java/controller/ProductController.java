package controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


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
		return "showAllGames";
		
	}
	@PostMapping("/InsertGame")
	public String InsertGame(@ModelAttribute Product gb) {
		System.out.println("DDD");	
		int result = gs.createGame(gb);
		if(result > 0) {
			return "redirect:/Product/SearchAllGame";		
		}
		return "mainpage";	
	}
	@GetMapping("/DeleteGame")
	public String DeleteGame(Integer productId) {
		System.out.println("DeleteFunction");
		int result = gs.deleteGame(productId);
		if (result > 0) {
			return "redirect:/Product/SearchAllGame";
		}
		return "mainpage";
	}
	@GetMapping("/UpdateGame")
	public String UpdateGame(Model model, Integer productId) {
		System.out.println("UpdateFunction");
		Product gb = gs.SearchGame(productId);
		model.addAttribute("gb", gb);
		return "UpdateGame";
	}
	@PostMapping("/UpdateGame")
	public String ProcessGameInfo(@ModelAttribute Product gb) {
		System.out.println("SaveUpdateFunction");
		Integer  result = gs.updateGame(gb);
		if(result > 0) {
			return "redirect:/Product/SearchAllGame";			
		}
		return "mainpage";
	}
	
	@GetMapping("/SearchGameByProductId")
	public String SearchGameByProductId(Model model,Integer ProductId) {
		System.out.println("SearchGameByProductId");
		Product product = gs.SearchGame(ProductId);
		model.addAttribute("product", product);
		return "ProductPage";
	}
	
	@GetMapping("/SearchGameByE_name")
	public String SearchGameByE_name(Model model, String E_name) {
		System.out.println("SearchGameByE_name");
		List<Product>list = gs.SearchGameByE_name(E_name);
		model.addAttribute("result", list);
		return "SearchResult";		
	}
	@GetMapping("/SearchGameByC_name")
	public String SearchGameByC_name(Model model, String C_name) {
		System.out.println("SearchGameByC_name");
		List<Product>list = gs.SearchGameByC_name(C_name);
		model.addAttribute("result", list);
		return "SearchResult";		
	}
	@GetMapping("/SearchGameByG_maker")
	public String SearchGameByG_maker(Model model, String G_maker) {
		System.out.println("SearchGameByG_maker");
		List<Product>list = gs.SearchGameByG_maker(G_maker);
		model.addAttribute("result", list);
		return "SearchResult";		
	}
	@GetMapping("/SearchGameByiss")
	public String SearchGameByiss(Model model, String iss) {
		System.out.println("SearchGameByiss");
		List<Product>list = gs.SearchGameByiss(iss);
		model.addAttribute("result", list);
		return "SearchResult";		
	}
	@GetMapping("/SearchGameByViewCount")
	public String SearchGameByViewCount(Model model, Integer ViewCount1,Integer ViewCount2) {
		System.out.println("SearchGameByViewCount");
		List<Product>list = gs.SearchGameByViewCount(ViewCount1,ViewCount2);
		model.addAttribute("result", list);
		return "SearchResult";		
	}
	@GetMapping("/SearchGameBydate")
	public String SearchGameBydate(Model model, String date) {
		System.out.println("SearchGameBydate");
		List<Product>list = gs.SearchGameBydate(date);
		model.addAttribute("result", list);
		return "SearchResult";		
	}
	@GetMapping("/SearchGameByStorage")
	public String SearchGameByStorage(Model model, Integer storage1,Integer storage2) {
		System.out.println("SearchGameByEStorage");
		List<Product>list = gs.SearchGameByStorage(storage1,storage2);
		model.addAttribute("result", list);
		return "SearchResult";		
	}
	@GetMapping("/SearchGameByPrice")
	public String SearchGameByPrice(Model model, Integer price1,Integer price2) {
		System.out.println("SearchGameByPrice");
		List<Product>list = gs.SearchGameByPrice(price1,price2);
		model.addAttribute("result", list);
		return "SearchResult";		
	}
	@GetMapping("/header")
	public String Header() {
		return "redirect:/header";
	}
	
	
}
