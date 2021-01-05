<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>享玩 桌遊 | 分類檢索</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Standard.css">
    <script src="${pageContext.request.contextPath}/js/SearchList.js"></script>
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
    <script src="${pageContext.request.contextPath}/js/Standard.js"></script>
	<script>
        function checkout() {
        	alert("已登出,歡迎下次再來")
        	}
	</script>
    <style>

	 .table_st{
	 	font-size:35px;

	 }
	 .td_st{
	 	text-align:center;
	 	padding:10px;
	 	width:270px;
	 	height:270px;
	 	transition:background-color .7s,border-radius .7s;
	 }
 	 .td_st:hover{ 
	 	 background-color:	#007979;
	 	 border-radius:20px; 
 	 }
 	 .td_st a{
 	 	 text-decoration:none;
 	 }

 	 .td_st span{
 	 	display:none;
 	 }
 	 .td_st:hover span{ 
		display:block;
		color:#FFD1A4;

 	 }
 	 .td_st img{
 	 	border:10px solid #642100;
 	 	float:left;
	 	width:270px;
	 	height:270px;
	 	display:block;
	 	padding:2px;
 	 }
 	 .td_st:hover img{
  	 	display: none;
 	 }


    </style>
</head>

<body class="header_body">
	<header>
	</header>

	<div class="standard_nav"
	style="width: 200px; height: fit-content; float: left;background-image: url(${pageContext.request.contextPath}/images/墨綠色背景.jpg)">
	</div>

	<div style='font-size:20px;font-weight:bold'>
	<span style='margin-left:30px;'>變更排序方式 : </span>
		<select>
			<option id='condition'></option>
			<option id='condition' value='price' onchange='orderby(this.value)'>依產品價錢</option>
			<option id='condition' value='date' onchange='orderby(this.value)'>依上市日期</option>
			<option id='condition' value='ViewCount' onchange='orderby(this.value)'>依瀏覽數</option>
		</select>
	</div>

<div id='showarea' style="width:1500px; height:fit-content;float:left">
		<c:forEach var='game' varStatus='vs' items='${allGames}'>
		
			<c:if test ='${vs.first }'>
				<c:out value="<table class='table_st'>" escapeXml='false'/>	
			</c:if>
			<c:if test='${vs.count % 5 == 1 }'>
			<c:out value="<tr>" escapeXml='false'/>
			</c:if>
			<td class='td_st'>
<%-- 				<a href='${pageContext.request.contextPath}/Product/AddMemberHistory?productId=${game.productId}'></a>	 --%>
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
		<div style="text-align:center;">
			<c:set var='page' value='${fn:length(allGamesPage)/15}'/>
			<c:if test='${fn:length(allGamesPage)%15 !=0 }'>
			<c:set var='page' value='${fn:length(allGamesPage)/15+1}'/>
			</c:if>
			<c:forEach var='page' begin='1' end='${page}' varStatus='loop'>
				<span style="font-size:30px;margin-right:20px;"><a href='${pageContext.request.contextPath}/Product/SearchGameByPage?Page=${page}'>${page}</a></span>				
			</c:forEach>
		</div>
					
</div>

<script type="text/javascript">
var origin = "SearchGameByPage";
$('select').change(function(){
	var condition = $(this).val()
	console.log($(this).val())
	$("#showarea").load(page + "/Product/OrderByCondition?condition=" + condition)

})
</script>	

<footer class="footer_body">
</footer>
</body>

</html>