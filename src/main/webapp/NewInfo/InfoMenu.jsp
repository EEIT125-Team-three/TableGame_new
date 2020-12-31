<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>InfoMenu</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/InfoMenu_style.css">
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>
</head>

<body>
	<div class="menu">
		<h3>最新消息</h3>
		<dl id="optionmenu">
			<dd>
				<dl>
					<dt>
						<a href="${pageContext.request.contextPath}/NewActivityPage">活動消息</a>
					</dt>
				</dl>
			</dd>
			<dd>
				<dl>
					<dt>
						<a href="">課程資訊</a>
					</dt>
				</dl>
			</dd>
			<dd>
				<dl>
					<dt>我的活動</dt>
				</dl>
			<dd>
				<dl>
					<dt>
						<a href="${pageContext.request.contextPath}/NewInfoManager">管理者系統</a>
					</dt>
				</dl>
			</dd>
		</dl>
	</div>
</body>

</html>