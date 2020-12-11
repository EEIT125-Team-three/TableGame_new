<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>註冊新會員</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="../css/header_style.css">
    <link rel="stylesheet" href="../css/login.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
    <style>

    </style>
</head>

<body class="header_body">
    <script src="js/header_js.js"></script>
    <script>
    	var userId = 0
    </script>
    <header>
        <div>
            <ul class="header_listst1">
                <li> 
                    <a href="header" class="header_a"><p class="header_titlest"><image src="../images/LOGO.jpg">享玩 桌遊</p></a> 
                </li>
                <p class="header_p1">讓因桌遊而產生的歡笑&emsp;充滿生命中的每分每秒</p>
            </ul>
        </div>
        <hgroup class="hearder_hgroup">
            <h2 class="header_h2_1">放輕心情</h2>
            <h2 class="header_h2_2">享受與親友</h2>
            <h2 class="header_h2_3">共同度過的桌遊時光</h2>
        </hgroup>
        <nav class="header_nav">
            <div>
                <span class="header_span1"><a href="header" class="header_a">網站起源</a></span>
                <span class="header_span1"><a href="news" class="header_a">最新消息</a></span>
                <span class="header_span1"><a href="product" class="header_a">分類檢索</a></span>
                <span class="header_span1"><a href="shopCar" class="header_a">購物車</a></span>
                <span class="header_span1"><a href="gossip" class="header_a">討論區</a></span>
                <span class="header_span1"><a href="login" class="header_a">會員中心</a></span>
                <span class="header_span1"><a href="connect" class="header_a">聯絡我們</a></span>
                <span class="header_span2"><button>登出</button></span>
                <span class="header_span2">XXX 歡迎</span>
            </div>
        </nav>
    </header>

<form action="InsertMemberServlet" method="post">
		<fieldset>
			<legend class="ti">註冊新會員</legend>
			<table cellspacing="2" cellpadding="1" width="100%">
				<tr>
					<td>帳號ID:</td>
					<td><input type="text" name="account" value="${param.account}" id="account" size="30"
						maxlength="20" onblur="checkId()"><span id="sp1"></span></td>	
				</tr>
				<tr>
					<td>密碼Password:</td>
					<td><input type="password" name="password" value="${param.password}" id="password"
						size="30" maxlength="20" onblur="checkPassword()">
						<i class="fa fa-eye" onclick="showhide()" id="eye"></i>
						<span id="sp2"></span></td>
				</tr>
				<tr>
					<td>確認密碼Password:</td>
					<td><input type="password" name="cpassword" id="cpassword"
						size="30" maxlength="20" onblur="checkPasswordAgain()">
						<i class="fa fa-eye" onclick="showhide1()" id="eye"></i>
						<span id="sp3"></span></td>
				</tr>
				<tr>
					<td>姓名Name:</td>
					<td><input type="text" name="name" value="${param.name}" id="name" size="30" 
						maxlength="20" onblur="checkName()"><span id="sp4"></span></td>					
				</tr>
				<tr>
					<td>性別Gender:</td>
					<td><input type="radio" name="gender" id="gender" value="male">男<input
						type="radio" name="gender" id="gender" value="female">女</td>
				</tr>
				<tr>
					<td>生日Birthday:</td>
					<td><input type="date" name="birthday" id="birthday">
					</td>
				</tr>
				<tr>
					<td>手機Phone:</td>
					<td><input type="text" name="phone" value="${param.phone}" id="phone" size="30"
						maxlength="20" onblur="checkPhone()"><span id="sp5"></span></td>			
				</tr>
				<tr>
					<td>信箱E-mail:</td>
					<td><input type="email" name="mailaddress" value="${param.mailaddress}" id="mailaddress"
						size="30" maxlength="30" onblur="checkMail()"><span id="sp6"></span></td>					
				</tr>
				<tr>
					<td>地址Address:</td>
					<td><input type="text" name="address" value="${param.address}" id="address"
						size="30" maxlength="30" onblur="checkAddress()"><span id="sp7"></span></td>					
				</tr>
					<tr>
					<td>身分證字號IdNumber:</td>
					<td><input type="text" name="idNumber" value="${param.idNumber}" id="idNumber"
						size="30" maxlength="30" onblur="checkIdNumber()"><span id="sp8"></span></td>					
				</tr>
					<tr>
					<td>大頭貼Photo:</td>
					<td><input type="file" name="pic" value="${param.pic}" id="pic"
						size="30" maxlength="30" onblur="checkIdNumber()"><span id="sp8"></span></td>					
				</tr>
				
			</table>
			<br>
			<center>
				<input class="login" type="submit" name="submit" value="確認註冊"> <input
					class="login" type="reset" value="清除重填">
			</center>
			<img class="img1" src="../images/dice.png">
		</fieldset>
		<script src="../js/register.js"></script>
	</form>
	

</body>
</html>