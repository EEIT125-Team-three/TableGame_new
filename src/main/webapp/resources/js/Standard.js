$(document).ready(function(){
	$(".standard_ul").children("li").each(function(){
		$(this).children("img").click(function(){
			$(this).parent().children("form").css("display","").parent().siblings().children("form").css("display","none")
		})
	})
})


function manager_search_display(){
	let display = document.getElementById("search_fieldset");
	let display1 = document.getElementById("creat_fieldset");
	display.style.display="";
	display1.style.display="none";
}

function manager_creat_display(){
	let display = document.getElementById("search_fieldset");
	let display1 = document.getElementById("creat_fieldset");
	display.style.display="none";
	display1.style.display="";
}
