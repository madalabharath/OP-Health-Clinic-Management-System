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

@WebServlet("/AuthDeletePatientByEmailServlet")
public class AuthDeletePatientByEmailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");

        response.setContentType("text/html");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Mysql@123");

            // Delete patient record
            String deleteSql = "DELETE FROM patients WHERE email = ?";
            PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
            deleteStmt.setString(1, email);

            int rowsDeleted = deleteStmt.executeUpdate();
            response.getWriter().println("<html><body>");
            if (rowsDeleted > 0) {
                response.getWriter().println("<p>Patient record deleted successfully!</p>");
            } else {
                response.getWriter().println("<p>No patient found with the provided email.</p>");
            }
            response.getWriter().println("<p><a href='authoritieswelcome.jsp'>Go to Dashboard</a></p>");
            response.getWriter().println("</body></html>");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<p>Error: " + e.getMessage() + "</p>");
        }
    }
}
