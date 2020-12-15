<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Gossip-Brain</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="../css/header_style.css">
    <link rel="stylesheet" href="../css/brain.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"
        integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30=" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js"
        integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
    <style>

    </style>
</head>

<body class="header_body">
    <script src="js/header_js.js"></script>
    <script>
        var userId = 0
    </script>
    <header>
        <div>
            <ul class="header_listst1">
                <li>
                    <a href="header" class="header_a">
                        <p class="header_titlest">
                            <image src="../images/LOGO.jpg">享玩 桌遊
                        </p>
                    </a>
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
                <span class="header_span1"><a href="header" class="header_a">網站起源</a></span>
                <span class="header_span1"><a href="news" class="header_a">最新消息</a></span>
                <span class="header_span1"><a href="product" class="header_a">分類檢索</a></span>
                <span class="header_span1"><a href="shopCar" class="header_a">購物車</a></span>
                <span class="header_span1"><a href="gossip" class="header_a">討論區</a></span>
                <span class="header_span1"><a href="login" class="header_a">會員中心</a></span>
                <span class="header_span1"><a href="connect" class="header_a">聯絡我們</a></span>
                <span class="header_span2"><button>登出</button></span>
                <span class="header_span2">XXX 歡迎</span>
            </div>
        </nav>
    </header>


    <div class="container">
        <div class="aside">

            <ul class="aside_menu">
                <br><br>
                <li><a href="Post_Article.jsp">發表文章</a></li><br><br>
                <li><a href="Brain">大腦類</a></li><br><br>
                <li> <a href="Brain">策略類</a></li><br><br>
                <li> <a href="Brain">卡牌類</a></li><br><br>
                <li> <a href="Brain">派對類</a></li><br><br>
                <li> <a href="Brain">合作類</a></li><br><br>
                <li> <a href="Brain">陣營類</a></li><br><br>
                <li> <a href="Brain">競速類</a></li><br><br>
                <li> <a href="Brain">兒童類</a></li><br><br>
                <li> <a href="Brain">樂齡類</a></li><br><br>
            </ul>
        </div>

</body>

</html>