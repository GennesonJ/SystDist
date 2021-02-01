package com.example.Proj1;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        /*
        response.setContentType("text/html");

        // Hello

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");


        // Ajout par rapport au cours
        response.setContentType("text/html"); // ou response.setContentType("txt.html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.print("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Provient du out.print du servlet</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "Provient du out.print du servlet\n" +
                "</body>\n" +
                "</html>");
         */

        String mes = "Variable transmise par la Servlet avec la méthode GET";
        request.setAttribute("mes",mes);

        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response); // Renvoi direct la JSP




    }

    public void destroy() {
    }
}