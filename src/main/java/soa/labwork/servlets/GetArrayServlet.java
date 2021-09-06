package soa.labwork.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/organizations")
public class GetArrayServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "pwd");
            String execStatement = "SELECT * FROM ORGANIZATION";
            PreparedStatement statement = connection.prepareStatement(execStatement);
            statement.execute();
            ResultSet rs = statement.getResultSet();
            StringBuilder jsonStr = new StringBuilder("[");

            while (!rs.isLast()) {
                jsonStr.append("{");
                jsonStr.append("\"id\":\"").append(String.valueOf(rs.getLong("id"))).append("\",");
                jsonStr.append("\"name\":\"").append(rs.getString("name")).append("\",");
                jsonStr.append("\"coordinatex\":\"").append(String.valueOf(rs.getFloat("coordinatex"))).append("\",");
                jsonStr.append("\"coordinatey\":\"").append(String.valueOf(rs.getLong("coordinatey"))).append("\",");
                jsonStr.append("\"creationdate\":\"").append(String.valueOf(rs.getDate("creationdate"))).append("\",");
                jsonStr.append("\"annualturnover\":\"").append(String.valueOf(rs.getFloat("annualturnover"))).append("\",");
                jsonStr.append("\"organizationtype\":\"").append(rs.getString("organizationtype")).append("\",");
                jsonStr.append("\"street\":\"").append(rs.getString("street")).append("\",");
                jsonStr.append("\"town\":\"").append(rs.getString("town")).append("\"");
                jsonStr.append("},");
                rs.next();
            }
            jsonStr.append("{");
            jsonStr.append("\"id\":\"").append(String.valueOf(rs.getLong("id"))).append("\",");
            jsonStr.append("\"name\":\"").append(rs.getString("name")).append("\",");
            jsonStr.append("\"coordinatex\":\"").append(String.valueOf(rs.getFloat("coordinatex"))).append("\",");
            jsonStr.append("\"coordinatey\":\"").append(String.valueOf(rs.getLong("coordinatey"))).append("\",");
            jsonStr.append("\"creationdate\":\"").append(String.valueOf(rs.getDate("creationdate"))).append("\",");
            jsonStr.append("\"annualturnover\":\"").append(String.valueOf(rs.getFloat("annualturnover"))).append("\",");
            jsonStr.append("\"organizationtype\":\"").append(rs.getString("organizationtype")).append("\",");
            jsonStr.append("\"street\":\"").append(rs.getString("street")).append("\",");
            jsonStr.append("\"town\":\"").append(rs.getString("town")).append("\"");
            jsonStr.append("}]");
            connection.close();

            resp.setContentType("application/json");
            PrintWriter printWriter = resp.getWriter();
            printWriter.write(String.valueOf(jsonStr));
            printWriter.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


}
