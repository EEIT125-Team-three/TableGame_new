package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Product;
import service.shopCarservice;

@Controller
public class shopCarController {
	@Autowired
	shopCarservice shopCarservice;
	
	@PostMapping("shopCarajax")
	public @ResponseBody List<Product> test(
			@RequestParam(value = "show", required = false) Integer show,
			@RequestParam(value = "doWhich", required = false) String doWhich,
			@RequestParam(value = "member", required = false) Integer member,
			@RequestParam(value = "buyHowmuch", required = false) Integer buyHowmuch,
			@RequestParam(value = "product", required = false) Integer product
			){
		return shopCarservice.getData(doWhich, show, buyHowmuch, member, product);
	}
}
