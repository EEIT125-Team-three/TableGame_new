$(document).ready(function(){	
	getImg();
	var beginPage = $('fieldset').eq(1).html();
	
	$('#UMP').click(function(){
		$('#MCtable').find("td").css({"background-color":"#F3EAD8","transform":"scale(1)"})
		$(this).css({"background-color":"#E3D1A8","transform":"scale(1.3)"});		
		$('fieldset').eq(1).load("/TestVersion/updateMember",function(){
			getImg();
			changePic();
		})
	})
	
	$('#viewHistory').click(function(){
		$('#MCtable').find("td").css({"background-color":"#F3EAD8","transform":"scale(1)"})
		$(this).css({"background-color":"#E3D1A8","transform":"scale(1.3)"});
		$('fieldset').eq(1).load("/TestVersion/viewHistory")
	})
	
	$('#disHistory').click(function(){
		$('#MCtable').find("td").css({"background-color":"#F3EAD8","transform":"scale(1)"})
		$(this).css({"background-color":"#E3D1A8","transform":"scale(1.3)"});
		$('fieldset').eq(1).load("/TestVersion/disHistory")
	})
	
	$('#infoHistory').click(function(){
		$('#MCtable').find("td").css({"background-color":"#F3EAD8","transform":"scale(1)"})
		$(this).css({"background-color":"#E3D1A8","transform":"scale(1.3)"});
		$('fieldset').eq(1).load("/TestVersion/infoHistory")
	})
	
	$('#showMembers').click(function(){
		$('#MCtable').find("td").css({"background-color":"#F3EAD8","transform":"scale(1)"})
		$(this).css({"background-color":"#E3D1A8","transform":"scale(1.3)"});
		$('fieldset').eq(1).load("/TestVersion/showMembers",function(){
			getImg();
			changeAu();
			$('.UM').click(function(){
				$('fieldset').eq(1).load("/TestVersion/updateMember?id=" + $(this).parent().parent().children("td").eq(0).html(),function(){
					getImg();
					changePic();
					$('#UM_Btn').click(function(){
					    $('fieldset').eq(1).load("/TestVersion/showMembers")
					})				
				})
			})
		})
	})
	
	$('#searchMembers').click(function(){
		$('#MCtable').find("td").css({"background-color":"#F3EAD8","transform":"scale(1)"})
		$(this).css({"background-color":"#E3D1A8","transform":"scale(1.3)"});
		$('fieldset').eq(1).load("/TestVersion/search",function(){
						
			$("#SearchMemberByAccount2").click(function(){
				let s = $("#SearchMemberByAccount1").val();
				$('fieldset').eq(1).load("/TestVersion/searchMemberByAccount?account=" + s,function(){
					getImg();
					changeAu();	
				})
			})
			
			$("#SearchMemberByName2").click(function(){
				let s = $("#SearchMemberByName1").val();
				$('fieldset').eq(1).load("/TestVersion/searchMemberByName?name=" + s,function(){
					getImg();
					changeAu();	
				})
			})
			
			$("#SearchMemberByAddress2").click(function(){
				let s = $("#SearchMemberByAddress1").val();
				$('fieldset').eq(1).load("/TestVersion/searchMemberByAddress?address=" + s,function(){
					getImg();
					changeAu();	
				})
			})
			
			$("#SearchMemberByAu").click(function(){
				$('fieldset').eq(1).load("/TestVersion/searchMemberByAu",function(){
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

function changePic(){
	$("#pic").change(function() {
		var readFile = new FileReader();
		var mfile = $("#pic")[0].files[0]; //注意這裡必須時$("#myfile")[0]，document.getElementById('file')等價與$("#myfile")[0]
		readFile.readAsDataURL(mfile);
		readFile.onload = function() {
		$("#show").attr("src", this.result);
		}
	})
}
	

