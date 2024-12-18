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

@WebServlet("/AuthRegisterPatientServlet")
public class AuthRegisterPatientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob"); // Ensure this is in 'YYYY-MM-DD' format
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Updated driver class name for MySQL Connector/J 8.x
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Mysql@123");
            String sql = "INSERT INTO patients (first_name, last_name, gender, dob, email, phone, address, city, state, zip) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, gender);
            statement.setString(4, dob); // Ensure the date format matches 'DATE' type
            statement.setString(5, email);
            statement.setString(6, phone);
            statement.setString(7, address);
            statement.setString(8, city);
            statement.setString(9, state);
            statement.setString(10, zip);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                response.setContentType("text/html");
                response.getWriter().println("<p>Patient added successfully!</p>");
                response.getWriter().println("<p><a href='authoritieswelcome.jsp'>Go to Dashboard</a></p>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<p>Error: " + e.getMessage() + "</p>");
            response.getWriter().println("<p><a href='Authaddpatient.jsp'>Go Back</a></p>"); // Assuming 'form.jsp' is where the form is
        }
    }
}
