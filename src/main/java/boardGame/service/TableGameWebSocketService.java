package boardGame.service;

import java.io.Console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.mail.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SimpleAliasRegistry;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import boardGame.controller.TableGameWebSocketController;
import boardGame.dao.MemberDAO;
import boardGame.dao.WebSocketDao;
import boardGame.model.MemberBean;
import boardGame.model.MemberRequestHistory;

@Service("webSocketMessageService")
public class TableGameWebSocketService {
	private Logger logger = LoggerFactory.getLogger(TableGameWebSocketService.class);
	// 宣告websocket連線類
	@Autowired
	private TableGameWebSocketController webSocketChat;
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private WebSocketDao webSocketDao;
//    private TableGameWebSocketController webSocketChat = new TableGameWebSocketController();

	/**
	 * @Title: sendToAllTerminal
	 * @Description: 呼叫websocket類給使用者下的所有終端傳送訊息
	 * @param @param  userId 使用者id
	 * @param @param  message 訊息
	 * @param @return 傳送成功返回true，否則返回false
	 */
	@Transactional
	public Boolean sendToAllTerminal(String userId, String message, Integer nowLinkMember) {
		logger.info("向用戶{}的訊息：{}", userId, message);
		MemberRequestHistory memberRequestHistory;
		MemberBean nowLinkMemberBean = memberDAO.getMember(nowLinkMember);
		Date date = new Date();
		if(nowLinkMember == 1) {
			MemberBean memberBean = memberDAO.getMember(Integer.parseInt(userId));
			memberRequestHistory = new MemberRequestHistory(message, memberBean, date, nowLinkMemberBean);			
		}else {
			memberRequestHistory = new MemberRequestHistory(message, nowLinkMemberBean, date, nowLinkMemberBean);
		}
		webSocketDao.save(memberRequestHistory);
		
		webSocketChat.setUserId(nowLinkMember.toString());
		StringBuffer timeIndexMessage = new StringBuffer();
		timeIndexMessage.append(message);
		timeIndexMessage.append("<span style='font-size:10px'> (");
		SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String[] re = sdf.format(calendar.getTime()).split(" ");
		timeIndexMessage.append(re[1]);
		timeIndexMessage.append(" ");
		timeIndexMessage.append(re[0]);
		timeIndexMessage.append(")<span>");
		if (webSocketChat.sendMessageToUser(userId, timeIndexMessage.toString())) {
			return true;
		} else {
			return false;
		}
	}

	public Set<String> allMember() {
		return webSocketChat.allMember();
	}
	
	@Transactional
	public List<String> getMemberMessage(Integer memberId, Integer nowAccount) {
		List<MemberRequestHistory> list = memberDAO.getMember(memberId).getMemberRequestHistory();
		List<String> talkContext = new ArrayList<String>();
		Date date = new Date();
		if (list != null) {
			if (nowAccount != 1) {
				for (MemberRequestHistory memberRequestHistory : list) {
					StringBuffer allMessage = new StringBuffer();
					allMessage.append(memberRequestHistory.getRequestContent());
					allMessage.append("<span style='font-size:10px; color:black'> (");
					allMessage.append(createReturnDate(memberRequestHistory.getThisMessageTime()));
					allMessage.append(")</span>");
					if (memberRequestHistory.getWhoTalk().getMemId() == memberRequestHistory.getMemberBean().getMemId()) {
						talkContext.add("你：" + allMessage.toString());
					} else {
						talkContext.add("管理員：" + allMessage.toString());
					}
				}
			} else {
				for (MemberRequestHistory memberRequestHistory : list) {
					StringBuffer allMessage = new StringBuffer();
					allMessage.append(memberRequestHistory.getRequestContent());
					allMessage.append("<span style='font-size:10px'> (");
					allMessage.append(createReturnDate(memberRequestHistory.getThisMessageTime()));
					allMessage.append(")</span>");
					if (memberRequestHistory.getWhoTalk().getMemId() == memberRequestHistory.getMemberBean().getMemId()) {
						talkContext.add("會員：" + allMessage.toString());
					} else {
						talkContext.add("你："  + allMessage.toString());
					}
				}
			}
		}
		return talkContext;
	}
	
	private String createReturnDate(Date date) {
		StringBuffer returnString = new StringBuffer();
		Calendar calendarNow = Calendar.getInstance();
		calendarNow.set(calendarNow.get(Calendar.YEAR), calendarNow.get(Calendar.MONTH), calendarNow.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		Date now = calendarNow.getTime();
		if(now.getTime() < date.getTime()) {
			
		}else if(now.getTime() - date.getTime() <= 86400000){
			returnString.append("昨天 ");
		}else if(now.getTime() - date.getTime() <= 172800000) {
			returnString.append("前天 ");
		}else {
			returnString.append(date.getMonth()+1);
			returnString.append("/");
			returnString.append(date.getDate());
			returnString.append(" ");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String[] re = sdf.format(calendar.getTime()).split(" ");
		returnString.append(re[1]);
		returnString.append(" ");
		returnString.append(re[0]);
		return returnString.toString();
	}
}
