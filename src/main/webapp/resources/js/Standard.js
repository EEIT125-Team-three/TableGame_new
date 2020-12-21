
$(document).ready(function(){
	$(".standard_ul").children("li").each(function(){
		$(this).children("img").click(function(){
			if($(this).parent().children("form").css("display") == 'none'){
				$(this).parent().children("form").css("display","").parent().siblings().children("form").css("display","none")
			}else{
				$(this).parent().children("form").css("display","none")
			}
		})
	})
})


