import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/index.html")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Lab 11</title></head>");
        out.println("<body><h1>Simple Calculator Lab</h1>" +
                "<form action=\"/firstdemo_war_exploded/index.html\" method=\"Post\">\n" +
                "<input type=\"text\" name=\"add1\"> + \n" +
                "<input type=\"text\" name=\"add2\">\n" +
                " = <input type=\"text\" name=\"sum\">\n" +
                "<br>\n" +
                "<input type=\"text\" name=\"prod1\"> X\n" +
                "<input type=\"text\" name=\"prod2\">\n" +
                " = <input type=\"text\" name=\"product\">\n" +
                "<br>\n" +
                "<input type=\"submit\">\n" +
                "</form>" +
                "</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String line1= sum(req.getParameter("add1"),req.getParameter("add2"));
        String line2= product(req.getParameter("prod1"),req.getParameter("prod2"));

        out.println("<html><head><title>Lab 11</title></head>"+
                "<body><h1>Simple Calculator Lab</h1>" +   "<form action=\"/firstdemo_war_exploded/index.html\" method=\"Post\">\n" +
                line1 +
                "<br>\n" +
                line2+
                "<br>\n" +
                "<input type=\"submit\">\n" +
                "</form>" +
                "</body></html>");
    }


    private static String sum(String num1,String num2){
        String s="<input type=\"text\" name=\"add1\" value=\" m\"> + \n" +
                "<input type=\"text\" name=\"add2\" value=\"\">\n" +
                "=<input type=\"text\" name=\"sum\" value=\"\">\n" ;
        try {
            s="<input type=\"text\" name=\"add1\" value=\""+toNumber(num1)+"\"> + \n" +
                    "<input type=\"text\" name=\"add2\" value=\""+toNumber(num2)+"\">\n" +
                    " = <input type=\"text\" name=\"sum\" value=\""+(toNumber(num1)+toNumber(num2))+"\">\n";

        } catch (NumberFormatException e) {

        }
        return s;
    }

    private static String product(String num1,String num2){
        String p="<input type=\"text\" name=\"prod1\" value=\" m\"> + \n" +
                "<input type=\"text\" name=\"prod2\" value=\"\">\n" +
                "=<input type=\"text\" name=\"product\" value=\"\">\n" ;
        try {
            p = "<input type=\"text\" name=\"prod1\" value=\"" + toNumber(num1) + "\"> * \n" +
                    "<input type=\"text\" name=\"prod2\" value=\"" + toNumber(num2) + "\">\n" +
                    " = <input type=\"text\" name=\"product\" value=\"" + (toNumber(num1) * toNumber(num2)) + "\">\n";
        }catch (NumberFormatException e) {

        }
        return p;
    }

    private static float toNumber(String s) throws NumberFormatException{
        try {
            float f=Float.parseFloat(s.trim());
            return f;
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }
}
