var doWhich = "";
var productId = 3;
var show = 0;
var totalMoney = 0;
var randomlist = [];
var buylist = [];
var likelist = [];
var buyHowmuch = 1;
$(document).ready(function(){	
    $(".shopCar_button").each(function(){
        $(this).click(function(){
            $(this).css("background-color", "gray").siblings("button").css("background-color", "white")
			show = $(this).index();
			dataLink();
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
			'buyHowmuch':buyHowmuch,
			'show':show
		},
		dataType: 'json',
		type:'POST',
		success : function(htmlobj, Object){
			if(show == -1){
				$(".shopCar_div6").each(function(){
					while(true){
						var s = Math.ceil(Math.random()*htmlobj.length);
						console.log(buylist)
						if(randomlist.indexOf(s) < 0 && buylist.indexOf(s) < 0){
							randomlist.push(s)
							$(this).children("img").attr("src", htmlobj[s].img_url)
							$(this).children("button").attr("productId", htmlobj[s].productId).click(function(){
								addTolist($(this).attr("productId"));
							})
							break;		
						}
					}
				})
				show = 0;
			}
			else if(show == 0){
				if(doWhich == ""){
					if(htmlobj.length > 0){
						createTable(htmlobj);
					}
					else{
						$(".shopCar_span").html('您還未選購商品，下方有各種推薦商品可以選擇');
					}
					show = -1;
					dataLink();
				}
				else if(doWhich == "insert"){
					createTable(htmlobj);			
				}
				else if(doWhich == "update"){
					getquantity();
				}
				else if(doWhich == "delete"){
					createTable(htmlobj);
				}
			}
		},
		error:function(){
			console.log("bbb");
		}	
	})
}

function getquantity(){
	$.ajax({
		url:"shopCarajaxquantity",
		dataType: 'json',
		type:'POST',
		success : function(htmlobj, Object){
			$("tr").each(function(){
				if(htmlobj[$(this).attr("id")]){
					var d = htmlobj[$(this).attr("id")];
					$(this).children("td").eq(4).children("input").attr("value", d).val(d)
					.parent().next().each(function(){
						$(this).html(parseInt(d)*parseInt($(this).prev().prev().html()))
					})
				}
			})
			setTotalMoney();
		}
	})
}
function addTolist(productId){
	if(buylist.indexOf(parseInt(productId)) < 0){
		this.productId = productId;
		doWhich = "insert";
		let now = show;
		show = 0;
		dataLink();	
		show = now;
	}
}

function createTable(htmlobj){
	totalMoney = 0;
	if(buylist.length == 0 && htmlobj.length >0){
		var s = '<thead><th style="width: 44px;">序號</th><th style="width: 101px;">商品圖</th><th style="width: 443px;">商品名稱</th><th style="width: 90px;">單價</th><th style="width: 98px;">數量</th><th style="width: 90px;">小計</th><th style="width: 76px;">變更</th></thead>';
		$('.shopCar_list').html(s);
	}
	var s = "";
	for(var i=0; i<htmlobj.length; i++){
		s += '<tr id="' + htmlobj[i].productId + '"><td>' + (buylist.length+1) + '</td>';
		s += '<td><img src="' + htmlobj[i].img_url + '" style="width: 101px;"></td>';
		s += '<td>' + htmlobj[i].c_name + '</td>';
		s += '<td>' + htmlobj[i].price + '</td>';
		s += '<td><button style="width:3px;">-</button><input type="text" value="' + buyHowmuch + '" style="width:20px; text-align:center;"><button style="width:3px;">+</button></td>';
		s += '<td>' + htmlobj[i].price*buyHowmuch + '</td>';
		s += '<td><button type="button" id="add' + i + '">追蹤</button><br><button type="button" id="del' + i + '">刪除</button></td></tr>';
		buylist.push(htmlobj[i].productId);
	}
	$('.shopCar_list').append(s);
	getquantity();
	addevent();
}

function setTotalMoney(){
	if(buylist.length > 0){
		$(".shopCar_list").children("tr").each(function(){
			totalMoney += parseInt($(this).children().eq(5).text());
		})
		$(".shopCar_span").html("小計" + totalMoney + "元");
		if(buylist.length > 4){
			$('.shopCar_div2').css("height", "555px").css("overflow", "scroll");
		}
	}
	else{
		$(".shopCar_span").html('您還未選購商品，下方有各種推薦商品可以選擇');
	}
}

function addevent(){
	$(".shopCar_list").children("tr").each(function(){
		$(this).children().eq(4).children().each(function(){
			$(this).unbind();
		})
		.eq(0).click(function(){
			//變更值(-)
			$(this).parent().children("input").each(function(){
				if($(this).attr("value") != 1){
					$(this).attr("value", parseInt($(this).attr("value"))-1).val($(this).attr("value"))
					doWhich = "update";
					buyHowmuch = $(this).attr("value");
					productId = $(this).parent().parent().attr("id");
					dataLink();
				}
				else{
					if(confirm("確認移除此款桌遊嗎?")){
						buylist.splice(0, buylist.length);
						doWhich = "delete";
						productId = $(this).parent().parent().attr("id");
						$("table").html("").parent().css("height", "auto").css("overflow", "");
						dataLink();
					}
				}
			})
		})
		.parent().children().eq(2).click(function(){
			//變更值(+)
			$(this).parent().children("input").each(function(){
				$(this).attr("value", parseInt($(this).attr("value"))+1).val($(this).attr("value"))
				doWhich = "update";
				buyHowmuch = $(this).attr("value");
				productId = $(this).parent().parent().attr("id");
				dataLink();
			})
		})
		.parent().children().eq(1).change(function(){
			//變更值(手動輸入)
			if($(this).val() < 1){
				if($(this).val() == 0){
					
				}
				else{
					console.log($(this).attr("value", $(this).val()))
					doWhich = "update";
					buyHowmuch = $(this).attr("value");
					productId = $(this).parent().parent().attr("id");
					dataLink();
				}
			}
			
		})
		.parent().next().next().children("button").each(function(){
			$(this).unbind();
		})
		.eq(0).click(function(){
			//加入追蹤清單
			likelist.push(parseInt($(this).parent().parent().attr("id")));
			buylist.splice(0, buylist.length);
			dataLink();
		})
		.parent().children("button").eq(1).click(function(){
			//刪除
			if(confirm("確認移除此款桌遊嗎?")){
				buylist.splice(0, buylist.length);
				doWhich = "delete";
				productId = $(this).parent().parent().attr("id");
				$("table").html("").parent().css("height", "auto").css("overflow", "");
				dataLink();
			}
		})
	})
}