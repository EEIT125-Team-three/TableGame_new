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
<title>享玩 桌遊 | 我的活動</title>
<link rel="icon"
	href="${pageContext.request.contextPath}/images/favicon.ico"
	type="image/x-icon" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/Member.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/newinfo_style.css">
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>
</head>

<body class="header_body">
	<script src="${pageContext.request.contextPath}/js/InfoMenu.js"></script>
	<header> </header>
	<div class="menu"></div>
	<fieldset style="border: 0px;">
		<div class="SM_title">我的活動</div>
		<c:if test='${empty infoHistory}'>
		查無活動資料<br>
		</c:if>
		<c:if test='${not empty infoHistory}'>
			<c:forEach var='MI' varStatus='vs' items='${infoHistory}'>
				<c:if test='${vs.first }'>
					<c:out value="<table border='0'>" escapeXml='false' />
					<c:out
						value="<tr>
						<th class='SM_th'>活動區域</th>
						<th class='SM_th'>類型</th>
						<th class='SM_th'>活動形式</th>
						<th class='SM_th'>活動日期(一)</th>
				        <th class='SM_th'>開始時間(一)</th>
				        <th class='SM_th'>結束時間(一)</th>
				        <th class='SM_th'>活動日期(二)</th>
				        <th class='SM_th'>開始時間(二)</th>
				        <th class='SM_th'>結束時間(二)</th>
				        <th class='SM_th'>活動天數</th>
				        <th class='SM_th'>活動地點</th>				  
				        <th class='SM_th'>活動地址</th>
				        <th class='SM_th'>活動費用</th>
				        <th class='SM_th'>繳費情形</th>
				        <th class='SM_th'>取消/繳費</th>
				        </tr>"
						escapeXml='false' />
				</c:if>
				<tr class="SM_tr">
					<td style='display: none'>${MI.member}</td>
					<td style='display: none'>${MI.miId}</td>
					<td>${MI.info.actArea}</td>
					<td>${MI.info.actType}</td>
					<td>${MI.info.activity}</td>
					<td>${MI.info.actDate1}</td>
					<td>${MI.info.actStrTime1}</td>
					<td>${MI.info.actEndTime1}</td>
					<td>${MI.info.actDate2}</td>
					<td>${MI.info.actStrTime2}</td>
					<td>${MI.info.actEndTime2}</td>
					<td>${MI.info.actDay}</td>
					<td>${MI.info.actLocation}</td>
					<td>${MI.info.actAddress}</td>
					<td>${MI.info.actCost}</td>
					<td class='pay'>${MI.payedCheck}</td>
					<td><a href='DeletSignUp?miId=${MI.miId}'><button
								type='button' class='cancal' id='cancal'>取消</button></a>
						<button type='button'>繳費</button></td>

				</tr>
				<c:if test='${vs.last}'>
					<c:out value="</table>" escapeXml='false' />
				</c:if>
			</c:forEach>
		</c:if>
		<form id="goForm"></form>
	</fieldset>
	<script>
		$(document).ready(function(){
			$(".pay").each(function() {
				console.log($(this).next())
				if ($(this).html() == "已繳費") {
					$(this).next().children('button').attr("disabled","disabled")
					$(this).next().children().eq(0).children('button').attr("disabled","disabled")
				}
			})
		})

		$(function() {
			$("tbody").children("tr").each(function() {
				console.log($(this).children("td").eq(16).children("button").eq(0))
				$(this).children("td").eq(16).children("button").eq(0).click(function() {
							swal.fire({
								title:"繳費確認",
								text:"即將進入付款程序，請進行確認",
								icon:"warning",
								showCancelButton: true,
								confirmButtonColor: '#3085d6',
								cancelButtonColor: '#d33',
								cancelButtonText: '我再想想',
								confirmButtonText: '確認繳費'
							}).then((result) => {
								if (result.isConfirmed){
									Swal.fire(
								      '報名成功',
								      '跳轉繳費頁面',
								      'success'
									)
		 							$("#goForm").attr("method","POST").attr("action","paySignUp?MImergeId="
		 							+ $(this).parents("tr").children("td").eq(1).html()).submit()
								}
							})
						})
					})
				})
	</script>
</body>
	<footer class="footer_body">
</footer>
</html>