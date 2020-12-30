<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>123</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/manager_page.css">
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>
<script src="${pageContext.request.contextPath}/js/Standard.js"></script>
<style>
.creat_input{
	width:200px;
	height:40px;
}
.creat_text-area{
	width:200px;
	height:40px;
}

.rep_div{
	float:left;
	margin-left:15px;
	width:1100px;
	height:750px;
	background-image:url(${pageContext.request.contextPath}/images/墨綠色背景.jpg);
	border:2px solid black;
	border-radius:15px;
}
.sub_rep_div{
	float:left;
	margin:20px;
	width:1050px;
	height:700px;
	background-image:url(${pageContext.request.contextPath}/images/膚色紙背景.jpg);
	border:5px double black;
	border-radius:15px;
}
.btn_rep_st{
	width:100px;
	height:30px;
	font-size:20px;
	border-radius:5px;
	background-color:#006030;
	color:#FFD306
}
</style>
</head>

<body class="header_body">
	<header> </header>

	<div style='float:left'>
	<div class="manager_divst">
		<a href='${pageContext.request.contextPath}/Product/SearchAllGame'>
		<img src="${pageContext.request.contextPath}/images/勇氣徽章.png"
			style="height: 300px; width: 300px; margin-top: 15px;border:3px solid black">
		</a>
		<p style='margin-top:5px;'>遊戲清單</p>
	</div>
		 
	<div class="manager_divst">
		<img src="${pageContext.request.contextPath}/images/愛心徽章.png"
			style="height: 300px; width: 300px; margin-top: 15px;border:3px solid black"
			onclick="manager_creat_display()">
		<p style='margin-top:5px;'>新遊戲上架</p> 
	</div>
			 
	<div class="manager_divst" style='clear:left;margin-top:15px;'>
		<img src="${pageContext.request.contextPath}/images/誠實徽章.png"
			style="height: 300px; width: 300px; margin-top: 15px;border:3px solid black"
			onclick="patch_edit()">
		<p style='margin-top:5px;'>批次編輯</p>
	</div>

	<div class="manager_divst" style='margin-top:15px;'>
		<img src="${pageContext.request.contextPath}/images/純真徽章.png"
			style="height: 300px; width: 300px; margin-top: 15px;border:3px solid black"
			 id='viewCount_analized'>
		<p style='margin-top:5px'>瀏覽數排行</p>
		
	</div>
	</div>
	<div class='rep_div'>
		<div class='sub_rep_div'>
		<p id='default' style='font-size:100px;margin-top:300px;margin-left:250px;font-weight:bold;'>管理員視窗</p>
			
			<div id="main" style="width: 1000px;height:700px;display:none;"></div>
    <script type="text/javascript">
        // 基於準備好的dom，初始化echarts例項
        var myChart = echarts.init(document.getElementById('main'));
 
        // 指定圖表的配置項和資料
        var option = {
            title: {text: '瀏覽數排行'},
            tooltip: {},
            legend: {data:['瀏覽數']},
            xAxis: {data: ${name}},
            yAxis: {},
            series: [{
                name: '瀏覽數',
                type: 'bar',
                data: ${viewCount},
                itemStyle:{
                	normal:{
                		color:'#0072E3',
                	}
                }
            }]
        };
 
        // 使用剛指定的配置項和資料顯示圖表。
        myChart.setOption(option);
    </script>
    
    		<fieldset style="display: none; border: none; text-align: center; font-size: 40px; line-height: 1.8;" id='search_fieldset'>
	    		<legend style='font-size:60px;font-weight:bold;'>搜尋遊戲</legend>
	    		<form action="${pageContext.request.contextPath}/Product/AdvancedSearch_manager_ajax" method="POST" id="fuck">
	    		<div style='float:left;text-align:right'>
		    		<label>英文名字: </label><br>
					<label>中文名字: </label><br>
					<label>創作者: </label><br>
					<label>插畫家: </label><br>
					<label>價錢: </label>
	    		</div>
	    		<div style='float:left;'>
		    		<input style='height:20px;width:300px;' type='text' name='E_name' value=""><br>	
					<input style='height:20px;width:300px;' type='text' name='C_name' value=""><br>
					<input style='height:20px;width:300px;' type='text' name='G_maker' value=""><br>
					<input style='height:20px;width:300px;' type='text' name='iss' value=""><br>
					<input style='height:20px;width:50px;' type='text' name='Price' value=0>
					<span> ~ </span>
					<input style='height:20px;width:50px;' type='text' name='Price1' value=0>
					<p style='font-size:20px;color:red;margin-top:1px'>( 請輸入正整數 )</p>
		    		
		    		<input class='btn_rep_st' type='button' name='name' value='提交' onclick='getAdvancedGame()'>
					<input class='btn_rep_st' type='reset' name='name' value='清除'>
	    		</div>
	    		</form>
	    		
	    		<div id='111' style='border-radius:15px;float:right;border:2px solid black;width:400px;height:400px;margin-left:10px;background-image:url(${pageContext.request.contextPath}/images/青色紙背景.jpg)'>
				<button class='btn_rep_st' style='width:200px;height:100px;font-size:30px;' onclick='getAllGames()'>取得所有遊戲</button>
	    		</div>
	    					
				<script type="text/javascript">
				function getAllGames(){
				$.ajax({
					url:"${pageContext.request.contextPath}/Product/SearchAllGame_manager_ajax",
					data:{},
					dataType:'json',
					type:'POST',
					success:function(htmlObj,Object){
						$('#111').html("共搜尋出 :"+htmlObj.length+" 筆資料<br>"
						+"<form action='${pageContext.request.contextPath}/Product/PatchUpdate'>"
						+"創作者 :<input type='text' name='G_maker'><br>"
						+"插畫家 :<input type='text' name='iss'><br>"
						+"價錢折扣數 :<input type='text' name='discount'><br>"
						+"<button class='btn_rep_st' type='submit' value='Submit' onclick='warning()'>確認修改</button>"
						+"<button class='btn_rep_st' type='reset'>清除資料</button>"
						+"</form>")
						console.log(htmlObj)
					}
				})
				}
				function getAdvancedGame(){
					$('form').each(function(){
							console.log($(this).index())
					})
						var url = $('#fuck').attr("action");
						var form = $('#fuck').serialize();
						form = decodeURIComponent(form,true);
						$.ajax({
							url : url,
							data:{
								'form' : form
							},
							dataType:'json',
							type:'POST',
							success:function(htmlObj,Object){
								$('#111').html("共搜尋出 :"+htmlObj.length+" 筆資料<br>"
								+"<form action='${pageContext.request.contextPath}/Product/PatchUpdate'>"
								+"創作者 :<input type='text' name='G_maker'><br>"
								+"插畫家 :<input type='text' name='iss'><br>"
								+"價錢折扣數 :<input type='text' name='discount'><span id='numcheck'></span><br>"
								+"<button class='btn_rep_st' type='submit' onclick='warning()'>確認修改</button>"
								+"<button class='btn_rep_st' type='reset'>清除資料</button>"
								+"</form>")
								console.log(htmlObj)
							},
							error:function(){
								console.log("bbb")
							}

						})
				}
				</script>
    		</fieldset>
		
			<fieldset
				style="display: none; border: none; text-align: center; font-size: 40px; line-height: 2;"
				id="creat_fieldset">
				<legend style='font-size:60px;font-weight:bold;'>新遊戲上架</legend>
				<form:form action='${pageContext.request.contextPath}/Product/InsertGame' method='POST' modelAttribute='gb'>
				<div style='float:left;text-align:left;width:400px'>
				<div style='float:left;text-align:right'>
				<label>英文名字: </label><br>
				<label>中文名字: </label><br>
				<label>圖片連結: </label><br>
				<label>創作者: </label><br>
				<label>插畫家: </label>
				</div>
				<div style='float:left;margin-left:5px'>
	                <input class='creat_input' type='text' name='E_name' required='required'><br>
			        <input class='creat_input' type='text' name='C_name'	required='required'><br>
			        <input class='creat_input' type='text' name='img_url'><br>
			        <input class='creat_input' type='text' name='G_maker'><br>
			        <input class='creat_input' type='text' name='iss'>
			    </div>   
			    </div>
			    <div style='float:left;text-align:left;width:500px'>
			    <div style='float:left;text-align:right'>
			    <label>內容:</label><br>
			    <label>價錢: </label><br>
			    <label>瀏覽數:</label><br>
			    <label>上市日期:</label><br>
			    <label>庫存:</label>
			    </div>
			    <div style='float:left;margin-left:5px'>
			       <textarea class='creat_text-area' name='info'></textarea><br>
			       <input class='creat_input' type='text' name='Price' required='required'><span style='font-size:15px;color:red;'>(請輸入正整數)</span><br>
			       <input class='creat_input' type='text' name='viewCount' required='required'><span style='font-size:15px;color:red;'>(請輸入正整數)</span><br>
			       <input class='creat_input' type='date' name='date' required='required'><br>
			       <input class='creat_input' type='text' name='storage' required='required'><span style='font-size:15px;color:red;'>(請輸入正整數)</span>
				</div>
				</div>
					<div style='clear:left;'>
					<input class='btn_rep_st' type='submit' name='name' value='提交'>
					<input class='btn_rep_st' type='reset' name='name' value='清除'>
					</div>
				</form:form>
			</fieldset>
		</div>
	</div>

	
	<script>
	var default_chart = document.getElementById("default");
	var analized_show = document.querySelector('#viewCount_analized');
	var display = document.getElementById("creat_fieldset");
	var display1 = document.getElementById('main');
	var display2 = document.getElementById("search_fieldset");
	
	function manager_creat_display(){

					display.style.display="";				
					default_chart.style.display="none";
					display1.style.display="none";				
					display2.style.display="none";				

				}

	function patch_edit(){

			display2.style.display="";
			default_chart.style.display="none";
			display.style.display="none";
			display1.style.display="none";

	}
	analized_show.addEventListener('click', function () {
			display1.style.display="";
			default_chart.style.display="none";
			display.style.display="none";
			display2.style.display="none";
		
	})
// 	function warning(){
// 		alert("多筆資料即將異動 !!!")
// 	}
	function warning() {
		Swal.fire(
            "商品資料異動",
              "資料庫內容已被修改", //訊息內容(可省略)
              "warning" //圖示(可省略) success/info/warning/error/question
            //圖示範例：https://sweetalert2.github.io/#icons
        );
    }
//     function warning() {
//         Swal.fire({
//             title: "資料即將異動",
//             text: "請確認操作",
//             showCancelButton: true
//         }).then(function(result) {
//            if (result.value) {
//                 Swal.fire("您按了OK");
//            }
//            else {
//                Swal.fire("您選擇了Cancel");
//            }
//         });
//     }
// 		function warning() {
// 		    swalConfirm("操作確認", "請點選按鈕")
// 		        .done(function () {
// 		            Swal.fire("您按了OK");
// 		        })
// 		        .fail(function () {
// 		            Swal.fire("您選擇了Cancel");
// 		        });
// 		}
	
		
	</script>
<footer class="footer_body">
</footer>
</body>

</html>