<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.*" import="com.project.entity.Cashier" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
            // Retrieve admin name from session
            HttpSession session2 = request.getSession(false);
            String adminName = (session2 != null) ? (String) session2.getAttribute("adminName") : null;

            if (adminName == null) {
                // Redirect to login if session is invalid
                response.sendRedirect("adminAuth.jsp");
            }
        %>
<% Cashier cashier = (Cashier)request.getAttribute("cashier");%>
<h3>Update Cashier</h3>
        <form action="SaveUpdate" method="post">
        	<label for="id">Cashier Id:</label>
            <input type="text" value="<%=cashier.getId()%>" name="id" readonly="true" required ><br><br>
            <label for="username">Cashier Username:</label>
            <input type="text" value="<%=cashier.getUsername()%>" name="username" readonly="true" required><br><br>

            <label for="password">Cashier Password:</label>
            <input type="text" value="<%=cashier.getPassword()%>" name="password" required><br><br>

            <button type="submit">Update Cashier</button>
        </form>
</body>
</html>