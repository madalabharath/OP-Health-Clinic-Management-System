<%@ page import="java.sql.*, javax.servlet.*, javax.servlet.http.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Appointment</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #f5f7fa, #c3cfe2);
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        .container {
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
            padding: 30px;
            width: 90%;
            max-width: 600px;
            box-sizing: border-box;
        }
        h2 {
            text-align: center;
            color: #343a40;
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 8px;
            color: #495057;
        }
        input[type="text"],
        input[type="email"],
        input[type="date"],
        input[type="time"],
        select {
            width: 100%;
            padding: 12px;
            margin-bottom: 16px;
            border: 1px solid #ced4da;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 4px;
            padding: 12px;
            cursor: pointer;
            width: 100%;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #218838;
        }
        .message {
            color: #dc3545;
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Update Appointment</h2>
        <%
            // Retrieve appointment ID from request
            String idStr = request.getParameter("id");
            int id = Integer.parseInt(idStr);

            // Database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Mysql@123");

            // Query to retrieve appointment details
            String sql = "SELECT * FROM appointments WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            // Retrieve appointment data
            if (rs.next()) {
                String email = rs.getString("email");
                String doctor = rs.getString("doctor");
                String appointmentDate = rs.getString("appointment_date");
                String appointmentTime = rs.getString("appointment_time");
        %>
        <form action="updateAppointmentServlet" method="post">
            <input type="hidden" name="id" value="<%= id %>">
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="<%= email %>" required>
            
            <label for="doctor">Select Doctor:</label>
            <select id="doctor" name="doctor" required>
                <option value="Dr. John Smith" <%= doctor.equals("Dr. John Smith") ? "selected" : "" %>>Dr. John Smith</option>
                <option value="Dr. Jane Doe" <%= doctor.equals("Dr. Jane Doe") ? "selected" : "" %>>Dr. Jane Doe</option>
                <option value="Dr. Bob Johnson" <%= doctor.equals("Dr. Bob Johnson") ? "selected" : "" %>>Dr. Bob Johnson</option>
                <option value="Dr. Mary Smith" <%= doctor.equals("Dr. Mary Smith") ? "selected" : "" %>>Dr. Mary Smith</option>
                <option value="Dr. James Brown" <%= doctor.equals("Dr. James Brown") ? "selected" : "" %>>Dr. James Brown</option>
            </select>
            
            <label for="date">Appointment Date:</label>
            <input type="date" id="date" name="appointment_date" value="<%= appointmentDate %>" required>
            
            <label for="time">Appointment Time:</label>
            <input type="time" id="time" name="appointment_time" value="<%= appointmentTime %>" required>
            
            <input type="submit" value="Update Appointment">
        </form>
        <%
            } else {
        %>
        <p class="message">No appointment found with the provided ID.</p>
        <%
            }
            rs.close();
            ps.close();
            conn.close();
        %>
    </div>
</body>
</html>
