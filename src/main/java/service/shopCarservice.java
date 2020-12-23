package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.MemberDAO;
import dao.ProductDAO_interface;
import dao.shopCarDAO;
import dao.trackLikeDao;
import model.MemberBean;
import model.Product;
import model.ShopCar;
import model.TrackList;

@Service
public class shopCarservice{
	@Autowired
	ProductDAO_interface productDao;
	@Autowired
	shopCarDAO shopCarDao;
	@Autowired
	MemberDAO memberDao;
	@Autowired
	trackLikeDao trackLikeDao;
	@Transactional
	public List<Product> getData(String doWhich, Integer show, Integer  buyHowmuch, Integer memberId, Integer productId) {
		List<Product> products = new ArrayList<Product>();
		List<ShopCar> lShopCar = new ArrayList<ShopCar>();
		if(show == -1) {
			return productDao.SearchAllGame();
		}
		if(memberId != null) {
			switch (show) {
			case 0:
				switch (doWhich) {
				case "":
					lShopCar = shopCarDao.selectAll(memberId);
					for(ShopCar s : lShopCar) {
						products.add(s.getpId());
					}
					return products;
				case "insert":
					Product product = productDao.SearchGame(productId);
					shopCarDao.insert(new ShopCar(product, memberDao.getMember(memberId), buyHowmuch, "N"));
					products.add(product);
					return products;
				case "update":
					shopCarDao.update(memberId, productId, buyHowmuch);
					return products;
				case "delete":
					shopCarDao.delete(memberId, productId);
					lShopCar = shopCarDao.selectAll(memberId);
					for(ShopCar s : lShopCar) {
						products.add(s.getpId());
					}
					return products;
				}
			case 1:
				switch(doWhich) {
					case "insert":
						trackLikeDao.insert(new TrackList(productDao.SearchGame(productId), memberDao.getMember(memberId)));
						shopCarDao.delete(memberId, productId);
						lShopCar = shopCarDao.selectAll(memberId);
						System.out.println(lShopCar.size());
						for(ShopCar s : lShopCar) {
							products.add(s.getpId());
						}
						return products;
				}
			case 2:
				break;
			}
		}
		return products;
	}
	@Transactional
	public Map<Integer, Integer> getquantity(Integer memberId){
		Map<Integer, Integer> map = new HashMap<>();
		List<ShopCar> shopCars = shopCarDao.selectAll(memberId);
		for(ShopCar shopCar : shopCars) {
			map.put(shopCar.getpId().getProductId(), shopCar.getQuantity());
		}
		System.out.println(map);
		return map;
	}
}
