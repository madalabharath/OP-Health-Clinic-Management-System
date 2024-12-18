package com.authorities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AuthDoctorAppointmentsServlet")
public class AuthDoctorAppointmentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String doctorName = request.getParameter("searchDoctor");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // CSS styling
        response.getWriter().println("<style>");
        response.getWriter().println("body { font-family: Arial, sans-serif; margin: 20px; padding: 0; background-color: #f4f4f4; color: #333; }");
        response.getWriter().println(".container { max-width: 800px; margin: 0 auto; padding: 20px; background-color: #fff; border-radius: 5px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
        response.getWriter().println("h2, h3 { color: #333; border-bottom: 2px solid #ddd; padding-bottom: 10px; }");
        response.getWriter().println("table { width: 100%; border-collapse: collapse; margin-bottom: 20px; }");
        response.getWriter().println("table, th, td { border: 1px solid #ddd; }");
        response.getWriter().println("th, td { padding: 10px; text-align: left; }");
        response.getWriter().println("th { background-color: #f2f2f2; }");
        response.getWriter().println("tr:nth-child(even) { background-color: #f9f9f9; }");
        response.getWriter().println("tr:hover { background-color: #f1f1f1; }");
        response.getWriter().println(".message { text-align: center; font-style: italic; }");
        response.getWriter().println("a { color: #4CAF50; text-decoration: none; }");
        response.getWriter().println("a:hover { text-decoration: underline; }");
        response.getWriter().println("</style>");

        if (doctorName == null || doctorName.trim().isEmpty()) {
            response.getWriter().println("<div class='container'>");
            response.getWriter().println("<p>Please provide a doctor name to search.</p>");
            response.getWriter().println("<p><a href='authRetrieveAppointments.jsp'>Go Back</a></p>");
            response.getWriter().println("</div>");
            return;
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Mysql@123")) {
            String sql = "SELECT appointment_id, email, doctor_name, appointment_date, appointment_time, status FROM appointments WHERE doctor_name = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, doctorName);
                try (ResultSet resultSet = statement.executeQuery()) {
                    response.getWriter().println("<div class='container'>");
                    if (resultSet.next()) {
                        response.getWriter().println("<p>Data retrieved successfully.</p>");
                        response.getWriter().println("<table>");
                        response.getWriter().println("<tr><th>ID</th><th>Email</th><th>Doctor</th><th>Date</th><th>Time</th><th>Status</th></tr>");
                        do {
                            int id = resultSet.getInt("appointment_id");
                            String email = resultSet.getString("email");
                            String doctor = resultSet.getString("doctor_name");
                            String date = resultSet.getString("appointment_date");
                            String time = resultSet.getString("appointment_time");
                            String status = resultSet.getString("status");

                            response.getWriter().println("<tr>");
                            response.getWriter().println("<td>" + id + "</td>");
                            response.getWriter().println("<td>" + email + "</td>");
                            response.getWriter().println("<td>" + doctor + "</td>");
                            response.getWriter().println("<td>" + date + "</td>");
                            response.getWriter().println("<td>" + time + "</td>");
                            response.getWriter().println("<td>" + status + "</td>");
                            response.getWriter().println("</tr>");
                        } while (resultSet.next());
                        response.getWriter().println("</table>");
                        response.getWriter().println("<p><a href='authoritieswelcome.jsp'>Go to Dashboard</a></p>");
                    } else {
                        response.getWriter().println("<p>No appointments found for the given doctor.</p>");
                        response.getWriter().println("<p><a href='authRetrieveAppointments.jsp'>Go Back</a></p>");
                    }
                    response.getWriter().println("</div>");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("<div class='container'>");
            response.getWriter().println("<p>Error: " + e.getMessage() + "</p>");
            response.getWriter().println("<p><a href='authRetrieveAppointments.jsp'>Go Back</a></p>");
            response.getWriter().println("</div>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}