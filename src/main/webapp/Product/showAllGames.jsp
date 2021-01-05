<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>享玩 桌遊 | 管理員 | 所有商品</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/manager_page.css">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
	<style type="text/css">
	 .table_st{
	 	font-size:20px;
	 	border:2px solid blue;
	 	text-align:center;
	 }
	 .td_st{
	 	width:150px;
	 	border-top:2px solid blue;	
	 }
	 .btn_rep_st{
		width:100px;
		height:30px;
		font-size:20px;
		border-radius:5px;
		background-color:#006030;
		color:#FFD306;
	}
	 #gotop {
	    position:fixed;
	    z-index:90;
	    right:10px;
	    bottom:31px;
	    display:none;
	    width:60px;
	    height:60px;
	    color:#fff;
	    background:#33b5e5;
	    line-height:50px;
	    border-radius:50%;
	    transition:all 0.5s;
	    text-align: center;

	}
	#gotop :hover{
	    background:transaction;
	    color:	#000079;
	}
 	</style>
	 <script type="text/javascript">
	 function check(id){
			Swal.fire(
				{title:"確定刪除資料?",
				text:"資料將無法回復，請謹慎操作",
				type:"warning",
				showCancelButton:true,
				confirmButtonColor:"#DD6B55",
				confirmButtonText:"刪除",
				cancelButtonText:"取消",
				closeOnConfirm: false
				},
				function(isConfirm)
				{
					if(isConfirm)
					{
						Swal.fire({title:"刪除成功",
							text:"已刪除資料",
							type:"success"},
							function(){ window.location.assign("${pageContext.request.contextPath}/Product/DeleteGame?productId="+id)
								})
					}
					else{
						Swal.fire({title:"取消",
							text:"已取消操作！",
							type:"error"})
					}
				}
				)
		}

// 		function warning(){
// 			alert("資料即將刪除");
// 		}
// 		function confirmDelete(productId) {
// 			var result = confirm("確定刪除此筆資料(編號:" + productId + ")?");
// 			if (result) {
// 				document.forms[0].finalDecision.value = "Delete";
// 				return true;
// 			}
// 			return false;
// 		}

	    $(function() {
	        /* 按下GoTop按鈕時的事件 */
	        $('#gotop').click(function(){
	            $('html,body').animate({ scrollTop: 0 }, 'slow');   /* 返回到最頂上 */
	            return false;
	        });
	        
	        /* 偵測卷軸滑動時，往下滑超過400px就讓GoTop按鈕出現 */
	        $(window).scroll(function() {
	            if ( $(this).scrollTop() > 400){
	                $('#gotop').fadeIn();
	            } else {
	                $('#gotop').fadeOut();
	            }
	        });
	    });
	</script>
</head>

<body class="header_body">
	<header>
	</header>
    
<div>
<h1>遊戲列表</h1>

<c:if test='${empty allGames}'>
		查無遊戲資料<br>
	</c:if>
	<c:if test='${not empty allGames}'>
		<c:forEach var='game' varStatus='vs' items='${allGames}'>
			<c:if test ='${vs.first }'>
				<c:out value="<table class='table_st'>"  escapeXml='false'/>
				<c:out value="<tr bgcolor='lightyellow'>
								<th>遊戲編號</th>
								<th>英文名稱</th>
								<th>中文名稱</th>
								<th>圖片連結</th>
								<th>遊戲作者</th>
								<th>插畫家</th>
								<th>資訊</th>
								<th>價錢</th>
								<th>瀏覽數</th>
								<th>上市日期</th>
								<th>庫存</th>
								<th>操作</th>
							</tr>"  escapeXml='false'/>			
			</c:if>
			
			<tr bgcolor='lightblue'>
				<td class='td_st' style='width:50px'>${game.productId}</td>
				<td class='td_st'>${game.e_name}</td>
				<td class='td_st'>${game.c_name}</td>
				<td class='td_st'><img style="width:100px;height:100px" src='${game.img_url}'></td>
				<td class='td_st'>${game.g_maker}</td>
				<td class='td_st'>${game.iss}</td>
				<td class='td_st' style='width:600px'>${game.info}</td>
				<td class='td_st' style='width:50px'>${game.price}</td>
				<td class='td_st' style='width:70px'>${game.viewCount}</td>
				<td class='td_st' style='width:100px'>${game.date}</td>
				<td class='td_st' style='width:50px'>${game.storage}</td>
				<td class='td_st'>
<%-- 				<a href='DeleteGame?productId=${game.productId}'><button class="btn_rep_st" type='button' onclick="return confirmDelete(${game.productId})">刪除</button></a> --%>
				<button class="btn_rep_st" type='button' onclick="check(${game.productId})">刪除</button>
				<a href='UpdateGame?productId=${game.productId}'><button class="btn_rep_st" type='button'>修改</button></a>
				</td>
			</tr>
			<c:if test ='${vs.last }'>
				<c:out value="</table>" escapeXml='false'/>
			</c:if>
		</c:forEach>
	</c:if>
</div>
<a href='../product'><span style="font-size:20px">回到遊戲管理</span></a>
<a href="https://www.blogger.com/blogger.g?blogID=2031514508322140995#" id="gotop">
   <i class="fa fa-angle-double-up fa-3x"></i>
</a>
<footer class="footer_body">
</footer>
</body>
</html>