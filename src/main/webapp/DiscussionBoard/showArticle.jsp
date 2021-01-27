<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>享玩 桌遊 | 討論區 | 文章</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/24.0.0/classic/ckeditor.js"></script>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ScrollBar.css">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/Post_Article.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"
	integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30="
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>
<script src="${pageContext.request.contextPath}/js/Artical.js"></script>
<style type="text/css">
	.showArticle_st{
		border:2px solid black;
		border-radius:10px;
		background-color:beige;
		width:1000px;
		padding:15px;
	}
	.showArticle_st1{
		border:2px solid black;
		border-radius:10px;
		background-color:#FFDAC8;
		width:800px;
		padding:5px;
	}
	.ck-editor__editable {
	/* 設定最低高度 */
	    max-height: 200px;
	    min-height: 200px;
	}
	.btn_rep_st{
		width:100px;
		height:25px;
		font-size:10px;
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
</head>


<body class="header_body">
	<header> </header>
	<div style="float:left;">
		<div class="showArticle_st">
			<label for="title" style="font-size: 60px;">標題:</label>
			<span style="font-size:60px;">${GetArticalbyDisID.distitle}</span>
		</div>
		<div class="showArticle_st" style="margin-top:15px;">
			<label for="textarea" style="font-size: 60px;">內容:</label><br>
			<span>${GetArticalbyDisID.disDate}</span>
			<div style="font-size:20px;">${GetArticalbyDisID.disArtical}</div>
		</div>
		
			
			<a href="${pageContext.request.contextPath}/DiscussionBoard/SearchCata2?cata2=${GetArticalbyDisID.cata2.keys}"><button class='btn_rep_st' style="margin-top:5px">回討論區</button></a>
	</div>
	<div style="float:left;">
		<div class="showArticle_st1" style="margin-left:15px;">
		<form action="${pageContext.request.contextPath}/DiscussionBoard/AddReText">
			<p>標題 : Re:<span>${GetArticalbyDisID.distitle}</span></p>
			<input  type="hidden" name="memId" value="${memId}">
			<input  type="hidden" name="mainArticleId" value="${articleId}">
			<input  type="hidden" name="re_textTitle" value="Re:${GetArticalbyDisID.distitle}">
			<textarea id="editor" name="re_text"></textarea>
			<script type="text/javascript">
				var theEditor;
				ClassicEditor.create(document.querySelector('#editor'),{
					toolbar: {
						items: [ 'heading', '|', 'bold', 'italic', 'link', 'bulletedList', 'numberedList', 'blockQuote', '|', 'undo', 'redo','bulletedList' ],
					    viewportTopOffset: 30,
					    shouldNotGroupWhenFull: true
					},
			        heading: {
			            options: [
			                { model: 'paragraph', title: 'Paragraph', class: 'ck-heading_paragraph' },
			                { model: 'heading1', view: 'h1', title: 'Heading 1', class: 'ck-heading_heading1' },
			                { model: 'heading2', view: 'h2', title: 'Heading 2', class: 'ck-heading_heading2' }
			            ]
			        }
				})
				.then(editor=>{
						theEditor = editor;
				})
				.catch(error=>{
				       console.error(error);
				});
			</script>
		</form>
			<button class='btn_rep_st' onclick="check();">送出回覆</button>
			<button class='btn_rep_st' onclick="fastinput();">一鍵輸入</button>
			<script type="text/javascript">
				function check(){
					let content = theEditor.getData();
					if(${memId==null}){
						Swal.fire(
								  '發生錯誤',
								  '請先登入會員',
								  'error'
								)
					}
					else if(content == ""){
						Swal.fire(
								  '發生錯誤',
								  '請輸入內容',
								  'error'
								)}else{									
						Swal.fire({
							  title: '確定回覆此文章?',
							  text: "請注意不得文字包含暴力、色情以及汙辱性文字，有出現以上情形，管理員將會強制刪除",
							  icon: 'question',
							  showCancelButton: true,
							  confirmButtonColor: '#3085d6',
							  cancelButtonColor: '#d33',
							  confirmButtonText: '確定',
							  cancelButtonText:'取消'
							}).then((result) => {
							  if (result.isConfirmed) {
								  $("form").eq(1).submit();
							  }
							  return false;
							})	
						}
					}
				function deleteCheck(retextId,mainArticleId){
					 //alert(id)
					 Swal.fire({
						  title: '確定刪除資料?',
						  text: "刪除後不可回復，請確定操作!",
						  icon: 'warning',
						  showCancelButton: true,
						  confirmButtonColor: '#3085d6',
						  cancelButtonColor: '#d33',
						  confirmButtonText: '刪除',
						  cancelButtonText:'取消',
						  closeOnCancel: true
						}).then((result) => {
						  if (result.isConfirmed) {
						    window.location.href="<c:url value='DeleteReText?retextId="+retextId+"&mainArticleId="+mainArticleId+"'/>"
						  }
						})
					}
				function fastinput(){
					theEditor.setData("感謝版主的分享!!!真的太實用了~");
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
		</div>
		<c:forEach var="retext" items="${reList}">
				<c:out value="<div class='showArticle_st1' style='margin-top:15px;margin-left:15px;'>" escapeXml="false"></c:out>
					<span>回覆者 : ${retext.memNam}</span>
					<br>
					<span>${retext.date}</span>
					<br>
					<span>${retext.reText}</span>
					<span style="margin-left:650px;margin-bottom:20px;">
						<c:if test="${retext.memId==memId || memId==1}">
							<c:out value="<button class='btn_rep_st' onclick='deleteCheck(${retext.num},${retext.mainArticleId})'>刪除</button>" escapeXml="false"></c:out>
						</c:if>
					</span>
				<c:out value="</div>"  escapeXml="false"></c:out>
			</c:forEach>
	</div>
	<a href="#" id="gotop">
	   <i class="fa fa-angle-double-up fa-3x"></i>
	</a>
	<footer class="footer_body">
</footer>
</body>

</html>