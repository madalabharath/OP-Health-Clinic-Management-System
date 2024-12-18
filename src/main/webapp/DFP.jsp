<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Forgot Password</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f2f2f2;
        }
        .forgot-password-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
            text-align: center;
        }
        .forgot-password-container h2 {
            margin-bottom: 20px;
        }
        .forgot-password-container form {
            display: flex;
            flex-direction: column;
        }
        .forgot-password-container label {
            margin-bottom: 5px;
            text-align: left;
        }
        .forgot-password-container input {
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .forgot-password-container button {
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .forgot-password-container button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="forgot-password-container">
        <h2>Reset Password</h2>
        <form action="ForgotPasswordServlet" method="post">
            <label for="id">Doctor ID:</label>
            <input type="text" id="id" name="id" required>
            <label for="newPassword">New Password:</label>
            <input type="password" id="newPassword" name="newPassword" required>
            <button type="submit">Reset Password</button>
        </form>
    </div>
</body>
</html>