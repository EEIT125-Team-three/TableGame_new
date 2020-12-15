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
    <script>var s = "${name}"</script>
    <script src="js/header_js.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Standard.css">
    <style>

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
</head>

<body class="header_body">

	<div class="standard_nav"
	style="width: 200px; height: fit-content; float: left;background-image: url(images/墨綠色背景.jpg)">
	<p
		style="margin-left: 10px; font-size: 35px; font-weight: bold; color: rgb(234, 241, 171);">分類檢索表</p>

	<ul class="standard_ul">
		<li>英文名稱  <img src="images/箭頭.png" class="standard_imgst" onclick="Ename_test()">
			<form id="fid1" action="Product/SearchGameByE_name"	style="display: none">
				<input type='text' style='width: 100px' name="E_name"> 
				<input type='submit' value='送出'>
			</form>
		</li>
		<li>中文名稱 <img src="images/箭頭.png" class="standard_imgst" onclick="Cname_test()">
			<form id="fid2" action="Product/SearchGameByC_name" style="display: none">
				<input type='text' style='width: 100px' name="C_name"> 
				<input type='submit' value='送出'>
			</form>
		</li>
		
		<li>遊戲作者 <img src="images/箭頭.png" class="standard_imgst" onclick="Gmaker_test()">
			<form id="fid3" action="Product/SearchGameByG_maker" style="display: none">
				<input type='text' style='width: 100px' name="G_maker">
				<input type='submit' value='送出'>
			</form>

		</li>
		<li>插畫家 <img src="images/箭頭.png" class="standard_imgst"	onclick="Iss_test()">
			<form id="fid4" action="Product/SearchGameByiss" style="display: none">
				<input type='text' style='width: 100px' name="iss"> 
				<input type='submit' value='送出'>
			</form>
		</li>
		<li>瀏覽數 <img src="images/箭頭.png" class="standard_imgst" onclick="ViewCount_test()">
			<form id="fid5" action="Product/SearchGameByViewCount" style="display: none">
				<input type='text' style='width: 50px' name="ViewCount1"><span> ~ </span>
				<input type='text' style='width: 50px' name="ViewCount2">
				<input type='submit' value='送出'>
			</form>
		</li>
		<li>上市日期 <img src="images/箭頭.png" class="standard_imgst" onclick="Date_test()">
			<form id="fid6" action="Product/SearchGameBydate" style="display: none">
				<input type='date' style='width: 100px' name="date">
				<input type='submit' value='送出'>
			</form>
		</li>
		<li>庫存數量 <img src="images/箭頭.png" class="standard_imgst" onclick="Storage_test()">
			<form id="fid7" action="Product/SearchGameByStorage" style="display: none">
				<input type='text' style='width: 50px' name="storage1"><span> ~ </span>
				<input type='text' style='width: 50px' name="storage2">
				<input type='submit' value='送出'>
			</form>
		</li>
		<li>價錢 <img src="images/箭頭.png" class="standard_imgst" onclick="Price_test()">
			<form id="fid8" action="Product/SearchGameByPrice" style="display: none">
				<input type='text' style='width: 50px' name="price1"><span> ~ </span>
				<input type='text' style='width: 50px' name="price2">
				<input type='submit' value='送出'>
			</form>
		</li>
		<li>
		<a href='Product/advanced_page.jsp'>進階查詢</a>
		</li>
		<li>
		<a href='Product/manager_page.jsp'>管理員介面</a>
		</li>


	</ul>

</div>


<div style="width:fit-content;border:1px solid black;float:left">
		<c:forEach var='game' varStatus='vs' items='${allGames}'>
		
			<c:if test ='${vs.first }'>
				<c:out value="<table class='table_st'>" escapeXml='false'/>	
			</c:if>
			<c:if test='${vs.count % 5 == 1 }'>
			<c:out value="<tr>" escapeXml='false'/>
			</c:if>
			<td class='td_st'>
				<a href='Product/SearchGameByProductId?ProductId=${game.productId}'>
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
		</div>
<!-- 	<table -->
<!-- 		style="border: 1px solid black; float: left; width: 1100px; height: 500px; margin-left: 20px; text-align: center;"> -->
<!-- 		<tr> -->
<!-- 			<td><a href="productpage1.jsp"> -->
<!-- 			<img title="矮人十兄弟" -->
<!-- 				src="https://uploads-ssl.webflow.com/575714cc825e8dbc6c83b98a/5ab8efcaff9c8bac62cecb91_10%20Dwarves_Box_CH_BOX_3D.jpg"> -->
<!-- 				</a> -->
<!-- 			</td> -->
<!-- 			<td><img title="13道線索" -->
<!-- 				src="https://uploads-ssl.webflow.com/575714cc825e8dbc6c83b98a/5c1db685fd28a72741e82787_13Clues_Box.jpg"> -->

<!-- 			</td> -->
<!-- 			<td><img title="504" -->
<!-- 				src="https://uploads-ssl.webflow.com/575714cc825e8dbc6c83b98a/5ab8efdaff9c8b7b26cecb99_504_Box_3D.jpg"> -->
<!-- 			</td> -->
<!-- 			<td><img -->
<!-- 				src="https://uploads-ssl.webflow.com/575714cc825e8dbc6c83b98a/5e9538f619faa7557041501a_789_Box_3D_2019.jpg"> -->
<!-- 			</td> -->
<!-- 			<td><img -->
<!-- 				src="https://uploads-ssl.webflow.com/575714cc825e8dbc6c83b98a/5e796b529b31cfa64cabc365_AlaCarte_Box_2019.jpg"> -->
<!-- 			</td> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td><img -->
<!-- 				src="https://uploads-ssl.webflow.com/575714cc825e8dbc6c83b98a/5b3b08a4fa3b00d8a47002cd_Sahne_Box.jpg"> -->

<!-- 			</td> -->
<!-- 			<td><img -->
<!-- 				src="https://uploads-ssl.webflow.com/575714cc825e8dbc6c83b98a/5ab8f018ff9c8be262cecbc5_Absacker_BOX_3D.jpg"> -->
<!-- 			</td> -->
<!-- 			<td><img -->
<!-- 				src="https://uploads-ssl.webflow.com/575714cc825e8dbc6c83b98a/5ab8f0581f33701552d77e88_Agricola_Hobby_2017_Box.jpg"> -->
<!-- 			</td> -->
<!-- 			<td><img -->
<!-- 				src="https://uploads-ssl.webflow.com/575714cc825e8dbc6c83b98a/5ab8f03cf866da189b167b8d_Agricola_2P_BOX_3D.jpg"> -->
<!-- 			</td> -->
<!-- 			<td><img -->
<!-- 				src="https://uploads-ssl.webflow.com/575714cc825e8dbc6c83b98a/5ab8f049ff9c8b525acecbf1_Agricola_Family_Box3D_CH.jpg"> -->
<!-- 			</td> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td><img -->
<!-- 				src="https://uploads-ssl.webflow.com/575714cc825e8dbc6c83b98a/5ab8f09de294a009d647806b_Alibi_Box_3D.jpg"> -->
<!-- 			</td> -->
<!-- 			<td><img -->
<!-- 				src="https://uploads-ssl.webflow.com/575714cc825e8dbc6c83b98a/5ab8f0be41c0912f9eceed2a_Alles%20Tomate_Box_3D_SEAL.jpg"> -->
<!-- 			</td> -->
<!-- 			<td><img -->
<!-- 				src="https://uploads-ssl.webflow.com/575714cc825e8dbc6c83b98a/5ab8f0d041c091b6fbceed32_AnimaUponAnimal_BOX_3D.jpg"> -->
<!-- 			</td> -->
<!-- 			<td><img -->
<!-- 				src="https://uploads-ssl.webflow.com/575714cc825e8dbc6c83b98a/5cd5524af1db8349b7a0ef11_Animal%20Upon%20Animal%20Small%20yet%20great_Box_3D.jpg"> -->
<!-- 			</td> -->
<!-- 			<td><img -->
<!-- 				src="https://uploads-ssl.webflow.com/575714cc825e8dbc6c83b98a/5ab8f0f11f33705d64d77edf_AoB_Box_3D.jpg"> -->
<!-- 			</td> -->
<!-- 		</tr> -->
<!-- 	</table> -->
<!-- </div> -->
<script src="js/Standard.js"></script>
<script src="js/jquery-3.5.1.min.js"></script>
<script>
        function checkout() {
        	alert("已登出,歡迎下次再來")
        	}
</script>
</body>

</html>