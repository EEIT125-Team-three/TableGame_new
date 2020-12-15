package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
	public List<Product> AdvancedSearch(Product p) {
		List<Product> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		String hql = "FROM Product  where productId = ?1 and E_name = ?2 and C_name = ?3 and G_maker = ?4 and Price = ?5 and date = ?6 and img_url = ?7 and info = ?8 and iss = ?9 and viewCount = ?10 and storage = ?11";
		Query<Product> query = session.createQuery(hql);
		query.setParameter(1, p.getProductId());
		query.setParameter(2, p.getE_name());
		query.setParameter(3, p.getC_name());
		query.setParameter(4, p.getG_maker());
		query.setParameter(5, p.getPrice());
		query.setParameter(6, p.getDate());
		query.setParameter(7, p.getImg_url());
		query.setParameter(8, p.getInfo());
		query.setParameter(9, p.getIss());
		query.setParameter(10, p.getViewCount());
		query.setParameter(11, p.getStorage());

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




}
