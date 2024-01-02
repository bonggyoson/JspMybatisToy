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
                                   placeholder="비밀번호"/>
                        </div>
                        <small class="fw-bold" id="passwordValid"></small>
                    </div>
                    <div class="d-grid gap-2 d-md-flex justify-content-md-center">
                        <button type="submit" class="btn btn-secondary" id="login"
                                onclick="login_member()">로그인
                        </button>
                        <button type="button" class="btn btn-outline-secondary"
                                onclick="location.href='/join'">
                            회원가입
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
  function login_member() {
    let memberEmail = $("#memberEmail").val() === "" || $("#memberEmail").val() === null;
    let memberPassword = $("#memberPassword").val() === "" || $("#memberPassword").val() === null;
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

    if (validCount > 0) {
      console.log("test");
      return false;
    }
    return true;
  }
</script>