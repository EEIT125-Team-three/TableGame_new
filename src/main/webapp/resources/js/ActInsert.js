$('#Area').change(function() {
	let area = $('#Area').val();
	if (area == "") {
		document.getElementById('actsp1').innerHTML = "請選擇地區"
		document.getElementById('actsp1').style.color = "red";
	} else {
		document.getElementById('actsp1').innerHTML = "";

	}
})
$('#Act').change(function() {
	let act = $('#Act').val();
	if (act == "") {
		document.getElementById("actsp2").innerHTML = "請選擇舉辦項目"
		document.getElementById("actsp2").style.color = "red";
	} else {
		document.getElementById("actsp2").innerHTML = "";

	}
})
$('#Type').change(function() {
	let type = $('#Type').val();
	if (type == "") {
		document.getElementById("actsp3").innerHTML = "請選擇舉辦類型"
		document.getElementById("actsp3").style.color = "red";
	} else {
		document.getElementById("actsp3").innerHTML = "";

	}
})
$('#Date1').change(function() {
	let date1 = $('#Date1').val();
	if (date1 == "") {
		document.getElementById("actsp4").innerHTML = "請選擇活動日期(1)"
		document.getElementById("actsp4").style.color = "red";
	} else {
		document.getElementById("actsp4").innerHTML = "";

	}
})
$('#strtime1').change(function() {
	let strtime1 = $('#strtime1').val();
	if (strtime1 == "") {
		document.getElementById("actsp5").innerHTML = "請輸入活動開始時間"
		document.getElementById("actsp5").style.color = "red";
	} else {
		document.getElementById("actsp5").innerHTML = "";

	}
})
$('#endtime1').change(function() {
	let endtime1 = $('#endtime1').val();
	if (endtime1 == "") {
		document.getElementById("actsp5").innerHTML = "請輸入活動結束時間"
		document.getElementById("actsp5").style.color = "red";
	} else {
		document.getElementById("actsp5").innerHTML = "";

	}
})
$('#Date2').change(function() {
	let date2 = $('#Date2').val();
	if (date2 == "") {
		document.getElementById("actsp6").innerHTML = "請選擇活動日期(2)"
		document.getElementById("actsp6").style.color = "red";
	} else {
		document.getElementById("actsp6").innerHTML = "";

	}
})
$('#strtime2').change(function() {
	let strtime1 = $('#strtime2').val();
	if (strtime1 == "") {
		document.getElementById("actsp7").innerHTML = "請輸入活動開始時間"
		document.getElementById("actsp7").style.color = "red";
	} else {
		document.getElementById("actsp7").innerHTML = "";

	}
})
$('#endtime2').change(function() {
	let endtime1 = $('#endtime2').val();
	if (endtime1 == "") {
		document.getElementById("actsp7").innerHTML = "請輸入活動結束時間"
		document.getElementById("actsp7").style.color = "red";
	} else {
		document.getElementById("actsp7").innerHTML = "";

	}
})
$('#Day').change(function() {
	let day = $('#Day').val();
	if (day == "") {
		document.getElementById("actsp8").innerHTML = "請輸入活動天數"
		document.getElementById("actsp8").style.color = "red";
	} else {
		document.getElementById("actsp8").innerHTML = "";

	}
})
$('#Location').change(function() {
	let location = $('#Location').val();
	if (location == "") {
		document.getElementById("actsp9").innerHTML = "請輸入活動地點"
		document.getElementById("actsp9").style.color = "red";
	} else {
		document.getElementById("actsp9").innerHTML = "";

	}
})
$('#Address').change(function() {
	let location = $('#Address').val();
	if (location == "") {
		document.getElementById("actsp10").innerHTML = "請輸入活動地址"
		document.getElementById("actsp10").style.color = "red";
	} else {
		document.getElementById("actsp10").innerHTML = "";

	}
})
$('#Limitper').change(function() {
	let day = $('#Limitper').val();
	if (day == "") {
		document.getElementById("actsp11").innerHTML = "請輸入人數限制"
		document.getElementById("actsp11").style.color = "red";
	} else {
		document.getElementById("actsp11").innerHTML = "";

	}
})
$('#Cost').change(function() {
	let day = $('#Cost').val();
	if (day == "") {
		document.getElementById("actsp12").innerHTML = "請輸入參加費用"
		document.getElementById("actsp12").style.color = "red";
	} else {
		document.getElementById("actsp12").innerHTML = "";

	}
})


$('#recheck').click(function() {
	if ($('#Area').val() != null && $('#Area').val().trim() != "") {
		if ($('#Act').val() != null && $('#Act').val().trim() != "") {
			if ($('#Type').val() != null && $('#Type').val().trim() != "") {
				if ($('#Date1').val() != null && $('#Date1').val().trim() != "") {
					if ($('#strtime1').val() != null && $('#strtime1').val().trim() != "") {
						if ($('#endtime1').val() != null && $('#endtime1').val().trim() != "") {
							if ($('#Date2').val() != null && $('#Date2').val().trim() != "") {
								if ($('#strtime2').val() != null && $('#strtime2').val().trim() != "") {
									if ($('#endtime2').val() != null && $('#endtime2').val().trim() != "") {
										if ($('#Day').val() != null && $('#Day').val().trim() != "") {
											if ($('#Location').val() != null && $('#Location').val().trim() != "") {
												if ($('#Address').val() != null && $('#Address').val().trim() != "") {
													if ($('#Limitper').val() != null && $('#Limitper').val().trim() != "") {
														if ($('#Cost').val() != null && $('#Cost').val().trim() != "") {
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
															document.querySelector("#actsp12").innerHTML = "未輸入報名費用"
															document.querySelector("#actsp12").style.color = "red";
														}
													} else {
														document.querySelector("#actsp11").innerHTML = "未輸入限制人數"
														document.querySelector("#actsp11").style.color = "red";
													}
												} else {
													document.querySelector("#actsp10").innerHTML = "未選擇活動地址"
													document.querySelector("#actsp10").style.color = "red";
												}
											} else {
												document.querySelector("#actsp9").innerHTML = "未選擇活動地點"
												document.querySelector("#actsp9").style.color = "red";
											}
										} else {
											document.querySelector("#actsp8").innerHTML = "未輸入天數"
											document.querySelector("#actsp8").style.color = "red";
										}
									} else {
										document.querySelector("#actsp7").innerHTML = "未選擇結束時間"
										document.querySelector("#actsp7").style.color = "red";
									}

								} else {
									document.querySelector("#actsp7").innerHTML = "未選擇開始時間"
									document.querySelector("#actsp7").style.color = "red";
								}
							} else {
								document.querySelector("#actsp6").innerHTML = "未選擇日期(2)"
								document.querySelector("#actsp6").style.color = "red";
							}
						} else {
							document.querySelector("#actsp5").innerHTML = "未選擇結束時間"
							document.querySelector("#actsp5").style.color = "red";
						}
					} else {
						document.querySelector("#actsp5").innerHTML = "未選擇開始時間"
						document.querySelector("#actsp5").style.color = "red";
					}
				} else {
					document.querySelector("#actsp4").innerHTML = "未選擇日期(1)"
					document.querySelector("#actsp4").style.color = "red";
				}
			} else {
				document.querySelector("#actsp3").innerHTML = "未選擇舉辦類型"
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
$('#quickAdd').click(function() {

	document.querySelector("#Date1").value = "2021-02-03";
	document.querySelector("#strtime1").value = "09:30";
	document.querySelector("#endtime1").value = "16:30";
	document.querySelector("#Date2").value = "2021-02-08";
	document.querySelector("#strtime2").value = "09:30";
	document.querySelector("#endtime2").value = "16:30";
	document.querySelector("#Day").value = "5";
	document.querySelector("#Limitper").value = "30";
	document.querySelector("#Cost").value = "5000";
})
$('#updatecheck').click(function() {
	if ($('#Area').val() != null && $('#Area').val().trim() != "") {
		if ($('#Act').val() != null && $('#Act').val().trim() != "") {
			if ($('#Type').val() != null && $('#Type').val().trim() != "") {
				if ($('#Date1').val() != null && $('#Date1').val().trim() != "") {
					if ($('#strtime1').val() != null && $('#strtime1').val().trim() != "") {
						if ($('#endtime1').val() != null && $('#endtime1').val().trim() != "") {
							if ($('#Date2').val() != null && $('#Date2').val().trim() != "") {
								if ($('#strtime2').val() != null && $('#strtime2').val().trim() != "") {
									if ($('#endtime2').val() != null && $('#endtime2').val().trim() != "") {
										if ($('#Day').val() != null && $('#Day').val().trim() != "") {
											if ($('#Location').val() != null && $('#Location').val().trim() != "") {
												if ($('#Address').val() != null && $('#Address').val().trim() != "") {
													if ($('#Limitper').val() != null && $('#Limitper').val().trim() != "") {
														if ($('#Cost').val() != null && $('#Cost').val().trim() != "") {
															Swal.fire({
																title: '確認修改活動?',
																icon: 'question',
																showCancelButton: true,
																confirmButtonColor: '#3085d6',
																cancelButtonColor: '#d33',
																confirmButtonText: 'confirm',
															}).then((result) => {
																console.log(result.isConfirmed)
																if (result.isConfirmed) {
																	Swal.fire(
																		'修改成功!',
																		'success'
																	).then((result) => {
																		$("#addInfo").submit();
																		return true;
																	})
																}
															})
															return false;

														} else {
															document.querySelector("#actsp12").innerHTML = "未輸入報名費用"
															document.querySelector("#actsp12").style.color = "red";
														}
													} else {
														document.querySelector("#actsp11").innerHTML = "未輸入限制人數"
														document.querySelector("#actsp11").style.color = "red";
													}
												} else {
													document.querySelector("#actsp10").innerHTML = "未選擇活動地址"
													document.querySelector("#actsp10").style.color = "red";
												}
											} else {
												document.querySelector("#actsp9").innerHTML = "未選擇活動地點"
												document.querySelector("#actsp9").style.color = "red";
											}
										} else {
											document.querySelector("#actsp8").innerHTML = "未輸入天數"
											document.querySelector("#actsp8").style.color = "red";
										}
									} else {
										document.querySelector("#actsp7").innerHTML = "未選擇結束時間"
										document.querySelector("#actsp7").style.color = "red";
									}

								} else {
									document.querySelector("#actsp7").innerHTML = "未選擇開始時間"
									document.querySelector("#actsp7").style.color = "red";
								}
							} else {
								document.querySelector("#actsp6").innerHTML = "未選擇日期(2)"
								document.querySelector("#actsp6").style.color = "red";
							}
						} else {
							document.querySelector("#actsp5").innerHTML = "未選擇結束時間"
							document.querySelector("#actsp5").style.color = "red";
						}
					} else {
						document.querySelector("#actsp5").innerHTML = "未選擇開始時間"
						document.querySelector("#actsp5").style.color = "red";
					}
				} else {
					document.querySelector("#actsp4").innerHTML = "未選擇日期(1)"
					document.querySelector("#actsp4").style.color = "red";
				}
			} else {
				document.querySelector("#actsp3").innerHTML = "未選擇舉辦類型"
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