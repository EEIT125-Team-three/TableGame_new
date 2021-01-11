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
				if(obj.message=='成功加入購物車'){
//					swal("加入成功!", obj.message, "success", {
//                            button: "ok",
//                        });
					Swal.fire({
					  title: obj.message,
					  width: 600,
					  icon:'success',
					  padding: '3em',
					  backdrop: `
					    rgba(0,0,123,0.4)
					    url("../images/firework.gif")
    					repeat
					  `
					});
				}
				else{
//					swal("商品已存在","", "warning", {
//                            button: "ok",
//                        });
					Swal.fire(
					  obj.message,
					  '',
					  'warning'
					)
				}
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
				if(obj.message=='成功加入追蹤清單'){
//				swal("追蹤成功!",obj.message , "success", {
//                            button: "ok",
//                        });
				Swal.fire(
					  '追蹤成功!',
					  '',
					  'success'
					)
				$("#alreadytrack").html('已追蹤');					
				}else{
//					swal("商品已追蹤","", "warning", {
//                            button: "ok",
//                        });
					Swal.fire(
					  '商品已追蹤',
					  '',
					  'warning'
					)
				}
			}
		})
	})
})