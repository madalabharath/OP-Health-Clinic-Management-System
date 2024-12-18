package com.klef;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forgotPasswordServlet")
public class ForgotPassword extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String newPassword = request.getParameter("newPassword");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Mysql@123");

            String sql = "UPDATE patientlist SET password = ? WHERE email = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.setString(2, email);

            int updated = ps.executeUpdate();
            PrintWriter out = response.getWriter();
           
            if (updated > 0) {
                out.println("<html><head><style>");
                out.println("body, html { margin: 0; padding: 0; height: 100%; display: flex; align-items: center; justify-content: center; }");
                out.println("@keyframes float { 0% { transform: translateY(0); } 50% { transform: translateY(-10px); } 100% { transform: translateY(0); } }");
                out.println(".frame { border: 2px solid lightgreen; padding: 40px; width: 80%; max-width: 500px; text-align: center; background-color: #f0fff0; ");
                out.println("box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); animation: float 2s infinite; border-radius: 10px; font-family: 'Roboto', sans-serif; }");
                out.println("h2 { color: #006400; margin-bottom: 20px; }");
                out.println("a { display: inline-block; margin-top: 20px; text-decoration: none; color: #00796b; font-size: 16px; font-weight: bold; }");
                out.println("a:hover { color: #004d40; }");
                out.println("</style></head><body>");
                out.println("<div class='frame'><h2>Password updated successfully.</h2>");
                out.println("<a href='patientlogin.jsp'>Login</a></div>");
                out.println("</body></html>");
            } else {
                out.println("<html><head><style>");
                out.println("body, html { margin: 0; padding: 0; height: 100%; display: flex; align-items: center; justify-content: center; }");
                out.println(".frame { border: 2px solid red; padding: 40px; width: 80%; max-width: 500px; text-align: center; background-color: #fff0f0; ");
                out.println("box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); border-radius: 10px; font-family: 'Roboto', sans-serif; }");
                out.println("h2 { color: #800000; margin-bottom: 20px; }");
                out.println("a { display: inline-block; margin-top: 20px; text-decoration: none; color: #00796b; font-size: 16px; font-weight: bold; }");
                out.println("a:hover { color: #004d40; }");
                out.println("</style></head><body>");
                out.println("<div class='frame'><h2>Email not found. Please try again.</h2>");
                out.println("<a href='patientforgotpassword.jsp'>Try Again</a></div>");
                out.println("</body></html>");
            }




            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
