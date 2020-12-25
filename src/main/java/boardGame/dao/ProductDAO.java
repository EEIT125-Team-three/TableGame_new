package boardGame.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import boardGame.model.Product;
import boardGame.model.Product_cata1_merge;
import boardGame.model.Product_cata2_merge;

@Repository
public class ProductDAO implements ProductDAO_interface {

	@Autowired
	SessionFactory factory;

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

	@Override
	public Product SearchGame(Integer productId) {
		Product gb = null;
		Session session = factory.getCurrentSession();
		gb = session.get(Product.class, productId);
		return gb;

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchGameByE_name(String E_name) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product  where E_name like '%" + E_name + "%'";
		return session.createQuery(hql).getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchGameByC_name(String C_name) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product  where C_name like '%" + C_name + "%'";
		return session.createQuery(hql).getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchGameByG_maker(String G_maker) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product  where G_maker like '%" + G_maker + "%'";
		return session.createQuery(hql).getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchGameByiss(String iss) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product  where iss like '%" + iss + "%'";
		return session.createQuery(hql).getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchGameByViewCount(Integer ViewCount1, Integer ViewCount2) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product  where viewCount between '" + ViewCount1 + "'and'"+ViewCount2+"'";
		return session.createQuery(hql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchGameBydate(String date) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product where date = '"+date+"'";
		return session.createQuery(hql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchGameByStorage(Integer storage1, Integer storage2) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product  where storage between '" + storage1 + "'and'"+storage2+"'";
		return session.createQuery(hql).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchGameByPrice(Integer price1, Integer price2) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product  where Price between '" + price1 + "'and'"+price2+"'";
		return session.createQuery(hql).getResultList();

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchGameByCata1(Integer Cata1) {
		Session session=factory.getCurrentSession();
		String Cata1hql="FROM Product_cata1_merge where Keys = '"+Cata1+"'";
		List<Product_cata1_merge>cata1list = session.createQuery(Cata1hql).getResultList();
		List<Integer> productIdList=new ArrayList<Integer>();
		List<Product> productList = new ArrayList<Product>();
		for (Product_cata1_merge i : cata1list) {
			productIdList.add(i.getProductId());
		}
		for(Integer id : productIdList) {
			productList.add(SearchGame(id));
		}
		return productList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> SearchGameByCata2(Integer Cata2) {
		Session session=factory.getCurrentSession();
		String Cata2hql="FROM Product_cata2_merge where Keys = '"+Cata2+"'";
		List<Product_cata2_merge>cata2list = session.createQuery(Cata2hql).getResultList();
		List<Integer> productIdList=new ArrayList<Integer>();
		List<Product> productList = new ArrayList<Product>();
		for (Product_cata2_merge i : cata2list) {
			productIdList.add(i.getProductId());
		}
		for(Integer id : productIdList) {
			productList.add(SearchGame(id));
		}
		return productList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> AdvancedSearch(String E_name,String C_name,String G_maker,String iss,Integer Price,Integer Price1) {
		List<Product> list = new ArrayList<>();
		String hql = "FROM Product ";
		Session session = factory.getCurrentSession();
		if(E_name != "" || C_name != "" || G_maker != "" || iss !="" || (Price!=null && Price1!=null)) {
			hql +=" where ";
			if((Price!=null && Price1!=null)) {
				hql +=" Price between '"+Price+"' and '"+Price1+"'";					
					if(E_name != "") {hql +=" and E_name like '%"+E_name+"%'";}
					if(C_name != "") {hql +=" and C_name like '%"+C_name+"%'";}
					if(G_maker != "") {hql +=" and G_maker like '%"+G_maker+"%'";}
					if(iss != "") {hql +=" and iss like '%"+iss+"%'";}	
					}
		}
		System.out.println(hql);
		Query<Product> query = session.createQuery(hql);

		list = query.getResultList();
		return list;

	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Product> AdvancedSearch(String E_name, String C_name, String G_maker, String iss, Integer Price,
			Integer Price1, List<Integer> Cata1, List<Integer> Cata2) {
		String hql = "FROM Product ";		
		Session session=factory.getCurrentSession();
		List<Product>productlist=new ArrayList<Product>();
		List<Product>products_fit_cata1 = new ArrayList<Product>();
		List<Product>products_fit_cata2 = new ArrayList<Product>();
		List<Product_cata1_merge>cata1list = new ArrayList<Product_cata1_merge>();
		List<Product_cata2_merge>cata2list = new ArrayList<Product_cata2_merge>();
		List<Product>products_compare_result_cata1 = new ArrayList<Product>();
		List<Product>products_compare_result_cata2 = new ArrayList<Product>();
		List<Product>products_compare_result_both = new ArrayList<Product>();

		System.out.println("+++++++++++");	
			if(Cata1 != null || Cata2 !=null) {
				//用cata1去尋找之結果
				if(Cata1 !=null) {
//					for(Integer cata1:Cata1) {
						
						String Cata1hql="FROM Product_cata1_merge where Keys in ?1";
						Query query = session.createQuery(Cata1hql);
						query.setParameter(1, Cata1);
						
//						List<Integer> productIdList_cata1=new ArrayList<Integer>();				
						cata1list = query.getResultList();
						System.out.println(cata1list.size());
//						for (Product_cata1_merge i : cata1list) {
//							productIdList_cata1.add(i.getProductId());
//						}
						for (Product_cata1_merge id : cata1list) {
							products_fit_cata1.add(SearchGame(id.getProductId()));
						}
//					}
				}
				//用cata2去尋找之結果
				if(Cata2 != null) {
//					for(Integer cata2:Cata2) {
						
						String Cata2hql="FROM Product_cata2_merge where Keys in ?2 ";
						Query query = session.createQuery(Cata2hql);
						query.setParameter(2, Cata2);
						
//						List<Integer> productIdList_cata2=new ArrayList<Integer>();
						cata2list = query.getResultList();
						System.out.println(cata2list.size());
//						for (Product_cata2_merge i : cata2list) {
//							productIdList_cata2.add(i.getProductId());
//						}
						for (Product_cata2_merge id : cata2list) {
							products_fit_cata2.add(SearchGame(id.getProductId()));
						}
//					}
				}				
			}
			//用除了cata1及cata2之外的條件尋找之結果
			if(E_name != "" || C_name != "" || G_maker != "" || iss !="" || (Price!=null && Price1!=null)) {
				hql +=" where ";
				if((Price!=null && Price1!=null)) {
					hql +=" Price between '"+Price+"' and '"+Price1+"'";					
						if(E_name != "") {hql +=" and E_name like '%"+E_name+"%'";}
						if(C_name != "") {hql +=" and C_name like '%"+C_name+"%'";}
						if(G_maker != "") {hql +=" and G_maker like '%"+G_maker+"%'";}
						if(iss != "") {hql +=" and iss like '%"+iss+"%'";}	
						}
			}
			System.out.println(hql);
			productlist = session.createQuery(hql).getResultList();
			System.out.println(productlist.size());
			
			List<Integer>cata1_id_list = new ArrayList<Integer>();
			List<Integer>cata2_id_list = new ArrayList<Integer>();
			List<Integer>product_id_list = new ArrayList<Integer>();
			for(Product p : products_fit_cata1) {
				cata1_id_list.add(p.getProductId());
			}
			for(Product p : products_fit_cata2) {
				cata2_id_list.add(p.getProductId());
			}
			for(Product p : productlist) {
				product_id_list.add(p.getProductId());
			}
			System.out.println(cata1_id_list);
			System.out.println(cata2_id_list);
			System.out.println(product_id_list);
			Collection all = new ArrayList<Integer>(product_id_list);
			Collection all2 = new ArrayList<Integer>(product_id_list);
			Collection cata1=new ArrayList<Integer>(cata1_id_list);
			Collection cata2=new ArrayList<Integer>(cata2_id_list);
			
			if(all.size()>cata1.size() && all.size()>cata2.size()) {
				all.retainAll(cata1);				
				all2.retainAll(cata2);
				all2.retainAll(all);
				for(Object id : all2.toArray()) {
					products_compare_result_both.add(SearchGame((Integer)id));
				}
				return products_compare_result_both;
			}
			
			System.out.println(all.size());	//intersaction between all and cata1
			System.out.println(all2.size());	//intersaction between all and cata2
			System.out.println(all2.size());	//intersaction between all and cata1 and cata2
			System.out.println(all2);	//intersaction between all and cata1 and cata2
			return productlist;
	}
					

//						for(Product cata2p :products_fit_cata2) {
//							if(p.getProductId()==cata2p.getProductId()) {
//								products_compare_result_cata2.add(cata2p);
//							}return products_compare_result_cata2;
//						}
//					
//
//						for(Product cata1p : products_fit_cata1) {
//							for(Product cata2p :products_fit_cata2) {
//								if(p.getProductId() == cata1p.getProductId() && p.getProductId()==cata2p.getProductId()) {
//									products_compare_result_both.add(p);
//								}return products_compare_result_both;
//							}
//						}
//						
//				}				
//			return productlist;
		
	

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
		Product p = new Product();
		p.setProductId(productId);
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> searchGameByPage(Integer Page) {
		String hql ="FROM Product";
		Session session = factory.getCurrentSession();
		return session.createQuery(hql).setFirstResult((Page-1)*15).setMaxResults(15).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> ViewCount_analized() {
		String hql="FROM Product order by viewCount desc";
		Session session = factory.getCurrentSession();
		return session.createQuery(hql).setMaxResults(10).getResultList();
	}









}
