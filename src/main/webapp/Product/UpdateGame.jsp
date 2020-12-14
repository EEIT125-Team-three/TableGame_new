<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href='${pageContext.request.contextPath}/css/header_style.css'>
<style type="text/css">
 .table_st{
 	font-size:35px;
 	border:2px solid blue;
 	
 }
 .td_st{
 	width:150px;
 }
 input{
 	width:450px;
 }
 </style>
<script type="text/javascript">

	function confirmUpdate(productId) {
		var result = confirm("確定編輯此筆資料(編號:" + productId + ")?");
		if (result) {
			document.forms[0].finalDecision.value = "UPDATE";
			return true;
		}
		return false;
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
                <span class="header_span2"><a class="link" href="../Member/loginPage.jsp" onclick="checkout()"><button>登出</button></a></span>
                <span class="header_span2">XXX 歡迎</span>
            </div>
        </nav>

    </header>

<form:form method='POST' modelAttribute='gb'>
	<table class='table_st'>
		<tr>
			<th>項目</th>
			<th width='500px'>內容</th>
		</tr>
		<tr>
			<td>遊戲編號 :</td>
			<td><input type="text" name="productId" value="${param.productId}" ></td>
		</tr>
		<tr>
			<td>英文名稱 :</td>
			<td><input type="text" name="E_name" value="${gb.e_name}${param.e_name}" ></td>
		</tr>
		<tr>
			<td>中文名稱 :</td>
			<td><input type="text" name="C_name" value="${gb.c_name}${param.c_name}" ></td>
		</tr>
		<tr>
			<td>圖片連結 :</td>
			<td><input type="text" name="img_url" value="${gb.img_url}${param.img_url}" ></td>
		</tr>
		<tr>
			<td>作者 :</td>
			<td><input type="text" name="G_maker" value="${gb.g_maker}${param.G_make}" ></td>
		</tr>
		<tr>
			<td>插畫家 :</td>
			<td><input type="text" name="iss" value="${gb.iss}${param.iss}" ></td>
		</tr>
		<tr>
			<td>資訊 :</td>
			<td><input type="text" name="info" value="${gb.info}${param.info}" ></td>
		</tr>
		<tr>
			<td>價錢 :</td>
			<td><input type="text" name="Price" value="${gb.price}${param.Price}" ></td>
		</tr>
		<tr>
			<td>瀏覽數 :</td>
			<td><input type="text" name="viewCount" value="${gb.viewCount}${param.viewCount}" ></td>
		</tr>
		<tr>
			<td>上市日期 :</td>
			<td><input type="text" name="date" value="${gb.date}${param.date}" ></td>
		</tr>
		<tr>
			<td>庫存 :</td>
			<td><input type="text" name="storage" value="${gb.storage}${param.storage}" ></td>
		</tr>

		<tr>
			<td colspan="2" align="center">
			<input width="50px" type="submit" value="更新" onclick="return confirmUpdate('${gb.productId}');"><br>
			<input width="50px" type="reset" value="清空資料" onclick="return confirmUpdate('${gb.productId}');">
		</td>
		</tr>
	</table>
	</form:form>
	<a href='manager_page.jsp'><span style="font-size:20px">回到遊戲管理</span></a>

</body>
</html>