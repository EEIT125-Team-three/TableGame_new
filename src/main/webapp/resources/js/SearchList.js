var page = "/TestVersion"
$(document).ready(function(){
	var init = $(".standard_nav").html();	
	$(".standard_nav").load(page + "/SearchList")
})