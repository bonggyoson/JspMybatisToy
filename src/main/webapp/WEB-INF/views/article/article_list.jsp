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
<div class="container">
    <div class="row mt-4">
        <div class="col-11 text-center">
            <h2> ~ 게시판 놀이 ~ </h2>
        </div>
        <div class="col-auto">
            <button class="btn btn-outline-light" onclick="location.href='article/insertArticle'">
                글쓰기
            </button>
        </div>
    </div>
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
    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>
<script id="list-template" type="text/x-handlebars-template">
    {{#each .}}
    <tr>
        <td>{{articleId}}</td>
        <td>{{articleTitle}}</td>
        <td>{{articleWriter}}</td>
        <td>{{f:formatLocalDateTime(data.createdAt, 'YYYY.MM.dd')}}</td>
        <td>{{articleView}}</td>
    </tr>
    {{/each}}
</script>