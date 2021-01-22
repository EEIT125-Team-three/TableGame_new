var cityId = null;
var districtId = null;
var roadId = null;
var nowRadio = 4;
var noRefundMoney;
var maxCanUseRefund;
var maxRefund;
var delMoney;
var nowShow = false;
var convenienceStore = [];
var discountCheckId = false;

$(document).ready(function(){
	$.ajax({
		url:"selectAllFromShopCarAjax",
		dataType: 'json',
		type:'POST',
		success : function(htmlobj){
			let s = '<thead><th style="width: 44px;">序號</th><th style="width: 101px;">商品圖</th><th style="width: 443px;">商品名稱</th><th style="width: 90px;">單價</th><th style="width: 98px;">數量</th><th style="width: 110px;">小計</th></thead>';
			$(".shopCar_list").html(s);
			s = "";
			for(let i=0; i<htmlobj.length; i++){
				s += ("<tr id='" + htmlobj[i].productId + "'><td>" + parseInt(i+1) + "</td>")
				s += ("<td><img src='" + htmlobj[i].img_url + "' style='width: 101px;'></td>")
				s += ("<td>" + htmlobj[i].c_name + "</td>")
				if(htmlobj[i].discount == null){
					s += ("<td>" + htmlobj[i].price + "</td>")
				}else{
					s += ("<td>" + parseInt(htmlobj[i].price) * parseInt(htmlobj[i].discount) / 10 + "</td>")
				}
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
		let s = '即將進入結帳頁面';
		if($("input[name='useRefund']:checked").val() == 2 && ($("#discount") == "" || $("#discount").next().css("color") != "rgb(0, 128, 0)")){
			console.log($("#discount").next().css("color"))
			s = '未填寫正確折扣碼將視作不使用優惠，是否仍要前往結帳';
		}
		Swal.fire({
			  title: s,
			  text: "",
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: '確定',
			  cancelButtonText:'取消'
			}).then((result) => {
			  if (result.value) {
				let finalCheck = true;
				
				if($("#sentToWhere").attr("addressid") == ""){
					$("#road").next().html("請填寫地址");
					finalCheck = false;
				}else{
					$("#road").next().html("");
				}
				
				if($("#sentToWho").val().trim() == ""){
					$("#sentToWho").next().html("請填寫收件人姓名");
					finalCheck = false;
				}else{
					$("#sentToWho").next().html("");
				}
				
				if($("#sentToPhone").val().trim() == ""){
					$("#sentToPhone").next().html("請填寫聯絡手機號碼");
					finalCheck = false;
				}else if($("#sentToPhone").val().trim().length != 10){
					$("#sentToPhone").next().html("手機號碼格式錯誤");
					finalCheck = false;
				}else{
					$("#sentToPhone").next().html("");
				}
				
				if(finalCheck){
					$("#roadData").val($("#roadData").attr("value"))
					$("#shopId").val($("#sentToWhere").attr("addressid")).attr("value", $("#shopId").val())
					$("form").eq(1).submit();
				}
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
	//刪除線數字
	delMoney = $("del").eq(0).html().replace(",", "");
	$(".useRefund").click(function(){
		if($(this).val() != 2){
			setMoney($(this).val());			
		}else{
			if(!discountCheckId){
				nowRadio = 2;
				setMoney(0);
			}else{
				nowRadio = 0;
				setMoney(2);
			}
		}
	})	
	
	getMemberAddress();
	
	$("#city").change(function(){
		getAllDistrict();
		$("#sentToWhere").val("").attr("addressId", "");
		$("#gMap").next().next().next().attr("value", "還未選擇取貨地址");
		nowRadio = (nowRadio+1)%3;
		setMoney((nowRadio+2)%3);
	})
	$("#district").change(function(){
		getAllRoad();
		getConvenienceStore();
		$("#sentToWhere").val("").attr("addressId", "");
		$("#gMap").next().next().next().attr("value", "還未選擇取貨地址");
		nowRadio = (nowRadio+1)%3;
		setMoney((nowRadio+2)%3);
		createSelectConvenienceStore();
	})
	
	$("#roadData").blur(function(){
		$("#roadData").attr("value", "");
		let options = $("#road").children();
		if($("#roadData").val().trim() == ""){
			$("#roadData").val("請重新選擇");
			$("#sentToWhere").val("").attr("addressId", "");
			$("#gMap").next().next().next().attr("value", "還未選擇取貨地址");
			nowRadio = (nowRadio+1)%3;
			setMoney((nowRadio+2)%3);
		}else{
			for(var i=0;i<options.length;i++){
		        if(options.eq(i).val().trim()==$("#roadData").val().trim()){
		            $("#roadData").val(options.eq(i).val()).attr("value", options.eq(i).attr("id"));
					break;
		        }
		    }
			if($("#roadData").attr("value") == ""){
				$("#roadData").val("請重新選擇");
				$("#sentToWhere").val("").attr("addressId", "");
				$("#gMap").next().next().next().attr("value", "還未選擇取貨地址");
				nowRadio = (nowRadio+1)%3;
				setMoney((nowRadio+2)%3);
			}
		}
	}).click(function(){
		if($(this).val() == "請重新選擇"){
			$(this).val("");
		}else if($(this).attr("value") != ""){
			$(this).val("").attr("value", "");
		}
	}).change(function(){
		$("#sentToWhere").val("").attr("addressId", "");
		$("#gMap").next().next().next().attr("value", "還未選擇取貨地址");
		nowRadio = (nowRadio+1)%3;
		setMoney((nowRadio+2)%3);
		createSelectConvenienceStore();
	})
	
	$("#sentToWhere").blur(function(){
		if($("#sentToWhere").val().length != 0){
			for(let i=0; i<convenienceStore.length; i++){
				if($("#sentToWhere").val() == (convenienceStore[i][0] + convenienceStore[i][1])){
					$("#sentToWhere").attr("addressId", convenienceStore[i][2]);
					$("#gMap").next().next().next().attr("value", "取貨模式: 超商取貨，運費60元");
					nowRadio = (nowRadio+1)%3;
					setMoney((nowRadio+2)%3);
					$("#roadData").val(convenienceStore[i][0]);
					let options = $("#road").children();
					for(let j=0;j<options.length;j++){
				        if(options.eq(j).val().trim() == $("#roadData").val().trim()){
				            $("#roadData").val(options.eq(j).val()).attr("value", options.eq(j).attr("id"));
							break;
				        }
				    }
					break;
				}else if(i == convenienceStore.length-1){
					$("#gMap").next().next().next().attr("value", "取貨模式: 宅配，運費100元");
					$("#sentToWhere").attr("addressId", 0);
					nowRadio = (nowRadio+1)%3;
					setMoney((nowRadio+2)%3);
				}
			}	
		}else{
			$("#sentToWhere").val("").attr("addressId", "");
			$("#gMap").next().next().next().attr("value", "還未選擇取貨地址");
			createSelectConvenienceStore();
			nowRadio = (nowRadio+1)%3;
			setMoney((nowRadio+2)%3);
		}
	})
	
	$("#discount").change(function(){
		//檢查優惠碼
		$.ajax({
			url:"checkDiscount",
			dataType:"json",
			type:"POST",
			data:{
				"discountId":$("#discount").val()				
			},
			success:function(obj){
				discountCheckId = obj;
				nowRadio = 2
				if($("#discount").val().trim() == ""){
					$("#discount").next().html("");
					setMoney(0);
				}else if(!obj){
					$("#discount").next().html("折扣碼輸入有誤").css("color", "red");
					setMoney(0);			
				}else{
					nowRadio = 0;
					setMoney(2);
				}
			}
		})
	}).click(function(){
		$(this).next().click().prev().focus();
	})
	
	
	$("#gMap").click(function(e){
		if(!nowShow && $("#sentToWhere").attr("addressId") != ""){
			let x = -100;
			let y = 0;
			let theWay;
			if($("#sentToWhere").attr("addressId") == 0){	
				theWay = $("#city :selected").text() + $("#district :selected").text() +  $("#roadData").val() + $("#sentToWhere").val();
			}else{
				theWay = $("#city :selected").text() + $("#district :selected").text() +  $("#sentToWhere").val();	
			}
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
				$("#gMap").next().next().next().attr("value", "取貨模式: 宅配，運費100元");
				$("#sentToWhere").attr("addressid", 0);
				setMoney(0);
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
			for(let i=0; i<convenience.length; i++){
				convenienceStore.push([convenience[i][1], convenience[i][0]["convenienceStoreAddress"], convenience[i][0]["convenienceStoreAddressId"], convenience[i][0]["convenienceStoreType"]["convenienceStore"]])
			}
			createSelectConvenienceStore()
		}
	})
}

function createSelectConvenienceStore(){
	let s = "";
	let s2 = "";
	for(let i=0; i<convenienceStore.length; i++){
		if(convenienceStore[i][0] == $("#roadData").val()){
			s += "<option id=" + convenienceStore[i][2] + " value=\"" + convenienceStore[i][0] + convenienceStore[i][1] + "\">"+ convenienceStore[i][3] + "</option>"
		}else{
			s2 += "<option id=" + convenienceStore[i][2] + " value=\"" + convenienceStore[i][0] + convenienceStore[i][1] + "\">"+ convenienceStore[i][3] + "</option>"

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

function setMoney(clickWhich){
	if(nowRadio != clickWhich){
		nowRadio = clickWhich;
		//最後總價
		let totalMoney;
		//最後總回饋金
		let totalRefund = 0;
		//可獲得回饋金
		let getRefund;
		//運費
		let shippingRate;
		let finalDelMoney = delMoney;
		
		if($("#sentToWhere").attr("addressid") == ""){
			shippingRate = 0;
		}else if($("#sentToWhere").attr("addressid") == "0"){
			finalDelMoney = parseInt(finalDelMoney) + 100;
			shippingRate = 100;
		}else{
			finalDelMoney = parseInt(finalDelMoney) + 60;
			shippingRate = 60;
		}
		if(nowRadio == 0){
			//不用優惠
			totalMoney = parseInt(noRefundMoney) + parseInt(shippingRate);
			$("#total").parent().prev().attr("hidden", "hidden").next().css("color", "");
		}else if(nowRadio == 1){
			//用擁有的優惠
			totalMoney = parseInt(noRefundMoney) - parseInt(maxRefund) + parseInt(shippingRate);
			totalRefund = parseInt(totalRefund) - parseInt(maxRefund);
			$("#total").parent().prev().removeAttr("hidden").next().css("color", "red");
		}else{
			//折扣碼
			$("#discount").next().html("折扣碼可使用(95折)").css("color", "green");
			$("#discount").focus()
			totalMoney = parseInt((parseInt(noRefundMoney) + parseInt(shippingRate))*0.95);
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

		a = finalDelMoney.toString();
		if(a.length > 3){
			i = a.length%3;
			finalDelMoney = (a.slice(0, i));
			for(; i<a.length; i+=3){
				finalDelMoney += ("," + a.slice(i, i+3))
			}
		}
		$("del").eq(0).html(finalDelMoney)
	}
}