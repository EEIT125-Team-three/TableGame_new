package boardGame.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import boardGame.model.ShopCar;
import boardGame.model.TableGameOrder;

@Repository
public class shopCarDAO {
	
	@Autowired
	SessionFactory factory;
	
	public List<ShopCar> selectAll(Integer memberId) {
		return factory.getCurrentSession().createQuery("From ShopCar where mId = " + memberId + " and transactionType = 'N'").list();
	}
	public ShopCar select(Integer memberId, Integer ProductId) {
		List<ShopCar> list = factory.getCurrentSession().createQuery("From ShopCar where mId = " + memberId + " and pId = " + ProductId + " and transactionType = 'N'").list();
		if(list.size() > 0) {
			return list.get(0);
		}
		return null;
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
	public void updateWhenCheckout(ShopCar shopCar, TableGameOrder tableGameOrder) {
		shopCar.setTableGameOrderId(tableGameOrder);
		shopCar.setTransactionType("Y");
	}
	public void insertTableGameOrder(TableGameOrder tableGameOrder) {
		factory.getCurrentSession().save(tableGameOrder);
	}
	
	public ShopCar[] getOrderDetail(Integer orderId){
		Set<ShopCar> shopCars = factory.getCurrentSession().get(TableGameOrder.class, orderId).getShopCars();
		return shopCars.toArray(new ShopCar[shopCars.size()]);
	}
	
	public List<TableGameOrder> getShopCarHistory(String hql, Date start, Date end) {
		if(start != null) {
			return factory.getCurrentSession().createQuery(hql).setTimestamp("start", start).setTimestamp("end", end).getResultList();
		}
		return factory.getCurrentSession().createQuery(hql).getResultList();
	}
	
	public void updateTableGameOrder(String sentToWho, String sentToWhere, String sentToPhone, Integer orderId) {
		TableGameOrder tableGameOrder = factory.getCurrentSession().get(TableGameOrder.class, orderId);
		tableGameOrder.setSentToWho(sentToWho);
		tableGameOrder.setSentToAddress(sentToWhere);
		tableGameOrder.setSentToPhone(sentToPhone);
	}
}
