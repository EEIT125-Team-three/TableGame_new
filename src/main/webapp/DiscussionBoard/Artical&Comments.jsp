<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Artical&Comments</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC&display=swap"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/brain.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/Article&Comments.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"
	integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30="
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>

</head>


<body class="header_body">
	<header> </header>
</body>
<div class="container">
	<div class="aside">
		<ul class="aside_menu">
			<br>
			<br>
			<li><a href="Post_Article.html">發表文章</a></li>
			<br>
			<br>
			<li><a href="Brain">大腦類</a></li>
			<br>
			<br>
			<li><a href="Brain">策略類</a></li>
			<br>
			<br>
			<li><a href="Brain">卡牌類</a></li>
			<br>
			<br>
			<li><a href="Brain">派對類</a></li>
			<br>
			<br>
			<li><a href="Brain">合作類</a></li>
			<br>
			<br>
			<li><a href="Brain">陣營類</a></li>
			<br>
			<br>
			<li><a href="Brain">競速類</a></li>
			<br>
			<br>
			<li><a href="Brain">兒童類</a></li>
			<br>
			<br>
			<li><a href="Brain">樂齡類</a></li>
			<br>
			<br>
		</ul>
	</div>
</div>

<div class="mainboard">
	<div class="ID+Title+Date">
		<table>
			<c:forEach var="dis" items="${listofArtical }">
				<tr>
					<th>作者</th>
					<td>${dis.memName}</td>
				</tr>
				<tr>
					<th>標題</th>
					<td>${dis.distitle}</td>
				</tr>
				<tr>
					<th>文章</th>
					<td>${dis.Artical}</td>
				</tr>
			</c:forEach>
		</table>
	</div>


	<div class="AllComments">
		<div class="buildcomments">
			<img class="memPic" src="../images/LOGO.jpg"> <span
				class="memName">會員: ${dis.memName}
				</span>
			<div class="getcomment"></div>
			<select id="controlmenu" class="controlmenu">
				<option>留言控制</option>
				<option value="update">編輯留言</option>
				<option value="delete">刪除留言</option>
				<option value="report">檢舉留言</option>
			</select>
		</div>

		<div class="givesingleComment">
			<img class="memPic" src="../images/LOGO.jpg"> <span
				class="memID">會員: ${dis.memName}</span> <span><textarea class="comment"></textarea></span>
			<span> <input type="submit" class="givecomment" value="發表留言"></span>
		</div>
	</div>

</div>

<body>
	<div id="comments-container"></div>
	<table>
	
	
	</table>
	
</body>
</body>

</html>