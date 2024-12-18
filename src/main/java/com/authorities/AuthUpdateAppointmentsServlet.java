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

@WebServlet("/AuthUpdateAppointmentsServlet")
public class AuthUpdateAppointmentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String doctorName = request.getParameter("searchDoctor");

        if (doctorName == null || doctorName.trim().isEmpty()) {
            request.setAttribute("appointments", null);
            request.getRequestDispatcher("authUpdateAppointments.jsp").forward(request, response);
            return;
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Mysql@123")) {
            String sql = "SELECT appointment_id, email, doctor_name, appointment_date, appointment_time, status FROM appointments WHERE doctor_name = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, doctorName);
                try (ResultSet resultSet = statement.executeQuery()) {
                    request.setAttribute("appointments", resultSet);
                    request.getRequestDispatcher("authUpdateAppointments.jsp").forward(request, response);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database error", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int appointmentId = Integer.parseInt(request.getParameter("appointmentId"));
        String newStatus = request.getParameter("status");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Mysql@123")) {
            String sql = "UPDATE appointments SET status = ? WHERE appointment_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, newStatus);
                statement.setInt(2, appointmentId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database error", e);
        }

        // Redirect to the same servlet to refresh the appointments list
        response.sendRedirect("AuthUpdateAppointmentsServlet?searchDoctor=" + request.getParameter("searchDoctor"));
    }
}