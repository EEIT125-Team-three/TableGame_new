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
</head>

<body class="header_body">
	<header>
	</header>
    <form action="LoginServlet" method="post">
    <fieldset>
        <legend class="ti">會員登入</legend>
         <div align="center">
   <% if(request.getAttribute("msg") != null) { %>
    <p style="color: red">
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
        </table>
        <br>
        <center>
        <input class="login" type="submit" value="登入">
        <br>
        <a class="link" href="<c:url value='InsertMember'/>">註冊新會員</a>
        <a class="link" href="<c:url value='showMembers'/>">查詢會員資料</a>
<!--         <a class="link" href="InsertMember">註冊新會員</a> -->
        <a class="link" href="https://www.xujisunrise.com.tw/zh-TW/home">忘記帳號</a>
        <a class="link" href="https://www.xujisunrise.com.tw/zh-TW/home">忘記密碼</a>
        <br>
        <button type="button" style="background-color:blue ; color:white">FB登入</button>&emsp;
        <button type="button" style="background-color:green ; color:white">Google登入</button>&emsp;
        <button type="button" style="background-color:red ; color:white">IG登入</button>
        </center>
        <img class="img1" src="images/dice.png">
    </fieldset>
    <script src="js/register.js"></script>
    </form>
</body>

</html>