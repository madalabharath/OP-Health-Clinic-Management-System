package com.klef;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AppointmentServlet")
public class AppointmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("email") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String email = (String) session.getAttribute("email");

        List<Appointment> appointments = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Mysql@123")) {
            String sql = "SELECT doctor_name, appointment_date, appointment_time, status, appointment_id FROM appointments WHERE email = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, email);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Appointment appointment = new Appointment();
                        appointment.setDoctorName(resultSet.getString("doctor_name"));
                        appointment.setAppointmentDate(resultSet.getDate("appointment_date"));
                        appointment.setAppointmentTime(resultSet.getTime("appointment_time"));
                        appointment.setStatus(resultSet.getString("status"));
                        appointment.setAppointmentId(resultSet.getInt("appointment_id"));
                        appointments.add(appointment);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database error", e);
        }

        request.setAttribute("appointments", appointments);
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
}