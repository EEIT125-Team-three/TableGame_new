var page = "/TestVersion"
var buylist = "";
$(document).ready(function(){
	var init = $(".standard_nav").html();	
	$(".standard_nav").load(page + "/SearchList")
	$(".buy_btn").eq(1).click(function(){
		//加入購物車
		$.ajax({
			url:"/TestVersion/insertToShopCar",
			data:{
				'productId':$(".buy_btn").eq(1).attr("productId"),
				'buyHowmuch':1
			},
			type:"POST",
			success:function(obj){
				alert(obj.message)
			}
		})
	})
	$(".buy_btn").eq(2).click(function(){
		//加入追蹤
		if($(".login_Btn").eq(0).html() == "登入"){
			$(".login_Btn").eq(0).click();
		}
		$.ajax({
			url:"/TestVersion/addToTrackList",
			data:{
				'productId':$(".buy_btn").eq(1).attr("productId")
			},
			type:"POST",
			dataType:"json",
			success:function(obj){
				alert(obj.message)
			}
		})
	})
})