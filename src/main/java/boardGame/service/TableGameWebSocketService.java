package boardGame.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
		if (webSocketChat.sendMessageToUser(userId, message)) {
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
		if (list != null) {
			if (nowAccount != 1) {
				for (MemberRequestHistory memberRequestHistory : list) {
					if (memberRequestHistory.getWhoTalk().getMemId() == memberRequestHistory.getMemberBean().getMemId()) {
						talkContext.add("你：" + memberRequestHistory.getRequestContent());
					} else {
						talkContext.add("管理員：" + memberRequestHistory.getRequestContent());
					}
				}
			} else {
				for (MemberRequestHistory memberRequestHistory : list) {
					if (memberRequestHistory.getWhoTalk().getMemId() == memberRequestHistory.getMemberBean().getMemId()) {
						talkContext.add("會員：" + memberRequestHistory.getRequestContent());
					} else {
						talkContext.add("你：" + memberRequestHistory.getRequestContent());
					}
				}
			}
		}
		return talkContext;
	}
}
