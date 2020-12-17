package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.internal.ast.HqlASTFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Product;
import model.ShopCar;

@Repository
public class shopCarDAO {
	
	@Autowired
	SessionFactory factory;
	
	public List<Product> selectAll(Integer memberId) {
		List<ShopCar> lShopCar = factory.getCurrentSession().createQuery("From ShopCar where mId = " + memberId).getResultList();
		List<Product> products = new ArrayList<Product>();
		Session session = factory.getCurrentSession();
		for(ShopCar s : lShopCar) {
			products.add(session.get(Product.class, s.getpId()));
		}
		return products;
	}
}
