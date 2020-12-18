<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>123</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Standard.css">
    <script src="${pageContext.request.contextPath}/js/Standard.js"></script>
    <script src="${pageContext.request.contextPath}/js/SearchList.js"></script>
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
	<style type="text/css">
	 .table_st{
	 	font-size:35px;
	 	border:2px solid blue;
	 }
	 .td_st{
	 	border:2px solid blue;
	 	text-align:center;
	 	padding:10px;
	 	width:270px;
	 	height:270px;
	 	transition:background-color .7s,border-radius .7s;
	 }
 	 .td_st:hover{ 
	 	 background-color:	#007979;
	 	 border-radius:20px; 
 	 }
 	 .td_st a{
 	 	 text-decoration:none;
 	 }

 	 .td_st span{
 	 	display:none;
 	 }
 	 .td_st:hover span{ 
	 	 display:block;
	 	 color:#FFD1A4;

 	 }
 	 .td_st img{
 	 	float:left;
	 	width:270px;
	 	height:270px;
	 	display:block;
 	 }
 	 .td_st:hover img{
 	 	display:none;
 	 }
	 </style>
	 <script type="text/javascript">
	
		function AddToShopCar(C_name) {
			alert(C_name+" 已加入購物車");
		}
		function FollowProduct(C_name) {
			alert("已追蹤 "+ C_name);
		}
	</script>
</head>

<body class="header_body">
	<header>
	</header>
    <div class="standard_nav"
	style="width: 200px; height: fit-content; float: left;background-image: url(${pageContext.request.contextPath}/images/墨綠色背景.jpg)">
	</div>
<div style="float:left">
<h1>遊戲列表</h1>

<c:if test='${empty result}'>
		<h1>查無遊戲資料</h1><br>
	</c:if>
	<c:if test='${not empty result}'>
		<h2>搜尋結果 : <c:out value="${fn:length(result)}"></c:out> 筆資料 </h2>

		<c:forEach var='game' varStatus='vs' items='${result}'>
		
			<c:if test ='${vs.first }'>
				<c:out value="<table class='table_st'>" escapeXml='false'/>	
			</c:if>
			<c:if test='${vs.count % 5 == 1 }'>
			<c:out value="<tr>" escapeXml='false'/>
			</c:if>
			<td class='td_st'>
				<a href='SearchGameByProductId?ProductId=${game.productId}'>
					<span>${game.c_name}<br></span>
					<span>${game.e_name}</span>
					<span>$ ${game.price}</span>
					<img src='${game.img_url}'>
				</a>
			</td>
			<c:if test='${vs.count % 5 == 0 }'>
			<c:out value="</tr>" escapeXml='false'/>
			</c:if>
			<c:if test ='${vs.last }'>
				<c:out value="</table>" escapeXml='false'/>
			</c:if>
		</c:forEach>

	</c:if>
</div>

</body>
</html>