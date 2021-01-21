package boardGame.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

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

	private void sentMail(String title, String context, String mail) {
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

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void newPasswordMail(String checkId, String mail) {
		String title = "找回密碼確認信";
		String context = "<h1>親愛的用戶您好，請點擊以下連結更換新密碼</h1><a href='http://localhost:8080/TestVersion/AAA?checkId="
				+ checkId + "'>點擊前往</a>";
		sentMail(title, context, mail);
	}

	public void insertSendMail(String checkId, String mail) {
		String title = "註冊確認信";
		String context = "<h1>親愛的用戶您好，請點擊以下連結來確認註冊</h1><a href='http://localhost:8080/TestVersion/InsertMemberSuccess?checkId="
				+ checkId + "'>點擊前往開通帳號</a>";
		sentMail(title, context, mail);
	}

	public void sendSignMail(String mail, String area, String type, String date1, String strtime1, String endtime1,
			String date2, String strtime2, String endtime2, Integer day, String location, String address) {
		String title = "報名確認信";
		String context = "<h1>親愛的用戶您好，感謝您報名活動<br>" + area + type + date1 + "</h1>詳細資訊如下方所示，以供保存紀錄<br>活動名稱:" + area
				+ type + date1 + "<br>活動日期(1):" + date1 + "<br>活動時間(1):" + strtime1 + "~" + endtime1 + "<br>活動日期(2):"
				+ date2 + "<br>活動時間(2):" + strtime2 + "~" + endtime2 + "<br>活動天數: 共" + day + "天<br>活動地點:" + location
				+ "<br>活動地址:" + address + "<br>期待您的蒞臨，感謝您";
		sentMail(title, context, mail);
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
