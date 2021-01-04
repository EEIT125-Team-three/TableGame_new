<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>123</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/manager_page.css">
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
	<style type="text/css">
	 .table_st{
	 	font-size:35px;
	 	border:2px solid blue;
	 	background-image:url(${pageContext.request.contextPath}/images/青色紙背景.jpg);
	 	border-radius:5px;
	 	margin:auto;
	 	
	 }
	 .td_st{
	 	width:150px;
	 }
	 input{
	 	width:450px;
	 }
	 .btn_rep_st{
		width:100px;
		height:30px;
		font-size:20px;
		border-radius:5px;
		background-color:#006030;
		color:#FFD306
	}
 	</style>
	<script type="text/javascript">
	
		function confirmUpdate(productId) {
			var result = confirm("確定修改此筆資料?");
			if (result) {
				document.forms[0].finalDecision.value = "UPDATE";
				return true;
			}
			return false;
		}
// 		function confirmTest() {
// 			Swal.fire(
// 	                "資料異動", //標題 
// 	                "", //訊息內容(可省略)
// 	                "warning" //圖示(可省略) success/info/warning/error/question
// 	                //圖示範例：https://sweetalert2.github.io/#icons
// 	            );
// 	        }
	</script>
</head>

<body class="header_body">
	<header>
	</header>

<form:form method='POST' modelAttribute='gb'>
<div style="text-align:center;">
	<table class='table_st'>
		<tr>
			<th>項目</th>
			<th width='500px'>內容</th>
		</tr>
		<tr>
			<td>遊戲編號 :</td>
			<td><input type="text" name="productId" value="${param.productId}" ></td>
		</tr>
		<tr>
			<td>英文名稱 :</td>
			<td><input type="text" name="E_name" value="${gb.e_name}${param.e_name}" ></td>
		</tr>
		<tr>
			<td>中文名稱 :</td>
			<td><input type="text" name="C_name" value="${gb.c_name}${param.c_name}" ></td>
		</tr>
		<tr>
			<td>圖片連結 :</td>
			<td><input type="text" name="img_url" value="${gb.img_url}${param.img_url}" ></td>
		</tr>
		<tr>
			<td>作者 :</td>
			<td><input type="text" name="G_maker" value="${gb.g_maker}${param.G_make}" ></td>
		</tr>
		<tr>
			<td>插畫家 :</td>
			<td><input type="text" name="iss" value="${gb.iss}${param.iss}" ></td>
		</tr>
		<tr>
			<td>資訊 :</td>
			<td><input type="text" name="info" value="${gb.info}${param.info}" ></td>
		</tr>
		<tr>
			<td>價錢 :</td>
			<td><input type="text" name="Price" value="${gb.price}${param.Price}" ></td>
		</tr>
		<tr>
			<td>瀏覽數 :</td>
			<td><input type="text" name="viewCount" value="${gb.viewCount}${param.viewCount}" ></td>
		</tr>
		<tr>
			<td>上市日期 :</td>
			<td><input type="text" name="date" value="${gb.date}${param.date}" ></td>
		</tr>
		<tr>
			<td>庫存 :</td>
			<td><input type="text" name="storage" value="${gb.storage}${param.storage}" ></td>
		</tr>

		<tr>
			<td colspan="2" align="center">
<%-- 			<input width="50px" type="submit" value="更新" onclick="return confirmUpdate('${gb.productId}');"><br> --%>
			<input class="btn_rep_st" width="50px" type="submit" value="更新" onclick="return confirmUpdate('${gb.productId}');"><br>
			<input class="btn_rep_st" width="50px" type="reset" value="清空資料" onclick="return confirmUpdate('${gb.productId}');">
		</td>
		</tr>
	</table>
	</div>
	</form:form>
<!-- 	<a href='manager_page.jsp'><span style="font-size:20px">回到遊戲管理</span></a> -->
<footer class="footer_body">
</footer>
</body>
</html>