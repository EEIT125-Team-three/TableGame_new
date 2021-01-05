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
					<a href="/searchStudy"><h2>桌遊研習</h2> <img class="ClassImg"
						src="${pageContext.request.contextPath}/images/桌遊研習.png" alt=""
						height="200px"></a>
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
					<h4>講師:林彥光</h4>
					<p>兼具教學者、設計師、桌遊店經營者、桌遊玩家於一身的桌遊人。志向是讓台灣桌遊在全世界展露頭角。 ‍
					<p>現任｜新天鵝堡桌遊編輯 &桌遊資深講師
					<p>經歷｜電玩遊戲公司2D美術、玩具牧場桌上遊戲主題餐廳負責人、桌遊研究及教學超過10年
				</div>
				<table bgcolor="green" border='1'>
					<tr bgcolor="white">
						<th>地點</th>
						<th colspan='6'>${info.actArea}</th>
					</tr>
					<tr bgcolor="white">
						<th>地址</th>
						<th colspan='6'>${info.actAddress}</th>
					</tr>
					<tr bgcolor="white">
						<td>第一天日期</td>
						<td>開始時間</td>
						<td>結束時間</td>
						<td>第二天日期</td>
						<td>開始時間</td>
						<td>結束時間</td>
						<td>立即報名</td>
					</tr>
					<tr bgcolor="white">
						<td>${info.actDate1}</td>
						<td>${info.actStrtime1}</td>
						<td>${info.actEndtime1}</td>
						<td>${info.actDate2}</td>
						<td>${info.actStrtime2}</td>
						<td>${info.actEndtime2}</td>
						<td><a href='UpdateInfo?activityId=${info.activityId}'><button
									type='button'>我要報名</button></a></td>
					</tr>
				</table>
			</fieldset>
		</div>
		<div class="classes">
			<fieldset class="block">
				<div class="conpic">
					<a href="/searchCamp"><h2>桌遊營</h2>
					<img class="ClassImg"
						src="${pageContext.request.contextPath}/images/同樂會.png" alt=""
						height="200px"></a>
				</div>
			</fieldset>
		</div>
		<div class="classes">
			<fieldset class="block">
				<div class="conpic">
					<a href="/searchTeach"><h2>師資培訓班</h2>
					<img class="ClassImg"
						src="${pageContext.request.contextPath}/images/師資培訓.png" alt=""
						height="200px"></a>
				</div>
			</fieldset>
		</div>
	</div>
	<tbody>
	</tbody>
	<footer> </footer>
</body>

</html>