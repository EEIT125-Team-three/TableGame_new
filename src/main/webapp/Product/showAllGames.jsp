<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>遊戲資料</title>
</head>
<body>
<div>
<h1>遊戲列表</h1>

<c:if test='${empty allGames}'>
		查無遊戲資料<br>
	</c:if>
	<c:if test='${not empty allGames}'>
		<c:forEach var='game' varStatus='vs' items='${allGames}'>
			<c:if test ='${vs.first }'>
				<c:out value="<table border='1'>"  escapeXml='false'/>
				<c:out value="<tr>
								<td>遊戲編號</td>
								<td>英文名稱</td>
								<td>中文名稱</td>
								<td>圖片連結</td>
								<td>遊戲作者</td>
								<td>插畫家</td>
								<td>資訊</td>
								<td>價錢</td>
								<td>瀏覽數</td>
								<td>上市日期</td>
								<td>庫存</td>
								<td></td>
							</tr>"  escapeXml='false'/>			
			</c:if>
			
			<tr>
				<td>${game.productId}</td>
				<td>${game.e_name}</td>
				<td>${game.c_name}</td>
				<td>${game.img_url}</td>
				<td>${game.g_maker}</td>
				<td>${game.iss}</td>
				<td>${game.info}</td>
				<td>${game.price}</td>
				<td>${game.viewCount}</td>
				<td>${game.date}</td>
				<td>${game.storage}</td>
				<td>
				<a href='DeleteGameServlet?productId=${game.productId}'><button type='button'>刪除</button></a>
				</td>
			</tr>
			<c:if test ='${vs.last }'>
				<c:out value="</table>" escapeXml='false'/>
			</c:if>
		</c:forEach>
	</c:if>
</div>
<a href='manager_page.jsp'>回到遊戲管理</a>

</body>
</html>