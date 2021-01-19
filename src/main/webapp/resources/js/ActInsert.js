var a = false;
var b = false;
var c = false;
var d = false;
var e = false;
var f = false;
var g = false;
var h = false;
var i = false;
var j = false;
var k = false;

$('#Area').blur(function() {
	let area = $('#Area').val();
	if (area == "") {
		document.getElementById('actsp1').innerHTML = "請選擇地區"
		document.getElementById('actsp1').style.color = "red";
	} else {
		document.getElementById('actsp1').innerHTML = "";
		a = true;
	}
})
$('#Act').blur(function() {
	let act = $('#Act').val();
	if (act == "") {
		document.getElementById("actsp2").innerHTML = "請選擇舉辦項目"
		document.getElementById("actsp2").style.color = "red";
	} else {
		document.getElementById("actsp2").innerHTML = "";
		b = true;
	}
})
$('#Date1').blur(function() {
	let date1 = $('#Date1').val();
	if (date1 == "") {
		document.getElementById("actsp3").innerHTML = "請選擇活動日期(1)"
		document.getElementById("actsp3").style.color = "red";
	} else {
		document.getElementById("actsp3").innerHTML = "";
		c = true;
	}
})
$('#strtime1').blur(function() {
	let strtime1 = $('#strtime1').val();
	if (strtime1 == "") {
		document.getElementById("actsp4").innerHTML = "請輸入活動開始時間"
		document.getElementById("actsp4").style.color = "red";
	} else {
		document.getElementById("actsp4").innerHTML = "";
		d = true;
	}
})
$('#endtime1').blur(function() {
	let endtime1 = $('#endtime1').val();
	if (endtime1 == "") {
		document.getElementById("actsp4").innerHTML = "請輸入活動結束時間"
		document.getElementById("actsp4").style.color = "red";
	} else {
		document.getElementById("actsp4").innerHTML = "";
		e = true;
	}
})
$('#Date2').blur(function() {
	let date2 = $('#Date2').val();
	if (date2 == "") {
		document.getElementById("actsp5").innerHTML = "請選擇活動日期(2)"
		document.getElementById("actsp5").style.color = "red";
	} else {
		document.getElementById("actsp5").innerHTML = "";
		f = true;
	}
})
$('#strtime2').blur(function() {
	let strtime1 = $('#strtime2').val();
	if (strtime1 == "") {
		document.getElementById("actsp6").innerHTML = "請輸入活動開始時間"
		document.getElementById("actsp6").style.color = "red";
	} else {
		document.getElementById("actsp6").innerHTML = "";
		g = true;
	}
})
$('#endtime2').blur(function() {
	let endtime1 = $('#endtime2').val();
	if (endtime1 == "") {
		document.getElementById("actsp6").innerHTML = "請輸入活動結束時間"
		document.getElementById("actsp6").style.color = "red";
	} else {
		document.getElementById("actsp6").innerHTML = "";
		h = true;
	}
})
$('#Day').blur(function() {
	let day = $('#Day').val();
	if (day == "") {
		document.getElementById("actsp7").innerHTML = "請輸入活動天數"
		document.getElementById("actsp7").style.color = "red";
	} else {
		document.getElementById("actsp7").innerHTML = "";
		i = true;
	}
})
$('#Limitper').blur(function() {
	let day = $('#Limitper').val();
	if (day == "") {
		document.getElementById("actsp8").innerHTML = "請輸入人數限制"
		document.getElementById("actsp8").style.color = "red";
	} else {
		document.getElementById("actsp8").innerHTML = "";
		j = true;
	}
})
$('#Cost').blur(function() {
	let day = $('#Cost').val();
	if (day == "") {
		document.getElementById("actsp9").innerHTML = "請輸入參加費用"
		document.getElementById("actsp9").style.color = "red";
	} else {
		document.getElementById("actsp9").innerHTML = "";
		k = true;
	}
})


$('#recheck').click(function() {
	if (a) {
		if (b) {
			if (c) {
				if (d) {
					if (e) {
						if (f) {
							if (g) {
								if (h) {
									if (i) {
										if (j) {
											if (k) {
												Swal.fire({
													title: '是否新增活動?',
													icon: 'question',
													showCancelButton: true,
													confirmButtonColor: '#3085d6',
													cancelButtonColor: '#d33',
													confirmButtonText: 'confirm',
												}).then((result) => {
													console.log(result.isConfirmed)
													if (result.isConfirmed) {
														Swal.fire(
															'新增成功!',
															'success'
														).then((result) => {
															$("#addInfo").submit();
															return true;
														})
													}
												})
												return false;

											} else {
												document.querySelector("#actsp9").innerHTML = "未輸入報名費用"
												document.querySelector("#actsp9").style.color = "red";
											}
										} else {
											document.querySelector("#actsp8").innerHTML = "未輸入限制人數"
											document.querySelector("#actsp8").style.color = "red";
										}
									} else {
										document.querySelector("#actsp7").innerHTML = "未輸入天數"
										document.querySelector("#actsp7").style.color = "red";
									}
								} else {
									document.querySelector("#actsp6").innerHTML = "未選擇結束時間"
									document.querySelector("#actsp6").style.color = "red";
								}

							} else {
								document.querySelector("#actsp6").innerHTML = "未選擇開始時間"
								document.querySelector("#actsp6").style.color = "red";
							}
						} else {
							document.querySelector("#actsp5").innerHTML = "未選擇日期(2)"
							document.querySelector("#actsp5").style.color = "red";
						}
					} else {
						document.querySelector("#actsp4").innerHTML = "未選擇結束時間"
						document.querySelector("#actsp4").style.color = "red";
					}
				} else {
					document.querySelector("#actsp4").innerHTML = "未選擇開始時間"
					document.querySelector("#actsp4").style.color = "red";
				}
			} else {
				document.querySelector("#actsp3").innerHTML = "未選擇日期(1)"
				document.querySelector("#actsp3").style.color = "red";
			}
		} else {
			document.querySelector("#actsp2").innerHTML = "未選擇舉辦項目"
			document.querySelector("#actsp2").style.color = "red";
		}
	} else {
		document.querySelector("#actsp1").innerHTML = "未選擇地區"
		document.querySelector("#actsp1").style.color = "red";
		}
	})

