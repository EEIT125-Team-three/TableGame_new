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
	href="${pageContext.request.contextPath}/css/newinfo_style.css">
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>
<script src="${pageContext.request.contextPath}/js/Act.js"></script>
</head>
<body class="header_body">
	<script src="${pageContext.request.contextPath}/js/InfoMenu.js"></script>
	<header> </header>
	<div class="menu"></div>

	<div class="search">
		<a href="${pageContext.request.contextPath}/AllInfos"><button
				type='button'>修改活動資料</button></a>
	</div>
	<div class="update">
		<form:form method="POST" modelAttribute="InfoBean"
			enctype="multipart/form-data">

			<div class="updateform">
				<h3>新增活動</h3>
				<table class="update" border="1">
					<tr>
						<td><label class="u1">活動區域:</label></td>
						<td><form:select type="text" path="actArea" id="Area"
								size="0" maxlength="10" onchange="onSelectArea();">
								<form:option value="">請選擇</form:option>
								<form:option value="台北">台北</form:option>
								<form:option value="台中">台中</form:option>
								<form:option value="高雄">高雄</form:option>
								<form:option value="桃園">桃園</form:option>
							</form:select><span id="actsp1" class="SH_span"></span></td>
					</tr>
					<tr>
						<td><label class="u1">項目:</label></td>
						<td><form:select type="text" path="activity" id="Act"
								size="0" maxlength="10" onchange="onSelectAct();">
								<form:option value="">請選擇</form:option>
								<form:option value="活動">活動</form:option>
								<form:option value="課程">課程</form:option>
							</form:select><span id="actsp2" class="SH_span"></span></td>
					</tr>
					<tr>
						<td><label class="u1">活動形式:</label></td>
						<td><form:select type="text" path="actType" id="Type"
								size="0" maxlength="10" placeholder="活動類型">
							</form:select> <span id="actsp3" class="SH_span"></span></td>
					</tr>
					<tr>
						<td><label class="u1">活動日期(1):</label></td>
						<td><form:input type="date" path="actDate1" /></td>
					</tr>
					<tr>
						<td><label class="u1">時間(1):</label></td>
						<td><label class="u1">開始: <form:input type="time"
									path="actStrTime1" /> ~ 結束:<form:input type="time"
									path="actEndTime1" /></label></td>
					</tr>
					<tr>
						<td><label class="u1">活動日期(2):</label></td>
						<td><form:input type="date" path="actDate2" /></td>
					</tr>
					<tr>
						<td><label class="u1">時間(2):</label></td>
						<td><label class="u1">開始:<form:input type="time"
									path="actStrTime2" />~ 結束: <form:input type="time"
									path="actEndTime2" /></label></td>
					</tr>
					<tr>
						<td><label class="u1">活動天數:</label></td>
						<td><form:input type="text" path="actDay" /></td>
					</tr>
					<tr>
						<td><label class="u1">活動地點:</label></td>
						<td><form:select id="Location" size="0" maxlength="10"
								type="text" path="actLocation" onchange="onSelectLoc();"></form:select></td>
					</tr>
					<tr>
						<td><label class="u1">活動地址:</label></td>
						<td><span></span>
						<form:input type="text" path="actAddress" size="0" maxlength="20"
								id="Address" style="display:none" /></td>
					</tr>
					<tr>
						<td><label class="u1">人數限制:</label></td>
						<td><form:input type="text" path="actLimitPer" /></td>
					</tr>
					<tr>
						<td><label class="u1">活動費用:</label></td>
						<td><form:input type="text" path="actCost" /></td>


					</tr>
					<tr>
						<td style='text-align: center;' colspan='2'><input
							type="submit" name="submit" value="新增"> <input
							type="reset" name="reset" value="重設"></td>
					</tr>
				</table>
			</div>
		</form:form>
	</div>
</body>
<script src="${pageContext.request.contextPath}/js/ActInsert.js"></script>

</html>