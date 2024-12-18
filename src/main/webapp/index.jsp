<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <style>
        nav {
            background-color: #333;
            overflow: hidden;
        }
        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }
        nav ul li {
            float: left;
        }
        nav ul li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
        nav ul li a:hover {
            background-color: #111;
        }
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        h1 {
            color: #333;
            text-align: center;
            margin-top: 20px;
        }
        .content {
            max-width: 1200px;
            margin: 20px auto;
            padding: 20px;
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .hero {
            width: 100%;
            height: 400px;
            background: url('<%= request.getContextPath() %>/images/img1.jpg') no-repeat center center/cover;
        }
        .gallery {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }
        .gallery img {
            width: 32%;
            border-radius: 5px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
        }
        .login-links {
            text-align: center;
            margin-top: 30px;
        }
        .login-links a {
            display: inline-block;
            margin: 0 15px;
            padding: 10px 20px;
            background-color: #333;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .login-links a:hover {
            background-color: #111;
        }
    </style>
</head>
<body>
    <jsp:include page="navbar.jsp" />
    <div class="hero"></div>
    <div class="content">
        <h1>Welcome to Our Healthcare System</h1>
        <p>We are dedicated to providing the best healthcare services to our community. Our state-of-the-art facilities and highly trained staff are here to ensure your health and well-being.</p>
        <div class="gallery">
            <img src="<%= request.getContextPath() %>/images/img2.jpg" alt="Healthcare 1">
            <img src="<%= request.getContextPath() %>/images/img3.jpg" alt="Healthcare 2">
            <img src="<%= request.getContextPath() %>/images/img4.jpg" alt="Healthcare 3">
        </div>
    </div>
</body> 
</html>
