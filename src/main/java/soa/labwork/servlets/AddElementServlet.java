package soa.labwork.servlets;

import soa.labwork.entities.Organization;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add")
public class AddElementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/xml");
        PrintWriter printWriter = resp.getWriter();
        //printWriter.write(Organization.toString());
        printWriter.write("<a id=\"a\"><b id=\"b\">hey!</b></a>");
        printWriter.close();
    }
}
