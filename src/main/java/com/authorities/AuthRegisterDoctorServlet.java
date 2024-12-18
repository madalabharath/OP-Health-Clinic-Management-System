package com.authorities;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AuthRegisterDoctorServlet")
public class AuthRegisterDoctorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String specialization = request.getParameter("specialization");
        String salary = request.getParameter("salary");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Mysql@123");
            String sql = "INSERT INTO doctordetails (first_name, last_name, gender, age, specialization, salary, phone, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, gender);
            statement.setInt(4, Integer.parseInt(age));
            statement.setString(5, specialization);
            statement.setBigDecimal(6, new BigDecimal(salary));
            statement.setString(7, phone);
            statement.setString(8, email);

            int rowsInserted = statement.executeUpdate();
            response.setContentType("text/html");
            if (rowsInserted > 0) {
                response.getWriter().println("<p>Doctor added successfully!</p>");
                response.getWriter().println("<p><a href='authoritieswelcome.jsp'>Go to Dashboard</a></p>");
            } else {
                response.getWriter().println("<p>Failed to add doctor.</p>");
                response.getWriter().println("<p><a href='authAddDoctor.jsp'>Go Back</a></p>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<p>Error: " + e.getMessage() + "</p>");
            response.getWriter().println("<p><a href='authAddDoctor.jsp'>Go Back</a></p>");
        }
    }
}
