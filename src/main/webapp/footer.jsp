<%--
  Created by IntelliJ IDEA.
  User: my_user
  Date: 05.11.2022
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <style>
        .footer {
            position: fixed;
            left: 0;
            bottom: 0;
            padding: 10px;
            color: dimgray;
            width: 100%;
        }
    </style>
    <title></title>
</head>
<body>


<div class="footer">
    Статистика:
    <br>
    name: ${username}
    <br>
    Количество игр: ${counter}
<%--    <c:if test="${counter == 0}">--%>
<%--        <c:out value="Это ваша первая игра"/>--%>
<%--    </c:if>--%>
<%--    <c:if test="${counter > 0}">--%>
<%--        <c:out value="${counter}"/>--%>
<%--    </c:if>--%>
<%--    <br>--%>
<%--    ip: ${ip}--%>
</div>
</body>
</html>
