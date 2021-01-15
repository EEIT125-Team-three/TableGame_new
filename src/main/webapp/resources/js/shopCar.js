var productId = 3;
var totalMoney = 0;
var randomlist = [];
var buylist = [];
var likelist = [];
var buyHowmuch = 1;
$(document).ready(function(){	
    $(".shopCar_button").each(function(){
        $(this).click(function(){
            $(this).css("background-color", "gray").siblings("button").css("background-color", "white")
			buylist = [];
			if($(this).index() == 1){
				$(".shopCar_div2").children("table").attr("class", "shopCar_list");
				$("table").html("").parent().css("height", "auto").css("overflow", "");
				selectAllFromShopCar();
			}
			if($(this).index() == 2){
				if($(".header_span2").eq(1).children("button").html() == "登入"){
					$(".header_span1").eq(5).children("a")[0].click();
				}
				$(".shopCar_div2").children("table").attr("class", "track_list");
				$("table").html("").parent().css("height", "auto").css("overflow", "");
				selectAllFromTrackList();
			}
        })
    }).eq(0).css("margin-left", "500px").css("background-color", "gray")
	getShowProduct();
	
})

function insertToShopCar(){
	$.ajax({
		url:"insertToShopCarAjax",
		data: {
			'productId':productId,
			'buyHowmuch':buyHowmuch
		},
		dataType: 'json',
		type:'POST',
		success : function(htmlobj, Object){
			createTableBuyList(htmlobj);
//			createTableBuyList_small(htmlobj);
		}
	})
}

function deleteFromShopCar(){
	$.ajax({
		url:"deleteFromShopCarAjax",
		data: {
			'productId':productId,
		},
		dataType: 'json',
		type:'POST',
		success : function(htmlobj){
			createTableBuyList(htmlobj);
		}
	})
}

function updateFromShopCar(){
	$.ajax({
		url:"updateFromShopCarAjax",
		data: {
			'productId':productId,
			'buyHowmuch':buyHowmuch
		},
		dataType: 'json',
		type:'POST',
		success : function(htmlobj, Object){
			getquantity();
		}
	})
}

function selectAllFromShopCar(){
	$.ajax({
		url:"selectAllFromShopCarAjax",
		dataType: 'json',
		type:'POST',
		success : function(htmlobj, Object){
			createTableBuyList(htmlobj);
		}
	})
}

function getShowProduct(){
	$.ajax({
		url:"getShowProductAjax",
		dataType: 'json',
		type:'POST',
		success : function(htmlobj, Object){
			selectAllFromShopCar();		
			$(".shopCar_div6").each(function(){
				while(true){
					var s = Math.ceil(Math.random()*htmlobj.length);
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
		}
	})
}

function addToTrackList(){	
	$.ajax({
		url:"addToTrackListAjax",
		data: {
			'productId':productId,
			'buyHowmuch':buyHowmuch,
		},
		dataType: 'json',
		type:'POST',
		success: function(htmlobj){
			createTableBuyList(htmlobj);
		}
	})
}

function selectAllFromTrackList(){
	$.ajax({
		
	})
	$.ajax({
		url:"selectAllFromTrackListAjax",
		data: {
			'productId':productId,
			'buyHowmuch':buyHowmuch,
		},
		dataType: 'json',
		type:'POST',
		success: function(htmlobj){
			createTableTrackList(htmlobj);
		}
	})
}

function getquantity(){
	totalMoney = 0;
	$.ajax({
		url:"shopCarAjaxQuantity",
		dataType: 'json',
		type:'POST',
		success : function(htmlobj){
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
function trackToShopCar(){
	//這裡
	$.ajax({
		url: 'trackToShopCarAjax',
		type: 'POST',
		dataType: 'json',
		data: {
			productId: productId
		},
		success: function(htmlobj){
			createTableTrackList(htmlobj);
		}
	})
}

function deleteFromTrackList(){
	//這裡
	$.ajax({
		url: 'deleteFromTrackListAjax',
		type: 'POST',
		dataType: 'json',
		data: {
			productId: productId
		},
		success: function(htmlobj){
			createTableTrackList(htmlobj);
		}
	})
}

function addTolist(productId){
	if(buylist.indexOf(parseInt(productId)) < 0){
		this.productId = productId;
		buyHowmuch = 1;
		insertToShopCar();
	}
}

function createTableBuyList(htmlobj){
	totalMoney = 0;
	if(buylist.length == 0){
		$('.shopCar_list').html("");
		if(htmlobj.length >0){
			var s = '<thead style="background-color:#FFE153;"><th style="width: 44px;">序號</th><th style="width: 101px;">商品圖</th><th style="width: 443px;">商品名稱</th><th style="width: 90px;">單價</th><th style="width: 98px;">數量</th><th style="width: 90px;">小計</th><th style="width: 76px;">變更</th></thead>';
			$('.shopCar_list').html(s);
		}
	}
	var s = "";
	for(var i=0; i<htmlobj.length; i++){
		s += '<tr id="' + htmlobj[i].productId + '"><td>' + (buylist.length+1) + '</td>';
		s += '<td><img src="' + htmlobj[i].img_url + '" style="width: 101px;"></td>';
		s += '<td>' + htmlobj[i].c_name + '</td>';
		s += '<td>' + htmlobj[i].price + '</td>';
		s += '<td><button style="width:30px;background-color:#006030;color:#FFD306;">十</button><br><input type="text" value="' + buyHowmuch + '" style="width:20px; text-align:center;" max="' + htmlobj[i].storage +'"><br><button style="width:30px;background-color:#006030;color:#FFD306;">一</button></td>';
		s += '<td>' + htmlobj[i].price*buyHowmuch + '</td>';
		s += '<td><button style="background-color:#006030;color:#FFD306;border-radius:10px;" type="button" id="add' + i + '">加入追蹤</button><br><br><button style="background-color:#006030;color:#FFD306;border-radius:10px;" type="button" id="del' + i + '">&nbsp;&nbsp;刪&nbsp;&nbsp;&nbsp;&nbsp;除&nbsp;&nbsp;</button></td></tr>';
		buylist.push(htmlobj[i].productId);
	}
	$('.shopCar_list').append(s);
	getquantity();
	addBuyListEvent();
}

function createTableTrackList(htmlobj){
	$('.track_list').html("");
	if(htmlobj.length >0){
		if(htmlobj.length >4){
			$('.shopCar_div2').css("height", "555px").css("overflow", "scroll");
		}
		var s = '<thead style="background-color:#FFE153;"><th style="width: 44px;">序號</th><th style="width: 101px;">商品圖</th><th style="width: 631px;">商品名稱</th><th style="width: 90px;">單價</th><th style="width: 76px;">變更</th></thead>';
		$('.track_list').html(s);
		s = ""
		for(var i=0; i<htmlobj.length; i++){
			s += '<tr id="' + htmlobj[i].productId + '"><td>' + (buylist.length+1) + '</td>';
			s += '<td><img src="' + htmlobj[i].img_url + '" style="width: 101px;"></td>';
			s += '<td>' + htmlobj[i].c_name + '</td>';
			s += '<td>' + htmlobj[i].price + '</td>';
			s += '<td><button style="background-color:#006030;color:#FFD306;border-radius:10px;" type="button" id="add' + i + '">加入購物</button><br><br><button style="background-color:#006030;color:#FFD306;border-radius:10px;" type="button" id="del' + i + '">&nbsp;&nbsp;刪&nbsp;&nbsp;&nbsp;&nbsp;除&nbsp;&nbsp;</button></td></tr>';
			likelist.push(htmlobj[i].productId);
		}
		$('.track_list').append(s);
		$(".shopCar_span").html('以上為追蹤清單，購買請加至購物車');
		addTrackListEvent();
	}
	else{
		$(".shopCar_span").html('您目前還沒有任何追蹤商品喔!');
	}
}

function setTotalMoney(){
	if(buylist.length > 0){
		$(".shopCar_list").children("tr").each(function(){
			totalMoney += parseInt($(this).children().eq(5).text());
		})
		$(".shopCar_span").html("小計" + totalMoney + "元" + "<button style='font-size:20px;height:50px; border:2px red solid;background-color:#006030;color:#FFD306;border-radius:10px;'>前往結帳</button>");
		$(".shopCar_span").children("button").click(function(){
			var item = "";
			$(".shopCar_list").children("tr").each(function(){
				item += ($(this).children("td").eq(2).html().split("\<br\>")[0] +" X " + $(this).children("td").eq(4).children("input").attr("value") + "'a'");
			})
			$(".goCheck").eq(0).children("input").eq(0).attr("value", item)
			$(".goCheck").eq(0).attr("action", "goCheck?totalAmount=" + totalMoney).submit();
		})
		if(buylist.length > 4){
			$('.shopCar_div2').css("height", "555px").css("overflow", "scroll");
		}
		else{
			$('.shopCar_div2').css("height", "auto").css("overflow", "");
		}
	}
	else{
		$(".shopCar_span").html('您還未選購商品，下方有各種推薦商品可以選擇');
	}
}

function addBuyListEvent(){
	$(".shopCar_list").children("tr").each(function(){
		$(this).children().eq(4).children().each(function(){
			$(this).unbind();
		})
		.eq(4).click(function(){
			//變更值(-)
			$(this).parent().children("input").each(function(){
				if($(this).attr("value") != 1){
					$(this).attr("value", parseInt($(this).attr("value"))-1).val($(this).attr("value"));
					let s = $(this).parent().prev().prev();
					s.html(s.html().split("<br>")[0]);
					buyHowmuch = $(this).attr("value");
					productId = $(this).parent().parent().attr("id");
					updateFromShopCar();
				}
				else{				
					Swal.fire({
					  title: '確定刪除此遊戲?',
					  text: "",
					  icon: 'question',
					  showCancelButton: true,
					  confirmButtonColor: '#3085d6',
					  cancelButtonColor: '#d33',
					  cancelButtonText: '取消',
					  confirmButtonText: '確定'
					}).then((result) => {
					  if (result.isConfirmed) {
					    Swal.fire(
					      '商品已刪除',
					      '',
					      'success'
					    )
						buylist.splice(0, buylist.length);
						productId = $(this).parent().parent().attr("id");
						$("table").html("").parent().css("height", "auto").css("overflow", "");
						deleteFromShopCar();
					  }
					})
				}
			})
		})
		.parent().children().eq(0).click(function(){
			//變更值(+)
			$(this).parent().children("input").each(function(){
				if($(this).attr("value") != $(this).attr("max")){
					$(this).attr("value", parseInt($(this).attr("value"))+1).val($(this).attr("value"))
					buyHowmuch = $(this).attr("value");
					productId = $(this).parent().parent().attr("id");
					updateFromShopCar();
				}
				else{
					let s = $(this).parent().prev().prev();
					s.html(s.html().split("<br>")[0] + "<br><p style='color: red'>抱歉，該商品已達庫存上限，若需要更多請電洽客服人員進行補貨</p>");
				}
			})
		})
		.parent().children().eq(2).change(function(){
			//變更值(手動輸入)
				if($(this).val() == 0){					
					Swal.fire({
					  title: '確定刪除此遊戲?',
					  text: "",
					  icon: 'question',
					  showCancelButton: true,
					  confirmButtonColor: '#3085d6',
					  cancelButtonColor: '#d33',
					  cancelButtonText: '取消',
					  confirmButtonText: '確定'
					}).then((result) => {
					  if (result.isConfirmed) {
					    Swal.fire(
					      '商品已刪除',
					      '',
					      'success'
					    )
						buylist.splice(0, buylist.length);
						productId = $(this).parent().parent().attr("id");
						$("table").html("").parent().css("height", "auto").css("overflow", "");
						deleteFromShopCar();
					  }
						else{
						$(this).val($(this).attr("value"));
					}
					})

				}
				else if($(this).val() > 0){
						let s = $(this).parent().prev().prev();
					if(parseInt($(this).val()) > parseInt($(this).attr("max"))){
							$(this).val($(this).attr("max"));
						if($(this).attr("max") != $(this).attr("value")){
							$(this).attr("value", $(this).attr("max"));
							s.html(s.html() + "<br><p style='color: red'>抱歉，該商品已達庫存上限，若需要更多請電洽客服人員進行補貨</p>");
							buyHowmuch = $(this).attr("value");
							productId = $(this).parent().parent().attr("id");
							updateFromShopCar();
						}
					}
					else{
						$(this).attr("value", $(this).val());
						s.html(s.html().split("<br>")[0]);
						buyHowmuch = $(this).attr("value");
						productId = $(this).parent().parent().attr("id");
						updateFromShopCar();
					}
						
				}
				else{
					$(this).val($(this).attr("value"))
				}
			
		})
		.parent().next().next().children("button").each(function(){
			$(this).unbind();
		})
		.eq(0).click(function(){
			//加入追蹤清單
			likelist.push(parseInt($(this).parent().parent().attr("id")));
			buylist.splice(0, buylist.length);
			productId = $(this).parent().parent().attr("id");
			buyHowmuch = 1;
			if($(".header_span2").eq(1).children("button").html() == "登入"){
				$(".header_span1").eq(5).children("a")[0].click();
			}
			addToTrackList();
		})
		.parent().children("button").eq(1).click(function(){
			//刪除
			
			Swal.fire({
					  title: '確定刪除此遊戲?',
					  text: "",
					  icon: 'question',
					  showCancelButton: true,
					  confirmButtonColor: '#3085d6',
					  cancelButtonColor: '#d33',
					  cancelButtonText: '取消',
					  confirmButtonText: '確定'
					}).then((result) => {
					  if (result.isConfirmed) {
					    Swal.fire(
					      '商品已刪除',
					      '',
					      'success'
					    )
						buylist.splice(0, buylist.length);
						productId = $(this).parent().parent().attr("id");
						$("table").html("").parent().css("height", "auto").css("overflow", "");
						deleteFromShopCar();
					  }
					})
		})
	})
}

function addTrackListEvent(){
	$(".track_list").children("tr").each(function(){
		$(this).children("td").eq(4).children("button").eq(0).click(function(){
			productId = $(this).parent().parent().attr("id");
			trackToShopCar();
		})
		.parent().children("button").eq(1).click(function(){
			
			Swal.fire({
					  title: '確定刪除此遊戲?',
					  text: "",
					  icon: 'question',
					  showCancelButton: true,
					  confirmButtonColor: '#3085d6',
					  cancelButtonColor: '#d33',
					  cancelButtonText: '取消',
					  confirmButtonText: '確定'
					}).then((result) => {
					  if (result.isConfirmed) {
					    Swal.fire(
					      '商品已刪除',
					      '',
					      'success'
					    )
						buylist.splice(0, buylist.length);
						productId = $(this).parent().parent().attr("id");
						$("table").html("").parent().css("height", "auto").css("overflow", "");
						deleteFromTrackList();
					  }
					})

		})
	})
}

