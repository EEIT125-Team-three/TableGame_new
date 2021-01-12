<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head> 
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shopCarManager.css">
    <script src="${pageContext.request.contextPath}/js/shopCarManager.js"></script>
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
</head>
<body class="header_body">
	<header>
    </header>
    <article>
    	<div class="shopCarManager_Div1">
	    	<select class="dateRage">
	    		<option value=null>所有時間</option>
	    		<option value="1">近一個月</option>
	    		<option value="3">近一季度</option>
	    		<option value="6">近半年</option>
	    		<option value="12">近一年</option>
	    	</select>
	    	<span>訂單編號:</span><input id="orderId">
	    	<button>查詢</button>
    	</div>
    	<div class="shopCarManager_Div2">
    		<table class="shopCarManager_Table1">
    		</table>
    	</div>
    	<div>
    		<form action="" method="POST">
    		</form>
    	</div>
    	<div class="shopCarManager_Div3">
    		<table class="shopCarManager_Table1">
    		</table>
    	</div>
    <div class="backOver">
    </div>
    <div class="centerOver">
    </div>
    </article>
	<footer class="footer_body">
	</footer>
</body>

</html>