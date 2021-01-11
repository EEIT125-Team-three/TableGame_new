package boardGame.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import boardGame.dao.MemberDAOInterface;
import boardGame.dao.ProductDAO_interface;
import boardGame.dao.shopCarDAO;
import boardGame.dao.trackLikeDao;
import boardGame.model.Cata1;
import boardGame.model.Cata2;
import boardGame.model.MPmerge;
import boardGame.model.MemberBean;
import boardGame.model.Product;
import boardGame.model.TrackList;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	ProductDAO_interface dao;

	@Autowired
	MemberDAOInterface memDao;
	
	@Autowired
	trackLikeDao trackDao;
	
	@Autowired
	shopCarDAO carDao;

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
	public List<Product> AdvancedSearch(String E_name, String C_name, String G_maker, String iss, Integer Price,
			Integer Price1) {
		return dao.AdvancedSearch(E_name, C_name, G_maker, iss, Price, Price1);
	}

	@Transactional
	@Override
	public List<Product> AdvancedSearch_cata(String E_name, String C_name, String G_maker, String iss, Integer Price,
			Integer Price1, List<Integer> Cata1, List<Integer> Cata2) {
		List<Product> finalCata1 = new ArrayList<Product>();
		List<Product> finalCata2 = new ArrayList<Product>();
		if (Cata1.size() > 0) {
			for (Integer i : Cata1) {
				List<Product> list = dao.SearchGameByCata1(i);
				for (Product p : list) {
					finalCata1.add(p);
				}
			}
		}
		if (Cata2.size() > 0) {
			for (Integer i : Cata2) {
				List<Product> list = dao.SearchGameByCata2(i);
				for (Product p : list) {
					finalCata2.add(p);
				}
			}
		}
		return dao.AdvancedSearch(E_name, C_name, G_maker, iss, Price, Price1, finalCata1, Cata1.size(), finalCata2,
				Cata2.size());
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
	public List<Product> SearchGameByViewCount(Integer ViewCount1, Integer ViewCount2) {
		return dao.SearchGameByViewCount(ViewCount1, ViewCount2);
	}

	@Transactional
	@Override
	public List<Product> SearchGameBydate(Integer date) {
		return dao.SearchGameBydate(date);
	}

	@Transactional
	@Override
	public List<Product> SearchGameByStorage(Integer storage1, Integer storage2) {
		return dao.SearchGameByStorage(storage1, storage2);
	}

	@Transactional
	@Override
	public List<Product> SearchGameByPrice(Integer price1, Integer price2) {
		return dao.SearchGameByPrice(price1, price2);
	}

	@Transactional
	@Override
	public List<Product> SearchGameByPage(Integer Page) {
		return dao.searchGameByPage(Page);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	@Override
	public List<String> ViewCount_analized_name() {
		ArrayList<String> name = new ArrayList();
		List<Product> list = dao.ViewCount_analized();
		for (Product p : list) {
			name.add("'" + p.getC_name() + "'");
		}
		System.out.println(name);
		return name;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	@Override
	public List<String> ViewCount_analized_count() {
		ArrayList<String> viewNum = new ArrayList();
		List<Product> list = dao.ViewCount_analized();
		for (Product p : list) {
			viewNum.add("'" + p.getViewCount().toString() + "'");
		}
		System.out.println(viewNum);
		return viewNum;
	}

	@Transactional
	@Override
	public List<Product> SearchGameByCata1(Integer Cata1) {
		return dao.SearchGameByCata1(Cata1);
	}

	@Transactional
	@Override
	public List<Product> SearchGameByCata2(Integer Cata2) {
		return dao.SearchGameByCata1(Cata2);
	}

	@Transactional
	@Override
	public List<Cata1> FromIdSearchCata1(Integer productId) {
		return dao.FromIdSearchCata1(productId);
	}

	@Transactional
	@Override
	public List<Cata2> FromIdSearchCata2(Integer productId) {
		return dao.FromIdSearchCata2(productId);
	}

	@Transactional
	@Override
	public List<Product> OrderByConditionAndPage(String Condition, Integer Page) {
		return dao.OrderByConditionAndPage(Condition, Page);
	}

	@Transactional
	@Override
	public List<Product> SearchDLC(Integer productId) {
		return dao.SearchDLC(productId);
	}

	@Transactional
	@Override
	public void AddMemberHistory(Integer memId, Product productIdBean) {
		MemberBean memBean = memDao.getMember(memId);
		MPmerge mPmerge = dao.getViewCount(memBean, productIdBean);
		if (mPmerge == null) {
			dao.AddMemberHistory(memBean, productIdBean);
		} else {
			dao.updateMemberHistory(mPmerge);
		}
	}

	@Transactional
	@Override
	public List<String> GetAllCata1() {
		ArrayList<String> list = new ArrayList<String>();
		for (String cata1 : dao.GetAllCata1()) {
			list.add("'" + cata1 + "'");
		}
		return list;
	}

	@Transactional
	@Override
	public List<String> GetAllCata2() {
		ArrayList<String> list = new ArrayList<String>();
		for (String cata2 : dao.GetAllCata2()) {
			list.add("'" + cata2 + "'");
		}
		return list;
	}

	@Transactional
	@Override
	public List<Integer> GetGameNumByEachCata1() {
		return dao.GetGameNumByEachCata1();
	}

	@Transactional
	@Override
	public List<Integer> GetGameNumByEachCata2() {
		return dao.GetGameNumByEachCata2();
	}

	@Transactional
	@Override
	public void InsertProduct_cata1(Product id, List<Integer> Cata1) {
		List<Cata1> c1list = new ArrayList<Cata1>();
		for (Integer keys : Cata1) {
			c1list.add(dao.getCata1ByKeys(keys));
		}
		dao.InsertProduct_cata1(id, c1list);

	}

	@Transactional
	@Override
	public void InsertProduct_cata2(Product id, List<Integer> Cata2) {
		List<Cata2> c2list = new ArrayList<Cata2>();
		for (Integer keys : Cata2) {
			c2list.add(dao.getCata2ByKeys(keys));
		}
		dao.InsertProduct_cata2(id, c2list);
	}
	
	@Transactional
	public String checkTrackStatus(Integer memberId, Integer productId) {
		if(shopCarDao.select(memberId, productId) != null) {
			return "已加入";
		}
		else if(trackLikeDao.select(memberId, productId) != null) {
			return "已追蹤";
		}
	}

	
	
}
