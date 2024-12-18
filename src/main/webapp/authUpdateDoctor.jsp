<!DOCTYPE html>
<html>
<head>
    <title>Retrieve Doctor</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 500px;
        }
        h2 {
            text-align: center;
        }
        label {
            display: block;
            margin-bottom: 8px;
        }
        input[type="text"], input[type="number"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            padding: 10px;
            font-size: 16px;
            border-radius: 4px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .results {
            margin-top: 20px;
        }
        .results p {
            font-size: 16px;
            line-height: 1.6;
        }
        a {
            color: #4CAF50;
            text-decoration: none;
            font-weight: bold;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Retrieve and Update Doctor Details</h2>
        <form action="AuthUpdateDoctorByEmailServlet" method="get">
            <label for="email">Enter Doctor Email:</label>
            <input type="text" id="email" name="email" required>
            <input type="submit" value="Retrieve">
        </form>
        <div class="results">
            <%
                // Display any messages here
                String resultMessage = (String) request.getAttribute("resultMessage");
                if (resultMessage != null) {
                    out.println(resultMessage);
                }
            %>
        </div>
        <p><a href="authoritieswelcome.jsp">Go to Dashboard</a></p>
    </div>
</body>
</html>
