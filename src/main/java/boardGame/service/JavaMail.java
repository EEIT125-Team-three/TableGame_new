package boardGame.service;

import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.omg.CORBA.PUBLIC_MEMBER;

public class JavaMail {
// ---------------------------------------------------------基本資料
	private String mailEncoding = "text/html;charset = UTF-8";
	private String userName = "eeit125team3@gmail.com"; // 寄件者信箱
	private String password = "elxnosqublmyzgpi"; // 寄件者密碼
	private Properties getProperties() {
		// ---------------------------------------------------------連線設定
		Properties prop = new Properties();
		// 設定連線為smtp
		prop.setProperty("mail.transport.protocol", "smtp");

		// host主機:smtp.gmail.com
		prop.setProperty("mail.host", "smtp.gmail.com");

		// host port:465
		prop.put("mail.smtp.port", "465");

		// 寄件者帳號需要驗證：是
		prop.put("mail.smtp.auth", "true");

		// 需要安全資料傳輸層 (SSL)：是
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		// 安全資料傳輸層 (SSL) 通訊埠：465
		prop.put("mail.smtp.socketFactory.port", "465");

		// 顯示連線資訊
		prop.put("mail.debug", "true");
		return prop;
	}
	
	private Boolean sentMail(String title, String context, String mail) {
		Properties prop = getProperties();
		// class
		Auth auth = new Auth(userName, password);
		Session session = Session.getDefaultInstance(prop, auth);

		// ---------------------------------------------------------Message郵件格式
		MimeMessage message = new MimeMessage(session);

		try {
			// 寄件者
			// 匿名類別
			// message.setSender(new InternetAddress(userName));

			// class
			InternetAddress sender = new InternetAddress(userName);
			message.setSender(sender);
			
			// 收件者
			message.setRecipient(RecipientType.TO, new InternetAddress(mail));
			
			// 標題
			message.setSubject(title);
			
			// 內容/格式
			message.setContent(context, mailEncoding);
			
			
			// ---------------------------------------------------------Transport傳送Message
			Transport transport = session.getTransport();
			
			// transport將message送出
			transport.send(message);
			
			// 關閉Transport
			transport.close();
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void newPasswordMail(String checkId, String mail) {
		String title = "享玩桌遊-找回密碼確認信";
		String context = "<h1>親愛的用戶您好，請點擊以下連結更換新密碼</h1><a href='http://localhost:8080/TestVersion/AAA?checkId="+checkId+"'>點擊前往</a>";
		sentMail(title, context, mail);
	}

	public void insertSendMail(String checkId, String mail) {
		String title = "享玩桌遊-註冊確認信";
		String context = "<h1>親愛的用戶您好，請點擊以下連結來確認註冊</h1><a href='http://localhost:8080/TestVersion/InsertMemberSuccess?checkId="+checkId+"'>點擊前往開通帳號</a>";
		sentMail(title, context, mail);
	}

	public void SendSignMail(String paySignUpId, String memMailaddress) {
		// TODO Auto-generated method stub
		
	}
	
	public void shopCarOrderMail(String mail,Map<String, String> allData) {
		StringBuffer context = new StringBuffer();
		String title = "交易成功通知";
		context.append("<h1>親愛的 ");
		context.append(allData.get("memberName"));
		context.append(" 您好,感謝您的購買</h1><dl style='font-size: 30px;'><dt>本次交易的訂單編號為");
		context.append(allData.get("orderId"));
		context.append("，以下是訂單資訊<dt><dd>收件人姓名:");
		context.append(allData.get("name"));
		context.append("</dd><dd>收件地址:");
		context.append(allData.get("address"));
		context.append("</dd><dd>聯絡電話:");
		context.append(allData.get("phoneNumber"));
		context.append("</dd><dd><dl><dt>產品細節:</dt>");
		for(String s:allData.get("item").split("#")) {
			context.append("<dd>");
			context.append(s);
			context.append("</dd>");
		}
		context.append("</dl></dd><dd>運送模式:");
		context.append(allData.get("deliveryType"));
		context.append("</dd><dd>");
		context.append(allData.get("discount"));
		context.append("</dd><dd>總價:");
		context.append(allData.get("totalMoney"));
		context.append("元</dd></dl><h1>若需修改本訂單之收件地址或聯絡電話請於收到本信件三天內連繫客服</h1>");
		sentMail(title, context.toString(), mail);
	}
}

class Auth extends Authenticator {

	private String userName;
	private String password;

	public Auth(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		PasswordAuthentication pa = new PasswordAuthentication(userName, password);
		return pa;
	}

}
		