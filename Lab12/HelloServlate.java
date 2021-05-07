import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/index.html")
public class HelloServlet extends HttpServlet {
    List<Quiz> quizzes;
    private int numberOfQuestion;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        quizzes=Provider.getQuize();
        numberOfQuestion=quizzes.size();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        HttpSession session=req.getSession();
        session.setAttribute("number",1);
        session.setAttribute("score",0);


        out.println("<html><head><title>Lab 11</title></head>");
        out.println("<body>");

        out.println("<h1>*The Number Quiz</h1>" +
                "  <p>Your current score is 0" +
                "  </p>");

            out.println("  <p>Guss the number in the sequence</p>" +
                    "  <p>" +
                    quizzes.get(0).getQuestion() +
                    "  </p>" +
                    "  <form action=\"index.html\" method=\"Post\">" +
                    "    <lable> Your answer:" +
                    "      <input type=\"text\" name=\"answer\" size=\"2\">" +
                    "    </lable>" +
                    "    <br><br>" +
                    "    <input type=\"submit\">" +
                    "  </form>");


                    out.print("");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        int current=(int)session.getAttribute("number");
        session.setAttribute("number",current+1);
        String prvAnswer=req.getParameter("answer")!=null? (String) req.getParameter("answer") :"";


        System.out.println(current);
        System.out.println(prvAnswer);
        System.out.println(req.getAttribute("answer"));

        String previousAnswer = req.getParameter("answer");

        if (previousAnswer.equals(quizzes.get(current-1).getAnswer() + ""))
            session.setAttribute("score",  (int) session.getAttribute("score") + 1);


        int score=(int)session.getAttribute("score");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Lab 11</title></head>");
        out.println("<body>");
        out.println("<h1>The Number Quiz</h1>" +
                "  <p>Your current score is " +
                score+
                "  </p>");
        if(current>=numberOfQuestion) {
            out.println("<p>You have completed the Number Quize, with a score of " +
                    score +
                    " out of " +
                    numberOfQuestion +
                    "  </p>" +
                    "  <a href=\"index.html\">Take the quize agian? </a>");
        }else {
            out.println("  <p>Guss the number in the sequence</p>" +
                    "  <p>" +
                    quizzes.get(current).getQuestion() +
                    "  </p>" +
                    "  <form action=\"index.html\" method=\"Post\">" +
                    "    <lable> Your answer:" +
                    "      <input type=\"text\" name=\"answer\" size=\"2\">" +
                    "    </lable>" +
                    "    <br><br>" +
                    "    <input type=\"submit\">" +
                    "  </form>");
        }

        out.print("");
    }





}
