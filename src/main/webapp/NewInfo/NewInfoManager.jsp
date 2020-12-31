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
<title>New Information</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/shopCar.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/newinfo_style.css">
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>
</head>
<body class="header_body">
<script src="${pageContext.request.contextPath}/js/InfoMenu.js"></script>
	<header> </header>
	<div class="menu">
	</div>
	<div class="search">
		<a href="${pageContext.request.contextPath}/AllInfos"><button
				type='button'>修改活動資料</button></a>
	</div>
	<div class="update">
		<form:form method="POST" modelAttribute="InfoBean"
			enctype="multipart/form-data">
			<fieldset>
				<figure class="fupdate">
					<div class="updateform">
						<legend>
							<h3>新增活動</h3>
							<table cellspacing="2" cellpadding="1" border="1" width="100%">

								<tr>
									<td><label path="actArea">活動區域:</label></td>
									<td><form:input path="actArea" /></td>
								</tr>
								<tr>
									<td><label path="activity" class="u1">類型:</label></td>
									<td><form:input type="text" path="activity" /></td>
								</tr>
								<tr>
									<td><label class="u1">活動形式:</label></td>
									<td><form:input type="text" path="actType" /></td>
								</tr>
								<tr>
									<td><label class="u1">活動日期(1):</label></td>
									<td><form:input type="date" path="actDate1" /></td>
									<td><label class="u1">開始時間(1):</label></td>
									<td><form:input type="time" path="actStrTime1" /></td>
									<td><label class="u1">結束時間(1):</label></td>
									<td><form:input type="time" path="actEndTime1" /></td>
								</tr>
								<tr>
									<td><label class="u1">活動日期(2):</label></td>
									<td><form:input type="date" path="actDate2" /></td>
									<td><label class="u1">開始時間(2):</label></td>
									<td><form:input type="time" path="actStrTime2" /></td>
									<td><label class="u1">結束時間(2):</label></td>
									<td><form:input type="time" path="actEndTime2" /></td>
								</tr>
								<tr>
									<td><label class="u1">活動天數:</label></td>
									<td><form:input type="text" path="actDay" /></td>
								</tr>
								<tr>
									<td><label class="u1">活動地點:</label></td>
									<td><form:input type="text" path="actLocation" /></td>
								</tr>
								<tr>
									<td><label class="u1">活動地址:</label></td>
									<td><form:input type="text" path="actAddress" /></td>
								</tr>
								<tr>
									<td><label class="u1">人數限制:</label></td>
									<td><form:input type="text" path="actLimitPer" /></td>
								</tr>
								<tr>
									<td><label class="u1">活動費用:</label></td>
									<td><form:input type="text" path="actCost" /></td>
									</figcaption>
									</div>
									<div class="sub">
										<input type="submit" name="submit" value="新增"> <input
											type="reset" name="reset" value="重設">
									</div>
								</tr>
							</table>
						</legend>
					</div>
				</figure>
			</fieldset>
		</form:form>
	</div>

</body>

</html>