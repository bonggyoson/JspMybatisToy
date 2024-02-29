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
        <div class="card-body flex-nowrap">
            <div class="row">
                <div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark text-center col-3">
                    <a href="/myPage/<sec:authentication property="principal.memberId"/>"
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
                <div class="d-flex flex-column bg-dark flex-shrink-0 p-3 bg-light col">
                    <div class="card">
                        <div class="card-body">
                            <div class="card-title text-center">
                                회원정보수정
                            </div>
                            <div class="row">
                                <div class="col-3"></div>
                                <div class="col-6" id="listData">
                                </div>
                            </div>
                            <div class="col-3"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>

  getAjax('post', '/api/mypage/<sec:authentication property="principal.memberId"/>', '', 'json',
      false);

  function update_member() {
    Swal.fire({
      title: "정말로 수정하시겠습니까?",
      showCancelButton: true,
      confirmButtonColor: 'Skyblue',
      cancelButtonColor: 'gray',
      confirmButtonText: '네',
      cancelButtonText: '아니요',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        submitAjax('put', '/api/member/<sec:authentication property="principal.memberId"/>/update',
            getFormData($("#frm")), 'json', 'application/json');
        swalToast();
      }
    });
  }

</script>
<script id="data-template" type="text/x-handlebars-template">
    <form id="frm" onsubmit="return false;">
        <div class="mb-3">
            <div class="input-group">
                                            <span class="input-group-text">
                                                              <svg xmlns="http://www.w3.org/2000/svg"
                                                                   width="16"
                                                                   height="16" fill="currentColor"
                                                                   class="bi bi-envelope"
                                                                   viewBox="0 0 16 16">
                                              <path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4Zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1H2Zm13 2.383-4.708 2.825L15 11.105V5.383Zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741ZM1 11.105l4.708-2.897L1 5.383v5.722Z"></path>
                                            </svg>
                                                            </span>
                <input type="text" class="form-control"
                       name="memberEmail"
                       id="memberEmail"
                       placeholder="이메일"
                       value="{{memberEmail}}">
            </div>
            <small class="fw-bold" id="emailValid"></small>
        </div>
        <div class="mb-3">
            <div class="input-group">
                                        <span class="input-group-text" id="basic-addon1">
                                                          <svg xmlns="http://www.w3.org/2000/svg"
                                                               width="16"
                                                               height="16" fill="currentColor"
                                                               class="bi bi-person-lines-fill"
                                                               viewBox="0 0 16 16">
                                          <path d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm-5 6s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zM11 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5zm.5 2.5a.5.5 0 0 0 0 1h4a.5.5 0 0 0 0-1h-4zm2 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2zm0 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2z"></path>
                                        </svg>
                                                        </span>
                <input type="text" class="form-control"
                       name="memberName"
                       id="memberName"
                       placeholder="이름"
                       value="{{memberName}}">
            </div>
            <small class="fw-bold" id="nameValid"></small>
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-secondary" id="sweetConfirm"
                    onclick="update_member()">
                수정
            </button>
        </div>
    </form>
</script>