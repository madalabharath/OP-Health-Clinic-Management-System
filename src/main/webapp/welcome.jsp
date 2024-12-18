<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.klef.Appointment" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }
        .container {
            max-width: 800px;
            margin: 40px auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ddd;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .header {
            background-color: #c6efce;
            padding: 10px;
            text-align: center;
            font-size: 24px;
            font-weight: bold;
            color: #333;
        }
        .section {
            margin-bottom: 20px;
        }
        .section-header {
            background-color: #c6efce;
            padding: 10px;
            text-align: left;
            font-size: 18px;
            font-weight: bold;
            color: #333;
        }
        .form-control {
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .btn {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #45a049;
        }
        .table {
            border-collapse: collapse;
            width: 100%;
        }
        .table th, .table td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }
        .table th {
            background-color: #c6efce;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h2>Welcome!</h2>
        </div>
        <% 
            String email = (String) session.getAttribute("email");
            if (email == null) {
                response.sendRedirect("login.jsp");
            } else {
        %>
            Logged in as: <%= email %>
        <% } %>

        <div class="section">
            <div class="section-header">
                <h2>Appointment Scheduling</h2>
            </div>
            <form action="ScheduleAppointment" method="post">
                <label for="doctor">Select a Doctor:</label>
                <select id="doctor" name="doctor" class="form-control">
                    <option value="">Select a Doctor</option>
                    <option value="Dr. John Smith">Dr. John Smith</option>
                    <option value="Dr. Jane Doe">Dr. Jane Doe</option>
                    <option value="Dr. Bob Johnson">Dr. Bob Johnson</option>
                </select>
                <br><br>
                <label for="appointmentDate">Appointment Date:</label>
                <input type="date" id="appointmentDate" name="appointmentDate" class="form-control">
                <br><br>
                <label for="appointmentTime">Appointment Time:</label>
                <input type="time" id="appointmentTime" name="appointmentTime" class="form-control">
                <br><br>
                <input type="submit" value="Schedule Appointment" class="btn">
            </form>
        </div>

        <div class="section">
            <div class="section-header">
                <h2>Upcoming Appointments</h2>
            </div>
            <table class="table">
                <tr>
                    <th>Doctor Name</th>
                    <th>Appointment Date</th>
                    <th>Appointment Time</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
                <% 
                    List<Appointment> appointments = (List<Appointment>) request.getAttribute("appointments");
                    if (appointments != null && !appointments.isEmpty()) {
                        for (Appointment appointment : appointments) {
                %>
                        <tr>
                            <td><%= appointment.getDoctorName() %></td>
                            <td><%= appointment.getAppointmentDate() %></td>
                            <td><%= appointment.getAppointmentTime() %></td>
                            <td><%= appointment.getStatus() %></td>
                            <td>
                                <form action="CancelAppointmentServlet" method="post">
                                    <input type="hidden" name="appointmentId" value="<%= appointment.getAppointmentId() %>">
                                    <input type="submit" value="Cancel" class="btn">
                                </form>
                            </td>
                        </tr>
                <% 
                        }
                    } else {
                %>
                        <tr>
                            <td colspan="5">No upcoming appointments</td>
                        </tr>
                <% } %>
            </table>
        </div>
    </div>
</body>
</html>