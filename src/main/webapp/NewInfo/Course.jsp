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
<script src="${pageContext.request.contextPath}/js/InfoMenu.js"></script>
</head>

<body class="header_body">
	<header> </header>
	<div class="menu"></div>
	<h1>課程項目</h1>
	<div class="Item">
		<div class="classes">
			<fieldset class="block">
				<div class="study">
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
					<p>
					<div class="content2">
						<h4>第二天</h4>
						盜版與抄襲<br>桌遊製作流程 <br>遊戲自己出介紹<br>自製遊戲<br>簡報說明書<br>
						桌遊測試
					</div>
					<p>
					<div class="contentIntro">
						<h4>講師:林彥光</h4>
						<p>兼具教學者、設計師、桌遊店經營者、桌遊玩家於一身的桌遊人。志向是讓台灣桌遊在全世界展露頭角。 ‍
						<p>現任｜新天鵝堡桌遊編輯 &桌遊資深講師
						<p>經歷｜電玩遊戲公司2D美術、玩具牧場桌上遊戲主題餐廳負責人、桌遊研究及教學超過10年
					</div>
					<p>
					<div class="contentIntro">
						<h4>講師:林彥光</h4>
						<p>兼具教學者、設計師、桌遊店經營者、桌遊玩家於一身的桌遊人。志向是讓台灣桌遊在全世界展露頭角。 ‍
						<p>現任｜新天鵝堡桌遊編輯 &桌遊資深講師
						<p>經歷｜電玩遊戲公司2D美術、玩具牧場桌上遊戲主題餐廳負責人、桌遊研究及教學超過10年
					</div>
				</div>
				<p>
				<div class="courseCon">
					<form id='addEvent' method='POST' action='signUp'>
						<input type='text' name='active' value='1' style='display: none'>
					</form>
					<div class="container">
						<div class="row"></div>
					</div>
				</div>
			</fieldset>
		</div>
		<div class="classes">
			<fieldset class="block">
				<h2>桌遊營</h2>

				<h3>場次介紹</h3>
				<fieldset>
					<button class="Camp_btn" type="button"
						style="border: 5px #9999FF dashed;" onclick="showTPICampAjax()">
						<div class="contentCamp">
							<h4>台北場</h4>
							1. 採分組遊戲 <br>2. 主題遊戲帶領(指導員) <br>3.戶外活動(天氣許可) <br>4.
							分組對抗活動。<br>5. 點心時間 <br>6. 分享與討論遊戲心得。
							<p>
						</div>
					</button>
					<p>
					<div class="Tab1">
						<table class="C_tab" border='1' cellspacing='5' cellpadding='5'>
							<tbody class="TPItab">
							</tbody>
						</table>
					</div>
				</fieldset>
				<fieldset>
					<button class="Camp_btn" type="button"
						style="border: 5px #9999FF dashed;" onclick="showTCHCampAjax()">
						<div class="contentCamp">
							<h4>台中場</h4>
							1. 主題式融合桌遊教學 <br>2. 桌遊故事探索與內涵 <br>3. 體驗多種遊戲機制<br>4.
							享受桌遊魅力
							<p>
						</div>
					</button>
					<p>
					<div class="Tab1">
						<table class="C_tab" border='1' cellspacing='5' cellpadding='5'>
							<tbody class="TCHtab">
							</tbody>
						</table>
					</div>
				</fieldset>
				<fieldset>
					<button class="Camp_btn" type="button"
						style="border: 5px #9999FF dashed;" onclick="showKOHCampAjax()">
						<div class="contentCamp">
							<h5>高雄場</h5>
							1. 分組進行遊戲(有指導員) <br>2. 新遊戲介紹與遊玩 <br>3. 中午休息:九十分鐘 <br>4.
							自由遊玩分享 <br>5. 遊戲心得討論
							<p>
						</div>
					</button>
					<p>
					<div class="Tab1">
						<table class="C_tab" border='1' cellspacing='5' cellpadding='5'>
							<tbody class="KOHtab">
							</tbody>
						</table>
					</div>
				</fieldset>
				<form id='addEvent' method='POST' action='signUp'>
					<input type='text' name='active' value='1' style='display: none'>
				</form>
			</fieldset>
		</div>
	</div>
	<footer> </footer>
</body>

</html>