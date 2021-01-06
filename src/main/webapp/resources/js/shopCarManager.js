var historyId = null;
var dateRage = null;
$(document).ready(function(){
	getAllShopCarHistory();
	$("button").eq(1).click(function(){
		//中央懸浮視窗
		$(".backOver").attr("class", "backOn")
		$(".centerOver").attr("class", "centerOn").eq(0).click(function(){
			//關閉懸浮視窗
			$(this).attr("class", "centerOver")
			$(".backOn").attr("class", "backOver")
		})
	})
})

function getAllShopCarHistory(){
	$.ajax({
		url:"getAllShopCarHistory",
		data:{
			"historyId":historyId,
			"dateRage":dateRage
		},
		dataType:"json",
		type:"POST",
		success:function(obj){
			let s = "";
			if(obj.TableGameOrder.length > 0){
				s = "<tr><td>訂單編號</td><td>訂單時間</td><td>收件人</td><td>收件地址</td><td>收件人電話</td><td>訂單金額</td><td>訂單細節</td></tr>";
				for(let i=0; i<obj.TableGameOrder.length; i++){
					s += ("<td>" + obj.TableGameOrder[i].tableGameOrderId + "</td><td>" + obj.allTableGameOrderTime[i] + "</td><td>" + obj.TableGameOrder[i].sentToWho + "</td><td>" + obj.TableGameOrder[i].sentToAddress + "</td><td>" + obj.TableGameOrder[i].sentToPhone + "</td><td>" + obj.TableGameOrder[i].totalMoney + "</td><td><button>訂單細節</button></td>")
				}
			}
			$(".shopCarManager_Table1").eq(0).html(s)
			//按鈕事件
		}
	})
}