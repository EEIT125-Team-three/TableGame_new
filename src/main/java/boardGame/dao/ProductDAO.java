package boardGame.dao;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.functors.IfClosure;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import boardGame.model.Cata1;
import boardGame.model.Cata2;
import boardGame.model.MPmerge;
import boardGame.model.MemberBean;
import boardGame.model.Product;
import boardGame.model.Product_cata1_merge;
import boardGame.model.Product_cata2_merge;

@Repository
public class ProductDAO implements ProductDAO_interface {

	@Autowired
	SessionFactory factory;

	//確認遊戲是否存在於資料庫中
	@SuppressWarnings("unchecked")
	@Override
	public boolean checkGame(Integer productId) {
		boolean result = false;
		String hql = "FROM GameBean g where g.productId = ?1";
		Session session = factory.getCurrentSession();
		Query<Product> query = session.createQuery(hql);
		List<Product> list = query.setParameter(1, productId).getResultList();
		if (list.size() > 0) {
			result = true;
		}
		return result;
	}
	//依遊戲編號搜尋遊戲
	@Override
	public Product SearchGame(Integer productId) {
		Product gb = null;
		Session session = factory.getCurrentSession();
		gb = session.get(Product.class, productId);
		Integer oldCount = gb.getViewCount();
//		System.out.println(oldCount);
		gb.setViewCount(oldCount + 1);
		return gb;
	}
	//依遊戲英文名稱搜尋遊戲
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchGameByE_name(String E_name) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product  where E_name like '%" + E_name + "%'";
		return session.createQuery(hql).getResultList();

	}
	//依遊戲中文名稱搜尋遊戲
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchGameByC_name(String C_name) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product  where C_name like '%" + C_name + "%'";
		return session.createQuery(hql).getResultList();
	}
	//依遊戲作者搜尋遊戲
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchGameByG_maker(String G_maker) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product  where G_maker like '%" + G_maker + "%'";
		return session.createQuery(hql).getResultList();
	}
	//依遊戲插畫家搜尋遊戲
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchGameByiss(String iss) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product  where iss like '%" + iss + "%'";
		return session.createQuery(hql).getResultList();
	}
	//依瀏覽數區間搜尋遊戲
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchGameByViewCount(Integer ViewCount1, Integer ViewCount2) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product  where viewCount between '" + ViewCount1 + "'and'" + ViewCount2 + "'";
		return session.createQuery(hql).getResultList();
	}
	//依上市日期區間搜尋遊戲
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchGameBydate(Integer date) {

		SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(date);
		Long date_Long = new Long(date);
		Date date_now = new Date();
		Calendar calendar = Calendar.getInstance();
		Long resultTime = date_now.getTime() - date_Long * (24 * 60 * 60 * 1000);
		calendar.setTimeInMillis(resultTime);
		Date date_target = calendar.getTime();
		String date_range_front = bartDateFormat.format(date_target);
		String date_range_back = bartDateFormat.format(date_now);
//		System.out.println("+++++++++++++");
//		System.out.println(date_range_front);
//		System.out.println(date_range_back);
		Session session = factory.getCurrentSession();
		String hql = "FROM Product where date between '" + date_range_front + "' and '" + date_range_back + "'";
		return session.createQuery(hql).getResultList();
	}
	//依庫存數量區間搜尋遊戲
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchGameByStorage(Integer storage1, Integer storage2) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product  where storage between '" + storage1 + "'and'" + storage2 + "'";
		return session.createQuery(hql).getResultList();
	}
	//依價錢區間搜尋遊戲
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchGameByPrice(Integer price1, Integer price2) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product  where Price between '" + price1 + "'and'" + price2 + "'";
		return session.createQuery(hql).getResultList();

	}
	//依遊戲所屬類型搜尋
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchGameByCata1(Integer Cata1) {
		Session session = factory.getCurrentSession();
		String Cata1hql = "FROM Product_cata1_merge where keys = '" + Cata1 + "'";
		List<Product_cata1_merge> cata1list = session.createQuery(Cata1hql).getResultList();
		List<Integer> productIdList = new ArrayList<Integer>();
		List<Product> productList = new ArrayList<Product>();
		for (Product_cata1_merge i : cata1list) {
			productIdList.add(i.getProductId().getProductId());
		}
		for (Integer id : productIdList) {
			productList.add(SearchGame(id));
		}
		return productList;
	}
	//依遊戲所屬科目搜尋
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchGameByCata2(Integer Cata2) {
		Session session = factory.getCurrentSession();
		String Cata2hql = "FROM Product_cata2_merge where keys = '" + Cata2 + "'";
		List<Product_cata2_merge> cata2list = session.createQuery(Cata2hql).getResultList();
		List<Integer> productIdList = new ArrayList<Integer>();
		List<Product> productList = new ArrayList<Product>();
		for (Product_cata2_merge i : cata2list) {
			productIdList.add(i.getProductId().getProductId());
		}
		for (Integer id : productIdList) {
			productList.add(SearchGame(id));
		}
		return productList;
	}
	//進階搜尋，不包含類型及科目
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> AdvancedSearch(String E_name, String C_name, String G_maker, String iss, Integer Price,
			Integer Price1) {
		List<Product> list = new ArrayList<>();
		String hql = "FROM Product ";
		Session session = factory.getCurrentSession();
		if (E_name != "" || C_name != "" || G_maker != "" || iss != "" || (Price != null && Price1 != null)) {
			hql += " where ";
			if ((Price != null && Price1 != null)) {
				hql += " Price between '" + Price + "' and '" + Price1 + "'";
				if (E_name != "") {
					hql += " and E_name like '%" + E_name + "%'";
				}
				if (C_name != "") {
					hql += " and C_name like '%" + C_name + "%'";
				}
				if (G_maker != "") {
					hql += " and G_maker like '%" + G_maker + "%'";
				}
				if (iss != "") {
					hql += " and iss like '%" + iss + "%'";
				}
			}
		}
		System.out.println(hql);
		Query<Product> query = session.createQuery(hql);
		list = query.getResultList();
		return list;
	}
	//進階搜尋，包含類型及科目
	@Override
	public List<Product> AdvancedSearch(String E_name, String C_name, String G_maker, String iss, Integer Price,
			Integer Price1, List<Product> finalCata1, Integer Cata1Size, List<Product> finalCata2, Integer Cata2Size) {

		List<Product> products_fit_cata1 = new ArrayList<Product>();
		List<Product> products_fit_cata2 = new ArrayList<Product>();
		List<Product> products4 = new ArrayList<Product>();
		List<List<Product>> lists = new ArrayList<List<Product>>();
		Integer all;
		Integer i1;
		Integer count;
		System.out.println("+++++++++++");
		// 用cata1去尋找之結果
		if (finalCata1.size() != 0) {
			all = finalCata1.size();
			if (Cata1Size == 1) {
				for (Product p : finalCata1) {
					products_fit_cata1.add(p);
				}
			} else {
				while (all >= Cata1Size) {
					Product p = finalCata1.get(0);
					i1 = p.getProductId();
					count = 1;
					finalCata1.remove(0);
					all -= 1;
					for (int j = 0; j < all; j++) {
						if (i1 == finalCata1.get(j).getProductId()) {
							count += 1;
							all -= 1;
							finalCata1.remove(j);
							j -= 1;
							if (count == Cata1Size) {
								products_fit_cata1.add(p);
								break;
							}
						}
					}
				}
				if(products_fit_cata1.size() == 0) {
					return products4;
				}
			}
		}
		// 用cata2去尋找之結果
		if (finalCata2.size() != 0) {
			all = finalCata2.size();
			if (Cata2Size == 1) {
				for (Product p : finalCata2) {
					products_fit_cata2.add(p);
				}
			} else {
				while (all >= Cata2Size) {
					Product p = finalCata2.get(0);
					i1 = p.getProductId();
					count = 1;
					finalCata2.remove(0);
					all -= 1;
					for (int j = 0; j < all; j++) {
						if (i1 == finalCata2.get(j).getProductId()) {
							count += 1;
							all -= 1;
							finalCata2.remove(j);
							j -= 1;
							if (count == Cata2Size) {
								products_fit_cata2.add(p);
								break;
							}
						}
					}
				}
				if(products_fit_cata2.size() == 0){
					return products4;
				}
			}
		}
		// 用除了cata1和cata2以外的條件查詢的結果
		List<Product> productlist = AdvancedSearch(E_name, C_name, G_maker, iss, Price, Price1);
		if(productlist.size() == 0) {
			return products4;
		}
		lists.add(productlist);
		if (products_fit_cata1.size() > 0) {
			lists.add(products_fit_cata1);
		}
		System.out.println(products_fit_cata1.size());
		if (products_fit_cata2.size() > 0) {
			lists.add(products_fit_cata2);
		}
		switch (lists.size()) {
		case 0:
			return products4;
		case 1:
			return lists.get(0);
		case 2:
			for (Product p1 : lists.get(0)) {
				for (Product p2 : lists.get(1)) {
					if (p1.getProductId() == p2.getProductId()) {
						products4.add(p1);
						break;
					}
				}
			}
			return products4;
		case 3:
			Integer i = new Integer(0);
			for (Product p1 : lists.get(0)) {
				i = p1.getProductId();
				for (Product p2 : lists.get(1)) {
					if (i == p2.getProductId()) {
						for (Product p3 : lists.get(2)) {
							if (i == p3.getProductId()) {
								products4.add(p1);
								break;
							}
						}
					}
				}
			}
			return products4;
		}
		return null;
	}
	//取得所有遊戲
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchAllGame() {
		String hql = "FROM Product";
		Session session = factory.getCurrentSession();
		return session.createQuery(hql).getResultList();
	}

	// 建立新的遊戲
	@Override
	public int createGame(Product gb) {
		System.out.println("2222");
		int count = 0;
		Session session = factory.getCurrentSession();
		session.save(gb);
		count++;
		System.out.println(count);
		return count;
	}

	// 刪除遊戲
	@Override
	public int deleteGame(int productId) {
		int count = 0;
		Session session = factory.getCurrentSession();
		Product p = SearchGame(productId);
		session.delete(p);
		count++;
		return count;
	}

	// 更新遊戲資訊
	@Override
	public int updateGame(Product p) {
		int count = 0;
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(p);
		count++;
		return count;

	}
	//依照分頁之頁數取得當頁面的遊戲
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> searchGameByPage(Integer Page) {
		String hql = "FROM Product";
		Session session = factory.getCurrentSession();
		return session.createQuery(hql).setFirstResult((Page - 1) * 15).setMaxResults(15).getResultList();
	}
	//瀏覽數前10名的遊戲，以長條圖顯示
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> ViewCount_analized() {
		String hql = "FROM Product order by viewCount desc";
		Session session = factory.getCurrentSession();
		return session.createQuery(hql).setMaxResults(10).getResultList();
	}
	//利用遊戲編號抓出其所屬的類型
	@SuppressWarnings("unchecked")
	@Override
	public List<Cata1> FromIdSearchCata1(Integer productId) {
		List<Cata1> cata1 = new ArrayList<Cata1>();
		Session session = factory.getCurrentSession();
		String hql = "FROM Product_cata1_merge where productId = '" + productId + "'";
		List<Product_cata1_merge> resultlist = session.createQuery(hql).getResultList();
		for (Product_cata1_merge p : resultlist) {
			cata1.add(p.getKeys());
		}
		return cata1;
	}
	//利用遊戲編號抓出其所屬的科目
	@SuppressWarnings("unchecked")
	@Override
	public List<Cata2> FromIdSearchCata2(Integer productId) {
		List<Cata2> cata2 = new ArrayList<Cata2>();
		Session session = factory.getCurrentSession();
		String hql = "FROM Product_cata2_merge where productId = '" + productId + "'";
		List<Product_cata2_merge> resultlist = session.createQuery(hql).getResultList();
		for (Product_cata2_merge p : resultlist) {
			cata2.add(p.getKeys());
		}
		return cata2;
	}
	//變更頁面顯示排序
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> OrderByConditionAndPage(String Condition, Integer Page) {
		String hql = "FROM Product order by " + Condition;
		Session session = factory.getCurrentSession();
		return session.createQuery(hql).setFirstResult((Page - 1) * 15).setMaxResults(15).getResultList();
	}
	//搜尋目標商品相關的周邊商品
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchDLC(Integer productId) {
		String hql = "FROM DLC where productId = " + productId;
		Session session = factory.getCurrentSession();
		return session.createQuery(hql).getResultList();
	}
	//當前帳號瀏覽紀錄的建立
	@Override
	public void AddMemberHistory(MemberBean memId, Product productId) {
		MPmerge history = new MPmerge(memId, productId, 1);
		Session session = factory.getCurrentSession();
		session.save(history);
	}
	//取得當前帳號瀏覽同產品的總次數
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public MPmerge getViewCount(MemberBean memId, Product productId) {
		String hql = "FROM MPmerge where productId = ?1 and memId = ?2";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(1, productId).setParameter(2, memId);
		List<MPmerge> list = query.getResultList();
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	//更新同帳號對同產品的瀏覽次數
	@Override
	public void updateMemberHistory(MPmerge mPmerge) {
		mPmerge.setViewCount(mPmerge.getViewCount() + 1);
		factory.getCurrentSession().save(mPmerge);
	}
	//取得所有類型
	@SuppressWarnings("unchecked")
	@Override
	public List<String> GetAllCata1() {
		List<String>cata1list = new ArrayList<String>();
		String hql = "FROM Cata1 ";
		Session session = factory.getCurrentSession();
		List<Cata1>list=session.createQuery(hql).getResultList();
		for(Cata1 cata1:list) {
			cata1list.add(cata1.getCata1());
		}
		return cata1list;
	}
	//取的所有科目
	@SuppressWarnings("unchecked")
	@Override
	public List<String> GetAllCata2() {
		List<String>cata2list = new ArrayList<String>();
		String hql = "FROM Cata2 ";
		Session session = factory.getCurrentSession();
		List<Cata2>list=session.createQuery(hql).getResultList();
		for(Cata2 cata2:list) {
			cata2list.add(cata2.getCata2());
		}
		return cata2list;
	}
	//取得每個類型的遊戲數量
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> GetGameNumByEachCata1() {
		Session session = factory.getCurrentSession();
		List<Integer>cata1gamelist = new ArrayList<Integer>();
		List<Integer>cata1keyslist = new ArrayList<Integer>();
		List<Cata1>cata1=session.createQuery("FROM Cata1").getResultList();
		for(Cata1 cata1bean:cata1) {
			cata1keyslist.add(cata1bean.getKeys());
		}
		for(Integer i :cata1keyslist) {
			String hql = "FROM Product_cata1_merge where keys = '"+i+"'";
			Integer ans = session.createQuery(hql).getResultList().size();
			cata1gamelist.add(ans);
		}
		return cata1gamelist;
	}
	//取得每個科目的遊戲數量
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> GetGameNumByEachCata2() {
		Session session = factory.getCurrentSession();
		List<Integer>cata2gamelist = new ArrayList<Integer>();
		List<Integer>cata2keyslist = new ArrayList<Integer>();
		List<Cata2>cata2=session.createQuery("FROM Cata2").getResultList();
		for(Cata2 cata2bean:cata2) {
			cata2keyslist.add(cata2bean.getKeys());
		}
		for(Integer i :cata2keyslist) {
			String hql = "FROM Product_cata2_merge where keys = '"+i+"'";
			Integer ans = session.createQuery(hql).getResultList().size();
			cata2gamelist.add(ans);
		}
		return cata2gamelist;
	}
	//新增遊戲類型
	@Override
	public void InsertProduct_cata1(Product id, List<Cata1> Cata1) {
		Session session = factory.getCurrentSession();
		for(Cata1 i:Cata1) {
			Product_cata1_merge p1=new Product_cata1_merge();
			p1.setProductId(id);
			p1.setKeys(i);
			session.save(p1);
		}		
	}
	//新增遊戲科目
	@Override
	public void InsertProduct_cata2(Product id, List<Cata2> Cata2) {
		Session session = factory.getCurrentSession();
		for(Cata2 i:Cata2) {
			Product_cata2_merge p2=new Product_cata2_merge();
			p2.setProductId(id);
			p2.setKeys(i);
			session.save(p2);		
	}
}
	//透過數字keys取得該筆cata1
	@Override
	public Cata1 getCata1ByKeys(Integer keys) {
		String hql = "FROM Cata1 where keys = '"+keys+"'";
		Session session = factory.getCurrentSession();
		return (Cata1) session.createQuery(hql).getSingleResult();
		}
	//透過數字keys取得該筆cata2
	@Override
	public Cata2 getCata2ByKeys(Integer keys) {
		String hql = "FROM Cata2 where keys = '"+keys+"'";
		Session session = factory.getCurrentSession();
		return (Cata2) session.createQuery(hql).getSingleResult();
	}
	
	//庫存調整
	@Override
	public void updateStorage(Product product, Integer changeNum) {
		Integer nowStorage =  product.getStorage();
		product.setStorage(nowStorage+changeNum);
		factory.getCurrentSession().save(product);
	}
}
