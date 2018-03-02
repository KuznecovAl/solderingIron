<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<TABLE border="1">
    <tr>
        <th>№</th>
        <th>Order Id</th>
        <th>Date</th>
        <th>Status</th>
        <th>User</th>
    </tr>

    <c:forEach var="order" items="${orders}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${order.id}</td>
            <td>${order.date_time}</td>
            <td>${order.status}</td>
            <td>${user.name}</td>
        </tr>
        <%--<c:forEach var="item" items="${itemss}" varStatus="status2">--%>
            <%--<tr>--%>
                <%--<td></td>--%>
                <%--<td>${status2.index + 1}</td>--%>
                <%--<td>${item.id_orders}</td>--%>
                <%--<td>${item.id_products}</td>--%>
                <%--<td>${item.quantity}</td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
    </c:forEach>
</TABLE>
