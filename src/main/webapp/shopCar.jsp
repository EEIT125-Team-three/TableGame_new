<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>123</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="css/header_style.css">
    <link rel="stylesheet" href="css/shopCar.css">
    <style>

    </style>
</head>

<body class="header_body">
    <script src="js/shopCar.js"></script>
    <script>
    	var userId = 0
    </script>
    <header>
        <div>
            <ul class="header_listst1">
                <li> 
                    <a href="header" class="header_a"><p class="header_titlest"><image src="images/LOGO.jpg">享玩 桌遊</p></a> 
                </li>
                <p class="header_p1">讓因桌遊而產生的歡笑&emsp;充滿生命中的每分每秒</p>
            </ul>
        </div>
        <hgroup class="hearder_hgroup">
            <h2 class="header_h2_1">放輕心情</h2>
            <h2 class="header_h2_2">享受與親友</h2>
            <h2 class="header_h2_3">共同度過的桌遊時光</h2>
        </hgroup>
        <nav class="header_nav">
            <div>
                <a href="header" class="header_a"><span class="header_span1">網站起源</span></a>
                <a href="news" class="header_a"><span class="header_span1">最新消息</span></a>
                <a href="product" class="header_a"><span class="header_span1">分類檢索</span></a>
                <a href="shopCar" class="header_a"><span class="header_span1">購物車</span></a>
                <a href="gossip" class="header_a"><span class="header_span1">討論區</span></a>
                <a href="login" class="header_a"><span class="header_span1">會員中心</span></a>
                <a href="connect" class="header_a"><span class="header_span1">聯絡我們</span></a>
                <span class="header_span2"><button>登出</button></span>
                <span class="header_span2">XXX 歡迎</span>
            </div>
        </nav>
    </header>

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