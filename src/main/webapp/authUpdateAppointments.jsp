<%@ page import="java.sql.*, javax.servlet.*, javax.servlet.http.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Appointments</title>
    <style>
        /* General Styles */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            color: #333;
        }

        .container {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
        }

        /* Header Styles */
        h2, h3 {
            color: #333;
            border-bottom: 2px solid #ddd;
            padding-bottom: 10px;
        }

        /* Form Styles */
        form {
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"], select {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        /* Table Styles */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        .message {
            text-align: center;
            font-style: italic;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Manage Appointments</h2>

        <!-- Form for searching appointments by doctor name -->
        <h3>Search Appointments</h3>
        <form action="DoctorAppointmentsServlet" method="get">
            <label for="searchDoctor">Doctor Name:</label>
            <input type="text" id="searchDoctor" name="searchDoctor">
            <input type="submit" value="Search">
        </form>

        <hr>

        <!-- Table to view and manage existing appointments -->
        <h3>Appointments List</h3>
        <table>
            <tr>
                <th>ID</th>
                <th>Email</th>
                <th>Doctor</th>
                <th>Date</th>
                <th>Time</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            <% 
                ResultSet rs = (ResultSet) request.getAttribute("appointments");

                if (rs != null) {
                    while (rs.next()) {
                        int id = rs.getInt("appointment_id");
                        String email = rs.getString("email");
                        String doctor = rs.getString("doctor_name");
                        String date = rs.getString("appointment_date");
                        String time = rs.getString("appointment_time");
                        String status = rs.getString("status");

                        out.println("<tr>");
                        out.println("<td>" + id + "</td>");
                        out.println("<td>" + email + "</td>");
                        out.println("<td>" + doctor + "</td>");
                        out.println("<td>" + date + "</td>");
                        out.println("<td>" + time + "</td>");
                        out.println("<td>" + status + "</td>");
                        out.println("<td>");
                        out.println("<form action='DoctorAppointmentsServlet' method='post' style='display:inline;'>");
                        out.println("<input type='hidden' name='appointmentId' value='" + id + "'>");
                        out.println("<select name='status' required>");
                        out.println("<option value='Pending'" + (status.equals("Pending") ? " selected" : "") + ">Pending</option>");
                        out.println("<option value='Accepted'" + (status.equals("Accepted") ? " selected" : "") + ">Accepted</option>");
                        out.println("<option value='Rejected'" + (status.equals("Rejected") ? " selected" : "") + ">Rejected</option>");
                        out.println("</select>");
                        out.println("<input type='submit' value='Update Status'>");
                        out.println("</form>");
                        out.println("</td>");
                        out.println("</tr>");
                    }
                } else {
                    out.println("<tr><td colspan='7' class='message'>No appointments found.</td></tr>");
                }
            %>
        </table>

        <!-- Link to go to the dashboard -->
        <p class="message"><a href="authoritieswelcome.jsp">Go to Dashboard</a></p>
    </div>
</body>
</html>