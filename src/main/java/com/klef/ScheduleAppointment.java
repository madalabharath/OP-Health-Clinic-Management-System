package com.klef;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ScheduleAppointmentServlet")
public class ScheduleAppointment extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("email") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String email = (String) session.getAttribute("email");
        String doctor = request.getParameter("doctor");
        String appointmentDate = request.getParameter("appointmentDate");
        String appointmentTime = request.getParameter("appointmentTime");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Mysql@123")) {
            String sql = "INSERT INTO appointments (email, doctor_name, appointment_date, appointment_time, status) VALUES (?, ?, ?, ?, 'Pending')";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, email);
                statement.setString(2, doctor);
                statement.setString(3, appointmentDate);
                statement.setString(4, appointmentTime);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database error", e);
        }

        // Redirect to AppointmentServlet to fetch updated data and then forward to welcome.jsp
        response.sendRedirect("AppointmentServlet");
    }
}