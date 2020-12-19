package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import model.Product;

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
	public List<Product> SearchGameByPage(Integer Page) {
		String hql ="FROM Product";
		Session session = factory.getCurrentSession();
		return session.createQuery(hql).setFirstResult((Page-1)*10).setMaxResults(10).getResultList();
	}




}
