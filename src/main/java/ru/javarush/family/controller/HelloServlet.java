package ru.javarush.family.controller;

import org.json.simple.parser.ParseException;
import ru.javarush.family.init.InitGameFamily;
import ru.javarush.family.entitie.Question;
import ru.javarush.family.entitie.Role;
import ru.javarush.family.entitie.User;

import java.io.*;
import java.util.Map;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {

    Map<Long, Question> questionMap;
    Map<String, User> userMap;

    @Override
    public void init() throws ServletException {
        InitGameFamily initGameFamily;
        try {
            initGameFamily = InitGameFamily.getInstance();
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        questionMap = initGameFamily.getQuestionMap();
        userMap = initGameFamily.getUsers();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        int counter = 0;
        if (userMap.containsKey(username)) {
            counter = userMap.get(username).getCountOfGamesPlayed();
        } else {
            userMap.put(username, new User(Role.PLAYER, counter));
        }

        request.setAttribute("counter", counter);
        request.setAttribute("username", username);
        request.setAttribute("nextQuestion", 1);
//        request.setAttribute("ip", ip);

        request.getRequestDispatcher("/begin.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String counter = request.getParameter("counter");
        String stringNextQuestion = request.getParameter("nextQuestion");
        Long nextQuestion = 0L;
        if (stringNextQuestion.equals("wrong")) {
            String whyFailure = request.getParameter("whyfailure");
            request.setAttribute("whyfailure", whyFailure);
            incrementCountOfGamesPlayer(username);
            request.getRequestDispatcher("/defeat.jsp").forward(request, response);
        } else if (stringNextQuestion.equals("win")) {
            incrementCountOfGamesPlayer(username);
            request.getRequestDispatcher("/win.jsp").forward(request, response);
        } else {
            nextQuestion = Long.parseLong(stringNextQuestion);
        }

        Question question = questionMap.get(nextQuestion);

        request.setAttribute("counter", counter);
        request.setAttribute("username", username);
        request.setAttribute("idNextQuestion", nextQuestion + 1);
        request.setAttribute("questionId", nextQuestion);
        request.setAttribute("question", question.getQuestion());
        request.setAttribute("answers", question.getAnswers());
        request.setAttribute("whyfailure", question.getWhyFailure());


        request.getRequestDispatcher("/game.jsp").forward(request, response);
    }

    private void incrementCountOfGamesPlayer(String username) {
        User user = userMap.get(username);
        user.setCountOfGamesPlayed(user.getCountOfGamesPlayed() + 1);
    }

    public void destroy() {
        //TODO Реализовать запись игроков в json
    }
}