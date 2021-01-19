<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>會員管理</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Member.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.23/datatables.min.css"/>
	<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.23/datatables.min.js"></script>
</head>

<body class="header_body">
<script src="${pageContext.request.contextPath}/js/showMember.js"></script>
	<header>
	</header>
    <fieldset class="MC_fieldset_left">
        <legend class="MC_title">會員管理</legend>
        <table id="MCtable" cellspacing="10" cellpadding="7" width="100%">
				<tr><td class="MC_td" id="showMembers">會員清單檢視</td></tr>
				<tr><td class="MC_td" id="searchMembers">查詢會員資料</td></tr>							   
        </table>
        <br>
        <img class="img1" src="images/dice.png">
    </fieldset>       
	<fieldset class="MC_fieldset_right">
	<div class="SER_title">會員分析</div>
	<canvas id="gender" width="300" height="100"></canvas>
	</fieldset>
	<script>
	var ctx = document.getElementById('gender');
	var myChart = new Chart(ctx, {
	  type: 'pie', //圖表類型
	  data: {	  
	    labels: ${mlist["genderName"]}, //標題
	    datasets: [{
	      label: '# test', //標籤
	      data: ${mlist["genderCount"]}, //資料
	      //圖表背景色
	      backgroundColor: [
	        'rgba(255, 99, 132, 0.2)',
	        'rgba(54, 162, 235, 0.2)'	       
	      ],
	      //圖表外框線色
	      borderColor: [
	        'rgba(255, 99, 132, 1)',
	        'rgba(54, 162, 235, 1)'	        
	      ],
	      //外框線寬度
	      borderWidth: 1
	    }]
	  },
// 	  options: {
// 	    scales: {
// 	      yAxes: [{
// 	        ticks: {
// 	          beginAtZero: true,
// 	          responsive: true //符合響應式
// 	        }
// 	      }]
// 	    }
// 	  }
	});
	</script>	
</body>
</html>