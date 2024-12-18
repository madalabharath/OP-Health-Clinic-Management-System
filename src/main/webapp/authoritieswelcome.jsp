<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Authorities Dashboard</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
        }
        .sidebar {
            background-color: #2c3e50;
            width: 220px;
            height: 100vh;
            position: fixed;
            top: 0;
            left: 0;
            overflow-x: hidden;
            padding-top: 20px;
        }
        .sidebar a, .dropdown-btn {
            padding: 15px 20px;
            text-align: left;
            display: block;
            color: #ecf0f1;
            text-decoration: none;
            font-size: 18px;
            border: none;
            background: none;
            width: 100%;
            text-align: left;
            cursor: pointer;
            outline: none;
        }
        .sidebar a:hover, .dropdown-btn:hover {
            background-color: #34495e;
            color: #ecf0f1;
        }
        .dropdown-container {
            display: none;
            background-color: #34495e;
            padding-left: 8px;
        }
        .navbar {
            background-color: #2c3e50;
            width: calc(100% - 220px);
            height: 60px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 0 20px;
            position: fixed;
            top: 0;
            left: 220px;
            box-sizing: border-box;
        }
        .navbar .logo {
            font-size: 20px;
            font-weight: bold;
            color: white;
        }
        .navbar .right a {
            color: #ecf0f1;
            text-align: center;
            padding: 14px 20px;
            text-decoration: none;
            font-size: 16px;
        }
        .navbar .right a:hover {
            background-color: #34495e;
            color: #ecf0f1;
        }
        .container {
            margin-top: 80px;
            margin-left: 240px;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            flex-grow: 1;
        }
        .content {
            padding: 20px;
        }
    </style>
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            var dropdown = document.getElementsByClassName("dropdown-btn");
            for (var i = 0; i < dropdown.length; i++) {
                dropdown[i].addEventListener("click", function() {
                    this.classList.toggle("active");
                    var dropdownContent = this.nextElementSibling;
                    if (dropdownContent.style.display === "block") {
                        dropdownContent.style.display = "none";
                    } else {
                        dropdownContent.style.display = "block";
                    }
                });
            }
        });
    </script>
</head>
<body>
    <div class="sidebar">
        <a href="authoritieswelcome.jsp">Home</a>
        <button class="dropdown-btn">Patients 
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-container">
            <a href="Authaddpatient.jsp">Add Patient</a>
            <a href="authRetrievePatient.jsp">View Patients</a>
            <a href="AuthUpdatePatient.jsp">Update Patient</a>
            <a href="AuthDeletePatientByEmail.jsp">Delete Patient</a>
        </div>
        <button class="dropdown-btn">Doctors 
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-container">
            <a href="authAddDoctor.jsp">Add Doctor Details</a>
            <a href="authRetrievedoctor.jsp">View Doctors</a>
            <a href="authUpdateDoctor.jsp">Update Doctor</a>
            <a href="authDeleteDoctor.jsp">Delete Doctor</a>
        </div>
        <button class="dropdown-btn">Appointments 
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-container">
            <a href="authAddAppointments.jsp">Add Appointment</a>
            <a href="authRetrieveAppointments.jsp">View Appointments</a>
            <a href="authUpdateAppointments.jsp">Update Appointments</a>
            <a href="authDeleteAppointment.jsp">Delete Appointment</a>
        </div>
        <a href="FinancialReportServlet">Reports</a>
        <a href="HospitalStatisticsServlet">Health statisticts</a>
    </div>
    <div class="navbar">
        <div class="logo">Authority Dashboard</div>
        <div class="right">
            <a href="authochangepassword.jsp">ChangePassword</a>
            <a href="logout.jsp">Logout</a>
        </div>
    </div>
    <div class="container">
        <div class="content">
            <h1>Welcome, <%= session.getAttribute("username") %>!</h1>
            <p>Use the navigation bar to access different sections of the authorities module.</p>
        </div>
    </div>
</body>
</html>