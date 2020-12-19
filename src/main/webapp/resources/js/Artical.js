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

//從前端傳到後端以及傳到另一個頁面
function postArticle(){
 Form.date.value = new Date().toString('yyyy-MM-dd HH:mm:ss.SSS'); //取得發文時間 
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
			if(data=="true"){
                $('#Discussion-Brain/show').jsp("<br/>"+$("[title]").value()+"<br/>"+$("[date]").value());
        //如果成功，List 到
            }
		}
		})
		}

