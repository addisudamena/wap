
package controller;

import app.Guest;
import com.google.gson.Gson;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


/**
 *
 * @author levi
 */
@WebServlet(name = "guestServlet", urlPatterns = {"*.ajax"})
public class GuestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("guests.jsp");
        view.forward(request, response);;

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        /* retrieve or create session here as needed */
        HttpSession sess = request.getSession();
        List<Guest> guestList = (List<Guest>) sess.getAttribute("guestList");
        if (guestList == null) {
            guestList = new ArrayList<Guest>();
            sess = request.getSession();
            sess.setAttribute("guestList", guestList);
        }

        /* get  input */
        String firstInput = request.getParameter("first");
        String lastInput = request.getParameter("last");
        guestList.add(new Guest(firstInput, lastInput));
        
        String JSONguests;
        JSONguests = new Gson().toJson(guestList);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.write(JSONguests);        
    }



}
