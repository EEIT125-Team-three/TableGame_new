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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/manager_page.css">
    <script>
    var s = "${name}"
    var h = "${pageContext.request.contextPath}";
    </script>
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Standard.css">
    
    <style>
	.divst_form {
	border: 1px solid black;
	width: fit-content;
	height: fit-content;
	border-radius: 15px;
	background-image: url("../images/紅背景.jpg");
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


<script src="${pageContext.request.contextPath}/js/Standard.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
</body>

</html>