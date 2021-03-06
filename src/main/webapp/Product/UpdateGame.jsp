<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>享玩 桌遊 | 管理員 | 資料更新</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/manager_page.css">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
	<style type="text/css">
	 .table_st{
	 	font-size:35px;
	 	border:2px solid blue;
	 	background-color:rgba(226, 226, 219, 0.794);
	 	border-radius:5px;
	 	margin:auto;
	 	text-align:center;
	 	width:800px;
	 	
	 }
	 input{
	 	width:450px;
	 	font-size:20px;
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
			Swal.fire({
				  title: '確定更新資料?',
				  text: "",
				  icon: 'question',
				  showCancelButton: true,
				  confirmButtonColor: '#3085d6',
				  cancelButtonColor: '#d33',
				  confirmButtonText: '更新',
				  cancelButtonText:'取消'
				}).then((result) => {
				  if (result.isConfirmed) {
					  $("input").each(function(){
						  if($(this).val().trim() == ""){
							  $(this).val($(this).attr("value"))
						  }
							;
						});
					  $("form").eq(1).submit();
				  }
				  return false;
				})
			
		}
		function reset1(){
			$("input").each(function(){
				$(this).val("");
			});
		}
	</script>
</head>

<body class="header_body">
	<header>
	</header>

<div class='table_st'>
<form:form method='POST' modelAttribute='gb' id='form1'>
<div style="text-align:center;">
	<table>
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
		</td>
		</tr>
	</table>
	</div>
	</form:form>
		<button class="btn_rep_st" onclick="return confirmUpdate('${gb.productId}');">更新</button>
		<button class="btn_rep_st" onclick="reset1()">清空資料</button>
	</div>
<footer class="footer_body">
</footer>
</body>
</html>