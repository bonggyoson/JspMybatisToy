<%--
  Created by IntelliJ IDEA.
  User: bongg
  Date: 2023-11-16
  Time: 오후 5:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html data-bs-theme="dark">
<!-- Pagination Header -->
<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="nav"/>
<!-- Pagination Contents -->
<tiles:insertAttribute name="body"/>
<tiles:insertAttribute name="pagination"/>
<!-- Pagination Footer -->
<tiles:insertAttribute name="footer"/>
</html>
