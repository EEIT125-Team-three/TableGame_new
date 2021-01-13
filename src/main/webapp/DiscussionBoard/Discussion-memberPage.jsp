<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>

<!DOCTYPE html>
<html lang="zh-Hant-TW">

<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Gossip-Brain</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/brain.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"
	integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30="
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<fmt:formatDate value="${dis.disDate}" pattern="yyyy MM dd HH:mm:ss"/>
<style>
</style>
</head>

<body class="header_body">
	<header> </header>

	<div class="container">
		<div class="aside">

			<ul class="aside_menu">

				<li><a class='discuss_a' href="${pageContext.request.contextPath }/DiscussionBoard/ToPostArticle?cata2=${cata2Keys}">發表文章</a></li>
				<li><a class='discuss_a' href="${pageContext.request.contextPath }/DiscussionBoard/SearchCata2?cata2=1">自然</a></li>
				<li><a class='discuss_a' href="${pageContext.request.contextPath }/DiscussionBoard/SearchCata2?cata2=2">社會</a></li>
				<li><a class='discuss_a' href="${pageContext.request.contextPath }/DiscussionBoard/SearchCata2?cata2=3">科技</a></li>
				<li><a class='discuss_a' href="${pageContext.request.contextPath }/DiscussionBoard/SearchCata2?cata2=4">健體</a></li>
				<li><a class='discuss_a' href="${pageContext.request.contextPath }/DiscussionBoard/SearchCata2?cata2=5">綜合</a></li>
				<li><a class='discuss_a' href="${pageContext.request.contextPath }/DiscussionBoard/SearchCata2?cata2=6">語文</a></li>
				<li><a class='discuss_a' href="${pageContext.request.contextPath }/DiscussionBoard/SearchCata2?cata2=7">數學</a></li>
				<li><a class='discuss_a' href="${pageContext.request.contextPath }/DiscussionBoard/SearchCata2?cata2=8">藝術</a></li>
				
			</ul>
		</div>
		</div>
		
	<div class="ArticalList">
		<form method="POST"
			action="${pageContext.request.contextPath }/ArticalList">
			<h1>${cata2}</h1>
		<h1>所有文章列表</h1>
		<table style="width:1000px;font-size:30px;border:2px solid black;text-align:center;">
			<tr style="background-color:#FFA042;">
				<th>編號</th>
				<th>標題</th>
				<th>時間</th>
				<th>編輯</th>
				<th>刪除</th>
			</tr>
			<c:forEach var="dis" items="${artList}">
				<tr style="background-color:rgba(226, 226, 219, 0.794);">
					<td>${dis.discussionBoardID}</td>
					<td>
						<a href='#'>
							${dis.distitle}
						</a>
					</td>
					<td>${dis.disDate}</td>
					<td><a
						href="${pageContext.request.contextPath }/DiscussionBoard/editArtical?DiscussionBoardID=${dis.discussionBoardID}">編輯</a></td>
					<td><a
						href="${pageContext.request.contextPath }/DiscussionBoard/deleteArtical?DiscussionBoardID=${dis.discussionBoardID}" onclick="if (!(confirm('確定要刪除此文章嗎?'))) return false">刪除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		</form>
		</div>
		<footer class="footer_body">
</footer>
</body>

</html>