package com.authorities;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AuthUpdateDoctorByEmailServlet")
public class AuthUpdateDoctorByEmailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String gender = request.getParameter("gender");
        String specialization = request.getParameter("specialization");
        String salary = request.getParameter("salary");
        String phone = request.getParameter("phone");

        response.setContentType("text/html");
        response.getWriter().println("<html><head>");
        response.getWriter().println("<title>Update Doctor Details</title>");
        response.getWriter().println("<style>");
        response.getWriter().println("body {");
        response.getWriter().println("    font-family: Arial, sans-serif;");
        response.getWriter().println("    margin: 0;");
        response.getWriter().println("    padding: 0;");
        response.getWriter().println("    background-color: #f4f4f4;");
        response.getWriter().println("}");
        response.getWriter().println(".container {");
        response.getWriter().println("    max-width: 800px;");
        response.getWriter().println("    margin: 20px auto;");
        response.getWriter().println("    padding: 20px;");
        response.getWriter().println("    background: #fff;");
        response.getWriter().println("    border-radius: 8px;");
        response.getWriter().println("    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);");
        response.getWriter().println("}");
        response.getWriter().println("h1 {");
        response.getWriter().println("    color: #333;");
        response.getWriter().println("    text-align: center;");
        response.getWriter().println("    margin-bottom: 20px;");
        response.getWriter().println("}");
        response.getWriter().println("label {");
        response.getWriter().println("    font-weight: bold;");
        response.getWriter().println("    display: block;");
        response.getWriter().println("    margin-top: 10px;");
        response.getWriter().println("}");
        response.getWriter().println("input[type=\"text\"],");
        response.getWriter().println("input[type=\"number\"] {");
        response.getWriter().println("    padding: 10px;");
        response.getWriter().println("    font-size: 16px;");
        response.getWriter().println("    border: 1px solid #ccc;");
        response.getWriter().println("    border-radius: 4px;");
        response.getWriter().println("    width: calc(100% - 22px);");
        response.getWriter().println("    margin-top: 5px;");
        response.getWriter().println("    box-sizing: border-box;");
        response.getWriter().println("}");
        response.getWriter().println("input[type=\"submit\"] {");
        response.getWriter().println("    background-color: #4CAF50;");
        response.getWriter().println("    color: white;");
        response.getWriter().println("    border: none;");
        response.getWriter().println("    padding: 15px;");
        response.getWriter().println("    font-size: 16px;");
        response.getWriter().println("    cursor: pointer;");
        response.getWriter().println("    border-radius: 4px;");
        response.getWriter().println("    margin-top: 20px;");
        response.getWriter().println("}");
        response.getWriter().println("input[type=\"submit\"]:hover {");
        response.getWriter().println("    background-color: #45a049;");
        response.getWriter().println("}");
        response.getWriter().println(".doctor-info {");
        response.getWriter().println("    margin-top: 20px;");
        response.getWriter().println("    padding: 10px;");
        response.getWriter().println("    background: #f9f9f9;");
        response.getWriter().println("    border: 1px solid #ddd;");
        response.getWriter().println("    border-radius: 4px;");
        response.getWriter().println("}");
        response.getWriter().println(".doctor-info p {");
        response.getWriter().println("    margin: 5px 0;");
        response.getWriter().println("}");
        response.getWriter().println("a {");
        response.getWriter().println("    color: #4CAF50;");
        response.getWriter().println("    text-decoration: none;");
        response.getWriter().println("    font-weight: bold;");
        response.getWriter().println("}");
        response.getWriter().println("a:hover {");
        response.getWriter().println("    text-decoration: underline;");
        response.getWriter().println("}");
        response.getWriter().println(".form-group {");
        response.getWriter().println("    margin-bottom: 15px;");
        response.getWriter().println("}");
        response.getWriter().println("</style>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<div class='container'>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Mysql@123");

            if (firstName == null || lastName == null || gender == null || specialization == null || salary == null || phone == null) {
                // Retrieve current doctor details
                String retrieveSql = "SELECT * FROM doctordetails WHERE email = ?";
                PreparedStatement retrieveStmt = conn.prepareStatement(retrieveSql);
                retrieveStmt.setString(1, email);
                ResultSet resultSet = retrieveStmt.executeQuery();
                
                if (resultSet.next()) {
                    // Display the current details and provide fields to update
                    response.getWriter().println("<h1>Update Doctor Details</h1>");
                    response.getWriter().println("<form action='AuthUpdateDoctorByEmailServlet' method='get'>");
                    response.getWriter().println("<div class='form-group'><label>First Name:</label><input type='text' name='firstName' value='" + resultSet.getString("first_name") + "' required></div>");
                    response.getWriter().println("<div class='form-group'><label>Last Name:</label><input type='text' name='lastName' value='" + resultSet.getString("last_name") + "' required></div>");
                    response.getWriter().println("<div class='form-group'><label>Gender:</label><input type='text' name='gender' value='" + resultSet.getString("gender") + "' required></div>");
                    response.getWriter().println("<div class='form-group'><label>Specialization:</label><input type='text' name='specialization' value='" + resultSet.getString("specialization") + "' required></div>");
                    response.getWriter().println("<div class='form-group'><label>Salary:</label><input type='number' name='salary' value='" + resultSet.getBigDecimal("salary") + "' required></div>");
                    response.getWriter().println("<div class='form-group'><label>Phone:</label><input type='text' name='phone' value='" + resultSet.getString("phone") + "' required></div>");
                    response.getWriter().println("<input type='hidden' name='email' value='" + email + "'>");
                    response.getWriter().println("<input type='submit' value='Update'>");
                    response.getWriter().println("</form>");
                } else {
                    response.getWriter().println("<p>No doctor found with the provided email.</p>");
                }
            } else {
                // Update doctor details
                String updateSql = "UPDATE doctordetails SET first_name = ?, last_name = ?, gender = ?, specialization = ?, salary = ?, phone = ? WHERE email = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                updateStmt.setString(1, firstName);
                updateStmt.setString(2, lastName);
                updateStmt.setString(3, gender);
                updateStmt.setString(4, specialization);
                updateStmt.setBigDecimal(5, new BigDecimal(salary));
                updateStmt.setString(6, phone);
                updateStmt.setString(7, email);
                
                int rowsUpdated = updateStmt.executeUpdate();
                if (rowsUpdated > 0) {
                    response.getWriter().println("<p>Doctor updated successfully!</p>");
                } else {
                    response.getWriter().println("<p>Error updating doctor. Please check the email provided.</p>");
                }
                response.getWriter().println("<p><a href='authoritieswelcome.jsp'>Go to Dashboard</a></p>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<p>Error: " + e.getMessage() + "</p>");
        }
        
        response.getWriter().println("</div>");
        response.getWriter().println("</body></html>");
    }
}
