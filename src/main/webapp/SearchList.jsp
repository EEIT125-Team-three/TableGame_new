<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="zh-Hant-TW">
<script src="${pageContext.request.contextPath}/js/Standard.js"></script>

<p style="margin-left: 10px; font-size: 35px; font-weight: bold; color: rgb(234, 241, 171);">分類檢索表</p>

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
			<form id="fid6" action="${pageContext.request.contextPath}/Product/SearchGameBydate" style="display: none;font-size:20px;color:#F9F900">
<!-- 				<input type='date' style='width: 100px' name="date" required> -->
				<div style='float:left'>
				<label>一星期內</label><br>
				<label>一個月內</label><br>
				<label>半年內</label><br>
				<label>一年內</label><br>
				</div>
				<div style='float:left'>
				<input type='radio' name="date" value='7'><br>
				<input type='radio' name="date" value='30'><br>
				<input type='radio' name="date" value='180'><br>
				<input type='radio' name="date" value='365'><br>
				</div>
				<div style='clear:left'>
				<input type='submit' value='送出'>
				</div>
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
		<li>類型 <img src="${pageContext.request.contextPath}/images/箭頭.png" class="standard_imgst">
			<form id="fid8" action="${pageContext.request.contextPath}/Product/SearchGameByCata1" style="display: none;font-size:20px;color:#F9F900">
				<div style='float:left'>
				<label>競速</label><input type='radio' name="Cata1" value='1'>
				<label>言語</label><input type='radio' name="Cata1" value='2'><br>
				<label>大腦</label><input type='radio' name="Cata1" value='3'>
				<label>紙牌</label><input type='radio' name="Cata1" value='4'><br>
				<label>讀物</label><input type='radio' name="Cata1" value='5'>
				<label>猜心</label><input type='radio' name="Cata1" value='6'><br>
				<label>巧手</label><input type='radio' name="Cata1" value='7'>
				<label>派對</label><input type='radio' name="Cata1" value='8'><br>
				<label>骰子</label><input type='radio' name="Cata1" value='9'>
				<label>樂齡</label><input type='radio' name="Cata1" value='10'><br>
				<label>陣營</label><input type='radio' name="Cata1" value='14'>
				<label>兒童</label><input type='radio' name="Cata1" value='15'><br>
				<label>合作</label><input type='radio' name="Cata1" value='16'>
				<label>周邊</label><input type='radio' name="Cata1" value='19'><br>
				<label>6人+</label><input type='radio' name="Cata1" value='18'>
				<label>1-2人</label><input type='radio' name="Cata1" value='17'><br>
				<label>重策略</label><input type='radio' name="Cata1" value='11'>
				<label>中策略</label><input type='radio' name="Cata1" value='12'><br>
				<label>輕策略</label><input type='radio' name="Cata1" value='13'><br>
				</div>
				<input type='submit' value='送出'>
			</form>
		</li>
		<li>科目 <img src="${pageContext.request.contextPath}/images/箭頭.png" class="standard_imgst">
			<form id="fid8" action="${pageContext.request.contextPath}/Product/SearchGameByCata2" style="display: none;font-size:20px;color:#F9F900">
				<label>自然</label><input type='radio' name="Cata2" value='1'>
				<label>社會</label><input type='radio' name="Cata2" value='2'><br>
				<label>科技</label><input type='radio' name="Cata2" value='3'>
				<label>健體</label><input type='radio' name="Cata2" value='4'><br>
				<label>綜合</label><input type='radio' name="Cata2" value='5'>
				<label>語文</label><input type='radio' name="Cata2" value='6'><br>
				<label>數學</label><input type='radio' name="Cata2" value='7'>
				<label>藝術</label><input type='radio' name="Cata2" value='8'><br>
				<input type='submit' value='送出'>
			</form>
		</li>
		<li>
		<a href='${pageContext.request.contextPath}/Product/advanced_page.jsp'>進階查詢</a>
		</li>
<!-- 		<li> -->
<%-- 		<a href='${pageContext.request.contextPath}/Product/manager_page.jsp'>管理員介面</a> --%>
<!-- 		</li> -->


	</ul>

</html>