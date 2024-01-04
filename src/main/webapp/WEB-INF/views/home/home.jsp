<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
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
            <h3 class="fw-bold">TOY BOARD</h3>
            <h4>${principal.memberName}</h4>
            <div class="mb-auto">
                <button type="button" class="btn btn-secondary"
                        onclick="location.href='/article'">게시판
                </button>
                <button type="button" class="btn btn-secondary"
                        onclick="location.href='/login'">회원
                </button>
            </div>
        </div>
    </div>
</div>