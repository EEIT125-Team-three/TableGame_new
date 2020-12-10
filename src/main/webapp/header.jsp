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
    <style>

    </style>
</head>

<body class="header_body">
    <script src="js/header_js.js"></script>
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
                <span class="header_span1"><a href="header" class="header_a">網站起源</a></span>
                <span class="header_span1"><a href="news" class="header_a">最新消息</a></span>
                <span class="header_span1"><a href="product" class="header_a">分類檢索</a></span>
                <span class="header_span1"><a href="shopCar" class="header_a">購物車</a></span>
                <span class="header_span1"><a href="gossip" class="header_a">討論區</a></span>
                <span class="header_span1"><a href="login" class="header_a">會員中心</a></span>
                <span class="header_span1"><a href="connect" class="header_a">聯絡我們</a></span>
                <span class="header_span2"><button>登出</button></span>
                <span class="header_span2">XXX 歡迎</span>
            </div>
        </nav>
    </header>

</body>

</html>