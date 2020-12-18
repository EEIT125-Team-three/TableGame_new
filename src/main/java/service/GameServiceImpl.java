package service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ProductDAO_interface;
import model.Product;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	ProductDAO_interface dao;

	@Transactional
	@Override
	public boolean checkGame(int productId) {
		boolean result = false;
		result = dao.checkGame(productId);
		return result;
	}

	@Transactional
	@Override
	public Product SearchGame(Integer productId) {
		Product p = null;
		p = dao.SearchGame(productId);
		return p;
	}

	@Transactional
	@Override
	public List<Product> SearchAllGame() {
		return dao.SearchAllGame();
	}

	@Transactional
	@Override
	public Integer createGame(Product gb) {
		System.out.println("1111");
		int count = 0;
		dao.createGame(gb);
		count++;
		return count;
	}

	@Transactional
	@Override
	public Integer deleteGame(int productId) {
		int count = 0;
		int result = dao.deleteGame(productId);
		if (result > 0) {
			count++;
		}
		return count;
	}

	@Transactional
	@Override
	public Integer updateGame(Product p) {
		int count = 0;
		int result = dao.updateGame(p);
		if (result > 0) {
			count++;
		}
		return count;
	}

	@Transactional
	@Override
	public List<Product> AdvancedSearch(String E_name,String C_name,String G_maker,String iss,Integer Price,Integer Price1) {
		return dao.AdvancedSearch(E_name,C_name,G_maker,iss,Price,Price1);
	}

	@Transactional
	@Override
	public List<Product> SearchGameByE_name(String E_name) {	
		return dao.SearchGameByE_name(E_name);
	}
	@Transactional
	@Override
	public List<Product> SearchGameByC_name(String C_name) {
		return dao.SearchGameByC_name(C_name);
	}

	@Transactional
	@Override
	public List<Product> SearchGameByG_maker(String G_maker) {
		return dao.SearchGameByG_maker(G_maker);
	}

	@Transactional
	@Override
	public List<Product> SearchGameByiss(String iss) {
		return dao.SearchGameByiss(iss);
	}
	@Transactional
	@Override
	public List<Product> SearchGameByViewCount(Integer ViewCount1,Integer ViewCount2) {
		return dao.SearchGameByViewCount(ViewCount1,ViewCount2);
	}
	@Transactional
	@Override
	public List<Product> SearchGameBydate(String date) {
		return dao.SearchGameBydate(date);
	}
	@Transactional
	@Override
	public List<Product> SearchGameByStorage(Integer storage1, Integer storage2) {
		return dao.SearchGameByStorage(storage1,storage2);
	}
	@Transactional
	@Override
	public List<Product> SearchGameByPrice(Integer price1, Integer price2) {
		return dao.SearchGameByPrice(price1,price2);
	}




}
