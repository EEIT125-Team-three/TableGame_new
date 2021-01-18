$(document).ready(function(){	
	getImg();
	var beginPage = $('fieldset').eq(1).html();
	
	$('#UMP').click(function(){
		$('#MCtable').find("td").css({"background-color":"#F3EAD8","transform":"scale(1)"})
		$(this).css({"background-color":"#E3D1A8","transform":"scale(1.3)"});
		$('fieldset').eq(1).load("/TestVersion/updateMember",function(){
				getImg();
				changePic();
				getMemberAddress();
				$("#city").change(function(){
					getAllDistrict();
				})
				$("#district").change(function(){
					getAllRoad();
				})
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
		$('fieldset').eq(1).load("/TestVersion/DiscussionBoard/disHistory")
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
		console.log("AB")
		dataTable();
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
     if (pwd.type == "password") {
         pwd.type = "text";
         eye.className='fa fa-eye-slash fa-2x'
     }else {
         pwd.type = "password";
         eye.className='fa fa-eye fa-2x'
     }
}

function showhide2(){
     let eye = document.getElementById("eye2");
     let pwd = document.getElementById("password2");
     if (pwd.type == "password") {
         pwd.type = "text";
         eye.className='fa fa-eye-slash fa-2x'
     }else {
         pwd.type = "password";
         eye.className='fa fa-eye fa-2x'
     }
}

function showhide3(){
     let eye = document.getElementById("eye3");
     let pwd = document.getElementById("password3");
     if (pwd.type == "password") {
         pwd.type = "text";
         eye.className='fa fa-eye-slash fa-2x'
     }else {
         pwd.type = "password";
         eye.className='fa fa-eye fa-2x'
     }
}

function dataTable() {
	console.log($('#table1'))
	$('#table1').DataTable({
		bFilter: true,
		bPaginate: true, // 顯示換頁
		searching: true, // 顯示搜尋
		info: true, // 顯示資訊
		fixedHeader: true, // 標題置頂
		destroy:true,
		language:{
		"processing": "處理中...",
		"loadingRecords": "載入中...",
		"lengthMenu": "顯示 _MENU_ 項結果",
		"zeroRecords": "沒有符合的結果",
		"info": "顯示第 _START_ 至 _END_ 項結果，共 _TOTAL_ 項",
		"infoEmpty": "顯示第 0 至 0 項結果，共 0 項",
		"infoFiltered": "(從 _MAX_ 項結果中過濾)",
		"search": "搜尋:",
		"paginate": {
		"first": "第一頁",
		"previous": "上一頁",
		"next": "下一頁",
		"last": "最後一頁"
		},
		"aria": {
		"sortAscending": ": 升冪排列",
		"sortDescending": ": 降冪排列"
		},
		"select": {
		"1": "%d 列已選擇",
		"2": "%d 列已選擇",
		"_": "%d 列已選擇"
		}
		}
	})
}

function getAllCity(){
	$.ajax({
		url:"/TestVersion/getAllCity",
		type:"POST",
		dataType:"json",
		success:function(allCity){
			let s = "";
			if(cityId != null){
				for(let i=0; i<allCity.length; i++){
					if(cityId == allCity[i].cityId){
						s += "<option selected value=" + allCity[i].cityId + ">" + allCity[i].city + "</option>"
					}else{
						s += "<option value=" + allCity[i].cityId + ">" + allCity[i].city + "</option>"					
					}
				}
				cityId = null;
			}else{
				for(let i=0; i<allCity.length; i++){
					s += "<option value=" + allCity[i].cityId + ">" + allCity[i].city + "</option>"
				}
			}
			$("#city").html(s);
			getAllDistrict();
		}
	})
}

function getAllDistrict(){
	$.ajax({
		url:"/TestVersion/getAllDistrict",
		type:"POST",
		dataType:"json",
		data:{
			"cityId":$("#city").val()
		},
		success:function(allDistrict){
			let s = "";
			if(districtId != null){
				for(let i=0; i<allDistrict.length; i++){
					if(districtId == allDistrict[i].districtId){
						s += "<option selected value=" + allDistrict[i].districtId + ">" + allDistrict[i].district + "</option>"
					}else{
						s += "<option value=" + allDistrict[i].districtId + ">" + allDistrict[i].district + "</option>"					
					}
				}
				districtId = null;
			}else{
				for(let i=0; i<allDistrict.length; i++){
					s += "<option value=" + allDistrict[i].districtId + ">" + allDistrict[i].district + "</option>"
				}
			}
			$("#district").html(s);
			getAllRoad();
		}
	})
}

function getAllRoad(){
	$.ajax({
		url:"/TestVersion/getAllRoad",
		type:"POST",
		dataType:"json",
		data:{
			"districtId":$("#district").val()
		},
		success:function(allRoad){
			let s = "";
			if(roadId != null){
				for(let i=0; i<allRoad.length; i++){
					if(roadId == allRoad[i].roadId){
						s += "<option selected value=" + allRoad[i].roadId + ">" + allRoad[i].road + "</option>"
					}else{
						s += "<option value=" + allRoad[i].roadId + ">" + allRoad[i].road + "</option>"					
					}
				}
				roadId = null;
			}else{
				for(let i=0; i<allRoad.length; i++){
					s += "<option value=" + allRoad[i].roadId + ">" + allRoad[i].road + "</option>"
				}
			}
			$("#road").html(s);
		}
	})
}

function getMemberAddress(){
	$.ajax({
		url:"/TestVersion/getMemberAddress",
		type:"POST",
		dataType:"json",
		async:false,
		success:function(memberAddress){
			cityId = memberAddress.city;
			districtId = memberAddress.district;
			roadId = memberAddress.road;
			getAllCity();
		}
	})	
}