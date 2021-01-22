package boardGame.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.swing.JMenu;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import boardGame.dao.InfoDAOInterface;
import boardGame.dao.MemberDAOInterface;
import boardGame.model.InfoBean;
import boardGame.model.MImerge;
import boardGame.model.MemberBean;
import boardGame.model.TableGameOrder;
import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutOneTime;

@Service
public class InfoServiceImpl implements InfoService {
	@Autowired
	InfoDAOInterface dao;

	@Autowired
	MemberDAOInterface memDao;

	@Transactional
	@Override
	public boolean idExists(String activityId) {
		boolean exist = false;
		exist = dao.idExists(activityId);
		return exist;
	}

	@Transactional
	@Override
	public int updateInfo(InfoBean inf) {
		int count = 0;
		dao.updateInfo(inf);
		count++;
		return count;
	}

	@Transactional
	@Override
	public int saveInfo(InfoBean inf) {
		int count = 0;
		dao.saveInfo(inf);
		count++;
		return count;
	}

	@Transactional
	@Override
	public InfoBean getInfo(Integer activityId) {
		InfoBean info = null;
		info = dao.getInfo(activityId);
		return info;
	}

	@Transactional
	@Override
	public List<InfoBean> getAllInfos() {
		return dao.getAllInfos();
	}

	@Transactional
	@Override
	public int deleteInfo(int activity_id) {
		int count = 0;
		dao.deleteInfo(activity_id);
		count++;
		return count;
	}

	@Transactional
	@Override
	public List<InfoBean> showActByArea(String actArea, String activity) {
		return dao.showActivityByArea(actArea, activity);
	}

	@Transactional
	@Override
	public List<InfoBean> showAllAct(String activity) {
		return dao.showAllActivity(activity);
	}

	@Transactional
	@Override
	public List<InfoBean> showCourseByType(String activity, String actType) {
		return dao.showCourseByType(activity, actType);
	}

	@Transactional
	@Override
	public List<InfoBean> showCourseByCamp(String activity, String actType) {
		return dao.showCourseByCamp(activity, actType);
	}

	@Transactional
	@Override
	public List<InfoBean> showTPICamp(String actArea, String actType) {
		return dao.showTPICamp(actArea, actType);
	}

	@Transactional
	@Override
	public List<InfoBean> showTCHCamp(String actArea, String actType) {
		return dao.showTCHCamp(actArea, actType);
	}

	@Transactional
	@Override
	public List<InfoBean> showKOHCamp(String actArea, String actType) {
		return dao.showKOHCamp(actArea, actType);
	}

	@Transactional
	@Override
	public void addMemberActivity(Integer memId, InfoBean infoIdBean) {
		MemberBean memBean = memDao.getMember(memId);
		MImerge mImerge = dao.getSignUp(memBean, infoIdBean);
		if (mImerge == null) {
			dao.AddMemberActivity(memBean, infoIdBean);
		} else {
			dao.updateMemberActivity(mImerge);
		}
	}

	@Transactional
	@Override
	public InfoBean searchActivity(Integer activityId) {
		InfoBean info = dao.SearchActivity(activityId);
		System.out.println(info);
		return info;
	}

	// 個人會員活動歷史查詢
	@Transactional
	@Override
	public List<MImerge> getInfoHistory(Integer id) {
		return dao.getInfoHistory(id);
	}

	@Transactional
	@Override
	public Map<String, Object> getActTypeNum() {
		return dao.getActTypeNum();
	}

	@Transactional
	@Override
	public Map<String, Object> getActTypePeople() {
		List<InfoBean> allInfos = dao.getAllInfos();
		Map<String, Integer> reMap = new HashMap<String, Integer>();
		for (InfoBean infoBean : allInfos) {
			if (reMap.get(infoBean.getActType()) != null) {
				reMap.put(infoBean.getActType(), reMap.get(infoBean.getActType()) + infoBean.getMember().size());
			} else {
				reMap.put(infoBean.getActType(), infoBean.getMember().size());
			}
		}
		Set<String> keySet = reMap.keySet();
		List<String> activeTypeName = new ArrayList<String>();
		List<Integer> activePeopleAcount = new ArrayList<Integer>();
		for (String key : keySet) {
			activePeopleAcount.add(reMap.get(key));
			activeTypeName.add("\'" + key + "\'");
		}
		Map<String, Object> finalMap = new HashMap<String, Object>();
		finalMap.put("activePeopleAcount", activePeopleAcount);
		finalMap.put("activeTypeName", activeTypeName);
		System.out.println(reMap);
		return finalMap;
	}

	@Transactional
	@Override
	public int deleteSignUp(int miId) {
		int count = 0;
		dao.deleteSignUp(miId);
		count++;
		return count;
	}

	@Override
	public void close() {
		dao.close();
	}

	@Override
	@Transactional
	public String paySignUp(Integer memberId, Integer MImergeId) {
		AllInOne all = new AllInOne("");
		AioCheckOutOneTime obj = new AioCheckOutOneTime();
		String paySignUpId = "TG" + UUID.randomUUID().toString().replaceAll("-", "").substring(0, 18);
		Date date = new Date();
		MImerge mimerge = dao.getMImergeByMImergeId(MImergeId);
		InfoBean infoBean = mimerge.getInfo();
		mimerge.setPayedCheck("已繳費");
		StringBuffer itemName = new StringBuffer();
		itemName.append(infoBean.getActArea());
		itemName.append(infoBean.getActType());
		itemName.append(infoBean.getActDate1());
		String totalAmount = infoBean.getActCost().toString();
		MemberBean memberBean = memDao.getMember(memberId);
		StringBuffer tradeDesc = new StringBuffer();
		tradeDesc.append("感謝");
		tradeDesc.append(memberBean.getMemName());
		if (memberBean.getMemGender().contains("男")) {
			tradeDesc.append("先生");
		} else if (memberBean.getMemGender().contains("女")) {
			tradeDesc.append("小姐");
		} else {
			tradeDesc.append(memberBean.getMemGender());
		}
		JavaMail JM = new JavaMail();
		JM.sendSignMail(memberBean.getMemMailaddress(), infoBean.getActArea(), infoBean.getActType(),
				infoBean.getActDate1(), infoBean.getActStrTime1(), infoBean.getActEndTime1(), infoBean.getActDate2(),
				infoBean.getActStrTime2(), infoBean.getActEndTime2(), infoBean.getActDay(), infoBean.getActLocation(),
				infoBean.getActAddress());
		tradeDesc.append("購買本公司的產品");
		obj.setMerchantTradeNo(paySignUpId);
		obj.setMerchantTradeDate(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date));
		obj.setTotalAmount(totalAmount);
		obj.setTradeDesc(tradeDesc.toString());
		obj.setItemName(itemName.toString());
		obj.setClientBackURL("http://localhost:8080/TestVersion/checkoutOver");
		obj.setReturnURL("http://localhost:8080/TestVersion/checkoutOver");
		obj.setNeedExtraPaidInfo("N");
//		TableGameOrder tableGameOrder = new TableGameOrder(tableGameOrderId, sentToWho, sentToWhere, sentToPhone, Integer.parseInt(totalAmount), date, memberBean);
//		shopCarDao.insertTableGameOrder(tableGameOrder);
//		updateWhenCheckout(memberId, tableGameOrder);
		return all.aioCheckOut(obj, null);
	}

}
