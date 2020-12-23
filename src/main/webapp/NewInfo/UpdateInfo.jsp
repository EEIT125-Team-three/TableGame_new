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
<title>Show All Informations</title>
</head>
<body>
	<form:form class='center' method="POST" modelAttribute="InfoBean">
		<fieldset>
			<div class="center-block">
				<h2>編輯活動資料</h2>
				<hr>
				<form:input type="hidden" path="activityId" />
				<c:forEach var="info" varStatus="statusX" items="${AllInfos}">
					<c:if test="${statusX.first}">
						<c:out value="<table border='1' cellspacing='5' cellpadding='5' >"
							escapeXml="false" />
						<tr bgcolor="CCCC00">
							<td colspan='5' ALIGN='CENTER'>活動資料</td>
						</tr>
						<table>
							<tr>
								<td>活動ID</td>
								<td>${info.acitvityId}${param.acitvityId}</td>
							</tr>
							<tr>
								<td>地區</td>
								<td><form:input type="text" path="actArea" size="30" /></td>
							</tr>
							<tr>
								<td>類型</td>
								<td><form:input type="text" path="actType" size="30" /></td>
							</tr>
							<tr>
								<td>活動</td>
								<td><form:input type="text" path="activity" size="30" /></td>
							</tr>
							<tr>
								<td>日期(1)</td>
								<td><form:input type="date" path="actDate1" size="30" /></td>
							</tr>
							<tr>
								<td>開始時間(1)</td>
								<td><form:input type="time" path="actStrTime1" size="30" /></td>
							</tr>
							<tr>
								<td>結束時間(1)</td>
								<td><form:input type="time" path="actEndTime1" size="30" /></td>
							</tr>
							<tr>
								<td>日期(2)</td>
								<td><form:input type="date" path="actDate2" size="30" /></td>
							</tr>
							<tr>
								<td>開始時間(2)</td>
								<td><form:input type="time" path="actStrTime2" size="30" /></td>
							</tr>
							<tr>
								<td>結束時間(2)</td>
								<td><form:input type="time" path="actEndTime2" size="30" /></td>
							</tr>
							<tr>
								<td>天數</td>
								<td><form:input type="text" path="actDay" size="30" /></td>
							</tr>
							<tr>
								<td>地點</td>
								<td><form:input type="text" path="actLocation" size="30" /></td>
							</tr>
							<tr>
								<td>地址</td>
								<td><form:input type="text" path="actAddress" size="30" /></td>
							</tr>
							<tr>
								<td>限制人數</td>
								<td><form:input type="text" path="actLimitPer" size="30" /></td>
							</tr>
							<tr>
								<td>費用</td>
								<td><form:input type="text" path="actCost" size="30" /></td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input class="login"
									type="submit" value="更新" name='updateBtn'
									onclick="return confirmUpdate('${info.userId}');"> <input
									type="submit" class="login" value="刪除" name='deleteBtn'
									onclick="return confirmDelete('${info.userId}');"></td>
							</tr>
						</table>
					</c:if>
					<c:choose>
						<c:when test="${ statusX.count % 2 == 0 }">
							<c:set var="colorVar" value="99ddff" />
						</c:when>
						<c:otherwise>
							<c:set var="colorVar" value="88dd00" />
						</c:otherwise>
					</c:choose>

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
		</fieldset>
	</form:form>
	<br>
	<small>&lt;&lt;<a href="resource/jsp/updateInfo.jsp">回管理頁面</a>&gt;&gt;
	</small>
	</div>
</body>
</html>