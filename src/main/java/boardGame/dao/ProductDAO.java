package boardGame.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import boardGame.model.Cata1;
import boardGame.model.Cata2;
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
		String Cata1hql="FROM Product_cata1_merge where keys = '"+Cata1+"'";
		List<Product_cata1_merge>cata1list = session.createQuery(Cata1hql).getResultList();
		List<Integer> productIdList=new ArrayList<Integer>();
		List<Product> productList = new ArrayList<Product>();
		for (Product_cata1_merge i : cata1list) {
			productIdList.add(i.getProductId().getProductId());
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
		String Cata2hql="FROM Product_cata2_merge where keys = '"+Cata2+"'";
		List<Product_cata2_merge>cata2list = session.createQuery(Cata2hql).getResultList();
		List<Integer> productIdList=new ArrayList<Integer>();
		List<Product> productList = new ArrayList<Product>();
		for (Product_cata2_merge i : cata2list) {
			productIdList.add(i.getProductId().getProductId());
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
	
	@Override
	public List<Product> AdvancedSearch(String E_name,String C_name,String G_maker,String iss,Integer Price,Integer Price1, List<Product> finalCata1,Integer Cata1Size,  List<Product> finalCata2,Integer Cata2Size) {

		List<Product>products_fit_cata1 = new ArrayList<Product>();
		List<Product>products_fit_cata2 = new ArrayList<Product>();
		List<Product>products4 = new ArrayList<Product>();
		List<List<Product>>lists = new ArrayList<List<Product>>();
		Integer all;
		Integer i1;
		Integer count;

		System.out.println("+++++++++++");	
				//用cata1去尋找之結果
				if(finalCata1.size() !=0) {
						all = finalCata1.size();
						if(Cata1Size == 1) {
							for(Product p : finalCata1) {
								products_fit_cata1.add(p);
							}
						}else {
							while(all >= Cata1Size) {
								Product p = finalCata1.get(0);
								i1 = p.getProductId();
								count = 1;
								finalCata1.remove(0);
								all -= 1;
								for(int j = 0; j < all; j++) {
									if(i1 == finalCata1.get(j).getProductId()) {
										count += 1;
										all -= 1;
										finalCata1.remove(j);
										j -= 1;
										if(count == Cata1Size) {
											products_fit_cata1.add(p);
											break;
										}
									}
								}
							}
						}
				}			
				//用cata2去尋找之結果
				if(finalCata2.size() != 0) {
						all = finalCata2.size();
						if(Cata2Size == 1) {
							for(Product p : finalCata2) {
								products_fit_cata2.add(p);
							}
						}else {
							while(all >= Cata2Size) {
								Product p = finalCata2.get(0);
								i1 = p.getProductId();
								count = 1;
								finalCata2.remove(0);
								all -= 1;
								for(int j = 0; j < all; j++) {
									if(i1 == finalCata2.get(j).getProductId()) {
										count += 1;
										all -= 1;
										finalCata2.remove(j);
										j -= 1;
										if(count == Cata2Size) {
											products_fit_cata2.add(p);
											break;
										}
									}
								}
							}
						}
				}
				//用除了cata1和cata2以外的條件查詢的結果
			List<Product>productlist = AdvancedSearch(E_name, C_name, G_maker, iss, Price, Price1);
			lists.add(productlist);
			
			if(products_fit_cata1.size()>0) {
				lists.add(products_fit_cata1);
			}
			System.out.println(products_fit_cata1.size());
			if(products_fit_cata2.size()>0) {
				lists.add(products_fit_cata2);
			}
			
			switch (lists.size()) {
			case 0:
				return products4;
			case 1:
				return lists.get(0);
			case 2:
				for(Product p1:lists.get(0)) {
					for(Product p2:lists.get(1)) {
						if(p1.getProductId()==p2.getProductId()) {
							products4.add(p1);
							break;
						}
					}
				}
				return products4;
			case 3:
				Integer i =new Integer(0);
				for(Product p1:lists.get(0)) {
					i = p1.getProductId();
					for(Product p2:lists.get(1)) {
						if(i==p2.getProductId()) {
							for(Product p3:lists.get(2)) {
								if(i==p3.getProductId()) {
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Cata1> FromIdSearchCata1(Integer productId) {
		List<Cata1>cata1 = new ArrayList<Cata1>();
		Session session = factory.getCurrentSession();
		String hql="FROM Product_cata1_merge where productId = '"+productId+"'";
		List<Product_cata1_merge>resultlist = session.createQuery(hql).getResultList();
		for(Product_cata1_merge p:resultlist) {
			cata1.add(p.getKeys());
		}
		return cata1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cata2> FromIdSearchCata2(Integer productId) {
		List<Cata2>cata2 = new ArrayList<Cata2>();
		Session session = factory.getCurrentSession();
		String hql="FROM Product_cata2_merge where productId = '"+productId+"'";
		List<Product_cata2_merge>resultlist = session.createQuery(hql).getResultList();
		for(Product_cata2_merge p:resultlist) {
			cata2.add(p.getKeys());
		}
		return cata2;
	}









}
