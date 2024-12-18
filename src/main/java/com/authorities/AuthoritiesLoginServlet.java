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
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class AuthoritiesLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Mysql@123");

            PreparedStatement ps = con.prepareStatement("SELECT * FROM authorities WHERE username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("password");
                if (password.equals(storedPassword)) { // Compare plain text passwords
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    session.setAttribute("role", rs.getString("role"));
                    response.sendRedirect("authoritieswelcome.jsp");
                } else {
                    response.sendRedirect("authoritieslogin.jsp?error=invalid");
                }
            } else {
                response.sendRedirect("authoritieslogin.jsp?error=invalid");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
