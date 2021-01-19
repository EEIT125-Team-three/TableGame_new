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
	<fieldset>
		<div id="container">
			<div id="list" style="left: -600px;"></div>
			<img class="act_img" src="images/桌遊活動圖片5.jpg" alt="1" /> 
			<img class="act_img" src="images/桌遊活動圖片1.jpg" alt="1" /> 
			<img class="act_img" src="images/桌遊活動圖片2.jpg" alt="2" />
			<img class="act_img" src="images/桌遊活動圖片3.jpg" alt="3" />
			<img class="act_img" src="images/桌遊活動圖片4.jpg" alt="4" /> 
			<img class="act_img" src="images/桌遊活動圖片5.jpg" alt="5" />
			<img class="act_img" src="images/桌遊活動圖片1.jpg" alt="5" />
			<div id="buttons">
				<span index="1" class="on"></span> <span index="2"></span> <span
					index="3"></span> <span index="4"></span> <span index="5"></span>
			</div>
			<a href="javascript:;" id="prev" class="arrow">&lt;</a> <a
				href="javascript:;" id="next" class="arrow">&gt;</a>
		</div>
	</fieldset>
</body>
<fieldset>
	<div class="InfoItem">
		<h1>最新消息</h1>
		<div class="container">
			<div class="row">
				<div class="col-1" style="float: left; width: 25%; margin-left: 4%">
					<a href="${pageContext.request.contextPath}/MyActivity"> <img
						src="${pageContext.request.contextPath}/images/新品上架.png"
						alt="我的活動" style="width: 60%">
						<div class="caption">
							<p>
							<h3>我的活動</h3>
							<p>
						</div>
					</a>
				</div>
				<div class="col-1" style="float: left; width: 25%; margin-left: 4%">

					<a href="${pageContext.request.contextPath}/NewActivityPage"> <img
						src="${pageContext.request.contextPath}/images/活動廣播.png"
						alt="活動廣播." style="width: 60%">
						<div class="caption">
							<p>
							<h3>活動廣播</h3>
							<p>
						</div>
					</a>
				</div>
				<div class="col-1" style="float: left; width: 25%; margin-left: 4%">
					<a href="${pageContext.request.contextPath}/Course"> <img
						src="${pageContext.request.contextPath}/images/課程項目.png"
						alt="課程項目" style="width: 60%">
						<div class="caption">
							<p>
							<h3>課程資訊</h3>
							<p>
						</div>
					</a>
				</div>
			</div>
		</div>
	</div>
</fieldset>
</body>


</html>