<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <style>
	td {
	border: 1px solid black;
	width: fit-content;
	height: fit-content;
	}
	
	table img {
		width: 300px;
		height: 300px;
		transition: border .5s linear, width .5s,height .5s,border-radius .5s;
	}
	table img:hover {
		border:5px solid blue;
		width: 250px;
		height: 250px;
		border-radius:20px;
	
	}
	.div_product{
	border-radius:15px;
	margin-left:20px;
	width:1200px; 
	height:640px;
	float: left;
	background-image: url(../images/墨綠色背景.jpg);
	}
	.div_info{
		width: 500px;
		height: 600px;
		border-radius:15px;
		float:left;
		margin-top:20px;
		margin-left:20px;
		font-size:x-large;
		font-weight:bolder;
		padding:5px;
		background-image: url(../images/木質背景1.jpg);
	}
	.product_img {
		width: 600px;
		height: 600px;
		padding:20px;
		border-radius:15px;
		float:left;
		
	}
	.buy_btn{
		width:fit-content;
		height:fit-content;
		color:yellow;
		float:right;
		padding:10px;
		border-radius:15px;
		position:relative;
		bottom:15px;
		background-color: red;
	}
		
    </style>
</head>

<body class="header_body">

	<div class="standard_nav"
	style="width: 200px; height: fit-content; float: left;background-image: url(../images/墨綠色背景.jpg)">
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

<div class="div_product">

<img class="product_img" src="${product.img_url}">
<div class="div_info">
<p style="color:blue;margin-bottom:3px;margin-top:3px;font-size:50px">${product.c_name}</p>
<h2>${product.e_name}</h2>
<p>${product.info}</p>
<p>類型 : </p>
<p>科目 : </p>
<span>售價 : ${product.price}</span>
<div class="buy_btn">加入購物車</div>
<div class="buy_btn">加入追蹤清單</div>
<!-- <div class="buy_btn"><a href=''>回上頁</a></div> -->
</div>
</div>
<script src="../js/Standard.js"></script>
<script src="../js/jquery-3.5.1.min.js"></script>
<script>
        function checkout() {
        	alert("已登出,歡迎下次再來")
        	}
</script>
</body>

</html>