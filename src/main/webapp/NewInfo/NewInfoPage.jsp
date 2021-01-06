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
<script src="js/jquery-2.0.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	//$('.carousel').carousel('next');
</script>
</head>
<body class="header_body">
	<script src="${pageContext.request.contextPath}/js/InfoMenu.js"></script>
	<header> </header>
	<div class="menu"></div>

	<div class="show">
		<div id="carousel-example-generic" class="carousel slide"
			data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-generic" data-slide-to="0"
					class="active"></li>
				<li data-target="#carousel-example-generic" data-slide-to="1"></li>
				<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" style="text-align: center">
				<div class="item active">
					<img alt="First slide"
						src="${pageContext.request.contextPath}/images/桌遊活動圖片1.jpg"></img>
				</div>
				<div class="item">
					<img alt="Second slide"
						src="${pageContext.request.contextPath}/images/桌遊活動圖片2.jpg"></img>
				</div>
				<div class="item">
					<img alt="Third slide"
						src="${pageContext.request.contextPath}/images/桌遊活動圖片3.jpg"></img>
				</div>
			</div>

			<!-- Controls -->
			<a class="left carousel-control" href="#carousel-example-generic"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left"></span>
			</a> <a class="right carousel-control" href="#carousel-example-generic"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span>
			</a>
		</div>
	</div>
	<div class="InfoItem">
		<h1>最新消息</h1>
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<div class="thumbnail">
						<a href=""> <img
							src="${pageContext.request.contextPath}/images/新品上架.png"
							alt="新品上架" style="width: 60%">
							<div class="caption">
								<p>
								<h3>新品上架</h3>
								<p>
							</div>
						</a>
					</div>
				</div>
				<div class="col-md-4">
					<div class="thumbnail" >
						<a href="${pageContext.request.contextPath}/NewActivityPage"> 
						<img
							src="${pageContext.request.contextPath}/images/活動廣播.png"
							alt="活動廣播." style="width: 60%">
							<div class="caption">
								<p>
								<h3>活動廣播</h3>
								<p>
							</div>
						</a>
					</div>
				</div>
				<div class="col-md-4">
					<div class="thumbnail">
						<a href="${pageContext.request.contextPath}/Course"	> 
						<img
							src="${pageContext.request.contextPath}/images/課程項目.png"
							alt="課程項目" style="width: 60%">
							<div class="caption">
								<p>
								<h3>課程資訊</h3>
								</p>
							</div>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>