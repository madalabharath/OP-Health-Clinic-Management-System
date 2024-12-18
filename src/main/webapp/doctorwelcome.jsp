<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        .navbar {
            background-color: #2c3e50;
            overflow: hidden;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }

        .navbar a {
            float: left;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 20px;
            text-decoration: none;
            transition: background-color 0.3s;
        }

        .navbar a:hover {
            background-color: #1abc9c;
            color: white;
        }

        .container {
            text-align: center;
            padding: 50px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0,0,0,0.1);
            margin: 50px auto;
            width: 60%;
        }

        h1 {
            color: #2c3e50;
            font-size: 36px;
            margin-bottom: 20px;
        }

        p {
            font-size: 18px;
            color: #666;
            margin-bottom: 40px;
        }
    </style>
</head>
<body>
    <%@ include file="doctornavbar.jsp" %>

    <div class="container">
        <%
            String doctorName = (String) request.getAttribute("doctorName");
            if (doctorName == null || doctorName.isEmpty()) {
                doctorName = "Doctor";
            }
        %>
        <h1>Welcome, <%= doctorName %>!</h1>
        <p>You have successfully logged in.</p>
    </div>
</body>
</html>