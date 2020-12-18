package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.Case;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import dao.ProductDAO_interface;
import dao.shopCarDAO;
import model.Product;

@Controller
public class shopCarservice{
	@Autowired
	ProductDAO_interface productDao;
	@Autowired
	shopCarDAO shopCarDao;
	@Transactional
	public List<Product> getData(String doWhich, Integer show, Integer  buyHowmuch, Integer memberId, Integer productId) {
		switch (show) {
			case -1:
				return productDao.SearchAllGame();
			case 0:
				switch (doWhich) {
					case "":
						return shopCarDao.selectAll(memberId);
				}
			case 1:
				break;
			case 2:
				break;
		}
		return null;
	}
}
