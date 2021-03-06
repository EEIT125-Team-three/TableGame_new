<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>享玩 桌遊 | 最新消息</title>
<link rel="icon"
	href="${pageContext.request.contextPath}/images/favicon.ico"
	type="image/x-icon" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/newinfo_style.css">
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>
<script src="js/jquery-2.0.3.min.js"></script>
<script type="text/javascript">
	window.onload = function() {
		var list = document.getElementById('list');
		var prev = document.getElementById('prev');
		var next = document.getElementById('next');

		function animate(offset) {
			/*獲取的是style.left，是相對左邊獲取距離，所以第一張圖后style.left都為負值，
			且style.left獲取的是字符串，需要用parseInt()取整轉化為數字。*/
			var newLeft = parseInt(list.style.left) + offset;
			list.style.left = newLeft + 'px';
			if (newLeft < -3000) {
				list.style.left = -600 + 'px';
			}
			if (newLeft > -600) {
				list.style.left = -3000 + 'px';
			}
		}
		/*上一步*/
		prev.onclick = function() {
			animate(600);
		}
		/*下一步*/
		next.onclick = function() {
			animate(-600);
		}
		/*自動循環播放*/
		var timer;

		function play() {
			timer = setInterval(function() {
				prev.onclick();
			}, 1500)
		}
		play();
		/*鼠標放上（離開）對應輪播暫停（播放）*/
		var container = document.getElementById('container');
		function stop() {
			clearInterval(timer);
		}
		container.onmouseover = stop;
		container.onmouseout = play;
	}
</script>
<script src="${pageContext.request.contextPath}/js/InfoMenu.js"></script>
</head>
<body class="header_body">
	<header> </header>
	<div class="menu"></div>
	<fieldset style="border: 0;">
		<div class="InfoItem">
			<div class="container align-items-center">
				<div class="row align-items-center">

					<div class="col-1"
						style="float: left; width: 30%; border-radius: 10%; margin: 0% 0% 20px 3%; background-color: #FFFFAA;">
						<a href="${pageContext.request.contextPath}/NewActivityPage"><br>
							<button type="button" class="caption">活動廣播</button> <br> <img
							src="${pageContext.request.contextPath}/images/活動廣播.png"
							alt="活動廣播." style="width: 250px; float: left"></a>
						<div class="ActItem" style="float: left">
							<h2>內容</h2>
							活動內容介紹<br> 全台活動地點<br> 各地地點查詢<br> 立即報名<br> <br>
						</div>
					</div>
					<div class="col-1"
						style="float: left; width: 30%; border-radius: 10%; margin: 0% 0% 20px 3%; background-color: #FFFFAA;">
						<a href="${pageContext.request.contextPath}/Course"><br>
							<button type="button" class="caption">課程項目</button> <br> <img
							src="${pageContext.request.contextPath}/images/課程項目.png"
							alt="課程項目" style="width: 250px; float: left"> </a>
						<div class="ActItem" style="float: left">
							<h2>內容</h2>
							課程指導資訊<br> 導師資訊<br> 桌遊營介紹<br> 報名資訊<br> <br>
						</div>
					</div>
					<div class="col-1"
						style="float: left; width: 30%; border-radius: 10%; margin: 0% 0% 20px 3%; background-color: #FFFFAA;">
						<a href="${pageContext.request.contextPath}/MyActivity"><br>
							<button type="button" class="caption">我的活動</button> <br> <img
							src="${pageContext.request.contextPath}/images/新品上架.png"
							alt="我的活動" style="width: 250px; float: left"> </a>
						<div class="ActItem" style="float: left">
							<h2>內容</h2>
							參與活動查詢<br> 報名狀態確認<br>報名繳費資訊<br>
						</div>
					</div>
				</div>
			</div>
		</div>
	</fieldset>
	<fieldset class="InfoPageField">
		<div id="container" style="border-radius: 30px; margin: auto;">
			<div id="list" style="left: -600px;">
				<img class="act_img" src="images/桌遊活動圖片5.jpg" width="600px" alt="1" />
				<img class="act_img" src="images/桌遊活動圖片1.jpg" width="600px" alt="1" />
				<img class="act_img" src="images/桌遊活動圖片2.jpg" width="600px" alt="2" />
				<img class="act_img" src="images/桌遊活動圖片3.jpg" width="600px" alt="3" />
				<img class="act_img" src="images/桌遊活動圖片4.jpg" width="600px" alt="4" />
				<img class="act_img" src="images/桌遊活動圖片5.jpg" width="600px" alt="5" />
				<img class="act_img" src="images/桌遊活動圖片1.jpg" width="600px" alt="5" />
				<div id="buttons">
					<span index="1" class="on"></span> <span index="2"></span> <span
						index="3"></span> <span index="4"></span> <span index="5"></span>
				</div>
			</div>
			<a href="javascript:;" id="prev" class="arrow">&lt;</a> <a
				href="javascript:;" id="next" class="arrow">&gt;</a>
		</div>
	</fieldset>
</body>
<footer class="footer_body"> </footer>
</body>


</html>