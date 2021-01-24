<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>享玩 桌遊 | 網站起源</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
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
    	margin-left:10px;
    	margin-right:10px;
    }
    .source_div_top{
    	border:3px solid black;
    	border-radius:15px;
    	background-image:url(${pageContext.request.contextPath}/images/深藍紙背景.jpg);
    	color:beige;
    	width:fit-content;
    	margin-left:10px;
    	margin-right:10px;
    }
    .p_st{
    	font-weight:bold;
    }
    .p_div_st{
    	background-color:rgba(226, 226, 219, 0.794);
    	padding:5px;
    	border-radius:15px;
    	margin-left:10px;
    	margin-right:10px;
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
			<p class="source_div_top" style="width:250px;">組長&emsp;夏浩庭</p>
			<div class="p_div_st">
				<p class="p_st">分類檢索、討論區</p>
				<p>分類檢索 : 使用者針對自身喜好進行商品搜尋，可將商品加入追蹤或購物車，提供複數條件搜尋，可精準找出目標商品。後台提供商品CRUD功能、瀏覽數排名、批次對商品進行刪除或修改，讓管理者在控制商品資料庫更為靈活。</p>	
				<p>討論區 : 各類型的桌遊有獨立討論區，管理員具有所有留言的刪除以及修改權限，而會員可對本身的留言進行編輯及修改的操作，此外設計會員可對其他會員之留言發表意見的巢狀結構。</p>	
			</div>
		</div>

		<div class="source_div">
			<p class="source_div_top" style="width:250px;">技術長&emsp;黃凱廷</p>
			<div class="p_div_st">
				<p class="p_st">購物車、線上客服</p>
				<p>設計符合使用者邏輯的購物車畫面，依據使用者喜好生成六筆使用者可能感興趣之產品於購物調整畫面、離線加入購物車並於登入後新增至購物選單列表。同時在結帳時可選擇離住家最近的超商進行取貨，亦可直接透過線上課服與管理員聯繫進行訂單修改。</p>		
			</div>
		</div>
		
		<div class="source_div">
			<p class="source_div_top" style="width:250px;">組員&emsp;劉哲文</p>
			<div class="p_div_st">
				<p class="p_st">會員中心</p>
				<p>個人會員中心資訊修改、網站活動歷史軌跡查詢，管理員完整會員數據分析、權限管理，配合第三方登入、嚴謹的帳號驗證，使前後台兩側使用者都能得到簡潔和安全的體驗。</p>	
			</div>
		</div>
				
		<div class="source_div">
			<p class="source_div_top" style="width:250px;">組員&emsp;王泓智</p>
			<div class="p_div_st">
				<p class="p_st">最新消息</p>
				<p>提供包含課程、活動等消息，供使用者進行活動的報名以及繳費，亦可根據地區搜尋該區域的活動。後台可舉辦新活動或是課程供會員選擇。</p>	
			</div>
		</div>

		
	</div>
	<footer class="footer_body">
	</footer>
</body>

</html>