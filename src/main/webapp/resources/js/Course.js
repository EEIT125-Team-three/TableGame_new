function showCourseAjax(t) {
	let actType = t
	$.ajax({
		url: "/TestVersion/showCourseAjax",
		data: {
			"actType": actType,
			"activity": "課程"
		},
		dataType: 'json',
		type: 'POST',
		success: function(info) {
			console.log(info)
			let s = "";
			for (let i = 0; i < info.length; i++) {
				s +=
					"<div class='col-1' style='float:left;width:33%;'><table bgcolor='green' border='1' style='text-align: center ;margin:10px;'><tbody><tr bgcolor='white'><th style='display: none'>"
					+ info[i].activityId + "</th><th>地點</th><th colspan='6'>"
					+ info[i].actLocation + "</th></tr><tr bgcolor='white'><th>地址</th><th colspan='6'>"
					+ info[i].actAddress + "</th></tr><tr bgcolor='white'><th>費用</th><th colspan='6'>"
					+ info[i].actCost + "</th></tr><tr bgcolor='white'><td>活動日期(1)</td><td>活動時間(1)</td><td>活動日期(2)</td><td>活動時間(2)</td><td>報名</td></tr><tr bgcolor='white'><td>"
					+ info[i].actDate1 + "</td><td>"
					+ info[i].actStrTime1 + "~"
					+ info[i].actEndTime1 + "</td><td>"
					+ info[i].actDate2 + "</td><td>"
					+ info[i].actStrTime2 + "~"
					+ info[i].actEndTime2 + "</td><td><button type='button' onclick='sign("
					+ info[i].activityId + ")'>立即報名</button></td></tr></tbody></table></div><br>";

			}
			$("div.row").html(s);
		}
	})
}
function sign(i) {
	console.log(i)
	$('#addEvent').children("input").attr("value", i);
	$('#addEvent').submit();
}
function showTPICampAjax() {
	$.ajax({
		url: "/TestVersion/showTPICampAjax",
		data: {
			"actArea": "台北",
			"actType": "桌遊營"
		},
		dataType: 'json',
		type: 'POST',
		success: function(info) {
			let s = "";
			for (let i = 0; i < info.length; i++) {
				s += "<thead bgcolor='#00A600'><th>類型</th><th>地點</th><th>地址</th><th>活動日期</th><th>活動時間(1)</th><th>活動時間(2)</th><th>天數</th><th>限制人數</th><th>費用</th><th>報名活動</th></thead><tr bgcolor='white'><th style='display: none'>"
					+ info[i].activityId +
					"</td><td>" + info[i].actType +
					"</td><td>" + info[i].actLocation +
					"</td><td>" + info[i].actAddress +
					"</td><td>" + info[i].actDate1 + " 至 " + info[i].actDate2 +
					"</td><td>" + info[i].actStrTime1 + "~" + info[i].actEndTime1 +
					"</td><td>" + info[i].actStrTime2 + "~" + info[i].actEndTime2 +
					"</td><td>" + info[i].actDay +
					"</td><td>" + info[i].actLimitPer +
					"</td><td>" + info[i].actCost +
					"</td><td><button type='button' onclick='sign("
					+ info[i].activityId + ")'>報名</button></td></tr>";
			}
			$("tbody.TPItab").html(s);
		}
	})
}
function showTCHCampAjax() {
	$.ajax({
		url: "/TestVersion/showTCHCampAjax",
		data: {
			"actArea": "台中",
			"actType": "桌遊營"
		},
		dataType: 'json',
		type: 'POST',
		success: function(info) {
			let s = "";
			for (let i = 0; i < info.length; i++) {
				s += "<thead bgcolor='#00A600'><th>類型</th><th>地點</th><th>地址</th><th>活動日期</th><th>活動時間(1)</th><th>活動時間(2)</th><th>天數</th><th>限制人數</th><th>費用</th><th>報名活動</th></thead><tr bgcolor='white'><th style='display: none'>"
					+ info[i].activityId +
					"</td><td>" + info[i].actType +
					"</td><td>" + info[i].actLocation +
					"</td><td>" + info[i].actAddress +
					"</td><td>" + info[i].actDate1 + " 至 " + info[i].actDate2 +
					"</td><td>" + info[i].actStrTime1 + "~" + info[i].actEndTime1 +
					"</td><td>" + info[i].actStrTime2 + "~" + info[i].actEndTime2 +
					"</td><td>" + info[i].actDay +
					"</td><td>" + info[i].actLimitPer +
					"</td><td>" + info[i].actCost +
					"</td><td><button type='button' onclick='sign("
					+ info[i].activityId + ")'>報名</button></td></tr>";
			}
			$("tbody.TCHtab").html(s);
		}
	})
}
function showKOHCampAjax() {
	$.ajax({
		url: "/TestVersion/showKOHCampAjax",
		data: {
			"actArea": "高雄",
			"actType": "桌遊營"
		},
		dataType: 'json',
		type: 'POST',
		success: function(info) {
			let s = "";
			for (let i = 0; i < info.length; i++) {
				s += "<thead bgcolor='#00A600'><th>類型</th><th>地點</th><th>地址</th><th>活動日期</th><th>活動時間(1)</th><th>活動時間(2)</th><th>天數</th><th>限制人數</th><th>費用</th><th>報名活動</th></thead><tr bgcolor='white'><th style='display: none'>"
					+ info[i].activityId +
					"</td><td>" + info[i].actType +
					"</td><td>" + info[i].actLocation +
					"</td><td>" + info[i].actAddress +
					"</td><td>" + info[i].actDate1 + " 至 " + info[i].actDate2 +
					"</td><td>" + info[i].actStrTime1 + "~" + info[i].actEndTime1 +
					"</td><td>" + info[i].actStrTime2 + "~" + info[i].actEndTime2 +
					"</td><td>" + info[i].actDay +
					"</td><td>" + info[i].actLimitPer +
					"</td><td>" + info[i].actCost +
					"</td><td><button type='button' onclick='sign("
					+ info[i].activityId + ")'>報名</button></td></tr>";
			}
			$("tbody.KOHtab").html(s);
		}
	})
}