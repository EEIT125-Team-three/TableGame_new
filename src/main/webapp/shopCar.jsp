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
    <link rel="stylesheet" href="css/header_style.css">
    <link rel="stylesheet" href="css/shopCar.css">
    <script>
    var s = "${name}"
    var h = "${pageContext.request.contextPath}"
    </script>
    <script src="js/header_js.js"></script>
</head>

<body class="header_body">
	<script src="js/shopCar.js"></script>
	<article>
        <button class='shopCar_button'>我的購物清單</button><button class='shopCar_button'>我的追蹤清單</button><button class='shopCar_button'>出貨進度查詢</button><br>
        <div class="shopCar_div">
	        <div class="shopCar_div2">
	            <table id="buyList">
	            </table>
	        </div>
	        <div class="shopCar_div3">
	            <span class="shopCar_span">您還未選購商品，下方有各種推薦商品可以選擇</span>
	        </div>
	    </div>
        <div class="shopCar_div4">
        </div>
        <div class="shopCar_div1">
        	<button id="showAnother" class="shopCar_button1">刷新看其他商品</button>
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