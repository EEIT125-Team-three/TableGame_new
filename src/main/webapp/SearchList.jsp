<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="zh-Hant-TW">
<script src="${pageContext.request.contextPath}/js/Standard.js"></script>

<p
		style="margin-left: 10px; font-size: 35px; font-weight: bold; color: rgb(234, 241, 171);">分類檢索表</p>

	<ul class="standard_ul">
		<li>英文名稱  <img src="${pageContext.request.contextPath}/images/箭頭.png" class="standard_imgst">
			<form id="fid1" action="${pageContext.request.contextPath}/Product/SearchGameByE_name"	style="display: none">
				<input type='text' style='width: 100px' name="E_name"> 
				<input type='submit' value='送出'>
			</form>
		</li>
		<li>中文名稱 <img src="${pageContext.request.contextPath}/images/箭頭.png" class="standard_imgst">
			<form id="fid2" action="${pageContext.request.contextPath}/Product/SearchGameByC_name" style="display: none">
				<input type='text' style='width: 100px' name="C_name"> 
				<input type='submit' value='送出'>
			</form>
		</li>
		
		<li>遊戲作者 <img src="${pageContext.request.contextPath}/images/箭頭.png" class="standard_imgst">
			<form id="fid3" action="${pageContext.request.contextPath}/Product/SearchGameByG_maker" style="display: none">
				<input type='text' style='width: 100px' name="G_maker">
				<input type='submit' value='送出'>
			</form>

		</li>
		<li>插畫家 <img src="${pageContext.request.contextPath}/images/箭頭.png" class="standard_imgst">
			<form id="fid4" action="${pageContext.request.contextPath}/Product/SearchGameByiss" style="display: none">
				<input type='text' style='width: 100px' name="iss"> 
				<input type='submit' value='送出'>
			</form>
		</li>
		<li>瀏覽數 <img src="${pageContext.request.contextPath}/images/箭頭.png" class="standard_imgst">
			<form id="fid5" action="${pageContext.request.contextPath}/Product/SearchGameByViewCount" style="display: none">
				<input type='text' style='width: 50px' name="ViewCount1"><span> ~ </span>
				<input type='text' style='width: 50px' name="ViewCount2" required>
				<input type='submit' value='送出'>
			</form>
		</li>
		<li>上市日期 <img src="${pageContext.request.contextPath}/images/箭頭.png" class="standard_imgst">
			<form id="fid6" action="${pageContext.request.contextPath}/Product/SearchGameBydate" style="display: none">
				<input type='date' style='width: 100px' name="date" required>
				<input type='submit' value='送出'>
			</form>
		</li>
		<li>庫存數量 <img src="${pageContext.request.contextPath}/images/箭頭.png" class="standard_imgst">
			<form id="fid7" action="${pageContext.request.contextPath}/Product/SearchGameByStorage" style="display: none">
				<input type='text' style='width: 50px' name="storage1"><span> ~ </span>
				<input type='text' style='width: 50px' name="storage2" required>
				<input type='submit' value='送出'>
			</form>
		</li>
		<li>價錢 <img src="${pageContext.request.contextPath}/images/箭頭.png" class="standard_imgst">
			<form id="fid8" action="${pageContext.request.contextPath}/Product/SearchGameByPrice" style="display: none">
				<input type='text' style='width: 50px' name="price1"><span> ~ </span>
				<input type='text' style='width: 50px' name="price2" required>
				<input type='submit' value='送出'>
			</form>
		</li>
		<li>
		<a href='${pageContext.request.contextPath}/Product/advanced_page.jsp'>進階查詢</a>
		</li>
		<li>
		<a href='${pageContext.request.contextPath}/Product/manager_page.jsp'>管理員介面</a>
		</li>


	</ul>

</html>