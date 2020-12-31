<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>會員資訊</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Member.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
</head>

<body class="header_body">
<script src="${pageContext.request.contextPath}/js/showMember.js"></script>
	<header>
	</header>
	<div>
    <fieldset class="MC_fieldset_left">
        <legend class="MC_title">會員資訊</legend>
        <table cellspacing="10" cellpadding="7" width="100%">				
		<tr><td class="MC_td" id="UMP">會員資料更動</td></tr>				
		<tr><td class="MC_td" id="viewHistory">商品查詢歷史</td></tr>	
		<tr><td class="MC_td" id="disHistory">已發表文章</td></tr>		
		<tr><td class="MC_td" id="infoHistory">已參與活動</td></tr>		
		<tr><td class="MC_td" id="shopCarHistory">購物車內容</td></tr>		   
		<tr><td class="MC_td" id="bonus">會員福利</td></tr>		
        </table>
        <br>
        <img class="img1" src="images/dice.png">
    </fieldset>
              
	<fieldset class="MC_fieldset_right">
      <img class="img2" src="http://5b0988e595225.cdn.sohucs.com/images/20181125/455d02f82dbe4e0db9bf46118107ecb4.gif">
    <img class="img2" src="http://5b0988e595225.cdn.sohucs.com/images/20181125/ec02343e49774dbe8dd209f397402828.gif">
    </fieldset>
    </div>          
</body>
</html>