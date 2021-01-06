<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>會員管理</title>
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
    <fieldset class="MC_fieldset_left">
        <legend class="MC_title">會員管理</legend>
        <table id="MCtable" cellspacing="10" cellpadding="7" width="100%">
				<tr><td class="MC_td" id="showMembers">會員清單檢視</td></tr>
				<tr><td class="MC_td" id="searchMembers">查詢會員資料</td></tr>				
				<tr><td class="MC_td">新增會員資料</td></tr>
				<tr><td class="MC_td">刪除會員資料</td></tr>			   
        </table>
        <br>
        <img class="img1" src="images/dice.png">
    </fieldset>       
	<fieldset class="MC_fieldset_right">
	<img class="img2" src="images/s1.gif">
	<img class="img2" src="images/s2.gif">
	</fieldset>
</body>
</html>