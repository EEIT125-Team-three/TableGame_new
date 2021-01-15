<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>會員登入</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Member.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
    <script src="js/register.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>

</head>

<body class="header_body">
	<header>
	</header>
    <form method="post" action="${pageContext.request.contextPath }/login">
    <fieldset class="LO_fieldset">
        <legend class="LO_title">會員登入</legend>
         <div align="center">
   <% if(request.getAttribute("msg") != null) { %>
    <p style="color: red; font-size: 30px">
     <%= request.getAttribute("msg") %>
    </p>
   <% } %>
   </div>
        <table>
				<tr>
					<td class="LO_td">帳號ID:</td>
					<td class="LO_td"><input class="LO_input" type="text" name="account" id="account" size="30"
						maxlength="30" onblur="checkId()"><span id="sp1"></span></td>	
				</tr>
				<tr>
					<td class="LO_td">密碼Password:</td>
					<td class="LO_td"><input class="LO_input" type="password" name="password" id="password"
						size="30" maxlength="20" onblur="checkPassword()">
						<i class="fa fa-eye" onclick="showhide()" id="eye1"></i>
						<span id="sp2"></span></td>
				</tr>
				<tr><td class="LO_td">
				<input type="hidden" name="remember" id="remember">
				<input type="checkbox" name="rememberMe" id="rememberMe" class="rememberMe">記住我
				</td>
				</tr>
			 
        </table>
        <br>
        <div align="center">
        <input class="LO_loginBtn" type="submit" value="登入Login">
        <br>
        <br>
        <div><a class="LO_link" href="${pageContext.request.contextPath }/InsertMember">註冊新會員</a></div>
        <a class="link" href="${pageContext.request.contextPath }/forgetPassword">忘記密碼</a>
        <br>        
        <button type="button" id="btnSignIn">Google登入</button>
        </div>
        <img class="img1" src="images/dice.png">
    </fieldset>
    </form>

<script type="text/javascript">
        let CLIENT_ID = "1060867705816-oe6agoje4lumg7n6ntp4k96acfehanvl.apps.googleusercontent.com";
        //let API_KEY = '';//Javascript SDK無須 API 金鑰
        // Array of API discovery doc URLs for APIs
        let DISCOVERY_DOCS = ["https://www.googleapis.com/discovery/v1/apis/people/v1/rest"];

    </script>
    <!--執行Google API必須的.js，callback function名稱請自訂 -->
    <!--↓https://apis.google.com/js/platform.js 或 https://apis.google.com/js/api.js 兩者網址都行得通 這裡採用跟官網寫法一樣-->
    <script async defer src="https://apis.google.com/js/api.js"
            onload="this.onload=function(){};GoogleClientInit()"
            onreadystatechange="if (this.readyState === 'complete') this.onload()">
    </script>

    <!--以下請另外放置到 *.js檔案-->
    <script type="text/javascript">
        //jQuery處理button click event 當畫面DOM都載入時....
        $(function () {
            $("#btnSignIn").on("click", function () {
                $("#content").html("");//清空顯示結果
                GoogleLogin();//Google 登入
            });
            $("#btnDisconnect").on("click", function () {
                Google_disconnect();//和Google App斷連
            });
        });

        function GoogleClientInit() {
            //官網範例寫client:auth2，但本人實測由於待會要呼叫gapi.client.init而不是gapi.auth2.init，所以給client即可
            gapi.load('client', function () {
                gapi.client.init({
                    //client_id 和 scope 兩者參數必填
                    clientId: CLIENT_ID,
                    //scope列表參考：https://developers.google.com/people/api/rest/v1/people/get
                    //"profile"是簡寫，要用完整scope名稱也可以
                    scope: "profile",//"https://www.googleapis.com/auth/userinfo.profile",
                    discoveryDocs: DISCOVERY_DOCS
                });


            });//end gapi.load
        }//end GoogleClientInit function


        function GoogleLogin() {
            let auth2 = gapi.auth2.getAuthInstance();//取得GoogleAuth物件
            auth2.signIn().then(function (GoogleUser) {
                console.log("Google登入成功");
                let user_id = GoogleUser.getId();//取得user id，不過要發送至Server端的話，為了資安請使用id_token，本人另一篇文章有範例：https://dotblogs.com.tw/shadow/2019/01/31/113026
                console.log(`user_id:${user_id}`);
                let AuthResponse = GoogleUser.getAuthResponse(true) ;//true會回傳包含access token ，false則不會
                let id_token = AuthResponse.id_token;//取得id_token
                //people.get方法參考：https://developers.google.com/people/api/rest/v1/people/get
                gapi.client.people.people.get({
                    'resourceName': 'people/me',
                    //通常你會想要知道的用戶個資↓
                    'personFields': 'names,phoneNumbers,emailAddresses,addresses,residences,genders,birthdays,occupations',
                }).then(function (res) {

                        //success
                        let str = JSON.stringify(res.result);//將物件列化成string，方便顯示結果在畫面上
                        //顯示授權你網站存取的用戶個資
//                         document.getElementById('content').innerHTML = str;
                        //↑通常metadata標記primary:true的個資就是你該抓的資料
						console.log(res);
//                         $.ajax({
//                         	url:"otherAccount",
//                         	type:"POST",
//                         	data:{
//                         		"nickName":res.result.names[0].displayName,
// 								"email":res.result.emailAddresses[0].value
//                         	},
//                         	async:false
//                         })
						$(".login_Btn").parent().append("<input name='nickName' hidden=true value='" + res.result.names[0].displayName + "'><input name='email' hidden=true value='" + res.result.emailAddresses[0].value + "'>").parent().attr("action", "/TestVersion/otherAccount").attr("method", "POST");
						$(".login_Btn").click();
                        //請再自行Parse JSON，可以將JSON字串丟到線上parse工具查看：http://json.parser.online.fr/


                        //最終，取得用戶個資後看要填在畫面表單上或是透過Ajax儲存到資料庫(記得是傳id_token給你的Web Server而不是明碼的user_id喔)，本範例就不贅述，請自行努力XD


                });

            },
                function (error) {
                    console.log("Google登入失敗");
                    console.log(error);
                });

        }//end function GoogleLogin



        function Google_disconnect() {
            let auth2 = gapi.auth2.getAuthInstance(); //取得GoogleAuth物件

            auth2.disconnect().then(function () {
                console.log('User disconnect.');
            });
        }
    </script>
    
</body>

</html>