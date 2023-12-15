<%--
  Created by IntelliJ IDEA.
  User: bongg
  Date: 2023-11-16
  Time: 오후 5:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container w-25">
    <div class="card bg-dark bg-gradient d-flex justify-content-center"
         style="border-radius: 1rem;">
        <div class="card-body p-5 text-center">
            <button type="button" class="btn btn-lg mb-2 fw-bold text-white"
                    onclick="location.href='/'">JspMybatis
            </button>
            <p class="text-white-100 fw-bold">회원가입</p>
            <div class="mb-2">
                <form onsubmit="return false">
                    <div class="mb-3">
                        <input type="text" class="form-control" name="email" id="email"
                               placeholder="이메일">
                    </div>
                    <div class="mb-3">
                        <input type="password" class="form-control" name="password" id="password"
                               placeholder="비밀번호">
                    </div>
                    <div class="mb-3">
                        <input type="text" class="form-control" name="name" id="name"
                               placeholder="이름">
                    </div>
                    <button type="submit" class="btn btn-secondary me-2" id="save-member">회원가입
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