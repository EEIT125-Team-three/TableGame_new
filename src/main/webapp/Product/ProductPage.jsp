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
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
	<script src="${pageContext.request.contextPath}/js/Standard.js"></script>
    <script src="${pageContext.request.contextPath}/js/SearchList.js"></script>
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
		top:220px;
		padding:10px;
		border-radius:15px;
		position:relative;
		bottom:15px;
		background-color: red;
		margin-left:5px;
	}
		
    </style>
</head>

<body class="header_body">
	<header>
	</header>

	<div class="standard_nav"
	style="width: 200px; height: fit-content; float: left;background-image: url(../images/墨綠色背景.jpg)">
	
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
<script src="${pageContext.request.contextPath}/js/Standard.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
<script>
        function checkout() {
        	alert("已登出,歡迎下次再來")
        	}
</script>
</body>

</html>