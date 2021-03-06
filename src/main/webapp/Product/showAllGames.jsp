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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ScrollBar.css">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	<link rel='stylesheet' href='//cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css'>
   	<script src='//cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js'></script>
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
	.dataTables_wrapper {
	    font-family: tahoma;
	    font-size: 20px;
	    font-weight:bold;
	    width:95%;
		margin-left:50px;
		
	}

 	</style>
	 <script type="text/javascript">
	 $(document).ready(function() {
		    $(function () {
		    	$('#table1').DataTable({
		    		language: {
		    		    "lengthMenu": "顯示 _MENU_ 筆資料",
		    		    "sProcessing": "處理中...",
		    		    "sZeroRecords": "没有匹配结果",
		    		    "sInfo": "目前有 _MAX_ 筆資料",
		    		    "sInfoEmpty": "目前共有 0 筆紀錄",
		    		    "sInfoFiltered": " ",
		    		    "sInfoPostFix": "",
		    		    "sSearch": "尋找:",
		    		    "sUrl": "",
		    		    "sEmptyTable": "尚未有資料紀錄存在",
		    		    "sLoadingRecords": "載入資料中...",
		    		    "sInfoThousands": ",",
		    		    "oPaginate": {
		    		        "sFirst": "首頁",
		    		        "sPrevious": "上一頁",
		    		        "sNext": "下一頁",
		    		        "sLast": "末頁"
		    		    },
		    		    "order": [[0, "desc"]],
		    		    "oAria": {
		    		        "sSortAscending": ": 以升序排列此列",
		    		        "sSortDescending": ": 以降序排列此列"
		    		    }
		    		}
		    	})
		    	});
	 })
	 function check(id){
		 //alert(id)
		 Swal.fire({
			  title: '確定刪除資料?',
			  text: "刪除後不可回復，請確定操作!",
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: '刪除',
			  cancelButtonText:'取消'
			}).then((result) => {
			  if (result.isConfirmed) {
			    window.location.href="<c:url value='DeleteGame?productId="+id+"'/>"
			  }
			})
		}

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
<h1 style="margin-left:50px;">遊戲列表</h1>

<c:if test='${empty allGames}'>
		查無遊戲資料<br>
	</c:if>
	<c:if test='${not empty allGames}'>
		<c:forEach var='game' varStatus='vs' items='${allGames}'>
			<c:if test ='${vs.first }'>
				<c:out value="<table id='table1' class='table_st'>"  escapeXml='false'/>
				<c:out value="<thead style='font-size:25px;'><tr bgcolor='lightyellow'>
								<th>編號</th>
								<th>英文名稱</th>
								<th>中文名稱</th>
								<th>圖片</th>
								<th>遊戲作者</th>
								<th>插畫家</th>
								<th>資訊</th>
								<th>價錢</th>
								<th>瀏覽數</th>
								<th>上市日期</th>
								<th>庫存</th>
								<th>操作</th>
							</tr></thead>"  escapeXml='false'/>			
			</c:if>
			
			<tr>
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
<a style="text-decoration:none;" href='../product'><span style="font-size:40px;margin-left:50px;font-weight:bold;">回到遊戲管理</span></a>
<a href="#" id="gotop">
   <i class="fa fa-angle-double-up fa-3x"></i>
</a>
<footer class="footer_body">
</footer>
</body>
</html>