<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增更新遊戲資料成功</title>
</head>
<body>
<h1>新增、更新遊戲資料成功</h1>
<table border='1'>
<tr>
<th>項目</th>
<th width='500px'>內容</th>
</tr>
<tr><td>遊戲編號 : </td><td>${gb.productId}</td></tr>
<tr><td>英文名稱 : </td><td>${gb.e_name}</td></tr>
<tr><td>中文名稱 : </td><td>${gb.c_name}</td></tr>
<tr><td>圖片連結 : </td><td>${gb.img_url}</td></tr>
<tr><td>作者 : </td><td>${gb.g_maker}</td></tr>
<tr><td>插畫家 : </td><td>${gb.iss}</td></tr>
<tr><td>資訊 : </td><td>${gb.info}</td></tr>
<tr><td>價錢 : </td><td>${gb.price}</td></tr>
<tr><td>瀏覽數 : </td><td>${gb.viewCount}</td></tr>
<tr><td>上市日期 : </td><td>${gb.date}</td></tr>
<tr><td>庫存 : </td><td>${gb.storage}</td></tr>


</table>
<a href='manager_page.jsp'>回到遊戲管理</a>

</body>
</html>