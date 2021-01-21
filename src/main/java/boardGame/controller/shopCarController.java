package boardGame.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.varia.StringMatchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import boardGame.model.MemberBean;
import boardGame.model.Product;
import boardGame.model.ShopCar;
import boardGame.model.TableGameOrder;
import boardGame.service.MemberServiceInterface;
import boardGame.service.shopCarservice;

@Controller
@SessionAttributes({"id", "name"})
public class shopCarController {
	@Autowired
	shopCarservice shopCarservice;
	@Autowired
	MemberServiceInterface memberService;
	
	@PostMapping("getShowProductAjax")
	public @ResponseBody List<Product> getShowProduct(){
		return shopCarservice.getShowProduct();
	}
	
	@PostMapping("selectAllFromShopCarAjax")
	public @ResponseBody List<Product> selectAllFromShopCar(Model model, HttpServletRequest request, HttpServletResponse response){
		return shopCarservice.selectAllFromShopCarAjax((Integer) model.getAttribute("id"), request);
	}
	
	@PostMapping("updateFromShopCarAjax")
	public @ResponseBody List<Product> updateFromShopCar(Model model, 
			@RequestParam(value = "buyHowmuch", required = false) Integer buyHowmuch,
			@RequestParam(value = "productId", required = false) Integer productId,
			HttpServletRequest request, HttpServletResponse response){
		return shopCarservice.updateFromShopCarAjax((Integer) model.getAttribute("id"), productId, buyHowmuch, request, response);
	}
	
	@PostMapping("deleteFromShopCarAjax")
	public @ResponseBody List<Product> deleteFromShopCar(Model model,
			@RequestParam(value = "productId", required = false) Integer productId,
			HttpServletRequest request, HttpServletResponse response){
		return shopCarservice.deleteFromShopCarAjax((Integer) model.getAttribute("id"), productId, request, response);
	}
	
	@PostMapping("insertToShopCarAjax")
	public @ResponseBody List<Product> insertToShopCar(Model model,
			@RequestParam(value = "buyHowmuch", required = false) Integer buyHowmuch,
			@RequestParam(value = "productId", required = false) Integer productId,
			HttpServletRequest request, HttpServletResponse response){
		if((Integer) model.getAttribute("id") == null) {
			shopCarservice.addAllCookieBuy(request, response, productId);
		}
		return shopCarservice.insertToShopCarAjax((Integer) model.getAttribute("id"), productId, buyHowmuch);
	}
	
	@PostMapping("shopCarAjaxQuantity")
	public @ResponseBody Map<Integer, Integer> test(Model model, HttpServletRequest request, HttpServletResponse response){
			return shopCarservice.getQuantity((Integer) model.getAttribute("id"), request, response);

	}
	
	@PostMapping("addToTrackListAjax")
	public @ResponseBody List<Product> addToTrackList(Model model,
			@RequestParam(value = "productId", required = false) Integer productId,
			HttpServletRequest request, HttpServletResponse response){
		if((Integer) model.getAttribute("id") == null) {
			productId = 0;
		}
		else {
			shopCarservice.shopCarToTrackList((Integer) model.getAttribute("id"), productId);
		}
		return shopCarservice.deleteFromShopCarAjax((Integer) model.getAttribute("id"), productId, request, response);
	}
	
	@PostMapping("selectAllFromTrackListAjax")
	public @ResponseBody List<Product> selectAllFromTrackList(Model model){
		return shopCarservice.selectAllFromTrackList((Integer) model.getAttribute("id"));
	}
	
	@PostMapping("trackToShopCarAjax")
	public @ResponseBody List<Product> trackToShopCar(Model model,
			@RequestParam(value = "productId", required = false) Integer productId){
		shopCarservice.deleteFromTrackListAjax((Integer)model.getAttribute("id"), productId);
		shopCarservice.insertToShopCarAjax((Integer) model.getAttribute("id"), productId, 1);
		return shopCarservice.selectAllFromTrackList((Integer) model.getAttribute("id"));
	}
	
	@PostMapping("deleteFromTrackListAjax")
	public @ResponseBody List<Product> deleteFromTrackList(Model model,
			@RequestParam(value = "productId", required = false) Integer productId){
		shopCarservice.deleteFromTrackListAjax((Integer)model.getAttribute("id"), productId);
		return shopCarservice.selectAllFromTrackList((Integer) model.getAttribute("id"));
	}
	
	@PostMapping("/goCheck")
	public String goCheck(Model model, String merchantTradeNo, String totalAmount, String itemName) {
		if((Integer)model.getAttribute("id") != null) {
			System.out.println(itemName);
			model.addAttribute("item", itemName);
			model.addAttribute("totalAmount", totalAmount);
			MemberBean memberBean = memberService.getMember((Integer)model.getAttribute("id"));
			model.addAttribute("address", memberBean.getMemAddress());
			model.addAttribute("phone", memberBean.getMemPhone());
			model.addAttribute("refund", memberBean.getMemRefund());
			return "goCheck";
		}
		return "redirect:/login";
	}
	
	@PostMapping("/checkout")
	public String checkout(Model model, String sentToWho, String sentToWhere, String sentToPhone, Integer road, Integer useRefund, Integer shopId) {
		model.addAttribute("go", shopCarservice.checkOut((Integer)model.getAttribute("id"), sentToWho, sentToWhere, sentToPhone, road, useRefund, shopId));
		return "Go";
	}
	
	@PostMapping("addToTrackList")
	public @ResponseBody Map<String, String> addToTrackList(HttpServletResponse response, Model model, Integer productId) {
		return shopCarservice.addToTrackList((Integer)model.getAttribute("id"), productId);
	}
	
	@PostMapping("insertToShopCar")
	public @ResponseBody Map<String, String> insertToShopCar(Model model, Integer productId,
			HttpServletRequest request, HttpServletResponse response){
		if((Integer) model.getAttribute("id") == null) {
			return shopCarservice.addAllCookieBuy(request, response, productId);
		}
		return shopCarservice.addToShopCar((Integer) model.getAttribute("id"), productId);
	}
	@PostMapping("/getAllShopCarHistory")
	public @ResponseBody Map<String, Object> getAllShopCarHistory(Model model, Integer dateRage, Integer historyId){
		if(model.getAttribute("id") != null && (Integer)model.getAttribute("id") == 1) {
			return shopCarservice.getShopCarHistory(dateRage, historyId, null);
		}
		return new HashMap<String, Object>();
	}
	@PostMapping("/getOrderDetail")
	public @ResponseBody List<List<String>> getOrderDetail(Integer orderId){
		System.out.println("AAA");
		return shopCarservice.getOrderDetail(orderId);
	}
	@PostMapping("/changeOrderData")
	public @ResponseBody void changeOrderData(String sentToWho, String sentToWhere, String sentToPhone, Integer orderId) {
		shopCarservice.changeOrderData(sentToWho, sentToWhere, sentToPhone, orderId);
	}
	
	@PostMapping("/getAllOrderYear")
	public @ResponseBody List<Integer> getAllOrderYear() {
		Map<String, Object> map = shopCarservice.getShopCarHistory(null, null, null);
		return shopCarservice.getAllOrderYear((List<String>)map.get("allTableGameOrderTime"));
	}
	
	@PostMapping("/getDataByDate")
	public @ResponseBody Map<String, Object> getDataByDate(Integer year, Integer month){
		Map<String, Object> map = shopCarservice.getShopCarHistory(null, null, null);
		Map<String, Object> remap = shopCarservice.getDataByDate((List<TableGameOrder>)map.get("TableGameOrder"), year-1900, month);
		return remap;
	}
	
	@GetMapping("/checkoutOver")
	public String checkoutOver() {
		return "Go";
	}
	
	@PostMapping("/checkDiscount")
	public @ResponseBody Boolean checkDiscount(String discountId, Model model) {
		return shopCarservice.checkDiscount(discountId, (Integer)model.getAttribute("id"));
	}
}
