package com.authorities;

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

@WebServlet("/AuthDeleteAppointmentServlet")
public class AuthDeleteAppointmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int appointmentId = Integer.parseInt(request.getParameter("appointmentId"));

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Mysql@123")) {
            String sql = "DELETE FROM appointments WHERE appointment_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, appointmentId);
                int rowsDeleted = statement.executeUpdate();

                if (rowsDeleted > 0) {
                    request.setAttribute("message", "Appointment deleted successfully.");
                } else {
                    request.setAttribute("message", "Appointment not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database error", e);
        }

        request.getRequestDispatcher("authDeleteAppointment.jsp").forward(request, response);
    }
}