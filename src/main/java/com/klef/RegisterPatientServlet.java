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
import javax.servlet.http.HttpSession;

@WebServlet("/registerPatientServlet")
public class RegisterPatientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String emailFromSession = (String) session.getAttribute("email");
        
        if (emailFromSession == null) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body><h2>You must be logged in to register as a patient.</h2></body></html>");
            return;
        }
        
        String email = request.getParameter("email");
        if (!email.equals(emailFromSession)) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body><h2>Invalid email. Please use the email with which you logged in.</h2></body></html>");
            return;
        }
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Mysql@123");

            // Check if the email already exists
            String checkEmailSql = "SELECT * FROM patients WHERE email = ?";
            PreparedStatement checkEmailPs = conn.prepareStatement(checkEmailSql);
            checkEmailPs.setString(1, email);
            if (checkEmailPs.executeQuery().next()) {
                out.println("<html><body><h2>Email already exists.</h2></body></html>");
                checkEmailPs.close();
                conn.close();
                return;
            }
            checkEmailPs.close();

            // Insert the new patient record
            String sql = "INSERT INTO patients (first_name, last_name, gender, dob, email, phone, address, city, state, zip) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, gender);
            ps.setString(4, dob);
            ps.setString(5, email);
            ps.setString(6, phone);
            ps.setString(7, address);
            ps.setString(8, city);
            ps.setString(9, state);
            ps.setString(10, zip);

            int result = ps.executeUpdate();

            if (result > 0) {
                out.println("<html><body><h2>Registration successful. <a href='patienthome.jsp'>Go to Home Page</a></h2></body></html>");
            } else {
                out.println("<html><body><h2>Registration failed. Please try again.</h2></body></html>");
            }

            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<html><body><h2>An error occurred. Please try again later.</h2></body></html>");
        }
    }
}
