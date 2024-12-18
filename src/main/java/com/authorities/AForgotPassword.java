package com.authorities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ForgotPasswordServlet")
public class AForgotPassword extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String newPassword = request.getParameter("newPassword");

        String jdbcURL = "jdbc:mysql://localhost:3306/db";
        String dbUser = "root";
        String dbPassword = "Mysql@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            String sql = "UPDATE authorities SET password = ? WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newPassword);
            statement.setString(2, username);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                response.getWriter().println("<html><head><style>");
                response.getWriter().println("body, html { margin: 0; padding: 0; height: 100%; display: flex; align-items: center; justify-content: center; }");
                response.getWriter().println("@keyframes float { 0% { transform: translateY(0); } 50% { transform: translateY(-10px); } 100% { transform: translateY(0); } }");
                response.getWriter().println(".frame { border: 2px solid lightgreen; padding: 20px; width: 50%; max-width: 600px; text-align: center; background-color: #f0fff0; ");
                response.getWriter().println("box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); animation: float 2s infinite; border-radius: 10px; }");
                response.getWriter().println("h2 { color: #006400; }");
                response.getWriter().println("a { display: inline-block; margin-top: 20px; text-decoration: none; color: lightgreen; font-size: 16px; font-weight: bold; }");
                response.getWriter().println("</style></head><body>");
                response.getWriter().println("<div class='frame'><h2>Password successfully updated.</h2>");
                response.getWriter().println("<a href='authoritieslogin.jsp'>Login</a></div>");
                response.getWriter().println("</body></html>");
            } else {
                response.getWriter().println("<html><head><style>");
                response.getWriter().println("body, html { margin: 0; padding: 0; height: 100%; display: flex; align-items: center; justify-content: center; }");
                response.getWriter().println(".frame { border: 2px solid red; padding: 20px; width: 50%; max-width: 600px; text-align: center; background-color: #fff0f0; ");
                response.getWriter().println("box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); border-radius: 10px; }");
                response.getWriter().println("h2 { color: #800000; }");
                response.getWriter().println("</style></head><body>");
                response.getWriter().println("<div class='frame'><h2>Invalid Username.</h2></div>");
                response.getWriter().println("</body></html>");
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("An error occurred while updating the password.");
        }
    }
}
