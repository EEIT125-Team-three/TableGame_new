<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>123</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/manager_page.css">
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>
</head>

<body class="header_body">
	<header> </header>

	<div id="manager_div">
		<fieldset
			style="display: none; border: none; text-align: center; font-size: x-large; line-height: 1.5; font-weight: bold"
			id="search_fieldset">
			<legend>搜尋表單</legend>
			<form action='SearchGame' method='POST'>
				遊戲編號 :<input type='text' name='productId' required='required'><br>
				英文名稱 :<input type='text' name='E_name'><br> 中文名稱 :<input
					type='text' name='C_name'><br> 作者 :<input type='text'
					name='G_maker'><br> 插畫家 :<input type='text'
					name='Price'><br> 瀏覽數 :<input type='text'
					name='viewCount'><br> 上市日期 :<input type='text'
					name='date'><br> 庫存 :<input type='text' name='storage'><br>
				<input type='submit' value='送出'> <input type='reset'
					value='清除'>
			</form>
			<a href='SearchAllGame'><button type='button'>遊戲資料列表</button></a><br>
		</fieldset>

		<fieldset
			style="display: none; border: none; text-align: center; font-size: x-large; line-height: 1.5; font-weight: bold"
			id="creat_fieldset">
			<legend>新增遊戲至DB</legend>
			<form:form action='InsertGame' method='POST' modelAttribute='gb'>


                                英文名字:<input type='text' name='E_name'
					required='required'>
				<br> 中文名字:

                                <input type='text' name='C_name'
					required='required'>
				<br> 圖片連結:
                                <input type='text' name='img_url'>
				<br> 創作者:
                                <input type='text' name='G_maker'>
				<br> 插畫家:
                                <input type='text' name='iss'>
				<br> 內容:
                                <input type='text' name='info'>
				<br> 價錢:
                                <input type='text' name='Price'
					required='required'>
				<br> 瀏覽數:
                                <input type='text' name='viewCount'
					required='required'>
				<br> 上市日期:
                                <input type='date' name='date'
					required='required'>
				<!-- <span style="font-size:smaller;color:gray">格式ex:yyyy-MM-dd</span> -->
				<br> 庫存:
                                <input type='text' name='storage'
					required='required'>
				<br>


				<input type='submit' name='name' value='提交'>
				<input type='reset' name='name' value='清除'>
				<br>
				<br>
			</form:form>
		</fieldset>

	</div>
	<div class="manager_divst">
		<img src="${pageContext.request.contextPath}/images/勇氣徽章.png"
			style="height: 300px; width: 300px; margin-top: 15px;"
			onclick="manager_search_display()"> <img
			src="${pageContext.request.contextPath}/images/愛心徽章.png"
			style="height: 300px; width: 300px; margin-top: 15px;"
			onclick="manager_search_display()"> <img
			src="${pageContext.request.contextPath}/images/誠實徽章.png"
			style="height: 300px; width: 300px; margin-top: 15px;"
			onclick="manager_search_display()">
		<p>搜尋、刪除、修改資料庫中的遊戲</p>
	</div>

	<div class="manager_divst">
		<img src="${pageContext.request.contextPath}/images/純真徽章.png"
			style="height: 300px; width: 300px; margin-top: 15px;"
			onclick="manager_creat_display()">
		<p>新增資料庫中的遊戲</p>

	</div>

	<script src="${pageContext.request.contextPath}/js/Standard.js"></script>
	<script>
		function checkout() {
			alert("已登出,歡迎下次再來")
		}
	</script>

</body>

</html>