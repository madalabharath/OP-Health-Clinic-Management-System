<%@ page import="java.sql.*, javax.servlet.*, javax.servlet.http.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Appointments</title>
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
            max-width: 1000px;
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
        input[type="tel"],
        input[type="date"],
        input[type="time"],
        select,
        textarea {
            width: 100%;
            padding: 12px;
            margin-bottom: 16px;
            border: 1px solid #ced4da;
            border-radius: 4px;
            box-sizing: border-box;
        }
        textarea {
            resize: vertical;
            height: 120px;
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
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        a {
            text-decoration: none;
            color: #007bff;
        }
        a:hover {
            text-decoration: underline;
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
        <h2>Manage Appointments</h2>

        <!-- Form for creating new appointment -->
        <h3>Create Appointment</h3>
        <form action="createAppointmentServlet" method="post">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="doctor">Select Doctor:</label>
            <select id="doctor" name="doctor" required>
                <option value="Dr. John Smith">Dr. John Smith</option>
                <option value="Dr. Jane Doe">Dr. Jane Doe</option>
                <option value="Dr. Bob Johnson">Dr. Bob Johnson</option>
                <option value="Dr. Mary Smith">Dr. Mary Smith</option>
                <option value="Dr. James Brown">Dr. James Brown</option>
            </select>

            <label for="date">Appointment Date:</label>
            <input type="date" id="date" name="date" required>

            <label for="time">Appointment Time:</label>
            <input type="time" id="time" name="time" required>

            <input type="submit" value="Create Appointment">
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
                <th>Action</th>
            </tr>
            <% 
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Mysql@123");

                    String sql = "SELECT * FROM appointments";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String email = rs.getString("email");
                        String doctor = rs.getString("doctor");
                        String date = rs.getString("appointment_date");
                        String time = rs.getString("appointment_time");

                        out.println("<tr>");
                        out.println("<td>" + id + "</td>");
                        out.println("<td>" + email + "</td>");
                        out.println("<td>" + doctor + "</td>");
                        out.println("<td>" + date + "</td>");
                        out.println("<td>" + time + "</td>");
                        out.println("<td><a href='updateAppointment.jsp?id=" + id + "&email=" + email + "&doctor=" + doctor + "&date=" + date + "&time=" + time + "'>Update</a> | <a href='deleteAppointmentServlet?id=" + id + "'>Delete</a></td>");
                        out.println("</tr>");
                    }

                    rs.close();
                    ps.close();
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    out.println("<tr><td colspan='6' class='message'>An error occurred. Please try again later.</td></tr>");
                }
            %>
        </table>
    </div>
</body>
</html>
