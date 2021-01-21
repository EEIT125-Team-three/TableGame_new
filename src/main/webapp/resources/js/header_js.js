
var page = "/TestVersion"
$(document).ready(function(){	
	$(".header_body").children("header").load(page + "/header",
		function(){
			$(".header_body").children("footer").load(page + "/footer")
			if($("form").eq(0).children("span").eq(0).children("button").eq(0).html() == "登出"){
				$("form").eq(0).parent().append("<div id='WebSocket_down'></div><button id='openWebSocket'>線上客服</button><script src=\"" + page + "/js/WebSocket.js\"></script>")
			}
		}
	)
	
})