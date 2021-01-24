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
    <title>享玩 桌遊｜密碼更新</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Member.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
	<script src="${pageContext.request.contextPath}/js/register.js"></script>	
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ScrollBar.css">
	<link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
</head>

<body class="header_body">
	<header>
	</header>
<fieldset class="LO_fieldset">  
        <legend class="LO_title">密碼更新</legend>       
<form class='center' method="POST" action="newPassword" id="newPassword1">
			<input type="hidden" name="finalDecision" value="">
			<table>	
			<tr>
			<td class="LO_td">帳號:</td>
			<td><input class="UMP_input" name="account" size="30" value="${account}" hidden="hidden"><span class="FO_Account">${account}</span>
			</td>
			</tr>					
			<tr>
			<td class="LO_td">新密碼:</td>
			<td><input class="UMP_input" id="password" type="password" size="30" onblur="checkPassword()" placeholder="請輸入密碼"/>
			<i class="fa fa-eye fa-2x" onclick="showhide()" id="eye1"></i>
			<span id="sp2" class="RE_span"></span></td>
			</tr>
			<tr>
			<td class="LO_td">確認密碼:</td>
			<td><input class="UMP_input" id="cpassword" type="password" name="password" size="30" onblur="checkPasswordAgain()" placeholder="請輸入密碼"/>
			<i class="fa fa-eye fa-2x" onclick="showhide1()" id="eye"></i>
			<span id="sp3" class="RE_span"></span></td>
			</tr>		
			</table>
			<c:if test="${not empty requestScope.modify}">
				<c:remove var="member" scope="request" />
			</c:if>
		</form>	
		<button class="UMP_Btn" name='updateBtn' onclick="confirmUpdate('${member.userId}')">確認更改</button>		
		<button class="UMP_Btn"><a class="UMP_link" href="${pageContext.request.contextPath }/login">回登入頁面</a></button>
		<button class="RE_btn" id="onePiece2">一鍵輸入</button>
		 </fieldset>
			
		<p />
		<footer class="footer_body" style="margin-top:250px">
		</footer> 
<script type="text/javascript">
	function confirmUpdate(userId) {				
				Swal.fire({
				  title: '是否更新密碼?',
				  icon: 'question',
				  background: '#fff url()',
// 				  backdrop: `
// 				    rgba(0,0,123,0.4)
// 				    url("${pageContext.request.contextPath}/images/s1.gif")
// 				    center top
// 				    no-repeat
// 				  `,
				  showCancelButton: true,
				  cancelButtonText: '取消更改',
				  confirmButtonColor: '#3085d6',
				  cancelButtonColor: '#d33',
				  confirmButtonText: '確認更改'
				}).then((result) => {
				  					  
			      console.log(result.isConfirmed)
				  if (result.isConfirmed) {
				    Swal.fire(
				      '更改成功!'
				    ).then((result) =>{
				    	$("#newPassword1").submit();
	 					return true;
				    })
				  }
				})
		return false;
	}
</script>	
</body>

</html>
