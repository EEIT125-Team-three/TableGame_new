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
<title>已參與活動</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/Member.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/newinfo_style.css">
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>
</head>

<body class="header_body">
	<script src="${pageContext.request.contextPath}/js/InfoMenu.js"></script>
	<header> </header>
	<div class="menu"></div>
	<form method="post" style="height: 550px; overflow: scroll">
		<div class="SM_title">我的活動</div>
		<c:if test='${empty infoHistory}'>
		查無活動資料<br>
		</c:if>
		<c:if test='${not empty infoHistory}'>
			<c:forEach var='MI' varStatus='vs' items='${infoHistory}'>
				<c:if test='${vs.first }'>
					<c:out value="<table border='1'>" escapeXml='false' />
					<c:out
						value="<tr>
						<th class='SM_th'>活動區域</th>
						<th class='SM_th'>類型</th>
						<th class='SM_th'>活動形式</th>
						<th class='SM_th'>活動日期</th>
				        <th class='SM_th'>開始時間</th>
				        <th class='SM_th'>結束時間</th>
				        <th class='SM_th'>活動天數</th>
				        <th class='SM_th'>活動地點</th>				  
				        <th class='SM_th'>活動地址</th>
				        <th class='SM_th'>人數限制</th>
				        <th class='SM_th'>活動費用</th>
				        </tr>"
						escapeXml='false' />
				</c:if>
				<tr class="SM_tr">
					<td style='display: none'>${MI.member}</td>
					<td>${MI.info.actArea}</td>
					<td>${MI.info.actType}</td>
					<td>${MI.info.activity}</td>
					<td>${MI.info.actDate1}</td>
					<td>${MI.info.actStrTime1}</td>
					<td>${MI.info.actEndTime1}</td>
					<td>${MI.info.actDay}</td>
					<td>${MI.info.actLocation}</td>
					<td>${MI.info.actAddress}</td>
					<td>${MI.info.actLimitPer}</td>
					<td>${MI.info.actCost}</td>
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