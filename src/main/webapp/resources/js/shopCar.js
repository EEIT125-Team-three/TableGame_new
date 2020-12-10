let AllBuy = [];
let WaitToDo = [];
let AllList = [];
var NowShow = "ShopCar";
var user;
var re = /^[0-9]+$/;
var doWhich = "";
var CName="";
var EName="";
var buyHowmuch = 1;
$(document).ready(function(){
	function checkData() {
		let j=0;
		for(;j<AllBuy.length;j++){	
			if(AllBuy[j][4] == EName){
				alert("該商品已存在");
				break;
			}
		}
		if(j==AllBuy.length){
			doWhich = "insert";
			backToFace();
		}
	}

	function backToFace(){ //新增後端傳來的元素
		$.ajax({
			withCredentials:true,
			url:"test",
			data: {
				'C_Name':CName,
				'doWhich':doWhich,
				'user':user,
				'buyHowmuch':buyHowmuch,
				'EName':EName,
				},
			dataType: 'json',
			async:false,
			type:'POST',
			success : function(htmlobj){
				switch(doWhich){
					case "":
						user = "Visitors" + htmlobj[0].Visitors;
					case "insert":
						for(let a=0;a< htmlobj.length; a++){
							let s = htmlobj[a]
							AllBuy.push([s.imgUrl.toString(),s.message.toString(),s.price.toString(),s.buyHowmuch.toString(),s.E_Name.toString()])	   	  					
						}
						break;
					case "delete":
						break;
					case "update":
						break;
					default:
						break;
				}
				if(doWhich != ""){
					createTable();
				}
			},
			error:function(){console.log("bbb")}
		});
	}
	
	$(document).ready(function(){
			backToFace();
			for(let i=0;i<AllBuy.length;i++){
				AllList.push(AllBuy[i]);
			}
			AllBuy.length=0;
			for(let j=0;WaitToDo.length<6;){
				j = Math.floor(Math.random()*AllList.length);
				if(AllList[j][2]!=0){
					WaitToDo.push(AllList[j]);
				}
				AllList.splice(j,1);
			}
			let i=0;
			$("#myDiv").children().each(function(){
				$(this).children("img").attr("src",WaitToDo[i][0])
				$(this).children("button").attr("id",WaitToDo[i][4]).click(function(){
					EName = $(this).attr("id");
					checkData();
				})
				i++;
				})
			WaitToDo.length = 0;
		$("#showAnother").click(function(){
			for(let j=0;WaitToDo.length<6;){
			j = Math.floor(Math.random()*AllList.length);
			if(AllList[j][2]!=0){
				WaitToDo.push(AllList[j]);
			}
			AllList.splice(j,1);
			}
			let i=0;
			$("#myDiv").children().each(function(){
				$(this).children("img").attr("src",WaitToDo[i][0])
				$(this).children("button").attr("id",WaitToDo[i][4])
				i++;
			})
		WaitToDo.length = 0;
	})
	})
	$("article").children("button").each(function(){
		$(this).click(function(){
			$(this).css("background-color","gray").siblings("button").css("background-color","white").css("border","0");
		})
	})
	function delTitle(){    //隱藏表格標題(如果沒有AllBuy資料的畫執行)
		for(let i=0; i<document.querySelectorAll("#menuBuy").length;i++){
			document.querySelectorAll("#menuBuy")[i].style.display="none";
		}
	}
	function showTitle(){   //顯示表格標題
		for(let i=0; i<document.querySelectorAll("#menuBuy").length;i++){
			document.querySelectorAll("#menuBuy")[i].style.display="";
		}
	}
	function delList(c){    //刪除特定元素
		EName = AllBuy[c][4];
		doWhich = "delete";
		backToFace();
		AllBuy.splice(c,1);
		createTable();
	}
	function SetTotalMoney(){   //顯示於下方的總金額
		if(totalMoney > 0){
			document.getElementById('totalMoney').innerHTML = ("目前金額共" + totalMoney + "元");
		}
		else{
			document.getElementById('totalMoney').innerHTML = ("您還未選購商品，下方有各種推薦商品可以選擇");
		}
	}
	function BuyUp(c){
		document.getElementById('countSelect' + c).value++;
		BuySelect(c);
	}
	function BuyDown(c){
		document.getElementById('countSelect' + c).value--;
		BuySelect(c);
	}
	function BuySelect(c){
		if(re.test(document.getElementById('countSelect' + c).value)){
			AllBuy[c][3] = document.getElementById('countSelect' + c).value;
		}
		if(AllBuy[c][3] == 0){
			delList(c);
		}
		else{
			EName = AllBuy[c][4];
			doWhich = "updata";
			buyHowmuch = AllBuy[c][3];
			backToFace();
			buyHowmuch = 1;
			createTable();		
		}
	}
	function createTable(){ //建立完整的Table
		document.getElementById('buyList').innerHTML = "";
		totalMoney = 0;
		if(AllBuy.length != 0){
			if(AllBuy.length > 6){
				$("#WhichBuy").css("height","500px")
			}
			else{
				$("#WhichBuy").css("height","auto")
			}
			let s = '<caption><td style="width: 44px;" id="menuBuy">序號</td><td style="width: 101px;" id="menuBuy">商品圖</td><td style="width: 443px;" id="menuBuy">商品名稱</td><td style="width: 90px;" id="menuBuy">單價</td><td style="width: 98px;" id="menuBuy">數量</td><td style="width: 90px;" id="menuBuy">小計</td><td style="width: 76px;" id="menuBuy">變更</td></caption>';
			for(let i = 0; i < AllBuy.length; i++){
				s += '<tr id="data' + i + '">';
				s += '<td>' + (i+1) + '</td>';
				s += '<td><img src="' + AllBuy[i][0] + '"></td>';
				s += '<td>' + AllBuy[i][1] + '</td>';
				s += '<td>' + AllBuy[i][2] + '</td>';
				s += '<td><button id=countDel' + i + ' style="width:3px;">-</button><input type="text" value="' + AllBuy[i][3] + '" style="width:20px; text-align:center;" id="countSelect' + i + '"><button id=countAdd' + i + ' style="width:3px;">+</button></td>';
				s += '<td>' + AllBuy[i][2]*AllBuy[i][3] + '</td>';
				s += '<td><button type="button" id="add' + i + '">追蹤</button><br><button type="button" id="del' + i + '">刪除</button></td>';
				s += '</tr>';
				totalMoney += AllBuy[i][2]*AllBuy[i][3];
			}
			document.getElementById('buyList').innerHTML += s;
			createListen();
		}
		SetTotalMoney();
	}
	
	if(AllBuy.length != 0){
		createTable();
	}
	
	function createListen(){
		for(let i=0; i<AllBuy.length; i++){
			//document.getElementById('add' + i).addEventListener('click',); //加入追蹤清單
			document.getElementById('del' + i).addEventListener('click',function(){
				delList(i);
			});
			document.getElementById('countAdd' + i).addEventListener('click',function(){
				BuyUp(i);
			});
			document.getElementById('countDel' + i).addEventListener('click',function(){
				BuyDown(i);
			});
			document.getElementById('countSelect' + i).addEventListener('change',function(){
				BuySelect(i);
			});
		}
	}
})