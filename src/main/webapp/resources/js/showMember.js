$(document).ready(function(){	
    $('img').each(function(){
	var src = $(this);
		if($(this).attr("src") == ""){
			$.ajax({
				url:"memberImages",
				data: {
					img : $(this).parent().parent().children().eq(0).html()
				},
				dataType: 'text',
				type:'POST',
				success:function(img){
					src.attr("src", img)
				}
			})
		}
	})
	
	$(".slider").each(function(){
		if($(this).attr("checktype") == 'true'){
			$(this).click();
		}
		$(this).click(function(){
			let s = $(this);
			$.ajax({
				url:"changeAu",
				data:{
					'id': s.parent().parent().parent().children('td').eq(0).html()
				},
				type:"POST",
				success:function(){
					if(s.attr("checktype") == 'true'){
						s.attr("checktype", "false");
					}else{
						s.attr("checktype", "true");
					}
					
				}
			})
		})
	})
	
	
	$('td').eq(0).click(function(){
		$('fieldset').eq(1).load("/TestVersion/updateMember")
	})
	
	$('td').eq(1).click(function(){
		$('fieldset').eq(1).load("/TestVersion/viewHistory")
	})
	
	$('td').eq(2).click(function(){
		$('fieldset').eq(1).load("/TestVersion/disHistory")
	})
})



