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
<%@taglib uri="http://example.com/functions" prefix="f" %>
<script src="${pageContext.request.contextPath}/static/js/article.js"></script>
<script src="${pageContext.request.contextPath}/static/js/common/helper.js"></script>
<div class="container">
    <table class="table table-striped caption-top table-hover">
        <%--        <caption> 총 ${articles.size()} 건</caption>--%>
        <thead>
        <tr>
            <th>#</th>
            <th>제목</th>
            <th>작성자</th>
            <th>날짜</th>
            <th>조회수</th>
        </tr>
        </thead>
        <tbody id="listData">
        </tbody>
    </table>
</div>
<script id="list-template" type="text/x-handlebars-template">
    {{#each .}}
    <tr>
        <td>{{articleId}}</td>
        <td>{{articleTitle}}</td>
        <td>{{articleWriter}}</td>
        <td>{{formatDate createdAt "YYYY-MM-DD hh:ss:mm"}}</td>
        <td>{{articleView}}</td>
    </tr>
    {{/each}}
</script>