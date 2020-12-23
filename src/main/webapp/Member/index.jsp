<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>會員資料管理</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
</head>

<body class="header_body">
	<header>
	</header>
	<form>
    <fieldset>
        <legend class="ti">會員資料維護</legend>
        <table cellspacing="2" cellpadding="1" width="100%">
				<tr>
					<td><a class="link" href="${pageContext.request.contextPath }/InsertMember">新增會員資料</a></td>
					<td><a class="link" href="${pageContext.request.contextPath }/showMembers">查詢會員資料</a></td>
				</tr>
				<tr>
				<td><a class="link" href="${pageContext.request.contextPath }/showMembers">修改會員資料</a></td>
				<td><a class="link" href="${pageContext.request.contextPath }/showMembers">刪除會員資料</a></td>
				</tr>		
				<tr>
<!-- 					<td><a class="link" href="/" onclick="checkout()">登出</a></td> -->
                <td><a class="link" href="${pageContext.request.contextPath }/login" onclick="checkout()">登出</a></td>
				</tr>		   
        </table>
        <br>
        <img class="img1" src="images/dice.png">
    </fieldset>
    </form>           
<script>
        function checkout() {
        	alert("已登出,歡迎下次再來")
        	}
</script>
	
</body>
</html>