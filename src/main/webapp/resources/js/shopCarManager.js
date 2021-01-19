var historyId = null;
var dateRage = null;
var dateChart = null;
var backgroundColor = ["#D9FFFF","#CAFFFF","#BBFFFF","#A6FFFF","#80FFFF","#4DFFFF","#00FFFF",
					   "#00E3E3","#00CACA","#00AEAE","#D7FFEE","#C1FFE4","#ADFEDC","#96FED1",
					   "#7AFEC6","#4EFEB3","#1AFD9C","#02F78E","#02DF82","#02C874","#FFD9EC",
					   "#FFC1E0","#FFAAD5","#FF95CA","#FF79BC","#FF60AF","#FF359A","#FF0080",
					   "#F00078","#D9006C","#CA8EC2","#C07AB8","#B766AD"]
$(document).ready(function(){
	
	getAllShopCarHistory();
	
	$("#orderId").change(function(){
		if($(this).val() != ""){
			if($(this).val()>0){
				$(this).attr("value", $(this).val())
			}else if($(this).val() == 0){
				$(this).val("")
				$(this).attr("value", $(this).val())
			}else{
				$(this).val($(this).attr("value"))
			}
		}else{
		$(this).attr("value", $(this).val())	
		}
	})
	
	$(".shopCarManager_Div2").children("button").eq(0).click(function(){
		historyId = $("#orderId").val();
		console.log(historyId)
		if(historyId == "" || historyId == 0){
			historyId = null
		}
		dateRage = $(".dateRage").val();
		console.log(dateRage)
		if(dateRage == "null"){
			dateRage = null
		}
		getAllShopCarHistory();
	})
	
	$(".dateRage").change(function(){
		historyId = $("#orderId").val();
		console.log(historyId)
		if(historyId == ""){
			historyId = null
		}
		dateRage = $(".dateRage").val();
		console.log(dateRage)
		if(dateRage == "null"){
			dateRage = null
		}
		getAllShopCarHistory();
	})
	
	$(".showAllOrderData").click(function(){
		if($(".allOrderData").css("display") == "none"){
			$(".showAllOrderData").html("隱藏訂單資訊⬆");
			$(".allOrderData").slideDown("slow");
		}else{
			$(".allOrderData").slideUp("slow");
			$(".showAllOrderData").html("顯示訂單資訊⬇");
		}
	})
	
	$(".showCanvas").click(function(){
		if($(".shopCarManager_Div1").css("display") == "none"){
			$(".showCanvas").html("隱藏訂單資訊⬆");
			$(".shopCarManager_Div1").slideDown("slow");
		}else{
			$(".shopCarManager_Div1").slideUp("slow");
			$(".showCanvas").html("顯示訂單資訊⬇");
		}
	})
	
	$.ajax({
		url:"getAllOrderYear",
		type:"POST",
		dataType:"json",
		success:function(obj){
			let s = "";
			for(let i=0; i<obj.length; i++){
				s += "<option>";
				s += obj[i];
				s += "</option>";
			}
			$("#byYear").html(s);
			getDataByDate();
		}
	})
	
	$("#byYear").change(function(){
		$("#byMonth").val("不指定");
		getDataByDate();
	})
	
	$("#byMonth").change(function(){
		getDataByDate();
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
			console.log(obj.TableGameOrder.length)
			if(obj.TableGameOrder.length > 0){
				s = "<thead><th>訂單編號</th><th>訂單時間</th><th>收件人</th><th>收件地址</th><th>收件人電話</th><th>訂單金額</th><th>訂單細節</th></thead>";
				for(let i=0; i<obj.TableGameOrder.length; i++){
					s += ("<tr><td>" + obj.TableGameOrder[i].tableGameOrderId + "</td><td>" + obj.allTableGameOrderTime[i] + "</td><td>" + obj.TableGameOrder[i].sentToWho + "</td><td>" + obj.TableGameOrder[i].sentToAddress + "</td><td>" + obj.TableGameOrder[i].sentToPhone + "</td><td>" + obj.TableGameOrder[i].totalMoney + "</td><td><button class='detail'>訂單細節</button><br><button class='changeData'>修改收件資料</button></td></tr>")
				}
			}
			$(".shopCarManager_Table1").eq(0).html(s);
//			changeTable($(".shopCarManager_Table1").eq(0));
			$(".detail").click(function(){
				getOrderDetail($(this).parents("tr").children().eq(0).html());
			})
			$(".changeData").click(function(){
				changeData($(this).parents("tr"));
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
			$(".shopCarManager_Table1").eq(1).html("");
			let s = "<thead><th>商品名稱</th><th>商品單價</th><th>購買數量</th></thead>";
			for(let i=0; i<orderDetail[0].length; i++){
				s += ("<tr id=" + orderDetail[0][i] + "><td>" + orderDetail[1][i] + "</td><td>" + orderDetail[2][i] + "</td><td>" + orderDetail[3][i] + "</td></tr>")
			}
			$(".shopCarManager_Table1").eq(1).html(s);
//			changeTable($(".shopCarManager_Table1").eq(1));
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

//function changeTable(where){
//	where.DataTable({
//		destroy: true,
//		language: {
//		    "lengthMenu": "顯示 _MENU_ 筆資料",
//		    "sProcessing": "處理中...",
//		    "sZeroRecords": "没有匹配结果",
//		    "sInfo": "目前有 _MAX_ 筆資料",
//		    "sInfoEmpty": "目前共有 0 筆紀錄",
//		    "sInfoFiltered": " ",
//		    "sInfoPostFix": "",
//		    "sSearch": "尋找:",
//		    "sUrl": "",
//		    "sEmptyTable": "尚未有資料紀錄存在",
//		    "sLoadingRecords": "載入資料中...",
//		    "sInfoThousands": ",",
//		    "oPaginate": {
//		        "sFirst": "首頁",
//		        "sPrevious": "上一頁",
//		        "sNext": "下一頁",
//		        "sLast": "末頁"
//		    },
//		    "order": [[0, "desc"]],
//		    "oAria": {
//		        "sSortAscending": ": 以升序排列此列",
//		        "sSortDescending": ": 以降序排列此列"
//		    }
//		}
//	})
//}

function getDataByDate(){
	let month = $("#byMonth").val();
	if(month == "不指定"){
		month = null;
	}
	$.ajax({
		url:"getDataByDate",
		type:"POST",
		dataType:"json",
		data:{
			"year":$("#byYear").val(),
			"month":month
		},
		success:function(obj){
			console.log(obj)
			let s = ($("#byYear").val() + "年");
			if(obj.dateName.length != 12){
				s += (month + "月 月");
			}else{
				createMonthSelect(obj.date);
				s += " 年";
			}
			s += "度總報表(共收入";
			s += obj.totalMoney;
			s += "元)";
			showDataInChart(obj.date, obj.dateName, s);
		}
	})
}

function showDataInChart(data, dataName, dataTitle){
	let newBackgroundColor = [];
	if(dateChart != null){
		dateChart.destroy();
	}
	for(let i=0; i<data.length; i++){
		newBackgroundColor.push(backgroundColor[i%33]);
	}
	dateChart = new Chart($("#example"), {
		// 參數設定[註1]
		type: "bar", // 圖表類型
		data: {
	        datasets: [{
	            label: dataTitle,
				dataColor:"#000000",
	            data: data,
				backgroundColor: newBackgroundColor,
				borderWidth: 1,
				borderColor:"#000000",
				hoverBackgroundColor: "red",
	            hoverBorderColor: "#FF0000"
	        }],
	        labels: dataName
	    },
		options:{
			legend: {
                labels: {
                    fontColor: "black",
                    fontSize: 20
                }
            },
			scales: {
		        yAxes: [{
		            ticks: {
		                beginAtZero:true
		            }
		        }]
		    }
		}
	});
}

function createMonthSelect(date){
	let s = "<option>不指定</option>";
	for(let i=0; i<date.length; i++){
		if(date[i] != 0){
			s += "<option>";
			s += (i+1);
			s += "</option>";
		}
	}
	$("#byMonth").html(s);
}