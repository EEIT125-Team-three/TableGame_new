function showAllLocationAjax(){
	$.ajax({
		url:"showAllLocationAjax",
		data:{"actType" : "活動"
		},
		dataType: 'json',
		type:'POST',
		success: function(htmlobj){
			console.log(htmlobj);
			}
	})
}

