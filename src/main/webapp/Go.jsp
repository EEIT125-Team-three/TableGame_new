<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head> 
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ScrollBar.css">
    <title>享玩 桌遊 | 感謝購買</title>
    <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
    <style>
    	.go_st{
    		height:fit-content;
    		font-size:200px;
    		text-align:center;
    		float:left;
    		font-weight:bold;
    		background-image:url("${pageContext.request.contextPath}/images/firework.gif");
    		background-size:300px,300px;
    		padding-top:50px;
    	}
    	.bow_st{
    		float:left;
    		margin-left:50px;
    		margin-right:50px;
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
    <script>
    var flag = true;
    function blink() {
    	console.log(flag)
           if (flag) {
               $("#text1").css("color","red");
               flag = false;
           } else {
        	   $("#text1").css("color","black");
               flag = true;
           }
       }   	
    $(function(){
        setInterval("blink()", 500);
    })
    </script>
</head>

<body class="header_body">
	<header>
	</header>
	<div hidden="hidden">${go}</div>
	<div class="bow_st"><img src="${pageContext.request.contextPath}/images/bow.gif"></div>
	<div class="go_st"><span id="text1">感謝您的購買</span><br></div>
	<div class="bow_st"><img src="${pageContext.request.contextPath}/images/bow.gif"></div>
	<div style="text-align:center;"><a href="/TestVersion/"><button class="btn_rep_st">返回首頁</button></a></div>
	<footer class="footer_body">
	</footer>
</body>

</html>