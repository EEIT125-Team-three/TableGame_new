<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>123</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Standard.css">
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
    <script src="${pageContext.request.contextPath}/js/Standard.js"></script>
    <script src="${pageContext.request.contextPath}/js/SearchList.js"></script>
	<style>
	.fieldset_st{
		background-image:url(${pageContext.request.contextPath}/images/墨綠色背景.jpg);
		width:700px;
		border-radius:15px;
		color:	#FFC78E;
		
	}
	.display_img{
		width:350px;
		height:350px;
		float:right;
	}
	</style>
</head>

<body class="header_body">
	<header>
	</header>

	<div class="standard_nav"
	style="margin-right:20px;width: 200px; height: fit-content; float: left;background-image: url(${pageContext.request.contextPath}/images/墨綠色背景.jpg)">
	</div>
	<fieldset class='fieldset_st'>

        <h1 style="font-size: xx-large;color: rgb(234, 241, 171);">請選擇條件</h1>
        <div>
        <form style="font-size: xx-large;font-weight: bold;margin-left: 50px;width: fit-content;line-height: 1.5;color: rgb(166, 245, 245);"
            action="AdvancedSearch" method="POST" onsubmit="return handleData()" id="form1">
			<div style='float:left;text-align:right'>
				<label>英文名字: </label><br>
				<label>中文名字: </label><br>
				<label>創作者: </label><br>
				<label>插畫家: </label><br>
				<label>價錢: </label>
	    	</div>
	    	<div style='float:left;'>
				<input type='text'  name='E_name'><br>	
				<input type='text'  name='C_name'><br>
				<input type='text'  name='G_maker'><br>
				<input type='text'  name='iss'><br>
				<input type='text'  name='Price'><span> ~ </span><input type='text' name='Price1' required><br>
				<p style='font-size:20px;color:yellow;margin-top:1px'>( 請輸入正整數 )</p>
            	<input type="submit" value="送出">
            	<input type="reset" value="清除">
            </div>
        </form>
        </div>

    </fieldset>

    <img class='display_img' src='${pageContext.request.contextPath}/images/目擊者之夜.jpg'>
    <img class='display_img' src='${pageContext.request.contextPath}/images/妙語偵探社.jpg'>
    <img class='display_img' src='${pageContext.request.contextPath}/images/駱駝大賽.jpg'>





</body>

</html>