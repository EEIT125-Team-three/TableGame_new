package boardGame.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import boardGame.model.Product;
import boardGame.model.TrackList;
import boardGame.service.shopCarservice;

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
	public @ResponseBody List<Product> selectAllFromShopCar(Model model){
		return shopCarservice.selectAllFromShopCarAjax((Integer) model.getAttribute("id"));
	}
	
	@PostMapping("updateFromShopCarAjax")
	public @ResponseBody List<Product> updateFromShopCar(Model model, 
			@RequestParam(value = "buyHowmuch", required = false) Integer buyHowmuch,
			@RequestParam(value = "productId", required = false) Integer productId){
		return shopCarservice.updateFromShopCarAjax((Integer) model.getAttribute("id"), productId, buyHowmuch);
	}
	
	@PostMapping("deleteFromShopCarAjax")
	public @ResponseBody List<Product> deleteFromShopCar(Model model,
			@RequestParam(value = "productId", required = false) Integer productId){
		return shopCarservice.deleteFromShopCarAjax((Integer) model.getAttribute("id"), productId);
	}
	
	@PostMapping("insertToShopCarAjax")
	public @ResponseBody List<Product> insertToShopCar(Model model,
			@RequestParam(value = "buyHowmuch", required = false) Integer buyHowmuch,
			@RequestParam(value = "productId", required = false) Integer productId){
		return shopCarservice.insertToShopCarAjax((Integer) model.getAttribute("id"), productId, buyHowmuch);
	}
	
	@PostMapping("shopCarAjaxQuantity")
	public @ResponseBody Map<Integer, Integer> test(Model model){
		return shopCarservice.getquantity((Integer) model.getAttribute("id"));
	}
	
	@PostMapping("addToTrackListAjax")
	public @ResponseBody List<Product> addToTrackList(Model model,
			@RequestParam(value = "productId", required = false) Integer productId){
		shopCarservice.addToTrackList((Integer) model.getAttribute("id"), productId);
		return shopCarservice.deleteFromShopCarAjax((Integer) model.getAttribute("id"), productId);
	}
	
	@PostMapping("selectAllFromTrackListAjax")
	public @ResponseBody List<Product> selectAllFromTrackList(Model model){
		return shopCarservice.selectAllFromTrackList((Integer) model.getAttribute("id"));
	}
}
