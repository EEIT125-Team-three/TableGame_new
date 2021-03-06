<%@page import="java.io.Console"%>
    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <!DOCTYPE html>
            <html lang="zh-Hant-TW">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>享玩 桌遊 | 分類檢索 | 商品</title>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
                <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon" />
                <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
                <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Standard.css">
			    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ScrollBar.css">				
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
                        transition: border .5s linear, width .5s, height .5s, border-radius .5s;
                    }
                    
                    table img:hover {
                        border: 5px solid blue;
                        width: 250px;
                        height: 250px;
                        border-radius: 20px;
                    }
                    
                    .div_product {
                        border-radius: 15px;
                        margin-left: 15px;
                        width: 1400px;
                        height: 640px;
                        float: left;
                    	background-color:rgba(179, 179, 179,0.8);
                    }
                    
                    .div_info {
                        width: 700px;
                        height: 600px;
                        border-radius: 15px;
                        float: left;
                        margin-top: 20px;
                        margin-left: 20px;
                        font-size: 25px;
                        font-weight: bolder;
                        padding: 5px;
                        background-image: url(${pageContext.request.contextPath}/images/木質背景1.jpg);
                        line-height: 1.1;
                    }
                    
                    .product_img {
                        width: 600px;
                        height: 600px;
                        padding: 20px;
                        border-radius: 15px;
                        float: left;
                    }
                    
                    .buy_btn {
                        width: 100px;
                        height: fit-content;                    
                        float: right;
                        top: 840px;
                        padding: 10px;
                        border-radius: 15px;
                        position: relative;
                        bottom: 15px;
                        background-color: #FF0000;
                        margin-left: 5px;
                        position: absolute;
                        border:2px solid #A23400;
                        text-align:center;
                    }
                    
                    .DLC_div {
                        color: blue;
                        font-size: 25px;
                        font-weight: bold;
                        border: 2px solid black;
                        width: 240px;
                        background-image:url(${pageContext.request.contextPath}/images/木質背景1.jpg);
                    }
                    
                    .DLC_div_scroll {
                        width: 250px;
                        height: 600px;
                        overflow: auto;
                    }
                    
                    .table_st {
                        font-size: 25px;
                    }
                    
                    .td_st {
                        text-align: center;
                        width: 220px;
                        height: 220px;
                        transition: background-color .7s, border-radius .7s;
                    }
                    
                    .td_st:hover {
                        background-color:rgb(255, 240, 158);
                        border-radius: 20px;
                    }
                    
                    .td_st a {
                        text-decoration: none;
                    }
                    
                    .td_st span {
                        display: none;
                    }
                    
                    .td_st:hover span {
                        display: block;
                        color: #844200;
                    }
                    
                    .td_st img {
                        width: 220px;
                        height: 220px;
                        display: block;
                    }
                    
                    .td_st:hover img {
                        display: none;
                    }
                    
                    .swal-title {
                        font-size: 50px;
                    }
                    
                    .swal-text {
                        font-size: 30px;
                    }
                    .swal-button {
					  padding: 7px 19px;
					  border-radius: 2px;
					  background-color: #4962B3;
					  font-size: 20px;
					  border: 1px solid #3e549a;
					  text-shadow: 0px -1px 0px rgba(0, 0, 0, 0.3);
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

                <div class="standard_nav" style="width: 200px; height: fit-content; float: left;">

                </div>

                <div id="product_area" class="div_product">
                        <img id="product_img" class="product_img" src="${product.img_url}" title="點擊看大圖">
                    <div class="div_info">
                        <p style="color:blue;margin-bottom:3px;margin-top:3px;font-size:40px;float:left;">${product.c_name}</p>
                        <span style="position:absolute;right:320px;">
		<a href="https://www.youtube.com/results?search_query=${product.c_name}">
			<img title="相關影片" style="width:60px;" src="${pageContext.request.contextPath}/images/youtube_icon.png">
		</a>
	</span>
                        <h2 style='margin-top:10px;margin-bottom:5px;clear:left;'>${product.e_name}</h2>
                        <p>${product.info}</p>
                        <p style='margin-top:20px;'>類型 :
                            <c:forEach var='cata1' items='${cata1}'>
                                <span>
		<a style="text-decoration:none;" href='${pageContext.request.contextPath}/Product/SearchGameByCata1?Cata1=${cata1.keys}'>
			${cata1.cata1} &emsp;
		</a>
		</span>
                            </c:forEach>
                        </p>
                        <p>科目 :
                            <c:forEach var='cata2' items='${cata2}'>
                                <span>
		<a style="text-decoration:none;" href='${pageContext.request.contextPath}/Product/SearchGameByCata2?Cata2=${cata2.keys}'>
		${cata2.cata2} &emsp;
		</a>
		</span>
                            </c:forEach>
                        </p>
                        <span>售價 : </span>
                        <c:if test="${newPrice != null && newPrice != product.price}">
	                        <c:out value="<del>${product.price}</del>" escapeXml="false>"></c:out>
	                        <c:out value="<span id='price' style='font-size:50px'>${newPrice}</span>" escapeXml="false>"></c:out>
                        </c:if>
                        <c:if test="${newPrice == null || newPrice == product.price}">
                        	<c:out value="<span id='price' style='font-size:50px'>${product.price}</span>" escapeXml="false>"></c:out>
                        </c:if>
                        <div class="buy_btn" onclick='frontpage()' style='left:1160px'><a href='#' style='text-decoration:none;color:yellow;'>回上一頁</a></div>
                        <c:if test="${storageStatus=='庫存不足'}">
                        	<c:out value="<div class='buy_btn'  style='left:1300px;' productId='${product.productId}'>${storageStatus}</div>" escapeXml="false>"/>
                        </c:if>
                        <c:if test="${storageStatus!='庫存不足'}">
                        	<c:out value="<div class='buy_btn'  style='left:1300px;' productId='${product.productId}'><a href='#' style='text-decoration:none;color:yellow;'>${storageStatus}</a></div>" escapeXml="false>"/>
                        </c:if>
                        <div class="buy_btn"  style='left:1440px;'><a id='alreadytrack' href='#' style='text-decoration:none;color:yellow;'>${trackStatus}</a></div>
                        <!-- <div class="buy_btn"><a href=''>回上頁</a></div> -->
                    </div>
                </div>

                <div style='margin-left:5px;float:left;width:240px;text-align:center'>
                    <div class='DLC_div'>相關商品</div>
                    <div class='DLC_div_scroll' style='overflow-x: hidden;'>
                        <table class='table_st'>
                            <c:forEach var='DLC_game' items='${DLC}'>
                                <tr>
                                    <td class='td_st'>
                                        <a href='${pageContext.request.contextPath}/Product/SearchGameByProductId?ProductId=${DLC_game.DLCId.productId}'>
                                            <span>${DLC_game.DLCId.c_name}<br>${DLC_game.DLCId.e_name}<br>$ ${DLC_game.DLCId.price}</span>
                                            
                                            <img src='${DLC_game.DLCId.img_url}'>
                                        </a>
                                    </td>
                                    <tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
                
                <div class="backOver">
			    </div>
			    <div class="centerOver">
			    </div>
                
                <script src="${pageContext.request.contextPath}/js/Standard.js"></script>
                <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
                <script>

                    var flag = 0;
                    var text = document.getElementById("price");

                    function checkout() {
                        alert("已登出,歡迎下次再來");
                    }

                    function frontpage() {
                        history.go(-1);
                    	}

                    function blink() {
                        if (!flag) {
                            text.style.color = "red";
                            text.style.background = "yellow";
                            flag = 1;
                        } else {
                            text.style.color = "";
                            text.style.background = "";
                            flag = 0;
                        }
                    }
                    $(function(){
                    	setInterval("blink()", 500)
                    })

                </script>
                <footer class="footer_body">
                </footer>
            </body>

            </html>