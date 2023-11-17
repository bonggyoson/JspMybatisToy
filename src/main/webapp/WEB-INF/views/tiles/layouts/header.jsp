<%--
  Created by IntelliJ IDEA.
  User: bongg
  Date: 2023-11-14
  Time: 오후 3:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="requestURI" value="${requestScope['javax.servlet.forward.request_uri']}"/>

<ul>
    <c:forEach var="menu" items="${menuList}">
        <li>
            <a href="${menu.menuUrl}" title="${menu.menuName}">
                <c:out value="${menu.menuName}"/>
            </a>
        </li>
    </c:forEach>
</ul>