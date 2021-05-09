package com.example.lab_13;

import java.io.*;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/")
public class HelloServlet extends HttpServlet {
    List<Quiz> quizzes;
    private int numberOfQuestion;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        quizzes=Provider.getQuize();
        numberOfQuestion=quizzes.size();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session=request.getSession();
        session.setAttribute("number",0);
        session.setAttribute("score",0);

        request.setAttribute("question",quizzes.get(0).getQuestion());

        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();

        int number=(int)session.getAttribute("number");
        System.out.println(number);


        if(quizzes.get(number).isAnswer((String)request.getParameter("answer"))) {
            session.setAttribute("score",(int)session.getAttribute("score")+1);
        }
        session.setAttribute("number",++number);
        if(number<numberOfQuestion) {
            request.setAttribute("question",quizzes.get(number).getQuestion());
            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);
        }
        else{
            request.setAttribute("length",quizzes.size());
            request.getRequestDispatcher("WEB-INF/last.jsp").forward(request,response);
        }
    }

    public void destroy() {
    }
}
