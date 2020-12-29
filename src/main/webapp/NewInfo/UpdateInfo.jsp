<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>
<head>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/styles.css'
	type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modify Informations</title>
</head>
<body>
	<div class="center-block">
		<h2>編輯活動資料</h2>
		<hr>
		<form:form class='center' method="POST" modelAttribute="info">
			<fieldset>
				<legend class='modify'>活動資料</legend>
				<form:hidden path="activityId" />
				<table>
					<tr>
						<td>活動ID:</td>
						<td>${info.activityId}${param.activityId}</td>
					</tr>
					<tr>
						<td>地區:</td>
						<td><form:input type="text" path="actArea" id="actArea"
								size="30" /></td>
					</tr>
					<tr>
						<td>類型:</td>
						<td><form:input type="text" path="actType" id="" size="30" /></td>
					</tr>
					<tr>
						<td>活動:</td>
						<td><form:input type="text" path="activity" id="" size="30" /></td>
					</tr>
					<tr>
						<td>日期(1):</td>
						<td><form:input type="date" path="actDate1" id="" size="30" /></td>
					</tr>
					<tr>
						<td>開始時間(1):</td>
						<td><form:input type="time" path="actStrTime1" id=""
								size="30" /></td>
					</tr>
					<tr>
						<td>結束時間(1):</td>
						<td><form:input type="time" path="actEndTime1" id=""
								size="30" /></td>
					</tr>
					<tr>
						<td>日期(2):</td>
						<td><form:input type="date" path="actDate2" id="" size="30" /></td>
					</tr>
					<tr>
						<td>開始時間(2):</td>
						<td><form:input type="time" path="actStrTime2" id=""
								size="30" /></td>
					</tr>
					<tr>
						<td>結束時間(2):</td>
						<td><form:input type="time" path="actEndTime2" id=""
								size="30" /></td>
					</tr>
					<tr>
						<td>天數:</td>
						<td><form:input type="text" path="actDay" id="" size="30" /></td>
					</tr>
					<tr>
						<td>地點:</td>
						<td><form:input type="text" path="actLocation" id=""
								size="30" /></td>
					</tr>
					<tr>
						<td>地址:</td>
						<td><form:input type="text" path="actAddress" size="30" /></td>
					</tr>
					<tr>
						<td>限制人數:</td>
						<td><form:input type="text" path="actLimitPer" size="30" /></td>
					</tr>
					<tr>
						<td>費用:</td>
						<td><form:input type="text" path="actCost" size="30" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="修改" name='updateBtn'
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
	<br>
	<small>&lt;&lt;<a
		href="${pageContext.request.contextPath}/NewInfoManager">回管理頁面</a>&gt;&gt;
	</small>
</body>
</html>