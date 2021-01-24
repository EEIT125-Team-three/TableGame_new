<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>享玩 桌遊｜會員中心</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Member.css">
</head>

<body class="header_body">
	<header>
	</header>
	<div>      
	<div class="SM_title">會員資料</div>
	<br>
	<table cellspacing="5" cellpadding="5" width="100%">
	<tr><td class="MC_memtd1">帳號:</td><td class="MC_memtd2">${account}</td><td class="MC_memtd1">姓名:</td><td class="MC_memtd2">${name}</td></tr>
	<tr><td class="MC_memtd1">性別:</td><td class="MC_memtd2">${gender}</td><td class="MC_memtd1">生日:</td><td class="MC_memtd2">${birthday}</td></tr>
	<tr><td class="MC_memtd1">手機:</td><td class="MC_memtd2">${phone}</td><td class="MC_memtd1">信箱:</td><td class="MC_memtd2">${mailaddress}</td></tr>
	<tr><td class="MC_memtd1">地址:</td><td class="MC_memtd2">${address}</td><td class="MC_memtd1">身分證字號:</td><td class="MC_memtd2">${idNumber}</td></tr>	
	<tr><td class="MC_memtd1">現有回饋金:</td><td class="MC_memtd2">${refund}</td><td class="MC_memtd1">註冊時間:</td><td class="MC_memtd2">${registerTime}</td></tr>
	</table>
    </div>         
</body>
</html>