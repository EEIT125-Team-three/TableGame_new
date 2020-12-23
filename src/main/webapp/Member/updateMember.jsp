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
    <title>會員資料編輯</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
</head>

<body class="header_body">
	<header>
	</header>


<form:form class='center' method="POST" modelAttribute="mb" enctype='multipart/form-data'>
  <fieldset>
        <legend class="ti">會員資料編輯</legend>
			<form:input type="hidden" path="memId"/> 
			<form:input type="hidden" path="memAccount"/>
			<input type="hidden" name="finalDecision" value="">
			<table>
			<tr><td>帳號Account:</td><td>${mb.memAccount}${param.memAccount}</td></tr>
			<tr><td>密碼Password:</td><td><form:input type="text" path="memPassword" size="30"/></td></tr>
			<tr><td>姓名Name:</td><td><form:input type="text" path="memName" size="30"/></td></tr>	
			<tr><td>性別Gender:</td><td><form:radiobutton path="memGender" value="male" checked="checked"/>男<form:radiobutton path="memGender" value="female"/>女</td></tr>	
			<tr><td>生日birthday:</td><td><form:input type="date" path="memBirthday" /></td></tr>
			<tr><td>手機Phone:</td><td><form:input type="text" path="memPhone" size="30"/></td></tr>
			<tr><td>信箱E-Mail:</td><td><form:input type="email" path="memMailaddress" size="30"/></td></tr>
			<tr><td>地址Address:</td><td><form:input type="text" path="memAddress" size="30"/></td></tr>
			<tr><td>身分證字號IdNumber:</td><td><form:input type="text" path="memIdNumber" size="30"/></td></tr>
			<tr><td>大頭貼Photo:</td>
			<td>
			<img width='100' height='150' src=${pageContext.request.contextPath}/${mb.memPic} />  
	        <input type="file" name="file"
						id="pic" size="30" maxlength="30" onblur="checkIdNumber()"/>
	        </td></tr>
			
				<tr>
					<td colspan="2" align="center"><input class="login" type="submit" value="更新"
						name='updateBtn'
						onclick="return confirmUpdate('${member.userId}');">
						<button class="login"><a href="javascript:history.back()">回上一頁</a></button>
						 </td>
				</tr>
			</table>
			<c:if test="${not empty requestScope.modify}">
				<c:remove var="member" scope="request" />
			</c:if>
			<img class="img1" src="images/dice.png">
			</fieldset>
		</form:form>
		
		<p />
<script type="text/javascript">
	function confirmDelete(userId) {
		var result = confirm("確定刪除此筆記錄(帳號:" + userId + ")?");
		if (result) {
			document.forms[0].finalDecision.value = "DELETE";
			return true;
		}
		return false;
	}
	function confirmUpdate(userId) {
		var result = confirm("確定送出此筆記錄(帳號:" + userId + ")?");
		if (result) {
			document.forms[0].finalDecision.value = "UPDATE";
			return true;
		}
		return false;
	}
</script>	
</body>

</html>
