//var Mes = [];
//var Mesu = [];
//var id;
//var action;
//var artical;
//var time;

function checkTitle(){
let theTitleObj = document.getElementById("title");
let theTitleObjVal = theTitleObj.value;
if (theTitleObjVal == "") {
    alert("請輸入標題!!!")
}}

function checkArticle(){
let theArticleObj = document.getElementById("textarea");
let theArticleObjVal = theArticleObj.value;
if (theArticleObjVal == "") {
    alert("一定要有內容喔!!!")
}}

function clearArticle(){
	alert("真的要清空嗎? 一旦清空將無法恢復!")
}

function postArticle(){
	$.ajax({
		url : "postArticalajax" ,
		data: $('#uploadArtical').serialize(),
		dataType : 'json',
		async : true,
		type: 'POST',
		error:function(request){
			console.log("failed")
		},
		success : function(data, htmlobj){
			$('#listAllArtical').html(list);
		}
		})
		}

