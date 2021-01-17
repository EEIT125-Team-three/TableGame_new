var a = false;
var b = false;
var c = false;
var d = false;
var e = false;
var f = false;
var g = false;

	$('#rememberMe').change(function(){
		$('#remember').attr("value", '123');
	})
		
	$('#account1').blur(function(){
		let account = document.getElementById("account1").value;
		let sp = document.getElementById("sp1");
		  
		if(account ==""){
	        document.querySelector("#sp1").innerHTML="不可空白"
			document.querySelector("#sp1").style.color="red";
	    }else if(account.length< 8){
	        document.querySelector("#sp1").innerHTML="帳號長度要大於8"
			document.querySelector("#sp1").style.color="red";
	    }else{
		$.ajax({
			async:false,
			type:"POST",
			url:"insertDup",
			dataType:"json",
			data:{"account":account},
			success:function(dup){
				if(dup){
			document.querySelector("#sp1").innerHTML="帳號已被註冊,請重新選擇"
			document.querySelector("#sp1").style.color="red";
				}else{
			document.querySelector("#sp1").innerHTML="帳號可使用";
			document.querySelector("#sp1").style.color="green";
			a=true;
				}
			}
		});
		}	
	})
	
	
function checkId(){
    let id = document.getElementById("account").value;
    if(id ==""){
        document.querySelector("#sp1").innerHTML="不可空白"
		document.querySelector("#sp1").style.color="red";
    }else if(id.length< 8){
        document.querySelector("#sp1").innerHTML="帳號長度要大於8"
		document.querySelector("#sp1").style.color="red";
    }else{
        document.querySelector("#sp1").innerHTML="";
    }
}

function checkPassword() {
    let pd = document.getElementById("password").value;
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
		b=true;
    }
}

function checkPasswordAgain(){
	let pd = document.getElementById("password").value;
    let cpd = document.getElementById("cpassword").value;
    if(cpd == pd){
         document.querySelector("#sp3").innerHTML="";
    }else{
        document.querySelector("#sp3").innerHTML="密碼不一致,請重新輸入"
		document.querySelector("#sp3").style.color="red";
		
    }
}

function checkName(){
    let name = document.getElementById("name").value;
    if(name ==""){
        document.querySelector("#sp4").innerHTML="不可空白"
		document.querySelector("#sp4").style.color="red";
    }else{
        document.querySelector("#sp4").innerHTML="";
		c=true;
    }
}

function checkPhone(){
    let phone = document.getElementById("phone").value;
    if(phone ==""){
        document.querySelector("#sp5").innerHTML="不可空白"
		document.querySelector("#sp5").style.color="red";
    }else if(phone.length != 10){
		document.querySelector("#sp5").innerHTML="號碼長度錯誤"
		document.querySelector("#sp5").style.color="red";
	}else{
        document.querySelector("#sp5").innerHTML="";
		d=true;
    }
}
function checkMail(){
    let mail = document.getElementById("mailaddress").value;
    if(mail ==""){
        document.querySelector("#sp6").innerHTML="不可空白"
		document.querySelector("#sp6").style.color="red";
    }else{
        document.querySelector("#sp6").innerHTML="";
		e=true;
    }
}

function checkAddress(){
    let mail = document.getElementById("address").value;
    if(mail ==""){
        document.querySelector("#sp7").innerHTML="不可空白"
		document.querySelector("#sp7").style.color="red";
    }else{
        document.querySelector("#sp7").innerHTML="";
		f=true;
    }
}

function checkIdNumber(){
    let phone = document.getElementById("idNumber").value;
    if(phone ==""){
        document.querySelector("#sp8").innerHTML="不可空白"
		document.querySelector("#sp8").style.color="red";
    }else if(phone.length != 10){
		document.querySelector("#sp8").innerHTML="號碼長度錯誤"
		document.querySelector("#sp8").style.color="red";
	}else{
        document.querySelector("#sp8").innerHTML="";
		g=true;
    }
}

function showhide(){
     let eye = document.getElementById("eye1");
     let pwd = document.getElementById("password");
     if (pwd.type == "password") {
         pwd.type = "text";
         eye.className='fa fa-eye-slash'
     }else {
         pwd.type = "password";
         eye.className='fa fa-eye'
     }
}

function showhide1(){
     let eye = document.getElementById("eye");
     let cpwd = document.getElementById("cpassword");
     if (cpwd.type == "cpassword") {
         cpwd.type = "text";
         eye.className='fa fa-eye-slash'
     }else {
         cpwd.type = "cpassword";
         eye.className='fa fa-eye'
     }
}

$("#reset").click(function(){
	$("input").val("")
})

$('#recheck').click(function(){
	if(a){
		if(b){
			if(c){
				if(d){
					if(e){
						if(f){
							if(g){
								$("form").eq(1).submit()
							}else{
			document.querySelector("#sp8").innerHTML="身分證未輸入"
			document.querySelector("#sp8").style.color="red";
		}
						}else{
			document.querySelector("#sp7").innerHTML="地址未輸入"
			document.querySelector("#sp7").style.color="red";
		}
					}else{
			document.querySelector("#sp6").innerHTML="信箱未輸入"
			document.querySelector("#sp6").style.color="red";
		}
				}else{
			document.querySelector("#sp5").innerHTML="手機未輸入"
			document.querySelector("#sp5").style.color="red";
		}
			}else{
			document.querySelector("#sp4").innerHTML="姓名未輸入"
			document.querySelector("#sp4").style.color="red";
		}
		}else{
			document.querySelector("#sp2").innerHTML="密碼未輸入"
			document.querySelector("#sp2").style.color="red";
		}
		}else{
			document.querySelector("#sp1").innerHTML="帳號未輸入"
			document.querySelector("#sp1").style.color="red";
		}
	
		
	})
$(function(){
	getAllCity();
	$("#city").change(function(){
		getAllDistrict();
	})
	$("#district").change(function(){
		getAllRoad();
	})
	$("#pic").change(function() {
		var readFile = new FileReader();
		var mfile = $("#pic")[0].files[0]; //注意這裡必須時$("#myfile")[0]，document.getElementById('file')等價與$("#myfile")[0]
		readFile.readAsDataURL(mfile);
		readFile.onload = function() {
		$("#show").attr("src", this.result).removeAttr('hidden');
		}
	})
})	

function getAllCity(){
	$.ajax({
		url:"/TestVersion/getAllCity",
		type:"POST",
		dataType:"json",
		success:function(allCity){
			console.log(allCity)
			let s = "";
			for(let i=0; i<allCity.length; i++){
				s += "<option value=" + allCity[i].cityId + ">" + allCity[i].city + "</option>"
			}
			$("#city").html(s);
			getAllDistrict();
		}
	})
}

function getAllDistrict(){
	console.log($("#city").val())
	$.ajax({
		url:"/TestVersion/getAllDistrict",
		type:"POST",
		dataType:"json",
		data:{
			"cityId":$("#city").val()
		},
		success:function(allDistrict){
			let s = "";
			for(let i=0; i<allDistrict.length; i++){
				s += "<option value=" + allDistrict[i].districtId + ">" + allDistrict[i].district + "</option>"
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
				for(let i=0; i<allRoad.length; i++){
					s += "<option value=" + allRoad[i].roadId + ">" + allRoad[i].road + "</option>"
				}
			$("#road").html(s);
		}
	})
}