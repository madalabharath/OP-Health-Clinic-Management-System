<!-- patientnavbar.jsp -->
<div class="navbar">
    <a href="patienthome.jsp">Home</a>
    <a href="registerPatient.jsp">Patient Registration</a>
    <a href="changePassword.jsp">Change Password</a>
    <a href="welcome.jsp">Appointments</a>
    <a href="logout.jsp" class="right">Logout</a>
    
</div>

<style>
    /* Basic styling for the navbar */
    .navbar {
        background-color: #333;
        overflow: hidden;
    }

    .navbar a {
        float: left;
        display: block;
        color: #f2f2f2;
        text-align: center;
        padding: 14px 20px;
        text-decoration: none;
    }

    .navbar a:hover {
        background-color: #ddd;
        color: black;
    }

    .navbar a.right {
        float: right;
    }
</style>
