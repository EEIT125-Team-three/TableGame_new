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
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>
<style>
.brain1 {
    float: left;
    border: 5px solid gray;
    border-radius: 15px;
    height: fit-content;
    text-align: center;
    padding: 15px;
    margin-left: 125px;
    color: black;
    margin-top: 25px;
    
}
</style>
</head>
<body class="header_body">
	<header> </header>

	<main role="main">
		<div class=" body">

			<div class="brain1">
				<a href='DiscussionBoard/SearchCata2?cata2=1'><img src="images/brain.jpg" width="250px"
					 height="250px"></a><br>
				<span style="position: relative; color: black;font-size:50px;font-weight:bold;">自然
				</span>
			</div>

			<div class="brain1">
				<a href='DiscussionBoard/SearchCata2?cata2=2'><img
					src="images/str.png" width="250px" height="250px"></a><br>
				<span style="position: relative; color: black;font-size:50px;font-weight:bold;">社會
				</span>
			</div>

			<div class="brain1">
			<a href='DiscussionBoard/SearchCata2?cata2=3'>
				<img src="images/cards.jpg" width="250px" height="250px"></a><br>
				<span style="position: relative; color: black;font-size:50px;font-weight:bold;">科技
				</span>
			</div>

			<div class="brain1">
			<a href='DiscussionBoard/SearchCata2?cata2=4'>
				<img src="images/party.jpg" width="250px" height="250px"></a><br>
				<span style="position: relative; color: black;font-size:50px;font-weight:bold;">健體
				</span>
			</div>

			<div class="brain1">
			<a href='DiscussionBoard/SearchCata2?cata2=5'>
				<img src="images/co.jpg" width="250px" height="250px"></a><br>
				<span style="position: relative; color: black;font-size:50px;font-weight:bold;">綜合
				</span>
			</div>

			<div class="brain1">
			<a href='DiscussionBoard/SearchCata2?cata2=6'>
				<img src="images/team.png" width="250px" height="250px"></a><br>
				<span style="position: relative; color: black;font-size:50px;font-weight:bold;">語文
				</span>
			</div>

			<div class="brain1">
			<a href='DiscussionBoard/SearchCata2?cata2=7'>
				<img src="images/cube.png" width="250px" height="250px"></a><br>
				<span style="position: relative; color: black;font-size:50px;font-weight:bold;">數學
				</span>
			</div>

			<div class="brain1">
			<a href='DiscussionBoard/SearchCata2?cata2=8'>
				<img src="images/child.jpg" width="250px" height="250px"></a><br>
				<span style="position: relative; color: black;font-size:50px;font-weight:bold;">藝術
				</span>
			</div>
<!-- 			<div class="old"> -->
<!-- 				<img src="images/old.png" width="250px" , height="250px"> -->
<!-- 				<h1 style="position: relative; color: black;"> -->
<!-- 					<big><big><big>樂齡類</big></big></big> -->
<!-- 				</h1> -->
<!-- 			</div> -->
		</div>
	</main>
	<footer class="footer_body">
</footer>
</body>
</html>