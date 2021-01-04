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
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
    <style type="text/css">
    .source_div{
    	float:left;
    	font-size:30px;
    	width:fit-content;
    }
    .source_div p{
    	margin-bottom:10px;
    }
    .source_div_top{
    	border:3px solid black;
    	border-radius:15px;
    	background-image:url(${pageContext.request.contextPath}/images/深藍紙背景.jpg);
    	color:beige;
    	width:100%;
    }

    </style>
</head>

<body class="header_body">
	<header>
	</header>
	<div class="source_div_top">
	<h1>主題發想</h1>
	<p style="font-size:30px;">目前國際疫情持續延燒，且有越演越烈的趨勢，因此不論是強制隔離或自主居家檢疫，人們待在家中與家人相處的時間大幅增加，但3C產品往往佔據目光，造成"明明相處時間增加，但彼此感情未見增長，衝突反而變多"的情況出現，此時桌遊即為多人互動的好選擇，既可以遠離螢幕，又可充分與他人互動，故本組以桌遊作為題目進行專題發想，目標建立一個桌遊相關的網站。</p>
	</div>

	<div>
		<div class="source_div">
			<p class="source_div_top">組長&emsp;夏浩庭</p>
			<span>負責分類檢索功能，使用者針對自身喜好進行商品搜尋，可將商品加入追蹤或購物車，提供複數條件搜尋，可精準找出目標商品。後台提供商品CRUD功能、瀏覽數排名、批次對商品進行刪除或修改，讓管理者在控制商品資料庫更為靈活。</span>	
		</div>

		<div class="source_div">
			<p class="source_div_top">技術長&emsp;黃凱廷</p>
			<span>負責購物車功能，設計符合使用者邏輯的購物車畫面，依據使用者喜好生成六筆使用者可能感興趣之產品於購物調整畫面、離線加入購物車並於登入後新增至購物選單列表。</span>	
		</div>
		
		<div class="source_div">
			<p class="source_div_top">組員&emsp;劉哲文</p>
			<span>負責會員中心，個人會員中心資訊修改、網站活動歷史軌跡查詢，管理員完整會員數據分析、權限管理，配合第三方登入、嚴謹的帳號驗證，使前後台兩側使用者都能得到簡潔和安全的體驗。</span>	
		</div>
		
		<div class="source_div">
			<p class="source_div_top">組員&emsp;黃冠華</p>
			<span>負責討論區，提供會員暢所欲言的空間，各類型的桌遊有獨立討論區，可讓會員對不同類型桌遊進行留言討論。</span>	
		</div>
		
		<div class="source_div">
			<p class="source_div_top">組員&emsp;王泓智</p>
			<span>負責最新消息，提供包含課程、新聞、開箱文、新品上架的消息，供使用者在首頁即可點選感興趣的資訊。後台對首頁顯示資訊進行調整，在舉辦活動或新產品上市時，將第一手資訊提供給使用者。</span>	
		</div>

		
	</div>
	<footer class="footer_body">
	</footer>
</body>

</html>