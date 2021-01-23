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
				console.log("編號:" + obj)
				websocket = new WebSocket("ws://" + thisConnection + page + "/chat/" + obj);
				createWebSocket();
				startUseButton();
			}
		})
	})	
});

//開啟連線使用功能
function createWebSocket(){
	//連線時獲得所有線上會員編號
	websocket.onopen = function(evnt) {
		$("#tou").html($("form").eq(0).html().split("</span>")[1].split(" ")[1])
		$.ajax({
			url: page + "/message/getAllMember",
			type:"POST",
			dataType:"json",
			success:function(obj){
				let s = "";
				for(let i=0; i<obj.length; i++){
//					if(obj[i] != 1){
						s += "<button class='button_AllMember'>";
    					s += obj[i];
    					s += "</button>";
//					}
				}
				$("#allOnlineMember").html(s);
				startAllMemberButton();
			}
		})
	};
	websocket.onmessage = function(evnt) {
		$("#msg").append("<span>" + evnt.data + "</span><br>");
		startAllMemberButton();
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
		$.ajax({
			url:page+"/message/sentToMember",
			type:"POST",
			data:{
				"userId":3,
				"message":$("#message").val()
			}
		})
	});
	startAllMemberButton();
}

//開啟各會員聊天窗按鈕
function startAllMemberButton(){
	$(".button_AllMember").unbind();
	$(".button_AllMember").click(function(){
		$(".button_AllMember").css("background-color", "red")
		$(this).css("background-color", "blue")
	})
}