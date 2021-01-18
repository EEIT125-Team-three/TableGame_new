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
        <br>       
			<form:input type="hidden" path="memId"/> 
			<form:input type="hidden" path="memAccount"/>
			<form:input type="hidden" path="memPassword"/>
			<form:input type="hidden" path="memRefund"/>
			<form:input type="hidden" path="memCheckAu"/>
			<form:input type="hidden" path="memPic"/>
			<input type="hidden" name="finalDecision" value="">
			<table cellspacing="5" cellpadding="5" width="100%">
			<tr>
			<td class="UMP_td1">帳號:</td>
			<td class="UMP_td2">${mb.memAccount}${param.memAccount}</td>
			<td class="UMP_td1">姓名:</td>
			<td class="UMP_td2"><form:input class="UMP_input" type="text" path="memName" size="30"/></td>
			</tr>			
			<tr>
			<td class="UMP_td1">性別:</td>
			<td class="UMP_td2"><form:radiobutton id="male" value="男孩"  class="RE_gen" path="memGender" checked="true"/>
			<label class="RE_genLabel" for="male">男孩</label>
			<form:radiobutton id="female" value="女孩"  class="RE_gen" path="memGender"/>
			<label class="RE_genLabel" for="female">女孩</label></td>
			<td class="UMP_td1">生日:</td>
			<td class="UMP_td2"><form:input class="RE_birthday" type="date" path="memBirthday" id="birthday"/></td>
			</tr>
			
			<tr>
			<td class="UMP_td1">手機:</td>
			<td class="UMP_td2"><form:input class="UMP_input" type="text" path="memPhone" size="30"/></td>			
			<td class="UMP_td1">信箱:</td>
			<td class="UMP_td2"><form:input class="UMP_input" type="email" path="memMailaddress" size="30"/></td>
			</tr>
			
			<tr>
			<td class="UMP_td1">地址:</td>
			<td class="UMP_td2">
			<select class="RE_select" name="cityId" id="city">
			</select>
			<select class="RE_select" name="districtId" id="district">
			</select>
			<select class="RE_select" name="roadId" id="road">
			</select>
			<form:input class="UMP_input" type="text" path="memAddress" size="30"/></td>
			<td class="UMP_td1">身分證字號:</td>
			<td class="UMP_td2"><form:input class="RE_input" type="text" path="memIdNumber" id="idNumber" size="30" maxlength="30"/></td>			
			</tr>
			
			<tr>
			<td style="display:none">${mb.memId}</td>
			<td class="UMP_td1">大頭貼:</td>
			<td class="UMP_td2">
			<img class="UMP_pic" id="show" src=''/>
			<label for="pic" class="custom-file-upload">
            <i class="fa fa-cloud-upload"></i> 重新上傳頭貼
			</label>
			<input id="pic" type="file" name="file"/>
			</td>	        
	        </tr>
			<tr>
			<td colspan="2" align="center">
			</td>
			</tr>
			</table>
			<c:if test="${not empty requestScope.modify}">
				<c:remove var="member" scope="request" />
			</c:if>		
		</form:form>
		<button class="UMP_Btn" name='updateBtn' onclick="confirmUpdate('${member.userId}')">確認修改</button>		
		<button class="UMP_Btn"><a class="UMP_link" href="javascript:history.back()">回上一頁</a></button>
		
<script type="text/javascript">
	function confirmUpdate(userId) {				
				Swal.fire({
				  title: '是否更新資料?',
				  icon: 'question',
				  background: '#fff url()',
				  backdrop: `
				    rgba(0,0,123,0.4)
				    url("${pageContext.request.contextPath}/images/s1.gif")
				    center top
				    no-repeat
				  `,
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
				    	$("#mb").submit();
	 					return true;
				    })
				  }
				})
		return false;
	}
</script>	
</body>

</html>
