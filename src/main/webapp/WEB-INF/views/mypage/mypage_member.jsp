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
                            <div class="card-title text-center mb-3">
                                <h5><b>회원정보수정</b></h5>
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

  function delete_member() {
    Swal.fire({
      title: "<div style='font-size:20px;color:red'>" + "정말로 탈퇴하시겠습니까?" + "</div>",
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
            '/api/member/<sec:authentication property="principal.memberId"/>/delete', 'json',
            'application/json');
      }
    });
  }

  function update_password() {
    let memberPassword = $('#memberPassword').val();
    let memberPasswordCheck = $('#memberPasswordCheck').val();
    let passwordValid = $('#passwordValid');
    let passwordCheckValid = $('#passwordCheckValid');
    let validCount = 0;

    passwordValid.html("");
    passwordCheckValid.html("");

    if (memberPassword === "" || memberPassword === null) {
      passwordValid.html("비밀번호를 입력해주세요.");
      passwordValid.css({'color': 'red'});
      validCount++;
    }

    if (memberPasswordCheck === "" || memberPasswordCheck === null) {
      passwordCheckValid.html("비밀번호 확인을 입력해주세요.");
      passwordCheckValid.css({'color': 'red'});
      validCount++;
    }

    if (memberPassword !== memberPasswordCheck) {
      Swal.fire({
        icon: "error",
        text: "비밀번호가 일치하지 않습니다.",
        width: "350"
      });
      passwordValid.css({'color': 'red'});
      passwordCheckValid.css({'color': 'red'});
      validCount++;
    }

    if (validCount > 0) {
      return false;
    }

    submitAjax('post',
        '/api/member/<sec:authentication property="principal.memberId"/>/updatePassword',
        $('#frmPassword').serializeArray(), 'json', 'application/json');

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
            <button type="submit" class="btn btn-secondary"
                    onclick="update_member()">
                수정
            </button>
        </div>
    </form>
    <form id="frmPassword" onsubmit="return false;">
        <div class="row mt-3">
            <div class="col">
                <a class="link-secondary" style="cursor:hand" onclick="delete_member()">
                    회원 탈퇴
                </a>
            </div>
            <div class="col-auto">
                <a class="link-secondary" style="cursor:hand" data-bs-toggle="modal"
                   data-bs-target="#exampleModal">
                    비밀번호 변경
                </a>
            </div>
        </div>
        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">비밀번호 변경</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="mb-3 text-center">
                            <div class="input-group">
                                <span class="input-group-text">
                                    <svg xmlns="http://www.w3.org/2000/svg"
                                         width="16"
                                         height="16"
                                         fill="currentColor"
                                         class="bi bi-key-fill"
                                         viewBox="0 0 16 16">
                                        <path d="M3.5 11.5a3.5 3.5 0 1 1 3.163-5H14L15.5 8 14 9.5l-1-1-1 1-1-1-1 1-1-1-1 1H6.663a3.5 3.5 0 0 1-3.163 2zM2.5 9a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"></path>
                                                                                </svg>
                                                                                                </span>
                                <input type="password" class="form-control"
                                       name="memberPassword"
                                       id="memberPassword"
                                       placeholder="비밀번호">
                            </div>
                            <small class="fw-bold" id="passwordValid"></small>
                        </div>
                        <div class="mb-3 text-center">
                            <div class="input-group">
                                <span id="passwordChangeIcon" class="input-group-text">
                                    <svg
                                            xmlns="http://www.w3.org/2000/svg" width="16"
                                            height="16"
                                            fill="currentColor" class="bi bi-check2-square"
                                            viewBox="0 0 16 16">
                                        <path d="M3 14.5A1.5 1.5 0 0 1 1.5 13V3A1.5 1.5 0 0 1 3 1.5h8a.5.5 0 0 1 0 1H3a.5.5 0 0 0-.5.5v10a.5.5 0 0 0 .5.5h10a.5.5 0 0 0 .5-.5V8a.5.5 0 0 1 1 0v5a1.5 1.5 0 0 1-1.5 1.5z"/>
                                        <path d="m8.354 10.354 7-7a.5.5 0 0 0-.708-.708L8 9.293 5.354 6.646a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0"/>
                                      </svg></span>
                                <input type="password" class="form-control"
                                       name="memberPasswordCheck"
                                       id="memberPasswordCheck"
                                       placeholder="비밀번호 확인">
                            </div>
                            <small class="fw-bold" id="passwordCheckValid"></small>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                            취소
                        </button>
                        <button type="button" class="btn btn-primary" onclick="update_password()">
                            변경
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</script>