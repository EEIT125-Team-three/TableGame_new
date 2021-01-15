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
    <title>會員密碼更改</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Member.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
</head>

<body class="header_body">
	<header>
	</header>


<form class='center' method="POST" action="updatePassword">
  
        <legend class="UMP_title">密碼更改</legend>       
			<input type="hidden" name="finalDecision" value="">
			<table>
			<tr>
			<td class="UMP_td">帳號:</td>
			<td><input class="UMP_input" name="account" size="30" value="${account}" disabled/>
			</td>
			</tr>			
			<tr>
			<td class="UMP_td">舊密碼:</td>
			<td><input class="UMP_input" type="password" name="password1" id="password1" size="30" placeholder="請輸入密碼"/>
			<i class="fa fa-eye" onclick="showhide1()" id="eye1"></i>
			<span id="sp1" class="RE_span"></span>
			</td>
			</tr>
			<tr>
			<td class="UMP_td">新密碼:</td>
			<td><input class="UMP_input" type="password" name="password" id="password2" size="30" onblur="checkPassword()" placeholder="請輸入密碼"/>
			<i class="fa fa-eye" onclick="showhide2()" id="eye2"></i>
			<span id="sp2" class="RE_span"></span></td>
			</tr>
			<tr>
			<td class="UMP_td">確認新密碼:</td>
			<td><input class="UMP_input" type="password" name="password2" id="password2" size="30" onblur="checkPasswordAgain()" placeholder="請輸入密碼"/>
			<i class="fa fa-eye" onclick="showhide3()" id="eye3"></i>
			<span id="sp3" class="RE_span"></span></td>
			</tr>		
			
			<tr>
			<td colspan="2" align="center"><input id="UMP_Btn"  class="UMP_Btn" type="submit" value="確認修改"
			name='updateBtn' onclick="return confirmUpdate('${member.userId}');">			
			<button class="UMP_Btn"><a class="UMP_link" href="javascript:history.back()">回上一頁</a></button>
			</td>
			</tr>
			</table>
			<c:if test="${not empty requestScope.modify}">
				<c:remove var="member" scope="request" />
			</c:if>
		
		</form>		
		<p />
<script type="text/javascript">

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
