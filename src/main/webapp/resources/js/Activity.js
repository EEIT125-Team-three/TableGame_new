function showAreaAjax(a){
	let actArea = a
	$.ajax({
		url:"/TestVersion/showAreaAjax",
		data:{
		"actArea" : actArea,
			"activity" : "活動"
		},
		dataType: 'json',
		type:'POST',
		success: function(info){
			let s = "";
			for(let i=0; i< info.length; i++){
				s += "<tr><td style='display: none'>" 
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
			$("tbody").html(s);
		}
	})	
}
$(document).ready(function(){
	showAllAreaAjax();
})

function sign(i){
	console.log(i)
	$('#addEvent').children("input").attr("value", i);
	$('#addEvent').submit();
}
function showAllAreaAjax(){
	$.ajax({
		url:"/TestVersion/showAllAreaAjax",
		data:{
			"activity" : "活動"
		},
		dataType: 'json',
		type:'POST',
		success: function(info){
			console.log(info[0].activityId);
			let s = "";
			for(let i=0; i< info.length; i++){
				s += "<tr><td style='display: none'>" 
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
			$("tbody").html(s);
		}
	})	
}