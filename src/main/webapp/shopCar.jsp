<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>享玩 桌遊 | 購物車</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shopCar.css">
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
</head>

<body class="header_body">
	<header>
	</header>
	<article>
	    <script src="${pageContext.request.contextPath}/js/shopCar.js"></script>
        <button class='shopCar_button'>我的購物清單</button><button class='shopCar_button'>我的追蹤清單</button><button class='shopCar_button'>出貨進度查詢</button><br>
        <div class="shopCar_div">
	        <div class="shopCar_div2">
	            <table class="shopCar_list">
	            </table>
	        </div>
	        <div class="shopCar_div3">
	            <span class="shopCar_span"></span>
	        </div>
	    </div>
        <div class="shopCar_div4">
        <form class="goCheck" action="" method="POST">
        	<input style="display:none" name="itemName" value="">
        </form>
        </div>
        <div id="myDiv" class="shopCar_div5">
        	<div class="shopCar_div6"><img class="shopCar_w95"><button class="shopCar_w95">加入購物車</button></div>
        	<div class="shopCar_div6"><img class="shopCar_w95"><button class="shopCar_w95">加入購物車</button></div>
        	<div class="shopCar_div6"><img class="shopCar_w95"><button class="shopCar_w95">加入購物車</button></div>
        	<div class="shopCar_div6"><img class="shopCar_w95"><button class="shopCar_w95">加入購物車</button></div>
        	<div class="shopCar_div6"><img class="shopCar_w95"><button class="shopCar_w95">加入購物車</button></div>
        	<div class="shopCar_div6"><img class="shopCar_w95"><button class="shopCar_w95">加入購物車</button></div>
        </div>
    </article>
    
</body>

</html>