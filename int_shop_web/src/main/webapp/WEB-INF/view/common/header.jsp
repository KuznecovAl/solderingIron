<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<table width="100%" border="0">
    <tr>

        <td align="center" valign="center" bgcolor="#deb887">
            <img alt="SOLDERING IRON" src="${pageContext.request.contextPath}/assests/pic/si_main.jpg"/>
        </td>






        <td width="63%" align="center" valign="center" bgcolor="#deb887" >
            <table border="1">
                <tr>
                    <td>
                            1
                    </td>
                </tr>
                <tr>
                    <td>
                                                    2
                    </td>
                </tr>
                <tr>
                    <td>
                            3
                    </td>
                </tr>
            </table>
        </td>













        <td align="center" valign="top" bgcolor="#deb887">

            <%--LOCALE--%>

            <c:set var="locale" value="${pageContext.response.locale.language}"/>

            <c:if test="${locale eq 'en'}">
                <li><a href="?locale=ru"><spring:message code="header.locale.ru"/></a></li>
                <li><spring:message code="header.locale.en"/></li>
            </c:if>

            <c:if test="${locale eq 'ru'}">
                <li><spring:message code="header.locale.ru"/></li>
                <li><a href="?locale=en"><spring:message code="header.locale.en"/></a></li>
            </c:if>

                <br/>

            <%--LOGIN NOT--%>

            <sec:authorize access="isAnonymous()">

                <c:if test="${not(pageContext.request.servletPath eq 'loginPage' or pageContext.request.servletPath eq 'regPage')}">
                    <li><a href="${pageContext.request.contextPath}/login"><spring:message code="login.signin"/></a><br/></li>
                    <li><a href="${pageContext.request.contextPath}/reg"><spring:message code="login.signup"/></a><br/></li>
                </c:if>


                <c:if test="${pageContext.request.servletPath eq 'loginPage'}">
                    <li><spring:message code="login.signin"/></li>
                    <li><a href="${pageContext.request.contextPath}/reg"><spring:message code="login.signup"/></a></li>
                </c:if>

                <c:if test="${pageContext.request.servletPath eq 'regPage'}">
                    <li><a href="${pageContext.request.contextPath}/login"><spring:message code="login.signin"/></a><br/></li>
                    <li><spring:message code="login.signup"/></li>
                </c:if>


            </sec:authorize>


            <%--LOGIN DONE--%>
            <sec:authorize access="isAuthenticated()">
                <p>Hello, <sec:authentication property="principal.displayName"/></p>
                <ul>
                    <c:url var="logout" value="/logout"/>
                    <li>
                        <a href="/settings" id="settingsButton">
                            <spring:message code="sett.settings"/></a>
                    </li>
                    <li>
                        <a href="${logout}" id="logOutButton">
                            <spring:message code="login.logout"/></a>
                    </li>
                </ul>
            </sec:authorize>
        </td>
    </tr>

    <%--Строка поиска--%>
    <tr>
        <td colspan="3" align="center" valign="center" bgcolor="#d2691e">
            <div><spring:message code="header.search"/><input name="search"></div>
        </td>
    </tr>

</table>



