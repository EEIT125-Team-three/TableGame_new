<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>123</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shopCar.css">
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
    <script src="${pageContext.request.contextPath}/js/checkout.js"></script>
</head>

<body class="header_body">
	<header>
	</header>
	<article>
		<div class="shopCar_div5">
			<table class="shopCar_list">
			</table>
		</div>
		<hr>
		<div class="shopCar_div7">
			<span class="shopCar_span2">收件資訊</span><br><br>
			<form method="POST" action="checkout?totalAmount=${totalAmount}" name="form">
				<input style="display:none" name="item" value="${item}">
				<span>總金額:</span><input disabled="disabled" name="money" value="${totalAmount}"><br><br>
				<span>收件者姓名:</span><input name="sentToWho" value="${name}"><br><br>
				<span>連絡電話:</span><input name="sentToPhone" value="${phone}"><br><br>
				<span>收件地址:</span><input name="sentToWhere" value="${address}"><br><br>
			</form>
			<div style="text-align:right"><button id="checkout" style="font-size:30px">前往刷卡</button></div>
		</div>
    </article>
    <footer class="footer_body">
    </footer>
</body>

</html>