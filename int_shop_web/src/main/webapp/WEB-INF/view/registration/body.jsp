<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<table width="100%" border="0">
    <tr>
        <td align="center" valign="center">
            <div class="container text-center">
                <div class="error">${errorMsg}</div>
                <form action="${pageContext.request.contextPath}/registration" method="post" accept-charset="UTF-8">
                    <b><spring:message code="login.login"/></b><input type="text" name="login" maxlength="30"/>
                    <b><spring:message code="login.password"/></b><input type="password" name="password"
                                                                         maxlength="20"/>
                    <b><spring:message code="login.email"/></b><input type="email" name="e_mail" maxlength="50"/><br/>
                    <input type="submit" value="<spring:message code="login.register"/>">
                </form>
                <form action="${pageContext.request.contextPath}/login" method="get" accept-charset="UTF-8">
                    <input type="submit" value="<spring:message code="login.signin"/>">
                </form>
            </div>
        </td>
    </tr>
</table>