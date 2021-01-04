<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach var='game' varStatus='vs' items='${allGames}'>
		
			<c:if test ='${vs.first }'>
				<c:out value="<table class='table_st'>" escapeXml='false'/>	
			</c:if>
			<c:if test='${vs.count % 5 == 1 }'>
			<c:out value="<tr>" escapeXml='false'/>
			</c:if>
			<td class='td_st'>
				<a href='${pageContext.request.contextPath}/Product/SearchGameByProductId?ProductId=${game.productId}'>
					<span>${game.c_name}<br>${game.e_name}<br>$ ${game.price}</span>
					<img src='${game.img_url}'>
				</a>
			</td>
			<c:if test='${vs.count % 5 == 0 }'>
			<c:out value="</tr>" escapeXml='false'/>
			</c:if>
			<c:if test ='${vs.last }'>
				<c:out value="</table>" escapeXml='false'/>
			</c:if>
		</c:forEach>
		<div style="text-align:center;" id="${condition}">
			<c:set var='page' value='${fn:length(allGamesPage)/15}'/>
			<c:if test='${fn:length(allGamesPage)%15 !=0 }'>
			<c:set var='page' value='${fn:length(allGamesPage)/15+1}'/>
			</c:if>
			<c:forEach var='page' begin='1' end='${page}' varStatus='loop'>
				<span style="font-size:30px;margin-right:20px;"><a href="#">${page}</a></span>				
			</c:forEach>
		</div>		
<%-- href='${pageContext.request.contextPath}/Product/OrderByCondition?Page=${page}&condition=${condition}' --%>
<!-- <footer class="footer_body"> -->
<!-- </footer> -->
</body>
<script>
	$("#${condition}").children("span").each(function(){
		let page = 1 + parseInt($(this).index());
		$(this).children("a").click(function(){
			console.log("/TestVersion/Product/OrderByCondition?condition=${condition}" + "&page = " + page)
			$("#showarea").load("/TestVersion/Product/OrderByCondition?condition=${condition}" + "&page=" + page)
		})
	})
</script>
</html>