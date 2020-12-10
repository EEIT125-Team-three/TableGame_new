<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/header_style.css">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30=" crossorigin="anonymous"></script>
<script src="jtable.2.4.0/jquery.jtable.js	" type="text/javascript" ></script>

<title>討論區-大腦類</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

body, input {
	font-size: 16px;
	line-height: 24px;
	color: black;
	font-family: Microsoft yahei, Song, Arial, Helvetica, Tahoma, Geneva;
}

h1 {
	margin-bottom: 15px;
	height: 100px;
	line-height: 100px;
	text-align: center;
	font-size: 30px;
	color: black;
}

#content #post, #comment p {
	zoom: 1;
}

#content #post:after, #comment p:after {
	display: block;
	height: 0;
	clear: both;
	visibility: hidden;
	overflow: hidden;
	content: '.';
}

.transition {
	-webkit-transition: all 0.5s linear;
	-moz-transition: all 0.5s linear;
	-o-transition: all 0.5s linear;
	-ms-transition: all 0.5s linear;
	transition: all 0.5s linear;
}

#content {
	margin: 0 auto;
	width: 960px;
	overflow: hidden;
}

#content #post {
	margin-bottom: 15px;
	padding-bottom: 15px;
	border-bottom: 1px #d4d4d4 dashed;
	height: 556px;
}

#content #post textarea {
	display: block;
	margin-bottom: 10px;
	padding: 5px;
	width: 948px;
	height: 390px;
	border: 1px #d1d1d1 solid;
	border-radius: 5px;
	resize: none;
	outline: none;
}

#content #post textarea:hover {
	border: 1px #9bdf70 solid;
	background: #f0fbeb;
}

#content #post #postBt, #content #post #clearBt, #content #post #updateBt
	{
	margin-left: 10px;
	margin-right: 5px;
	padding: 3px;
	float: right;
}

#comment {
	overflow: hidden;
}

#comment p {
	margin-bottom: 10px;
	padding: 10px;
	border-radius: 5px;
}

#comment p:nth-child(odd) {
	border: 1px solid #e3e197;
	background: #ffd;
}

#comment p:nth-child(even) {
	border: 1px solid #adcd3c;
	background: #f2fddb;
}

/*#comment p span{display:inline; float:left;}*/
#comment p .right {
	text-align: right;
}

#comment p .msg {
	width: 738px;
}

#comment p .datetime {
	width: 200px;
	color: #999;
	text-align: right;
}


</style>

<script type="text/javascript">
	var Mes=[]; 
	var Mesu=[];
	var id;
	var action;
	var comment;
	var time ;
</script>


<script type="text/javascript">
	var named = "匿名發言者";
	function delete1(id) {
		localStorage.removeItem(id);
		this.Storage.writeData();
		
		console.log(id);
		window.id=id ;
		action = "delete";
		comment = ""; 
		
		
		ftb();
		console.log("11111");
	}

	function update1(id) {
		var change = window.prompt("請編輯", "");
		if (localStorage.getItem((id)).split("|")[2].substring(localStorage
				.getItem((id)).split("|")[2].length - 5) == "(已編輯)") {
			localStorage.setItem(id, change + "|"
					+ localStorage.getItem((id)).split("|")[1] + "|"
					+ localStorage.getItem((id)).split("|")[2])
			time = localStorage.getItem((id)).split("|")[2].substring(0,localStorage
					.getItem((id)).split("|")[2].length - 5)	;
		} else {
			localStorage.setItem(id, change + "|"
					+ localStorage.getItem((id)).split("|")[1] + "|"
					+ localStorage.getItem((id)).split("|")[2] + "(已編輯)")
			time = localStorage.getItem((id)).split("|")[2];
		}
		console.log(localStorage.key(id))
		this.Storage.writeData();
		window.id = id;
		action = "update";
		comment = change;
		
		ftb();
	}

	function prom() {

		var name = prompt("請輸入您的名字", "");//將輸入的內容賦給變量 name ，
		named = name;
		//這里需要注意的是，prompt有兩個參數，前面是提示的話，后面是當對話框出來后，在對話框里的默認值

		if (named != "匿名發言者")//如果返回的有內容

		{

			alert("歡迎您：" + name)
			document.getElementById("shangtian").style.display = "none";
			document.getElementById("ritian").value = named;

		} else {
			document.getElementById("ritian").value = "匿名發言者";
		}

	}
	var Storage = {
		saveData : function()//保存數據
		{

			var data = document.querySelector("#post textarea");
			if (data.value != "") {
				time = new Date().getTime() + Math.random() * 5;//getTime是Date對象中的方法，作用是返回 1970年01月01日至今的毫秒數
				var now = this.getDateTime();
				localStorage.setItem(time, data.value + "|" + named + "|" + now);//將毫秒數存入Key值中，可以降低Key值重復率
				Mes.push([time, named, data.value, now])
				id = time;
				comment = data.value;
				user = named;
				time = now;
				action = "insert";
				ftb();
				data.value = "";
				this.writeData();
			} else {
				alert("請填寫您的留言！");
			}
		},
		writeData : function()//輸出數據
		{
			var dataHtml = "", data = "";
			for (var i = localStorage.length - 1; i >= 0; i--)//效率更高的循環方法
			{
				data = localStorage.getItem(localStorage.key(i)).split("|");

				//dataHtml += "<p><span class=\"msg\">" + data[0] + "</span><span class=\"datetime\">" + data[1] + "</span><span>" + data[2]+"</span></p>";
				dataHtml += "<span style=>"
						+ data[1]
						+ "<span style=\"float:right\">"
						+ data[2]
						+ "</span><p><span class=\"msg\">"
						+ data[0]
						+ "<input style=\"float:right;border:soild 5px darkgreen;border-radius:5px;\" type=\"button\" onclick=\"delete1("
						+ localStorage.key(i)
						+ ");\" value=\"刪除\"/>"
						+ "<input style=\"float:right;border:5px soild darkgreen;border-radius:5px;\" type=\"button\" onclick=\"update1("
						+ localStorage.key(i) + ");\" value=\"編輯\"/>"
						+ "</span></p>";
			}
			document.getElementById("comment").innerHTML = dataHtml;
		},
		clearData : function()//清空數據
		{
			if (localStorage.length + 1 > 0) {
				if (window.confirm("清空後不可恢復，是否確認清空？")) {
					localStorage.clearData();	
					this.writeData();
				}
			} else {
				alert("沒有需要清空的數據！");
			}
		},
		updateData : function()//更新數據
		{
			console.log($(this).parent("span"))
			$(this).parent("span").html("123")
				var input = document.getElementsById("comment");
				input.value = value;
				Mesu.push([time, named, input.value, now])
				id = time;
				comment = input.value;
				user = named;
				time = now;
				action = "update";
				upd();
				input = "";
				this.writeData();
		},
		getDateTime : function()//獲取日期時間，例如 2012-03-08 12:58:58
		{
			var isZero = function(num)//私有方法，自動補零
			{
				if (num < 10) {
					num = "0" + num;
				}
				return num;
			}

			var d = new Date();
			return d.getFullYear() + "-" + isZero(d.getMonth() + 1) + "-"
					+ isZero(d.getDate()) + " " + isZero(d.getHours()) + ":"
					+ isZero(d.getMinutes()) + ":" + isZero(d.getSeconds());
		}
	}

	window.onload = function() {
		let user = "";
		let time = "";
		let data = "";
		Storage.writeData();//當打開頁面的時候，先將localStorage中的數據輸出一邊，如果沒有數據，則輸出空
		let s;
        for(let i=0;i<localStorage.length;i++){
         s = localStorage.getItem(localStorage.key(i)).split("|");
         Mes.push([localStorage.key(i), s[1], s[0], s[2]]);
        }
        console.log(Mes)
		document.getElementById("postBt").onclick = function() {
			Storage.saveData();
		}//發表評論按鈕添加點擊事件，作用是將localStorage中的數據輸出
		document.getElementById("clearBt").onclick = function() {
			Storage.clearData();
		}//清空所有已保存的數據
		document.getElementById("updateBt").onclick = function() {
			Storage.updateData();
			
		}//編輯所有已保存的數據
	}
</script>
</head>

<body>

	<header>
		<div>
			<ul class="listst1">
				<li>
					<p class="titlest">
						<big><big><big>享玩 桌遊</big></big> </big>
					</p>
				</li>
				<p style="font-size: larger; font-weight: bold;">
					<big>讓因桌遊而產生的歡笑&emsp;充滿生命中的每分每秒</big>
				</p>
			</ul>
		</div>
		<hgroup>
			<h2 style="width: fit-content;">放輕心情</h2>
			<h2 style="width: fit-content;">&emsp;&emsp;&emsp;&emsp;享受與親友</h2>
			<h2 style="width: fit-content;">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;共同度過的桌遊時光</h2>
		</hgroup>
		<nav>
			<div>
				<span style="margin-left: 100px;">網站起源</span> <span>最新消息</span> <span>分類檢索</span>
				<span>購物車</span> <span>討論區</span> <span>會員中心</span> <span>聯絡我們</span>
			</div>
		</nav>

	</header>
	<h1>討論區-大腦類</h1>
	<form>
		<div id="content">

			<div id="post">
			<div >
				<div style="background: rgb(255, 255, 204); height: 30px;">
					<big style="font-weight: bolder;" >匿稱：</big><input type="submit"
						id="shangtian" name="Submit3"
						style="border: none; background-color: rgb(255, 229, 153); color: black;"
						value="默認用戶點擊改變" onclick="prom()" /> <input type="text"
						id="ritian"
						style="border: none; background-color: rgb(255, 255, 204); color: black;"
						onclick="prom()" />
					<!--disabled="disabled"-->
				</div>
				</div>
				<div>
					<textarea class="transition" ></textarea>
				</div>
				<div >
				<input id="postBt" type="submit" 
					style="border: none; background-color: #3EADC5; color: white; border-radius: 5px; width: 80px; height: 30px;"
					value="發表留言" /></div>
					<div>
					 <input id="clearBt" type="reset"
					style="border: none; background-color: #3EADC5; color: white; border-radius: 5px; width: 80px; height: 30px;"
					value="清空" /></div>
			</div>
			<div id="comment"></div>
		</div>
	</form>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>


	<script>
	function ftb(){
		$.ajax({
			url:"disservlet",
			data: {
	  				'id':id,
	  				'action':action,
	  				'comment':comment,
	  				'user':named,
	  				'time':time
	  				},
	  		dataType: 'json',
	  		async:true,
	  		type:'POST',
	  		success : function(htmlobj){
	  			switch(action){
	  				case "insert":
	  					named = "匿名發言者";
	  			}
	  			
	  		}
		})
	}
	</script>
	
</body>

</html>

