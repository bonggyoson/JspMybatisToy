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
                <form>
                    <div class="mb-3">
                        <input type="email" class="form-control" id="username" name="username"
                               placeholder="이메일">
                    </div>
                    <div class="mb-3">
                        <input type="password" class="form-control" id="password" name="password"
                               placeholder="비밀번호"/>
                    </div>
                    <div class="d-grid gap-2 d-md-flex justify-content-md-center">
                        <button type="submit" class="btn btn-secondary" id="login">로그인</button>
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