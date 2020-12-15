			console.log(h);
$(document).ready(function(){
			var wait = $(".header_body").html();
			$(".header_body").load(h + "/header?b=" + s,function(responseText,textStatus){
				$(".header_body").html(responseText + wait)
			});
		})