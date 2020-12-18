<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Post</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC&display=swap"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/Post_Article.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"
	integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30="
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>
</head>

<body>
<body class="header_body">
	<header> </header>

	<form action="post">
		<div class="accountID">

			<label for="account" style="font-size: xx-large" id="id"> 會員:</label>

		</div>
		<div>
			<label for="title" style="font-size: xx-large;">標題:</label> <input
				type="text" name="title" class="title">
		</div>
		<div>
			<label for="textarea" style="font-size: xx-large;">內容:</label>
			<textarea class="textarea">

            </textarea>
		</div>
		<div>
			<a href="Discussion-Brain.html" class="header_a"><input
				class="postBT" type="submit" value="發表文章"></a>
		</div>
		<div>
			<input class="clearBT" type="reset" value="清空文章">
		</div>

	</form>
</body>

</html>