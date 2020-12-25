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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
    
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script type="text/javascript">
    $(function(){
        $('#kaptchaImage').click(function () { 
            $(this).attr('src', 'captcha-image.jpg?' + Math.floor(Math.random()*100) ); 
        })
    });
    //修改验证码触发的函数 

    function  changeVerifyCode(){
     var verifyCodeValue = $("#verifyCode").val();
        if(verifyCodeValue.replace(/\s/g,"") == "") {
            alert("请输入验证码");
        }else {
            //异步检查验证码是否输入正确

            var verifyUrl = "${pageContext.request.contextPath}/checkVerificationCode";
            $.ajax({
                type:"POST",
                url:verifyUrl,
                data:{"verifyCode":verifyCodeValue},
                success:function(data){
                    if(data==true) {
                     //验证码正确，进行提交操作

                     //alert("输入正确 ！");
                    }else {
                        alert("请输入正确的验证码！");
                    }
                },
                error:function(e){
                    alert(e);
                }
            });
        }
    }
</script>

    <script>
//引入 facebook SDK
(function(d, s, id) {
	var js, fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id))
		return;
	js = d.createElement(s);
	js.id = id;
	js.src = "//connect.facebook.net/en_US/sdk.js";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));
</script>
</head>

<body class="header_body">
	<header>
	</header>
    <form method="post" action="${pageContext.request.contextPath }/login">
    <fieldset>
        <legend class="ti">會員登入</legend>
         <div align="center">
   <% if(request.getAttribute("msg") != null) { %>
    <p style="color: red; font-size: 30px">
     <%= request.getAttribute("msg") %>
    </p>
   <% } %>
   </div>
        <table>
				<tr>
					<td>帳號ID:</td>
					<td><input type="text" name="account" id="account" size="30"
						maxlength="20" onblur="checkId()"><span id="sp1"></span></td>	
				</tr>
				<tr>
					<td>密碼Password:</td>
					<td><input type="password" name="password" id="password"
						size="30" maxlength="20" onblur="checkPassword()">
						<i class="fa fa-eye" onclick="showhide()" id="eye"></i>
						<span id="sp2"></span></td>
				</tr>
<!-- 				<tr> -->
<!-- 					<td>驗證碼:</td> -->
<!-- 					<td><input type="text" name="verifyCode" id="verifyCode" class="usertext" value=""                         onchange="changeVerifyCode();"/> -->
<!--                <img src="captcha-image.jpg" width="110" height="30" id="kaptchaImage"  -->
<!--                         style="margin-bottom: -13px"/> </td>	 -->
<!-- 				</tr>				    -->
        </table>
        <br>
        <div align="center">
        <input class="login" type="submit" value="登入">
        <br>
        <a class="link" href="${pageContext.request.contextPath }/InsertMember">註冊新會員</a>
        <a class="link" href="https://www.xujisunrise.com.tw/zh-TW/home">忘記帳號</a>
        <a class="link" href="https://www.xujisunrise.com.tw/zh-TW/home">忘記密碼</a>
        <br>
        <fb:login-button scope="public_profile,email" autologoutlink="true" onlogin="checkLoginState();" size="large"
		show_faces="true">  </fb:login-button><div id="status"></div>&emsp;
        <button type="button" style="background-color:green ; color:white">Google登入</button>&emsp;
        <button type="button" style="background-color:red ; color:white">IG登入</button>
        </div>
        <img class="img1" src="images/dice.png">
    </fieldset>
    <script src="js/register.js"></script>
    </form>
 

<script>

	function statusChangeCallback(response) {
		//可用於後臺驗證，但是前臺呼叫SDK則會自動驗證
		var accessToken=response.authResponse.accessToken;
		console.log(response.authResponse.accessToken);
		if (response.status === 'connected') {//sdk會自動保留accessToken，並且驗證該請求是否來自我的應用
	        FB.api('/me?fields=name,first_name,last_name,email', function(response) { 
	        	//將使用者資訊傳回服務端
	        	window.location.href="http://localhost:8080/TestVersion/userInfo?userInfo="+JSON.stringify(response);
// 	        	 $.ajax({
// 	                    url:"http://localhost:8080/userInfo",
// 	                    data:{
// 	                    	userInfo:JSON.stringify(response)
// 	                    },
// 	                    dataType:"json",
// 	                    async:false,
// 	                    success:function(data){
// 	                    	window.location.href="";
// 	                    } 
// 	                }); 
	        	document.getElementById('status').innerHTML =
			        'Thanks for logging in, ' + response.name + '!';
	        });
	        
		} else {
			document.getElementById('status').innerHTML = 'Please log '
					+ 'into this app.';
		}
	}

	function checkLoginState() {
		FB.getLoginStatus(function(response) {
			statusChangeCallback(response);
		}); 
	}

	window.fbAsyncInit = function() {
		FB.init({
			appId : '440070780733338',
			cookie : true, 
			xfbml : true, 
			version : 'v2.8' 
		});

		FB.getLoginStatus(function(response) {
			statusChangeCallback(response);
		});

	};

</script>
    
</body>

</html>