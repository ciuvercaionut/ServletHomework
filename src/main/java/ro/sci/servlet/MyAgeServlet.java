package ro.sci.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MyAgeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {
            LocalDate datoOfBirth = LocalDate.parse(req.getParameter("dateofbirth"));
            double daysLived = ChronoUnit.DAYS.between(datoOfBirth, LocalDate.now());
            resp.getWriter().println("You have lived " + daysLived + " days!");
            resp.getWriter().println("We wish you many more!");
        } catch (DateTimeException e) {
            resp.getWriter().println("Incorrect date");
        }

    }


}
