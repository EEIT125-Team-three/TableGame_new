<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>123</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shopCar.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
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
			<form method="POST" action="checkout" name="form">
				<input style="display:none" name="item" value="${item}">
				<input hidden="hidden" name="totalAmount" value="${totalAmount}">
				<span>收件者姓名:</span><input name="sentToWho" value="${name}"><br><br>
				<span>連絡電話:</span><input name="sentToPhone" value="${phone}"><br><br>
				<span>收件地址:</span>
				<select id="city" name="city" style="font-size:30px">
					<option>縣市</option>
				</select>
				<select id="district" name="district" style="font-size:30px;">
					<option>鄉鎮市區</option>
				</select>
				<select id="road" name="road" style="font-size:30px;">
					<option>街路</option>
				</select><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input name="sentToWhere" placeholder="完整地址" value="${address}"><br><br>
				<span>目前回饋金<span id="nowRefund" style=""><fmt:formatNumber value="${refund}" /></span>元，結帳後為<span id="finalRefund"><fmt:formatNumber value="${(refund+(totalAmount-totalAmount%10)/10)}" /></span>元</span><br><br>
				<input type="radio" class="useRefund" name="useRefund" value="0" style="width:30px; height:30px;" checked="checked"> 不使用折扣<br><br>
				<input type="radio" class="useRefund" id="useRefund" name="useRefund" value="1" style="width:30px; height:30px;" hidden="hidden">
				<label for="useRefund" hidden="hidden">使用回饋金折扣(<span id="refund"><fmt:formatNumber value="${refund}" /></span>元)</label><br><br>
				<input type="radio" class="useRefund" name="useRefund" value="2" style="width:30px; height:30px;"><input disabled="disabled" value="輸入折扣碼">
				<hr style="border:3px solid ">
			</form>
			<span>總金額:</span>
				<span hidden="hidden">
					<del>
						<fmt:formatNumber value="${totalAmount}" />
					</del>
					<del>
						元
					</del>
					&nbsp;&nbsp;
				</span>
				<span>
					<span id="total"><fmt:formatNumber value="${totalAmount}" /></span>
					元
				</span>
				<span>
					(取得回饋金
					<span id="getRefund"><fmt:formatNumber value="${(totalAmount-totalAmount%10)/10}" /></span>
					元)
				</span><br><br>
			<div style="text-align:right;"><button id="checkout" style="font-size:30px">前往刷卡</button></div>
		</div>
    </article>
    <footer class="footer_body">
    </footer>
</body>

</html>