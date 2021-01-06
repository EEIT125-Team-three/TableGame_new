function showCourseAjax(t){
	let actType = t
	$.ajax({
		url:"/TestVersion/showCourseAjax",
		data:{
			"actType":actType,
			"activity":"課程"
			},
			dataType:'json',
			type:'POST',
			success:function(info){
				let s ="";
				for(let i =0; i<info.length;i++){
					s += "<tr bgcolor='white'><th style='display: none'>"
					+ info[i].activityId + "</th><th>地點</th><th colspan='6'>"
					+ info[i].actLocation + "</th></tr><tr bgcolor='white'><th>地址</th><th colspan='6'>"
					+ info[i].actAddress +"</th></tr><tr bgcolor='white'><th>費用</th><th colspan='6'>"
					+ info[i].actCost +"</th></tr><tr bgcolor='white'><td>第一天日期</td><td>開始時間</td><td>結束時間</td><td>第二天日期</td><td>開始時間</td><td>結束時間</td><td>報名</td></tr><tr bgcolor='white'><td>"
					+ info[i].actDate1 +"</td><td>"
					+ info[i].actStrTime1 +"</td><td>"
					+ info[i].actEndTime1 +"</td><td>"
					+ info[i].actDate2 +"</td><td>"
					+ info[i].actStrTime2 +"</td><td>"
					+ info[i].actEndTime2 +"</td><td><button type='button' onclick='sign("
					+ info[i].activityId + ")'>立即報名</button></td></tr>";
				}
				$("tbody.tb1").html(s);
		}
	})
}
function sign(i){
	console.log(i)
	$('#addEvent').children("input").attr("value", i);
	$('#addEvent').submit();
}
function showCampAjax(){
	$.ajax({
		url:"/TestVersion/showCampAjax",
		data:{
			"actType":"桌遊營",
			"activity":"課程"
			},
			dataType:'json',
			type:'POST',
			success:function(info){
				let s ="";
				for(let i =0; i<info.length;i++){
					s+= "<tr bgcolor='white'><th style='display: none'>" 
				+ info[i].activityId + 
				"</td><td>" + info[i].actArea + 
				"</td><td>" + info[i].activity + 
				"</td><td>" + info[i].actType + 
				"</td><td>" + info[i].actDate1 + 
				"</td><td>" + info[i].actStrTime1 + 
				"</td><td>" + info[i].actEndTime1 + 
				"</td><td>" + info[i].actDate2 + 
				"</td><td>" + info[i].actStrTime2 + 
				"</td><td>" + info[i].actEndTime2 + 
				"</td><td>" + info[i].actDay + 
				"</td><td>" + info[i].actLimitPer + 
				"</td><td>" + info[i].actCost + 
				"</td><td><button type='button' onclick='sign("
				 + info[i].activityId + ")'>報名</button></td></tr>";
				}
				$("tbody.tb2").html(s);
		}
	})
	}