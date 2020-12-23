package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.dialect.FirebirdDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.Product;
import service.GameService;


@Controller
@RequestMapping("/Product")
@SessionAttributes({"id", "name","result"})
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
	@PostMapping("/SearchAllGame_manager_ajax")
	public @ResponseBody List<String> SearchAllGame_manager(Model model) {
		System.out.println("CCC");
		List<String> id_list = new ArrayList<String>();
		List<Product>list = gs.SearchAllGame();
		for(Product p : list) {
			id_list.add(p.getProductId().toString());
		}
		model.addAttribute("result", list);
		System.out.println("--------------------------------");
		System.out.println(list);
		System.out.println(list.size());
		return  id_list;		
	}
	
	@PostMapping("/AdvancedSearch")
	public String AdvanceSearch(
			@RequestParam(value="E_name",required = false)String E_name,
			@RequestParam(value="C_name",required = false)String C_name,
			@RequestParam(value="G_maker",required = false)String G_maker,
			@RequestParam(value="iss",required = false)String iss,
			@RequestParam(value="Price",defaultValue = "0")Integer Price,
			@RequestParam(value="Price1")Integer Price1,
			Model model) {
		System.out.println("AdvancedSearch");
		System.out.println(E_name);
		System.out.println(C_name);
		List<Product>list = gs.AdvancedSearch(E_name,C_name,G_maker,iss,Price,Price1);
		model.addAttribute("result", list);
		return "SearchResult";		
	}
	@PostMapping("/AdvancedSearch_manager_ajax")
	public @ResponseBody List<String> AdvanceSearch_manager(
			@RequestParam(value="form",required = false)String form,
			Model model) {
		System.out.println("AdvancedSearch_manager_ajax");
		System.out.println(form);
		String[]list = form.split("&");
		String E_name = list[0].substring(list[0].indexOf("=")).replaceAll("=","");
		String C_name = list[1].substring(list[1].indexOf("=")).replaceAll("=","");
		String G_maker = list[2].substring(list[2].indexOf("=")).replaceAll("=","");
		String iss = list[3].substring(list[3].indexOf("=")).replaceAll("=","");
		Integer Price = Integer.parseInt((list[4].substring(list[4].indexOf("=")).replaceAll("=","")));
		Integer Price1 = Integer.parseInt((list[5].substring(list[5].indexOf("=")).replaceAll("=","")));
		
		List<Product>result_list = gs.AdvancedSearch(E_name,C_name,G_maker,iss,Price,Price1);
		List<String> id_list = new ArrayList<String>();
		for(Product p : result_list) {
			id_list.add(p.getProductId().toString());
		}
		model.addAttribute("result", result_list);

		return id_list;		
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
	@SuppressWarnings("unchecked")
	@GetMapping("/PatchUpdate")
	public String PatchUpdate(Model model, 
			@RequestParam(value="G_maker",required = false)String G_maker,
			@RequestParam(value="iss",required = false)String iss,
			@RequestParam(value="discount",required=false)Integer discount
			) {
		List<Product>list = (List<Product>) model.getAttribute("result");
		List<Integer> idlist = new ArrayList<Integer>();
		for(Product p : list) {
			idlist.add(p.getProductId());
		}
		for(Integer id : idlist) {
			Product product = gs.SearchGame(id);
			if(G_maker != "") {
				product.setG_maker(G_maker);
				gs.updateGame(product);
			}
			if(iss != "") {
				product.setIss(iss);
				gs.updateGame(product);
			}
			if(discount != null) {
				product.setPrice(product.getPrice()*discount/10);
				gs.updateGame(product);
			}
		}		
		return "manager_page";
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
	public String SearchGameByViewCount(Model model, 
			@RequestParam(value="ViewCount1",defaultValue = "0",required = false)Integer ViewCount1,
			Integer ViewCount2) {
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
	public String SearchGameByStorage(Model model, 
			@RequestParam(value="storage1",defaultValue = "0",required = false)Integer storage1,Integer storage2) {
		System.out.println("SearchGameByEStorage");
		List<Product>list = gs.SearchGameByStorage(storage1,storage2);
		model.addAttribute("result", list);
		return "SearchResult";		
	}
	@GetMapping("/SearchGameByPrice")
	public String SearchGameByPrice(Model model, 
			@RequestParam(value="price1",defaultValue = "0",required = false)Integer price1,Integer price2) {
		System.out.println("SearchGameByPrice");
		List<Product>list = gs.SearchGameByPrice(price1,price2);
		model.addAttribute("result", list);
		return "SearchResult";		
	}
	@GetMapping("/header")
	public String Header() {
		return "redirect:/header";
	}
	@GetMapping("/SearchGameByPage")
	public String SearchGameByPage(Model model,Integer Page) {
		System.out.println("SearchGameByPage");
		List<Product>list=gs.SearchAllGame();
		List<Product>list1 = gs.SearchGameByPage(Page);
		model.addAttribute("allGamesPage",list);
		model.addAttribute("allGames", list1);
		return "mainpage";

	}
//	@GetMapping("/viewCount_analized")
//	public String viewCount_analized(Model model) {
//		System.out.println("viewCount_analized");
//		List<String> data_game_name = gs.ViewCount_analized_name();
//		List<String> data_viewNum = gs.ViewCount_analized_count();
//		model.addAttribute("name", data_game_name);
//		model.addAttribute("viewCount", data_viewNum);
//		return "manager_page";
//	}

}
