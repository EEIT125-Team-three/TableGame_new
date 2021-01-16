<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>享玩 桌遊 | 分類檢索 | 搜尋結果</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Standard.css">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ScrollBar.css">
    <script src="${pageContext.request.contextPath}/js/Standard.js"></script>
    <script src="${pageContext.request.contextPath}/js/SearchList.js"></script>
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
    <script>
    $(function() {
        /* 按下GoTop按鈕時的事件 */
        $('#gotop').click(function(){
            $('html,body').animate({ scrollTop: 0 }, 'slow');   /* 返回到最頂上 */
            return false;
        });
        
        /* 偵測卷軸滑動時，往下滑超過400px就讓GoTop按鈕出現 */
        $(window).scroll(function() {
            if ( $(this).scrollTop() > 400){
                $('#gotop').fadeIn();
            } else {
                $('#gotop').fadeOut();
            }
        });
    });
	$(function() {
        $('#shoppingbasket').click(function(){
        	var basket = document.getElementById("shoppingbasket1");
        	if(basket.style.display==='none'){
        		basket.style.display = 'block';
        	}else{
        		basket.style.display = 'none';
        	}
        });
    });
    function AddToShopCar(C_name) {
		alert(C_name+" 已加入購物車");
	}
	function FollowProduct(C_name) {
		alert("已追蹤 "+ C_name);
	}
    </script>
	<style type="text/css">
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
	 	 background-color:rgb(255, 240, 158);
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
	 	 color:#844200;

 	 }
 	 .td_st img{
 	 	border:2px solid #9F5000;
 	 	float:left;
	 	width:270px;
	 	height:270px;
	 	display:block;
	 	padding:2px;
	 	text-align:center;
 	 }
 	 .td_st:hover img{
 	 	display:none;
 	 }
 	 
 	 #gotop {
	    position:fixed;
	    z-index:90;
	    right:10px;
	    bottom:31px;
	    display:none;
	    width:60px;
	    height:60px;
	    color:#fff;
	    background:#33b5e5;
	    line-height:50px;
	    border-radius:50%;
	    transition:all 0.5s;
	    text-align: center;

	}
	#gotop :hover{
	    background:transaction;
	    color:	#000079;
	}
	#shoppingbasket{
		position:fixed;
	    z-index:90;
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
	    height:fit-content;
	    border:2px solid black;
	    border-radius:10px;
	    background-color:#737300;
   		display:none;
   		opacity:0.8;      
	}
	.btn_rep_st{
		width:100px;
		height:30px;
		font-size:20px;
		border-radius:5px;
		background-color:#006030;
		color:#FFD306;
	}
	 </style>

</head>

<body class="header_body">
	<header>
	</header>
    <div class="standard_nav"
	style="width: 200px; height: fit-content; float: left;">
	</div>
<div style="float:left">
<h1 style='margin-left:10px;'>遊戲列表</h1>

<c:if test='${empty result}'>
		<h1>查無遊戲資料</h1><br>
	</c:if>
	<c:if test='${not empty result}'>
		<h2 style='margin-left:10px;'>搜尋結果 : <c:out value="${fn:length(result)}"></c:out> 筆資料 </h2>

		<c:forEach var='game' varStatus='vs' items='${result}'>
		
			<c:if test ='${vs.first }'>
				<c:out value="<table class='table_st'>" escapeXml='false'/>	
			</c:if>
			<c:if test='${vs.count % 5 == 1 }'>
			<c:out value="<tr>" escapeXml='false'/>
			</c:if>
			<td class='td_st'>
				<a href='SearchGameByProductId?ProductId=${game.productId}'>
					<span>${game.c_name}<br></span>
					<span>${game.e_name}</span>
					<span>$ ${game.price}</span>
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

	</c:if>
</div>

<a href="#" id="gotop">
   <i class="fa fa-angle-double-up fa-3x"></i>
</a>
<div id="shoppingbasket">

   <i class="fa fa-shopping-cart fa-3x"></i>

</div>
	<div class="shoppingbasket1" id="shoppingbasket1">
	<table>
	<c:forEach var='product' items='${products}'>
		<tr>
		<td>
		<a href='${pageContext.request.contextPath}/Product/SearchGameByProductId?ProductId=${product.productId}'>
				<img style="width:80px;height:80px" src='${product.img_url}'>
			</a>
		</td>
		<td style="font-size:25px;color:#BBFFFF;">${product.c_name}</td>
		<td style='color:yellow;'><span>$</span>${product.price}</td>
		</tr>
	</c:forEach>
	</table>
	<div style="text-align:center;">
		<a href='${pageContext.request.contextPath}/shopCar'><button class='btn_rep_st'>前往結帳</button></a>
	</div>
	</div>
<footer class="footer_body">
</footer>
</body>
</html>