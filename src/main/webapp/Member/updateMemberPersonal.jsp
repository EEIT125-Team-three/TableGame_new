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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Member.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</head>

<body class="header_body">
	<header>
	</header>


<form:form class='center' method="POST" modelAttribute="mb" enctype='multipart/form-data'>
  
        <legend class="UMP_title">會員資料更動</legend>       
			<form:input type="hidden" path="memId"/> 
			<form:input type="hidden" path="memAccount"/>
			<form:input type="hidden" path="memPassword"/>
			<form:input type="hidden" path="memGender"/>
			<form:input type="hidden" path="memBirthday"/>	
			<form:input type="hidden" path="memIdNumber"/>	
			<form:input type="hidden" path="memRefund"/>
			<form:input type="hidden" path="memCheckAu"/>
			<form:input type="hidden" path="memPic"/>
			<input type="hidden" name="finalDecision" value="">
			<table>
			<tr>
			<td class="UMP_td">帳號Account:</td>
			<td class="UMP_td" bgcolor=#E6F3D8 style="border:5px #8DD8D7 outset">${mb.memAccount}${param.memAccount}</td>
			</tr>
			<tr>
			<td class="UMP_td">姓名Name:</td>
			<td><form:input class="UMP_input" type="text" path="memName" size="30"/></td>
			</tr>	
			<tr>
			<td class="UMP_td">手機Phone:</td><td><form:input class="UMP_input" type="text" path="memPhone" size="30"/></td>
			</tr>
			<tr>
			<td class="UMP_td">信箱E-Mail:</td><td><form:input class="UMP_input" type="email" path="memMailaddress" size="30"/></td>
			</tr>
			<tr>
			<td class="UMP_td">地址Address:</td>
			<td>
			<select name="cityId" id="city">
			</select>
			<select name="districtId" id="district">
			</select>
			<select name="roadId" id="road">
			</select>
			<form:input class="UMP_input" type="text" path="memAddress" size="30"/></td>
			</tr>
			<tr>
			<td style="display:none">${mb.memId}</td>
			<td class="UMP_td">大頭貼Photo:</td>
			<td class="UMP_td">
			<img class="UMP_pic" id="show" src=''/>
			<label for="pic" class="custom-file-upload">
            <i class="fa fa-cloud-upload"></i> 重新上傳頭貼
			</label>
			<input id="pic" type="file" name="file"/>
			</td>	        
	        </tr>
			<tr>
			<td colspan="2" align="center">
<%-- 			<input id="UMP_Btn"  class="UMP_Btn" type="submit" value="確認修改"  name='updateBtn' onclick="return confirmUpdate('${member.userId}');">			 --%>
			<button class="UMP_Btn"><a class="UMP_link" href="javascript:history.back()">回上一頁</a></button>
			</td>
			</tr>
			</table>
			<c:if test="${not empty requestScope.modify}">
				<c:remove var="member" scope="request" />
			</c:if>
		
		</form:form>
		<button onclick="confirmUpdate('${member.userId}')">aaa</button>		
		<p />
<script type="text/javascript">

	function confirmUpdate(userId) {				
				Swal.fire({
				  title: '是否更新資料?',
				  icon: 'question',
				  background: '#fff url(${pageContext.request.contextPath}/images/86352.gif)',
				  backdrop: `
				    rgba(0,0,123,0.4)
				    url("${pageContext.request.contextPath}/images/s1.gif")
				    left top
				    no-repeat
				  `,
				  showCancelButton: true,
				  cancelButtonText: '要取消那你改屁啊!',
				  confirmButtonColor: '#3085d6',
				  cancelButtonColor: '#d33',
				  confirmButtonText: '確認'
				}).then((result) => {
				  					  
			      console.log(result.isConfirmed)
				  if (result.isConfirmed) {
				    Swal.fire(
				      '修改成功!'
				    ).then((result) =>{
				    	$("#mb").submit();
// 					    document.forms[0].finalDecision.value = "UPDATE";
	 					return true;
				    })
				  }
				})
// 				var result = confirm("確定送出此筆記錄(帳號:" + userId + ")?");
// 		if (result) {
			
// // 			document.forms[0].finalDecision.value = "UPDATE";
// 			return true;
// 		}
		return false;
	}
</script>	
</body>

</html>
