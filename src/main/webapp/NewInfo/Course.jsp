<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/shopCar.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/newinfo_style.css">
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>
</head>

<body class="header_body">
	<script src="${pageContext.request.contextPath}/js/InfoMenu.js"></script>
	<header> </header>
	<div class="menu"></div>
	<h1>課程項目</h1>
	<div class="Item">
		<div class="classes">
			<fieldset class="block">
				<div class="conpic">
					<h2>桌遊研習</h2>
					<img class="ClassImg"
						src="${pageContext.request.contextPath}/images/桌遊研習.png" alt=""
						height="200px">
				</div>
				<h3>課程內容</h3>
				<div class="content1">
					<h4>第一天</h4>
					桌遊的過去與現在<br>桌遊的組合成分 <br>桌遊機制分析<br> 桌遊設計的重點<br>
					製作樣品<br> 撰寫規則書
				</div>
				<div class="content2">
					<h4>第二天</h4>
					盜版與抄襲<br>桌遊製作流程 <br>遊戲自己出介紹<br>自製遊戲<br>簡報說明書<br>
					桌遊測試
				</div>
				<div class="content3">
					<h4>相關資訊</h4>
					講師:林彥光<br>課程費用:<br>地點:<br>第一天:時間:<br>第二天:時間:
				</div>
			</fieldset>
		</div>
		<div class="classes">
			<fieldset class="block">
				<div class="conpic">
					<h2>桌遊營</h2>
					<img class="ClassImg"
						src="${pageContext.request.contextPath}/images/同樂會.png" alt=""
						height="200px">
				</div>
			</fieldset>
		</div>
		<div class="classes">
			<fieldset class="block">
				<div class="conpic">
					<h2>師資培訓班</h2>
					<img class="ClassImg"
						src="${pageContext.request.contextPath}/images/師資培訓.png" alt=""
						height="200px">
				</div>
			</fieldset>
		</div>
	</div>
	<tbody>
	</tbody>
	<footer> </footer>
</body>

</html>