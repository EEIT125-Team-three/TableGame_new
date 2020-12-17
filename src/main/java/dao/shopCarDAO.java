package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.ast.And;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Product;
import model.ShopCar;

@Repository
public class shopCarDAO {
	
	@Autowired
	SessionFactory factory;
	
	public List<ShopCar> selectAll(Integer memberId) {
		return factory.getCurrentSession().createQuery("From ShopCar where mId = " + memberId).getResultList();
	}
	public void insert(ShopCar shopCar) {
		factory.getCurrentSession().save(shopCar);
	}
	public void update(Integer memberId, Integer productId) {
		//明天這裡開始
		factory.getCurrentSession();
	}
}
