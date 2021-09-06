package soa.labwork.servlets;

import soa.labwork.entities.Organization;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/add/*")
public class AddElementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String querystring = req.getQueryString();
        //Map<String, String[]> params = req.getParameterMap();
        System.out.println(querystring);
        System.out.println(req.getPathInfo());
        //System.out.println(params.get("name")[0]);
        //System.out.println(params.get("coordinatex")[0]);
        //System.out.println(params.get("coordinatey")[0]);


        resp.setContentType("application/xml");
        PrintWriter printWriter = resp.getWriter();
        //printWriter.write(Organization.toString());
        //printWriter.write("<a id=\"a\"><b id=\"b\">hey!</b></a>");
        printWriter.write("<data><id>1</id><content>Hello, World!</content></data>");
        //printWriter.write("{\"id\":1,\"content\":\"Hello, World!\"}");
        printWriter.close();
        //RequestDispatcher disp = getServletContext().getRequestDispatcher(req.get);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
