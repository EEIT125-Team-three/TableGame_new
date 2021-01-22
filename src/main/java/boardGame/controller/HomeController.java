package boardGame.controller;

import java.io.Console;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import boardGame.model.City;
import boardGame.model.ConvenienceStoreAddress;
import boardGame.model.District;
import boardGame.model.InfoBean;
import boardGame.model.MemberBean;
import boardGame.model.Road;
import boardGame.service.GameService;
import boardGame.service.HomeService;
import boardGame.service.InfoService;
import boardGame.service.MemberService;
import boardGame.service.MemberServiceInterface;
import boardGame.service.shopCarservice;
import sun.nio.cs.US_ASCII;

@SessionAttributes({ "id", "name" })
@Controller
public class HomeController {
	@Autowired
	private GameService gs;

	@Autowired
	private HomeService hs;
	@Autowired
	private MemberServiceInterface memberService;
	@Autowired
	private shopCarservice carService;
	@Autowired
	private InfoService is;

	@ModelAttribute("name")
	public String name() {
		return null;
	}

	@ModelAttribute("id")
	public String id() {
		return null;
	}

	@GetMapping("/")
	public String start(Model model) {
		return "frontPage";
	}

	@GetMapping("/header")
	public String header(Model model, HttpServletRequest request, HttpServletResponse response) {
		if ((Integer) model.getAttribute("id") != null && (Integer) model.getAttribute("id") == 1) {
			model.addAttribute("id", hs.cheakSessionId(response, request, (Integer) model.getAttribute("id"), model));
			return "header_manager";
		}
		model.addAttribute("id", hs.cheakSessionId(response, request, (Integer) model.getAttribute("id"), model));
		return "header";
	}

	@GetMapping("/frontPage")
	public String homepage() {
		return "frontPage";
	}

	@GetMapping("/footer")
	public String footer() {
		return "footer";
	}

	@GetMapping("/SearchList")
	public String SearchList() {
		return "SearchList";
	}

	@GetMapping("/NewInfoPage")
	public String news(Model model) {
		if ((Integer) model.getAttribute("id") != null && (Integer) model.getAttribute("id") == 1) {
			return "redirect:/NewInfoManager";
		}
		return "NewInfo/NewInfoPage";
	}

	@GetMapping("/product")
	public String product(Model model, HttpServletRequest request) {
		System.out.println("BBBB");
		if (model.getAttribute("id") != null && (Integer) model.getAttribute("id") == 1) {
			model.addAttribute("name", gs.ViewCount_analized_name());
			model.addAttribute("viewCount", gs.ViewCount_analized_count());
			model.addAttribute("cata1", gs.GetAllCata1());
			model.addAttribute("cata2", gs.GetAllCata2());
			model.addAttribute("cata1_gameNum", gs.GetGameNumByEachCata1());
			model.addAttribute("cata2_gameNum", gs.GetGameNumByEachCata2());
			return "Product/manager_page";
		} else {
			model.addAttribute("allGamesPage", gs.SearchAllGame());
			model.addAttribute("allGames", gs.SearchGameByPage(new Integer(1)));
			model.addAttribute("products",
					carService.selectAllFromShopCarAjax((Integer) model.getAttribute("id"), request));
			return "Product/mainpage";
		}
	}

	@GetMapping("/shopCar")
	public String shopCar(Model model) {
		if ((Integer) model.getAttribute("id") != null && (Integer) model.getAttribute("id") == 1) {
			return "shopCarManager";
		}
		return "shopCar";
	}

	@GetMapping("/gossip")
	public String gossip() {
		return "DiscussionBoard/gossip";
	}

	@GetMapping("/login")
	public String login(Model model, HttpServletRequest request) {
		if (model.getAttribute("id") != null || hs.checkCookieHasSessionId(request)) {
			if ((Integer) model.getAttribute("id") == 1) {
				model.addAttribute("mlist", memberService.getGenderNumber());
				model.addAttribute("mRegion",memberService.getRegionNumber());
				model.addAttribute("mMonth", memberService.getMonthNumber());
				return "Member/index";
			} else {
				MemberBean mb = memberService.getMember((Integer) model.getAttribute("id"));
				model.addAttribute("account", mb.getMemAccount());
				model.addAttribute("gender", mb.getMemGender());
				model.addAttribute("birthday", mb.getMemBirthday());
				model.addAttribute("phone", mb.getMemPhone());
				model.addAttribute("mailaddress", mb.getMemMailaddress());
				if(mb.getRoad() != null) {
					model.addAttribute("address", mb.getRoad().getDistrict().getCity().getCity()+mb.getRoad().getDistrict().getDistrict()+mb.getRoad().getRoad()+mb.getMemAddress());
				}
				model.addAttribute("idNumber", mb.getMemIdNumber());
				model.addAttribute("refund", mb.getMemRefund());
				model.addAttribute("registerTime",mb.getResisterTime());
				return "Member/memberCenter";
			}
		}
		return "Member/loginPage";
	}

	@GetMapping("/connect")
	public String connect() {
		return null;
	}

	@PostMapping("/logout")
	public String logout(HttpServletResponse response, HttpServletRequest request, SessionStatus sessionStatus) {
		hs.logout(response, request, sessionStatus);
		return "redirect:/frontPage";
	}

	@GetMapping("/source")
	public String source() {
		return "source";
	}

	@PostMapping("/getAllCity")
	public @ResponseBody List<City> getAllCity() {
		return hs.getAllCity();
	}

	@PostMapping("/getAllDistrict")
	public @ResponseBody List<District> getAllDistrict(Integer cityId){
		if(cityId != null) {
			return hs.getAllDistrict(cityId);
		}
		return new ArrayList<District>();
	}
	
	@PostMapping("/getAllRoad")
	public @ResponseBody List<Road> getAllRoad(Integer districtId){
		if(districtId != null) {
			return hs.getAllRoad(districtId);
		}
		return new ArrayList<Road>();
	}
	
	@PostMapping("/getConvenienceStoreByRoadId")
	public @ResponseBody List<List<Object>> getConvenienceStoreByRoadId(Integer districtId){
		return hs.getConvenienceStoreByRoadId(districtId);
	}
	
	@GetMapping("/getWebSocketPage")
	public String getWebSocketPage() {
		return "webSocketPage";
	}
}
