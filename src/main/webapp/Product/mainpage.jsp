<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>享玩 桌遊 | 分類檢索</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Standard.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ScrollBar.css">
    <script src="${pageContext.request.contextPath}/js/SearchList.js"></script>
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
    <script src="${pageContext.request.contextPath}/js/Standard.js"></script>
    
	<script>
        function checkout() {
        	alert("已登出,歡迎下次再來")
        	}
	</script>
    <style>
	 .table_st{
	 	font-size:35px;
	 }
	 .td_st{
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
 	 	border:2px solid #642100;
 	 	float:left;
	 	width:270px;
	 	height:270px;
	 	display:block;
	 	padding:2px;
 	 }
 	 .td_st:hover img{
  	 	display: none;
 	 }
 	 #shoppingbasket{
		position:fixed;
/* 	    z-index:90; */
	    right:10px;
	    top:300px;
	    width:60px;
	    height:60px;
	    color:#fff;
	    background:#33b5e5;
	    line-height:50px;
	    border-radius:50%;
	    text-align: center;
	}
	#shoppingbasket :hover{
	    color:	#FF0000;
	}
	.shoppingbasket1{
		position:fixed;
		right:70px;
		top:330px;
		width:300px;
	    height:300px;
	    border:2px solid black;
	    border-radius:10px;
	    background-color:#737300;
   		display:none;
    	opacity:0.8;
    	overflow:auto;
    	text-align:center;    
	}
	.btn_rep_st{
		width:100px;
		height:30px;
		font-size:20px;
		border-radius:5px;
		background-color:#006030;
		color:#FFD306;
	}
	.option_st{
		width:200px;
		font-size:20px;
		font-weight:bold;
	}    
    </style>
</head>

<body class="header_body">
	<header>
	</header>

	<div class="standard_nav"
	style="width: 200px; height: fit-content; float: left;">
	</div>

	<div style='font-size:20px;font-weight:bold'>
	<span style='margin-left:30px;'>變更排序方式 : </span>
		<select>
			<option class='option_st' id='condition'></option>
			<option class='option_st' id='condition' value='price' onchange='orderby(this.value)'>依產品價錢 ( 高 --> 低 )</option>
			<option class='option_st' id='condition' value='date' onchange='orderby(this.value)'>依上市日期 ( 新 -->舊 )</option>
			<option class='option_st' id='condition' value='ViewCount' onchange='orderby(this.value)'>依瀏覽數 ( 多 --> 少 )</option>
		</select>
	</div>

<div id='showarea' style="width:1500px; height:fit-content;float:left;text-align:center;">
		<c:forEach var='game' varStatus='vs' items='${allGames}'>
		
			<c:if test ='${vs.first }'>
				<c:out value="<table class='table_st'>" escapeXml='false'/>	
			</c:if>
			<c:if test='${vs.count % 5 == 1 }'>
			<c:out value="<tr>" escapeXml='false'/>
			</c:if>
			<td class='td_st'>
<%-- 				<a href='${pageContext.request.contextPath}/Product/AddMemberHistory?productId=${game.productId}'></a>	 --%>
				<a href='${pageContext.request.contextPath}/Product/SearchGameByProductId?ProductId=${game.productId}'>
					<span>${game.c_name}<br>${game.e_name}<br>$ ${game.price}</span>
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
		<div style="text-align:center;">
			<c:set var='page' value='${fn:length(allGamesPage)/15}'/>
			<c:if test='${fn:length(allGamesPage)%15 !=0 }'>
			<c:set var='page' value='${fn:length(allGamesPage)/15+1}'/>
			</c:if>
			<c:forEach var='page' begin='1' end='${page}' varStatus='loop'>
				<span style="font-size:30px;margin-right:20px;"><a href='${pageContext.request.contextPath}/Product/SearchGameByPage?Page=${page}'>${page}</a></span>				
			</c:forEach>
		</div>
					
</div>

<script type="text/javascript">
var origin = "SearchGameByPage";
$('select').change(function(){
	var condition = $(this).val()
	console.log($(this).val())
	$("#showarea").load(page + "/Product/OrderByCondition?condition=" + condition)

})
$(function() {
	var basket = document.getElementById("shoppingbasket1");	
        $('#shoppingbasket').click(function(){
        	console.log(basket);
        	if(basket.style.display==='none'){
        		basket.style.display = 'block';
        	}else{
        		basket.style.display = 'none';
        	}
        });
    });
</script>	
<div id="shoppingbasket">

	<i class="fa fa-shopping-cart fa-3x"></i>

</div>
	<div>
		<div class="shoppingbasket1" id="shoppingbasket1">
		<table>
		<c:forEach var='product' items='${products}'>
			<tr>
			<td>
			<a href='${pageContext.request.contextPath}/Product/SearchGameByProductId?ProductId=${product.productId}'>
				<img style="width:80px;height:80px" src='${product.img_url}'>
			</a>
			</td>
			<td style="font-size:25px;color:#BBFFFF;width:150px;">${product.c_name}</td>
			<td style='color:yellow;'><span>$</span>${product.price}</td>
			</tr>
		</c:forEach>
		</table>

			<a href='${pageContext.request.contextPath}/shopCar'><button class='btn_rep_st'>前往結帳</button></a>

		</div>
	</div>
<footer class="footer_body">
</footer>
</body>

</html>