function onSelectAct(){
	console.log($("#Act").val())
	let act = $("#Act").val();
	let s = "";
	if(act == "活動"){
		s += "<option>桌遊聚會</option>";
		s += "<option>桌遊趴</option>";
	}else if(act == "課程"){
		s += "<option>桌遊研習</option>";
		s += "<option>桌遊營</option>";
	}
	$("#Type").html(s)

}
function onSelectArea(){
	console.log($("#Area").val())
	let area=$("#Area").val();
	let a ="";
	if(area =="台北"){
		a +="<option>三重區綜合體育館</option>";
		a +="<option>天鵝桌遊館</option>";
	}else if(area == "台中"){
		a +="<option>龍邦美村</option>";
		a +="<option>瓦屋桌遊休閒館</option>";
	}else if(area == "高雄"){
		a +="<option>高雄國際會議中心</option>";
		a +="<option>頭比家遊戲咖啡館</option>";
	}else if(area == "桃園"){
		a +="<option>桃園展演中心</option>";
		}
	$("#Location").html(a)
	onSelectLoc();
}
function onSelectLoc(){
	let location =$("#Location").val();
	let l;
	if(location=="三重區綜合體育館"){
		l = "新北市三重區新北大道一段2號";
	}else if(location == "天鵝桌遊館"){
		l = "臺北市文山區羅斯福路五段170巷37號";
	}else if(location == "龍邦美村"){
		l = "台中市西區美村路一段270號";
	}else if(location == "瓦屋桌遊休閒館"){
		l = "臺中市台中市南屯區向上南路一段197號";
	}else if(location == "高雄國際會議中心"){
		l = "高雄市鹽埕區中正四路274號";
	}else if(location == "頭比家遊戲咖啡館"){
		l = "高雄市鼓山區明華路7號";
	}else if(location == "桃園展演中心"){
		l = "桃園市桃園區中正路1188號";
	}
	$("#Address").attr("value", l).val(l).prev().html(l)
}
			

		