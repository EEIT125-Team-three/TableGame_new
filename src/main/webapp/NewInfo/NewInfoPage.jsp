<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>123</title>
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





<a href="<c:url value="/exchange"/>">sssssssss</a>





<body class="header_body">
	<header> </header>
	<div class="menu">
		<h3>最新消息</h3>
		<dl id="optionmenu">
			<dd>
				<dl>
					<dt>新品上架</dt>
				</dl>
			</dd>
			<dd>
				<dl>
					<dt>
						<a href="regisact.html">課程資訊</a>
					</dt>
				</dl>
			</dd>
			<dd>
				<dl>
					<dt>活動消息</dt>
				</dl>
			<dd>
				<dl>
					<dt>開箱試玩</dt>
					<dd>
						<ul>
							<li><a href=#>最新開箱</a></li>
							<li><a href=#>玩法介紹</a></li>
							<li><a href=#>比賽直播</a></li>
						</ul>
					</dd>
				</dl>
			<dd>
				<dl>
					<dt>
							<a href=${pageContext.request.contextPath}/InfoManager>123管理者系統</a>
						</dt>	
					</dl>
	</div>
	<div class="box1">
		<h3>新品上架</h3>
		<figure class="f1">
			<img src="images/新品上架.jpg" alt="" width="200px" height="150px">
			<figcaption>
				最新、最夯的遊戲都在這裡<br>
				<br> <span>1.<a href=#>BG BIKINI 桌遊比基尼</a></span><br> <span>2.<a
					href=#>CAMEL UP 2020 駱駝大賽</a></span><br> <span>3.<a href=#>NIGHT
						OF WITNESSES 目擊者之夜</a></span><br> <span>4.<a href=#>ORIFLAMME
						富饒之城2</a></span><br>
			</figcaption>
	</div>
	</figure>
	<div class="box2">
		<h3>活動消息</h3>
		<figure class="f2">
			<img src="images/最新活動.jpg" alt="" width="200px" height="150px">
			<figcaption>
				一個人太無聊?揪團看過來<br>
				<br> <span><a href=#>[台北]桌遊聚會 2021-02-17 三重區綜合體育館</a></span><br>
				<span><a href=#>[台中]桌遊聚會 2021-03-06 龍邦美村</a></span><br> <span><a
					href=#>[台南]桌遊聚會 2020-12-26 台南文化創意產業園區</a></span><br> <span><a
					href=#>[高雄]桌遊聚會 2020-12-19 高雄國際會議中心</a></span><br>
			</figcaption>
	</div>
	</figure>
	</div>
	<div class="box3">
		<h3>課程資訊</h3>
		<figure class="f3">
			<img src="images/課程資訊.png" alt="" width="200px" height="150px">
			<figcaption>
				桌游大師的第一步，找個名師指導<br>
				<br> <span><a href=#>[台北] 2020-09-20 專業師資初階班</a></span><br>
				<span><a href=#>[台中] 2020-10-24 專業師資初階班</a></span><br> <span><a
					href=#>[嘉義] 2020-10-31 專業師資初階班</a></span><br> <span><a href=#>[高雄]
						2020-11-08 專業師資初階班</a></span><br>
			</figcaption>
	</div>
	</figure>
	<div class="box4">
		<h3>開箱試玩</h3>
		<figure class="f4">
			<img src="images/開箱試玩.jpg" alt="" width="200px" height="150px">
			<figcaption>
				想學桌遊沒時間?看看別人怎麼玩<br>
				<br> <span><a
					href=https://www.youtube.com/watch?v=sBMgeg0WdHg>地獄級桌遊《電車難題》!
						家人和朋友在鐵軌上你會選擇撞誰...?!</a></span><br> <span><a
					href=https://www.youtube.com/watch?v=tdT9POElwZc>恥力全開的18+桌遊
						我特地找了兩個變態《黃牌》</a></span><br>
			</figcaption>
	</div>
	</figure>
	</div>

</body>

</html>