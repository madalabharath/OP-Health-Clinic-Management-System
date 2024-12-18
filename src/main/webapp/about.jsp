<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>About Us</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
            color: #333;
        }
        .navbar {
            background-color: #333;
            overflow: hidden;
        }
        .navbar a {
            float: left;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            transition: background-color 0.3s, color 0.3s;
        }
        .navbar a:hover {
            background-color: #4CAF50;
            color: white;
        }
        .header {
            text-align: center;
            padding: 50px 20px;
            background-color: #4CAF50;
            color: white;
        }
        .header h1 {
            margin: 0;
            font-size: 48px;
        }
        .header p {
            font-size: 18px;
            margin: 10px 0 0 0;
        }
        .container {
            padding: 20px;
        }
        .intro {
            text-align: center;
            margin-bottom: 40px;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }
        .intro h2 {
            color: #4CAF50;
        }
        .intro p {
            font-size: 18px;
            margin: 10px 0;
            line-height: 1.6;
        }
        .doctor-card {
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 8px;
            padding: 16px;
            margin: 16px 0;
            display: flex;
            align-items: center;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            transition: transform 0.3s;
        }
        .doctor-card:hover {
            transform: translateY(-5px);
        }
        .doctor-card img {
            border-radius: 50%;
            margin-right: 16px;
            border: 3px solid #4CAF50;
        }
        .doctor-card .details {
            flex-grow: 1;
        }
        .doctor-card .details h2 {
            margin: 0 0 8px 0;
            font-size: 24px;
            color: #4CAF50;
        }
        .doctor-card .details p {
            margin: 4px 0;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <a href="index.jsp">Home</a>
        <a href="about.jsp">About Us</a>
        <a href="contact.jsp">Contact Us</a>
    </div>
    <div class="header">
        <h1>Welcome to Our Healthcare Services</h1>
        <p>Providing compassionate and comprehensive care for all your health needs.</p>
    </div>
    <div class="container">
        <div class="intro">
            <h2>About Our Healthcare Services</h2>
            <p>At our healthcare center, we are dedicated to offering high-quality medical services with a focus on personalized care. Our team of experienced and compassionate doctors and healthcare professionals are committed to ensuring the best outcomes for our patients.</p>
            <p>We utilize the latest medical technologies and innovative treatment methods to address a wide range of health conditions. Our goal is to promote wellness and improve the quality of life for all our patients.</p>
        </div>
        <h2 style="text-align: center; color: #4CAF50;">Meet Our Doctors</h2>
        <div class="doctor-card">
            <img src="images/dr_john_smith.jpg" alt="Dr. John Smith" width="100" height="100">
            <div class="details">
                <h2>Dr. John Smith</h2>
                <p><strong>Specialization:</strong> Cardiology</p>
                <p>Dr. John Smith is a renowned cardiologist with over 20 years of experience in treating heart diseases and conditions. He is committed to providing the best care for his patients.</p>
            </div>
        </div>
        <div class="doctor-card">
            <img src="images/dr_jane_doe.jpg" alt="Dr. Jane Doe" width="100" height="100">
            <div class="details">
                <h2>Dr. Jane Doe</h2>
                <p><strong>Specialization:</strong> Neurology</p>
                <p>Dr. Jane Doe specializes in neurology and has extensive experience in diagnosing and treating disorders of the nervous system. She is dedicated to improving patient outcomes through innovative treatments.</p>
            </div>
        </div>
        <div class="doctor-card">
            <img src="images/dr_bob_johnson.jpg" alt="Dr. Bob Johnson" width="100" height="100">
            <div class="details">
                <h2>Dr. Bob Johnson</h2>
                <p><strong>Specialization:</strong> Orthopedics</p>
                <p>Dr. Bob Johnson is an expert in orthopedics with a focus on joint replacement and sports injuries. He is passionate about helping patients regain their mobility and quality of life.</p>
            </div>
        </div>
        <div class="doctor-card">
            <img src="images/dr_mary_smith.jpg" alt="Dr. Mary Smith" width="100" height="100">
            <div class="details">
                <h2>Dr. Mary Smith</h2>
                <p><strong>Specialization:</strong> Pediatrics</p>
                <p>Dr. Mary Smith is a pediatrician with a heart for children. She has been caring for young patients for over 15 years, providing compassionate and comprehensive healthcare services.</p>
            </div>
        </div>
        <div class="doctor-card">
            <img src="images/dr_james_brown.jpg" alt="Dr. James Brown" width="100" height="100">
            <div class="details">
                <h2>Dr. James Brown</h2>
                <p><strong>Specialization:</strong> Dermatology</p>
                <p>Dr. James Brown is a dermatologist known for his expertise in skin care and cosmetic treatments. He is dedicated to helping patients achieve healthy and beautiful skin.</p>
            </div>
        </div>
    </div>
</body>
</html>

