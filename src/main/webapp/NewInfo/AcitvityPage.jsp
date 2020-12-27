<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Document</title>
<style>
.loc {
	border: dash green 3px;
	height: 100px;
	background-color: green;
	border-radius: 30px;
	margin: 30px;
}
.actInfo{
float:left;
background-color:blue;
}
.LocImg{
float:left;
}
</style>
</head>
<body>
	<div class="jumbotron text-center">
		<h1>活動資訊</h1>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<h3>全部</h3>
			</div>
			<div class="col-sm-3">
				<h3>北部</h3>
			</div>
			<div class="col-sm-3">
				<h3>中部</h3>
			</div>
			<div class="col-sm-3">
				<h3>南部</h3>
			</div>
		</div>
	</div>
	<div class="Info">

			<img class="LocImg" src="${pageContext.request.contextPath}/images/台南文化創意園區.jpg" width="300px" height="300"px>

		<div class="actInfo">
			<p style="color: blue; margin-bottom: 3px; margin-top: 3px; font-size: 50px">${info.activityId}</p>
			<p>地點:${Info.actLocation}</p>
			<p>地址 :${Info.actAddress}</p>
			<div class="buy_btn" onclick='frontpage()'>回上一頁</div>
			<div class="buy_btn" style='left: 1270px;'>查詢日期</div>

		</div>
	</div>
</body>
</html>