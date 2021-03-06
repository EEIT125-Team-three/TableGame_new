<%@page import="java.io.Console"%>
    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
            <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
                <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
                    <%@ page import="java.io.*,java.util.*"%>
                        <%@ page import="javax.servlet.*,java.text.*"%>

                            <!DOCTYPE html>
                            <html lang="zh-Hant-TW">

                            <!DOCTYPE html>

                            <head>
                                <meta charset="UTF-8">
                                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                                <title>Gossip</title>
                                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
                                <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header_style.css">
                                <link rel="stylesheet" href="${pageContext.request.contextPath}/css/brain.css">
                                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
                                <script src="${pageContext.request.contextPath}/js/header_js.js"></script>
                                <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30=" crossorigin="anonymous"></script>
                                <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
                                <fmt:formatDate value="${dis.disDate}" pattern="yyyy MM dd HH:mm:ss" />
                                <style>

                                </style>
                            </head>

                            <body class="header_body">
                                <header> </header>

                                <div class="container">
                                    <div class="aside">

                                        <ul class="aside_menu">
                                            <br>
                                            <br>
                                            <li><a href="${pageContext.request.contextPath }/Post_Article">發表文章</a></li>
                                            <br>
                                            <br>
                                            <li><a href="Brain">大腦類</a></li>
                                            <br>
                                            <br>
                                            <li><a href="${pageContext.request.contextPath }/ArticalList">策略類</a></li>
                                            <br>
                                            <br>
                                            <li><a href="Brain">卡牌類</a></li>
                                            <br>
                                            <br>
                                            <li><a href="Brain">派對類</a></li>
                                            <br>
                                            <br>
                                            <li><a href="Brain">合作類</a></li>
                                            <br>
                                            <br>
                                            <li><a href="Brain">陣營類</a></li>
                                            <br>
                                            <br>
                                            <li><a href="Brain">競速類</a></li>
                                            <br>
                                            <br>
                                            <li><a href="Brain">兒童類</a></li>
                                            <br>
                                            <br>
                                            <li><a href="Brain">樂齡類</a></li>
                                            <br>
                                            <br>
                                        </ul>
                                    </div>
                                </div>

                                <div class="ArticalList">
                                    <form method="POST" action="${pageContext.request.contextPath }/ArticalList">
                                        <h1>所有文章列表-大腦類</h1>
                                        <table>
                                            <tr>
                                                <th>標題</th>
                                                <th>作者</th>
                                                <th>時間</th>

                                            </tr>
                                            <c:forEach var="dis" items="${listofArtical }">
                                                <tr>
                                                    <td><a href="${pageContext.request.contextPath }/GetArticalbyDisID?DiscussionBoardID=${dis.discussionBoardID}">${dis.distitle}</a></td>
                                                    <%-- 						<td>${dis.memName}</td> --%>
                                                        <td>${dis.disDate}</td>
                                                        </td>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                    </form>
                                </div>
                            </body>

                            </html>