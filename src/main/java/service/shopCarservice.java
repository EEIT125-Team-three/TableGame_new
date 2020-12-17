package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.Case;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import dao.MemberDAO;
import dao.ProductDAO_interface;
import dao.shopCarDAO;
import model.MemberBean;
import model.Product;
import model.ShopCar;

@Controller
public class shopCarservice{
	@Autowired
	ProductDAO_interface productDao;
	@Autowired
	shopCarDAO shopCarDao;
	@Autowired
	MemberDAO memberDao;
	@Transactional
	public List<Product> getData(String doWhich, Integer show, Integer  buyHowmuch, Integer memberId, Integer productId) {
		List<Product> products = new ArrayList<Product>();
		switch (show) {
			case -1:
				return productDao.SearchAllGame();
			case 0:
				switch (doWhich) {
					case "":
						List<ShopCar> lShopCar = shopCarDao.selectAll(memberId);
						for(ShopCar s : lShopCar) {
							products.add(s.getpId());
						}
						return products;
					case "insert":
						Product product = productDao.SearchGame(productId);
						shopCarDao.insert(new ShopCar(product, memberDao.getMember(memberId), buyHowmuch, "N"));
						products.add(product);
						return products;
					case "update":
						shopCarDao.update(memberId, productId);
						return null;
				}
			case 1:
				break;
			case 2:
				break;
		}
		return null;
	}
}
