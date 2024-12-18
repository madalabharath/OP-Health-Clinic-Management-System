package com.authorities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AuthChangePasswordServlet")
public class AuthChangePasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Mysql@123");

            // Check if the current username and password match
            String query = "SELECT * FROM authorities WHERE username = ? AND password = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, currentPassword);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Update the password
                query = "UPDATE authorities SET password = ? WHERE username = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, newPassword);
                preparedStatement.setString(2, username);
                int updated = preparedStatement.executeUpdate();

                if (updated > 0) {
                    response.getWriter().println("<html><body>");
                    response.getWriter().println("<h2>Password changed successfully.</h2>");
                    response.getWriter().println("<a href='index.jsp'>Go to Home</a>");
                    response.getWriter().println("</body></html>");
                } else {
                    response.getWriter().println("<html><body>");
                    response.getWriter().println("<h2>Failed to change password.</h2>");
                    response.getWriter().println("<a href='authochangepassword.jsp'>Try Again</a>");
                    response.getWriter().println("</body></html>");
                }
            } else {
                response.getWriter().println("<html><body>");
                response.getWriter().println("<h2>Invalid username or current password.</h2>");
                response.getWriter().println("<a href='authochangepassword.jsp'>Try Again</a>");
                response.getWriter().println("</body></html>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h2>An error occurred while changing the password.</h2>");
            response.getWriter().println("<a href='authochangepassword.jsp'>Try Again</a>");
            response.getWriter().println("</body></html>");
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
