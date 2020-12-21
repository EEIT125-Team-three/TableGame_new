package service;

import java.util.List;

import model.Product;

public interface GameService {

	boolean checkGame(int productId);

	Product SearchGame(Integer productId);
	List<Product> SearchGameByE_name(String E_name);
	List<Product> SearchGameByC_name(String C_name);
	List<Product> SearchGameByG_maker(String G_maker);
	List<Product> SearchGameByiss(String iss);
	List<Product> SearchGameByViewCount(Integer ViewCount1,Integer ViewCount2);
	List<Product> SearchGameBydate(String date);
	List<Product> SearchGameByStorage(Integer storage1,Integer storage2);
	List<Product> SearchGameByPrice(Integer price1,Integer price2);
	List<Product> SearchGameByPage(Integer Page);
	List<Product> SearchAllGame();
	List<Product> AdvancedSearch(String E_name,String C_name,String G_maker,String iss,Integer Price,Integer Price1);


	List<String> ViewCount_analized_name();
	List<String> ViewCount_analized_count();
	
	Integer createGame(Product gb);

	Integer deleteGame(int productId);

	Integer updateGame(Product p);
}