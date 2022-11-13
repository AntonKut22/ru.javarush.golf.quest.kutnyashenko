package ru.javarush.family.controller;

import ru.javarush.family.entitie.Question;
import ru.javarush.family.repository.Questions;
import ru.javarush.family.repository.Users;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet", value = "/hello")
public class DispatcherServlet extends HttpServlet {

    Users users;
    Questions questions;

    @Override
    public void init() throws ServletException {
        File fileUser = new File("D:\\Обучение\\JRU\\ru.familyQuest\\family\\src\\main\\resources\\users.json");
        File fileQuestion = new File("D:\\Обучение\\JRU\\ru.familyQuest\\family\\src\\main\\resources\\questions.json");
        users = new Users(fileUser);
        questions = new Questions(fileQuestion);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        int counter = 0;
        if (users.getUserMap().containsKey(username)) {
            counter = users.getUser(username).getCountOfGamesPlayed();
        } else {
            users.update(username);
        }

        request.setAttribute("counter", counter);
        request.setAttribute("username", username);
        request.setAttribute("nextQuestion", 1);

        request.getRequestDispatcher("/begin.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String counter = request.getParameter("counter");
        String stringNextQuestion = request.getParameter("nextQuestion");
        Long nextQuestion = 0L;

        nextQuestion = nextStep(request, response, username, stringNextQuestion, nextQuestion);


        Question question = questions.getQuestion(nextQuestion);

        request.setAttribute("counter", counter);
        request.setAttribute("username", username);
        request.setAttribute("idNextQuestion", nextQuestion + 1);
        request.setAttribute("questionId", nextQuestion);
        request.setAttribute("question", question.getQuestion());
        request.setAttribute("answers", question.getAnswers());
        request.setAttribute("whyfailure", question.getWhyFailure());

        request.getRequestDispatcher("/game.jsp").forward(request, response);
    }

    private Long nextStep(HttpServletRequest request, HttpServletResponse response, String username, String stringNextQuestion, Long nextQuestion) throws ServletException, IOException {
        if (stringNextQuestion.equals("wrong")) {
            String whyFailure = request.getParameter("whyfailure");
            request.setAttribute("whyfailure", whyFailure);
            users.incrementCountOfGamesPlayer(username);
            request.getRequestDispatcher("/defeat.jsp").forward(request, response);
        } else {
            nextQuestion = Long.parseLong(stringNextQuestion);
        }

        if (nextQuestion == questions.getQuestionsMap().size()) {
            users.incrementCountOfGamesPlayer(username);
            request.getRequestDispatcher("/win.jsp").forward(request, response);
        }
        return nextQuestion;
    }


    public void destroy() {
        //TODO Реализовать запись игроков в json
    }
}