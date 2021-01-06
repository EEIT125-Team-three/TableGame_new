<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"
	type="text/javascript"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/shopCar.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/newinfo_style.css">
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>
<script src="${pageContext.request.contextPath}/js/Course.js"></script>
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
					<button type="button" style="border: 5px #9999FF dashed;"
						onclick="showCourseAjax('桌遊研習')">
						<img class="ClassImg"
							src="${pageContext.request.contextPath}/images/桌遊研習.png" alt=""
							height="200px">
					</button>
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
				<div class="contentIntro">
					<h4>講師:林彥光</h4>
					<p>兼具教學者、設計師、桌遊店經營者、桌遊玩家於一身的桌遊人。志向是讓台灣桌遊在全世界展露頭角。 ‍
					<p>現任｜新天鵝堡桌遊編輯 &桌遊資深講師
					<p>經歷｜電玩遊戲公司2D美術、玩具牧場桌上遊戲主題餐廳負責人、桌遊研究及教學超過10年
				</div>
				<h1 align="center" style="color: red;">點擊貼圖查詢與報名</h1>
				<table bgcolor="green" border="1" style="text-align: center;">
					<tbody class="tb1"></tbody>
				</table>
			</fieldset>
		</div>
		<div class="classes">
			<fieldset class="block">
				<div class="conpic">
					<h2>桌遊營</h2>
					<button type="button" style="border: 5px #9999FF dashed;"
						onclick="showCampAjax()">
						<img class="ClassImg"
							src="${pageContext.request.contextPath}/images/同樂會.png" alt=""
							height="200px">
					</button>
				</div>
				<h3>場次介紹</h3>
				<div class="content1">
					<h4>台北場</h4>
					<p>
						1. 採分組遊戲 <br>2. 各組由一位遊戲老師帶領進行當天的主題遊戲。 <br>3.天氣許可進行戶外活動，分組對抗活動。
						<br>4. 點心時間，延續當日主題進行桌遊課程 <br>5. 分享與討論遊戲心得。
				</div>

				<div class="content2">
					<h4>台中場</h4>
					<p>
						本梯營隊首推主題式融合桌遊教學 <br>由經驗豐富的老師帶領孩子探索桌遊的故事與內涵 <br>體驗機制享受桌遊魅力，玩遊戲給你不一樣的超能力～




					
				</div>
				<div class="content3">
					<h4>高雄場</h4>
					<p>
						營隊採分組進行遊戲，每組由一位遊戲指導員帶領 <br>上午進行各種機制主題的新遊戲介紹，中午休息九十分鐘 <br>下午由孩子們選擇自己想玩的遊戲來玩，分享與討論遊戲心得



					
				</div>
				<br>
				<table border='1' cellspacing='5' cellpadding='5'>
					<thead bgcolor="#00A600">
						<th>地區</th>
						<th>類型</th>
						<th>活動</th>
						<th>日期(1)</th>
						<th>開始時間(1)</th>
						<th>結束時間(1)</th>
						<th>日期(2)</th>
						<th>開始時間(2)</th>
						<th>結束時間(2)</th>
						<th>天數</th>
						<th>限制人數</th>
						<th>費用</th>
						<th>報名活動</th>
					</thead>
					<tbody class="tb2">
					</tbody>
				</table>
			</fieldset>
		</div>
	</div>
	<footer> </footer>
</body>

</html>