<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    nav ul li.right {
        float: right;
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
</style>
<nav>
    <ul>
        <li><a href="<%= request.getContextPath() %>/navigate?page=index.jsp">Home</a></li>
        <li><a href="<%= request.getContextPath() %>/navigate?page=about.jsp">About Us</a></li>
        <li><a href="<%= request.getContextPath() %>/navigate?page=contact.jsp">Contact Us</a></li>
        <li class="right"><a href="<%= request.getContextPath() %>/patientsignup.jsp">Patient</a></li>
        <li class="right"><a href="<%= request.getContextPath() %>/doctorslogin.jsp">Doctor</a></li>
        <li class="right"><a href="<%= request.getContextPath() %>/authoritieslogin.jsp">Authorities</a></li>
    </ul>
</nav>
