package boardGame.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.server.standard.SpringConfigurator;

//websocket連線URL地址和可被呼叫配置
@ServerEndpoint(value = "/chat/{userId}", configurator = SpringConfigurator.class)
@Controller
public class TableGameWebSocketController {

	private static Logger logger = Logger.getRootLogger();
	// 靜態變數，用來記錄當前線上連線數。應該把它設計成執行緒安全的。
	private static int onlineCount = 0;

	// 記錄每個使用者下多個終端的連線
	private static Map<String, Set<TableGameWebSocketController>> userSocket = new HashMap<>();

	// 需要session來對使用者傳送資料, 獲取連線特徵userId
	private Session session;
	private String userId;

	/**
	 * @Title: onOpen
	 * @Description: websocekt連線建立時的操作
	 * @param @param  userId 使用者id
	 * @param @param  session websocket連線的session屬性
	 * @param @throws IOException
	 */
	@OnOpen
	public void onOpen(@PathParam("userId") String userId, Session session) throws IOException {
		this.session = session;
		this.userId = userId;
		onlineCount++;
		// 根據該使用者當前是否已經在別的終端登入進行新增操作
		if (userSocket.containsKey(this.userId)) {
			logger.info("當前使用者id:{" + this.userId + "}已有其他終端登入");
			userSocket.get(this.userId).add(this); // 增加該使用者set中的連線例項
		} else {
			logger.info("當前使用者id:{" + this.userId + "}第一個終端登入");
			Set<TableGameWebSocketController> addUserSet = new HashSet<>();
			addUserSet.add(this);
			userSocket.put(this.userId, addUserSet);
			if (!userId.equals("1")) {
				sendMessageToUser("1", "NowIs" + userId);
			}
		}
		logger.info("使用者{" + userId + "}登入的終端個數是為{" + userSocket.get(this.userId).size() + "}");
		logger.info("當前線上使用者數為：{" + userSocket.size() + "},所有終端個數為：{" + onlineCount + "}");
	}

	/**
	 * @Title: onClose
	 * @Description: 連線關閉的操作
	 */
	@OnClose
	public void onClose() {
		// 移除當前使用者終端登入的websocket資訊,如果該使用者的所有終端都下線了，則刪除該使用者的記錄
		if (userSocket.get(this.userId).size() == 0) {
			userSocket.remove(this.userId);
		} else {
			userSocket.get(this.userId).remove(this);
		}
		logger.info("使用者{" + this.userId + "}登入的終端個數是為{" + userSocket.get(this.userId).size() + "}");
		logger.info("當前線上使用者數為：{" + userSocket.size() + "},所有終端個數為：{" + onlineCount + "}");
	}

	/**
	 * @Title: onMessage
	 * @Description: 收到訊息後的操作
	 * @param @param message 收到的訊息
	 * @param @param session 該連線的session屬性
	 */
	@OnMessage
	public void onMessage(String message, Session session) {
		logger.info("收到來自使用者id為：{" + this.userId + "}的訊息：{" + message + "}");
		if (session == null)
			logger.info("session null");
//        System.out.println(session);
//        System.out.println(this.session);
		// 測試向客戶端傳送訊息傳送
		sendMessageToUser(this.userId, message);
	}

	/**
	 * @Title: onError
	 * @Description: 連線發生錯誤時候的操作
	 * @param @param session 該連線的session
	 * @param @param error 發生的錯誤
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		logger.info("使用者id為：{" + this.userId + "}的連線傳送錯誤");
		error.printStackTrace();
	}

	/**
	 * @Title: sendMessageToUser
	 * @Description: 傳送訊息給使用者下的所有終端
	 * @param @param  userId 使用者id
	 * @param @param  message 傳送的訊息
	 * @param @return 傳送成功返回true，反則返回false
	 */
	public Boolean sendMessageToUser(String userId, String message) {
		if (userSocket.containsKey(userId)) {
			logger.info(" 給使用者id為：{" + userId + "}的所有終端傳送訊息：{" + message + "}");
			if (message.split("NowIs")[0].equals("")) {
				for (TableGameWebSocketController WS : userSocket.get("1")) {
					logger.info("sessionId為:{" + WS.session.getId() + "}");
					try {
						WS.session.getBasicRemote().sendText(message);
					} catch (IOException e) {
						e.printStackTrace();
						logger.info(" 給使用者id為：{" + userId + "}傳送訊息失敗");
						return false;
					}
				}
				return true;
			}

			for (TableGameWebSocketController WS : userSocket.get(this.userId)) {
				logger.info("sessionId為:{" + WS.session.getId() + "}");
				try {
					WS.session.getBasicRemote().sendText("你：" + message);
				} catch (IOException e) {
					e.printStackTrace();
					logger.info(" 給使用者id為：{" + userId + "}傳送訊息失敗");
					return false;
				}
			}

			if (!this.userId.equals("1")) {
				for (TableGameWebSocketController WS : userSocket.get("1")) {
					try {
						WS.session.getBasicRemote().sendText(this.userId + ",會員：" + message);
					} catch (IOException e) {
						e.printStackTrace();
						return false;
					}
				}
			} else {
				for (TableGameWebSocketController WS : userSocket.get(userId)) {
					try {
						WS.session.getBasicRemote().sendText("管理員：" + message);
					} catch (IOException e) {
						e.printStackTrace();
						return false;
					}
				}
			}
			return true;
		}
		logger.info("傳送錯誤：當前連線不包含id為：{" + userId + "}的使用者");
		return false;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Set<String> allMember() {
		return userSocket.keySet();
	}

	public List<String> getMemberTalkHistory() {
		return null;
	}
}
