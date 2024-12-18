package com.authorities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HospitalStatistics")
public class HospitalStatisticsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<HospitalStatistic> statsList = new ArrayList<>();

        // Database connection details
        String dbURL = "jdbc:mysql://localhost:3306/db";  // Replace 'db' with your database name
        String dbUsername = "root";  // Replace with your database username
        String dbPassword = "Mysql@123";  // Replace with your database password

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            try (Connection con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
                 Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM hospital_statistics ORDER BY year")) {

                // Process the result set
                while (rs.next()) {
                    HospitalStatistic stat = new HospitalStatistic();
                    stat.setYear(rs.getInt("year"));
                    stat.setNumPatients(rs.getInt("num_patients"));
                    stat.setNumDoctors(rs.getInt("num_doctors"));
                    stat.setTotalRevenue(rs.getBigDecimal("total_revenue"));
                    statsList.add(stat);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set the statistics list in the request scope and forward to JSP
        request.setAttribute("statsList", statsList);
        RequestDispatcher rd = request.getRequestDispatcher("HospitalStatistics.jsp");
        rd.forward(request, response);
    }
}
