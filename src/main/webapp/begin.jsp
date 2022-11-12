<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<h1>Привет ${username} </h1>
<h1>Добро пожаловать в игру "Семейные будни"</h1>
<br>
<h3>
    У Мистера Х был сложный день: работа, начальник и прочие радости будних дней.
    Он идет домой, где его ждет его Леди, совсем-микро-киндер и питомец.
    По дороге Мистер Х обдумывает планы на вечер: сегодня у него учёба
    (Мистер Х осваивает профессию мелиоратора – ведь это интересно и перспективно),
    нужно обезопасить дом для микро-киндера, да и просто хочется отдохнуть.
    С этими мыслями он открывает дверь.
    <br>
    <br>
    Основная цель игры – не выполнить все дела (как ни странно),
    а сохранить нормальный уровень семейного настроения
</h3>

<form>
    <input type="text" name="username" value="${username}" hidden>
    <input type="text" name="counter" value="${counter}" hidden>
    <input type="text" name="nextQuestion" value="${nextQuestion}" hidden>
    <input type="submit" value="Начать игру" >
</form>


<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
