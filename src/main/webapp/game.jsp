<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>game</title>
</head>
<body>
<h3>

    ${question}
    <br>
    Что выберем?
</h3>
<br>

<h2>
    <form>
        <input type="hidden" name="username" value="${username}" hidden>
        <input type="hidden" name="counter" value="${counter}" hidden>

        <c:forEach var="answersList" items="${answers}">
            <c:if test="${answersList.fidelityAnswer}">
                <input type="radio" name="nextQuestion" value="${idNextQuestion}"> ${answersList.answer}
                <br>
                <%--                    <input type="text" name="fidelityAnswer" value="${fidelityAnswer}" hidden>--%>
            </c:if>


            <c:if test="${!answersList.fidelityAnswer}">
                <input type="hidden" name="whyfailure" value="${whyfailure}">
                <input type="radio" name="nextQuestion" value="wrong"> ${answersList.answer}
                <br>
            </c:if>
        </c:forEach>

        <input type="submit" value="ответить">
    </form>

</h2>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
