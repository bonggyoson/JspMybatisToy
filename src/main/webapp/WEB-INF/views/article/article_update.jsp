<%--
  Created by IntelliJ IDEA.
  User: bongg
  Date: 2023-12-01
  Time: 오후 3:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://example.com/functions" prefix="f" %>
<div class="container">
    <div class="container-fluid px-4">
        <h1 class="mt-4">Article</h1>
        <div class="card mb-4">
            <div class="card-body" id="data">
            </div>
        </div>
    </div>
</div>
<script>
  $(function select_article() {
    getAjax('post', '/api/article/${articleId}', '', 'json');
  });

  function update_article() {
    if (confirm("정말로 수정하시겠습니까?")) {
      getAjax('put', '/api/article/${articleId}/update', getFormData($("#frm")), '');
    } else {
      return 0;
    }
  }

  function delete_article() {
    if (confirm("정말로 삭제하시겠습니까?")) {
      getAjax('delete', '/api/article/${articleId}/delete', '', '');
    }
  }
</script>
<script id="template" type="text/x-handlebars-template">
    <form id="frm">
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
            <label for="articleTitle" class="form-label">제목</label>
            <input type="text" class="form-control" id="articleTitle" name="articleTitle"
                   value="{{articleTitle}}">
        </div>
        <div class="mb-3">
            <label for="articleContent" class="form-label">내용</label>
            <textarea class="form-control"
                      id="articleContent" name="articleContent">
                {{articleContent}}</textarea>
        </div>
        <div class="mb-3">
            <label for="createdAt" class="form-label">등록일</label> <input
                type="text" class="form-control"
                id="createdAt" name="createdAt"
                value="{{createdAt}}" disabled>
        </div>
        <div class="mb-3">
            <label for="articleWriter" class="form-label">글쓴이</label> <input
                type="text" class="form-control"
                id="articleWriter" name="articleWriter"
                value="{{articleWriter}}">
        </div>
        <button class="btn btn-outline-warning"
                onclick="update_article()">수정
        </button>
        <button class="btn btn-outline-danger"
                onclick="delete_article()">삭제
        </button>
    </form>
</script>