<%--
  Created by IntelliJ IDEA.
  User: 20231102
  Date: 2024-02-13
  Time: 오후 1:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="container w-50 position-relative text-opacity-25 mt-4">
    <div class="card mb-4">
        <div class="card-body flex-nowrap" id="listData">
            <div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark text-center"
                 style="width: 200px;">
                <a href="/myPage/<sec:authentication property="principal.memberId"/>"
                   class="mb-1 text-white text-decoration-none">
                    <svg xmlns="http://www.w3.org/2000/svg" width="40px" height="40px"
                         fill="currentColor" class="bi bi-person-bounding-box me-3"
                         viewBox="0 0 16 16">
                        <path d="M1.5 1a.5.5 0 0 0-.5.5v3a.5.5 0 0 1-1 0v-3A1.5 1.5 0 0 1 1.5 0h3a.5.5 0 0 1 0 1zM11 .5a.5.5 0 0 1 .5-.5h3A1.5 1.5 0 0 1 16 1.5v3a.5.5 0 0 1-1 0v-3a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 1-.5-.5M.5 11a.5.5 0 0 1 .5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 1 0 1h-3A1.5 1.5 0 0 1 0 14.5v-3a.5.5 0 0 1 .5-.5m15 0a.5.5 0 0 1 .5.5v3a1.5 1.5 0 0 1-1.5 1.5h-3a.5.5 0 0 1 0-1h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 1 .5-.5"/>
                        <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zm8-9a3 3 0 1 1-6 0 3 3 0 0 1 6 0"/>
                    </svg>
                    <span class="fs-4"><sec:authentication property="principal.memberName"/></span>
                </a>
                <hr>
                <ul class="nav nav-pills flex-column mb-auto">
                    <li class="nav-item">
                        <a href="/myPage/<sec:authentication property="principal.memberId"/>"
                           class="nav-link active" aria-current="page">
                            회원정보수정
                        </a>
                    </li>
                    <li>
                        <a href="/myPage/article/<sec:authentication property="principal.memberId"/>"
                           class="nav-link text-white">
                            게시글관리
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<script>
  getAjax('post', '/api/mypage/<sec:authentication property="principal.memberId"/>', '', 'json',
      false);
</script>