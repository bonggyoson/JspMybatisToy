<%--
  Created by IntelliJ IDEA.
  User: 20231102
  Date: 2024-02-28
  Time: 오후 4:48
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
            <p class="fw-bold">비밀번호 재설정</p>
            <div class="mb-2">
                <form id="frm" onsubmit="return false;">
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
                            <input type="text" class="form-control" id="memberEmail"
                                   name="memberEmail"
                                   placeholder="이메일">
                        </div>
                        <small class="fw-bold" id="emailValid"></small>
                    </div>
                    <div class="d-grid gap-2">
                        <button type="submit" class="btn btn-secondary"
                                onclick="reset_password()">비밀번호 재설정하기
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
  function reset_password() {
    let memberEmail = $("#memberEmail").val() === "" || $("#memberEmail").val() === null;
    let emailValid = $("#emailValid");
    let validCount = 0;

    // 이메일 공백 검증
    if (memberEmail) {
      emailValid.html("이메일을 입력해주세요.");
      emailValid.css({'color': 'red'});
      emailValid.css({'border-color': 'red'});
      validCount++;
    }

    if (validCount > 0) {
      return false;
    }

    // 이메일 유효성 검사
    let regExpEmail = RegExp(
        /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([\-.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i);

    if (!regExpEmail.test($("#memberEmail").val())) {
      emailValid.html("이메일 형식에 맞게 작성해주세요.");
      emailValid.css({'color': 'red'});
      memberEmail.css({'border-color': 'red'});
      memberEmail.focus();
      validCount++;
    }

    if (validCount > 0) {
      return false;
    }

    submitAjax('post', '/api/member/resetPassword', getFormData($("#frm")), 'json',
        'application/json');
  }

</script>