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
	
	$("#useRefund").click(function(){
		let totalMoney;
		let totalRefund;
		let getRefund;
		if($(this).attr("value") == "false"){
			$(this).attr("value", true)
			totalMoney = parseInt($("#total").html().replace(",", ""))-parseInt($("#refund").html().replace(",", ""));
			totalRefund = parseInt($("#nowRefund").html().replace(",", ""))-parseInt($("#refund").html().replace(",", ""))+parseInt(totalMoney/10);
			$("#total").parent().prev().removeAttr("hidden").next().css("color", "red");
			getRefund = parseInt(totalMoney/10);
		}else{
			$(this).attr("value", false)
			totalMoney = parseInt($("#total").html().replace(",", ""))+parseInt($("#refund").html().replace(",", ""));
			totalRefund = parseInt($("#nowRefund").html().replace(",", ""))+parseInt(totalMoney/10);
			$("#total").parent().prev().attr("hidden", "hidden").next().css("color", "");
			getRefund = parseInt(totalMoney/10);
		}
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
	})	
	
	getMemberAddress();
	
	$("#city").change(function(){
		getAllDistrict();
	})
})

function getAllCity(cityId, districtId){
	$.ajax({
		url:"/TestVersion/getAllCity",
		type:"POST",
		dataType:"json",
		success:function(allCity){
			console.log(allCity)
			let s = "";
			for(let i=0; i<allCity.length; i++){
				if(cityId == allCity[i].cityId){
					s += "<option selected value=" + allCity[i].cityId + ">" + allCity[i].city + "</option>"
				}else{
					s += "<option value=" + allCity[i].cityId + ">" + allCity[i].city + "</option>"					
				}
			}
			$("#city").html(s);
			getAllDistrict(districtId);
		}
	})
}

function getAllDistrict(districtId){
	$.ajax({
		url:"/TestVersion/getAllDistrict",
		type:"POST",
		dataType:"json",
		data:{
			"cityId":$("#city").val()
		},
		success:function(allDistrict){
			console.log(allDistrict[0].districtId)
			let s = "";
			for(let i=0; i<allDistrict.length; i++){
				if(districtId == allDistrict[i].districtId){
					s += "<option selected value=" + allDistrict[i].districtId + ">" + allDistrict[i].district + "</option>"
				}else{
					s += "<option value=" + allDistrict[i].districtId + ">" + allDistrict[i].district + "</option>"					
				}
			}
			$("#district").html(s);
		}
	})
}

function getMemberAddress(){
$.ajax({
	url:"/TestVersion/getMemberAddress",
	type:"POST",
	dataType:"json",
	async:false,
	success:function(memberAddress){
		getAllCity(memberAddress.city, memberAddress.district);
	}
})	
}