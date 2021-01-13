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
	
	$('#pwdChange').click(function(){
		$('#MCtable').find("td").css({"background-color":"#F3EAD8","transform":"scale(1)"})
		$(this).css({"background-color":"#E3D1A8","transform":"scale(1.3)"});		
		$('fieldset').eq(1).load("/TestVersion/passwordDup",function(){
		$('#password1').blur(function(){
		let password = document.getElementById("password1").value;
		let sp = document.getElementById("sp1");
		  
		if(password ==""){
	        document.querySelector("#sp1").innerHTML="不可空白"
			document.querySelector("#sp1").style.color="red";
	    }else if(password.length< 8){
	        document.querySelector("#sp1").innerHTML="帳號長度要大於8"
			document.querySelector("#sp1").style.color="red";
	    }else{
		$.ajax({
			async:false,
			type:"POST",
			url:"passwordDup",
			dataType:"json",
			data:{"oldPassword":password},
			success:function(dup){
				if(dup){
			document.querySelector("#sp1").innerHTML="密碼不一致，請重新輸入"
			document.querySelector("#sp1").style.color="red";
				}else{
			document.querySelector("#sp1").innerHTML="密碼相同";
			document.querySelector("#sp1").style.color="green";
				}
			}
		});
		}	
	})
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
	
	$('#shopHistory').click(function(){
		$('#MCtable').find("td").css({"background-color":"#F3EAD8","transform":"scale(1)"})
		$(this).css({"background-color":"#E3D1A8","transform":"scale(1.3)"});
		$('fieldset').eq(1).load("/TestVersion/shopHistory",function(){
			$('.shopDetails').each(function(){
				$(this).click(function(){
					getOrderDetail($(this).parent().parent().children("td").eq(0).html());
				})
			})
		})
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
		$("#show").attr("src", this.result).removeAttr('hidden');
		}
	})
}
	
function getOrderDetail(orderId){
	$.ajax({
		url:"getOrderDetail",
		type:"POST",
		data:{
			"orderId":orderId
		},
		dataType:"json",
		success:function(orderDetail){
			let s = "<table><tr><td>商品名稱</td><td>商品單價</td><td>購買數量</td></tr>";
			for(let i=0; i<orderDetail[0].length; i++){
				s += ("<tr id=" + orderDetail[0][i] + "><td>" + orderDetail[1][i] + "</td><td>" + orderDetail[2][i] + "</td><td>" + orderDetail[3][i] + "</td></tr>")
			}
			s +="</table><button class='close'>關閉</button>"			
			$(".centerOver").html(s)
			$(".backOver").attr("class", "backOn")
			$(".centerOver").attr("class", "centerOn")
			$(".close").click(function(){
				$(".centerOn").attr("class", "centerOver").html("")
				$(".backOn").attr("class", "backOver")
	})
	
		}
	})
}

function checkPassword() {
    let pd = document.getElementById("password2").value;
    if (pd=="") {
        document.querySelector("#sp2").innerHTML="不可空白"
		document.querySelector("#sp2").style.color="red";
    }else if (pd.length < 8){
        document.querySelector("#sp2").innerHTML="密碼長度必須大於8"
		document.querySelector("#sp2").style.color="red";
    } else if (pd.search(/\d/) == -1) {
        document.querySelector("#sp2").innerHTML="必須包含數字"
		document.querySelector("#sp2").style.color="red";		
    } else if (pd.search(/[a-zA-Z]/) == -1) {
        document.querySelector("#sp2").innerHTML="必須包含英文字母"
		document.querySelector("#sp2").style.color="red";
    }else{
        document.querySelector("#sp2").innerHTML="";
    }
}

function checkPasswordAgain(){
	let pd = document.getElementById("password2").value;
    let cpd = document.getElementById("password3").value;
    if(cpd == pd){
         document.querySelector("#sp3").innerHTML="";
    }else{
        document.querySelector("#sp3").innerHTML="密碼不一致,請重新輸入"
		document.querySelector("#sp3").style.color="red";
		
    }
}

function showhide1(){
     let eye = document.getElementById("eye1");
     let pwd = document.getElementById("password1");
     if (pwd.type == "password1") {
         pwd.type = "text";
         eye.className='fa fa-eye-slash'
     }else {
         pwd.type = "password1";
         eye.className='fa fa-eye'
     }
}

function showhide2(){
     let eye = document.getElementById("eye2");
     let pwd = document.getElementById("password2");
     if (pwd.type == "password2") {
         pwd.type = "text";
         eye.className='fa fa-eye-slash'
     }else {
         pwd.type = "password2";
         eye.className='fa fa-eye'
     }
}

function showhide3(){
     let eye = document.getElementById("eye3");
     let pwd = document.getElementById("password3");
     if (pwd.type == "password3") {
         pwd.type = "text";
         eye.className='fa fa-eye-slash'
     }else {
         pwd.type = "password3";
         eye.className='fa fa-eye'
     }
}