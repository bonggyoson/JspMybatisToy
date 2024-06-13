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
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="container w-50 position-relative text-opacity-25 mt-4">
    <div class="card mb-4">
        <div class="card-body" id="listData">
        </div>
    </div>
</div>
<script>
  $(function () {
    getAjax('post', '/api/article/${articleId}', '', 'json', false);
  });

  function insert_comment() {
    let commentContent = $("#commentContent");

    // 댓글 검증
    if (checkNull(commentContent.val())) {
      swalToast("댓글 내용을 입력해주세요.", "warning");
      return false;
    }

    submitAjax('post', '/api/comment/insert', JSON.stringify(getFormData($("#frm"))), 'json',
        'application/json');
  }
</script>
<script id="data-template" type="text/x-handlebars-template">
    <div class="card mb-2">
        <div class="card-header border-0">
            <div class="d-flex align-items-center justify-content-between">
                <div class="d-flex align-items-center">
                    <!-- Avatar -->
                    <div class="avatar avatar-story me-2">
                        <img
                                src="{{#ifCond member.storeFileName '==' undefined}} /static/images/person-bounding-box.svg {{else}} /api/member/images/{{member.storeFileName}} {{/ifCond}}"
                                width="40px" height="40px" class="rounded"/>
                    </div>
                    <!-- Info -->
                    <div>
                        <div class="nav nav-divider">
                            <h6 class="nav-item card-title mb-0"><a
                                    href="#!">{{member.memberName}} </a>
                            </h6>
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="21"
                                 fill="currentColor" class="bi bi-dot" viewBox="0 0 16 16">
                                <path d="M8 9.5a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3"></path>
                            </svg>
                            <span class="nav-item small">{{formatDate createdAt "YYYY-MM-DD hh:ss:mm"}}</span>
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="21"
                                 fill="currentColor" class="bi bi-dot" viewBox="0 0 16 16">
                                <path d="M8 9.5a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3"></path>
                            </svg>
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="21"
                                 fill="currentColor" class="bi bi-binoculars" viewBox="0 0 16 16">
                                <path d="M3 2.5A1.5 1.5 0 0 1 4.5 1h1A1.5 1.5 0 0 1 7 2.5V5h2V2.5A1.5 1.5 0 0 1 10.5 1h1A1.5 1.5 0 0 1 13 2.5v2.382a.5.5 0 0 0 .276.447l.895.447A1.5 1.5 0 0 1 15 7.118V14.5a1.5 1.5 0 0 1-1.5 1.5h-3A1.5 1.5 0 0 1 9 14.5v-3a.5.5 0 0 1 .146-.354l.854-.853V9.5a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v.793l.854.853A.5.5 0 0 1 7 11.5v3A1.5 1.5 0 0 1 5.5 16h-3A1.5 1.5 0 0 1 1 14.5V7.118a1.5 1.5 0 0 1 .83-1.342l.894-.447A.5.5 0 0 0 3 4.882zM4.5 2a.5.5 0 0 0-.5.5V3h2v-.5a.5.5 0 0 0-.5-.5zM6 4H4v.882a1.5 1.5 0 0 1-.83 1.342l-.894.447A.5.5 0 0 0 2 7.118V13h4v-1.293l-.854-.853A.5.5 0 0 1 5 10.5v-1A1.5 1.5 0 0 1 6.5 8h3A1.5 1.5 0 0 1 11 9.5v1a.5.5 0 0 1-.146.354l-.854.853V13h4V7.118a.5.5 0 0 0-.276-.447l-.895-.447A1.5 1.5 0 0 1 12 4.882V4h-2v1.5a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5zm4-1h2v-.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5zm4 11h-4v.5a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5zm-8 0H2v.5a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5z"/>
                            </svg>
                            <span class="nav-item small mx-1">{{articleViewCount}}</span>
                        </div>
                        <p class="mb-0 small">Web Developer</p>
                    </div>
                </div>
                <!-- Card feed action dropdown START -->
                <div class="dropdown">
                    <a href="#" class="text-secondary btn btn-secondary-soft-hover py-1 px-2"
                       id="cardFeedAction" data-bs-toggle="dropdown" aria-expanded="false">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                             fill="currentColor" class="bi bi-three-dots-vertical"
                             viewBox="0 0 16 16">
                            <path d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0m0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0m0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0"/>
                        </svg>
                    </a>
                    <!-- Card feed action dropdown menu -->
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="cardFeedAction">
                        <li><a class="dropdown-item" href="#"> <i
                                class="bi bi-bookmark fa-fw pe-2"></i>Save post</a></li>
                        <li><a class="dropdown-item" href="#"> <i
                                class="bi bi-person-x fa-fw pe-2"></i>Unfollow lori ferguson </a>
                        </li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="#"> <i class="bi bi-flag fa-fw pe-2"></i>Report
                            post</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <h1 class="card-title mb-3">{{articleTitle}}</h1>
    <p class="card-text">{{articleContent}}</p>
    <hr/>
    <ul class="nav nav-stack mb-3">
        <li class="nav-item">
            <small>
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="21"
                     fill="currentColor" class="bi bi-hand-thumbs-up" viewBox="0 0 16 16">
                    <path d="M8.864.046C7.908-.193 7.02.53 6.956 1.466c-.072 1.051-.23 2.016-.428 2.59-.125.36-.479 1.013-1.04 1.639-.557.623-1.282 1.178-2.131 1.41C2.685 7.288 2 7.87 2 8.72v4.001c0 .845.682 1.464 1.448 1.545 1.07.114 1.564.415 2.068.723l.048.03c.272.165.578.348.97.484.397.136.861.217 1.466.217h3.5c.937 0 1.599-.477 1.934-1.064a1.86 1.86 0 0 0 .254-.912c0-.152-.023-.312-.077-.464.201-.263.38-.578.488-.901.11-.33.172-.762.004-1.149.069-.13.12-.269.159-.403.077-.27.113-.568.113-.857 0-.288-.036-.585-.113-.856a2 2 0 0 0-.138-.362 1.9 1.9 0 0 0 .234-1.734c-.206-.592-.682-1.1-1.2-1.272-.847-.282-1.803-.276-2.516-.211a10 10 0 0 0-.443.05 9.4 9.4 0 0 0-.062-4.509A1.38 1.38 0 0 0 9.125.111zM11.5 14.721H8c-.51 0-.863-.069-1.14-.164-.281-.097-.506-.228-.776-.393l-.04-.024c-.555-.339-1.198-.731-2.49-.868-.333-.036-.554-.29-.554-.55V8.72c0-.254.226-.543.62-.65 1.095-.3 1.977-.996 2.614-1.708.635-.71 1.064-1.475 1.238-1.978.243-.7.407-1.768.482-2.85.025-.362.36-.594.667-.518l.262.066c.16.04.258.143.288.255a8.34 8.34 0 0 1-.145 4.725.5.5 0 0 0 .595.644l.003-.001.014-.003.058-.014a9 9 0 0 1 1.036-.157c.663-.06 1.457-.054 2.11.164.175.058.45.3.57.65.107.308.087.67-.266 1.022l-.353.353.353.354c.043.043.105.141.154.315.048.167.075.37.075.581 0 .212-.027.414-.075.582-.05.174-.111.272-.154.315l-.353.353.353.354c.047.047.109.177.005.488a2.2 2.2 0 0 1-.505.805l-.353.353.353.354c.006.005.041.05.041.17a.9.9 0 0 1-.121.416c-.165.288-.503.56-1.066.56z"/>
                </svg>
                56
            </small>
        </li>
        <li class="nav-item mx-3">
            <small>
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="21"
                     fill="currentColor" class="bi bi-chat-dots" viewBox="0 0 16 16">
                    <path d="M5 8a1 1 0 1 1-2 0 1 1 0 0 1 2 0m4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0m3 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2"/>
                    <path d="m2.165 15.803.02-.004c1.83-.363 2.948-.842 3.468-1.105A9 9 0 0 0 8 15c4.418 0 8-3.134 8-7s-3.582-7-8-7-8 3.134-8 7c0 1.76.743 3.37 1.97 4.6a10.4 10.4 0 0 1-.524 2.318l-.003.011a11 11 0 0 1-.244.637c-.079.186.074.394.273.362a22 22 0 0 0 .693-.125m.8-3.108a1 1 0 0 0-.287-.801C1.618 10.83 1 9.468 1 8c0-3.192 3.004-6 7-6s7 2.808 7 6-3.004 6-7 6a8 8 0 0 1-2.088-.272 1 1 0 0 0-.711.074c-.387.196-1.24.57-2.634.893a11 11 0 0 0 .398-2"/>
                </svg>
                12
            </small>
        </li>
    </ul>

    <!-- Add comment -->
    <div class="d-flex mb-3">
        <!-- Avatar -->
        <div class="avatar avatar-xs me-2">
            <img
                    src="{{#ifCond member.storeFileName '==' undefined}} /static/images/person-bounding-box.svg {{else}} /api/member/images/{{member.storeFileName}} {{/ifCond}}"
                    width="40px" height="40px" class="rounded"/>
        </div>

        <!-- Comment box  -->
        <form id="frm" onsubmit="return false;" class="input-group">
                <textarea id="commentContent" name="commentContent" adata-autoresize=""
                          class="form-control me-2 rounded" rows="1"
                          placeholder="댓글을 입력해주세요."></textarea>
            <input type="hidden" id="articleId" name="articleId" value="{{articleId}}"/>
            <input type="hidden" id="memberId" name="memberId"
                   value="<sec:authentication property="principal.memberId"/>"/>
            <button class="btn btn-primary mb-0 rounded" onclick="insert_comment()">등록</button>
        </form>
    </div>
    <!-- Comment wrap START -->
    {{#each comment}}
    <div class="card mb-2">
        <div class="card-header border-0">
            <div class="d-flex align-items-center justify-content-between">
                <div class="d-flex align-items-center">
                    <!-- Avatar -->
                    <div class="avatar avatar-story me-2">
                        <img id="imageData"
                             src="{{#ifCond member.storeFileName '==' undefined}} /static/images/person-bounding-box.svg {{else}} /api/member/images/{{member.storeFileName}} {{/ifCond}}"
                             width="40px" height="40px" class="rounded"/>
                    </div>
                    <!-- Info -->
                    <div>
                        <div class="nav nav-divider">
                            <h6 class="nav-item card-title mb-0">{{member.memberName}} </h6>
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="21"
                                 fill="currentColor" class="bi bi-dot" viewBox="0 0 16 16">
                                <path d="M8 9.5a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3"></path>
                            </svg>
                            <span class="nav-item small">{{formatDate updatedAt "YYYY-MM-DD hh:ss:mm"}}</span>
                        </div>
                        <p class="mb-0 small">{{commentContent}}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    {{/each}}
    <!-- Comment wrap END -->
</script>
