<%--
  Created by IntelliJ IDEA.
  User: bongg
  Date: 2023-11-16
  Time: 오후 4:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="container w-50 position-relative text-opacity-25 mt-4">
    <div class="card mb-4">
        <div class="card-body">
            <h4 class="card-title">글쓰기</h4>
            <form id="frm" onsubmit="return false;">
                <div class="mb-3">
                    <label for="articleTitle" class="form-label">제목</label>
                    <input type="text" class="form-control" id="articleTitle" name="articleTitle">
                    <input type="hidden" id="memberId" name="memberId"
                           value="<sec:authentication property="principal.memberId"/>">
                    <small class="fw-bold" id="titleValid"></small>
                </div>
                <div class="mb-3">
                    <label for="articleContent" class="form-label">내용</label>
                    <textarea class="form-control" id="articleContent" name="articleContent"
                    ></textarea>
                    <small class="fw-bold" id="contentValid"></small>
                </div>
                <div class="float-end">
                    <button type="button" class="btn btn-outline-secondary"
                            onclick="location.href='/article'">취소
                    </button>
                    <button type="button" class="btn btn-primary"
                            onclick="insert_article()"
                    >등록
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
  function insert_article() {
    let articleTitle = $("#articleTitle");
    let articleContent = $("#articleContent");
    let titleValid = $("#titleValid");
    let contentValid = $("#contentValid");
    let validCount = 0;

    // 제목 검증
    if (articleTitle.val() === "" || articleTitle.val() === null) {
      titleValid.html("제목을 입력해주세요");
      titleValid.css({'color': 'red'});
      articleTitle.css({'border-color': 'red'});
      validCount++;
    }

    // 본문 검증
    if (articleContent.val() === "" || articleContent.val() === null) {
      contentValid.html("내용을 입력해주세요");
      contentValid.css({'color': 'red'});
      articleContent.css({'border-color': 'red'});
      validCount++;
    }
    if (validCount > 0) {
      return false;
    }

    submitAjax('post', '/api/article/insert', JSON.stringify(getFormData($("#frm"))), 'json', 'application/json');
  }
</script>