var page = "/TestVersion";
var websocket;
var thisConnection = "127.0.0.1:8080";

$(function() {
	$("#WebSocket_down").load(page + "/getWebSocketPage", function(){
		$.ajax({
			url:"getMemberChatId",
			type:"POST",
			dataType:"text",
			async:false,
			success:function(obj){
				websocket = new WebSocket("ws://" + thisConnection + page + "/chat/" + obj);
				createWebSocket();
				startUseButton();
				getMyHistoryId(obj);
			}
		})
	})	
});

//開啟連線使用功能
function createWebSocket(){
	websocket.onopen = function(evnt) {
		$("#tou").html($("form").eq(0).html().split("</span>")[1].split(" ")[1])
	};
	websocket.onmessage = function(evnt) {
		$("#msg").append("<span>" + evnt.data + "</span><br>");
		//設定滑鼠高度
		var scrollTop = $("#msg")[0].scrollHeight;
		$("#msg").scrollTop(scrollTop);
	};
//	websocket.onerror = function(evnt) { };
	websocket.onclose = function(evnt) {
		$("#tou").html("與伺服器斷開了連結!")
	}
}

//開啟按鈕功能
function startUseButton(){
	//開啟/關閉聊天室窗
	$("#openWebSocket").click(function(){
		$(this).attr("hidden", "hidden")
		$("#WebSocket_down").attr("id", "WebSocket_float");
		$(".close").mouseover(function(){
			$(this).css("opacity", "0.6");
		}).mouseout(function(){
			$(this).css("opacity", "0.3");
		}).click(function(){
			$(this).css("opacity", "0.3").unbind();
			$("#WebSocket_float").attr("id", "WebSocket_down");
			$("#openWebSocket").removeAttr("hidden");
		})
	})
	//訊息送出
	$('#send').click(function() {
		if($("#message").val().trim() != ""){
			$.ajax({
				url:page+"/message/sentToMember",
				type:"POST",
				data:{
					"userId":1,
					"message":$("#message").val()
				},
				success:function(){
					$("#message").val("");
				}
			})			
		}
	});
}

//調出歷史聊天紀錄
function getMyHistoryId(obj){
	$.ajax({
		url:page + "/message/getMemberMessage",
		type:"POST",
		dataType:"json",
		data:{
			"memberId":obj
		},
		success:function(thisMemberContextHistory){
			let s = "";
			for(let i=0; i<thisMemberContextHistory.length; i++){
				s += ("<span>" + thisMemberContextHistory[i] + "</span><br>");
			}
			$("#msg").html(s);
			//設定滑鼠高度
			$("#msg").html(s);
			var scrollTop = $("#msg")[0].scrollHeight;
			$("#msg").scrollTop(scrollTop);
		}
	})
}