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
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</head>

<body class="header_body">
	<header>
	</header>


<form class='center' method="POST" action="updatePassword" id="forget">
        <div class="UMP_title">密碼更改</div>
        <br>       
			<input type="hidden" name="finalDecision" value="">
			<table cellspacing="5" cellpadding="5" width="100%">
			<tr>
			<td class="UMP_td1">舊密碼:</td>
			<td><input class="UMP_input" type="password" name="password1" id="password1" size="30" placeholder="請輸入密碼"/>
			<i class="fa fa-eye fa-2x" onclick="showhide1()" id="eye1"></i>
			<span id="sp1" class="RE_span"></span>
			</td>
			</tr>
			<tr>
			<td class="UMP_td1">新密碼:</td>
			<td><input class="UMP_input" type="password" name="password" id="password2" size="30" onblur="checkPassword()" placeholder="請輸入密碼"/>
			<i class="fa fa-eye fa-2x" onclick="showhide2()" id="eye2"></i>
			<span id="sp2" class="RE_span"></span></td>
			</tr>
			<tr>
			<td class="UMP_td1">確認新密碼:</td>
			<td><input class="UMP_input" type="password" name="password2" id="password3" size="30" onblur="checkPasswordAgain()" placeholder="請輸入密碼"/>
			<i class="fa fa-eye fa-2x" onclick="showhide3()" id="eye3"></i>
			<span id="sp3" class="RE_span"></span></td>
			</tr>		
			</table>
			<c:if test="${not empty requestScope.modify}">
				<c:remove var="member" scope="request" />
			</c:if>	
		</form>
				<button class="UMP_Btn" name='updateBtn' onclick="confirmUpdate('${member.userId}')">確認修改</button>			
		<button class="UMP_Btn"><a class="UMP_link" href="${pageContext.request.contextPath }/login">回會員資料</a></button>
		<button class="RE_btn" id="forgetPwd">一鍵輸入</button>	 		
		<p />
<script type="text/javascript">
function confirmUpdate(userId) {				
	Swal.fire({
	  title: '是否確認重設密碼?',
	  icon: 'question',
	  background: '#fff url()',
// 	  backdrop: `
// 	    rgba(0,0,123,0.4)
// 	    url("${pageContext.request.contextPath}/images/s1.gif")
// 	    center top
// 	    no-repeat
// 	  `,
	  showCancelButton: true,
	  cancelButtonText: '取消',
	  confirmButtonColor: '#3085d6',
	  cancelButtonColor: '#d33',
	  confirmButtonText: '確認'
	}).then((result) => {
	  					  
      console.log(result.isConfirmed)
	  if (result.isConfirmed) {
	    Swal.fire(
	      '已重設密碼!'
	    ).then((result) =>{
	    	$("#forget").submit();
				return true;
	    })
	  }
	})
return false;
}
</script>	
</body>

</html>
