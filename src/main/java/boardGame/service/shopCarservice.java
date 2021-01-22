package boardGame.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import boardGame.dao.MemberDAO;
import boardGame.dao.ProductDAO_interface;
import boardGame.dao.shopCarDAO;
import boardGame.dao.trackLikeDao;
import boardGame.model.City;
import boardGame.model.ConvenienceStoreAddress;
import boardGame.model.District;
import boardGame.model.MemberBean;
import boardGame.model.Product;
import boardGame.model.Road;
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
	@Autowired
	HomeService homeService;
	
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
	public String checkOut(Integer memberId, String sentToWho, String sentToWhere, String sentToPhone, Integer road, Integer useRefund, Integer shopId) {
		Map<String, String> mailData = new HashMap<String, String>();
		StringBuffer itemName = new StringBuffer();
		StringBuffer mailUse = new StringBuffer();
		Integer totalAmount = 0;
		Integer thisAmount = 0;
		MemberBean memberBean = memberDao.getMember(memberId);
		List<ShopCar> shopCars = shopCarDao.selectAll(memberId);
		Date date = new Date();
		String tableGameOrderId = "TG" + UUID.randomUUID().toString().replaceAll("-", "").substring(0, 18);
		TableGameOrder tableGameOrder = new TableGameOrder(tableGameOrderId, sentToWho, null, sentToPhone, totalAmount, date, memberBean, null, null);
		for(ShopCar shopCar : shopCars) {
			thisAmount = 0;
			itemName.append(shopCar.getpId().getC_name());
			itemName.append("(");
			if(shopCar.getpId().getDiscount() == null) {
				itemName.append(shopCar.getpId().getPrice().toString());
				thisAmount = (shopCar.getQuantity() * shopCar.getpId().getPrice());
			}else {
				itemName.append(shopCar.getpId().getPrice() * shopCar.getpId().getDiscount() / 10);
				thisAmount = (shopCar.getQuantity() * shopCar.getpId().getPrice() * shopCar.getpId().getDiscount() / 10);
			}
			itemName.append("元/套)");
			itemName.append(" * ");
			itemName.append(shopCar.getQuantity().toString());
			itemName.append("，共");
			itemName.append(thisAmount);
			itemName.append("元#");
			totalAmount += thisAmount;
		}
		
		if(shopId == 0) {
			mailData.put("deliveryType", "宅配，運費100元");
			totalAmount += 100;
			tableGameOrder.setRoad(homeService.getRoad(road));
			tableGameOrder.setSentToAddress(sentToWhere);
		}else {
			mailData.put("deliveryType", "超商取貨，運費60元");
			ConvenienceStoreAddress convenienceStoreAddress = shopCarDao.getConvenienceStoreAddressById(shopId);
			mailUse.append("(");
			mailUse.append(convenienceStoreAddress.getConvenienceStoreType().getConvenienceStore());
			mailUse.append(")");
			totalAmount += 60;
			tableGameOrder.setConvenienceStoreAddress(convenienceStoreAddress);
		}
		mailUse.append(homeService.getAddress(homeService.getRoad(road)));
		mailUse.append(sentToWhere);
		mailData.put("address", mailUse.toString());
		mailUse.delete(0, mailUse.length());
		
		if(useRefund == 1) {
			mailUse.append("使用回饋金優惠(共折抵 ");
			if(memberBean.getMemRefund() > totalAmount) {
				if(shopId == 0) {
					mailUse.append(totalAmount-100);
					memberBean.setMemRefund(memberBean.getMemRefund()-(totalAmount-100)+10);
					totalAmount = 100;
				}else {
					mailUse.append(totalAmount-60);
					memberBean.setMemRefund(memberBean.getMemRefund()-(totalAmount-60)+6);
					totalAmount = 60;
				}
			}else {
				mailUse.append(memberBean.getMemRefund());
				totalAmount -= memberBean.getMemRefund();
				memberBean.setMemRefund(totalAmount/10);
			}
			mailUse.append(" 元)");
			mailData.put("discount", mailUse.toString());
		}else if(useRefund == 2){
			mailUse.append("使用折扣券優惠(共折抵 ");
			mailUse.append((int)(totalAmount*0.05));
			mailUse.append(" 元)");
			totalAmount = new Integer((int)(totalAmount*0.95));
			memberBean.setMemRefund(memberBean.getMemRefund()+totalAmount/10);
			memberBean.setDiscountCheck(true);
			mailData.put("discount", mailUse.toString());
		}else {
			memberBean.setMemRefund(memberBean.getMemRefund()+totalAmount/10);
			mailData.put("discount", "無使用優惠");
		}
		shopCarDao.insertTableGameOrder(tableGameOrder);
		mailData.put("memberName", memberBean.getMemName());
		mailData.put("orderId", tableGameOrder.getTableGameOrderId().toString());
		mailData.put("name", sentToWho);
		mailData.put("phoneNumber", sentToPhone);
		mailData.put("item", itemName.toString());
		mailData.put("totalMoney", totalAmount.toString());
		(new JavaMail()).shopCarOrderMail(memberBean.getMemMailaddress(), mailData);
		if(totalAmount == 0) {
			tableGameOrder.setGreenCheckId(null);
			updateWhenCheckout(memberId, tableGameOrder);
			return "";
		}
		updateWhenCheckout(memberId, tableGameOrder);
		AllInOne all = new AllInOne("");
		AioCheckOutOneTime obj = new AioCheckOutOneTime();
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
			return getOrderTimeAndAddress(shopCarDao.getShopCarHistory(hql.toString(), start, end));
		}
		return getOrderTimeAndAddress(shopCarDao.getShopCarHistory(hql.toString(), null, null));
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
	
	public Map<String, Object> getDataByDate(List<TableGameOrder> tableGameOrders, Integer year, Integer month, Integer regionId) {
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
		List<String> addressName = new ArrayList<String>();
		List<String> addressTotalAmount = new ArrayList<String>();
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
	
	@Transactional
	public Boolean checkDiscount(String discountId, Integer memberId) {
		if(memberDao.getMember(memberId).isDiscountCheck()) {
			return false;
		}
		return shopCarDao.checkDiscount(discountId);
	}
	
	public List<String> getAddress(List<TableGameOrder> tableGameOrders){
		List<String> orderSentAddress = new ArrayList<String>();
		StringBuffer address = new StringBuffer();
		ConvenienceStoreAddress convenienceStoreAddress;
		Road road;
		District district;
		City city;
		for(TableGameOrder tableGameOrder: tableGameOrders) {
			if(tableGameOrder.getRoad() != null) {
				road = tableGameOrder.getRoad();
				district = road.getDistrict();
				city = district.getCity();
				address.append(city.getCity());
				address.append(district.getDistrict());
				address.append(road.getRoad());
				address.append(tableGameOrder.getSentToAddress());
				orderSentAddress.add(address.toString());
				address.delete(0, address.toString().length());
			}else {
				convenienceStoreAddress = tableGameOrder.getConvenienceStoreAddress();
				road = convenienceStoreAddress.getRoad();
				district = road.getDistrict();
				city = district.getCity();
				address.append("(");
				address.append(convenienceStoreAddress.getConvenienceStoreType().getConvenienceStore());
				address.append(")");
				address.append(city.getCity());
				address.append(district.getDistrict());
				address.append(road.getRoad());
				address.append(tableGameOrder.getConvenienceStoreAddress().getConvenienceStoreAddress());
				orderSentAddress.add(address.toString());
				address.delete(0, address.toString().length());
			}
		}
		return orderSentAddress;
	}
	
	private  Map<String, Object> getOrderTimeAndAddress(List<TableGameOrder> tableGameOrders){
		Map<String, Object> reMap = new HashMap<String, Object>();
		List<String> orderTime = new ArrayList<String>();		
		for(TableGameOrder tableGameOrder: tableGameOrders) {
			orderTime.add(tableGameOrder.getCheckoutDate().toString());
		}
		reMap.put("TableGameOrder", tableGameOrders);
		reMap.put("allTableGameOrderTime", orderTime);
		System.out.println(reMap);
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
