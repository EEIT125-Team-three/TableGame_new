package boardGame.service;

import static org.hamcrest.CoreMatchers.nullValue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.events.EndDocument;

import org.springframework.beans.factory.annotation.Autowired;
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
import ecpay.payment.integration.domain.AioCheckOutOneTime;

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
	public String checkOut(Integer memberId, String sentToWho, String sentToWhere, String sentToPhone, Integer district, Integer useRefund) {
		System.out.println(memberId);
		System.out.println(sentToWho);
		System.out.println(sentToPhone);
		System.out.println(district);
		System.out.println(useRefund);
		StringBuffer itemName = new StringBuffer();
		Integer totalAmount = 0;
		MemberBean memberBean = memberDao.getMember(memberId);
		List<ShopCar> shopCars = shopCarDao.selectAll(memberId);
		for(ShopCar shopCar : shopCars) {
			itemName.append(shopCar.getpId().getC_name());
			itemName.append(" X ");
			itemName.append(shopCar.getQuantity().toString());
			itemName.append("#");
			totalAmount += (shopCar.getQuantity() * shopCar.getpId().getPrice());
		}
		if(useRefund == 1) {
			if(memberBean.getMemRefund() > totalAmount) {
				memberBean.setMemRefund(memberBean.getMemRefund()-totalAmount);
				totalAmount = 0;
			}else {
				totalAmount -= memberBean.getMemRefund();
				memberBean.setMemRefund(totalAmount/10);
			}
		}else if(useRefund == 2){
			totalAmount = new Integer((int)(totalAmount*0.95));
			memberBean.setMemRefund(memberBean.getMemRefund()+totalAmount/10);
		}else {
			memberBean.setMemRefund(memberBean.getMemRefund()+totalAmount/10);
		}
		
		Date date = new Date();
		String tableGameOrderId = null;
		TableGameOrder tableGameOrder = new TableGameOrder(tableGameOrderId, sentToWho, sentToWhere, sentToPhone, totalAmount, date, memberBean);
		shopCarDao.insertTableGameOrder(tableGameOrder);
		updateWhenCheckout(memberId, tableGameOrder);
		if(totalAmount == 0) {
			return "";
		}
		AllInOne all = new AllInOne("");
		AioCheckOutOneTime obj = new AioCheckOutOneTime();
		tableGameOrderId = "TG" + UUID.randomUUID().toString().replaceAll("-", "").substring(0, 18);
		StringBuffer tradeDesc = new StringBuffer();
		tradeDesc.append("感謝");
		tradeDesc.append(memberBean.getMemName());
		if(memberBean.getMemGender().contains("男")) {
			tradeDesc.append("先生");			
		}else if(memberBean.getMemGender().contains("女")) {
			tradeDesc.append("小姐");
		}else {
			tradeDesc.append(memberBean.getMemGender());
		}
		tradeDesc.append("購買本公司的產品");
		obj.setMerchantTradeNo(tableGameOrderId);
		obj.setMerchantTradeDate(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date));
		obj.setTotalAmount(totalAmount.toString());
		obj.setTradeDesc(tradeDesc.toString());
		obj.setItemName(itemName.toString().substring(0, itemName.toString().length()-1));
		obj.setClientBackURL("http://localhost:8080/TestVersion/checkoutOver");
		obj.setReturnURL("http://localhost:8080/TestVersion/checkoutOver");
		obj.setNeedExtraPaidInfo("N");
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
	public Map<String, Object> getShopCarHistory(Integer dateRage, Integer historyId, Integer memberId) {
		StringBuffer hql = new StringBuffer();
		boolean whereInHql = false;
		Calendar calendar = Calendar.getInstance();
		Date start = new Date();
		Date end = new Date();
		calendar.setTime(end);
		hql.append("From TableGameOrder");
		if(historyId != null) {
			hql.append(" where tableGameOrderId = '");
			hql.append(historyId);
			hql.append("'");
			whereInHql = true;
		}
		if(memberId != null) {
			if(whereInHql) {
				hql.append(" and");
			}
			else {
				hql.append(" where");
				whereInHql = true;
			}
			hql.append(" memberId = ");
			hql.append(memberId);
			
		}
		if(dateRage != null) {
				if(whereInHql) {
					hql.append(" and");
				}
				else {
					hql.append(" where");
					whereInHql = true;
				}
				switch (dateRage) {
					case 12:
						calendar.add(Calendar.YEAR, -1);
						break;
					default:
						calendar.add(Calendar.MONTH, -dateRage);
						break;
				}
				start = calendar.getTime();
				hql.append(" checkoutDate between :start and :end");
				System.out.println(hql);
				System.out.println(start);
				System.out.println(end);
				return getOrderTime(shopCarDao.getShopCarHistory(hql.toString(), start, end));
		}
		return getOrderTime(shopCarDao.getShopCarHistory(hql.toString(), null, null));
	}
	
	@Transactional
	public List<List<String>> getOrderDetail(Integer orderId){
		ShopCar[] shopCars = shopCarDao.getOrderDetail(orderId);
		List<String> productId = new ArrayList<String>();
		List<String> productName = new ArrayList<String>();
		List<String> productPrice = new ArrayList<String>();
		List<String> productQuantity = new ArrayList<String>();
		for(int i=0; i<shopCars.length; i++) {
			ShopCar s = shopCars[i];
			Product p = s.getpId();
			productId.add(p.getProductId().toString());
			productName.add(p.getC_name());
			productPrice.add(p.getPrice().toString());
			productQuantity.add(s.getQuantity().toString());
		}
		List<List<String>> list = new ArrayList<List<String>>();
		list.add(productId);
		list.add(productName);
		list.add(productPrice);
		list.add(productQuantity);
		return list;
	}
	
	@Transactional
	public void changeOrderData(String sentToWho, String sentToWhere, String sentToPhone, Integer orderId) {
		shopCarDao.updateTableGameOrder(sentToWho, sentToWhere, sentToPhone, orderId);
	}
	
	public List<Integer> getAllOrderYear(List<String> list){
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0; i<list.size(); i++) {
			set.add(Integer.parseInt(list.get(i).split("-")[0]));
		}
		ArrayList<Integer> reList = new ArrayList<Integer>(set);
		Collections.reverse(reList);
		return reList;
	}
	
	public Map<String, Object> getDataByDate(List<TableGameOrder> tableGameOrders, Integer year, Integer month) {
		Map<String, Object> remap = new HashMap<String, Object>();
		Integer lengthOfTableGameOrders = tableGameOrders.size();
		Integer totalMoney = 0;
		for(int i=0; i<lengthOfTableGameOrders; i++) {
			if(tableGameOrders.get(i).getCheckoutDate().getYear() != year) {
				tableGameOrders.remove(i);
				lengthOfTableGameOrders -= 1;
				i -= 1;
			}
		}
		if(month == null) {
			List<Integer> eachMonthAmount = new ArrayList<Integer>();
			List<Integer> eachMonth = new ArrayList<Integer>();
			for(int i=0; i<12; i++) {
				eachMonthAmount.add(0);
				eachMonth.add(i+1);
			}
			int thisMonth;
			for(TableGameOrder tableGameOrder : tableGameOrders) {
				thisMonth = tableGameOrder.getCheckoutDate().getMonth();
				eachMonthAmount.set(thisMonth, eachMonthAmount.get(thisMonth) + tableGameOrder.getTotalMoney());
				totalMoney += tableGameOrder.getTotalMoney();
			}
			remap.put("date", eachMonthAmount);
			remap.put("dateName", eachMonth);
			remap.put("totalMoney", totalMoney);
			return remap;
		}
		
		List<Integer> eachDateAmount = new ArrayList<Integer>();
		List<Integer> eachDate = new ArrayList<Integer>();
		for(int i=0; i<getDayOfMonth(year+1900, month); i++) {
			eachDateAmount.add(0);
			eachDate.add(i+1);
		}
		int thisDate;
		TableGameOrder tableGameOrder;
		for(int i=0; i<tableGameOrders.size(); i++) {
			tableGameOrder = tableGameOrders.get(i);
			if(tableGameOrder.getCheckoutDate().getMonth()+1 == month) {
				thisDate = tableGameOrders.get(i).getCheckoutDate().getDate()-1;
				eachDateAmount.set(thisDate, eachDateAmount.get(thisDate) + tableGameOrder.getTotalMoney());
				totalMoney += tableGameOrder.getTotalMoney();
			}
		}
		remap.put("date", eachDateAmount);
		remap.put("dateName", eachDate);
		remap.put("totalMoney", totalMoney);
		return remap;
	}
	
	private  Map<String, Object> getOrderTime(List<TableGameOrder> tableGameOrders){
		Map<String, Object> reMap = new HashMap<String, Object>();
		List<String> list = new ArrayList<String>();
		for(int i=0; i<tableGameOrders.size(); i++) {
			list.add(tableGameOrders.get(i).getCheckoutDate().toString());
		}
		reMap.put("TableGameOrder", tableGameOrders);
		 reMap.put("allTableGameOrderTime", list);
		return reMap;
	}
	
	private void updateWhenCheckout(Integer memberId, TableGameOrder tableGameOrder) {
		List<ShopCar> shopCars = shopCarDao.selectAll(memberId);
		for(int i=0; i<shopCars.size(); i++) {
			shopCarDao.updateWhenCheckout(shopCars.get(i), tableGameOrder);
			productDao.updateStorage(shopCars.get(i).getpId(), -shopCars.get(i).getQuantity());
		}
	}
	
	private int getDayOfMonth(Integer year,Integer month){
		Calendar c = Calendar.getInstance();
		c.set(year, month, 0);
		return c.get(Calendar.DAY_OF_MONTH);
	}
}
