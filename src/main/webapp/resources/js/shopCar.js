$(document).ready(function(){
    $(".shopCar_button").each(function(){
        $(this).click(function(){
            $(this).css("background-color", "gray").siblings("button").css("background-color", "white")
			dataLink();
        })
    }).eq(0).css("margin-left", "500px").css("background-color", "gray")
})

function dataLink(){ //新增後端傳來的元素
		$.ajax({
			withCredentials:true,
			url:"test",
			dataType: 'json',
			async:false,
			type:'GET',
			success : function(String, Object){
				console.log(String)
				console.log(Object)
			},
			error:function(){console.log("bbb")}
		});
	}