<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>享玩 桌遊 | 討論區 | 編輯貼文</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script src="https://cdn.ckeditor.com/ckeditor5/24.0.0/classic/ckeditor.js"></script>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC&display=swap"
	rel="stylesheet">
<link rel="stylesheet"	href="${pageContext.request.contextPath}/css/editor.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ScrollBar.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/Post_Article.css">
<link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon"/>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"
	integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30="
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/js/header_js.js"></script>
<script src="${pageContext.request.contextPath}/js/Artical.js"></script>
</head>

<body>
<body class="header_body">
	<header> </header>

	<form:form method="post" id="editArtical" name="editArtical"
		action="${pageContext.request.contextPath }/DiscussionBoard/editArtical" modelAttribute='discussionBoard'>
		<div class="accountID">

			<label for="account" style="font-size: xx-large"
				id="discussionBoardID" name="discussionBoardID"> 會員: </label>
			${name}　
			<input type="hidden" name = "discussionBoardID" value="${discussionBoard.discussionBoardID}">
			<input type="hidden" name = "disLikesNo" value="${discussionBoard.disLikesNo}">
			<input type="hidden" name = "memId" value="${discussionBoard.member.memId}">
			<input type="hidden" name = "cata2" value="${discussionBoard.cata2.keys}">
		</div>
		
		<div>
			<label for="title" style="font-size: xx-large;">標題:</label> <input
				type="text" id="distitle" name="distitle" class="title"
				onclick="checkTitle(); " value="${discussionBoard.distitle}">
		</div>
			<label for="textarea" style="font-size: xx-large;">內容:</label>
		<div class="textarea">
			<textarea id="editor" name="disArticle"
				onclick="checkArticle();">
		${discussionBoard.disArtical}
		</textarea>
		<script type="text/javascript">
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
			       console.log(editor);
			})
			.catch(error=>{
			       console.error(error);
			});
			</script>
		</div>
		<div>
			<input class="postBT" id="postBT" type="submit" value="編輯完畢">
		</div>
		<div>
			<input class="clearBT" id="clear" type="reset" value="清空文章"
				onclick="clearArticle();">
		</div>

	</form:form>
	<footer class="footer_body">
</footer>
</body>

</html>