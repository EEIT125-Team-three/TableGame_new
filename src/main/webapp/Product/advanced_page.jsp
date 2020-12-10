<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="resources/css/header_style.css">
    <link rel="stylesheet" href="resources/css/Standard.css">
    
    <style>
	.divst_form {
	border: 1px solid black;
	width: fit-content;
	height: fit-content;
	border-radius: 15px;
	background-image: url("resources/images/紅背景.jpg");
	position: relative;
	text-align: center;
	font-size: xx-large;
	font-weight: bold;
	margin-top: 15px;
	padding: 5px;
	color: gold;
	}
		
    </style>
</head>

<body class="header_body">
    <header>
        <div>
            <ul class="header_listst1">
                <li>  
                    <p class="header_titlest"><image src="resources/images/LOGO.jpg" />享玩 桌遊</p>
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
                <a href="header"><span class="header_span1">網站起源</span></a>
                <a href="news"><span class="header_span1">最新消息</span></a>
                <a href="product"><span class="header_span1">分類檢索</span></a>
                <a href="shopCar"><span class="header_span1">購物車</span></a>
                <a href="gossip"><span class="header_span1">討論區</span></a>
                <a href="login"><span class="header_span1">會員中心</span></a>
                <a href="connect"><span class="header_span1">聯絡我們</span></a>
                <span class="header_span2"><button>登出</button></span>
                <span class="header_span2">XXX 歡迎</span>
            </div>
        </nav>

    </header>

	<div class="standard_nav"
	style="width: 200px; height: fit-content; float: left;background-image: url(resources/images/墨綠色背景.jpg)">
	<p
		style="margin-left: 10px; font-size: 35px; font-weight: bold; color: rgb(234, 241, 171);">分類檢索表</p>

	<ul class="standard_ul">
		<li>遊戲編號 <img src="resources/images/箭頭.png" class="standard_imgst"
			onclick="Ename_test()">
			<form id="fid1" action="SearchGameServlet" method="POST"
				style="display: none">
				<input type='text' style='width: 100px' name="productId"> 
				<input type='submit' value='送出'>
			</form>
		</li>
		<li>中文名稱 <img src="resources/images/箭頭.png" class="standard_imgst"
			onclick="Cname_test()">
			<form id="fid2" action="SearchGameServlet" method="POST"
				style="display: none">
				<input type='text' style='width: 100px' name="c_name"> <input
					type='submit' value='送出'>
			</form>
		</li>
		
		<li>遊戲作者 <img src="resources/images/箭頭.png" class="standard_imgst"
			onclick="Gmaker_test()">
			<form id="fid3" action="SearchGameServlet" method="POST"
				style="display: none">
				<input type='text' style='width: 100px' name="gmaker"> <input
					type='submit' value='送出'>
			</form>

		</li>
		<li>插畫家 <img src="resources/images/箭頭.png" class="standard_imgst"
			onclick="Iss_test()">
			<form id="fid4" action="SearchGameServlet" method="POST"
				style="display: none">
				<input type='text' style='width: 100px' name="iss"> <input
					type='submit' value='送出'>
			</form>
		</li>



	</ul>

</div>
	<fieldset style="border: none;">

        <h1 style="font-size: xx-large;">請選擇條件</h1>
        <div>
        <form style="font-size: xx-large;font-weight: bold;margin-left: 50px;width: fit-content;line-height: 1.5;"
            action="AdvancedSearch" method="POST" onsubmit="return handleData()" id="form1">
            
            編號:<input type='text'      name='productId' required> <br> 

	英文名字:<input type='text'  name='E_name'><br>
	
	中文名字:<input type='text'      name='C_name'><br>
	圖片連結:<input type='text'      name='img_url'><br>
	創作者:<input type='text'      name='G_make'><br>
	插畫家:<input type='text'      name='iss'><br>
	內容:<input type='text'      name='info'><br>
	價錢:<input type='text'      name='Price'><br>
	瀏覽數:<input type='text'      name='viewCount'><br>
	上市日期:<input type='text'      name='date'><br>
	庫存:<input type='text'      name='storage'><br>
   

            <input type="submit" value="送出">
            <input type="reset" value="清除">
        </form>
        </div>

    </fieldset>


<script src="resources/js/Standard.js"></script>
<script src="resources/js/jquery-3.5.1.min.js"></script>
</body>

</html>