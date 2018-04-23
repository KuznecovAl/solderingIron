<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<table width="100%" border="0">
    <tr>
        <td align="center" valign="center">

            <sec:authorize access="isAnonymous()">
                <c:url var="loginUrl" value="/login"/>
                <form action="${loginUrl}" method="post">
                    <div>
                        <c:if test="${param.error != null}">
                            <div><p>Invalid username and password.</p></div>
                        </c:if>
                        <div>
                            <input type="text" class="form-control" id="login" name="login"
                                   placeholder="<spring:message code="login.enterlogin"/>" required="required"
                                   maxlength="18">
                            </input>
                        </div>
                        <div>
                            <input type="password" id="password" name="password"
                                   placeholder="<spring:message code="login.enterpassword"/>" required="required"
                                   maxlength="12">
                            </input>
                            <div>
                                <button type="submit">
                                    <i><spring:message code="login.signin"/></i>
                                </button>
                            </div>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                        </input>
                    </div>
                </form>
            </sec:authorize>

            <form action="${pageContext.request.contextPath}/reg" method="get" accept-charset="UTF-8">
                <input type="submit" value="<spring:message code="login.signup"/>">
            </form>
        </td>
    </tr>
</table>
<%--<head>--%>
<%--<script src="/assests/js/jquery-1.11.1.min.js" type="text/javascript"><jsp:text/></script>--%>
<%--<script src="/assests/js/utils.js" type="text/javascript"><jsp:text/></script>--%>
<%--</head>--%>

<%--<form method="post" class="signin" action="/mvc/j_spring_security_check">--%>
<%--<fieldset>--%>
<%--<div>--%>
<%--<label for="username_or_email"><spring:message code="login.login"/></label>--%>
<%--<input class="text" id="username_or_email" name="j_username" placeholder="login"--%>
<%--type="text" style="height:16px;width:80px;margin:10px;"/> <!-- Поле ввода имени пользователя -->--%>

<%--<label for="password"><spring:message code="login.password"/></label>--%>
<%--<input class="text" id="password" name="j_password" placeholder="Password"--%>
<%--type="password" style="height:16px;width:80px;margin:10px;"/> <!-- Поле ввода пароля -->--%>
<%--<br/><small><a href="/user/resend_password"><spring:message code="login.forgot"/></a></small>--%>

<%--<br/>--%>
<%--<input type="submit" value="<spring:message code="login.submit"></spring:message>"</input>--%>
<%--</div>--%>
<%--</fieldset>--%>
<%--</form>--%>

