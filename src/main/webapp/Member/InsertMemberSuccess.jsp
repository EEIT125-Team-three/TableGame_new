<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>註冊會員成功</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Member.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
</head>

<body class="header_body">
	<header>
	</header>
	
    <fieldset class="RES_fieldset">
    <div class="RES_div">註冊會員成功!</div>
<p class="RES_p">
親愛的${name}(帳號:${account})<br>
感謝您一同加入享玩桌遊的大家庭 ,一起來廝殺吧!!
</p>
<br>
<button type="button" class="RES_btn"><a class="RES_link" href="${pageContext.request.contextPath }/memberCenter">進入會員中心</a></button>
<img class="img1" src="${pageContext.request.contextPath}/images/dice.png">
    </fieldset>

</body>
</html>