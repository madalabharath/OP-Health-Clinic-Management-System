package com.klef;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signupServlet")
public class signupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Mysql@123");

            String sql = "INSERT INTO patientlist (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);

            int result = ps.executeUpdate();
            PrintWriter out = response.getWriter();
            if (result > 0) {
                out.println("<!DOCTYPE html>");
                out.println("<html><head>");
                out.println("<meta charset='UTF-8'>");
                out.println("<title>Signup Successful</title>");
                out.println("<style>");
                out.println("body {");
                out.println("  font-family: 'Roboto', sans-serif;");
                out.println("  display: flex;");
                out.println("  justify-content: center;");
                out.println("  align-items: center;");
                out.println("  height: 100vh;");
                out.println("  margin: 0;");
                out.println("  background: #f0f4f7;");
                out.println("  overflow: hidden;");
                out.println("  position: relative;");
                out.println("}");
                out.println(".signup-container {");
                out.println("  background-color: #fff;");
                out.println("  padding: 40px;");
                out.println("  border-radius: 10px;");
                out.println("  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);");
                out.println("  max-width: 400px;");
                out.println("  width: 100%;");
                out.println("  text-align: center;");
                out.println("  z-index: 10;");
                out.println("  position: relative;");
                out.println("}");
                out.println(".signup-container h2 {");
                out.println("  margin-bottom: 30px;");
                out.println("  color: #00796b;");
                out.println("  font-size: 24px;");
                out.println("}");
                out.println(".signup-container a {");
                out.println("  color: #00796b;");
                out.println("  text-decoration: none;");
                out.println("}");
                out.println(".signup-container a:hover {");
                out.println("  text-decoration: underline;");
                out.println("}");
                out.println("</style>");
                out.println("</head><body>");
                out.println("<div class='signup-container'>");
                out.println("<h2>Signup successful.</h2>");
                out.println("<a href='patientlogin.jsp'>Login here</a>");
                out.println("</div>");
                out.println("</body></html>");
            } else {
                out.println("<!DOCTYPE html>");
                out.println("<html><head>");
                out.println("<meta charset='UTF-8'>");
                out.println("<title>Signup Failed</title>");
                out.println("<style>");
                out.println("body {");
                out.println("  font-family: 'Roboto', sans-serif;");
                out.println("  display: flex;");
                out.println("  justify-content: center;");
                out.println("  align-items: center;");
                out.println("  height: 100vh;");
                out.println("  margin: 0;");
                out.println("  background: #f0f4f7;");
                out.println("  overflow: hidden;");
                out.println("  position: relative;");
                out.println("}");
                out.println(".signup-container {");
                out.println("  background-color: #fff;");
                out.println("  padding: 40px;");
                out.println("  border-radius: 10px;");
                out.println("  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);");
                out.println("  max-width: 400px;");
                out.println("  width: 100%;");
                out.println("  text-align: center;");
                out.println("  z-index: 10;");
                out.println("  position: relative;");
                out.println("}");
                out.println(".signup-container h2 {");
                out.println("  margin-bottom: 30px;");
                out.println("  color: #d32f2f;");
                out.println("  font-size: 24px;");
                out.println("}");
                out.println("</style>");
                out.println("</head><body>");
                out.println("<div class='signup-container'>");
                out.println("<h2>Signup failed. Please try again.</h2>");
                out.println("</div>");
                out.println("</body></html>");
            }

            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
