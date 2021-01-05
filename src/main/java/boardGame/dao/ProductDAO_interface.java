package boardGame.dao;

import java.util.List;
import boardGame.model.Cata1;
import boardGame.model.Cata2;
import boardGame.model.MPmerge;
import boardGame.model.MemberBean;
import boardGame.model.Product;

public interface ProductDAO_interface {

	boolean checkGame(Integer productId);
	Product SearchGame(Integer productId);
	List<Product> SearchGameByE_name(String E_name);
	List<Product> SearchGameByC_name(String C_name);
	List<Product> SearchGameByG_maker(String G_maker);
	List<Product> SearchGameByiss(String iss);
	List<Product> SearchGameByViewCount(Integer ViewCount1,Integer ViewCount2);
	List<Product> SearchGameBydate(Integer date);
	List<Product> SearchGameByStorage(Integer storage1, Integer storage2);
	List<Product> SearchGameByPrice(Integer price1, Integer price2);
	List<Product> searchGameByPage(Integer Page);
	List<Product>SearchGameByCata1(Integer Cata1);
	List<Product>SearchGameByCata2(Integer Cata2);
	List<Product> AdvancedSearch(String E_name,String C_name,String G_maker,String iss,Integer Price,Integer Price1);
	List<Product> AdvancedSearch(String E_name,String C_name,String G_maker,String iss,Integer Price,Integer Price1,List<Product>Cata1, Integer Cata1Size, List<Product>Cata2,Integer Cata2Size);
	List<Product> SearchAllGame();
	List<Product> OrderByConditionAndPage(String Condition,Integer Page);
	List<Product> SearchDLC(Integer productId);
	List<Cata1> FromIdSearchCata1(Integer productId);
	List<Cata2> FromIdSearchCata2(Integer productId);
	Cata1 getCata1ByKeys(Integer keys);
	Cata2 getCata2ByKeys(Integer keys);
	List<Product> ViewCount_analized();
	List<String> GetAllCata1();	
	List<String> GetAllCata2();
	List<Integer> GetGameNumByEachCata1();	
	List<Integer> GetGameNumByEachCata2();	
	void AddMemberHistory(MemberBean memId,Product productId);
	MPmerge getViewCount(MemberBean memId,Product productId);
	int createGame(Product gb);
	int deleteGame(int productId);
	int updateGame(Product p);
	void updateMemberHistory(MPmerge mPmerge);
	void InsertProduct_cata1(Product id,List<Cata1> Cata1);
	void InsertProduct_cata2(Product id,List<Cata2> Cata2);

}