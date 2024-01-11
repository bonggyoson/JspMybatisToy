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
<div class="container w-50 position-relative text-opacity-25 mt-4">
    <div class="card mb-4">
        <div class="card-body">
            <form>
                <div class="mb-3">
                    <label for="articleTitle" class="form-label">제목</label> <input
                        type="text" class="form-control" id="articleTitle" name="articleTitle">
                </div>
                <div class="mb-3">
                    <label for="articleContent" class="form-label">내용</label>
                    <textarea class="form-control" id="articleContent" name="articleContent"
                    ></textarea>
                </div>
                <a href="${pageContext.request.contextPath}/article"
                   class="btn btn-outline-secondary">돌아가기</a>
                <a href="${pageContext.request.contextPath}/article/insertArticle"
                   class="btn btn-outline-warning">등록</a>
            </form>
        </div>
    </div>
</div>
<script>
  function insert_article() {
    getAjax('post', '/api/member/join', getFormData($("#frm")), 'json', 'application/json');
  }
</script>