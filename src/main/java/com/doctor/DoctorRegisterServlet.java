package com.doctor;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DoctorRegisterServlet")
public class DoctorRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String specialization = request.getParameter("specialization");
        String salary = request.getParameter("salary");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String jdbcURL = "jdbc:mysql://localhost:3306/db";
        String dbUser = "root";
        String dbPassword = "Mysql@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            String sql = "INSERT INTO doctordetails (first_name, last_name, gender, age, specialization, salary, phone, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, gender);
            statement.setInt(4, Integer.parseInt(age));
            statement.setString(5, specialization);
            statement.setBigDecimal(6, new BigDecimal(salary));
            statement.setString(7, phone);
            statement.setString(8, email);

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                out.println("<html><body><h2>Doctor registered successfully!</h2>");
                out.println("<a href='doctorwelcome.jsp'>Go to Doctor Welcome Page</a></body></html>");
            } else {
                out.println("<html><body><h2>Error occurred while registering doctor.</h2>");
                out.println("<a href='doctorregister.jsp'>Go Back to Registration</a></body></html>");
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<html><body><h2>Error occurred: " + e.getMessage() + "</h2>");
            out.println("<a href='doctorregister.jsp'>Go Back to Registration</a></body></html>");
        }
    }
}
