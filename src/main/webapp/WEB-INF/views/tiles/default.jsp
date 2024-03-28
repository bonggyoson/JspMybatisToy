<%--
  Created by IntelliJ IDEA.
  User: bongg
  Date: 2023-11-16
  Time: 오후 5:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html data-bs-theme="dark">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Toy Article</title>
    <link rel="icon" type="image/ico" href="${pageContext.request.contextPath}/static/images/box2-heart-fill.svg">

    <%-- css --%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css">

    <%-- js --%>
    <%-- <script src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>--%>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.bundle.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>

    <script src="${pageContext.request.contextPath}/static/js/common/common.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/common/helper.js"></script>

    <%-- sweetalert2 --%>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.js"></script>
</head>
<body>
<!-- Pagination Header -->
<tiles:insertAttribute name="header"/>
<%--<tiles:insertAttribute name="nav"/>--%>
<!-- Pagination Contents -->
<tiles:insertAttribute name="body"/>
<!-- Pagination Footer -->
<tiles:insertAttribute name="footer"/>
</body>
</html>
