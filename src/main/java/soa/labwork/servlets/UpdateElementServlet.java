package soa.labwork.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/update")
public class UpdateElementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "pwd");
            String execStatement = "UPDATE ORGANIZATION WHERE ID=" + req.getPathInfo();
            PreparedStatement statement = connection.prepareStatement(execStatement);
            statement.execute();
            connection.close();
        } catch (
                SQLException throwable) {
            throwable.printStackTrace();
        }
    }

}
