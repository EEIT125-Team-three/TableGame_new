<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>享玩 桌遊 | 管理員</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ScrollBar.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/manager_page.css">
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>
<script src="${pageContext.request.contextPath}/js/Standard.js"></script>
<style>
	.creat_input{
		width:200px;
		height:30px;
	}
	.creat_text-area{
		width:200px;
		height:40px;
	}
	
	.rep_div{
		float:left;
		width:1700px;
		height:750px;
		background-color:rgba(226, 226, 219, 0.794);
		border:2px solid black;
		border-radius:15px;
	}
	.sub_rep_div{
		float:left;
		margin:20px;
		width:1650px;
		height:700px;
	/* 	background-image:url(${pageContext.request.contextPath}/images/膚色紙背景.jpg); */
		border:5px double black;
		border-radius:15px;
		background-color:rgba(255, 203, 112,0.9);
	}
	.btn_rep_st{
		width:100px;
		height:30px;
		font-size:20px;
		border-radius:5px;
		background-color:#006030;
		color:#FFD306
	}
	.swal-title{
		font-size: 50px;
	}
	.swal-text{
		font-size: 30px;
	}
	input{
		font-size:20px;
	}

</style>
</head>

<body class="header_body">
	<header> </header>

	<div>
	<div class="manager_divst">
		<a href='${pageContext.request.contextPath}/Product/SearchAllGame'>
		<img src="${pageContext.request.contextPath}/images/勇氣徽章.png"
			style="height: 60px; width: 60px;border:3px solid black;float:left;">
		</a>
		<p style='margin-top:5px;float:left;'>遊戲清單</p>
	</div>
		 
	<div class="manager_divst">
		<img src="${pageContext.request.contextPath}/images/愛心徽章.png"
			style="height: 60px; width: 60px;border:3px solid black;float:left;"
			onclick="manager_creat_display()">
		<p style='margin-top:5px;float:left;'>新遊戲上架</p> 
	</div>
			 
	<div class="manager_divst">
		<img src="${pageContext.request.contextPath}/images/誠實徽章.png"
			style="height: 60px; width: 60px;border:3px solid black;float:left;"
			onclick="patch_edit()">
		<p style='margin-top:5px;float:left;'>批次編輯</p>
	</div>

	<div class="manager_divst">
		<img src="${pageContext.request.contextPath}/images/純真徽章.png"
			style="height: 60px; width: 60px;border:3px solid black;float:left;"
			 id='viewCount_analized'>
		<p style='margin-top:5px;float:left;'>瀏覽數排行</p>
		
	</div>
	</div>

	<div class='rep_div'>
		<div class='sub_rep_div'>
<!-- 		<p id='default' style='font-size:100px;margin-top:300px;margin-left:250px;font-weight:bold;'>管理員視窗</p> -->
			<div id='default'>
				<div style='width:820px;float:left;'>
					<canvas style='float:left;' id="cata1_analysis" width="600" height="500"></canvas>
				</div>
				<div style='width:820px;float:left;'>
					<canvas style='float:left;' id="cata2_analysis" width="600" height="500"></canvas>	
				</div>
			</div>
  <script>
  	var ctx = document.getElementById( "cata1_analysis" ),
  		example = new Chart(ctx, {
  			// 參數設定[註1]
  			type: "doughnut", // 圖表類型
  			data: {
  				labels: ${cata1}, // 標題
  				labelsColor:"#000000",
  				datasets: [{
  					label: "# of Votes", // 標籤
  					data: ${cata1_gameNum}, // 資料
  					dataColor:"#000000",
  					backgroundColor: [ // 背景色					
  						"#006030","#01814A","#019858","#01B468","#02C874","#02F78E","#4EFEB3",
  						"#96FED1","#C1FFE4","#467500","#548C00","#64A600","#73BF00",
  						"#82D900","#8CEA00","#A8FF24","#C2FF68","#D3FF93","#E8FFC4",
  					],
  					borderWidth: 2, // 外框寬度
  					borderColor:"#000000",
  					hoverBackgroundColor: "red",
  		            hoverBorderColor: "#FF0000",
  				}]
  			},
  			options:{
  				legend: {
  	                labels: {
  	                    fontColor: "black",
  	                    fontSize: 20,
  	                    
  	                }
  	            }
  			}
  		});
  	var ctx = document.getElementById( "cata2_analysis" ),
  		example = new Chart(ctx, {
  			// 參數設定[註1]
  			type: "doughnut", // 圖表類型
  			data: {
  				labels: ${cata2}, // 標題
  				datasets: [{
  					label: "# of Votes", // 標籤
  					data: ${cata2_gameNum}, // 資料
  					backgroundColor: [ // 背景色
//   					"#FF0000","#0000E3","#00DB00","#FFD306","#6C3365","#8CEA00","#FF5809","#019858",
  					"#003060","#003D79","#004B97","#0072E3","#2894FF","#66B3FF","#ACD6FF","#D2E9FF",
  					],
  					borderWidth: 2, // 外框寬度
  					borderColor:"#000000",
  					hoverBackgroundColor: "#FFFF37",
  		            hoverBorderColor: "#FF0000",
  				}]
  			},
  			options:{
  				legend: {
  	                labels: {
  	                    fontColor: "black",
  	                    fontSize: 20
  	                }
  	            }
  			}
  		});
  </script>			
			<div id="main" style="width: 1600px;height:700px;display:none;"></div>
    <script type="text/javascript">
        // 基於準備好的dom，初始化echarts例項
        var myChart = echarts.init(document.getElementById('main')); 
        // 指定圖表的配置項和資料
        var option = {
            title: {
            	x:'center',
            	text: '瀏覽數排行',
            	textStyle: {
                    fontSize: 25,
                    fontWeight: 'bolder'
            	},
            },
            tooltip: {},
            legend: {data:['瀏覽數量']},
            xAxis: {data: ${name}},
            yAxis: {},
            series: [{
                name: '瀏覽數',
                type: 'bar',
                data: ${viewCount},
                itemStyle:{
                	normal:{
                		color:'rgba(0, 158, 55,0.8)',
                    	},
                	}
                }] 
        }; 
        // 使用剛指定的配置項和資料顯示圖表。
        myChart.setOption(option);
    </script>
    
    		<fieldset style="display: none; border: none; text-align: center; font-size: 30px; line-height: 1.6;" id='search_fieldset'>
	    		<legend style='font-size:60px;font-weight:bold;'>搜尋遊戲</legend>
	    		<div style='margin-left:50px;'>
	    		<form action="${pageContext.request.contextPath}/Product/AdvancedSearch_manager_ajax" method="POST" id="fuck">
	    		<div style='float:left;text-align:right;font-size: 30px;'>
		    		<label>英文名字: </label><br>
					<label>中文名字: </label><br>
					<label>創作者: </label><br>
					<label>插畫家: </label><br>
					<label>價錢: </label><br>
					<label>類型: </label><br><br><br><br>
					<label>科目: </label>
	    		</div>
	    		<div style='float:left;'>
		    		<input style='height:20px;width:300px;' type='text' id='E_name' name='E_name' value=""><br>	
					<input style='height:20px;width:300px;' type='text' id='C_name' name='C_name' value=""><br>
					<input style='height:20px;width:300px;' type='text' id='G_maker' name='G_maker' value=""><br>
					<input style='height:20px;width:300px;' type='text' id='iss' name='iss' value=""><br>
					<input style='height:20px;width:50px;' type='text' id='Price' name='Price' value=0>
					<span> ~ </span>
					<input style='height:20px;width:50px;' type='text' id='Price1' name='Price1' value=100 onblur='checkprice1()' id='price1'>
					<span style='font-size:20px;color:red;margin-top:1px' id='error'></span>
					<br>
					<div style='margin-left:50px'>
					<div style='font-size:30px;color:#000079;text-align:left;'>
		    		競速<input type='checkbox' name="Cata1[]" value='1'>
		    		言語<input type='checkbox' name="Cata1[]" value='2'>
		    		大腦<input type='checkbox' name="Cata1[]" value='3'>
					紙牌<input type='checkbox' name="Cata1[]" value='4'>
					讀物<input type='checkbox' name="Cata1[]" value='5'>
					猜心<input type='checkbox' name="Cata1[]" value='6'><br>
					巧手<input type='checkbox' name="Cata1[]" value='7'>
					派對<input type='checkbox' name="Cata1[]" value='8'>
					骰子<input type='checkbox' name="Cata1[]" value='9'>
					樂齡<input type='checkbox' name="Cata1[]" value='10'>
					陣營<input type='checkbox' name="Cata1[]" value='14'>
					兒童<input type='checkbox' name="Cata1[]" value='15'><br>
					合作<input type='checkbox' name="Cata1[]" value='16'>
					周邊<input type='checkbox' name="Cata1[]" value='19'>
					6人+<input type='checkbox' name="Cata1[]" value='18'>
					1-2人<input type='checkbox' id='cata11' name="Cata1[]" value='17'>
					重策略<input type='checkbox' id='cata12' name="Cata1[]" value='11'><br>
					中策略<input type='checkbox' name="Cata1[]" value='12'>
					輕策略<input type='checkbox' id='cata13' name="Cata1[]" value='13'><br>		    		
		    		</div>
		    		<div style='font-size:30px;color:#460046;text-align:left;'>
					自然<input type='checkbox' id='cata21' name="Cata2[]" value='1'>
					社會<input type='checkbox' id='cata22' name="Cata2[]" value='2'>
					科技<input type='checkbox' id='cata23' name="Cata2[]" value='3'>
					健體<input type='checkbox' name="Cata2[]" value='4'>
					綜合<input type='checkbox' name="Cata2[]" value='5'>
					語文<input type='checkbox' name="Cata2[]" value='6'><br>
					數學<input type='checkbox' name="Cata2[]" value='7'>
					藝術<input type='checkbox' name="Cata2[]" value='8'><br>
					</div>
					</div>

		    		<input class='btn_rep_st' type='button' name='name' value='提交' onclick='getAdvancedGame()'>
					<input class='btn_rep_st' type='reset' name='name' value='清除'>
					<button class='btn_rep_st' type='button' onclick='fastInsert1()'>一鍵輸入</button>
					<button class='btn_rep_st' style='width:120px' type='button' onclick='fastInsert2()'>一鍵輸入二</button>
	    		</div>
	    		</form>
	    		</div>
	    		
	    		<div id='111' style='border-radius:15px;float:right;border:2px solid black;width:800px;height:500px;margin-left:10px;background-image:url(${pageContext.request.contextPath}/images/青色紙背景.jpg)'>
				<button class='btn_rep_st' style='width:200px;height:100px;font-size:30px;margin-top:150px;' onclick='getAllGames()'>取得所有遊戲</button>
	    		</div>
	    					
				<script type="text/javascript">
				function fastInsert1(){
					$("#Price").val("0");
					$("#Price1").val("2000");
					$("#cata11").prop("checked", true);
					$("#cata12").prop("checked", true);
					$("#cata21").prop("checked", true);
					$("#cata22").prop("checked", true);
					$("#cata23").prop("checked", true);
				}
				function fastInsert2(){
					$("#E_name").val("Car");
					$("#C_name").val("卡卡");
					$("#Price").val("0");
					$("#Price1").val("1000");
					$("#cata13").prop("checked", true);
				}
				function fastInsert3(){
					$("#E_name1").val("InsertTest");
					$("#C_name1").val("新增遊戲測試");
					$("#img_url1").val("https://panmarket.asia/wp-content/uploads/2018/10/%E5%AF%B6%E8%97%8F%E5%8F%B0%E7%81%A3%E6%A1%8C%E9%81%8A_1-720x405.jpg");
					$("#G_maker1").val("第三組");
					$("#iss1").val("夏浩庭");
					$("#Price11").val("999");
					$("#info1").val("新增遊戲至資料庫DEMO測試，新增遊戲至資料庫DEMO測試，新增遊戲至資料庫DEMO測試");
					$("#viewCount1").val("2000");
					$("#storage1").val("5");
					$("#cata111").prop("checked", true);
					$("#cata112").prop("checked", true);
					$("#cata113").prop("checked", true);
					$("#cata211").prop("checked", true);
					$("#cata212").prop("checked", true);
				}
				
				function getAllGames(){
				$.ajax({
					url:"${pageContext.request.contextPath}/Product/SearchAllGame_manager_ajax",
					data:{},
					dataType:'json',
					type:'POST',
					success:function(htmlObj,Object){
						$('#111').html("共搜尋出 :"+htmlObj.length+" 筆資料<br>"
						+"<form action='${pageContext.request.contextPath}/Product/PatchUpdate' id='form3'>"
						+"創作者 :<input type='text' name='G_maker'><br>"
						+"插畫家 :<input type='text' name='iss'><br>"
						+"價錢折扣數 :<input type='text' name='discount'><br>"
						+"<button class='btn_rep_st' type='submit' value='submit'>確認修改</button>"
						+"<button class='btn_rep_st' type='reset'>清除資料</button>"
						+"</form>"
						+"<script>"
						+"document.querySelector('#form3').addEventListener('submit', function(e) {"
						+"var form = this;e.preventDefault();"
						+"swal({title: '確定修改?', text: '多筆資料即將修改!',icon: 'warning',buttons:['取消','確定'],dangerMode: true,"
						+"}).then(function(isConfirm){if (isConfirm){swal({title: '成功',text: '資料已成功修改',icon: 'success'}).then(function() {"
						+"form.submit();});} else {swal('取消', '已取消操作', 'error');}})});</"
						+"script>"
						
						)
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
								+"<form action='${pageContext.request.contextPath}/Product/PatchUpdate' id='form2'>"
								+"創作者 :<input type='text' name='G_maker'><br>"
								+"插畫家 :<input type='text' name='iss'><br>"
								+"價錢折扣數 :<input type='text' name='discount'><span id='numcheck'></span><br>"
								+"<button class='btn_rep_st' type='submit'>確認修改</button>"
								+"<button class='btn_rep_st' type='reset'>清除資料</button>"
								+"</form>"
								+"<script>"
								+"document.querySelector('#form2').addEventListener('submit', function(e) {"
								+"var form = this;e.preventDefault();"
								+"swal({title: '確定修改?', text: '多筆資料即將修改!',icon: 'warning',buttons:['取消','確定'],dangerMode: true,"
								+"}).then(function(isConfirm){if (isConfirm){swal({title: '成功',text: '資料已成功修改',icon: 'success'}).then(function() {"
								+"form.submit();});} else {swal('取消', '已取消操作', 'error');}})});</"
								+"script>"
								)
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
				style="display: none; border: none; text-align: center; font-size: 30px; line-height: 2;"
				id="creat_fieldset">
				<legend style='font-size:50px;font-weight:bold;'>新遊戲上架</legend>
<%-- 				<form:form action='${pageContext.request.contextPath}/Product/InsertGame' method='POST' modelAttribute='gb' enctype="multipart/form-data"> --%>
				<form action='${pageContext.request.contextPath}/Product/InsertGame' method='POST' id='form1'>
				<div style='float:left;text-align:left;width:600px;margin-left:250px;'>
				<div style='float:left;text-align:right;font-size:30px;'>
				<label>英文名字: </label><br>
				<label>中文名字: </label><br>
				<label>圖片: </label><br>
				<label>創作者: </label><br>
				<label>插畫家: </label><br>
				<label>類型: </label>
				</div>
				<div style='float:left;margin-left:50px'>
	                <input class='creat_input' type='text' id='E_name1' name='E_name' required='required'><br>
			        <input class='creat_input' type='text' id='C_name1' name='C_name' required='required'><br>
<!-- 			        <input class='creat_input' type='file' name='img_url' id="pic"><br> -->
			        <input class='creat_input' type='text' id='img_url1' name='img_url' id="pic"><br>
			        <input class='creat_input' type='text' id='G_maker1' name='G_maker'><br>
			        <input class='creat_input' type='text' id='iss1' name='iss'><br>
			        <div style='font-size:30px;color:#000079;text-align:left;'>
		    		競速<input type='checkbox' id='cata111' name="Cata1[]" value='1'>
		    		言語<input type='checkbox' id='cata112' name="Cata1[]" value='2'>
		    		大腦<input type='checkbox' id='cata113' name="Cata1[]" value='3'>
					紙牌<input type='checkbox' name="Cata1[]" value='4'>
					讀物<input type='checkbox' name="Cata1[]" value='5'><br>
					猜心<input type='checkbox' name="Cata1[]" value='6'>
					巧手<input type='checkbox' name="Cata1[]" value='7'>
					派對<input type='checkbox' name="Cata1[]" value='8'>
					骰子<input type='checkbox' name="Cata1[]" value='9'>
					樂齡<input type='checkbox' name="Cata1[]" value='10'><br>
					陣營<input type='checkbox' name="Cata1[]" value='14'>
					兒童<input type='checkbox' name="Cata1[]" value='15'>
					合作<input type='checkbox' name="Cata1[]" value='16'>
					周邊<input type='checkbox' name="Cata1[]" value='19'>
					6人+<input type='checkbox' name="Cata1[]" value='18'><br>
					1-2人<input type='checkbox' name="Cata1[]" value='17'>
					重策略<input type='checkbox' name="Cata1[]" value='11'>
					中策略<input type='checkbox' name="Cata1[]" value='12'>
					輕策略<input type='checkbox' name="Cata1[]" value='13'><br>		    		
		    		</div>
			        
			    </div>   
			    </div>
			    <div style='float:left;text-align:left;width:500px'>
			    <div style='float:left;text-align:right;font-size:30px;'>
			    <label>內容:</label><br>
			    <label>價錢: </label><br>
			    <label>瀏覽數:</label><br>
			    <label>上市日期:</label><br>
			    <label>庫存:</label><br>
			    <label>科目:</label>
			    </div>
			    <div style='float:left;margin-left:50px'>
			       <input class='creat_text-area' type='text' id='info1' name='info'></input><br>
			       <input class='creat_input' type='text' id='Price11' name='Price' required='required'><span style='font-size:15px;color:red;'>(請輸入正整數)</span><br>
			       <input class='creat_input' type='text' id='viewCount1' name='viewCount' required='required'><span style='font-size:15px;color:red;'>(請輸入正整數)</span><br>
			       <input class='creat_input' type='date' id='date1' name='date' required='required'><br>
			       <input class='creat_input' type='text' id='storage1' name='storage' required='required'><span style='font-size:15px;color:red;'>(請輸入正整數)</span>
			       <div style='font-size:30px;color:#460046;text-align:left;'>
					自然<input type='checkbox' id='cata211' name="Cata2[]" value='1'>
					社會<input type='checkbox' id='cata212' name="Cata2[]" value='2'>
					科技<input type='checkbox' name="Cata2[]" value='3'>
					健體<input type='checkbox' name="Cata2[]" value='4'><br>
					綜合<input type='checkbox' name="Cata2[]" value='5'>
					語文<input type='checkbox' name="Cata2[]" value='6'>
					數學<input type='checkbox' name="Cata2[]" value='7'>
					藝術<input type='checkbox' name="Cata2[]" value='8'><br>
					</div>
				</div>
				</div>
					<div style='clear:left;'>
<!-- 					<button class='btn_rep_st' type='submit' name='name' onclick='checkalert()'>提交</button> -->
					<button class='btn_rep_st' type='submit' >提交</button>
					<input class='btn_rep_st' type='reset' value='清除'>
					<button class='btn_rep_st' type='button' onclick='fastInsert3()'>一鍵輸入</button>
					</div>
				</form>
<%-- 				</form:form> --%>
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

	function checkprice1(){	
		let price1 = document.getElementById("price1");
		let error = document.getElementById("error");
		if(price1.value > 0){
			error.innerHTML="";
			error.innerHTML="格式正確";							
		}			
		else{
			error.innerHTML="";
			error.innerHTML="格式錯誤";
		}
	}
	
	function confirmUpdate(productId) {
		var result = confirm("確定修改多筆資料?");
		if (result) {
			document.forms[0].finalDecision.value = "UPDATE";
			return true;
		}
		return false;
	}
	document.querySelector('#form1').addEventListener('submit', function(e) {
		  var form = this;

		  e.preventDefault(); // <--- prevent form from submitting

		  swal({
		      title: "確定新增?",
		      text: "資料將寫入資料庫",
		      icon: "warning",
		      buttons: [
		        '取消',
		        '確定'
		      ],
		      dangerMode: true,
		    }).then(function(isConfirm) {
		      if (isConfirm) {
		        swal({
		          title: '成功',
		          text: '資料已成功新增',
		          icon: 'success'
		        }).then(function() {
		          form.submit(); // <--- submit form programmatically
		        });
		      } else {
		        swal("取消", "已取消操作", "error");
		      }
		    })
		});

	</script>
<footer class="footer_body">
</footer>
</body>

</html>