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
<title>文章清單</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Member.css">
</head>

<body class="header_body">
	<header> </header>
	<form method="post" style="height:700px;overflow:scroll" >				
			<div class="SM_title">文章查詢歷史清單</div>
			<c:if test='${empty disHistory}'>
		<h1>查無文章歷史資料</h1><br>
			</c:if>
			<c:if test='${not empty disHistory}'>
			<br>
				<c:set var="place" value="0"></c:set>
				<c:forEach var='Dis' varStatus='vs' items='${disHistory}'>
					<c:if test='${vs.first }'>
						<c:out value="<table class='SM_table'>" escapeXml='false' />
						<c:out value="<tr>
						<th class='SM_th'>文章標題</th>
						<th class='SM_th'>文章內容</th>
						<th class='SM_th'>文章發表時間</th>
 						<th class='SM_th'>文章回覆數</th>
				        </tr>"
						escapeXml='false'/>
					</c:if>
					<tr class="SM_tr">
						<td style='display:none'>${Dis.member}</td>
						<td>
							<a style='text-decoration:none;' href='${pageContext.request.contextPath }/DiscussionBoard/SearchArticalbyDisID?DiscussionBoardID=${Dis.discussionBoardID}'>
							${Dis.distitle}
							</a>
						</td>
						<td>${Dis.disArtical}</td>
						<td>${Dis.disDate}</td>
						<td>${retextNum[place]}</td>
					</tr>
					<c:set var="place" value="${place+1}"></c:set>
					<c:if test='${vs.last}'>
						<c:out value="</table>" escapeXml='false' />
					</c:if>
				</c:forEach>
			</c:if>
	</form>
</body>
</html>