<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Family</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
          crossorigin="anonymous">
</head>
<body>
<div class="text-bg-secondary p-3">

    <div class="container text-center">
        <div class="row align-items-center">
            <div class="col-9">

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
                    <input type="submit" value="Начать игру">
                </form>
            </div>

            <div class="col-3">
                <img class="w-100" srcset="img\page_begin.jpg" alt="family">
            </div>
        </div>
    </div>


    <jsp:include page="footer.jsp"></jsp:include>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
            crossorigin="anonymous">

    </script>
</div>

</body>
</html>
