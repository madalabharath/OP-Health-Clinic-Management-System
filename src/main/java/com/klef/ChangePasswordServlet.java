package com.klef;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/changePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Connection conn = null;
        PreparedStatement checkPs = null;
        PreparedStatement updatePs = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Mysql@123");

            // Check if the email and old password match
            String checkSql = "SELECT password FROM patientlist WHERE email = ?";
            checkPs = conn.prepareStatement(checkSql);
            checkPs.setString(1, email);
            rs = checkPs.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("password");

                // Replace with hashed password verification
                if (storedPassword.equals(oldPassword)) {
                    // Old password is correct, update with the new password
                    String updateSql = "UPDATE patientlist SET password = ? WHERE email = ?";
                    updatePs = conn.prepareStatement(updateSql);
                    updatePs.setString(1, newPassword); // Hash the new password before storing
                    updatePs.setString(2, email);
                    int rowsAffected = updatePs.executeUpdate();

                    if (rowsAffected > 0) {
                        out.println("<html><body><h2>Password updated successfully. <a href='patientlogin.jsp'>Login here</a></h2></body></html>");
                    } else {
                        out.println("<html><body><h2>Error updating password. Please try again.</h2></body></html>");
                    }
                } else {
                    out.println("<html><body><h2>Invalid email or old password.</h2></body></html>");
                }
            } else {
                out.println("<html><body><h2>Invalid email or old password.</h2></body></html>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<html><body><h2>An error occurred. Please try again later.</h2></body></html>");
        } finally {
            try {
                if (rs != null) rs.close();
                if (checkPs != null) checkPs.close();
                if (updatePs != null) updatePs.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
