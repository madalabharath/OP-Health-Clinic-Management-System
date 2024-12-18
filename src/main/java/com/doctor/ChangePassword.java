package com.doctor;

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
public class ChangePassword extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Mysql@123");

            String checkSql = "SELECT * FROM doctors WHERE id = ? AND password = ?";
            PreparedStatement checkPs = conn.prepareStatement(checkSql);
            checkPs.setString(1, id);
            checkPs.setString(2, oldPassword);
            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {
                String updateSql = "UPDATE doctors SET password = ? WHERE id = ?";
                PreparedStatement updatePs = conn.prepareStatement(updateSql);
                updatePs.setString(1, newPassword);
                updatePs.setString(2, id);
                int rowsAffected = updatePs.executeUpdate();

                if (rowsAffected > 0) {
                    out.println("<html><body><h2>Password updated successfully. <a href='doctorslogin.jsp'>Login here</a></h2></body></html>");
                } else {
                    out.println("<html><body><h2>Error updating password. Please try again.</h2></body></html>");
                }

                updatePs.close();
            } else {
                out.println("<html><body><h2>Invalid ID or old password.</h2></body></html>");
            }

            rs.close();
            checkPs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<html><body><h2>An error occurred. Please try again later.</h2></body></html>");
        }
    }
}
