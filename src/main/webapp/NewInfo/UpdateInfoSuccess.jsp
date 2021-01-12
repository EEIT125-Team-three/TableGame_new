<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html lang="zh-Hant-TW">

<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header_style.css">
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/styles.css'
	type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success</title>
</head>
<body class="header_body">
	<h1>活動資料新增成功</h1>
	<Font color='blue'>親愛的${userIdKey}您好，您的輸入資料已經處理完畢</font>
	<small>&lt;&lt;<a
		href="${pageContext.request.contextPath}/NewInfoManager">回到新增頁面</a>&gt;&gt;
	</small>
	<footer class="footer_body"> </footer>
</body>
</html>