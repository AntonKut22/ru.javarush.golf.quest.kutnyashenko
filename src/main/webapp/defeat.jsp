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

                <h2>
                    ${whyfailure}
                    <br>
                    Скандал каких свет не видевал, критически низкий уровень настроения.
                    <br>
                    <br>
                    Сожалею, Вы проиграли:
                    <br>
                </h2>

                <form method="post">
                    <input type="text" name="username" value="${username}" hidden>
                    <input type="text" name="counter" value="${counter}" hidden>
                    <input type="submit" value="Попробуете ещё раз?">
                </form>

                <br>
                <form action="/index">
                    <input type="submit" value="Сменить пользователя">
                </form>
            </div>

            <div class="col-3">
                <img class="w-100" srcset="img\failure.jpg" alt="family">
            </div>
        </div>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
            crossorigin="anonymous">

    </script>
</div>

</body>
</html>
