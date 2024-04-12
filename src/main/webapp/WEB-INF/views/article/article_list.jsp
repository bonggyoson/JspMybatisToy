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
<%@ taglib uri="http://example.com/functions" prefix="f" %>
<div class="container w-50 position-relative text-opacity-25">
    <div class="row mt-2 border border-1 rounded">
        <div class="col">
            <h1>ARTICLE</h1>
        </div>
        <div class="col-auto align-self-center">
            <button type="button" class="btn btn-secondary"
                    onclick="location.href='/article/insertArticle'">글쓰기
            </button>
        </div>
    </div>
    <table class="table table-striped caption-top table-hover">
        <caption>총 <em id="totalNum"></em> 건 / <em id="pageNum"></em> 페이지</caption>
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
  let url = window.location.search;

  $(function () {
    !checkNull(url) ? getAjax('post', '/api/article' + url, '', 'json', true)
        : getAjax('post', '/api/article', '', 'json', true);
  });
</script>
<script id="list-template" type="text/x-handlebars-template">
    {{#each list}}
    <tr>
        <td>{{articleId}}</td>
        <td>
            <a href="${pageContext.request.contextPath}/article/{{articleId}}">{{articleTitle}}</a>
        </td>
        <td>{{member.memberName}}</td>
        <td>{{formatDate createdAt "YYYY-MM-DD hh:ss:mm"}}</td>
        <td>{{articleViewCount}}</td>
    </tr>
    {{/each}}
</script>
<script id="page-template" type="text/x-handlebars-template">
    <ul class="pagination justify-content-center">
        {{#ifCond hasPreviousPage '==' true}}
        <li class="page-item">
            <a class="page-link" aria-label="first"
               onclick="getAjax('post', !checkNull(url) ? '/api/article' + url + '&page={{navigateFirstPage}}' : '/api/article?page={{navigateFirstPage}}', '', 'json', true)">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <li class="page-item">
            <a class="page-link" aria-label="previous"
               onclick="getAjax('post', !checkNull(url) ? '/api/article' + url + '&page={{math pageNum '-' 1}}' : '/api/article?page={{math pageNum '-' 1}}', '', 'json', true)">
                <span aria-hidden="true">&lsaquo;</span>
            </a>
        </li>
        {{/ifCond}}
        {{#each navigatepageNums}}
        <li class="page-item">
            <button class="page-link" id="{{math @index '+' 1}}page"
                    onclick="getAjax('post', !checkNull(url) ? '/api/article' + url + '&page={{math @index '+' 1}}' : '/api/article?page={{math @index '+' 1}}' , '', 'json', true)">
                {{math @index "+" 1}}
            </button>
        </li>
        {{/each}}
        {{#ifCond hasNextPage '==' true}}
        <li class="page-item" id="next">
            <a class="page-link" aria-label="Last"
               onclick="getAjax('post', !checkNull(url) ? '/api/article' + url + '&page={{math pageNum '+' 1}}' : '/api/article?page={{math pageNum '+' 1}}', '', 'json', true)">
                <span aria-hidden="true">&rsaquo;</span>
            </a>
        </li>
        <li class="page-item" id="last">
            <a class="page-link" aria-label="Last"
               onclick="getAjax('post', !checkNull(url) ? '/api/article' + url + '&page={{navigateLastPage}}' : '/api/article?page={{navigateLastPage}}', '', 'json', true)">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
        {{/ifCond}}
    </ul>
</script>
