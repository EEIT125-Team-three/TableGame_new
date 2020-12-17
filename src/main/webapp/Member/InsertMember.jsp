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
    <title>註冊新會員</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
</head>

<body class="header_body">
	<header>
	</header>

	<form:form method="post" modelAttribute="MemberBean">
		<fieldset>
			<legend class="ti">註冊新會員</legend>
			<table cellspacing="2" cellpadding="1" width="100%">
				<tr>
					<td>帳號ID:</td>
					<td><form:input type="text" path="memAccount" id="account"
							size="30" maxlength="20" onblur="checkId()" /><span id="sp1"></span></td>
				</tr>
				<tr>
					<td>密碼Password:</td>
					<td><form:input type="password" path="memPassword"
						 id="password" size="30" maxlength="20"
						onblur="checkPassword()"/> <i class="fa fa-eye"
						onclick="showhide()" id="eye"></i> <span id="sp2"></span></td>
				</tr>
				<tr>
					<td>確認密碼Password:</td>
					<td><input type="password" name="cpassword" id="cpassword"
						size="30" maxlength="20" onblur="checkPasswordAgain()"> <i
						class="fa fa-eye" onclick="showhide1()" id="eye"></i> <span
						id="sp3"></span></td>
				</tr>
				<tr>
					<td>姓名Name:</td>
					<td><form:input type="text" path="memName"
						id="name" size="30" maxlength="20" onblur="checkName()"/><span
						id="sp4"></span></td>
				</tr>
				<tr>
					<td>性別Gender:</td>
					<td><form:radiobutton  path="memGender" id="gender" value="male" checked="checked"/>男
					<form:radiobutton path="memGender" id="gender" value="female"/>女</td>
				</tr>
				<tr>
					<td>生日Birthday:</td>
					<td><form:input type="date" path="memBirthday" id="birthday"/>
					</td>
				</tr>
				<tr>
					<td>手機Phone:</td>
					<td><form:input type="text" path="memPhone" 
						id="phone" size="30" maxlength="20" onblur="checkPhone()"/><span
						id="sp5"></span></td>
				</tr>
				<tr>
					<td>信箱E-mail:</td>
					<td><form:input type="email" path="memMailaddress"
						 id="mailaddress" size="30"
						maxlength="30" onblur="checkMail()"/><span id="sp6"></span></td>
				</tr>
				<tr>
					<td>地址Address:</td>
					<td><form:input type="text" path="memAddress" 
						id="address" size="30" maxlength="30" onblur="checkAddress()"/><span
						id="sp7"></span></td>
				</tr>
				<tr>
					<td>身分證字號IdNumber:</td>
					<td><form:input type="text" path="memIdNumber"
						 id="idNumber" size="30" maxlength="30"
						onblur="checkIdNumber()"/><span id="sp8"></span></td>
				</tr>
				<tr>
					<td>大頭貼Photo:</td>
					<td><form:input type="file" path="memPic"
						id="pic" size="30" maxlength="30" onblur="checkIdNumber()"/><span
						id="sp8"></span></td>
				</tr>

			</table>
			<br>
			<div align="center">
				<input class="login" type="submit" name="submit" value="確認註冊">
				<input class="login" type="reset" value="清除重填">
			</div>
			<img class="img1" src="images/dice.png">
		</fieldset>
		<script src="js/register.js"></script>
	</form:form>


</body>
</html>