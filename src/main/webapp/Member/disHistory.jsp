<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>文章清單</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login.css">
<link
	href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>
</head>

<body class="header_body">
	<script src="${pageContext.request.contextPath}/js/showMember.js"></script>
	<header> </header>
	<form method="post" style="height:550px ;overflow:scroll" >				
			<c:if test='${empty disHistory}'>
		查無文章歷史資料<br>
			</c:if>
			<c:if test='${not empty disHistory}'>
				<c:forEach var='Dis' varStatus='vs' items='${disHistory}'>
					<c:if test='${vs.first }'>
						<c:out value="<table border='1'>" escapeXml='false' />
						<c:out value="<tr>
						<th>文章標題</th>
						<th>文章內容</th>
						<th>文章發表時間</th>
						<th>文章讚數</th>
				        </tr>"
						escapeXml='false'/>
					</c:if>
					<tr>
						<td style='display:none'>${Dis.member}</td>
						<td>${Dis.distitle}</td>
						<td>${Dis.disArtical}</td>
						<td>${Dis.disDate}</td>
						<td>${Dis.disLikesNo}</td>
					</tr>
					<c:if test='${vs.last}'>
						<c:out value="</table>" escapeXml='false' />
					</c:if>
				</c:forEach>
			</c:if>
			<img class="img1" src="images/dice.png">		

	</form>
</body>
</html>