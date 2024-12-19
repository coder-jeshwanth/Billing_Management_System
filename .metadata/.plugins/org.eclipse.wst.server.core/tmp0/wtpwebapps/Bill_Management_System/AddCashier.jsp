<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="javax.servlet.http.HttpSession" import="com.project.entity.Cashier" import="java.util.*" %>
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
<h3>Add New Cashier</h3>
        <form action="CashierServlet" method="post">
            <label for="username">Cashier Username:</label>
            <input type="text" name="username" required><br><br>

            <label for="password">Cashier Password:</label>
            <input type="password" name="password" required><br><br>

            <button type="submit">Add Cashier</button>
        </form>
</body>
</html>