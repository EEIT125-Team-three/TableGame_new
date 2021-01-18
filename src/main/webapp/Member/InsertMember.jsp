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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Member.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</head>

<body class="header_body">
	<header>
	</header>
		<fieldset class="RE_fieldset">
			<legend class="RE_title">註冊新會員</legend>
	<form:form method="post" modelAttribute="MemberBean" enctype="multipart/form-data">
			<table cellpadding="10">
				<tr>
					<td class="RE_td">帳號:</td>
					<td><form:input class="RE_input" type="text" path="memAccount" id="account1"
							size="30" maxlength="20" placeholder="請輸入帳號"/><span id="sp1" class="RE_span"></span></td>
				</tr>
				<tr>
					<td class="RE_td">密碼:</td>
					<td><form:input class="RE_input" type="password" path="memPassword"
						 id="password" size="30" maxlength="20"
						onblur="checkPassword()" placeholder="請輸入密碼"/> <i class="fa fa-eye fa-2x"
						onclick="showhide()" id="eye1"></i> <span id="sp2" class="RE_span"></span></td>
				</tr>
				<tr>
					<td class="RE_td">確認密碼:</td>
					<td><input class="RE_input" type="password" name="cpassword" id="cpassword"
						size="30" maxlength="20" onblur="checkPasswordAgain()" placeholder="再次輸入密碼"> 
						<i class="fa fa-eye fa-2x" onclick="showhide1()" id="eye"></i> <span
						id="sp3" class="RE_span"></span></td>
				</tr>
				<tr>
					<td class="RE_td">姓名:</td>
					<td><form:input class="RE_input" type="text" path="memName"
						id="name" size="30" maxlength="20" onblur="checkName()" placeholder="請輸入姓名"/><span
						id="sp4" class="RE_span"></span></td>
				</tr>
				<tr>
					<td class="RE_td">性別:</td>
					<td><form:radiobutton id="male" value="男孩"  class="RE_gen" path="memGender" checked="true"/>
						<label class="RE_genLabel" for="male">男孩</label>
						<form:radiobutton id="female" value="女孩"  class="RE_gen" path="memGender"/>
						<label class="RE_genLabel" for="female">女孩</label>
				</td>
				</tr>
				<tr>
					<td class="RE_td">生日:</td>
					<td><form:input class="RE_birthday" type="date" path="memBirthday" id="birthday" onblur="checkBirthday()"/>
					<span id="sp9" class="RE_span"></span>
					</td>
				</tr>
				<tr>
					<td class="RE_td">手機:</td>
					<td><form:input class="RE_input" type="text" path="memPhone" 
						id="phone" size="30" maxlength="20" onblur="checkPhone()" placeholder="請輸入手機號碼 "/><span
						id="sp5" class="RE_span"></span></td>
				</tr>
				<tr>
					<td class="RE_td">信箱:</td>
					<td><form:input class="RE_input" type="email" path="memMailaddress"
						 id="mailaddress" size="30"
						maxlength="30" onblur="checkMail()" placeholder="請輸入信箱"/><span id="sp6" class="RE_span"></span></td>
				</tr>
				<tr>
					<td class="RE_td">地址:</td>
					<td>
					<select class="RE_select" name="cityId" id="city">
						<option>臺北市</option>
					</select>
					<select class="RE_select" name="districtId" id="district">
						<option>中正區</option>
					</select>
					<select class="RE_select" name="roadId" id="road">
						<option>八德路</option>
					</select>
					<form:input class="RE_input" type="text" path="memAddress" 
						id="address" size="30" maxlength="30" onblur="checkAddress()" placeholder="請輸入地址"/><span
						id="sp7" class="RE_span"></span></td>
				</tr>
				<tr>
					<td class="RE_td">身分證字號:</td>
					<td><form:input class="RE_input" type="text" path="memIdNumber"
						 id="idNumber" size="30" maxlength="30"
						onblur="checkIdNumber()" placeholder="請輸入身分證字號"/><span id="sp8" class="RE_span"></span></td>
				</tr>
				<tr>
					<td class="RE_td">大頭貼:</td>
					<td>
					<img hidden=true id="show" class="UMP_pic">
					<label for="pic" class="custom-file-upload">
                    <i class="fa fa-cloud-upload"></i> 上傳頭貼
			        </label>
			        <input id="pic" type="file" name="file"/>
						</td>
				</tr>			

			</table>
			<br>
			<img class="img1" src="images/dice.png">
	</form:form>
			<div align="center">
				<button class="RE_btn" id="recheck">確認註冊</button>
				<button class="RE_btn" id="reset">清除重填</button>
			</div>
			<button class="RE_btn" id="onePiece">一閃輸入</button>
		</fieldset>		

<script src="js/register.js"></script>
</body>
</html>