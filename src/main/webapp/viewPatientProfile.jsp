<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Patient Profile</title>
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
    <h2>Patient Profile</h2>
    <table>
        <tr><th>First Name:</th><td>${firstName}</td></tr>
        <tr><th>Last Name:</th><td>${lastName}</td></tr>
        <tr><th>Gender:</th><td>${gender}</td></tr>
        <tr><th>Date of Birth:</th><td>${dob}</td></tr>
        <tr><th>Phone:</th><td>${phone}</td></tr>
        <tr><th>Address:</th><td>${address}</td></tr>
        <tr><th>City:</th><td>${city}</td></tr>
        <tr><th>State:</th><td>${state}</td></tr>
        <tr><th>ZIP:</th><td>${zip}</td></tr>
    </table>
    <br>
    <a href="editPatientProfile.jsp">Edit Profile</a>
</body>
</html>
