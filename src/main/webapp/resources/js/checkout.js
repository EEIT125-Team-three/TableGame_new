$(document).ready(function(){
	$.ajax({
		url:"selectAllFromShopCarAjax",
		dataType: 'json',
		type:'POST',
		success : function(htmlobj, Object){
			let s = '<thead><th style="width: 44px;">序號</th><th style="width: 101px;">商品圖</th><th style="width: 443px;">商品名稱</th><th style="width: 90px;">單價</th><th style="width: 98px;">數量</th><th style="width: 110px;">小計</th></thead>';
			$(".shopCar_list").html(s);
			s = "";
			for(let i=0; i<htmlobj.length; i++){
				s += ("<tr id='" + htmlobj[i].productId + "'><td>" + parseInt(i+1) + "</td>")
				s += ("<td><img src='" + htmlobj[i].img_url + "' style='width: 101px;'></td>")
				s += ("<td>" + htmlobj[i].c_name + "</td>")
				s += ("<td>" + htmlobj[i].price + "</td>")
				s += ("<td>" + 0 + "</td>")
				s += ("<td>" + 0 + "</td></tr>")
			}
			$(".shopCar_list").append(s);
			$.ajax({
				url:"shopCarAjaxQuantity",
				dataType: 'json',
				type:'POST',
				success : function(htmlobj){
					$("tr").each(function(){
						if(htmlobj[$(this).attr("id")]){
							let d = parseInt(htmlobj[$(this).attr("id")]);
							$(this).children("td").eq(4).html(d);
							$(this).children("td").eq(5).html(d*parseInt($(this).children("td").eq(3).html()));
						}
					})
				}
			})
		}
	})
	$("#checkout").click(function(){
		Swal.fire({
			  title: '即將進入結帳頁面',
			  text: "",
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: '確定',
			  cancelButtonText:'取消'
			}).then((result) => {
			  if (result.isConfirmed) {
					$("form").eq(1).submit();

			  }
			})
	})
})