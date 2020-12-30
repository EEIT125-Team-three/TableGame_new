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
	
	
	$('#UMP').click(function(){
		$('fieldset').eq(1).load("/TestVersion/updateMember")
	})
	
	$('#viewHistory').click(function(){
		$('fieldset').eq(1).load("/TestVersion/viewHistory")
	})
	
	$('#disHistory').click(function(){
		$('fieldset').eq(1).load("/TestVersion/disHistory")
	})
	
	$('#infoHistory').click(function(){
		$('fieldset').eq(1).load("/TestVersion/infoHistory")
	})
	
	$('#showMembers').unbind().click(function(){
		$('fieldset').eq(1).load("/TestVersion/showMembers")
	})
	
	$('.UM').click(function(){
		$('fieldset').eq(1).load("/TestVersion/updateMember?id=" + $(this).parent().parent().children("td").eq(0).html())
	})
	
})



