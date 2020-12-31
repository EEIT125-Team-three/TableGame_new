package boardGame.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import boardGame.model.Product;
import boardGame.model.TrackList;
import boardGame.service.shopCarservice;
import ecpay.payment.integration.AllInOne;

@Controller
@SessionAttributes({"id"})
public class shopCarController {
	@Autowired
	shopCarservice shopCarservice;
	
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
			shopCarservice.addToTrackList((Integer) model.getAttribute("id"), productId);
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
		shopCarservice.insertToShopCarAjax((Integer) model.getAttribute("id"), productId, 1);
		shopCarservice.deleteFromTrackListAjax((Integer)model.getAttribute("id"), productId);
		return shopCarservice.selectAllFromTrackList((Integer) model.getAttribute("id"));
	}
	
	@PostMapping("deleteFromTrackListAjax")
	public @ResponseBody List<Product> deleteFromTrackList(Model model,
			@RequestParam(value = "productId", required = false) Integer productId){
		shopCarservice.deleteFromTrackListAjax((Integer)model.getAttribute("id"), productId);
		return shopCarservice.selectAllFromTrackList((Integer) model.getAttribute("id"));
	}
	
	@PostMapping("/checkOut")
	public @ResponseBody String checkOut(String merchantTradeNo, String totalAmount, String tradeDesc, String itemName) {
		return shopCarservice.checkOut(merchantTradeNo, totalAmount, tradeDesc, itemName);
	}
}
