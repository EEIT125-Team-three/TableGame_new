<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>享玩 桌遊 | 討論區 | 發表文章</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link	href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC&display=swap" rel="stylesheet">
<link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
<link rel="stylesheet"	href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ScrollBar.css">
<link rel="stylesheet"	href="${pageContext.request.contextPath}/css/Post_Article.css">
<link rel="stylesheet"	href="${pageContext.request.contextPath}/css/editor.css">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/24.0.0/classic/ckeditor.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30="
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>

</head>

<body>
<body class="header_body">
	<header> </header>

	<form method="post" name="submitForm"
		action="${pageContext.request.contextPath }/DiscussionBoard/submitForm">
		<h1>分類 : ${cata2}</h1>
		<input type="hidden" name="cata2" value="${cata2Keys}">
		<div class="accountID">

			<label for="account" style="font-size: xx-large"
				id="discussionBoardID"> 會員: </label>
			<span style='font-size:30px;'>${name}</span>
		</div>
		<div>
			<label for="title" style="font-size: xx-large;">標題:</label> <input
				type="text" id="distitle" name="distitle" class="title">
		</div>
			<label for="textarea" style="font-size: xx-large;">內容:</label>
		<div class="textarea">
			<textarea id="editor" name="disArtical">
			</textarea>
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
		</div>
		<div>
			<input class="clearBT" id="clear" type="reset" value="清空文章">
		</div>

	</form>
		<div>
			<button class="postBT" id="postBT" type="submit" onclick="submitcheck()">發表文章</button>
		</div>
	<script>
		function submitcheck(){
			let theTitleObjVal= $('#distitle').val();
			let content = theEditor.getData();
			if(theTitleObjVal == ""||content == ""){
				Swal.fire(
						  '發生錯誤',
						  '請輸入標題及內容',
						  'error'
						)
			}else{
				Swal.fire({
					  title: '文章確定發布?',
					  text: "請注意用詞，管理員不定時巡帖",
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
	</script>
</body>

</html>