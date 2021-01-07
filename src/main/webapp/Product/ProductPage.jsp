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
<!--                 <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script> -->
                <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
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
                        margin-left: 20px;
                        width: 1400px;
                        height: 640px;
                        float: left;
                        background-image: url(${pageContext.request.contextPath}/images/墨綠色背景.jpg);
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
                        width: fit-content;
                        height: fit-content;
                        color: yellow;
                        float: right;
                        top: 850px;
                        padding: 10px;
                        border-radius: 15px;
                        position: relative;
                        bottom: 15px;
                        background-color: red;
                        margin-left: 5px;
                        position: absolute;
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
                        background-color: #007979;
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
                        color: #FFD1A4;
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
						
                </style>
            </head>

            <body class="header_body" onload='blink()'>
                <header>
                </header>

                <div class="standard_nav" style="width: 200px; height: fit-content; float: left;background-image: url(${pageContext.request.contextPath}/images/墨綠色背景.jpg)">

                </div>

                <div class="div_product">
                    <a href="${product.img_url}">
                        <img class="product_img" src="${product.img_url}" title="點擊看大圖">
                    </a>
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
                        <span>售價 : </span><span id='price' style='font-size:50px'>${product.price}</span>
                        <div class="buy_btn" onclick='frontpage()' style='left:1160px'><a href='#'>回上一頁</a></div>
                        <div class="buy_btn"  style='left:1290px;' productId="${product.productId}"><a href='#'>加入購物車</a></div>
                        <div class="buy_btn"  style='left:1440px;'><a href='#'>加入追蹤清單</a></div>
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
                        setTimeout("blink()", 500);
                    }

//                     function addshopcar() {
//                         swal("加入成功!", "感謝您的購買", "success", {
//                             button: "ok",
//                         });
//                     }

//                     function addfollow() {
//                         swal("成功追蹤!", "感謝您的追蹤", "success", {
//                             button: "ok",
//                         });
//                     }
                </script>
                <footer class="footer_body">
                </footer>
            </body>

            </html>