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
	public Product SearchGame(int productId) {
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
	public List<Product> AdvancedSearch(Product p) {
		return dao.AdvancedSearch(p);
	}

	@Transactional
	@Override
	public List<Product> SearchGame(String C_name) {
		return dao.SearchGame(C_name);
	}

	@Transactional
	@Override
	public List<Product> SearchGame1(String G_maker) {
		return dao.SearchGame1(G_maker);
	}

	@Transactional
	@Override
	public List<Product> SearchGame2(String iss) {
		return dao.SearchGame2(iss);
	}

}
