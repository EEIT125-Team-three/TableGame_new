<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/InfoMenu_style.css">
</head>
<div class="menu">
	<h3>最新消息</h3>
	<dl id="optionmenu">
		<dd style="margin-inline-start: 0px;">
			<dl>
				<dt>
					<a href="${pageContext.request.contextPath}/NewActivityPage">活動消息</a>
				</dt>
			</dl>
		</dd>
		<dd style="margin-inline-start: 0px;">
			<dl>
				<dt>
					<a href="${pageContext.request.contextPath}/Course">課程資訊</a>
				</dt>
			</dl>
		</dd>
		<dd style="margin-inline-start: 0px;">
			<dl>
				<dt>
					<a href="${pageContext.request.contextPath}/MyActivity">我的活動</a>
				</dt>
			</dl>
	</dl>
</div>
</html>
