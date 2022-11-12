<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2>Привет!</h2>
<h3>Сейчас тебе предстоит пройти квест максимально приближенный к реальной жизни! <br>
    Готов? Тогда приступим!</h3>
<form action="hello" method="post">
    Введите имя игрока: <input name="username" />
    <input type="submit" value="Начать игру">
</form>

</body>
</html>