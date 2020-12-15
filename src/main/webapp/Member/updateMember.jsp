<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>會員資料修改</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="css/header_style.css">
    <link rel="stylesheet" href="css/login.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
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
                    <a href="header" class="header_a"><p class="header_titlest"><image src="images/LOGO.jpg">享玩 桌遊</p></a> 
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


<form:form class='center' method="POST" modelAttribute="mb">
  <fieldset>
        <legend class="ti">會員資料編輯</legend>
			<form:input type="hidden" path="memId"/> 
			<form:input type="hidden" path="memAccount"/>
			<input type="hidden" name="finalDecision" value="">
			<table>
			<tr><td>帳號Account:</td><td>${mb.memAccount}${param.memAccount}</td></tr>
			<tr><td>密碼Password:</td><td><form:input type="text" path="memPassword" size="30"/></td></tr>
			<tr><td>姓名Name:</td><td><form:input type="text" path="memName" size="30"/></td></tr>	
			<tr><td>性別Gender:</td><td><form:radiobutton path="memGender" value="male" checked="checked"/>男<form:radiobutton path="memGender" value="female"/>女</td></tr>	
			<tr><td>生日birthday:</td><td><form:input type="date" path="memBirthday" /></td></tr>
			<tr><td>手機Phone:</td><td><form:input type="text" path="memPhone" size="30"/></td></tr>
			<tr><td>信箱E-Mail:</td><td><form:input type="email" path="memMailaddress" size="30"/></td></tr>
			<tr><td>地址Address:</td><td><form:input type="text" path="memAddress" size="30"/></td></tr>
			<tr><td>身分證字號IdNumber:</td><td><form:input type="text" path="memIdNumber" size="30"/></td></tr>
			<tr><td>大頭貼Photo:</td><td><form:input type="file" path="memPic" size="30"/></td></tr>
			
				<tr>
					<td colspan="2" align="center"><input class="login" type="submit" value="更新"
						name='updateBtn'
						onclick="return confirmUpdate('${member.userId}');"> <input
						type="submit" class="login"  value="刪除" name='deleteBtn'
						onclick="return confirmDelete('${member.userId}');"></td>
				</tr>
			</table>
			<c:if test="${not empty requestScope.modify}">
				<c:remove var="member" scope="request" />
			</c:if>
			<img class="img1" src="images/dice.png">
			</fieldset>
		</form:form>
		
		<p />
<script type="text/javascript">
	function confirmDelete(userId) {
		var result = confirm("確定刪除此筆記錄(帳號:" + userId + ")?");
		if (result) {
			document.forms[0].finalDecision.value = "DELETE";
			return true;
		}
		return false;
	}
	function confirmUpdate(userId) {
		var result = confirm("確定送出此筆記錄(帳號:" + userId + ")?");
		if (result) {
			document.forms[0].finalDecision.value = "UPDATE";
			return true;
		}
		return false;
	}
</script>	
</body>

</html>
