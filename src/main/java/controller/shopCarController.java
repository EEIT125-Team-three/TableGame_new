package controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.Product;
import model.ShopCar;
import service.shopCarservice;

@Controller
@SessionAttributes({"id"})
public class shopCarController {
	@Autowired
	shopCarservice shopCarservice;
	
	@PostMapping("shopCarajax")
	public @ResponseBody List<Product> test(
			@RequestParam(value = "show", required = false) Integer show,
			@RequestParam(value = "doWhich", required = false) String doWhich,
			Model model,
			@RequestParam(value = "buyHowmuch", required = false) Integer buyHowmuch,
			@RequestParam(value = "productId", required = false) Integer productId
			){
		return shopCarservice.getData(doWhich, show, buyHowmuch, (Integer) model.getAttribute("id"), productId);
	}
	@PostMapping("shopCarajaxquantity")
	public @ResponseBody Map<Integer, Integer> test(Model model){
		return shopCarservice.getquantity((Integer) model.getAttribute("id"));
	}
}
