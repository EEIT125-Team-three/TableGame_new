<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../css/header_style.css">
    <link rel="stylesheet" href="../css/manager_page.css">
    <style>

		
    </style>
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
                <span class="header_span2">管理員   歡迎</span>
            </div>
        </nav>

    </header>
    
   <div id="manager_div">
	<fieldset style="display:none;border:none;text-align:center;font-size:x-large;line-height:1.5;font-weight:bold" id ="search_fieldset">
		<legend>搜尋表單</legend>
		<form action='SearchGameServlet' method='POST'>
		遊戲編號 :<input type='text' name='productId'>
		<input type='submit' value='送出'>
		<input type='reset' value='清除'>
		</form>
		<a href='SearchAllGameServlet' ><button type='button'>遊戲資料列表</button></a><br>
	</fieldset>

	<fieldset style="display:none;border:none;text-align:center;font-size:x-large;line-height:1.5;font-weight:bold" id ="creat_fieldset">
        <legend>新增遊戲至DB</legend>
        <form  action='InsertGameServlet'  method='POST'  >


英文名字:<input type='text'  name='E_name'><br>

中文名字:<input type='text'      name='C_name'><br>
圖片連結:<input type='text'      name='img_url'><br>
創作者:<input type='text'      name='G_make'><br>
插畫家:<input type='text'      name='iss'><br>
內容:<input type='text'      name='info'><br>
價錢:<input type='text'      name='Price'><br>
瀏覽數:<input type='text'      name='viewCount'><br>
上市日期:<input type='text'      name='date'><span style="font-size:smaller;color:gray">格式ex:yyyy-MM-dd</span><br>
庫存:<input type='text'      name='storage'><br>


<input type='submit'      name='name' value='提交' >
<input type='reset'      name='name' value='清除' ><br><br>
</form>
    </fieldset>

</div>
<div class="manager_divst">
	<img src="../images/勇氣徽章.png"
		style="height: 300px; width: 300px; margin-top: 15px;"onclick="manager_search_display()">
	
	<img src="../images/愛心徽章.png"
		style="height: 300px; width: 300px; margin-top: 15px;"onclick="manager_search_display()">
		
	<img src="../images/誠實徽章.png"
		style="height: 300px; width: 300px; margin-top: 15px;"onclick="manager_search_display()">
	<p>搜尋、刪除、修改資料庫中的遊戲</p>
</div>

<div class="manager_divst">
	<img src="../images/純真徽章.png"
		style="height: 300px; width: 300px; margin-top: 15px;"onclick="manager_creat_display()">
	<p>新增資料庫中的遊戲</p>
	
</div>

<script src="../js/Standard.js"></script>
<script>
        function checkout() {
        	alert("已登出,歡迎下次再來")
        	}
</script> 

</body>

</html>