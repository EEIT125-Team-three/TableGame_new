var page = "/TestVersion"
$(document).ready(function(){
	$.ajax({
		url:"getMemberChatId",
		type:"POST",
		dataType:"text",
		async:false,
		success:function(obj){
			if(obj != 1){
				$(".header_body").children("header").load(page + "/header",
					function(){
						$(".header_body").children("footer").load(page + "/footer")
						if($("form").eq(0).children("span").eq(0).children("button").eq(0).html() == "登出"){
							$("form").eq(0).parent().append("<div id='WebSocket_down' style='width:390px'></div><button id='openWebSocket'>線上客服</button><script src=\"" + page + "/js/WebSocket.js\"></script>")
						}
					}
				)
			}else{
				$(".header_body").children("header").load(page + "/header",
					function(){
						$(".header_body").children("footer").load(page + "/footer")
						if($("form").eq(0).children("span").eq(0).children("button").eq(0).html() == "登出"){
							$("form").eq(0).parent().append("<div id='WebSocket_down' style='width:550px'></div><button id='openWebSocket'>線上客服</button><script src=\"" + page + "/js/WebSocketManager.js\"></script>")
						}
					}
				)
			}
		}
	})
	
	
})