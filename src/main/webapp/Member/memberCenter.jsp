<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>會員資訊</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Member.css"> 
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ScrollBar.css">
	<link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
</head>

<body class="header_body">
<script src="${pageContext.request.contextPath}/js/showMember.js"></script>
	<header>
	</header>
	<div>
    <fieldset class="MC_fieldset_left">
        <legend class="MC_title">會員資訊</legend>
        <table id="MCtable" cellspacing="10" cellpadding="5" width="100%">
        <tr><td class="MC_welcome">${name}</td></tr>
        <tr><td style="display:none">${id}</td><td class="MC_pictd" style="text-align:center"><img class="MC_pic" width='150' height='200' src=''/></td></tr>	
		<tr><td class="MC_td" id="UMP"><a href="#" class="MC_link">會員資料更動</a></td></tr>				
		<tr><td class="MC_td" id="pwdChange"><a href="#" class="MC_link">密碼更改</a></td></tr>				
		<tr><td class="MC_td" id="viewHistory"><a href="#" class="MC_link">商品查詢歷史</a></td></tr>	
		<tr><td class="MC_td" id="disHistory"><a href="#" class="MC_link">已發表文章</a></td></tr>		
		<tr><td class="MC_td" id="infoHistory"><a href="#" class="MC_link">已參與活動</a></td></tr>		
		<tr><td class="MC_td" id="shopHistory"><a href="#" class="MC_link">訂單查詢</a></td></tr>		   	
        </table>
        <br>
    </fieldset>          
	<fieldset class="MC_fieldset_right">
	<div class="SM_title">會員資料</div>
	<br>
	<table cellspacing="5" cellpadding="5" width="100%">
	<tr><td class="MC_memtd1">帳號:</td><td class="MC_memtd2">${account}</td><td class="MC_memtd1">姓名:</td><td class="MC_memtd2">${name}</td></tr>
	<tr><td class="MC_memtd1">性別:</td><td class="MC_memtd2">${gender}</td><td class="MC_memtd1">生日:</td><td class="MC_memtd2">${birthday}</td></tr>
	<tr><td class="MC_memtd1">手機:</td><td class="MC_memtd2">${phone}</td><td class="MC_memtd1">信箱:</td><td class="MC_memtd2">${mailaddress}</td></tr>
	<tr><td class="MC_memtd1">地址:</td><td class="MC_memtd2">${address}</td><td class="MC_memtd1">身分證字號:</td><td class="MC_memtd2">${idNumber}</td></tr>	
	<tr><td class="MC_memtd1">現有回饋金:</td><td class="MC_memtd2">${refund}</td><td class="MC_memtd1">註冊時間:</td><td class="MC_memtd2">${registerTime}</td></tr>
	</table>
    </fieldset>
    </div>          
</body>
</html>