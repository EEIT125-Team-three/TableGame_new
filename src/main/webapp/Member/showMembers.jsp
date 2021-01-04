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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Member.css">
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>
</head>

<body class="header_body">
	<header> </header>
	<div style="height:550px ;overflow:scroll">
			<div class="SM_title">會員清單</div>
			<c:if test='${empty allMembers}'>
		查無會員資料<br>
			</c:if>
			<c:if test='${not empty allMembers}'>
				<c:forEach var='member' varStatus='vs' items='${allMembers}'>
					<c:if test='${vs.first }'>
						<c:out value="<table class='SM_table'>" escapeXml='false' />
						<c:out value="<tr>
						<th class='SM_th'>帳號</th>
						<th class='SM_th'>密碼</th>
						<th class='SM_th'>姓名</th>
						<th class='SM_th'>性別</th>
				        <th class='SM_th'>生日</th>
				        <th class='SM_th'>手機</th>
				        <th class='SM_th'>信箱</th>
				        <th class='SM_th'>地址</th>
				        <th class='SM_th'>身分證字號</th>
				        <th class='SM_th'>剩餘回饋金</th>
				        <th class='SM_th'>大頭貼</th>
				        <th class='SM_th'>編輯</th>
				        <th class='SM_th'>權限</th>
				        </tr>"
						escapeXml='false'/>
					</c:if>

					<tr class="SM_tr">
						<td style='display:none'>${member.memId}</td>
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
						<td><img width='100' height='150' src=''/></td>
						<td><button type='button' class="UM" >修改</button><a
							href='deleteMember?id=${member.memId}' onclick="javascript:return del()"><button type='button'>刪除</button></a></td>
					    <td>
					  <label class="switch">
  	                     <input type="checkbox">
                         <span class="slider" checkType="${member.memCheckAu}"></span>
                         </label>
					  </td>
					</tr>
					<c:if test='${vs.last }'>
						<c:out value="</table>" escapeXml='false' />
					</c:if>
				</c:forEach>
			</c:if>
			<a class="link" href="${pageContext.request.contextPath }/index">回到會員資料維護</a>
	</div>
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