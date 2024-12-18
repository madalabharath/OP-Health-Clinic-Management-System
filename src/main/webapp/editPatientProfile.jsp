<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Patient Profile</title>
    <style>
        /* Add your CSS styling here */
        table {
            width: 50%;
            border-collapse: collapse;
            margin: 50px 0;
            font-size: 18px;
            text-align: left;
        }
        th, td {
            padding: 12px;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>
    <h2>Edit Patient Profile</h2>
    <form action="updatePatientProfileServlet" method="post">
        <input type="hidden" name="email" value="${sessionScope.email}">
        <table>
            <tr><th>First Name:</th><td><input type="text" name="firstName" value="${firstName}"></td></tr>
            <tr><th>Last Name:</th><td><input type="text" name="lastName" value="${lastName}"></td></tr>
            <tr><th>Gender:</th><td><input type="text" name="gender" value="${gender}"></td></tr>
            <tr><th>Date of Birth:</th><td><input type="date" name="dob" value="${dob}"></td></tr>
            <tr><th>Phone:</th><td><input type="text" name="phone" value="${phone}"></td></tr>
            <tr><th>Address:</th><td><input type="text" name="address" value="${address}"></td></tr>
            <tr><th>City:</th><td><input type="text" name="city" value="${city}"></td></tr>
            <tr><th>State:</th><td><input type="text" name="state" value="${state}"></td></tr>
            <tr><th>ZIP:</th><td><input type="text" name="zip" value="${zip}"></td></tr>
        </table>
        <br>
        <input type="submit" value="Update Profile">
    </form>
</body>
</html>
