<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Check if the session exists and invalidate it
    if (session != null) {
        session.invalidate();
    }
    // Redirect to the login page after logging out
    response.sendRedirect("index.jsp");
%>
