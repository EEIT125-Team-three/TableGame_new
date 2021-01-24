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
<title>123</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/shopCar.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/newinfo_style.css">
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>
<script src="${pageContext.request.contextPath}/js/Act.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</head>

<body class="header_body">
	<script src="${pageContext.request.contextPath}/js/InfoMenu.js"></script>
	<header> </header>
	<div class="menu"></div>
	<fieldset class="AddInfoField">
		<div class="center-block">
			<h2>編輯活動資料</h2>
			<hr>
			<form:form class='center' method="POST" modelAttribute="info" id="updateInfo">
				<fieldset>
					<legend class='modify'>
						活動資料
						<form:hidden path="activityId" />
					</legend>
					<table>
						<tr>
							<td>活動ID:</td>
							<td>${info.activityId}${param.activityId}</td>
						</tr>
						<tr>
							<td><label class="u1">地區:</label></td>
							<td><label class="u1"><form:input type="text"
										path="actArea" id="Area" size="30" /></label><span id="actsp1"
								class="SH_span"></span></td>
						</tr>
						<tr>
							<td><label class="u1">項目:</label></td>
							<td><label class="u1"><form:input type="text"
										path="actType" id="Type" size="30" /></label><span id="actsp2"
								class="SH_span"></span></td>
						</tr>
						<tr>
							<td><label class="u1">活動類型:</label></td>
							<td><label class="u1"><form:input type="text"
										path="activity" id="Act" size="30" /></label><span id="actsp3"
								class="SH_span"></span></td>
						</tr>
						<tr>
							<td><label class="u1">日期(1):</label></td>
							<td><label class="u1"><form:input type="date"
										path="actDate1" id="Date1" size="30" /></label><span id="actsp4"
								class="SH_span"></span></td>
						</tr>
						<tr>
							<td><label class="u1">活動時間(1):</label></td>
							<td><label class="u1">時間:<form:input type="time"
										path="actStrTime1" id="strtime1" size="30" /> ~ 時間:<form:input
										type="time" path="actEndTime1" id="endtime1" size="30" /></label><span
								id="actsp5" class="SH_span"></span></td>
						</tr>
						<tr>
							<td><label class="u1">日期(2):</label></td>
							<td><label class="u1"><form:input type="date"
										path="actDate2" id="Date2" size="30" /></label><span id="actsp6"
								class="SH_span"></span></td>
						</tr>
						<tr>
							<td><label class="u1">活動時間(2):</label></td>
							<td><label class="u1">時間:<form:input type="time"
										path="actStrTime2" id="strtime2" size="30" /> ~ 時間:<form:input
										type="time" path="actEndTime2" id="endtime2" size="30" /></label><span
								id="actsp7" class="SH_span"></span></td>
						</tr>
						<tr>
							<td><label class="u1">天數:</label></td>
							<td><label class="u1"><form:input type="text"
										path="actDay" id="Day" size="30" /></label><span id="actsp8"
								class="SH_span"></span></td>
						</tr>
						<tr>
							<td><label class="u1">地點:</label></td>
							<td><label class="u1"><form:input type="text"
										path="actLocation" id="Location" size="30" /></label><span
								id="actsp9" class="SH_span"></span></td>
						</tr>
						<tr>
							<td><label class="u1">地址:</label></td>
							<td><label class="u1"><form:input type="text"
										path="actAddress" id="Address" size="30" /></label><span id="actsp10"
								class="SH_span"></span></td>
						</tr>
						<tr>
							<td><label class="u1">限制人數:</label></td>
							<td><label class="u1"><form:input type="text"
										path="actLimitPer" id="Limitper" size="30" /></label><span
								id="actsp11" class="SH_span"></span></td>
						</tr>
						<tr>
							<td><label class="u1">費用:</label></td>
							<td><label class="u1"><form:input type="text"
										path="actCost" size="30" id="Cost" /></label><span id="actsp12"
								class="SH_span"></span></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="submit"
								value="修改" id="updatecheck" name='updateBtn'
								onclick="return confirmUpdate('${info.activityId}');"> <input
								type="submit" value="刪除" name='deleteBtn'
								onclick="return confirmDelete('${info.activityId}');"></td>
						</tr>
					</table>
					<c:if test="${not empty sessionScope.modify}">
						<font color='blue'>${sessionScope.modify}</font>
						<c:remove var="modify" scope="session" />
					</c:if>
					<c:if test="${not empty sessionScope.error}">
						<font color='red'>${sessionScope.error}</font>
						<c:remove var="error" scope="session" />
					</c:if>
				</fieldset>
			</form:form>
		</div>
	</fieldset>
	<br>
	<small>&lt;&lt;<a
		href="${pageContext.request.contextPath}/NewInfoManager">回管理頁面</a>&gt;&gt;
	</small>
</body>
<script src="${pageContext.request.contextPath}/js/ActInsert.js"></script>
</html>