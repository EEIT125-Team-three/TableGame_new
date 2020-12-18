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

</head>

<body class="header_body">
	<header>
	</header>

	<div class="standard_nav"
	style="width: 200px; height: fit-content; float: left;background-image: url(${pageContext.request.contextPath}/images/墨綠色背景.jpg)">
	

</div>
	<fieldset style="border: none;">

        <h1 style="font-size: xx-large;">請選擇條件</h1>
        <div>
        <form style="font-size: xx-large;font-weight: bold;margin-left: 50px;width: fit-content;line-height: 1.5;"
            action="AdvancedSearch" method="POST" onsubmit="return handleData()" id="form1">

	英文名字:<input type='text'  name='E_name'><br>	
	中文名字:<input type='text'      name='C_name'><br>
	創作者:<input type='text'      name='G_maker'><br>
	插畫家:<input type='text'      name='iss'><br>
	價錢:<input type='text'      name='Price'><span> ~ </span><input type='text' name='Price1' required><br>


            <input type="submit" value="送出">
            <input type="reset" value="清除">
        </form>
        </div>

    </fieldset>




</body>

</html>