package boardGame.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import boardGame.model.Cata1;
import boardGame.model.Cata2;
import boardGame.model.Product;
import boardGame.service.GameService;


@Controller
@RequestMapping("/Product")
@SessionAttributes({ "id", "name", "result" })
public class ProductController {

	@Autowired
	private GameService gs;

	@GetMapping("/SearchAllGame") // 管理員介面之取得遊戲清單
	public String SearchAllGame(Model model) {
		System.out.println("CCC");
		List<Product> list = gs.SearchAllGame();
		model.addAttribute("allGames", list);
		return "showAllGames";
	}

	@PostMapping("/SearchAllGame_manager_ajax") // 管理員介面批次修改中的取得所有資料
	public @ResponseBody List<String> SearchAllGame_manager(Model model) {
		System.out.println("CCC");
		List<String> id_list = new ArrayList<String>();
		List<Product> list = gs.SearchAllGame();
		for (Product p : list) {
			id_list.add(p.getProductId().toString());
		}
		model.addAttribute("result", list);
		return id_list;
	}

	@PostMapping("/AdvancedSearch") // 使用者介面進階查詢功能
	public String AdvanceSearch(
			@RequestParam(value = "E_name", required = false) String E_name,
			@RequestParam(value = "C_name", required = false) String C_name,
			@RequestParam(value = "G_maker", required = false) String G_maker,
			@RequestParam(value = "iss", required = false) String iss,
			@RequestParam(value = "Price", defaultValue = "0") Integer Price,
			@RequestParam(value = "Price1") Integer Price1,
			@RequestParam(value = "Cata1[]", required = false) List<Integer> Cata1,
			@RequestParam(value = "Cata2[]", required = false) List<Integer> Cata2, Model model) {
		if (Cata1 == null) {
			Cata1 = new ArrayList<Integer>();
		}
		if (Cata2 == null) {
			Cata2 = new ArrayList<Integer>();
		}
		System.out.println(Cata1);
		System.out.println(Cata2);
		List<Product> list = gs.AdvancedSearch_cata(E_name, C_name, G_maker, iss, Price, Price1, Cata1, Cata2);
		model.addAttribute("result", list);
		return "SearchResult";
	}

	@PostMapping("/AdvancedSearch_manager_ajax") // 管理員介面批次修改進階搜尋功能
	public @ResponseBody List<String> AdvanceSearch_manager(@RequestParam(value = "form", required = false) String form,
			Model model) {
		System.out.println("AdvancedSearch_manager_ajax");
		System.out.println(form);
		String[] list = form.split("&");
		List<String>list_test = new ArrayList<String>();
		for(String i : list) {
			list_test.add(i);
		}

		List<String>list_test2 = list_test.subList(6, list_test.size());
		List<Integer>cata1list = new ArrayList<Integer>();
		List<Integer>cata2list = new ArrayList<Integer>();
		if(list_test2.size() != 0) {
			for(String i : list_test2) {
				if(i.contains("Cata1")) {
					Integer ans =Integer.parseInt(i.replace("Cata1[]=", ""));
					cata1list.add(ans);				
				}
			}
			for(String i : list_test2) {
				if(i.contains("Cata2")) {
					Integer ans =Integer.parseInt(i.replace("Cata2[]=", ""));
					cata2list.add(ans);				
				}
			}
		}

		String E_name = list[0].replace("E_name=", "");
		if(E_name.isEmpty()) {
			E_name = "";
		}
		String C_name = list[1].replace("C_name=", "");
		if(C_name.isEmpty()) {
			C_name = "";
		}
		String G_maker = list[2].replace("G_maker=", "");
		if(G_maker.isEmpty()) {
			G_maker = "";
		}
		String iss = list[3].replace("iss=", "");
		if(iss.isEmpty()) {
			iss = "";
		}
		Integer Price = Integer.parseInt((list[4].replace("Price=", "")));
		Integer Price1 = Integer.parseInt((list[5].replace("Price1=", "")));
	
		List<Product> result_list = gs.AdvancedSearch_cata(E_name, C_name, G_maker, iss, Price, Price1,cata1list,cata2list);
		System.out.println(result_list.size());
		List<String> id_list = new ArrayList<String>();
		for (Product p : result_list) {
			id_list.add(p.getProductId().toString());
		}
		model.addAttribute("result", result_list);

		return id_list;
	}

	@PostMapping("/InsertGame") // 新增遊戲，包含類型科目
	public String InsertGame(
//			@ModelAttribute("Product") Product gb,
			@RequestParam(value = "E_name", required = false) String E_name,
			@RequestParam(value = "C_name", required = false) String C_name,
			@RequestParam(value = "img_url", required = false) String img_url,
			@RequestParam(value = "G_maker", required = false) String G_maker,
			@RequestParam(value = "iss", required = false) String iss,
			@RequestParam(value = "Price") Integer Price,
			@RequestParam(value = "viewCount") Integer viewCount,
			@RequestParam(value = "date") String date,
			@RequestParam(value = "storage") Integer storage,
			@RequestParam(value = "Cata1[]", required = false) List<Integer> Cata1,
			@RequestParam(value = "Cata2[]", required = false) List<Integer> Cata2
			){
		System.out.println("InsertGame");
		Product gb = new Product();
		gb.setC_name(C_name);
		gb.setE_name(E_name);
		gb.setImg_url(img_url);
		gb.setG_maker(G_maker);
		gb.setIss(iss);
		gb.setPrice(Price);
		gb.setViewCount(viewCount);
		gb.setDate(date);
		gb.setStorage(storage);
		int result = gs.createGame(gb);
		if (result > 0) {
//			Integer id = gb.getProductId();
			gs.InsertProduct_cata1(gb,Cata1);
			gs.InsertProduct_cata2(gb,Cata2);
			return "redirect:/Product/SearchAllGame";
		}
		return "mainpage";
	}

	@GetMapping("/DeleteGame") // 刪除遊戲
	public String DeleteGame(Integer productId) {
		System.out.println("DeleteFunction");
		int result = gs.deleteGame(productId);
		if (result > 0) {
			return "redirect:/Product/SearchAllGame";
		}
		return "mainpage";
	}

	@GetMapping("/UpdateGame") // 修改遊戲GET
	public String UpdateGame(Model model, Integer productId) {
		System.out.println("UpdateFunction");
		Product gb = gs.SearchGame(productId);
		model.addAttribute("gb", gb);
		return "UpdateGame";
	}

	@PostMapping("/UpdateGame") // 修改遊戲POST
	public String ProcessGameInfo(@ModelAttribute Product gb) {
		System.out.println("SaveUpdateFunction");
		Integer result = gs.updateGame(gb);
		if (result > 0) {
			return "redirect:/Product/SearchAllGame";
		}
		return "mainpage";
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/PatchUpdate") // 批次修改功能
	public String PatchUpdate(Model model, @RequestParam(value = "G_maker", required = false) String G_maker,
			@RequestParam(value = "iss", required = false) String iss,
			@RequestParam(value = "discount", required = false) Integer discount) {
		List<Product> list = (List<Product>) model.getAttribute("result");
		List<Integer> idlist = new ArrayList<Integer>();
		for (Product p : list) {
			idlist.add(p.getProductId());
		}
		for (Integer id : idlist) {
			Product product = gs.SearchGame(id);
			if (G_maker != "") {
				product.setG_maker(G_maker);
				gs.updateGame(product);
			}
			if (iss != "") {
				product.setIss(iss);
				gs.updateGame(product);
			}
			if (discount != null) {
				product.setPrice(product.getPrice() * discount / 10);
				gs.updateGame(product);
			}
		}
		return "redirect:/product";
	}

	@GetMapping("/SearchGameByProductId") // 透過id搜尋商品
	public String SearchGameByProductId(Model model, Integer ProductId) {
		System.out.println("SearchGameByProductId");
		Product product = gs.SearchGame(ProductId);
		if ((Integer) model.getAttribute("id") != null) {
			gs.AddMemberHistory((Integer) model.getAttribute("id"), product);
		}
		List<Cata1> cata1 = gs.FromIdSearchCata1(ProductId);
		List<Cata2> cata2 = gs.FromIdSearchCata2(ProductId);
		List<Product> DLC = gs.SearchDLC(ProductId);
		model.addAttribute("cata1", cata1);
		model.addAttribute("cata2", cata2);
		model.addAttribute("product", product);
		model.addAttribute("DLC", DLC);
		return "ProductPage";
	}

	@GetMapping("/SearchGameByE_name") // 透過e_name搜尋商品
	public String SearchGameByE_name(Model model, String E_name) {
		System.out.println("SearchGameByE_name");
		List<Product> list = gs.SearchGameByE_name(E_name);
		model.addAttribute("result", list);
		return "SearchResult";
	}

	@GetMapping("/SearchGameByC_name") // 透過c_name搜尋商品
	public String SearchGameByC_name(Model model, String C_name) {
		System.out.println("SearchGameByC_name");
		List<Product> list = gs.SearchGameByC_name(C_name);
		model.addAttribute("result", list);
		return "SearchResult";
	}

	@GetMapping("/SearchGameByG_maker") // 透過g_maker搜尋商品
	public String SearchGameByG_maker(Model model, String G_maker) {
		System.out.println("SearchGameByG_maker");
		List<Product> list = gs.SearchGameByG_maker(G_maker);
		model.addAttribute("result", list);
		return "SearchResult";
	}

	@GetMapping("/SearchGameByiss") // 透過iss搜尋商品
	public String SearchGameByiss(Model model, String iss) {
		System.out.println("SearchGameByiss");
		List<Product> list = gs.SearchGameByiss(iss);
		model.addAttribute("result", list);
		return "SearchResult";
	}

	@GetMapping("/SearchGameByViewCount") // 透過viewcount搜尋商品
	public String SearchGameByViewCount(Model model,
			@RequestParam(value = "ViewCount1", defaultValue = "0", required = false) Integer ViewCount1,
			Integer ViewCount2) {
		System.out.println("SearchGameByViewCount");
		List<Product> list = gs.SearchGameByViewCount(ViewCount1, ViewCount2);
		model.addAttribute("result", list);
		return "SearchResult";
	}

	@GetMapping("/SearchGameBydate") // 透過date搜尋商品
	public String SearchGameBydate(Model model, Integer date) {
		System.out.println("SearchGameBydate");
		List<Product> list = gs.SearchGameBydate(date);
		model.addAttribute("result", list);
		return "SearchResult";
	}

	@GetMapping("/SearchGameByStorage") // 透過storage搜尋商品
	public String SearchGameByStorage(Model model,
			@RequestParam(value = "storage1", defaultValue = "0", required = false) Integer storage1,
			Integer storage2) {
		System.out.println("SearchGameByEStorage");
		List<Product> list = gs.SearchGameByStorage(storage1, storage2);
		model.addAttribute("result", list);
		return "SearchResult";
	}

	@GetMapping("/SearchGameByPrice") // 透過price搜尋商品
	public String SearchGameByPrice(Model model,
			@RequestParam(value = "price1", defaultValue = "0", required = false) Integer price1, Integer price2) {
		System.out.println("SearchGameByPrice");
		List<Product> list = gs.SearchGameByPrice(price1, price2);
		model.addAttribute("result", list);
		return "SearchResult";
	}

	@GetMapping("/header") // ajax讀取header
	public String Header() {
		return "redirect:/header";
	}

	@GetMapping("/SearchGameByPage") // 透過頁數搜尋商品
	public String SearchGameByPage(Model model, Integer Page) {
		System.out.println("SearchGameByPage");
		List<Product> list = gs.SearchAllGame();
		List<Product> list1 = gs.SearchGameByPage(Page);
		model.addAttribute("allGamesPage", list);
		model.addAttribute("allGames", list1);
		return "mainpage";

	}

	@GetMapping("/SearchGameByCata1") // 透過cata1搜尋商品
	public String SearchGameByCata1(Model model, @RequestParam(value = "Cata1") Integer Cata1) {
		System.out.println("SearchGameByCata1");
		List<Product> list = gs.SearchGameByCata1(Cata1);
		model.addAttribute("result", list);
		return "SearchResult";
	}

	@GetMapping("/SearchGameByCata2") // 透過cata2搜尋商品
	public String SearchGameByCata2(Model model, @RequestParam(value = "Cata2") Integer Cata2) {
		System.out.println("SearchGameByCata2");
		List<Product> list = gs.SearchGameByCata2(Cata2);
		model.addAttribute("result", list);
		return "SearchResult";
	}

	@GetMapping("/OrderByCondition") // 藉由條件排序商品
	public String OrderByCondition(Model model, @RequestParam(value = "condition") String condition,
			@RequestParam(value = "page", required = false) Integer page) {
		if (page == null) {
			page = new Integer(1);
		}
		System.out.println("OrderByCondition");
		System.out.println(condition);
		model.addAttribute("condition", condition);
		model.addAttribute("allGamesPage", gs.SearchAllGame());
		model.addAttribute("allGames", gs.OrderByConditionAndPage(condition, page));
		return "OrderByPage";
	}

}
