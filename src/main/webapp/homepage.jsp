<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>123</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/首頁.css">
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
</head>

<body class="header_body">
	<header>
	</header>
	<article>
		<div class="homepage_divst1"
			style='background-image: url(${pageContext.request.contextPath}/images/墨綠色背景.jpg);'>
			<figure style="float: left; margin: 5px;">
				<img src="${pageContext.request.contextPath}/images/遊戲圖片1.jpeg"
					class='homepage_img'>
				<figcaption class='homepage_figcaption'>!網站維護公告!</figcaption>
			</figure>
			<div class='homepage_divst2'>
				<ol style="line-height: 2;">
					<li>無限期網站維護中</li>
					<li>無限期網站維護中</li>
					<li>無限期網站維護中</li>
					<li>無限期網站維護中</li>
					<li>無限期網站維護中</li>
					<li>無限期網站維護中</li>
					<li>無限期網站維護中</li>
					<li>無限期網站維護中</li>
				</ol>

			</div>

		</div>
		<div class="homepage_divst1"
			style='background-image: url(${pageContext.request.contextPath}/images/墨綠色背景.jpg);'>
			<figure style="float: left; margin: 5px;">
				<img src="${pageContext.request.contextPath}/images/遊戲圖片2.jpeg"
					class='homepage_img'>
				<figcaption class='homepage_figcaption'>桌遊爆新聞</figcaption>
			</figure>
			<div class='homepage_divst2'>
				<ol style="line-height: 2;">
					<li>有一款新桌遊發行!</li>
					<li>有二款新桌遊發行!</li>
					<li>有三款新桌遊發行!</li>
					<li>永遠不會有新聞</li>
					<li>永遠不會有新聞</li>
					<li>永遠不會有新聞</li>
					<li>永遠不會有新聞</li>
					<li>永遠不會有新聞</li>
				</ol>

			</div>
		</div>

		<div class="homepage_divst1"
			style="clear: both;margin-top: 5px;background-image: url(${pageContext.request.contextPath}/images/墨綠色背景.jpg);">
			<figure style="float: left; margin: 5px;">
				<img src="images/遊戲圖片3.jpeg" class='homepage_img'>
				<figcaption
					class='${pageContext.request.contextPath}/homepage_figcaption'>享玩桌遊
					遊戲王爭霸戰</figcaption>
			</figure>
			<div class='homepage_divst2'>
				<ol style="line-height: 2;">
					<li>專題二爆炸大亂鬥</li>
					<li>專題三爆炸大亂鬥</li>
					<li>期末專題爆炸大亂鬥</li>
					<li>永遠不會有比賽</li>
					<li>永遠不會有比賽</li>
					<li>永遠不會有比賽</li>
					<li>永遠不會有比賽</li>
					<li>永遠不會有比賽</li>
				</ol>

			</div>
		</div>
		<div class="homepage_divst1"
			style="margin-top: 5px;background-image: url(${pageContext.request.contextPath}/images/墨綠色背景.jpg);">
			<figure style="float: left; margin: 5px;">
				<img src="${pageContext.request.contextPath}/images/家庭3.jpeg"
					class='homepage_img'>
				<figcaption class='homepage_figcaption'>桌遊家庭日</figcaption>
			</figure>
			<div class='homepage_divst2'>
				<ol style="line-height: 2;">
					<li>享玩 桌遊聚-桃園場次</li>
					<li>享玩 桌遊聚-台北場次</li>
					<li>享玩 桌遊聚-台中場次</li>
					<li>享玩 桌遊聚-高雄場次</li>
					<li>桌遊研習營</li>
					<li>沒活動</li>
					<li>沒活動</li>
					<li>沒活動</li>
				</ol>

			</div>

		</div>

	</article>
	<footer class="footer_body">
	</footer>
</body>

</html>