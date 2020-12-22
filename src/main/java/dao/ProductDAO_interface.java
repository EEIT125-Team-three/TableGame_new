package dao;

import java.util.List;

import model.Product;

public interface ProductDAO_interface {

	boolean checkGame(Integer productId);

	Product SearchGame(Integer productId);
	List<Product> SearchGameByE_name(String E_name);
	List<Product> SearchGameByC_name(String C_name);
	List<Product> SearchGameByG_maker(String G_maker);
	List<Product> SearchGameByiss(String iss);
	List<Product> SearchGameByViewCount(Integer ViewCount1,Integer ViewCount2);
	List<Product> SearchGameBydate(String date);
	List<Product> SearchGameByStorage(Integer storage1, Integer storage2);
	List<Product> SearchGameByPrice(Integer price1, Integer price2);
	List<Product> searchGameByPage(Integer Page);
	List<Product> AdvancedSearch(String E_name,String C_name,String G_maker,String iss,Integer Price,Integer Price1);
	List<Product> SearchAllGame();

	List<Product> ViewCount_analized();

	
	// 建立新的遊戲
	int createGame(Product gb);

	// 刪除遊戲
	int deleteGame(int productId);

	// 更新遊戲資訊
	int updateGame(Product p);

}