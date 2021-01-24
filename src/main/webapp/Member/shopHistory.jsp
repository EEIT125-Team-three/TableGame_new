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
<title>訂單查詢</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Member.css">
</head>

<body class="header_body">
	<header> </header>
	<div style="height:700px ;overflow:scroll" >
			<div class="SM_title">訂單歷史</div>				
			<c:if test='${empty TableGameOrder}'>
		<h1>查無訂單資料</h1><br>
			</c:if>
			<c:if test='${not empty TableGameOrder}'>
			<br>
				<c:forEach var='SH' varStatus='vs' items='${TableGameOrder}'>
					<c:if test='${vs.first }'>
						<c:out value="<table class='SM_table'>" escapeXml='false' />
						<c:out value="<tr>
						<th class='SM_th'>訂單編號</th>
						<th class='SM_th'>訂單時間</th>
						<th class='SM_th'>收件人</th>
						<th class='SM_th'>收件地址</th>
				        <th class='SM_th'>電話</th>
				        <th class='SM_th'>總金額</th>
				        <th class='SM_th'>訂單細節</th>
				        </tr>"
						escapeXml='false'/>
					</c:if>
					<tr class="SM_tr">
<%-- 						<td style='display:none'>${SH.memberId.memId}</td> --%>
						<td>${SH.tableGameOrderId}</td>
						<td>${allTableGameOrderTime[vs.index]}</td>
						<td>${SH.sentToWho}</td>
						<td>${address[vs.index]}</td>
						<td>${SH.sentToPhone}</td>
						<td>${SH.totalMoney}</td>
						<td><button class="shopDetails">訂單細節</button></td>						
					</tr>
					<c:if test='${vs.last}'>
						<c:out value="</table>" escapeXml='false' />
					</c:if>
				</c:forEach>
			</c:if>		
	</div>
	<div class="backOver"></div>
	<div class="centerOver"></div>
</body>
</html>