//package controller;
//
//import java.io.IOException;
//import java.util.HashMap;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.lang.StringUtils;
//import org.apache.http.client.HttpClient;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import net.sf.json.JSONObject;
//
//@Controller
//public class FBController {
//	//應用編號
//		private static String client_id="應用編號";
//		//應用祕鑰
//		private static String client_secret="應用祕鑰";
//		//表示取得的使用者資訊的許可權範圍  
//		private static String scope = "user_about_me,email,read_stream";
//		//回撥地址
//		private static String redirect_url ="http://gntina.iok.la/doLogin"; 
//		//獲取臨時口令
//		private static String code_url="https://www.facebook.com/v2.8/dialog/oauth";
//		//獲取訪問口令
//		private static String token_url="https://graph.facebook.com/v2.8/oauth/access_token";
//		//獲取使用者資訊
//		private static String user_url="https://graph.facebook.com/me"; 
//		//驗證口令
//		private static String verify_url="https://graph.facebook.com/debug_token";
//		//獲取應用口令
//		private static String app_url="https://graph.facebook.com/v2.8/oauth/access_token";
//		
//
//		/**
//		 * @throws IOException 
//		 * @Title: doLogin  
//		 * @Description: 呼叫“登入”對話方塊和設定重定向網址   
//		 * @return void 這個就是在應用中定義的跳轉網址，也就是重定向第二步之後回撥的地址，並且帶上了code引數
//		 * @date Mar 17, 2017 9:29:03 AM
//		 * @throws
//		 */
//		@RequestMapping(value="/doLogin")
//		@ResponseBody
//		public Object doLogin(HttpServletRequest request,HttpServletResponse response) throws IOException{
//			String code = request.getParameter("code");//第二步獲取code，迷糊的同學往下看，方法上也有對應的步驟
//			if(StringUtils.isNotBlank(code)){
//				String accessToken = getFacebookAccessToken(code);//第三步，用code（臨時口令）換取accessToken
//				JSONObject userInfo=null;
//				if(StringUtils.isNotBlank(accessToken)){
//					userInfo = getUserInfo(accessToken);//第四步，用accessToken獲取使用者資訊
//				}else{
//					System.out.println("accessToken is null");
//				}
//				System.out.println(userInfo);
//				return userInfo;
//				//對使用者資訊進行處理
//			}else{
//				return "/code";
//			}
//		}
//		
//		
//		/**
//		 * @throws ServletException 
//		 * @throws IOException 
//		 * @Title: getAuthorizationCode  
//		 * @Description: 獲取 Authorization Code（臨時口令）
//		 * @author 第二步，在index.jsp中使用者登入成功後就是跳轉到這裡，重定向此地址會在回撥地址中的引數帶上code  
//		 * @return String
//		 * @date Mar 17, 2017 9:30:38 AM
//		 * @throws
//		 */
//		@RequestMapping(value="/code")
//		public static void getAuthorizationCode(HttpServletRequest  request,HttpServletResponse response) throws IOException, ServletException{
//			response.sendRedirect(code_url+"?client_id="+client_id+"&redirect_uri="+redirect_url);
//		}
//		
//		/**
//		 * @return 
//		 * @throws IOException 
//		 * @Title: getFacebookAccessToken  
//		 * @Description:用臨時口令獲取訪問口令 access_token 
//		 * @author 第三步用code換取accessToken（呼叫的介面和引數在程式碼裡找就能看明白了） 
//		 * @return String
//		 * @param code“登入”對話方塊重定向接收的引數。
//		 * @date Mar 15, 2017 11:36:11 AM
//		 * @throws
//		 */
//		public static String getFacebookAccessToken(String code){
//			HashMap<String, String> params = new HashMap<String,String>();
//			params.put("client_id", client_id);
//			params.put("redirect_uri", redirect_url);
//			params.put("client_secret", client_secret);
//			params.put("code", code);
//			String[] responseResult =null;
//			String accessToken =null;
//			try {
//				responseResult = HttpClient.getStringByPost(token_url, params, null);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			if (null != responseResult && responseResult[0].equals("200")) {
//				String result = responseResult[1];
//				JSONObject jsonObject =  JSONObject.fromObject(result);
//				accessToken = jsonObject.getString("access_token");
//			}
//			return accessToken;
//			//獲取,然後返回access_token
//			/*{
//			  "access_token": {access-token}, 
//			  "token_type": {type},
//			  "expires_in":  {seconds-til-expiration}
//			}*/
//		}
//		
//		/**
//		 * @throws IOException 
//		 * @return 
//		 * @Title: getUserInfo  
//		 * @Description:根據   token口令獲取使用者資訊
//		 * @author 第四步用accessToken獲取使用者資訊（呼叫的介面和引數在程式碼裡找就能看明白了） 
//		 * @return Map<String,String>
//		 * @date Mar 15, 2017 6:04:31 PM
//		 * @throws
//		 */
//		public static JSONObject getUserInfo(String accessToken){
//			HashMap<String, String> params = new HashMap<String,String>();
//			String fields="id,name,birthday,gender,hometown,email,devices";
//			params.put("access_token", accessToken);
//			params.put("fields", fields);
//			String[] responseResult =null;
//			JSONObject userInfo=null;
//			try {
//				responseResult = HttpClientUtil.getStringByGet(user_url, params);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			if (null != responseResult && responseResult[0].equals("200")) {
//				String result = responseResult[1];
//				userInfo =  JSONObject.fromObject(result);   
//			}
//			return userInfo;
//		}
//		
//		/**
//		 * @Title: verifyToken  
//		 * @Description: 呼叫圖譜API，驗證口令  app_id 和 user_id 欄位將幫助您的應用確認訪問口令對使用者和您的應用有效。
//		 * @author 第五步驗證訪問的使用者是否來自你的應用，防刷功能，防止惡意註冊  
//		 * @return String
//		 * @date Mar 17, 2017 9:50:38 AM
//		 * @throws
//		 */
//		@RequestMapping("/verify")
//		@ResponseBody
//		public Object verifyToken(String accessToken){
//			HashMap<String, String> params = new HashMap<String,String>();
//			//檢驗口令
//			accessToken="EAATb6fZCbwXgBAFlUThSX7xWMcwfVhpT8A9szvYkWsTqhJDjcILOLkTPReDYHx6BfWl67MXA2ZApPyc7FEDJGJ1bIrM0u8zQI6nszrcnzULDRuUG2gBWIjuZAe6CPZCYXBHClpsL8zhZAK4gVZC4N27ZAkZBPDscRJW0bRS05LisJAZDZD";
//			//應用口令
//			String access_token=getAppToken();
//			params.put("input_token", accessToken);
//			params.put("access_token", access_token);
//			String[] responseResult =null;
//			String data = null ;
//			try {
//				responseResult = HttpClientUtil.getStringByGet(verify_url, params);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			if (null != responseResult && responseResult[0].equals("200")) {
//				String result = responseResult[1];
//				JSONObject jsonObject =  JSONObject.fromObject(result);
//				data = jsonObject.getString("data");
//				System.out.println(data);
//			}
////			{
////			    "data": {
////			        "app_id": 138483919580948, 
////			        "application": "Social Cafe", 
////			        "expires_at": 1352419328, 
////			        "is_valid": true, 
////			        "issued_at": 1347235328, 
////			        "metadata": {
////			            "sso": "iphone-safari"
////			        }, 
////			        "scopes": [
////			            "email", 
////			            "publish_actions"
////			        ], 
////			        "user_id": 1207059
////			    }
////			}
//			return data;
//		}
//		
//		/**
//		 * @Title: getAppToken  
//		 * @Description: 獲取應用口令（用來驗證口令是否來自我的應用）  
//		 * @author gaona  
//		 * @return String
//		 * @date Mar 20, 2017 3:16:26 PM
//		 * @throws
//		 */
//		public String getAppToken(){
//			HashMap<String, String> params = new HashMap<String,String>();
//			params.put("client_id", client_id);
//			params.put("client_secret", client_secret);
//			params.put("grant_type", "client_credentials");
//			String[] responseResult =null;
//			String appToken=null;
//			try {
//				responseResult = HttpClientUtil.getStringByGet(app_url, params);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			if (null != responseResult && responseResult[0].equals("200")) {
//				String result = responseResult[1];
//				JSONObject jsonObject =  JSONObject.fromObject(result);
//				appToken = jsonObject.getString("access_token");
//				System.out.println(appToken);
//			}
//			return appToken;
//		}
//}
