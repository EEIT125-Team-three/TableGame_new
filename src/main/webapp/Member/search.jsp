<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>會員搜尋</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Member.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
</head>

<body class="header_body">
	<header>
	</header>
        <div class="UMP_title">會員搜尋</div>
        <ul>
        <li>帳號查詢:
		<input type='text' style='width: 100px' name="memAccount" id="SearchMemberByAccount1" placeholder="請輸入帳號" > 
	    <input id="SearchMemberByAccount2" type='submit' value='查詢'>
        </li>
        
        <li>姓名查詢:	    
		<input type='text' style='width: 100px' name="name" id="SearchMemberByName1" placeholder="請輸入姓名" > 
	    <input id="SearchMemberByName2" type='submit' value='查詢'>     
        </li>
        
        <li>地區查詢:	   
		<input type='text' style='width: 100px' name="address" id="SearchMemberByAddress1" placeholder="請輸入縣市" > 
	    <input id="SearchMemberByAddress2" type='submit' value='查詢'>
        </li>
        
        <li>停權人員查詢:
	    <input id="SearchMemberByAu"  type='button' value='查詢'>
        </li>	
		</ul>					
        <br>
        <img class="img1" src="images/dice.png">    
</body>
</html>