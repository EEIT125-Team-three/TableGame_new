var num = 0;
var manager =0;

function Ename_test() {
    let name = document.getElementById("fid1");
if(window.num==0){
    name.style.display="";
window.num++;	
}else if(window.num==1){
	name.style.display="none";
	window.num=0;
}
}
function Cname_test() {
    let name = document.getElementById("fid2");
    if(window.num==0){
    name.style.display="";
window.num++;	
}else if(window.num==1){
	name.style.display="none";
	window.num=0;
}
}
function Gmaker_test() {
    let name = document.getElementById("fid3");
    if(window.num==0){
    name.style.display="";
window.num++;	
}else if(window.num==1){
	name.style.display="none";
	window.num=0;
}
}
function Iss_test() {
    let name = document.getElementById("fid4");
    if(window.num==0){
    name.style.display="";
window.num++;	
}else if(window.num==1){
	name.style.display="none";
	window.num=0;
}
}
function Type_test() {
    let name = document.getElementById("fid6");
    if(window.num==0){
    name.style.display="";
window.num++;	
}else if(window.num==1){
	name.style.display="none";
	window.num=0;
}
}
function People_test() {
    let name = document.getElementById("fid7");
    if(window.num==0){
    name.style.display="";
window.num++;	
}else if(window.num==1){
	name.style.display="none";
	window.num=0;
}
}
function Price_test() {
    let name = document.getElementById("fid8");
    if(window.num==0){
    name.style.display="";
window.num++;	
}else if(window.num==1){
	name.style.display="none";
	window.num=0;
}
}
function Age() {
    let agearray = ["0-6歲", "7-12歲", "12歲以上"];
    let agevalue = ["0-6", "7-12", "12up"];
    let age = document.querySelector("#age");

    if (window.num == 0) {
        for (let i = 0; i < agearray.length; i++) {
            let opt = document.createElement("div");
            opt.innerHTML = "<input type='radio' name='age' value=" + agevalue[i] + ">" + agearray[i];
            age.appendChild(opt);
        }
        window.num++;
    } else if (window.num == 1) {
        age.innerHTML = "";
        window.num = 0;
    }
}

function manager_search_display(){
	let display = document.getElementById("search_fieldset");
	if(window.manager==0){
		display.style.display="";
		window.manager++;
	}else if(window.manager==1){
		display.style.display="none";
		window.manager=0;
	}
	
}
function manager_delete_display(){
	let display = document.getElementById("delete_fieldset");
	if(window.manager==0){
		display.style.display="";
		window.manager++;
	}else if(window.manager==1){
		display.style.display="none";
		window.manager=0;
	}
	
}
function manager_creat_display(){
	let display = document.getElementById("creat_fieldset");
	if(window.manager==0){
		display.style.display="";
		window.manager++;
	}else if(window.manager==1){
		display.style.display="none";
		window.manager=0;
	}
	
}
function manager_update_display(){
	let display = document.getElementById("update_fieldset");
	if(window.manager==0){
		display.style.display="";
		window.manager++;
	}else if(window.manager==1){
		display.style.display="none";
		window.manager=0;
	}
	
}