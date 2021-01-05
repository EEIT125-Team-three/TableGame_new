	$('#Area').blur(function(){
		let area = $('#Area').val();
		let sp1 = document.getElementById("actsp1");
		if(area==""){
			sp1.innerHTML="是要辦在哪裡~~"
			sp1.style.color="red";
			}else {
				sp.innerHTML="";
		}
	})	
	$('#Act').blur(function(){
		let act = $('#Act').val();
		let sp2 = document.getElementById("actsp2");
		if(act==""){
			sp2.innerHTML="開課還是活動!!"
			sp2.style.color="red";
			}else {
				sp2.innerHTML="";
		}
	})	
$('#Type').blur(function(){
		let type = $('#Type').val();
		let sp3 = document.getElementById("actsp3");
		if(type==""){
			sp3.innerHTML="有什麼可以玩?"
			sp3.style.color="red";
			}else {
				sp3.innerHTML="";
		}
	})	

	