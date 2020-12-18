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
<title>會員清單</title>
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
	<header> </header>

	<form>
		<fieldset>
			<legend class="ti">會員清單</legend>
			<c:if test='${empty allMembers}'>
		查無會員資料<br>
			</c:if>
			<c:if test='${not empty allMembers}'>
				<c:forEach var='member' varStatus='vs' items='${allMembers}'>
					<c:if test='${vs.first }'>
						<c:out value="<table border='1'>" escapeXml='false' />
						<c:out
							value="<tr><td>帳號</td><td>密碼</td><td>姓名</td><td>性別</td>
				<td>生日</td><td>手機</td><td>信箱</td><td>地址</td><td>身分證字號</td>
				<td>剩餘回饋金</td><td>大頭貼</td><td>編輯</td></tr>"
							escapeXml='false' />
					</c:if>

					<tr>
						<td>${member.memAccount}</td>
						<td>${member.memPassword}</td>
						<td>${member.memName}</td>
						<td>${member.memGender}</td>
						<td>${member.memBirthday}</td>
						<td>${member.memPhone}</td>
						<td>${member.memMailaddress}</td>
						<td>${member.memAddress}</td>
						<td>${member.memIdNumber}</td>
						<td>${member.memRefund}</td>
						<td><img width='100' height='150' src=${pageContext.request.contextPath}/${member.memPic} /></td>
						<td><a href='updateMember?id=${member.memId}'><button
									type='button'>修改</button></a> <a
							href='deleteMember?id=${member.memId}' onclick="javascript:return del()"><button type='button'>刪除</button></a></td>
					</tr>
					<c:if test='${vs.last }'>
						<c:out value="</table>" escapeXml='false' />
					</c:if>
				</c:forEach>
			</c:if>
			<a href="javascript:history.back()">回上一頁</a> <img class="img1"
				src="images/dice.png">
		</fieldset>
	</form>
	<script>
		function del() {
			var msg = "您真的確定要刪除嗎？";
			if (confirm(msg) == true) {
				return true;
			} else {
				return false;
			}
		}
	</script>
</body>
</html>