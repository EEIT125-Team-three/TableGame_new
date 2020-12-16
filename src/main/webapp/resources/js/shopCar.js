var doWhich = "";
var productId = "";
var member = 10;
var show = -1;
var totalMoney = 0;
var randomlist = [];
var buylist = [];
$(document).ready(function(){
    $(".shopCar_button").each(function(){
        $(this).click(function(){
            $(this).css("background-color", "gray").siblings("button").css("background-color", "white")
			show = $(this).index();
        })
    }).eq(0).css("margin-left", "500px").css("background-color", "gray")
	dataLink();
})

function dataLink(){ //新增後端傳來的元素
	$.ajax({
		url:"shopCarajax",
		data: {
			'productId':productId,
			'doWhich':doWhich,
			'member':member,
			'buyHowmuch':1,
			'show':show
		},
		dataType: 'json',
		type:'POST',
		success : function(htmlobj, Object){
			if(show == -1){
				$(".shopCar_div6").each(function(){
					var s = Math.ceil(Math.random()*htmlobj.length);
					if(randomlist.indexOf(s) < 0){
						randomlist.push(s)
						$(this).children("img").attr("src", htmlobj[s].img_url)
						$(this).children("button").attr("product", htmlobj[s].productId).click(function(){
							addTolist($(this).attr("product"));		
						})
					}
				})
			}
			else if(show == 0){
				$("")
			}
		},
		error:function(){
			console.log("bbb");
		}	
	})
}
function addTolist(productId){
	console.log("s")
	this.productId = productId;
	doWhich = "insert";
}
function createTable(){ //建立完整的Table
	$('#list').html('<caption><td style="width: 44px;" id="menuBuy">序號</td><td style="width: 101px;" id="menuBuy">商品圖</td><td style="width: 443px;" id="menuBuy">商品名稱</td><td style="width: 90px;" id="menuBuy">單價</td><td style="width: 98px;" id="menuBuy">數量</td><td style="width: 90px;" id="menuBuy">小計</td><td style="width: 76px;" id="menuBuy">變更</td></caption>');
	totalMoney = 0;
	if(AllBuy.length != 0){
		if(AllBuy.length > 6){
			$("#WhichBuy").css("height","500px")
		}
		else{
			$("#WhichBuy").css("height","auto")
		}
		for(let i = 0; i < AllBuy.length; i++){
			$('#list').append('<tr id="data' + i + '"><td>' + (i+1) + '</td><td><img src="' + AllBuy[i][0] + '"></td>')
			$('#list').append('')
			$('#list').append()
			$('#list').append()
			$('#list').append()
			$('#list').append()
			$('#list').append()
			$('#list').append()
//			s += '';
//			s += '<td>' + AllBuy[i][1] + '</td>';
//			s += '<td>' + AllBuy[i][2] + '</td>';
//			s += '<td><button id=countDel' + i + ' style="width:3px;">-</button><input type="text" value="' + AllBuy[i][3] + '" style="width:20px; text-align:center;" id="countSelect' + i + '"><button id=countAdd' + i + ' style="width:3px;">+</button></td>';
//			s += '<td>' + AllBuy[i][2]*AllBuy[i][3] + '</td>';
//			s += '<td><button type="button" id="add' + i + '">追蹤</button><br><button type="button" id="del' + i + '">刪除</button></td>';
//			s += '</tr>';
			totalMoney += AllBuy[i][2]*AllBuy[i][3];
		}
//		document.getElementById('buyList').innerHTML += s;
//		createListen();
	}
//	SetTotalMoney();
}