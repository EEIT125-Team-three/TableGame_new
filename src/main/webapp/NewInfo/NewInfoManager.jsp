<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>享玩 桌遊 | 活動管理員</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/newinfo_style.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>
<script src="${pageContext.request.contextPath}/js/Act.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</head>
<body class="header_body">
	<script src="${pageContext.request.contextPath}/js/InfoMenu.js"></script>
	<header> </header>
	<fieldset class="AddInfoField">
		<form:form method="POST" modelAttribute="InfoBean" id="addInfo"
			enctype="multipart/form-data">
			<div class="updateform">
				<h2>新增活動</h2>
				<table class="update_tb">
					<tr>
						<td><label class="u1">活動區域:</label></td>
						<td><form:select class="add_select" type="text"
								path="actArea" id="Area" size="0" maxlength="10"
								onchange="onSelectArea();">
								<form:option value="">請選擇</form:option>
								<form:option value="台北">台北</form:option>
								<form:option value="台中">台中</form:option>
								<form:option value="高雄">高雄</form:option>
							</form:select><span id="actsp1" class="SH_span"></span></td>
					</tr>
					<tr>
						<td><label class="u1">項目:</label></td>
						<td><form:select class="add_select" type="text"
								path="activity" id="Act" size="0" maxlength="10"
								onchange="onSelectAct();">
								<form:option value="">請選擇</form:option>
								<form:option value="活動">活動</form:option>
								<form:option value="課程">課程</form:option>
							</form:select><span id="actsp2" class="SH_span"></span></td>
					</tr>
					<tr>
						<td><label class="u1">活動類型:</label></td>
						<td><form:select class="add_select" type="text"
								path="actType" id="Type" size="0" maxlength="10"
								placeholder="活動類型">
							</form:select><span id="actsp3" class="SH_span"></span></td>
					</tr>
					<tr>
						<td><label class="u1">活動日期(1):</label></td>
						<td><form:input class="add_select" type="date"
								path="actDate1" id="Date1" /><span id="actsp4" class="SH_span"></span></td>
					</tr>
					<tr>
						<td><label class="u1">時間(1):</label></td>
						<td><label class="u1">開始: <form:input
									class="add_select" type="time" path="actStrTime1" id="strtime1" />
								~ 結束:<form:input class="add_select" type="time"
									path="actEndTime1" id="endtime1" /><br> <span id="actsp5"
								class="SH_span"></span></label></td>
					</tr>
					<tr>
						<td><label class="u1">活動日期(2):</label></td>
						<td><form:input class="add_select" type="date"
								path="actDate2" id="Date2" /><span id="actsp6" class="SH_span"></span></td>
					</tr>
					<tr>
						<td><label class="u1">時間(2):</label></td>
						<td><label class="u1">開始:<form:input
									class="add_select" type="time" path="actStrTime2" id="strtime2" />
								~ 結束: <form:input class="add_select" type="time"
									path="actEndTime2" id="endtime2" /><br> <span id="actsp7"
								class="SH_span"></span></label></td>
					</tr>
					<tr>
						<td><label class="u1">活動天數:</label></td>
						<td><form:input class="add_select" type="text" path="actDay"
								id="Day" /><span id="actsp8" class="SH_span"></span></td>
					</tr>
					<tr>
						<td><label class="u1">活動地點:</label></td>
						<td><form:select class="add_select" id="Location" size="0"
								maxlength="10" type="text" path="actLocation"
								onchange="onSelectLoc();"></form:select><br>
						<span id="actsp9" class="SH_span"></span></td>
					</tr>
					<tr>
						<td><label class="u1">活動地址:</label></td>
						<td><span></span> <form:input class="add_select" type="text"
								path="actAddress" size="0" maxlength="20" id="Address"
								style="display:none" /><br>
						<span id="actsp10" class="SH_span"></span></td>
					</tr>
					<tr>
						<td><label class="u1">人數限制:</label></td>
						<td><form:input class="add_select" type="text"
								path="actLimitPer" id="Limitper" /><span id="actsp11"
							class="SH_span"></span></td>
					</tr>
					<tr>
						<td><label class="u1">活動費用:</label></td>
						<td><form:input class="add_select" type="text" path="actCost"
								id="Cost" /><span id="actsp12" class="SH_span"></span></td>
					</tr>
				</table>
			</div>
		</form:form>
		<div class="search">
			<button class="add_select" name='addInfoBtn' id="recheck">新增</button>
			<button class="add_select" id="quickAdd">一鍵新增</button>
			<a href="${pageContext.request.contextPath}/AllInfos"><button
					class="add_select" type='button' >修改活動資料</button></a>
		</div>

	</fieldset>
	<div class="container">
		<div class="row">
			<div class="col-1" style="float: left; margin-left: 5%; width: 40%;">
				<div class="TotalAct">
					<h2>活動數量</h2>
					<canvas id="Act_analysis" width="600px" height="400px"></canvas>
				</div>
			</div>
			<div class="col-1"
				style="float: right; margin-right: 5%; width: 40%;">
				<div class="TotalAct">
					<h2>活動人數</h2>
					<canvas id="Act_people" width="600px" height="400px"></canvas>
				</div>
			</div>
		</div>
	</div>

	<script>
	var ctx = document.getElementById("Act_analysis") 
	var example = new Chart(ctx, { 
 		//設定參數 
 		type:"pie",//圓餅圖 
		data:{ 
			labels:${actNum["actTypeName"]},
 			labelsColor:"#000000", 
 			datasets:[{ 
 				label:"of Votes",//標籤 
 				data:${actNum["actTypeCount"]},//資料
 				backgroundColor:[ 
 					"#FF9224","#66B3FF","#28FF28","#FF60AF"
 				], 
 				borderWidth:0, 
 				borderColor:"#000000", 
 				hoverBackgroundColor:"#B15BFF", 
 				hoverBorderColor:"white", 
 			}] 
 		}, 
 	options:{ 
 		legend:{ 
 			labels:{ 
 				fontColor:"black", 
 				fontSize:25, 
 			} 
 		} 
 	} 
 	}) ;
	</script>
	<script>
var ctx1 = document.getElementById("Act_people") 
var example1 = new Chart(ctx1, {  
	//設定參數  
	type:"bar",//長條圖  
	data:{  
		labels:${actPeople["activeTypeName"]},
//		labelsColor:"#000000",
		datasets:[{  
 			label:"參與人數統計",//標籤  
//  		labelColor:"",
			data:${actPeople["activePeopleAcount"]},//資料
			backgroundColor:[
				"#FF9224","#66B3FF","#28FF28","#FF60AF", "#FFFF37"
			],  
			borderWidth:0,  
			borderColor:"#000000",  
			hoverBackgroundColor:"#B15BFF",  
			hoverBorderColor:"white",  
			}]
		},  
		options:{ 
		legend:{  
		labels:{ 
		fontColor:"black",  
		fontSize:25,  
		}
	}  
}  
}) ;  
</script>
</body>
<script src="${pageContext.request.contextPath}/js/ActInsert.js"></script>
	<footer class="footer_body">
</footer>
</html>