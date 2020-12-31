<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">
		<h3>最新消息</h3>
		<dl id="optionmenu">
			<dd>
				<dl>
					<dt>
						<a href="${pageContext.request.contextPath}/NewActivityPage">活動消息</a>
					</dt>
				</dl>
			</dd>
			<dd>
				<dl>
					<dt>
						<a href="${pageContext.request.contextPath}/NewActivityPage">課程資訊</a>
					</dt>
				</dl>
			</dd>
			<dd>
				<dl>
					<dt>
						<a href="${pageContext.request.contextPath}/NewActivityPage">我的活動</a>
					</dt>
				</dl>
			<dd>
				<dl>
					<dt>
						<a href="${pageContext.request.contextPath}/NewInfoManager">管理者系統</a>
					</dt>
				</dl>
			</dd>
		</dl>
</html>