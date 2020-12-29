<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>會員清單</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login.css">
<link
	href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>
</head>

<body class="header_body">
	<script src="${pageContext.request.contextPath}/js/showMember.js"></script>
	<header> </header>
	<form method="post" style="height:550px ;overflow:scroll" >				
			<c:if test='${empty viewHistory}'>
		查無產品歷史資料<br>
			</c:if>
			<c:if test='${not empty viewHistory}'>
				<c:forEach var='MP' varStatus='vs' items='${viewHistory}'>
					<c:if test='${vs.first }'>
						<c:out value="<table border='1'>" escapeXml='false' />
						<c:out value="<tr>
						<th>圖片</th>
						<th>FUCK</th>
						<th>中文遊戲名</th>
						<th>英文遊戲名</th>
						<th>遊戲製作者</th>
				        <th>插圖作家</th>
				        <th>上市日期</th>
				        <th>售價</th>
				        <th>商品剩餘庫存</th>				  
				        <th>您以觀看此商品次數</th>
				        </tr>"
						escapeXml='false'/>
					</c:if>
					<tr>
						<td style='display:none'>${MP.member}</td>
						<td>
						
						<img width='100' height='150' src='${MP.product.img_url}'>
						
						</td>
						<td><a href='${pageContext.request.contextPath}/Product/SearchGameByProductId?ProductId=${MP.product.productId}'>123</a></td>
						<td>${MP.product.c_name}</td>
						<td>${MP.product.e_name}</td>
						<td>${MP.product.g_maker}</td>
						<td>${MP.product.iss}</td>
						<td>${MP.product.date}</td>
						<td>${MP.product.price}</td>
						<td>${MP.product.storage}</td>
						<td>${MP.viewCount}</td>						
					</tr>
					<c:if test='${vs.last}'>
						<c:out value="</table>" escapeXml='false' />
					</c:if>
				</c:forEach>
			</c:if>
			<img class="img1" src="images/dice.png">		

	</form>
</body>
</html>