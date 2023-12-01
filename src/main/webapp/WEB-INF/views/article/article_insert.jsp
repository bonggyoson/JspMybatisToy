<%--
  Created by IntelliJ IDEA.
  User: bongg
  Date: 2023-11-16
  Time: 오후 4:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://example.com/functions" prefix="f" %>
<div class="container">
    <div class="container-fluid px-4 mt-5">
        <div class="card mb-4">
            <div class="card-body" id="data">
            </div>
        </div>
    </div>
</div>
<script>
  $(function () {
    getAjax('post', '/api/article/' + ${articleId}, 'json');
  });
</script>
<script id="template" type="text/x-handlebars-template">
    <form>
        <div class="mb-3 mt-3">
            <label for="articleId" class="form-label">번호</label>
            <input type="text"
                   class="form-control"
                   id="articleId"
                   name="articleId"
                   value="{{articleId}}"
                   disabled>
        </div>
        <div class="mb-3">
            <label for="articleTitle" class="form-label">제목</label> <input
                type="text" class="form-control" id="articleTitle" name="articleTitle"
                value="{{articleTitle}}" disabled>
        </div>
        <div class="mb-3">
            <label for="articleContent" class="form-label">내용</label>
            <textarea class="form-control" id="articleContent" name="articleContent"
                      disabled>{{articleContent}}</textarea>
        </div>
        <div class="mb-3">
            <label for="createdAt" class="form-label">등록일</label> <input
                type="text" class="form-control" id="createdAt" name="createdAt"
                value="{{createdAt}}" disabled>
        </div>
        <div class="mb-3">
            <label for="articleWriter" class="form-label">글쓴이</label> <input
                type="text" class="form-control" id="articleWriter" name="articleWriter"
                value="{{articleWriter}}" disabled>
        </div>
        <a href="${pageContext.request.contextPath}/article"
           class="btn btn-outline-secondary">돌아가기</a>
        <a href="${pageContext.request.contextPath}/article/updateArticle/${articleId}"
           class="btn btn-outline-warning">수정</a>
    </form>
</script>
