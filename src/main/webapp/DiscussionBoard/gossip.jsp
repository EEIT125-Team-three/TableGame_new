<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>討論區-分類</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/P1.css">
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>
</head>
<body class="header_body">
	<header> </header>

	<main role="main">
		<div class=" body">

			<div class="brain1">
				<a href=T1.jsp><img src="images/brain.jpg" width="250px"
					, height="250px"></a>
				<h1 style="position: relative; color: black;">
					<big><big><big>大腦類</big></big></big>
				</h1>
			</div>

			<div class="str">
				<a href='DiscussionBoard/Discussion-Brain.jsp'><img
					src="images/str.png" width="250px" , height="250px"></a>
				<h1 style="position: relative; color: black;">
					<big><big><big>策略類</big></big></big>
				</h1>
			</div>

			<div class="cards">
				<img src="images/cards.jpg" width="250px" , height="250px">
				<h1 style="position: relative; color: black;">
					<big><big><big>卡牌類</big></big></big>
				</h1>
			</div>

			<div class="party">
				<img src="images/party.jpg" width="250px" , height="250px">
				<h1 style="position: relative; color: black;">
					<big><big><big>派對類</big></big></big>
				</h1>
			</div>

			<div class="co">
				<img src="images/co.jpg" width="250px" , height="250px">
				<h1 style="position: relative; color: black;">
					<big><big><big>合作類</big></big></big>
				</h1>
			</div>

			<div class="team">
				<img src="images/team.png" width="250px" , height="250px">
				<h1 style="position: relative; color: black;">
					<big><big><big>陣營類</big></big></big>
				</h1>
			</div>

			<div class="speed">
				<img src="images/cube.png" width="250px" , height="250px">
				<h1 style="position: relative; color: black;">
					<big><big><big>競速類</big></big></big>
				</h1>
			</div>

			<div class="child">
				<img src="images/child.jpg" width="250px" , height="250px">
				<h1 style="position: relative; color: black;">
					<big><big><big>兒童類</big></big></big>
				</h1>
			</div>
			<div class="old">
				<img src="images/old.png" width="250px" , height="250px">
				<h1 style="position: relative; color: black;">
					<big><big><big>樂齡類</big></big></big>
				</h1>
			</div>
		</div>
	</main>
</body>
</html>