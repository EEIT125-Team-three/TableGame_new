var cityId = null;
var districtId = null;
var roadId = null;
var nowRadio = 0;
var noRefundMoney;
var maxCanUseRefund;
var maxRefund;
var nowShow = false;
var convenienceStore = [];

$(document).ready(function(){
	$.ajax({
		url:"selectAllFromShopCarAjax",
		dataType: 'json',
		type:'POST',
		success : function(htmlobj, Object){
			let s = '<thead><th style="width: 44px;">序號</th><th style="width: 101px;">商品圖</th><th style="width: 443px;">商品名稱</th><th style="width: 90px;">單價</th><th style="width: 98px;">數量</th><th style="width: 110px;">小計</th></thead>';
			$(".shopCar_list").html(s);
			s = "";
			for(let i=0; i<htmlobj.length; i++){
				s += ("<tr id='" + htmlobj[i].productId + "'><td>" + parseInt(i+1) + "</td>")
				s += ("<td><img src='" + htmlobj[i].img_url + "' style='width: 101px;'></td>")
				s += ("<td>" + htmlobj[i].c_name + "</td>")
				s += ("<td>" + htmlobj[i].price + "</td>")
				s += ("<td>" + 0 + "</td>")
				s += ("<td>" + 0 + "</td></tr>")
			}
			$(".shopCar_list").append(s);
			$.ajax({
				url:"shopCarAjaxQuantity",
				dataType: 'json',
				type:'POST',
				success : function(htmlobj){
					$("tr").each(function(){
						if(htmlobj[$(this).attr("id")]){
							let d = parseInt(htmlobj[$(this).attr("id")]);
							$(this).children("td").eq(4).html(d);
							$(this).children("td").eq(5).html(d*parseInt($(this).children("td").eq(3).html()));
						}
					})
				}
			})
		}
	})
	$("#checkout").click(function(){
		Swal.fire({
			  title: '即將進入結帳頁面',
			  text: "",
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: '確定',
			  cancelButtonText:'取消'
			}).then((result) => {
			  if (result.value) {
				$("#roadData").val($("#roadData").attr("value"))
				$("form").eq(1).submit();
			  }
			})
	})
	if($("#nowRefund").html() != 0){
		$("#refund").parent().removeAttr("hidden").prev().removeAttr("hidden");
		if(parseInt($("#nowRefund").html().replace(",", "")) > parseInt($("#total").html().replace(",", ""))){
			$("#refund").html($("#total").html())
		}
	}
	//原價
	noRefundMoney = $("#total").html().replace(",", "");
	//現有的回饋金
	maxCanUseRefund = $("#nowRefund").html().replace(",", "");
	//預計扣除的回饋金
	maxRefund = $("#refund").html().replace(",", "");
	console.log(noRefundMoney)
	console.log(maxCanUseRefund)
	console.log(maxRefund)
	$(".useRefund").click(function(){
		if(nowRadio != $(this).val()){
			nowRadio = $(this).val();
			//最後總價
			let totalMoney;
			//最後總回饋金
			let totalRefund = 0;
			//可獲得回饋金
			let getRefund;
			if(nowRadio == 0){
				//不用優惠
				totalMoney = parseInt(noRefundMoney);
				$("#total").parent().prev().attr("hidden", "hidden").next().css("color", "");
			}else if(nowRadio == 1){
				//用擁有的優惠
				totalMoney = parseInt(noRefundMoney) - parseInt(maxRefund);
				totalRefund = parseInt(totalRefund) - parseInt(maxRefund);
				console.log(totalRefund)
				$("#total").parent().prev().removeAttr("hidden").next().css("color", "red");
			}else{
				//折扣碼
				$("#discount").focus()
				totalMoney = parseInt(parseInt(noRefundMoney)*0.95);
				$("#total").parent().prev().removeAttr("hidden").next().css("color", "red");
			}
			getRefund = parseInt(totalMoney/10);
			totalRefund += parseInt(maxCanUseRefund) + parseInt(getRefund);
			
			let a = totalRefund.toString();
			if(a.length > 3){
				let i = a.length%3;
				totalRefund = (a.slice(0, i));
				for(; i<a.length; i+=3){
					totalRefund += ("," + a.slice(i, i+3))
				}	
			}
			$("#finalRefund").html(totalRefund)
			
			a = totalMoney.toString();
			if(a.length > 3){
				i = a.length%3;
				totalMoney = (a.slice(0, i));
				for(; i<a.length; i+=3){
					totalMoney += ("," + a.slice(i, i+3))
				}
			}
			$("#total").html(totalMoney)
			
			a = getRefund.toString();
			if(a.length > 3){
				i = a.length%3;
				getRefund = (a.slice(0, i));
				for(; i<a.length; i+=3){
					getRefund += ("," + a.slice(i, i+3))
				}
			}
			$("#getRefund").html(getRefund)
			}
	})	
	
	getMemberAddress();
	
	$("#city").change(function(){
		getAllDistrict();
	})
	$("#district").change(function(){
		getAllRoad();
		getConvenienceStore();
	})
	
	$("#roadData").blur(function(){
		$("#roadData").attr("value", "");
		let options = $("#road").children();
		for(var i=0;i<options.length;i++){
	        if(options.eq(i).val().trim()==$("#roadData").val().trim()){
	            $("#roadData").val(options.eq(i).val()).attr("value", options.eq(i).attr("id"));
	            $("#road").next().next().removeAttr("disabled");
				break;
	        }
	    }
		if($("#roadData").attr("value") == ""){
            $("#road").next().next().attr("disabled", "disabled");
			$("#roadData").val("請重新選擇")
		}
		$("#sentToWhere").val("").attr("value", "");
	}).click(function(){
		if($(this).val() == "請重新選擇"){
			$(this).val("");
		}else if($(this).attr("value") != ""){
			$(this).val("").attr("value", "");
		}
	})
	
	$("#discount").blur(function(){
		//檢查優惠碼
	}).click(function(){
		$(this).next().click().prev().focus();
	})
	
	
	$("#gMap").mouseover(function(e){
		if(!nowShow){
			let x = -100;
			let y = 0;
			let theWay = $("#city :selected").text() + $("#district :selected").text() +  $("#roadData").val() + $("#road").next().next().val();
	        let tooltip = "<div id='tooltip'><iframe id='myMap' width='550' height='400' src='https://maps.google.com.tw/maps?f=q&hl=zh-TW&geocode=&q=" + theWay + "&z=16&output=embed&t='></iframe></div>";
	        $("#gMap").append(tooltip);
	        $("#tooltip").css({
	            "top": (e.pageY + y) + "px",
	            "left": (e.pageX + x)  + "px",
				"position": "absolute",
				"z-index":1
	        }).show("fast");
			nowShow = true;
		}
    }).mouseleave(function(e){
		$("#tooltip").remove();
		nowShow = false;
	})
})

function getAllCity(){
	$.ajax({
		url:"/TestVersion/getAllCity",
		type:"POST",
		dataType:"json",
		success:function(allCity){
			let s = "";
			if(cityId != null){
				for(let i=0; i<allCity.length; i++){
					if(cityId == allCity[i].cityId){
						s += "<option selected value=" + allCity[i].cityId + ">" + allCity[i].city + "</option>"
					}else{
						s += "<option value=" + allCity[i].cityId + ">" + allCity[i].city + "</option>"					
					}
				}
				cityId = null;
			}else{
				for(let i=0; i<allCity.length; i++){
					s += "<option value=" + allCity[i].cityId + ">" + allCity[i].city + "</option>"
				}
			}
			$("#city").html(s);
			getAllDistrict();
		}
	})
}

function getAllDistrict(){
	$.ajax({
		url:"/TestVersion/getAllDistrict",
		type:"POST",
		dataType:"json",
		data:{
			"cityId":$("#city").val()
		},
		success:function(allDistrict){
			let s = "";
			if(districtId != null){
				for(let i=0; i<allDistrict.length; i++){
					if(districtId == allDistrict[i].districtId){
						s += "<option selected value=" + allDistrict[i].districtId + ">" + allDistrict[i].district + "</option>"
					}else{
						s += "<option value=" + allDistrict[i].districtId + ">" + allDistrict[i].district + "</option>"					
					}
				}
				districtId = null;
			}else{
				for(let i=0; i<allDistrict.length; i++){
					s += "<option value=" + allDistrict[i].districtId + ">" + allDistrict[i].district + "</option>"
				}
			}
			$("#district").html(s);
			getAllRoad();
			getConvenienceStore();
		}
	})
}

function getAllRoad(){
	$.ajax({
		url:"/TestVersion/getAllRoad",
		type:"POST",
		dataType:"json",
		data:{
			"districtId":$("#district").val()
		},
		success:function(allRoad){
			let s = "";
			if(roadId != null){
				for(let i=0; i<allRoad.length; i++){
					if(roadId == allRoad[i].roadId){
						s += "<option selected value=" + allRoad[i].road + " id='" + allRoad[i].roadId + "'></option>"
						$("#roadData").val(allRoad[i].road).attr("value", allRoad[i].roadId)
					}else{
						s += "<option value=" + allRoad[i].road + " id='" + allRoad[i].roadId + "'></option>"
					}
				}
				roadId = null;
			}else{
				for(let i=0; i<allRoad.length; i++){
					s += "<option value=" + allRoad[i].road + " id='" + allRoad[i].roadId + "'></option>"
				}
				$("#roadData").val(allRoad[0].road).attr("value", allRoad[0].roadId)
			}
			$("#road").html(s);
		}
	})
}

function getConvenienceStore(){
	convenienceStore = [];
	$.ajax({
		url:"getConvenienceStoreByRoadId",
		type:"POST",
		dataType:"json",
		data:{
			"districtId":$("#district").val()
		},
		success:function(convenience){
			console.log(convenience)
			for(let i=0; i<convenience.length; i++){
				convenienceStore.push([convenience[i][1], convenience[i][0]["convenienceStoreAddress"], convenience[i][0]["convenienceStoreAddressId"], convenience[i][0]["convenienceStoreType"]["convenienceStore"]])
			}
			console.log(convenienceStore)
			createSelectConvenienceStore()
		}
	})
}

function createSelectConvenienceStore(){
	let s = "";
	let s2 = "";
	for(let i=0; i<convenienceStore.length; i++){
		console.log([convenienceStore[i][0], $("#roadData").val()])
		if(convenienceStore[i][0] == $("#roadData").val()){
			s += "<option id=" + convenienceStore[i][2] + " value=\"" + convenienceStore[i][3] + "\">"+ convenienceStore[i][0] + convenienceStore[i][1] + "</option>"
		}else{
			s2 += "<option id=" + convenienceStore[i][2] + " value=\"" + convenienceStore[i][3] + "\">"+ convenienceStore[i][0] + convenienceStore[i][1] + "</option>"

		}
	}
	$("#convenience").html(s+s2);
}

function getMemberAddress(){
	$.ajax({
		url:"/TestVersion/getMemberAddress",
		type:"POST",
		dataType:"json",
		async:false,
		success:function(memberAddress){
			cityId = memberAddress.city;
			districtId = memberAddress.district;
			roadId = memberAddress.road;
			getAllCity();
		}
	})	                                                                            
}