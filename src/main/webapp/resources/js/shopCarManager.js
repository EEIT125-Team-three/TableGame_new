var historyId = null;
var dateRage = null;
$(document).ready(function(){
	getAllShopCarHistory();
	$("#orderId").change(function(){
		if($(this).val() != ""){
			if($(this).val() > 0) { 
		　　　　$(this).attr("value", $(this).val())
		　	}
			else{
				$(this).val($(this).attr("value"))
			}
		}
	})
	$(".shopCarManager_Div1").children("button").eq(0).click(function(){
		historyId = $(this).prev().val();
		if($(this).prev().val() == ""){
			historyId = null
		}
		dateRage = $(".dateRage").val();
		console.log(dateRage)
		if($(".dateRage").val() == "null"){
			dateRage = null
		}
		getAllShopCarHistory();
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
					s += ("<tr><td>" + obj.TableGameOrder[i].tableGameOrderId + "</td><td>" + obj.allTableGameOrderTime[i] + "</td><td>" + obj.TableGameOrder[i].sentToWho + "</td><td>" + obj.TableGameOrder[i].sentToAddress + "</td><td>" + obj.TableGameOrder[i].sentToPhone + "</td><td>" + obj.TableGameOrder[i].totalMoney + "</td><td><button>訂單細節</button><br><button>修改收件資料</button></td></tr>")
				}
			}
			$(".shopCarManager_Table1").eq(0).html(s).children("tr").each(function(){
				let orderId = $(this).children("td").eq(0).html();
				let line = $(this);
				$(this).children("td").eq(6).children("button").eq(0).click(function(){
					getOrderDetail(orderId);
				}).parent().children("button").eq(1).click(function(){
					changeData(line);
				})
			})
			
		}
	})
}
function getOrderDetail(orderId){
	$.ajax({
		url:"getOrderDetail",
		type:"POST",
		data:{
			"orderId":orderId
		},
		dataType:"json",
		success:function(orderDetail){
			let s = "<tr><td>商品名稱</td><td>商品單價</td><td>購買數量</td></tr>";
			for(let i=0; i<orderDetail[0].length; i++){
				s += ("<tr id=" + orderDetail[0][i] + "><td>" + orderDetail[1][i] + "</td><td>" + orderDetail[2][i] + "</td><td>" + orderDetail[3][i] + "</td></tr>")
			}
			$(".shopCarManager_Table1").eq(1).html(s);
		}
	})
}
function changeData(line){
	//中央懸浮視窗
	$(".centerOver").html(createChangeTable(line))
	$(".backOver").attr("class", "backOn")
	$(".centerOver").attr("class", "centerOn")
	$(".noChange").click(function(){
		$(".centerOn").attr("class", "centerOver").html("")
		$(".backOn").attr("class", "backOver")
	})
	
	$(".goChange").click(function(){
		if(line.children("td").eq(2).html() != $("#sentToWho").val() || line.children("td").eq(3).html() != $("#sentToWhere").val() || line.children("td").eq(4).html() != $("#sentToPhone").val()){
			$.ajax({
				url:"changeOrderData",
				data:{
					'orderId':$("#sentToWho").attr("orderId"),
					'sentToWho':$("#sentToWho").val(),
					'sentToWhere':$("#sentToWhere").val(),
					'sentToPhone':$("#sentToPhone").val()
				},
				type:"POST",
				success:function(){
					line.children("td").eq(2).html($("#sentToWho").val())
					line.children("td").eq(3).html($("#sentToWhere").val())
					line.children("td").eq(4).html($("#sentToPhone").val())
					alert("更新成功")
					$(".centerOn").attr("class", "centerOver").html("")
					$(".backOn").attr("class", "backOver")
				},
				error:function(){
					alert("更新失敗")
					$(".centerOn").attr("class", "centerOver").html("")
					$(".backOn").attr("class", "backOver")
				}
			})
			
		}
		else{
			$(".centerOn").attr("class", "centerOver").html("")
			$(".backOn").attr("class", "backOver")
		}
	})
}
function createChangeTable(line){
	s = (
		"<span>訂單編號 : " + line.children("td").eq(0).html() + "號</span><br>" +
		"<span>訂單成立時間 : " + line.children("td").eq(1).html() + "</span><br>" +
		"<span>收件人 : <input value='" + line.children("td").eq(2).html() + "' id='sentToWho' orderId='" + line.children("td").eq(0).html() + "'></span><br>" +
		"<span>收件地址 : <input value='" + line.children("td").eq(3).html() + "' id='sentToWhere'></span><br>" +
		"<span>收件人聯繫電話 : <input value='" + line.children("td").eq(4).html() + "' id='sentToPhone'></span><br>" +
		"<span>總金額 : " + line.children("td").eq(5).html() + "</span><br><br><span class='goChange'>更改</span><span class='noChange'>取消</span>"
	)
	return s;
}