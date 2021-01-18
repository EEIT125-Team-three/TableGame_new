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
    <title>重設密碼</title>
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

<fieldset class="LO_fieldset">
        <legend class="LO_title">重設密碼</legend>       
<form class='center' method="POST" action="forgetPassword" id="forget">
			<input type="hidden" name="finalDecision" value="">
			<table>		
			<tr>
			<td class="LO_td">帳號:</td>
			<td><input class="UMP_input" type="text" name="forget" id="password1" maxlength="30" size="30" placeholder="請輸入帳號"/>
			<span id="sp1" class="RE_span" style="color:red">${error}</span>
			</td>
			</tr>
			</table>
			<img class="img1" src="images/dice.png">
		 </form>
		 <br>
		<button class="UMP_Btn" name='updateBtn' onclick="confirmUpdate('${member.userId}')">確認修改</button>			
		<button class="UMP_Btn"><a class="UMP_link" href="${pageContext.request.contextPath }/login">回登入頁面</a></button>	 
		 </fieldset>		
		<p />
<script type="text/javascript">

function confirmUpdate(userId) {				
	Swal.fire({
	  title: '是否確認重設密碼?',
	  icon: 'question',
	  background: '#fff url()',
	  backdrop: `
	    rgba(0,0,123,0.4)
	    url("${pageContext.request.contextPath}/images/s1.gif")
	    center top
	    no-repeat
	  `,
	  showCancelButton: true,
	  cancelButtonText: '取消',
	  confirmButtonColor: '#3085d6',
	  cancelButtonColor: '#d33',
	  confirmButtonText: '確認'
	}).then((result) => {
	  					  
      console.log(result.isConfirmed)
	  if (result.isConfirmed) {
	    Swal.fire(
	      '已寄發確認信,請至電子信箱重設密碼!'
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
