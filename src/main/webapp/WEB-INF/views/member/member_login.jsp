<%--
  Created by IntelliJ IDEA.
  User: bongg
  Date: 2023-11-14
  Time: 오전 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container w-auto position-absolute top-50 start-50 translate-middle">
    <div class="card bg-dark bg-gradient d-flex justify-content-center"
         style="border-radius: 1rem;">
        <div class="card-body p-7 text-center">
            <button type="button" class="btn btn-lg mb-2 fw-bold text-white"
                    onclick="location.href='/article'">TOY BOARD
            </button>
            <p class="fw-bold">로그인</p>
            <div class="mb-2">
                <form id="frm" method="post"
                      action="${pageContext.request.contextPath}/api/member/login"
                      onsubmit="return login_member();">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="mb-3">
                        <div class="input-group">
                            <span class="input-group-text">
                                                                          <svg xmlns="http://www.w3.org/2000/svg"
                                                                               width="16"
                                                                               height="16"
                                                                               fill="currentColor"
                                                                               class="bi bi-envelope"
                                                                               viewBox="0 0 16 16">
                                                          <path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4Zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1H2Zm13 2.383-4.708 2.825L15 11.105V5.383Zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741ZM1 11.105l4.708-2.897L1 5.383v5.722Z"></path>
                                                        </svg>
                                                                        </span>
                            <input type="email" class="form-control" id="memberEmail"
                                   name="memberEmail"
                                   placeholder="이메일">
                        </div>
                        <small class="fw-bold" id="emailValid"></small>
                    </div>
                    <div class="mb-3">
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
                            <input type="password" class="form-control" id="memberPassword"
                                   name="memberPassword"
                                   placeholder="비밀번호"
                            />
                            <span id="passwordChangeIcon" class="input-group-text"
                                  onclick="confirm_password()"><svg
                                    xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                    fill="currentColor" class="bi bi-eye-slash" viewBox="0 0 16 16">
                                              <path d="M13.359 11.238C15.06 9.72 16 8 16 8s-3-5.5-8-5.5a7 7 0 0 0-2.79.588l.77.771A6 6 0 0 1 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13 13 0 0 1 14.828 8q-.086.13-.195.288c-.335.48-.83 1.12-1.465 1.755q-.247.248-.517.486z"/>
                                              <path d="M11.297 9.176a3.5 3.5 0 0 0-4.474-4.474l.823.823a2.5 2.5 0 0 1 2.829 2.829zm-2.943 1.299.822.822a3.5 3.5 0 0 1-4.474-4.474l.823.823a2.5 2.5 0 0 0 2.829 2.829"/>
                                              <path d="M3.35 5.47q-.27.24-.518.487A13 13 0 0 0 1.172 8l.195.288c.335.48.83 1.12 1.465 1.755C4.121 11.332 5.881 12.5 8 12.5c.716 0 1.39-.133 2.02-.36l.77.772A7 7 0 0 1 8 13.5C3 13.5 0 8 0 8s.939-1.721 2.641-3.238l.708.709zm10.296 8.884-12-12 .708-.708 12 12z"/>
                                            </svg></span>
                        </div>
                        <small class="fw-bold" id="passwordValid"></small>
                    </div>
                    <div class="mb-3">
                        <small class="fw-bold" style="color: red">${exception}</small>
                    </div>
                    <div class="d-grid gap-2">
                        <button type="submit" class="btn btn-secondary" id="login"
                                onclick="login_member()">로그인
                        </button>
                    </div>
                </form>
                <hr/>
                <div class="row">
                    <div class="col-7">
                        <a class="link-secondary"
                           href="/resetPassword">
                            비밀번호 재설정
                        </a>
                    </div>
                    <div class="col-5">
                        <a class="link-secondary"
                           href="/join">
                            회원가입
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
  function login_member() {
    let memberEmail = $("#memberEmail");
    let memberPassword = $("#memberPassword");
    let emailValid = $("#emailValid");
    let passwordValid = $("#passwordValid");
    let validCount = 0;

    memberEmail.css({'border-color': ''});
    emailValid.html("");
    memberPassword.css({'border-color': ''});
    passwordValid.html("");

    // 이메일 공백 검증
    if (memberEmail.val() === "" || memberEmail.val() === null) {
      emailValid.html("이메일을 입력해주세요.");
      emailValid.css({'color': 'red'});
      memberEmail.css({'border-color': 'red'});
      validCount++;
    }

    // 비밀번호 공백 검증
    if (memberPassword.val() === "" || memberPassword.val() === null) {
      passwordValid.html("비밀번호를 입력해주세요.");
      passwordValid.css({'color': 'red'});
      memberPassword.css({'border-color': 'red'});
      validCount++;
    }

    if (validCount > 0) {
      return false;
    }

    // 이메일 유효성 검사
    let regExpEmail = RegExp(
        /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([\-.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i);

    if (!regExpEmail.test(memberEmail.val())) {
      emailValid.html("이메일 형식에 맞게 작성해주세요.");
      emailValid.css({'color': 'red'});
      memberEmail.css({'border-color': 'red'});
      memberEmail.focus();
      validCount++;
    }

    return true;
  }

  // 패스워드 보이기 / 숨기기
  function confirm_password() {
    if (document.getElementById("memberPassword").type == 'password') {
      document.getElementById("memberPassword").type = 'text';
      $('#passwordChangeIcon').html(
          `<svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-eye' viewBox='0 0 16 16'>
          <path d = "M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8M1.173 8a13 13 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5s3.879 1.168 5.168 2.457A13 13 0 0 1 14.828 8q-.086.13-.195.288c-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5s-3.879-1.168-5.168-2.457A13 13 0 0 1 1.172 8z"/>
          <path d = "M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5M4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0" / >
          </svg>`);
    } else {
      document.getElementById("memberPassword").type = 'password';
      $('#passwordChangeIcon').html(
          `<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye-slash" viewBox="0 0 16 16">
            <path d="M13.359 11.238C15.06 9.72 16 8 16 8s-3-5.5-8-5.5a7 7 0 0 0-2.79.588l.77.771A6 6 0 0 1 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13 13 0 0 1 14.828 8q-.086.13-.195.288c-.335.48-.83 1.12-1.465 1.755q-.247.248-.517.486z"/>
            <path d="M11.297 9.176a3.5 3.5 0 0 0-4.474-4.474l.823.823a2.5 2.5 0 0 1 2.829 2.829zm-2.943 1.299.822.822a3.5 3.5 0 0 1-4.474-4.474l.823.823a2.5 2.5 0 0 0 2.829 2.829"/>
            <path d="M3.35 5.47q-.27.24-.518.487A13 13 0 0 0 1.172 8l.195.288c.335.48.83 1.12 1.465 1.755C4.121 11.332 5.881 12.5 8 12.5c.716 0 1.39-.133 2.02-.36l.77.772A7 7 0 0 1 8 13.5C3 13.5 0 8 0 8s.939-1.721 2.641-3.238l.708.709zm10.296 8.884-12-12 .708-.708 12 12z"/>
          </svg>`);
    }
  }

</script>