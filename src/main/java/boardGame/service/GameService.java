package boardGame.service;

import java.util.List;
import boardGame.model.Cata1;
import boardGame.model.Cata2;
import boardGame.model.Product;

public interface GameService {

	boolean checkGame(int productId);
	Product SearchGame(Integer productId);
	List<Product> SearchGameByE_name(String E_name);
	List<Product> SearchGameByC_name(String C_name);
	List<Product> SearchGameByG_maker(String G_maker);
	List<Product> SearchGameByiss(String iss);
	List<Product> SearchGameByViewCount(String ViewCount);
	List<Product> SearchGameBydate(Integer date);
	List<Product> SearchGameByStorage(Integer storage1,Integer storage2);
	List<Product> SearchGameByPrice(String price);
	List<Product> SearchGameByPage(Integer Page);
	List<Product>SearchGameByCata1(Integer Cata1);
	List<Product>SearchGameByCata2(Integer Cata2);
	List<Product> SearchAllGame();
	List<Product> AdvancedSearch(String E_name,String C_name,String G_maker,String iss,Integer Price,Integer Price1);
	List<Product> AdvancedSearch_cata(String E_name,String C_name,String G_maker,String iss,Integer Price,Integer Price1,List<Integer>Cata1,List<Integer>Cata2);
	List<Product> OrderByConditionAndPage(String Condition,Integer Page);
	List<Product> SearchDLC(Integer productId);
	List<Cata1> FromIdSearchCata1(Integer productId);
	List<Cata2> FromIdSearchCata2(Integer productId);
	List<String> ViewCount_analized_name();
	List<String> ViewCount_analized_count();	
	List<String> GetAllCata1();	
	List<String> GetAllCata2();	
	List<Integer> GetGameNumByEachCata1();	
	List<Integer> GetGameNumByEachCata2();	
	Integer createGame(Product gb);
	Integer deleteGame(int productId);
	Integer updateGame(Product p);
	void AddMemberHistory(Integer memId, Product productIdBean);
	void InsertProduct_cata1(Product id,List<Integer> Cata1);
	void InsertProduct_cata2(Product id,List<Integer> Cata2);
}