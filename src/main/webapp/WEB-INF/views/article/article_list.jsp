<%--
  Created by IntelliJ IDEA.
  User: bongg
  Date: 2023-11-16
  Time: 오후 5:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>게시물 리스트</title>
</head>
<body>
<h2 class="list-container">게시물 리스트</h2>

<div class="container">
    <button class="btn btn-dark" onclick="location.href='/article_insert.jsp'">글쓰기</button>
    <table class="table table-hover">
        <tr>
            <th></th>
            <th>제목</th>
            <th>작성자</th>
            <th>날짜</th>
            <th>조회수</th>
        </tr>
        <c:forEach var="i" items="${articles}">
            <tr>
                <td>${i.title}</td>
                <td>${i.writer}</td>
                <td><fmt:formatDate value="${i.createdAt}" pattern="yyyy-MM-dd"/></td>
                <td>${i.viewCnt}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
