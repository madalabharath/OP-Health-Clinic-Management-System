package com.authorities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FinancialReport")
public class FinancialReportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Mysql@123";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<FinancialReport> reports = new ArrayList<>();

        String query = "SELECT * FROM financial_report";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                FinancialReport report = new FinancialReport();
                report.setId(rs.getInt("id"));
                report.setDate(rs.getDate("date"));
                report.setRevenue(rs.getBigDecimal("revenue"));
                report.setExpenses(rs.getBigDecimal("expenses"));
                report.setProfit(rs.getBigDecimal("profit"));
                reports.add(report);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while retrieving the financial reports.");
            return;
        }

        request.setAttribute("reports", reports);
        RequestDispatcher rd = request.getRequestDispatcher("FinancialReport.jsp");
        rd.forward(request, response);
    }

}
