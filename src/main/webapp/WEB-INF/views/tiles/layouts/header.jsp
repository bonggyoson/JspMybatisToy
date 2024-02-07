<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: bongg
  Date: 2023-11-14
  Time: 오후 3:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark container w-50 pt-3 border-bottom border-secondary">
        <!-- Navbar Brand-->
        <a class="navbar-brand ps-2" href="${pageContext.request.contextPath}/article">Mybatis &
            Jsp</a>
        <!-- Sidebar Toggle-->
        <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle"
                href="#!">
            <svg class="svg-inline--fa fa-bars" aria-hidden="true" focusable="false"
                 data-prefix="fas"
                 data-icon="bars" role="img" xmlns="http://www.w3.org/2000/svg"
                 viewBox="0 0 448 512"
                 data-fa-i2svg="">
                <path fill="currentColor"
                      d="M0 96C0 78.3 14.3 64 32 64H416c17.7 0 32 14.3 32 32s-14.3 32-32 32H32C14.3 128 0 113.7 0 96zM0 256c0-17.7 14.3-32 32-32H416c17.7 0 32 14.3 32 32s-14.3 32-32 32H32c-17.7 0-32-14.3-32-32zM448 416c0 17.7-14.3 32-32 32H32c-17.7 0-32-14.3-32-32s14.3-32 32-32H416c17.7 0 32 14.3 32 32z"></path>
            </svg>
        </button>
        <!-- Navbar Search-->
        <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
            <div class="input-group">
                <input class="form-control" type="text" placeholder="검색"
                       aria-label="검색" aria-describedby="btnNavbarSearch">
                <button type="button" class="btn btn-secondary">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                         fill="currentColor"
                         class="bi bi-search" viewBox="0 0 16 16">
                        <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"></path>
                    </svg>
                </button>
            </div>
        </form>
        <!-- Navbar-->
        <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button"
                   data-bs-toggle="dropdown" aria-expanded="false">
                    <svg class="svg-inline--fa fa-user fa-fw" aria-hidden="true" focusable="false"
                         data-prefix="fas" data-icon="user" role="img"
                         xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512" data-fa-i2svg="">
                        <path fill="currentColor"
                              d="M224 256A128 128 0 1 0 224 0a128 128 0 1 0 0 256zm-45.7 48C79.8 304 0 383.8 0 482.3C0 498.7 13.3 512 29.7 512H418.3c16.4 0 29.7-13.3 29.7-29.7C448 383.8 368.2 304 269.7 304H178.3z"></path>
                    </svg>
                </a>
                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                    <sec:authorize access="isAnonymous()">
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/login">로그인</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/join">회원가입</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/myPage">마이페이지</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/api/member/logout">로그아웃</a>
                        </li>
                    </sec:authorize>
                </ul>
            </li>
        </ul>
    </nav>
</header>
