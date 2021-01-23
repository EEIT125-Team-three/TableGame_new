package boardGame.service;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boardGame.controller.TableGameWebSocketController;

@Service("webSocketMessageService")
public class TableGameWebSocketService {
	private Logger logger = LoggerFactory.getLogger(TableGameWebSocketService.class);
	// 宣告websocket連線類
	@Autowired
	private TableGameWebSocketController webSocketChat;
//    private TableGameWebSocketController webSocketChat = new TableGameWebSocketController();

	/**
	 * @Title: sendToAllTerminal
	 * @Description: 呼叫websocket類給使用者下的所有終端傳送訊息
	 * @param @param  userId 使用者id
	 * @param @param  message 訊息
	 * @param @return 傳送成功返回true，否則返回false
	 */
	public Boolean sendToAllTerminal(String userId, String message) {
		logger.info("向用戶{}的訊息：{}", userId, message);
		webSocketChat.setUserId("1");
		if (webSocketChat.sendMessageToUser(userId, message)) {
			return true;
		} else {
			return false;
		}
	}

	public Set<String> allMember() {
		return webSocketChat.allMember();
	}
}
