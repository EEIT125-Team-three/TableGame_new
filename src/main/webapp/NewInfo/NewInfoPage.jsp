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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>
</head>


<body class="header_body">
	<script src="${pageContext.request.contextPath}/js/InfoMenu.js"></script>
	<header> </header>
	<div class="menu"></div>

	<div class="container">
		<h1>最新消息</h1>

		<div class="row">
			<div class="col-md-4">
				<div class="thumbnail">
					<a href="" target="_blank"> <img
						src="${pageContext.request.contextPath}/images/新品上架.png"
						alt="新品上架" style="width: 80%">
						<div class="caption">
							<p>
							<h3>新品上架</h3>
							<p>
						</div>
					</a>
				</div>
			</div>
			<div class="col-md-4">
				<div class="thumbnail">
					<a href="${pageContext.request.contextPath}/NewActivityPage" target="_blank"> <img
						src="${pageContext.request.contextPath}/images/活動廣播.png"
						alt="活動廣播." style="width: 80%">
						<div class="caption">
							<p><h3>
						活動廣播
							</h3>
							<p></div>
					</a>
				</div>
			</div>
			<div class="col-md-4">
				<div class="thumbnail">
					<a href="${pageContext.request.contextPath}/Course" target="_blank"> <img
						src="${pageContext.request.contextPath}/images/課程項目.png"
						alt="課程項目" style="width: 80%">
						<div class="caption">
							<p><h3>
						課程資訊</h3>
							</p></div>
					</a>
				</div>
			</div>
		</div>
</body>

</html>