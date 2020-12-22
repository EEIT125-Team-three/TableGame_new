<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/header_style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/newinfo_style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/menu_style.css">
<script src="http://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>
<Script text="text/javascript">
	$(document).ready(function() {
		$("#optionmenu>dd>dl>dd").hide();
		$.each($("#optionmenu>dd>dl>dt"), function() {
			$(this).click(function() {
				$("#optionmenu>dd>dl>dd ").not($(this).next()).slideUp();
				$(this).next().slideToggle(500);
				//$(this).next().toggle();
			});
		});
	});
</script>
</Script>
</head>
<style>


</style>
<body>

	<article>
		<header>
			<div>
				<ul class="listst1">
					<li>
						<p class="titlest">
							<big><big><big>享玩 桌遊</big></big></big>
						</p>
					</li>
					<p style="font-size: larger; font-weight: bold;">
						<big>讓因桌遊而產生的歡笑&emsp;充滿生命中的每分每秒</big>
					</p>
				</ul>
			</div>
			<hgroup>
				<h2 style="width: fit-content;">放輕心情</h2>
				<h2 style="width: fit-content;">&emsp;&emsp;&emsp;&emsp;享受與親友</h2>
				<h2 style="width: fit-content;">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;共同度過的桌遊時光</h2>
			</hgroup>
			<nav>
				<div>
					<span style="margin-left: 100px;">網站起源</span> <span>最新消息</span> <span>分類檢索</span>
					<span>購物車</span> <span>討論區</span> <span>會員中心</span> <span>聯絡我們</span>
				</div>
			</nav>
		</header>

		<div class="menu">
			<h3>最新消息</h3>
			<dl id="optionmenu">
				<dd>
					<dl>
						<dt>新品上架</dt>
						<dd>
							<ul>
								<li><a href=#>語文</a></li>
								<li><a href=#>數學</a></li>
								<li><a href=#>自然</a></li>
								<li><a href=#>社會</a></li>
								<li><a href=#>科技</a></li>
								<li><a href=#>藝術</a></li>
								<li><a href=#>綜合</a></li>
							</ul>
						</dd>
					</dl>
				</dd>
				<dd>
					<dl>
						<dt>
							<a href="regisact.html">課程資訊</a>
						</dt>
					</dl>
				</dd>
				<dd>
					<dl>
						<dt>活動消息</dt>
						<dt>開箱試玩</dt>
						<dd>
							<ul>
								<li>最新開箱</li>
								<li>玩法介紹</li>
								<li>比賽直播</li>
							</ul>
						</dd>
					</dl>
				<dd>
					<dl>
						<dt>
							<a href=../jsp/updateInfo.jsp>管理者系統</a>
						</dt>
					</dl>
		</div>
		<div class="box1">
			<a href='${pageContext.request.contextPath}/showAllInfos'><button
					type='button'>顯示活動列表</button></a>
		</div>
		<div class="box2">
			<figure class="fupdate">
				<form action="${pageContext.request.contextPath}/SaveInfo"
					method="post">
					<div class="update form">
						<legend>
							<h3>新增活動</h3>
							<table cellspacing="2" cellpadding="1" border="1" width="100%">
								<tr>
									<td><label class="u1">活動區域:</label></td>
									<td><input type="text" name="actArea"></td>
								</tr>
								<tr>
									<td><label class="u1">類型:</label></td>
									<td><input type="text" name="activity"></td>
								</tr>
								<tr>
									<td><label class="u1">活動形式:</label></td>
									<td><input type="text" name="actType"></td>
								</tr>
								<tr>
									<td><label class="u1">活動日期(1):</label></td>
									<td><input type="date" name="actDate1"></td>
									<td><label class="u1">開始時間(1):</label></td>
									<td><input type="time" name="actStrTime1"></td>
									<td><label class="u1">結束時間(1):</label></td>
									<td><input type="time" name="actEndTime1"></td>
								</tr>
								<tr>
									<td><label class="u1">活動開始日期時間(2):</label></td>
									<td><input type="date" name="actDate2"></td>
									<td><label class="u1">開始時間(2):</label></td>
									<td><input type="time" name="actStrTime2"></td>
									<td><label class="u1">結束時間(2):</label></td>
									<td><input type="time" name="actEndTime2"></td>
								</tr>
								<tr>
									<td><label class="u1">活動天數:</label></td>
									<td><input type="text" name="actDay"></td>
								</tr>
								<tr>
									<td><label class="u1">活動地點:</label></td>
									<td><input type="text" name="actLocation"></td>
								</tr>
								<tr>
									<td><label class="u1">活動地址:</label></td>
									<td><input type="text" name="actAddress"></td>
								</tr>
								<tr>
									<td><label class="u1">人數限制:</label></td>
									<td><input type="text" name="actLimitper"></td>
								</tr>
								<tr>
									<td><label class="u1">活動費用:</label></td>
									<td><input type="text" name="actCost"></td>
									</figcaption>
									</div>
									<div class="sub">
										<input type="submit" name="submit" value="新增"> <input
											type="reset" name="reset" value="重設">
									</div>
								</tr>
							</table>
						</legend>
					</div>
				</form>
			</figure>
		</div>

		<div class="box3">
			<figure class="f1">
				<form action="${pageContext.request.contextPath}/DeleteInfo"
					method="get">
					<h3>
						刪除活動
						<h3>
							<table cellspacing="2" cellpadding="1" border="1" width="100%">
								<tr>
									<td><label class="u1">活動區域:</label></td>
									<td><input type="text" name="actArea"></td>
								</tr>
								<tr>
									<td><label class="u1">類型:</label></td>
									<td><input type="text" name="activity"></td>
								</tr>
								<tr>
									<td><label class="u1">活動形式:</label></td>
									<td><input type="text" name="actType"></td>
								</tr>
								<tr>
									<td><label class="u1">活動日期:</label></td>
									<td><input type="datetime-local" name="actDate1"></td>
								</tr>

								<input type="submit" name="delete" value="刪除">
								<input type="reset" name="reset" value="重設">
							</table>
				</form>
			</figure>
		</div>
</body>

</html>