<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head> 
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shopCarManager.css">
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
</head>
<body class="header_body">
	<header>
    </header>
    <article>
    	<div class="shopCarManager_Div1">
	    	<select>
	    		<option>近一個月</option>
	    		<option>近一季度</option>
	    		<option>近半年</option>
	    		<option>近一年</option>
	    	</select>
	    	<span>會員帳號:</span><input name="account">
	    	<button>查詢</button>
    	</div>
    	<div class="shopCarManager_Div2">
    		<table class="shopCarManager_Table1">
    			<tr>
    				<td>訂單編號</td>
    				<td>訂單時間</td>
    				<td>收件人</td>
    				<td>收件地址</td>
    				<td>收件人電話</td>
    				<td>訂單金額</td>
    				<td>訂單細節</td>    				
    			</tr>
    		</table>
    	</div>
    	<div>
    		<form action="" method="POST">
    		</form>
    	</div>
    	<div class="shopCarManager_Div3">
    		<table class="shopCarManager_Table1">
    			<tr>
    				<td>商品名稱</td>
    				<td>商品單價</td>
    				<td>購買數量</td>
    				<td>總價格</td>
 	  			</tr>
    		</table>
    	</div>
    </article>
	<footer class="footer_body">
	</footer>
</body>

</html>