var page = "/TestVersion";
var websocket;
var thisConnection = "127.0.0.1:8080";
var selectMember = 1;
$(function() {
	$("#WebSocket_down").load(page + "/getWebSocketPage", function() {
		$.ajax({
			url: page+"/getMemberChatId",
			type: "POST",
			dataType: "text",
			async: false,
			success: function(obj) {
				websocket = new WebSocket("ws://" + thisConnection + page + "/chat/" + obj);
				createWebSocket();
				startUseButton();
			}
		})
	})
});

//開啟連線使用功能
function createWebSocket() {
	//連線時獲得所有線上會員編號
	websocket.onopen = function(evnt) {
		$("#tou").html($("form").eq(0).html().split("</span>")[1].split(" ")[1]);
		createAllMemberButton();
	};
	//收到訊息
	websocket.onmessage = function(evnt) {
		console.log(selectMember == evnt.data.split(",")[0] || evnt.data.split(",").length == 1 || evnt.data.split(",")[0].includes("："))
		if (evnt.data.split("NowIs")[0] == "" && evnt.data.split("NowIs").length == 2) {
			//新連線用戶
			let s = "<button class='button_AllMember'>";
			s += evnt.data.split("NowIs")[1];
			s += "</button>";
			$("#allOnlineMember").append(s);
			startAllMemberButton();
		} else if (selectMember == evnt.data.split(",")[0]) {
			//正在看著的用戶傳來的訊息
			$("#msg").append("<span>" + evnt.data.substring(evnt.data.split(",")[0].length + 1, evnt.data.length) + "</span><br>");
			//設定滑鼠高度
			var scrollTop = $("#msg")[0].scrollHeight;
			$("#msg").scrollTop(scrollTop);
		} else if (evnt.data.split(",").length == 1 || evnt.data.split(",")[0].includes("：")) {
			//系統自動回復
			$("#msg").append("<span>" + evnt.data + "</span><br>");
			//設定滑鼠高度
			var scrollTop = $("#msg")[0].scrollHeight;
			$("#msg").scrollTop(scrollTop);
		} else {
			//沒看著的用戶傳來的訊息
			$(".button_AllMember").each(function() {
				if ($(this).html() == evnt.data.split(",")[0]) {
					$(this).remove();
				}
			})
			let s = "<button class='button_AllMember' noread='noread'>";
			s += evnt.data.split(",")[0];
			s += "</button>";
			$("#allOnlineMember").prepend(s);
			startAllMemberButton();
		}
	};
	//	websocket.onerror = function(evnt) { };
	websocket.onclose = function(evnt) {
		$("#tou").html("與伺服器斷開了連結!")
	}
}

//開啟按鈕功能
function startUseButton() {
	//開啟/關閉聊天室窗
	$("#openWebSocket").click(function() {
		$(this).attr("hidden", "hidden")
		$("#WebSocket_down").attr("id", "WebSocket_float");
		$(".close").mouseover(function() {
			$(this).css("opacity", "0.6");
		}).mouseout(function() {
			$(this).css("opacity", "0.3");
		}).click(function() {
			$(this).css("opacity", "0.3").unbind();
			$("#WebSocket_float").attr("id", "WebSocket_down");
			$("#openWebSocket").removeAttr("hidden");
			selectMember = 1;
		})
	})
	//訊息送出
	$('#send').click(function() {
		if ($("#message").val().trim() != "" && selectMember != 1) {
			$.ajax({
				url: page + "/message/sentToMember",
				type: "POST",
				data: {
					"userId": selectMember,
					"message": $("#message").val()
				},
				success: function() {
					$("#message").val("");
				}
			})
		}
	});
}

//開啟各會員聊天窗按鈕
function startAllMemberButton() {
	$(".button_AllMember").unbind();
	$(".button_AllMember").click(function() {
		if($(this).html() != selectMember){
			$(this).css("background-color", "yellow");
			$(this).removeAttr("noread");
			if (selectMember != 1) {
				$(".button_AllMember").each(function() {
					if ($(this).html() == selectMember) {
						$(this).css("background-color", "rgb(255, 199, 194)");
					}
				})
			}
			selectMember = $(this).html();
			$("textarea").eq(0).attr("placeholder","傳送訊息給 "+selectMember+" : ");
			$.ajax({
				url: page + "/message/getMemberMessage",
				type: "POST",
				dataType: "json",
				data: {
					"memberId": selectMember
				},
				success: function(thisMemberContextHistory) {
					let s = "";
					for (let i = 0; i < thisMemberContextHistory.length; i++) {
						s += ("<span>" + thisMemberContextHistory[i] + "</span><br>");
					}
					//設定滑鼠高度
					$("#msg").html(s);
					var scrollTop = $("#msg")[0].scrollHeight;
					$("#msg").scrollTop(scrollTop);
	
	
				}
			})		
		}
	})
}

//建立會員清單
function createAllMemberButton() {
	$.ajax({
		url: page + "/message/getAllMember",
		type: "POST",
		dataType: "json",
		success: function(obj) {
			let s = "";
			for (let i = 0; i < obj.length; i++) {
				if (obj[i] != 1) {
					s += "<button class='button_AllMember'>";
					s += obj[i];
					s += "</button>";
				}
			}
			$("#allOnlineMember").html(s);
			startAllMemberButton();
		}
	})
}