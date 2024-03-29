<%--
  Created by IntelliJ IDEA.
  User: bongg
  Date: 2023-11-16
  Time: 오후 5:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container w-auto position-absolute top-50 start-50 translate-middle">
    <div class="card bg-dark bg-gradient d-flex justify-content-center"
         style="border-radius: 1rem;">
        <div class="card-body text-center">
            <button type="button" class="btn btn-lg mb-2 fw-bold text-white"
                    onclick="location.href='/'">TOY BOARD
            </button>
            <p class="fw-bold">회원가입</p>
            <div class="mb-2">
                <form id="frm" onsubmit="return false;">
                    <div class="mb-3">
                        <div class="input-group">
                            <span class="input-group-text">
                                              <svg xmlns="http://www.w3.org/2000/svg" width="16"
                                                   height="16" fill="currentColor"
                                                   class="bi bi-envelope" viewBox="0 0 16 16">
                              <path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4Zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1H2Zm13 2.383-4.708 2.825L15 11.105V5.383Zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741ZM1 11.105l4.708-2.897L1 5.383v5.722Z"></path>
                            </svg>
                                            </span>
                            <input type="text" class="form-control" name="memberEmail"
                                   id="memberEmail"
                                   placeholder="이메일">
                        </div>
                        <small class="fw-bold" id="emailValid"></small>
                    </div>
                    <div class="mb-3">
                        <div class="input-group">
                        <span class="input-group-text">
                                          <svg xmlns="http://www.w3.org/2000/svg" width="16"
                                               height="16" fill="currentColor"
                                               class="bi bi-key-fill" viewBox="0 0 16 16">
                          <path d="M3.5 11.5a3.5 3.5 0 1 1 3.163-5H14L15.5 8 14 9.5l-1-1-1 1-1-1-1 1-1-1-1 1H6.663a3.5 3.5 0 0 1-3.163 2zM2.5 9a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"></path>
                        </svg>
                                        </span>
                            <input type="password" class="form-control" name="memberPassword"
                                   id="memberPassword"
                                   placeholder="비밀번호">
                        </div>
                        <small class="fw-bold" id="passwordValid"></small>
                    </div>
                    <div class="mb-3">
                        <div class="input-group">
                        <span class="input-group-text" id="basic-addon1">
                                          <svg xmlns="http://www.w3.org/2000/svg" width="16"
                                               height="16" fill="currentColor"
                                               class="bi bi-person-lines-fill" viewBox="0 0 16 16">
                          <path d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm-5 6s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zM11 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5zm.5 2.5a.5.5 0 0 0 0 1h4a.5.5 0 0 0 0-1h-4zm2 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2zm0 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2z"></path>
                        </svg>
                                        </span>
                            <input type="text" class="form-control" name="memberName"
                                   id="memberName"
                                   placeholder="이름">
                        </div>
                        <small class="fw-bold" id="nameValid"></small>
                    </div>
                    <button type="submit" class="btn btn-secondary me-2" onclick="join_member()">
                        회원가입
                    </button>
                    <button type="button" class="btn btn-outline-secondary"
                            onclick="location.href='/login'">
                        로그인
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
  function join_member() {
    let memberEmail = $("#memberEmail").val() === "" || $("#memberEmail").val() === null;
    let memberPassword = $("#memberPassword").val() === "" || $("#memberPassword").val() === null;
    let memberName = $("#memberName").val() === "" || $("#memberName").val() === null;
    let validCount = 0;

    // 이메일 공백 검증
    if (memberEmail) {
      $("#emailValid").html("이메일을 입력해주세요.");
      $("#emailValid").css({'color': 'red'});
      $("#memberEmail").css({'border-color': 'red'});
      validCount++;
    }

    // 비밀번호 공백 검증
    if (memberPassword) {
      $("#passwordValid").html("비밀번호를 입력해주세요.");
      $("#passwordValid").css({'color': 'red'});
      $("#memberPassword").css({'border-color': 'red'});
      validCount++;
    }

    // 이름 공백 검증
    if (memberName) {
      $("#nameValid").html("이름을 입력해주세요.");
      $("#nameValid").css({'color': 'red'});
      $("#memberName").css({'border-color': 'red'});
      validCount++;
    }

    if (validCount > 0) {
      return false;
    }
    submitAjax('post', '/api/member/join', getFormData($("#frm")), 'json', 'application/json');
  }

  // ajax 이메일 중복 체크
  $("#memberEmail").on("blur", function () {
    let memberEmail = $("#memberEmail");
    let emailValid = $("#emailValid");

    if ($(this).val().trim().length === 0) {
      this.style = "initial";
      emailValid.html("");
      return false;
    }

    // 이메일 유효성 검사
    let regExpEmail = RegExp(
        /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([\-.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i);

    if (!regExpEmail.test(memberEmail.val())) {
      emailValid.html("이메일 형식에 맞게 작성해주세요.");
      memberEmail.css({'border-color': 'red'});
      emailValid.css({'color': 'red'});
      emailValid.focus();
      return false;
    } else {
      $.ajax({
        url: '/api/member/checkDuplicateEmail',
        type: 'post',
        data: {
          memberEmail: memberEmail.val()
        },
        success: function (data) {
          if (data === 0) {
            emailValid.html("사용 가능한 이메일입니다.");
            memberEmail.css({'border-color': ''});
            emailValid.css({'color': 'skyblue'});
            emailValid.focus();
          } else {
            emailValid.html("이미 사용중인 이메일입니다.");
            memberEmail.css({'border-color': 'red'});
            emailValid.css({'color': 'red'});
            emailValid.focus();
          }
        }
      });
    }
  });
</script>