<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            color: #343a40;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 40px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 10px;
        }
        .header {
            text-align: center;
            padding: 20px 0;
            border-bottom: 2px solid #6c757d;
        }
        .header h2 {
            margin: 0;
            font-size: 2em;
            color: #007bff;
        }
        .header p {
            font-size: 1.2em;
            color: #6c757d;
        }
        .section {
            margin: 40px 0;
        }
        .section h2 {
            font-size: 1.8em;
            color: #007bff;
            border-bottom: 2px solid #007bff;
            padding-bottom: 10px;
            margin-bottom: 20px;
        }
        .services, .tips {
            list-style-type: none;
            padding: 0;
        }
        .services li, .tips li {
            margin: 10px 0;
            font-size: 1.1em;
        }
        .image-container {
            text-align: center;
            margin: 20px 0;
        }
        .image-container img {
            max-width: 100%;
            height: auto;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }
        .highlight {
            color: #28a745;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <%@ include file="patientnavbar.jsp" %>
    <div class="container">
        <div class="header">
            <h2>Welcome!</h2>
            <% 
                if (session != null) {
                    String email = (String) session.getAttribute("email");
                    if (email != null) {
                        out.println("<p>Logged in as: " + email + "</p>");
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                } else {
                    response.sendRedirect("login.jsp");
                }
            %>
        </div>
        <div class="section">
            <h2>About Our Services</h2>
            <div class="image-container">
                <img src="images/services.jpeg" alt="Our Services">
            </div>
            <p>At <span class="highlight">[Our Healthcare]</span>, we offer a range of services to ensure you and your family stay healthy:</p>
            <ul class="services">
                <li><strong>General Check-ups:</strong> Regular health assessments to keep you in top shape.</li>
                <li><strong>Specialist Consultations:</strong> Access to top specialists in various fields.</li>
                <li><strong>Diagnostics:</strong> Advanced diagnostic tests and screenings.</li>
                <li><strong>Vaccinations:</strong> Keeping you protected from preventable diseases.</li>
                <li><strong>Emergency Care:</strong> 24/7 emergency services for urgent health needs.</li>
            </ul>
        </div>
        <div class="section">
            <h2>Health Tips</h2>
            <div class="image-container">
                <img src="images/health_tips.jpeg" alt="Health Tips">
            </div>
            <ul class="tips">
                <li><strong>Stay Hydrated:</strong> Drink at least 8 glasses of water a day.</li>
                <li><strong>Balanced Diet:</strong> Include fruits, vegetables, and lean proteins in your meals.</li>
                <li><strong>Regular Exercise:</strong> Aim for at least 30 minutes of physical activity daily.</li>
                <li><strong>Adequate Sleep:</strong> Ensure you get 7-8 hours of quality sleep each night.</li>
            </ul>
        </div>
    </div>
</body>
</html>
