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
<div class="container w-50 position-relative text-opacity-25 mt-4">
    <div class="card mb-4">
        <div class="card-body" id="listData">
        </div>
    </div>
</div>
<script>
  getAjax('post', '/api/article/${articleId}', '', 'json', false);
</script>
<script id="template" type="text/x-handlebars-template">
    <div class="card">
        <div class="card-header border-0 pb-0">
            <div class="d-flex align-items-center justify-content-between">
                <div class="d-flex align-items-center">
                    <!-- Avatar -->
                    <div class="avatar avatar-story me-2">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                             fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                            <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                            <path fill-rule="evenodd"
                                  d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                        </svg>
                    </div>
                    <!-- Info -->
                    <div>
                        <div class="nav nav-divider">
                            <h6 class="nav-item card-title mb-0"><a href="#!"> Lori Ferguson </a>
                            </h6>
                            <span class="nav-item small"> 2hr</span>
                        </div>
                        <p class="mb-0 small">Web Developer at Webestica</p>
                    </div>
                </div>
                <!-- Card feed action dropdown START -->
                <div class="dropdown">
                    <a href="#" class="text-secondary btn btn-secondary-soft-hover py-1 px-2"
                       id="cardFeedAction" data-bs-toggle="dropdown" aria-expanded="false">
                        <i class="bi bi-three-dots"></i>
                    </a>
                    <!-- Card feed action dropdown menu -->
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="cardFeedAction">
                        <li><a class="dropdown-item" href="#"> <i
                                class="bi bi-bookmark fa-fw pe-2"></i>Save post</a></li>
                        <li><a class="dropdown-item" href="#"> <i
                                class="bi bi-person-x fa-fw pe-2"></i>Unfollow lori ferguson </a>
                        </li>
                        <li><a class="dropdown-item" href="#"> <i
                                class="bi bi-x-circle fa-fw pe-2"></i>Hide post</a></li>
                        <li><a class="dropdown-item" href="#"> <i
                                class="bi bi-slash-circle fa-fw pe-2"></i>Block</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="#"> <i class="bi bi-flag fa-fw pe-2"></i>Report
                            post</a></li>
                    </ul>
                </div>
                <!-- Card feed action dropdown END -->
            </div>
        </div>

    </div>
    <h5 class="card-title">{{articleTitle}}</h5>
    <p class="card-text">{{articleContent}}</p>
    <a href="${pageContext.request.contextPath}/article"
       class="btn btn-outline-secondary">돌아가기</a>
    <a href="${pageContext.request.contextPath}/article/updateArticle/${articleId}"
       class="btn btn-outline-warning">수정</a>
    <hr>
    <div class="card-body">
        <div class="row">
            <div class="col">
                <label for="exampleFormControlInput1" class="form-label"></label>
                <input type="text" class="form-control" id="exampleFormControlInput1">
            </div>
            <div class="col-auto">
                <button type="button" class="btn btn-secondary">등록</button>
            </div>
        </div>
    </div>

</script>