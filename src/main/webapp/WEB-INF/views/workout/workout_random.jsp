<%--
  Created by IntelliJ IDEA.
  User: 20231102
  Date: 2024-06-26
  Time: 오후 1:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container w-auto position-absolute top-50 start-50 translate-middle">
    <div class="card bg-dark bg-gradient d-flex justify-content-center"
         style="border-radius: 1rem;">
        <div class="card-body p-7 text-center">
            <button type="button" class="btn btn-lg mb-2 fw-bold text-white"
                    onclick="location.href='/workout'">WORKOUT OF DAY
            </button>
            <div class="mb-2">
                <p>${today}</p>
                <div id="listData"></div>
            </div>
        </div>
    </div>
</div>
<script>
  $(function () {
    getAjax('post', '/api/workout', '', 'json', false);
  });
</script>
<script id="data-template" type="text/x-handlebars-template">
    <p>{{workoutName}}</p>
    <p>{{workoutContent}}</p>
</script>