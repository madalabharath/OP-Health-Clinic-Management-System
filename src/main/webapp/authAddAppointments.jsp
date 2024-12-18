<!DOCTYPE html>
<html>
<head>
    <title>Schedule Appointment</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 350px;
        }
        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        label {
            display: block;
            font-weight: bold;
            margin-bottom: 6px;
            color: #555;
        }
        input[type="text"], input[type="email"], input[type="date"], input[type="time"], input[type="submit"], select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 16px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .message {
            text-align: center;
            color: #333;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Schedule Appointment</h2>
        <form action="AdminScheduleAppointmentServlet" method="post">
            <label for="email">Patient Email:</label>
            <input type="email" id="email" name="email" required>
            <label for="doctor">Select Doctor:</label>
            <select id="doctor" name="doctor" required>
                <option value="Dr. John Smith">Dr. John Smith</option>
                <option value="Dr. Jane Doe">Dr. Jane Doe</option>
                <option value="Dr. Bob Johnson">Dr. Bob Johnson</option>
                <option value="Dr. Mary Smith">Dr. Mary Smith</option>
                <option value="Dr. James Brown">Dr. James Brown</option>
            </select>
            <label for="appointmentDate">Appointment Date:</label>
            <input type="date" id="appointmentDate" name="appointmentDate" required>
            <label for="appointmentTime">Appointment Time:</label>
            <input type="time" id="appointmentTime" name="appointmentTime" required>
            <input type="submit" value="Schedule Appointment">
        </form>
    </div>
</body>
</html>