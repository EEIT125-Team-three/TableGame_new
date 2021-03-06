<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	href="${pageContext.request.contextPath}/css/newinfo_style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/shopCar.css">
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>
<script src="${pageContext.request.contextPath}/js/InfoMenu.js"></script>
</head>

<body class="header_body">
	<header> </header>
	<div class="menu"></div>
	<div class="center-block">
		<h2>活動資料</h2>
		<hr>
		<div class="Al_Tab" align="center">
			<c:forEach var="info" varStatus="statusX" items="${AllInfos}">
				<c:if test="${statusX.first}">
					<c:out value="<table border='1' cellspacing='5' cellpadding='5' >"
						escapeXml="false" />
					<tr bgcolor="#00A600">
						<td colspan='11' ALIGN='CENTER'>活動資料</td>
					</tr>
					<tr bgcolor="#00A600">
						<th>地區</th>
						<th>類型</th>
						<th>活動</th>
						<th>日期與活動時間(1)</th>
						<th>日期與活動時間(2)</th>
						<th>天數</th>
						<th>地點</th>
						<th>地址</th>
						<th>限制人數</th>
						<th>費用</th>
						<th>刪除/修改</th>
					</tr>
				</c:if>
				<c:choose>
					<c:when test="${ statusX.count % 2 == 0 }">
						<c:set var="colorVar" value="99ddff" />
					</c:when>
					<c:otherwise>
						<c:set var="colorVar" value="88dd00" />
					</c:otherwise>
				</c:choose>
				<tr>
					<td  style='display: none'>${info.activityId}</td>
					<td class="AI_T">${info.actArea}</td>
					<td class="AI_T">${info.actType}</td>
					<td class="AI_T">${info.activity}</td>
					<td class="AI_T">${info.actDate1}<br>${info.actStrTime1}~${info.actEndTime1}</td>
					<td class="AI_T">${info.actDate2}<br>${info.actStrTime2}~${info.actEndTime2}</td>
					<td class="AI_T">${info.actDay}</td>
					<td class="AI_T">${info.actLocation}</td>
					<td class="AI_T">${info.actAddress}</td>
					<td class="AI_T">${info.actLimitPer}</td>
					<td class="AI_T">${info.actCost}</td>
					<td class="AI_T"><a href='UpdateInfo?activityId=${info.activityId}'><button
								type='button'>修改</button></a> <a
						href='DeleteInfo?activityId=${info.activityId}'><button
								type='button'>刪除</button></a></td>
				</tr>

				<c:if test="${statusX.last}">
					<c:out value="</table>" escapeXml="flase" />
				</c:if>
			</c:forEach>
			<p>
				<c:if test="${not empty sessionScope.modify}">
					<font color='blue'>${sessionScope.modify}</font>
					<c:remove var="modify" scope="session" />
				</c:if>
				<c:if test="${not empty sessionScope.error}">
					<font color='red'>${sessionScope.error}</font>
					<c:remove var="error" scope="session" />
				</c:if>
				<br> <small>&lt;&lt;<a
					href="${pageContext.request.contextPath}/NewInfoManager">回管理頁面</a>&gt;&gt;
				</small>
		</div>
	</div>

</body>

</html>