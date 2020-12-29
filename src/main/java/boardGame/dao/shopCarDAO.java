package boardGame.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import boardGame.model.ShopCar;

@Repository
public class shopCarDAO {
	
	@Autowired
	SessionFactory factory;
	
	public List<ShopCar> selectAll(Integer memberId) {
		return factory.getCurrentSession().createQuery("From ShopCar where mId = " + memberId + " and transactionType = 'N'").list();
	}
	public void insert(ShopCar shopCar) {
		factory.getCurrentSession().save(shopCar);
	}
	public void update(Integer memberId, Integer productId, Integer buyHowmuch) {
		Session session = factory.getCurrentSession();
		ShopCar shopCar = (ShopCar)session.createQuery("From ShopCar where mId = " + memberId + " and pId = " + productId + "and transactionType = 'N'").list().get(0);
		shopCar.setQuantity(buyHowmuch);
	}
	public void delete(Integer memberId, Integer productId) {
		factory.getCurrentSession().createQuery("delete ShopCar as s where mId = " + memberId + " and pId = " + productId + "and transactionType = 'N'").executeUpdate();
	}
}
