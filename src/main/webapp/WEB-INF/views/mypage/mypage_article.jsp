<%--
  Created by IntelliJ IDEA.
  User: 20231102
  Date: 2024-02-13
  Time: 오후 1:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://example.com/functions" prefix="f" %>
<div class="container w-50 position-relative text-opacity-25 mt-4">
    <div class="card mb-4">
        <div class="card-body flex-nowrap">
            <div class="row">
                <div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark text-center col-3">
                    <a href="/myPage/article/<sec:authentication property="principal.memberId"/>"
                       class="mb-1 text-white text-decoration-none">
                        <svg xmlns="http://www.w3.org/2000/svg" width="40px" height="40px"
                             fill="currentColor" class="bi bi-person-bounding-box me-3"
                             viewBox="0 0 16 16">
                            <path d="M1.5 1a.5.5 0 0 0-.5.5v3a.5.5 0 0 1-1 0v-3A1.5 1.5 0 0 1 1.5 0h3a.5.5 0 0 1 0 1zM11 .5a.5.5 0 0 1 .5-.5h3A1.5 1.5 0 0 1 16 1.5v3a.5.5 0 0 1-1 0v-3a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 1-.5-.5M.5 11a.5.5 0 0 1 .5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 1 0 1h-3A1.5 1.5 0 0 1 0 14.5v-3a.5.5 0 0 1 .5-.5m15 0a.5.5 0 0 1 .5.5v3a1.5 1.5 0 0 1-1.5 1.5h-3a.5.5 0 0 1 0-1h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 1 .5-.5"/>
                            <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zm8-9a3 3 0 1 1-6 0 3 3 0 0 1 6 0"/>
                        </svg>
                        <span class="fs-4"><sec:authentication
                                property="principal.memberName"/></span>
                    </a>
                    <hr>
                    <ul class="nav nav-pills flex-column mb-auto">
                        <li class="nav-item">
                            <a href="/myPage/<sec:authentication property="principal.memberId"/>"
                               class="nav-link text-white">
                                회원정보수정
                            </a>
                        </li>
                        <li>
                            <a href="/myPage/article/<sec:authentication property="principal.memberId"/>"
                               class="nav-link text-white active">
                                게시글관리
                            </a>
                        </li>
                    </ul>
                </div>
                <div class="d-flex flex-column bg-dark flex-shrink-0 p-3 bg-light col">
                    <div class="card">
                        <div class="card-body">
                            <div class="card-title text-center mb-3">
                                <h5><b>내 게시글</b></h5>
                            </div>
                            <div class="row">
                                <div id="listData">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
  getAjax('post', '/api/myPage/article/<sec:authentication property="principal.memberId"/>', '',
      'json',
      true);

  function update_article() {
    Swal.fire({
      title: "<div style='font-size:20px'>" + "정말로 수정하시겠습니까?" + "</div>",
      width: "400px",
      showCancelButton: true,
      confirmButtonColor: 'blue',
      cancelButtonColor: 'gray',
      confirmButtonText: '네',
      cancelButtonText: '아니요',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        submitAjax('put', '/api/member/<sec:authentication property="principal.memberId"/>/update',
            getFormData($("#frm")), 'json', 'application/json');
      }
    });
  }

  function delete_article() {
    Swal.fire({
      title: "<div style='font-size:20px;color:red'>" + "정말로 삭제하시겠습니까?" + "</div>",
      width: "400px",
      showCancelButton: true,
      confirmButtonColor: 'blue',
      cancelButtonColor: 'gray',
      confirmButtonText: '네',
      cancelButtonText: '아니요',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {

        submitAjax('delete',
            '/api/article/<sec:authentication property="principal.memberId"/>/delete', 'json',
            'application/json');
      }
    });
  }

</script>
<script id="list-template" type="text/x-handlebars-template">
    {{#each list}}
    <div class="card">
        <div class="card-body">
            <div class="row">
                <div class="col">{{articleId}}</div>
                <div class="col-auto">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="21"
                         fill="currentColor" class="bi bi-binoculars" viewBox="0 0 16 16">
                        <path d="M3 2.5A1.5 1.5 0 0 1 4.5 1h1A1.5 1.5 0 0 1 7 2.5V5h2V2.5A1.5 1.5 0 0 1 10.5 1h1A1.5 1.5 0 0 1 13 2.5v2.382a.5.5 0 0 0 .276.447l.895.447A1.5 1.5 0 0 1 15 7.118V14.5a1.5 1.5 0 0 1-1.5 1.5h-3A1.5 1.5 0 0 1 9 14.5v-3a.5.5 0 0 1 .146-.354l.854-.853V9.5a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v.793l.854.853A.5.5 0 0 1 7 11.5v3A1.5 1.5 0 0 1 5.5 16h-3A1.5 1.5 0 0 1 1 14.5V7.118a1.5 1.5 0 0 1 .83-1.342l.894-.447A.5.5 0 0 0 3 4.882zM4.5 2a.5.5 0 0 0-.5.5V3h2v-.5a.5.5 0 0 0-.5-.5zM6 4H4v.882a1.5 1.5 0 0 1-.83 1.342l-.894.447A.5.5 0 0 0 2 7.118V13h4v-1.293l-.854-.853A.5.5 0 0 1 5 10.5v-1A1.5 1.5 0 0 1 6.5 8h3A1.5 1.5 0 0 1 11 9.5v1a.5.5 0 0 1-.146.354l-.854.853V13h4V7.118a.5.5 0 0 0-.276-.447l-.895-.447A1.5 1.5 0 0 1 12 4.882V4h-2v1.5a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5zm4-1h2v-.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5zm4 11h-4v.5a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5zm-8 0H2v.5a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5z"/>
                    </svg>
                    {{articleViewCount}}
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="21"
                         fill="currentColor" class="bi bi-dot" viewBox="0 0 16 16">
                        <path d="M8 9.5a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3"></path>
                    </svg>
                    {{formatDate createdAt "YYYY-MM-DD hh:ss:mm"}}
                </div>
            </div>
            <div class="mt-2">
                <p class="card-text"><a
                        href="${pageContext.request.contextPath}/article/{{articleId}}">{{articleTitle}}</a>
                </p>
            </div>
        </div>
        <div class="card-footer text-muted">
            2 days ago
        </div>
    </div>
    {{/each}}
</script>
<script id="page-template" type="text/x-handlebars-template">
    <ul class="pagination justify-content-center">
        {{#ifCond hasPreviousPage '==' true}}
        <li class="page-item">
            <a class="page-link" aria-label="first"
               onclick="getAjax('post', '/api/myPage/article?page={{navigateFirstPage}}', '', 'json', true)">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <li class="page-item">
            <a class="page-link" aria-label="previous"
               onclick="getAjax('post', '/api/article?page={{math pageNum '-' 1}}', '', 'json', true)">
                <span aria-hidden="true">&lsaquo;</span>
            </a>
        </li>
        {{/ifCond}}
        {{#each navigatepageNums}}
        <li class="page-item">
            <button class="page-link" id="{{math @index '+' 1}}page"
                    onclick="getAjax('post', '/api/article?page={{math @index '+' 1}}', '', 'json', true)">
                {{math @index "+" 1}}
            </button>
        </li>
        {{/each}}
        {{#ifCond hasNextPage '==' true}}
        <li class="page-item" id="next">
            <a class="page-link" aria-label="Last"
               onclick="getAjax('post', '/api/article?page={{math pageNum '+' 1}}', '', 'json', true)">
                <span aria-hidden="true">&rsaquo;</span>
            </a>
        </li>
        <li class="page-item" id="last">
            <a class="page-link" aria-label="Last"
               onclick="getAjax('post', '/api/article?page={{navigateLastPage}}', '', 'json', true)">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
        {{/ifCond}}
    </ul>
</script>
