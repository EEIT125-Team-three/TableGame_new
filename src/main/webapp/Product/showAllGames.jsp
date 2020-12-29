<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>123</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/manager_page.css">
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
	<style type="text/css">
	 .table_st{
	 	font-size:20px;
	 	border:2px solid blue;
	 	text-align:center;
	 }
	 .td_st{
	 	width:150px;
	 	border-top:2px solid blue;
	
	 }
 	</style>
	 <script type="text/javascript">
	
		function confirmDelete(productId) {
			var result = confirm("確定刪除此筆資料(編號:" + productId + ")?");
			if (result) {
				document.forms[0].finalDecision.value = "Delete";
				return true;
			}
			return false;
		}
	</script>
</head>

<body class="header_body">
	<header>
	</header>
    
<div>
<h1>遊戲列表</h1>

<c:if test='${empty allGames}'>
		查無遊戲資料<br>
	</c:if>
	<c:if test='${not empty allGames}'>
		<c:forEach var='game' varStatus='vs' items='${allGames}'>
			<c:if test ='${vs.first }'>
				<c:out value="<table class='table_st'>"  escapeXml='false'/>
				<c:out value="<tr bgcolor='lightyellow'>
								<th>遊戲編號</th>
								<th>英文名稱</th>
								<th>中文名稱</th>
								<th>圖片連結</th>
								<th>遊戲作者</th>
								<th>插畫家</th>
								<th>資訊</th>
								<th>價錢</th>
								<th>瀏覽數</th>
								<th>上市日期</th>
								<th>庫存</th>
								<th>操作</th>
							</tr>"  escapeXml='false'/>			
			</c:if>
			
			<tr bgcolor='lightblue'>
				<td class='td_st' style='width:50px'>${game.productId}</td>
				<td class='td_st'>${game.e_name}</td>
				<td class='td_st'>${game.c_name}</td>
				<td class='td_st'><img style="width:100px;height:100px" src='${game.img_url}'></td>
				<td class='td_st'>${game.g_maker}</td>
				<td class='td_st'>${game.iss}</td>
				<td class='td_st' style='width:600px'>${game.info}</td>
				<td class='td_st' style='width:50px'>${game.price}</td>
				<td class='td_st' style='width:70px'>${game.viewCount}</td>
				<td class='td_st' style='width:100px'>${game.date}</td>
				<td class='td_st' style='width:50px'>${game.storage}</td>
				<td class='td_st'>
				<a href='DeleteGame?productId=${game.productId}'><button type='button' onclick="return confirmDelete('${game.productId}');">刪除</button></a>
				<a href='UpdateGame?productId=${game.productId}'><button type='button'>修改</button></a>
				</td>
			</tr>
			<c:if test ='${vs.last }'>
				<c:out value="</table>" escapeXml='false'/>
			</c:if>
		</c:forEach>
	</c:if>
</div>
<a href='../product'><span style="font-size:20px">回到遊戲管理</span></a>

</body>
</html>