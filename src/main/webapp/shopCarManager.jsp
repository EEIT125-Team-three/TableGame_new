<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head> 
	<title>享玩 桌遊 | 管理員 | 購物車</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shopCarManager.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ScrollBar.css">
    <script src="${pageContext.request.contextPath}/js/shopCarManager.js"></script>
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
</head>
<body class="header_body">
	<header>
    </header>
    <article>
    	<div class="showCanvas">顯示圖表統計⬇</div>
	    	<div class="shopCarManager_Div1"  style="display:none">
				<div class="shopCarManager_selectByDate">
					<canvas id="incomeByDate" width="2500" height="1500"></canvas>
					<div style="text-align:center; font-size:20px">
						<span style="font-size:24px;">年份 : </span>
						<select id="byYear" style="font-size:20px">
						</select>
						<span style="font-size:24px;">特定月份日收入 : </span>
						<select id="byMonth" style="font-size:20px">
							<option>不指定</option>
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
							<option>6</option>
							<option>7</option>
							<option>8</option>
							<option>9</option>
							<option>10</option>
							<option>11</option>
							<option>12</option>
						</select>
					</div>
				</div>
				<div class="shopCarManager_selectByArea">
					<canvas id="incomeByArea" width="2500" height="1500"></canvas>
					<div style="text-align:center; font-size:20px">
						<span style="font-size:24px;">選擇地區 : </span>
						<select style="font-size:20px;"	id="byRegion">
							<option value="全台">全台</option>						
						</select>
					</div>
				</div>
	    		<div style="width:400px; height:550px;"></div>
				<div class="outputData">
				</div>
	    	</div>
    	
   		<div class="showAllOrderData">隱藏訂單資訊⬆</div>
    	<div class="allOrderData">
	    	<div class="shopCarManager_Div2">
		   		<select class="dateRage">
		    		<option value=null>所有時間</option>
		    		<option value="1">近一個月</option>
		    		<option value="3">近一季度</option>
		    		<option value="6">近半年</option>
		    		<option value="12">近一年</option>
		    	</select><br>
		    	<div>
			    	<label style="font-size:20px;">訂單編號 : </label><input style="height:30px;border-radius:5px;" id="orderId" placeholder="輸入編號">
			    	<button style="background-color:white;border-radius:5px;"><i class="fa fa-search fa-2x"></i></button>
		    	</div>
		    	<div class="shopCarManager_Div2_scroll">
		    		<table class="shopCarManager_Table1" id='allData'>
		    		</table>
	    		</div>
	    		<button id="outputExcel">123456</button>
	    	</div>
	    	<div class="shopCarManager_Div3">
	    		<table class="shopCarManager_Table1">
	    		</table>
	    	</div>
	    </div>
    <div class="backOver">
    </div>
    <div class="centerOver">
    </div>
    </article>
	<footer class="footer_body">
	</footer>
</body>

</html>