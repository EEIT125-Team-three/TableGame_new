package dao;

import java.util.List;

import model.Product;

public interface ProductDAO_interface {

	boolean checkGame(Integer productId);

	Product SearchGame(int productId);

	List<Product> SearchGame(String C_name);

	List<Product> SearchGame1(String G_maker);

	List<Product> SearchGame2(String iss);

	List<Product> AdvancedSearch(Product p);

	List<Product> SearchAllGame();

	// 建立新的遊戲
	int createGame(Product gb);

	// 刪除遊戲
	int deleteGame(int productId);

	// 更新遊戲資訊
	int updateGame(Product p);

}