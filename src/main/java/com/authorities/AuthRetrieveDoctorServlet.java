package com.authorities;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AuthRetrieveDoctorServlet")
public class AuthRetrieveDoctorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Mysql@123");
            String sql = "SELECT * FROM doctordetails WHERE email = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Doctor Details</title>");
            out.println("<style>");
            out.println("body {");
            out.println("    font-family: Arial, sans-serif;");
            out.println("    margin: 0;");
            out.println("    padding: 0;");
            out.println("    background-color: #f4f4f4;");
            out.println("}");
            out.println(".container {");
            out.println("    max-width: 800px;");
            out.println("    margin: 20px auto;");
            out.println("    padding: 20px;");
            out.println("    background: #fff;");
            out.println("    border-radius: 8px;");
            out.println("    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);");
            out.println("}");
            out.println("h1 {");
            out.println("    color: #333;");
            out.println("    text-align: center;");
            out.println("    margin-bottom: 20px;");
            out.println("}");
            out.println("p {");
            out.println("    font-size: 16px;");
            out.println("    line-height: 1.6;");
            out.println("    margin: 10px 0;");
            out.println("}");
            out.println("a {");
            out.println("    color: #4CAF50;");
            out.println("    text-decoration: none;");
            out.println("    font-weight: bold;");
            out.println("}");
            out.println("a:hover {");
            out.println("    text-decoration: underline;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");

            if (resultSet.next()) {
                out.println("<h1>Doctor Details</h1>");
                out.println("<p><strong>First Name:</strong> " + resultSet.getString("first_name") + "</p>");
                out.println("<p><strong>Last Name:</strong> " + resultSet.getString("last_name") + "</p>");
                out.println("<p><strong>Gender:</strong> " + resultSet.getString("gender") + "</p>");
                out.println("<p><strong>Age:</strong> " + resultSet.getInt("age") + "</p>");
                out.println("<p><strong>Specialization:</strong> " + resultSet.getString("specialization") + "</p>");
                out.println("<p><strong>Salary:</strong> " + resultSet.getBigDecimal("salary") + "</p>");
                out.println("<p><strong>Phone:</strong> " + resultSet.getString("phone") + "</p>");
                out.println("<p><strong>Email:</strong> " + resultSet.getString("email") + "</p>");
            } else {
                out.println("<p>No doctor found with the provided email.</p>");
            }

            out.println("<p><a href='authoritieswelcome.jsp'>Go to Dashboard</a></p>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<p>Error: " + e.getMessage() + "</p>");
        }
    }
}
