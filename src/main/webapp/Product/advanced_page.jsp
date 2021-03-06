<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>享玩 桌遊 | 分類檢索 | 進階搜尋</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Standard.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ScrollBar.css">
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
    <script src="${pageContext.request.contextPath}/js/Standard.js"></script>
    <script src="${pageContext.request.contextPath}/js/SearchList.js"></script>
	<style>
	.fieldset_st{
		background-color:rgba(226, 226, 219, 0.794);
		width:700px;
		border-radius:15px;
		color:	#FFC78E;
		float:left;
	}
	.display_img{
		width:300px;
		height:300px;
		transition:transform 1s ease;
	}
	.display_div{
		float:left;
	}
	input{
		font-size:20px;
		height:20px;
	}
	.btn_rep_st{
		width:100px;
		height:30px;
		font-size:20px;
		border-radius:5px;
		background-color:#006030;
		color:#FFD306;
	}

	</style>
</head>

<body class="header_body">
	<script>
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
		function checkEname(){
			var ename = document.getElementById("E_name").value;
    		var special = /[~!@#$%^&*ˇˋ˙ˊ()+=/\-]/;
    		if(special.test(ename)|| ename.indexOf("\'")>=0 || ename.indexOf('\"')>=0){
    				Swal.fire(
						  '發生錯誤',
						  '不可以輸入符號',
						  'error'
						)    				 				
    			}
    	}
		function checkCname(){
			var cname = document.getElementById("C_name").value;
    		var special = /[~!@#$%^&*ˇˋ˙ˊ()+=/\-]/;
    		if(special.test(cname)|| cname.indexOf("\'")>=0 || cname.indexOf('\"')>=0){
    				Swal.fire(
						  '發生錯誤',
						  '不可以輸入符號',
						  'error'
						)    				 				
    			}
    	}
		function checkGmaker(){
			var gmaker = document.getElementById("G_maker").value;
    		var special = /[~!@#$%^&*ˇˋ˙ˊ()+=/\-]/;
    		if(special.test(gmaker)|| gmaker.indexOf("\'")>=0 || gmaker.indexOf('\"')>=0){
    				Swal.fire(
						  '發生錯誤',
						  '不可以輸入符號',
						  'error'
						)    				 				
    			}
    	}
		function checkiss(){
			var iss = document.getElementById("iss").value;
    		var special = /[~!@#$%^&*ˇˋ˙ˊ()+=/\-]/;
    		if(special.test(iss)|| iss.indexOf("\'")>=0 || iss.indexOf('\"')>=0){
    				Swal.fire(
						  '發生錯誤',
						  '不可以輸入符號',
						  'error'
						)    				 				
    			}
    	}
		function checkprice(){
			var price1 = document.getElementById("Price1").value;
			var price = document.getElementById("Price").value;
    		var special = /[~!@#$%^&*ˇˋ˙ˊ()+=/\-]/;
    		var alphabat = /[a-zA-Z]/;
    		var reg = /^[\u4E00-\u9FA5]+$/;
    		if(special.test(price)|| price.indexOf("\'")>=0 || price.indexOf('\"')>=0 || alphabat.test(price)|| reg.test(price)){
    				Swal.fire(
						  '發生錯誤',
						  '不可以輸入符號或文字',
						  'error'
						)    				 				
    			}
    		if(price1 != ""){
    			if(parseInt(price)>parseInt(price1)){
    				Swal.fire(
  						  '發生錯誤',
  						  '價位區間大小錯誤',
  						  'error'
  						) 
    			}
    		}
    		
    	}
		function checkprice1(){
			var price1 = document.getElementById("Price1").value;
			var price = document.getElementById("Price").value;
    		var special = /[~!@#$%^&*ˇˋ˙ˊ()+=/\-]/;
    		var alphabat = /[a-zA-Z]/;
    		var reg = /^[\u4E00-\u9FA5]+$/;
    		if(special.test(price1)|| price1.indexOf("\'")>=0 || price1.indexOf('\"')>=0 || alphabat.test(price1)|| reg.test(price1)){
    				Swal.fire(
						  '發生錯誤',
						  '不可以輸入符號',
						  'error'
						)    				 				
    			}
    		if(price != ""){
    			if(parseInt(price)>parseInt(price1)){
    				Swal.fire(
  						  '發生錯誤',
  						  '價位區間大小錯誤',
  						  'error'
  						) 
    			}
    		}
    	}

	</script>
	<header>
	</header>

	<div class="standard_nav"
	style="margin-right:20px;width: 200px; height: fit-content; float: left;">
	</div>
	<fieldset class='fieldset_st'>

        <h1 style="font-size: xx-large;color: #000079;">請選擇條件</h1>
        <div>
        <form style="font-size: xx-large;font-weight: bold;margin-left: 50px;width: fit-content;line-height: 1.5;color: #003E3E;"
            action="AdvancedSearch" method="POST" onsubmit="return handleData()" id="form1">

				<label>英文名字: </label>&emsp;&thinsp;<input type='text' onblur="checkEname()" id='E_name' name='E_name'><br>	
				<label>中文名字: </label>&emsp;&thinsp;<input type='text' onblur="checkCname()" id='C_name' name='C_name'><br>
				<label>創作者: </label>&emsp;&emsp;<input type='text' onblur="checkGmaker()" id='G_maker' name='G_maker'><br>
				<label>插畫家: </label>&emsp;&emsp;<input type='text' onblur="checkiss()" id='iss' name='iss'><br>
				
            	<div>
            	<label>類型:</label>
<!--             	<span  style="visibility:hidden; color:red;font-size:20px;background-color:white" id="chk_option_error"></span> -->
            	</div>
            	<div style='font-size:20px;color:#642100;'>
            	競速<input type='checkbox' name="Cata1[]" value='1'>
            	言語<input type='checkbox' name="Cata1[]" value='2'>
				大腦<input type='checkbox' name="Cata1[]" value='3'>
				紙牌<input type='checkbox' name="Cata1[]" value='4'>
				讀物<input type='checkbox' name="Cata1[]" value='5'>
				猜心<input type='checkbox' name="Cata1[]" value='6'>
				巧手<input type='checkbox' name="Cata1[]" value='7'>
				派對<input type='checkbox' name="Cata1[]" value='8'>
				骰子<input type='checkbox' name="Cata1[]" value='9'>
				樂齡<input type='checkbox' name="Cata1[]" value='10'><br>
				陣營<input type='checkbox' name="Cata1[]" value='14'>
				兒童<input type='checkbox' name="Cata1[]" value='15'>
				合作<input type='checkbox' name="Cata1[]" value='16'>
				周邊<input type='checkbox' name="Cata1[]" value='19'>
				6人+<input type='checkbox' name="Cata1[]" value='18'>
				1-2人<input type='checkbox' id='cata11' name="Cata1[]" value='17'>
				重策略<input type='checkbox' id='cata12' name="Cata1[]" value='11'>
				中策略<input type='checkbox' name="Cata1[]" value='12'>
				輕策略<input type='checkbox' id='cata13' name="Cata1[]" value='13'>
				</div>
				<div>
				<label>科目:</label>
<!-- 				<span  style="visibility:hidden; color:red;font-size:20px;" id="chk_option_error"></span> -->
				</div>
				<div style='font-size:20px;color:#642100;'>
				自然<input type='checkbox' id='cata21' name="Cata2[]" value='1'>
				社會<input type='checkbox' id='cata22' name="Cata2[]" value='2'>
				科技<input type='checkbox' id='cata23' name="Cata2[]" value='3'>
				健體<input type='checkbox' name="Cata2[]" value='4'>
				綜合<input type='checkbox' name="Cata2[]" value='5'>
				語文<input type='checkbox' name="Cata2[]" value='6'>
				數學<input type='checkbox' name="Cata2[]" value='7'>
				藝術<input type='checkbox' name="Cata2[]" value='8'>
				</div>
				價錢: <input style='width:150px;' type='text' onblur="checkprice();" id='Price'  name='Price'><span> ~ </span><input style='width:150px;' type='text' onblur="checkprice1();" id='Price1' name='Price1' required><span style='font-size:20px;color:#FF0000;margin-top:1px'>(請輸入正整數)</span><br>

            <br>
				<input class="btn_rep_st" type="submit" value="送出">
            	<input class="btn_rep_st" type="reset" value="清除">
            	<button class="btn_rep_st" type='button' onclick='fastInsert1()'>一鍵輸入</button>
				<button class="btn_rep_st" style="width:120px;" type='button' onclick='fastInsert2()'>一鍵輸入二</button>
        </form>
        </div>

    </fieldset>
	<div class='display_div'>
		<img style='width:800px;height:900px;' src="${pageContext.request.contextPath}/images/組合圖片.png">
	</div>


<footer class="footer_body">
</footer>
</body>

</html>