$(document).ready(function(){	
	var beginPage = $('fieldset').eq(1).html();
	$('#UMP').click(function(){
		$('fieldset').eq(1).load("/TestVersion/updateMember",function(){
			getImg();
		})
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
	
	$('#showMembers').click(function(){
		$('fieldset').eq(1).load("/TestVersion/showMembers",function(){
			getImg();
			changeAu();
			$('.UM').click(function(){
				$('fieldset').eq(1).load("/TestVersion/updateMember?id=" + $(this).parent().parent().children("td").eq(0).html(),function(){
					getImg();
				//$('fieldset').eq(1).html("<span>修改成功</span>" + beginPage);
				})
			})
		})
	})
	
	$('#searchMembers').click(function(){
		$('fieldset').eq(1).load("/TestVersion/search",function(){			
			$("#SearchMemberByAccount2").click(function(){
				let s = $("#SearchMemberByAccount1").val();
				$('fieldset').eq(1).load("/TestVersion/searchByMemberAccount?account=" + s,function(){
					getImg();
					changeAu();	
				})
			})
			$("#SearchMemberByName2").click(function(){
				let s = $("#SearchMemberByName1").val();
				$('fieldset').eq(1).load("/TestVersion/searchByMemberName?name=" + s,function(){
					getImg();
					changeAu();	
				})
			})
		})
	})
	
	
})
function getImg(){
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
}
function changeAu(){
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
}



