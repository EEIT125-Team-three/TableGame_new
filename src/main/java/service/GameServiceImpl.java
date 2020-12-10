package service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductDAO_interface;
import model.Product;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	ProductDAO_interface dao;

	@Autowired
	SessionFactory factory;

	@Override
	public boolean checkGame(int productId) {
		boolean result = false;
		result = dao.checkGame(productId);
		return result;
	}

	@Override
	public Product SearchGame(int productId) {
		Product p = null;
		p = dao.SearchGame(productId);
		return p;
	}

	@Override
	public List<Product> SearchAllGame() {
		List<Product> p = new ArrayList<>();
		p = dao.SearchAllGame();
		return p;
	}

	@Override
	public Integer createGame(Product gb) {
		int count = 0;
		dao.createGame(gb);
		count++;
		return count;
	}

	@Override
	public Integer deleteGame(int productId) {
		int count = 0;
		dao.deleteGame(productId);
		count++;
		return count;
	}

	@Override
	public Integer updateGame(Product p) {
		int count = 0;
		dao.updateGame(p);
		count++;
		return count;
	}

	@Override
	public List<Product> AdvancedSearch(Product p) {
		List<Product> list = new ArrayList<>();
		list = dao.AdvancedSearch(p);
		return list;
	}

	@Override
	public List<Product> SearchGame(String C_name) {
		List<Product> list = new ArrayList<Product>();
		list = dao.SearchGame(C_name);
		return list;
	}

	@Override
	public List<Product> SearchGame1(String G_maker) {
		List<Product> list = new ArrayList<Product>();
		list = dao.SearchGame1(G_maker);
		return list;
	}

	@Override
	public List<Product> SearchGame2(String iss) {
		List<Product> list = new ArrayList<Product>();
		list = dao.SearchGame2(iss);
		return list;
	}

}
