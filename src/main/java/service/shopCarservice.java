package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.Case;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import dao.ProductDAO_interface;
import model.Product;

@Controller
public class shopCarservice{
	@Autowired
	ProductDAO_interface dao;
	
	@Transactional
	public List<Product> getData(String doWhich, Integer show, Integer  buyHowmuch, Integer member, Integer product) {
		switch (show) {
			case -1:
					return dao.SearchAllGame();
			case 1:
				break;
			case 2:
				break;
		}
		return null;
	}
}
