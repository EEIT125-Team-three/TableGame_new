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
<title>商品查詢歷史</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Member.css">
</head>

<body class="header_body">
	<header> </header>
	<form method="post" style="height:700px ;overflow:scroll" >
			<div class="SM_title">產品查詢歷史清單</div>	
			<br>			
			<c:if test='${empty viewHistory}'>
		<h1>查無產品歷史資料</h1><br>
			</c:if>
			<c:if test='${not empty viewHistory}'>
				<c:forEach var='MP' varStatus='vs' items='${viewHistory}'>
					<c:if test='${vs.first }'>
						<c:out value="<table class='SM_table'>" escapeXml='false' />
						<c:out value="<tr>
						<th class='SM_th'>圖片</th>
						<th class='SM_th'>中文遊戲名</th>
						<th class='SM_th'>英文遊戲名</th>
						<th class='SM_th'>遊戲製作者</th>
				        <th class='SM_th'>插圖作家</th>
				        <th class='SM_th'>上市日期</th>
				        <th class='SM_th'>售價</th>
				        <th class='SM_th'>剩餘庫存</th>				  
				        <th class='SM_th'>觀看次數</th>
				        </tr>"
						escapeXml='false'/>
					</c:if>
					<tr class="SM_tr">
						<td style='display:none'>${MP.member}</td>
						<td><a href='${pageContext.request.contextPath}/Product/SearchGameByProductId?ProductId=${MP.product.productId}'>
						<img width='100' height='150' src='${MP.product.img_url}'/></a></td>
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
	</form>
</body>
</html>