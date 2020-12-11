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
    }
}
function checkMail(){
    let mail = document.getElementById("mailaddress").value;
    if(mail ==""){
        document.querySelector("#sp6").innerHTML="不可空白"
		document.querySelector("#sp6").style.color="red";
    }else{
        document.querySelector("#sp6").innerHTML="";
    }
}

function checkAddress(){
    let mail = document.getElementById("address").value;
    if(mail ==""){
        document.querySelector("#sp7").innerHTML="不可空白"
		document.querySelector("#sp7").style.color="red";
    }else{
        document.querySelector("#sp7").innerHTML="";
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
    }
}

function showhide(){
     let eye = document.getElementById("eye");
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
     if (pwd.type == "cpassword") {
         pwd.type = "text";
         eye.className='fa fa-eye-slash'
     }else {
         pwd.type = "cpassword";
         eye.className='fa fa-eye'
     }
}
