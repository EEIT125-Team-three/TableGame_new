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
.loc {
	border: dash green 3px;
	height: 100px;
	background-color: green;
	border-radius: 30px;
	margin: auto;
	align: center;
}

.locImg {
	border-radius: 30px;
}
</style>
</head>

<body class="header_body">
	<header> </header>
	<div class="menu"></div>
	<div>
		<h2>活動介紹</h2>
		<div class="intro">
			闖關活動<br> 逾百種中文版桌上遊戲現場免費教學，試玩遊戲闖關成功者，可參加抽獎！<br> 闖關活動<br>
			逾百種中文版桌上遊戲現場免費教學，試玩遊戲闖關成功者，可參加抽獎！<br> 闖關活動<br>
			逾百種中文版桌上遊戲現場免費教學，試玩遊戲闖關成功者，可參加抽獎！<br> 闖關活動<br>
			逾百種中文版桌上遊戲現場免費教學，試玩遊戲闖關成功者，可參加抽獎！<br>
		</div>
		<div class="intro">
			闖關活動<br> 逾百種中文版桌上遊戲現場免費教學，試玩遊戲闖關成功者，可參加抽獎！<br> 闖關活動<br>
			逾百種中文版桌上遊戲現場免費教學，試玩遊戲闖關成功者，可參加抽獎！<br> 闖關活動<br>
			逾百種中文版桌上遊戲現場免費教學，試玩遊戲闖關成功者，可參加抽獎！<br> 闖關活動<br>
			逾百種中文版桌上遊戲現場免費教學，試玩遊戲闖關成功者，可參加抽獎！<br>
		</div>
	</div>
	<br>
	<fieldset>
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
						<p>
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
						<p>地點:天鵝堡桌遊館
						<p>
						<p>地址:116台北市文山區羅斯福路五段170巷28-32
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
						<p>地點:天鵝堡桌遊館
						<p>
						<p>地址:116台北市文山區羅斯福路五段170巷28-32
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
					<input type='text' name='active' value='1' style='display:none'>
					</form>
				</div>
			</div>
		</div>
		<br>

	</fieldset>
	<br>
</body>

</html>