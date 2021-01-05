var page = "/TestVersion"
$(document).ready(function(){	
	$(".header_body").children("header").load(page + "/header",
		function(responseText,textStatus){
			$(".header_body").children("footer").load(page + "/footer")
		}
	)
})