var page = "/TestVersion"
$(document).ready(function(){
	var init = $(".header_body").html();	
	$(".header_body").children("header").load(page + "/header",
		function(responseText,textStatus){
		}
	)
})