<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
<title>活動頁面</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/newinfo_style.css">
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>
<script src="${pageContext.request.contextPath}/js/InfoMenu.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"
	type="text/javascript"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/Activity.js"></script>
</head>

<body class="header_body">
	<header> </header>
	<div class="menu"></div>
	<fieldset class="Act_field">
		<h2>活動介紹</h2>
		<div class="block_act">
			<div class="intro">
				<h3>闖關活動</h3>
				逾百種中文版桌上遊戲現場免費教學，試玩遊戲闖關成功者，可參加抽獎！
			</div>
			<div class="intro">
				<h3>桌遊講座</h3>
				天天不同，場場精彩！適合教師、父母及助人工作者參與！
			</div>
			<div class="intro">
				<h3>巨人桌遊派對</h3>
				玩過翻滾刺蝟、消失的主角、烏邦果、三人成築的巨大版嗎？考驗體力與團隊合作能力，玩起來熱血沸騰，快來挑戰、跟我們全身動一動！
			</div>
		</div>

		<div class="block_act">
			<div class="intro">
				<h3>包牌套大賽</h3>
				2人一組，現場報名，和你的麻吉一起來挑戰，首先將一盒全新遊戲包上牌套，便能獲得一盒超值桌遊！
			</div>
			<div class="intro">
				<h3>自助學桌遊</h3>
				新天鵝堡每年發行新品逾40款，品項數已逾400款，有哪些是一直想要體驗卻苦無機會的嗎？自助區讓您一圓夢想，多試多玩，才能找到伴您一世的好夥伴！
			</div>
			<div class="intro">
				<h3>買多送多</h3>
				聚會限定優惠組合、特惠福袋，滿額再桌遊年年不同的多種新奇挑戰獎項！中文版盒損品、泡水貨出清6折起！＊視盒損輕重做折扣。
			</div>
		</div>
	</fieldset>
	<fieldset class="Act_field">
		<h1>活動地點</h1>
		<div class="ActCon">
			<div class="container">
				<div class="row">
					<div class="col-1" style="float: left; width: 20%; margin-left: 4%">
						<button type="button" onclick="showAllAreaAjax()">
							<h3>全部</h3>
						</button>
						<p>
						<div class="Img_div">
							<img class="locImg"
								src="${pageContext.request.contextPath}/images/活動廣播.png"
								width="300px" height="300"> <br>一個人太無聊?揪團看過來<br>目前活動地點在台北、台中、高雄都有喔!
						</div>
					</div>

					<div class="col-1" style="float: left; width: 20%; margin-left: 4%">
						<button type="button" onclick="showAreaAjax('台北')">
							<h3>台北</h3>
						</button>
						<p>
						<div class="Img_div">
							<img class="locImg"
								src="${pageContext.request.contextPath}/images/三重區綜合體育館.jpg"
								width="300px" height="300"> <br>地點:三重區綜合體育場
						</div>
					</div>

					<div class="col-1" style="float: left; width: 20%; margin-left: 4%">
						<button type="button" onclick="showAreaAjax('台中')">
							<h3>台中</h3>
						</button>
						<p>
						<div class="Img_div">
							<img class="locImg"
								src="${pageContext.request.contextPath}/images/龍邦美村.jpg"
								width="300px" height="300"> <br>地點:台中龍邦美村
						</div>
					</div>

					<div class="col-1" style="float: left; width: 20%; margin-left: 4%">
						<button type="button" onclick="showAreaAjax('高雄')">
							<h3>高雄</h3>
						</button>
						<p>
						<div class="Img_div">
							<img class="locImg"
								src="${pageContext.request.contextPath}/images/高雄國際會議中心.jpg"
								width="300px" height="300"> <br>地點:高雄國際會議中心
						</div>
					</div>

				</div>
				<div class="Info">
					<div class="actInfo">
						<p style="margin-bottom: 3px; margin-top: 3px; font-size: 50px">${info.activityId}</p>
						<table class="Act_tb" bgcolor="#CECEFF" border='1' cellspacing='5'
							cellpadding='5'>
							<thead bgcolor="#00A600">
								<th>地區</th>
								<th>類型</th>
								<th>活動</th>
								<th>地點</th>
								<th>地址</th>
								<th>日期(一)</th>
								<th>開始時間(一)</th>
								<th>結束時間(一)</th>
								<th>日期(二)</th>
								<th>開始時間(二)</th>
								<th>結束時間(二)</th>
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
		</div>
	</fieldset>
	<footer class="footer_body"> </footer>
</body>

</html>