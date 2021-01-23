var page = "/TestVersion";
var websocket;
$(function() {
	$("#WebSocket_down").load(page + "/getWebSocketManagerPage", function(){
		$.ajax({
			url:"getMemberChatId",
			type:"POST",
			dataType:"text",
			async:false,
			success:function(obj){
				console.log("編號:" + obj)
				websocket = new WebSocket("ws://127.0.0.1:8080/TestVersion/chat/" + obj);
			}
		})
		websocket.onopen = function(evnt) {
			$("#tou").html($("form").eq(0).html().split("</span>")[1].split(" ")[1] + "")
		};
		websocket.onmessage = function(evnt) {
			$("#msg").append("<span>" + evnt.data + "</span><br>");
		};
//		websocket.onerror = function(evnt) { };
		websocket.onclose = function(evnt) {
			$("#tou").html("與伺服器斷開了連結!")
		}
		
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
	})
//		if ('WebSocket' in window) {
//			console.log("此瀏覽器支援websocket");
//		} else if ('MozWebSocket' in window) {
//			alert("此瀏覽器只支援MozWebSocket");
//		} else {
//			alert("此瀏覽器只支援SockJS");
//		}
	
});