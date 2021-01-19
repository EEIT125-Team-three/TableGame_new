<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>會員分析</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Member.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ScrollBar.css">
	<link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
</head>

<body class="header_body">
	<div class="SER_title">會員分析</div>
	<canvas id="gender" width="300" height="100"></canvas>
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