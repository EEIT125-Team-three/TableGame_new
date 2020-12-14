<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>遊戲資料</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
 <style type="text/css">
 .table_st{
 	font-size:35px;
 	border:2px solid blue;
 }
 .td_st{
 	width:150px;
 	border-top:2px solid blue;

 }
 </style>
 <script type="text/javascript">

	function AddToShopCar(C_name) {
		alert(C_name+" 已加入購物車");
	}
	function FollowProduct(C_name) {
		alert("已追蹤 "+ C_name);
	}
</script>
</head>
<body class="header_body">
    <header>
        <div>
            <ul class="header_listst1">
                <li>  
                    <p class="header_titlest"><image src="../images/LOGO.jpg" />享玩 桌遊</p>
                </li>
                <p class="header_p1">讓因桌遊而產生的歡笑&emsp;充滿生命中的每分每秒</p>
            </ul>
        </div>
        <hgroup class="hearder_hgroup">
            <h2 class="header_h2_1">放輕心情</h2>
            <h2 class="header_h2_2">享受與親友</h2>
            <h2 class="header_h2_3">共同度過的桌遊時光</h2>
        </hgroup>
        <nav class="header_nav">
            <div>
                <a href="header"><span class="header_span1">網站起源</span></a>
                <a href="news"><span class="header_span1">最新消息</span></a>
                <a href="product"><span class="header_span1">分類檢索</span></a>
                <a href="shopCar"><span class="header_span1">購物車</span></a>
                <a href="gossip"><span class="header_span1">討論區</span></a>
                <a href="login"><span class="header_span1">會員中心</span></a>
                <a href="connect"><span class="header_span1">聯絡我們</span></a>
                <span class="header_span2"><a class="link" href="/TopicFinal3/loginPage.jsp" onclick="checkout()"><button>登出</button></a></span>
                <span class="header_span2">XXX 歡迎</span>
            </div>
        </nav>

    </header>
<div>
<h1>遊戲列表</h1>

<c:if test='${empty result}'>
		查無遊戲資料<br>
	</c:if>
	<c:if test='${not empty result}'>
		<c:forEach var='game' varStatus='vs' items='${result}'>
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
				<td class='td_st'>${game.productId}</td>
				<td class='td_st'>${game.e_name}</td>
				<td class='td_st'>${game.c_name}</td>
				<td class='td_st'>${game.img_url}</td>
				<td class='td_st'>${game.g_maker}</td>
				<td class='td_st'>${game.iss}</td>
				<td class='td_st'>${game.info}</td>
				<td class='td_st'>${game.price}</td>
				<td class='td_st'>${game.viewCount}</td>
				<td class='td_st'>${game.date}</td>
				<td class='td_st'>${game.storage}</td>
				<td class='td_st'>
				<a href='BuyGame?productId=${game.productId}'><button type='button' onclick="AddToShopCar('${game.c_name}');">購買</button></a>
				<a href='FollowGame?productId=${game.productId}'><button type='button' onclick="FollowProduct('${game.c_name}');">追蹤</button></a>
				</td>
			</tr>
			<c:if test ='${vs.last }'>
				<c:out value="</table>" escapeXml='false'/>
			</c:if>
		</c:forEach>
	</c:if>
</div>
<a href='manager_page.jsp'><span style="font-size:20px">回到遊戲管理</span></a>

</body>
</html>