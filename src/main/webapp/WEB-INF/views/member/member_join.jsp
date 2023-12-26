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
        <div class="card-body p-5 text-center">
            <button type="button" class="btn btn-lg mb-2 fw-bold text-white"
                    onclick="location.href='/'">TOY BOARD
            </button>
            <p class="fw-bold">회원가입</p>
            <div class="mb-2">
                <form id="frm">
                    <div class="mb-3">
                        <input type="text" class="form-control" name="memberEmail" id="memberEmail"
                               placeholder="이메일">
                    </div>
                    <div class="mb-3">
                        <input type="password" class="form-control" name="memberPassword" id="memberPassword"
                               placeholder="비밀번호">
                    </div>
                    <div class="mb-3">
                        <input type="text" class="form-control" name="memberName" id="memberName"
                               placeholder="이름">
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
    getAjax('post', '/api/member/join', getFormData($("#frm")), '');
  }
</script>