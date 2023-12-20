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
<div class="container w-50 position-relative text-opacity-25">
    <h1 class="mt-4">TOY</h1>
    <table class="table table-striped caption-top table-hover">
        <caption>총 <em id="totalNum"></em> 건</caption>
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
    <nav id="pageData" aria-label="Page navigation example">
    </nav>
</div>
<script>
  $(function () {
    getListAjax('post', '/api/article', 'json');
  });
</script>
<script id="list-template" type="text/x-handlebars-template">
    {{#each list}}
    <tr>
        <td>{{articleId}}</td>
        <td><a href="${pageContext.request.contextPath}/article/{{articleId}}">{{articleTitle}}</a>
        </td>
        <td>{{articleWriter}}</td>
        <td>{{formatDate createdAt "YYYY-MM-DD hh:ss:mm"}}</td>
        <td>{{articleViewCount}}</td>
    </tr>
    {{/each}}
</script>
<script id="page-template" type="text/x-handlebars-template">
    <ul class="pagination justify-content-center">
        {{#ifCond hasPreviousPage '==' true}}
        <li class="page-item">
            <a class="page-link" aria-label="Previous"
               onclick="getListAjax('post', '/api/article?page={{math pageNum '-' 1}}', 'json')">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        {{/ifCond}}
        {{#each navigatepageNums}}
        <li class="page-item">
            <button class="page-link ${'{{math @index "+" 1}}' eq '{{../pageNum}}' ? 'active' : 'none'}"
                    onclick="getListAjax('post', '/api/article?page={{math @index '+' 1}}', 'json')">
                {{math @index "+" 1}}
            </button>
            <%--            {{/ifCond}}--%>
            <%--            {{#ifCond {{../pageNum}} '!=' {{math @index '+' 1}}}}--%>
            <%--            <a class="page-link"--%>
            <%--               onclick="getListAjax('post', '/api/article?page={{math @index '+' 1}}', 'json')">--%>
            <%--                {{math @index "+" 1}}--%>
            <%--            </a>--%>
            <%--            {{/ifCond}}--%>
        </li>
        {{/each}}
        {{#ifCond hasNextPage '==' true}}
        <li class="page-item" id="next">
            <a class="page-link" href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
        {{/ifCond}}
    </ul>
</script>