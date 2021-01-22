<%@page import="java.io.Console"%>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>享玩 桌遊</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ScrollBar.css">
	<link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="css/header_style.css">
    <style>
	.search_input{
		width:150px;
		height:40px;
		border-radius:20px;
	}
	.search_bt_input{
		width:80px;
		height:45px;
		border-radius:20px;
		background-color:white;
		float:left;
	}
    </style>
    <script>
    	function submit(){
    		var keyword = document.getElementById("keyword").value;
    		var special = /[~!@#$%^&*ˇˋ˙ˊ()+=/\-]/;
    		if(special.test(keyword)|| keyword.indexOf("\'")>=0 || keyword.indexOf('\"')>=0){
    				Swal.fire(
						  '發生錯誤',
						  '不可以輸入符號',
						  'error'
						)    				 				
    		}else{
	    		$("form").eq(1).submit();    			
    		}
    	}
    </script>
</head>

<body class='header_body'>
	<header>
	</header>
	<div style="text-align:center;margin-left:75px;">
		<form action="${pageContext.request.contextPath}/Product/KeyWordSearch" style="margin-bottom:10px;float:left;">
			<input class="search_input" type="text" name="keyword" id="keyword" placeholder="桌遊名稱關鍵字">
		</form>
			<button class="search_bt_input" onclick="submit();"><i class="fa fa-search fa-2x"></i></button>
	</div>
	<div style="vw:95%;margin-left:75px;clear:left;">
    <div style="background-image: url(images/frontPage1.jpg);background-repeat: no-repeat;background-size:95%;">

        <fieldset style="height: 680px;border:none;">
            <fieldset style="width:fit-content;height:fit-content;margin-top: 110px;margin-left: 130px;border:none;background-color:white;">
<!--                 <iframe style="float:left;margin-right: 20px;" width="700" height="400" src="https://www.youtube.com/embed/1OWlZXO-GHA?rel=0&hd=1&autoplay=1&loop=1&playlist=1OWlZXO-GHA" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe> -->
                <iframe width="1400" height="400" src="https://www.youtube.com/embed/b1vA1R4_dV0?rel=0hd=1&autoplay=1&loop=1&playlist=b1vA1R4_dV0&title=0" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen ></iframe>
            </fieldset>

        </fieldset>
    </div>
    </div>
    <footer class="footer_body">
    </footer>
</body>

</html>