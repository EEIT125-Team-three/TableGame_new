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

	@Override
	@SuppressWarnings("unchecked")
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
	public Product SearchGame(int productId) {
		Product gb = null;
		Session session = factory.getCurrentSession();
		gb = session.get(Product.class, productId);
		return gb;

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> SearchGame(String C_name) {
		List<Product> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		String hql = "FROM Product  where C_name like '%" + C_name + "%'";
		Query<Product> query = session.createQuery(hql);
		list = query.getResultList();
		return list;

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> SearchGame1(String G_maker) {
		List<Product> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		String hql = "FROM Product  where G_maker like '%" + G_maker + "%'";
		Query<Product> query = session.createQuery(hql);
		list = query.getResultList();
		return list;

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> SearchGame2(String iss) {
		List<Product> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		String hql = "FROM Product  where iss like '%" + iss + "%'";
		Query<Product> query = session.createQuery(hql);
		list = query.getResultList();
		return list;

	}

	@Override
	@SuppressWarnings("unchecked")
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

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> SearchAllGame() {
		List<Product> list = new ArrayList<>();
		String hql = "FROM Product";
		Session session = factory.getCurrentSession();
		Query<Product> query = session.createQuery(hql);
		list = query.getResultList();
		return list;

	}

	// 建立新的遊戲
	@Override
	public int createGame(Product gb) {
		int count = 0;
		Session session = factory.getCurrentSession();
		session.save(gb);
		count++;
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
