<%--
  Created by IntelliJ IDEA.
  User: my_user
  Date: 10.11.2022
  Time: 2:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    Поздравляю Вы выиграли!
</h1>
<br>
<br>
<br>
<h2>
    Вы чудесно проводите время вместе с Леди, как в старые добрые времена, Микро-Киндер и питомец тихо спят.
</h2>
<br>
<br>
<form method="post">
    <input type="text" name="username" value="${username}" hidden>
    <input type="text" name="counter" value="${counter}" hidden>
<%--    <input type="text" name="nextQuestion" value="" hidden>--%>
    <input type="submit" value="Попробуете ещё раз?">
</form>
<br>
<br>
<form action="/index">
    <input type="submit" value="Сменить пользователя">
</form>
</body>
</html>
