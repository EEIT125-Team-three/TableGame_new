package service;

import java.util.List;

import model.Product;

public interface GameService {

	boolean checkGame(int productId);

	Product SearchGame(int productId);
	List<Product> SearchGame(String C_name);
	List<Product> SearchGame1(String G_maker);
	List<Product> SearchGame2(String iss);

	List<Product> SearchAllGame();

	List<Product> AdvancedSearch(Product p);

	Integer createGame(Product gb);

	Integer deleteGame(int productId);

	Integer updateGame(Product p);
}