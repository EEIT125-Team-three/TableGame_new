var DiscussionBoardID =0;
var Distitle = "";
var DisArtical= "";

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

$(document).ready(function(){
	$('#submitForm').submit(function(e){
		var frm=$('#submitForm');
		e.preventDefault();
		
		var data={};
		var Form=this;
		
		//取值
		$.each(this,function(i,v){
			var input=$(v);
			data[input.attr("distittle")]=input.val();
			delete data["undefined"];
		}),
		$.ajax({
		url : "./postArticalajax" ,
		data: $('#uploadNewArtical').serialize(),
		dataType : 'json',
		async : true,
		type: 'POST',
		success : function(data, htmlobj){
			if(data=="true"){
                $('#Discussion-Brain').jsp("<br/>"+$("[title]").value()+"<br/>"+$("[date]").value());
		}},
		error : function(){
                $(this).html("Error!");
            	}
			})
		})
	})







