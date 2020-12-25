<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>會員資料中心</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
</head>

<body class="header_body">
	<header>
	</header>
    <fieldset>
        <legend class="ti">會員資料中心</legend>
        <table cellspacing="2" cellpadding="1" width="100%">
				<tr>
				<td><a class="link" href="${pageContext.request.contextPath }/showMembers">會員資料更動</a></td>				
					<td><a class="link" href="${pageContext.request.contextPath }/InsertMember">商品查詢歷史</a></td>
					<td><a class="link" href="${pageContext.request.contextPath }/InsertMember">會員福利查詢</a></td>
				</tr>
				<tr>
					<td><a class="link" href="${pageContext.request.contextPath }/InsertMember">活動查詢</a></td>
					<td><a class="link" href="${pageContext.request.contextPath }/showMembers">留言查詢</a></td>
				<td><a class="link" href="${pageContext.request.contextPath }/showMembers">購物車查詢</a></td>
				</tr>		   
        </table>
        <br>
        <img class="img1" src="images/dice.png">
    </fieldset>          
	
</body>
</html>