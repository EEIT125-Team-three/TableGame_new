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
	
</script>
<script src="${pageContext.request.contextPath}/js/InfoMenu.js"></script>
</head>
<body class="header_body">
	<header> </header>
	<div class="menu"></div>

	
			<a class="left carousel-control" href="#carousel-example-generic"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left"></span>
			</a> <a class="right carousel-control" href="#carousel-example-generic"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span>
			</a>
		</div>
	</div>
	<fieldset>
		<div class="InfoItem">
			<h1>最新消息</h1>
			<div class="container">
				<div class="row">
					<div class="col-1" style="float:left;width:25%;margin-left:4%">
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
					<div class="col-1" style="float:left;width:25%;margin-left:4%">

						<a href="${pageContext.request.contextPath}/NewActivityPage">
							<img src="${pageContext.request.contextPath}/images/活動廣播.png"
							alt="活動廣播." style="width: 60%">
							<div class="caption">
								<p>
								<h3>活動廣播</h3>
								<p>
							</div>
						</a>
					</div>
					<div class="col-1" style="float:left;width:25%;margin-left:4%">
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