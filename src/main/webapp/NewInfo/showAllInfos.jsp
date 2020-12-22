﻿<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/styles.css'
	type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Informations</title>
</head>
<body>
	<div class="center-block">
		<h2>活動資料</h2>
		<hr>
		<c:forEach var="info" varStatus="statusX" items="${AllInfoBeans}">
			<c:if test="${statusX.first}">
				<c:out value="<table border='1' cellspacing='5' cellpadding='5' >"
					escapeXml="false" />
				<tr bgcolor="CCCC00">
					<td colspan='5' ALIGN='CENTER'>活動資料</td>
				</tr>
				<tr bgcolor="CCCC00">
					<th>活動ID</th>
					<th>地區</th>
					<th>類型</th>
					<th>活動</th>
					<th>日期(1)</th>
					<th>開始時間(1)</th>
					<th>結束時間(1)</th>
					<th>日期(2)</th>
					<th>開始時間(2)</th>
					<th>結束時間(2)</th>
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

			<tr bgcolor="${colorVar}">
				<td><a href='FindInfoServlet? activity_id=${info.activityId}'>${inf.activityId}</a></td>
				<td>${info.actArea}</td>
				<td>${info.actType}</td>
				<td>${info.activity}</td>
				<td>${info.actDate1}</td>
				<td>${info.actStrTime1}</td>
				<td>${info.actEndTime1}</td>
				<td>${info.actDate1}</td>
				<td>${info.actStrTime1}</td>
				<td>${info.actEndTime1}</td>
				<td>${info.actDay}</td>
				<td>${info.actLocation}</td>
				<td>${info.actAddress}</td>
				<td>${info.actLimitPer}</td>
				<td>${info.actCost}</td>
			</tr>
			<td><a href='UpdateInfo?id=${info.activityId}'><button
						type='button'>修改</button></a> <a
				href='DeleteInfo?id=${info.activityId}'><button type='button'>刪除</button></a></td>
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
				href="resource/jsp/updateInfo.jsp">回管理頁面</a>&gt;&gt;
			</small>
	</div>
</body>
</html>