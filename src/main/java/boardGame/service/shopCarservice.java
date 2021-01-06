package boardGame.service;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.bridge.MessageWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import boardGame.dao.MemberDAO;
import boardGame.dao.ProductDAO_interface;
import boardGame.dao.shopCarDAO;
import boardGame.dao.trackLikeDao;
import boardGame.model.MemberBean;
import boardGame.model.Product;
import boardGame.model.ShopCar;
import boardGame.model.TableGameOrder;
import boardGame.model.TrackList;
import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;
import ecpay.payment.integration.domain.AioCheckOutOneTime;
import net.bytebuddy.asm.Advice.AllArguments;
import net.bytebuddy.description.ModifierReviewable.OfAbstraction;

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
	public List<Product> getShowProduct(){
		return productDao.SearchAllGame();
	}
	
	@Transactional
	public List<Product> selectAllFromShopCarAjax(Integer memberId, HttpServletRequest request){
		List<Product> products = new ArrayList<Product>();
		if(memberId != null) {
			List<ShopCar> ShopCars = new ArrayList<ShopCar>();
			ShopCars = shopCarDao.selectAll(memberId);
			for(ShopCar s : ShopCars) {
				products.add(s.getpId());
			}
		}
		else {
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("buyList")) {
					String[] buys = cookie.getValue().split("\\|");
					for(String buy : buys) {
						products.add(productDao.SearchGame(Integer.parseInt(buy.split("q")[0])));
					}
				}
			}
		}
		return products;
	}
	
	@Transactional
	public List<Product> updateFromShopCarAjax(Integer memberId, Integer productId, Integer buyHowmuch, HttpServletRequest request, HttpServletResponse response){
		if(memberId != null) {
			shopCarDao.update(memberId, productId, buyHowmuch);
		}
		else {
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("buyList")) {
					String[] buys = cookie.getValue().split("\\|");
					StringBuffer newBuy = new StringBuffer();
					for(String buy : buys) {
						if(Integer.parseInt(buy.split("q")[0]) == productId) {
							newBuy.append(buy.split("q")[0]);
							newBuy.append("q");
							newBuy.append(buyHowmuch);
							newBuy.append("|");
						}
						else {
							newBuy.append(buy);
							newBuy.append("|");
						}
					}
					Cookie cookie1 = new Cookie("buyList", newBuy.toString().substring(0, newBuy.toString().length()-1));
					cookie1.setMaxAge(60*10);
					cookie1.setPath(request.getContextPath());
					response.addCookie(cookie1);
				}
			}
		}
		return new ArrayList<Product>();
	}
	@Transactional
	public List<Product> deleteFromShopCarAjax(Integer memberId, Integer productId, HttpServletRequest request, HttpServletResponse response){
		List<Product> products = new ArrayList<Product>();
		List<ShopCar> ShopCars = new ArrayList<ShopCar>();
		if(memberId != null) {
			shopCarDao.delete(memberId, productId);
			ShopCars = shopCarDao.selectAll(memberId);
			for(ShopCar s : ShopCars) {
				products.add(s.getpId());
			}
		}
		else {
			StringBuffer newBuy = new StringBuffer();
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("buyList")) {
					String[] buys = cookie.getValue().split("\\|");
					for(String buy : buys) {
						if(productId != Integer.parseInt(buy.split("q")[0])) {
							newBuy.append(buy);
							newBuy.append("|");
							products.add(productDao.SearchGame(Integer.parseInt(buy.split("q")[0])));
						}
					}
					Cookie cookie1;
					if(newBuy.toString().length() > 0) {
						cookie1 = new Cookie("buyList", newBuy.toString().substring(0, newBuy.toString().length()-1));
						cookie1.setMaxAge(60*10);
					}
					else {
						cookie1 = new Cookie("buyList", null);
						cookie1.setMaxAge(0);
					}
					cookie1.setPath(request.getContextPath());
					response.addCookie(cookie1);
				}
			}
		}
		return products;
	}
	@Transactional
	public List<Product> insertToShopCarAjax(Integer memberId, Integer productId, Integer buyHowmuch){
		List<Product> products = new ArrayList<Product>();
		Product product = productDao.SearchGame(productId);
		if(memberId != null) {
			shopCarDao.insert(new ShopCar(product, memberDao.getMember(memberId), buyHowmuch, "N"));
		}
		products.add(product);
		return products;
	}
	
	@Transactional
	public void shopCarToTrackList(Integer memberId, Integer productId){
			trackLikeDao.insert(new TrackList(productDao.SearchGame(productId), memberDao.getMember(memberId)));
	}
	
	@Transactional
	public List<Product> selectAllFromTrackList(Integer memberId){
		List<Product> products = new ArrayList<Product>();
		if(memberId != null) {
			List<TrackList> trackLists =  trackLikeDao.selectAll(memberId);
			for(TrackList trackList : trackLists) {
				products.add(trackList.getpId());
			}
		}
		return products;
	}
	
	@Transactional
	public Map<Integer, Integer> getQuantity(Integer memberId, HttpServletRequest request, HttpServletResponse response){
		Map<Integer, Integer> map = new HashMap<>();
		if(memberId != null) {
			List<ShopCar> shopCars = shopCarDao.selectAll(memberId);
			for(ShopCar shopCar : shopCars) {
				map.put(shopCar.getpId().getProductId(), shopCar.getQuantity());
			}
			return map;
		}
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("buyList")) {
				String[] buys = cookie.getValue().split("\\|");
				for(String buy : buys) {
					map.put(Integer.parseInt(buy.split("q")[0]), Integer.parseInt(buy.split("q")[1]));
				}
			}
		}
		return map;
	}
	
	@Transactional
	public void deleteFromTrackListAjax(Integer memberId, Integer productId) {
		trackLikeDao.delete(memberId, productId);
	}
	public Map<String, String> addAllCookieBuy(HttpServletRequest request, HttpServletResponse response, Integer productId) {
		Cookie[] cookies = request.getCookies();
		Map<String, String> returnMap = new HashMap<String, String>();
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("buyList")) {
				String[] buyLists = cookie.getValue().split("\\|");
				for(int i=0; i<buyLists.length; i++) {
					if(buyLists[i].split("q")[0].equals(productId.toString())) {
						System.out.println(buyLists);
						returnMap.put("message", "該商品已存在於購物車內");
						return returnMap;
					}
				}
				Cookie cookie1 = new Cookie("buyList", cookie.getValue() + "|" + productId + "q1");
				cookie1.setMaxAge(60*10);
				cookie1.setPath(request.getContextPath());
				response.addCookie(cookie1);
				returnMap.put("message", "成功加入購物車");
				return returnMap;
			}
		}
		Cookie cookie = new Cookie("buyList", productId.toString() + "q1");
		cookie.setMaxAge(60*10);
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);
		returnMap.put("message", "成功加入購物車");
		return returnMap;
	}
	@Transactional
	public void checkAllCookieBuy(HttpServletRequest request, HttpServletResponse response, MemberBean member) {
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("buyList")) {
				String[] buys = cookie.getValue().split("\\|");
				for(String buy : buys) {
					ShopCar shopCar = shopCarDao.select(member.getMemId(), Integer.parseInt(buy.split("q")[0]));
					System.out.println(shopCar);
					if(shopCar != null) {
						shopCarDao.update(member.getMemId(), Integer.parseInt(buy.split("q")[0]), Integer.parseInt(buy.split("q")[1]));
					}
					else {
						shopCarDao.insert(new ShopCar(productDao.SearchGame(Integer.parseInt(buy.split("q")[0])), member, Integer.parseInt(buy.split("q")[1]), "N"));
					}
				}
				cookie.setPath(request.getContextPath());
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
	}
	@Transactional
	public String checkOut(String totalAmount, String tradeDesc, String itemName, String sentToWho, String sentToWhere, String sentToPhone) {
		AllInOne all = new AllInOne("");
		AioCheckOutOneTime obj = new AioCheckOutOneTime();
		String tableGameOrderId = "TEST" + UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
		Date date = new Date();
		itemName = itemName.replace("\'a\'", "#");
		System.out.println(itemName);
		obj.setMerchantTradeNo(tableGameOrderId);
		obj.setMerchantTradeDate(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date));
		obj.setTotalAmount(totalAmount);
		obj.setTradeDesc(tradeDesc);
		obj.setItemName(itemName.substring(0, itemName.length()-1));
		obj.setClientBackURL("http://localhost:8080/TestVersion/");
		obj.setReturnURL("http://localhost:8080/TestVersion/checkoutOver");
		obj.setNeedExtraPaidInfo("N");
		TableGameOrder tableGameOrder = new TableGameOrder(tableGameOrderId, sentToWho, sentToWhere, sentToPhone, Integer.parseInt(totalAmount), date);
		shopCarDao.insertTableGameOrder(tableGameOrder);
		updateWhenCheckout(Integer.parseInt(tradeDesc), tableGameOrder);
		return all.aioCheckOut(obj, null);
	}
	
	@Transactional
	public Map<String, String> addToTrackList(Integer memberId, Integer productId) {
		Map<String, String> returnMap = new HashMap<>();
		
		if(shopCarDao.select(memberId, productId) != null) {
			returnMap.put("message", "該商品已存在於購物車內");
		}
		else if(trackLikeDao.select(memberId, productId) != null) {
			returnMap.put("message", "該商品已存在於追蹤清單內");
		}
		else {
			trackLikeDao.insert(new TrackList(productDao.SearchGame(productId), memberDao.getMember(memberId)));
			returnMap.put("message", "成功加入追蹤清單");
		}
		return returnMap;
	}
	
	@Transactional
	public Map<String, String> addToShopCar(Integer memberId, Integer productId) {
		Map<String, String> returnMap = new HashMap<String, String>();
		if(shopCarDao.select(memberId, productId) != null) {
			returnMap.put("message", "該商品已存在於購物車內");
		}
		else if(trackLikeDao.select(memberId, productId) != null) {
			returnMap.put("message", "該商品已存在於追蹤清單內");
		}
		else {
			shopCarDao.insert(new ShopCar(productDao.SearchGame(productId), memberDao.getMember(memberId), 1, "N"));
			returnMap.put("message", "成功加入購物車");
		}
		return returnMap;
	}
	
	@Transactional
	public List<TableGameOrder> getShopCarHistory(Integer dateRage, Integer historyId) {
		StringBuffer hql = new StringBuffer();
		hql.append("From TableGameOrder");
		if(historyId != null) {
			hql.append(" where tableGameOrderId = ");
			hql.append(historyId);
		}
		System.out.println(hql);
		return shopCarDao.getShopCarHistory(hql.toString());
	}
	
	public  List<String> getOrderTime(List<TableGameOrder> tableGameOrders, Integer dateRage){
		List<String> list = new ArrayList<String>();
		for(int i=0; i<tableGameOrders.size(); i++) {
			list.add(tableGameOrders.get(i).getCheckoutDate().toString());
		}
		return list;
	}
	private void updateWhenCheckout(Integer memberId, TableGameOrder tableGameOrder) {
		List<ShopCar> shopCars = shopCarDao.selectAll(memberId);
		for(int i=0; i<shopCars.size(); i++) {
			shopCarDao.updateWhenCheckout(shopCars.get(i), tableGameOrder);
		}
	}
}
