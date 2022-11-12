
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    Сожалею, Вы проиграли
</h1>
<br>
<br>
Почему: ${whyfailure}
<h2>

    <br>
    Скандал каких свет не видевал, критически низкий уровень настроения.
</h2>

<form method="post">
    <input type="text" name="username" value="${username}" hidden>
    <input type="text" name="counter" value="${counter}" hidden>
    <input type="submit" value="Попробуете ещё раз?">
</form>
<br>
<br>
<form action="/index">
    <input type="submit" value="Сменить пользователя">
</form>

</body>
</html>
