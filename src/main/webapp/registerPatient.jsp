<!DOCTYPE html>
<html>
<head>
    <title>Patient Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: white;
            padding: 20px 40px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            margin-top: 10px;
            font-weight: bold;
        }
        input[type="text"], input[type="email"], input[type="date"], input[type="tel"], input[type="submit"] {
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }
        input[type="submit"] {
            background-color: #28a745;
            color: white;
            border: none;
            cursor: pointer;
            margin-top: 20px;
            font-size: 18px;
        }
        input[type="submit"]:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Patient Registration Form</h2>
        <form action="registerPatientServlet" method="post">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="<%= session.getAttribute("email") %>" readonly>
            
            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" name="firstName">
            
            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName">
            
            <label for="gender">Gender:</label>
            <input type="text" id="gender" name="gender">
            
            <label for="dob">Date of Birth:</label>
            <input type="date" id="dob" name="dob">
            
            <label for="phone">Phone:</label>
            <input type="tel" id="phone" name="phone">
            
            <label for="address">Address:</label>
            <input type="text" id="address" name="address">
            
            <label for="city">City:</label>
            <input type="text" id="city" name="city">
            
            <label for="state">State:</label>
            <input type="text" id="state" name="state">
            
            <label for="zip">ZIP:</label>
            <input type="text" id="zip" name="zip">
            
            <input type="submit" value="Register">
        </form>
    </div>
</body>
</html>
