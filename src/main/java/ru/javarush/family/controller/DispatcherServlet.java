package ru.javarush.family.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.javarush.family.entity.Question;
import ru.javarush.family.repository.Questions;
import ru.javarush.family.repository.Users;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DispatcherServlet", value = "/hello")
public class DispatcherServlet extends HttpServlet {

    private static final Logger log = LogManager.getLogger(DispatcherServlet.class);
    Users users;
    Questions questions;

    @Override
    public void init() throws ServletException {
        log.info("Start DispatcherServlet");
        users = new Users(DispatcherServlet.class.getClassLoader().getResourceAsStream("users.json"));
        log.info("creating Users");
        questions = new Questions(DispatcherServlet.class.getClassLoader().getResourceAsStream("questions.json"));
        log.info("creating Questions");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        int counter = 0;
        if (users.getNameUserToCharacteristic().containsKey(username)) {
            counter = users.getUser(username).getCountOfGamesPlayed();
            log.info("player {} back to the game. Count of games {}", username, counter);
        } else {
            users.update(username);
            log.info("new players: {} joined the game {}", username, this);
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
        request.setAttribute("question", question.getTextQuestion());
        request.setAttribute("answers", question.getAnswers());
        request.setAttribute("whyfailure", question.getWhyFailure());
        request.setAttribute("image", question.getPathToImage());

        request.getRequestDispatcher("/game.jsp").forward(request, response);
    }

    private Long nextStep(HttpServletRequest request, HttpServletResponse response, String username, String stringNextQuestion, Long nextQuestion) throws ServletException, IOException {
        if (stringNextQuestion.equals("wrong")) {
            String whyFailure = request.getParameter("whyfailure");
            request.setAttribute("whyfailure", whyFailure);
            users.incrementCountOfGamesPlayer(username);
            request.getRequestDispatcher("/defeat.jsp").forward(request, response);
            log.info("user: {} wrong game  {}", username, this);
        } else {
            nextQuestion = Long.parseLong(stringNextQuestion);
            log.info("user {} moved on to the next question {}", username, this);
        }

        if (nextQuestion == questions.getIdToQuestion().size()) {
            users.incrementCountOfGamesPlayer(username);
            request.getRequestDispatcher("/win.jsp").forward(request, response);
            log.info("player: {} win game {}", username, this);
        }

        return nextQuestion;
    }

    @Override
    public String toString() {
        return "DispatcherServlet{" +
                "users=" + users.getCountUsers() + "}";
    }
}
