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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ScrollBar.css">
	<link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
</head>

<body class="header_body">
	<div class="SER_title">會員分析</div>
	<div class="pie"><canvas id="gender"></canvas></div>
	<div class="pie"><canvas id="region"></canvas></div>
	<div class="line"><canvas id="resTime"></canvas></div>
	<script>
	var ctx = document.getElementById('gender');
	var myChart = new Chart(ctx, {
	  type: 'pie', //圖表類型
	  data: {	  
	    labels: ${mlist["genderName"]} ,  
	    	datasets: [{
	      label: '# test', //標籤
	      data: ${mlist["genderCount"]}, //資料
	      //圖表背景色
	      backgroundColor: [
	        'rgba(54, 162, 235, 0.3)',	       
	        'rgba(255, 99, 132, 0.3)'
	      ],
	      //圖表外框線色
	      borderColor: [
	        'rgba(54, 162, 235, 1)',	        
	        'rgba(255, 99, 132, 1)'
	      ],
	      //外框線寬度
	      borderWidth: 1
	    }]
	  },
	  options:{
			legend: {
              labels: {
                  fontColor: "black",
                  fontSize: 25, 
              }
          }
		}
	});
	</script>
	<script>
	var ctx = document.getElementById('region');
	var myChart = new Chart(ctx, {
	  type: 'pie', //圖表類型
	  data: {	  
	    labels: ${mRegion["region"]}, //標題
	    datasets: [{
	      label: '# test', //標籤
	      data: ${mRegion["regionNum"]}, //資料
	      //圖表背景色
	      backgroundColor: [
	    	'rgba(255, 165, 0, 0.3)',
	    	'rgba(48, 213, 200, 0.3)',
	    	'rgba(64, 64, 64, 0.3)',
	    	'rgba(75, 0, 128, 0.3)',
	    	'rgba(77, 31, 0, 0.3)'
	      ],
	      //圖表外框線色
	      borderColor: [
	    	  'rgba(255, 165, 0, 1)',
	    	  'rgba(48, 213, 200, 1)',
	    	  'rgba(64, 64, 64, 1)',
	    	  'rgba(75, 0, 128, 1)',
	    	  'rgba(77, 31, 0, 1)'        
	      ],
	      //外框線寬度
	      borderWidth: 1
	    }]
	  },  
	  options: {
	            legend: {
	                labels: {
	                    // This more specific font property overrides the global property
	                    font: {
	                        size: 14
	                    }
	                }
	            }        
	    },
		options:{
				legend: {
	                labels: {
	                    fontColor: "black",
	                    fontSize: 25,
	                    
	                }
	            }
			}
	});
	</script>		
	<script>
	var ctx = document.getElementById('resTime');
	var myChart = new Chart(ctx, {
	  type: 'bar', //圖表類型
	  data: {
	    //標題
	    labels: ${mMonth["monthName"]},
	    datasets: [{
	      label: '半年內註冊人數統計表', //標籤
	      data: ${mMonth["monthCount"]}, //資料
	      //圖表背景色
	      backgroundColor: [
	        'rgba(255, 99, 132, 0.3)',
	        'rgba(54, 162, 235, 0.3)',
	        'rgba(255, 206, 86, 0.3)',
	        'rgba(75, 192, 192, 0.3)',
	        'rgba(153, 102, 255, 0.3)',
	        'rgba(255, 159, 64, 0.3)'
	      ],
	      //圖表外框線色
	      borderColor: [
	        'rgba(255, 99, 132, 1)',
	        'rgba(54, 162, 235, 1)',
	        'rgba(255, 206, 86, 1)',
	        'rgba(75, 192, 192, 1)',
	        'rgba(153, 102, 255, 1)',
	        'rgba(255, 159, 64, 1)'
	      ],
	      //外框線寬度
	      borderWidth: 1
	    }],
	  },
	  options: {
	    scales: {
	      yAxes: [{
	        ticks: {
	        	fontColor: "black",
	        	fontSize: 25,
	          beginAtZero: true,
	          responsive: true //符合響應式
	        }
	      }],
		    xAxes: [{
			  ticks: {
			     fontColor: "black",
			     fontSize: 25,
			        }
			      }]
	    },
	    legend: {
            labels: {
                fontColor: "black",
                fontSize: 50,
                
            }
        }
	  }			
	  
	});
	</script>
</body>
</html>