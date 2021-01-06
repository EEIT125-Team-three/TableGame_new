<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"
	type="text/javascript"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/shopCar.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/newinfo_style.css">
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>
<script src="${pageContext.request.contextPath}/js/Activity.js"></script>
<script src="${pageContext.request.contextPath}/js/InfoMenu.js"></script>
<title>123</title>
<style>
</style>
</head>

<body class="header_body">
	<header> </header>
	<div class="menu"></div>
	<div>
		<br><h2>活動介紹</h2>
		<fieldset class="block_act">
			<br>
			<div class="intro">
				<h3>闖關活動</h3>
				<p>
					逾百種中文版桌上遊戲現場免費教學，試玩遊戲闖關成功者，可參加抽獎！<br>
			</div>
			<div class="intro">
				<h3>桌遊講座</h3>
				<p>
					天天不同，場場精彩！適合教師、父母及助人工作者參與！<br>
			</div>
			<div class="intro">
				<h3>巨人桌遊派對</h3>
				<p>
					玩過翻滾刺蝟、消失的主角、烏邦果、三人成築的巨大版嗎？考驗體力與團隊合作能力，玩起來熱血沸騰，快來挑戰、跟我們全身動一動！ <br>
					<br>
			</div>
		</fieldset>
		<fieldset class="block_act">
			<br>
			<div class="intro">
				<h3>包牌套大賽</h3>
				<p>
					2人一組，現場報名，和你的麻吉一起來挑戰，首先將一盒全新遊戲包上牌套，便能獲得一盒超值桌遊！ <br>
			</div>
			<div class="intro">
				<h3>自助學桌遊</h3>
				<p>
					新天鵝堡每年發行新品逾40款，品項數已逾400款，有哪些是一直想要體驗卻苦無機會的嗎？自助區讓您一圓夢想，多試多玩，才能找到伴您一世的好夥伴！<br>
			</div>
			<div class="intro">
				<h3>買多送多</h3>
				<p>
					各項聚會限定優惠組合、特惠福袋，滿額再送桌遊⋯⋯年年不同的多種新奇挑戰獎項！中文版盒損品、泡水貨出清6折起！＊視盒損輕重做折扣。
					外文版清倉貨：比大小、絕對優惠！<br>
			</div>
		</fieldset>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<button type="button" onclick="showAllAreaAjax()">
					<h3>全部</h3>
				</button>
				<div class="Img_div">
					<img class="locImg"
						src="${pageContext.request.contextPath}/images/最新活動.jpg"
						width="300px" height="300">
					<p>一個人太無聊?揪團看過來，目前活動地點在台北、台中、高雄都有喔!
					<p>
				</div>
			</div>
			<div class="col-sm-3">
				<button type="button" onclick="showAreaAjax('台北')">
					<h3>台北</h3>
				</button>
				<div class="Img_div">
					<img class="locImg"
						src="${pageContext.request.contextPath}/images/天鵝堡桌遊館.jpg"
						width="300px" height="300">
					<p>地點:天鵝堡桌遊館
					<p>地址:116台北市文山區羅斯福路五段170巷28-32
					<p>
				</div>
			</div>
			<div class="col-sm-3">
				<button type="button" onclick="showAreaAjax('台中')">
					<h3>台中</h3>
				</button>
				<div class="Img_div">
					<img class="locImg"
						src="${pageContext.request.contextPath}/images/龍邦美村.jpg"
						width="300px" height="300">
					<p>地點:台中龍邦美村
					<p>地址:403台中市西區美村路一段272號
					<p>
				</div>
			</div>
			<div class="col-sm-3">
				<button type="button" onclick="showAreaAjax('高雄')">
					<h3>高雄</h3>
				</button>
				<div class="Img_div">
					<img class="locImg"
						src="${pageContext.request.contextPath}/images/高雄國際會議中心.jpg"
						width="300px" height="300">
					<p>地點:高雄國際會議中心
					<p>地址:高雄市鹽埕區中正四路274號
					<p>
				</div>
			</div>
		</div>
		<div class="Info">
			<div class="actInfo">
				<p style="margin-bottom: 3px; margin-top: 3px; font-size: 50px">${info.activityId}</p>
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
					<tbody>
					</tbody>
				</table>
				<form id='addEvent' method='POST' action='signUp'>
					<input type='text' name='active' value='1' style='display: none'>
				</form>
			</div>
		</div>
	</div>
	<br>
</body>

</html>