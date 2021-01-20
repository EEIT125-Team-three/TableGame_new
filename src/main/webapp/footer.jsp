<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<div style="width:1700px;float:left;">
<span>服務專線 :  03-4227151</span>&emsp;<span>傳真 : 03-4226062</span>&emsp;<span>聯絡信箱 : ncu7141@ncu.edu.tw</span>&emsp;<span>地址 : (32001)桃園市中壢區中大路300號 </span>
<hr>
<span>EEIT125-Team3-享玩 桌遊&emsp;|&emsp;Enjoy BoardGames.&emsp;|&emsp;© All Rights Reserved&emsp;|&emsp;網站內容僅供資策會EEIT125專題展示，無商業營利行為</span>
</div>
<div>
<img onclick="showcode()" style="width:80px;height:80px;margin-left:25px;" src="${pageContext.request.contextPath}/images/機器人QR code.png">
</div>
<script>
function showcode(){
	Swal.fire({
    			  title: 'QR Code',
    			  text: '請掃描加入官方LINE帳號',
    			  imageUrl: '${pageContext.request.contextPath}/images/機器人QR code.png',
    			  imageWidth: 400,
    			  imageHeight: 400,
    			  imageAlt: 'Custom image',
    			})	    
}
</script>
</html>