<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Contact Us - Submission</title>
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
        .message {
            padding: 20px;
            background-color: #e8f5e9;
            border-left: 5px solid #4CAF50;
            margin: 20px 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">Thank You!</div>
        <div class="message">
            <%
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String message = request.getParameter("message");

                // Simple console output for demonstration (use logging in real applications)
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
                System.out.println("Message: " + message);

                // Store or process the data as needed
            %>
            <p>Thank you, <%= name %>, for contacting us. We will respond to your message shortly.</p>
        </div>
    </div>
</body>
</html>
