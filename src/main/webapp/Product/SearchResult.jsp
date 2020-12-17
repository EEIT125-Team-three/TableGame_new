<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>123</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Standard.css">
    <script>
    var s = "${name}"
    var h = "${pageContext.request.contextPath}";
    </script>
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
    <div class="standard_nav"
	style="width: 200px; height: fit-content; float: left;background-image: url(${pageContext.request.contextPath}/images/墨綠色背景.jpg)">
	<p
		style="margin-left: 10px; font-size: 35px; font-weight: bold; color: rgb(234, 241, 171);">分類檢索表</p>

	<ul class="standard_ul">
		<li>英文名稱  <img src="../images/箭頭.png" class="standard_imgst" onclick="Ename_test()">
			<form id="fid1" action="${pageContext.request.contextPath}/Product/SearchGameByE_name"	style="display: none">
				<input type='text' style='width: 100px' name="E_name"> 
				<input type='submit' value='送出'>
			</form>
		</li>
		<li>中文名稱 <img src="../images/箭頭.png" class="standard_imgst" onclick="Cname_test()">
			<form id="fid2" action="${pageContext.request.contextPath}/Product/SearchGameByC_name" style="display: none">
				<input type='text' style='width: 100px' name="C_name"> 
				<input type='submit' value='送出'>
			</form>
		</li>
		
		<li>遊戲作者 <img src="../images/箭頭.png" class="standard_imgst" onclick="Gmaker_test()">
			<form id="fid3" action="${pageContext.request.contextPath}/Product/SearchGameByG_maker" style="display: none">
				<input type='text' style='width: 100px' name="G_maker">
				<input type='submit' value='送出'>
			</form>

		</li>
		<li>插畫家 <img src="../images/箭頭.png" class="standard_imgst"	onclick="Iss_test()">
			<form id="fid4" action="${pageContext.request.contextPath}/Product/SearchGameByiss" style="display: none">
				<input type='text' style='width: 100px' name="iss"> 
				<input type='submit' value='送出'>
			</form>
		</li>
		<li>瀏覽數 <img src="../images/箭頭.png" class="standard_imgst" onclick="ViewCount_test()">
			<form id="fid5" action="${pageContext.request.contextPath}/Product/SearchGameByViewCount" style="display: none">
				<input type='text' style='width: 50px' name="ViewCount1"><span> ~ </span>
				<input type='text' style='width: 50px' name="ViewCount2">
				<input type='submit' value='送出'>
			</form>
		</li>
		<li>上市日期 <img src="../images/箭頭.png" class="standard_imgst" onclick="Date_test()">
			<form id="fid6" action="${pageContext.request.contextPath}/Product/SearchGameBydate" style="display: none">
				<input type='date' style='width: 100px' name="date">
				<input type='submit' value='送出'>
			</form>
		</li>
		<li>庫存數量 <img src="../images/箭頭.png" class="standard_imgst" onclick="Storage_test()">
			<form id="fid7" action="${pageContext.request.contextPath}/Product/SearchGameByStorage" style="display: none">
				<input type='text' style='width: 50px' name="storage1"><span> ~ </span>
				<input type='text' style='width: 50px' name="storage2">
				<input type='submit' value='送出'>
			</form>
		</li>
		<li>價錢 <img src="../images/箭頭.png" class="standard_imgst" onclick="Price_test()">
			<form id="fid8" action="${pageContext.request.contextPath}/Product/SearchGameByPrice" style="display: none">
				<input type='text' style='width: 50px' name="price1"><span> ~ </span>
				<input type='text' style='width: 50px' name="price2">
				<input type='submit' value='送出'>
			</form>
		</li>
		<li>
		<a href='${pageContext.request.contextPath}/Product/advanced_page.jsp'>進階查詢</a>
		</li>
		<li>
		<a href='${pageContext.request.contextPath}/Product/manager_page.jsp'>管理員介面</a>
		</li>


	</ul>

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

<script src="${pageContext.request.contextPath}/js/Standard.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
</body>
</html>