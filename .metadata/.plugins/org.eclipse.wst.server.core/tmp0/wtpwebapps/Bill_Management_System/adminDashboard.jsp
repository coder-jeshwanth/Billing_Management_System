<%@ page import="javax.servlet.http.HttpSession" import="com.project.entity.Cashier" import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
        }
        .logout-btn {
            background-color: #f44336; /* Red button */
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-align: center;
            display: block;
            margin: 20px auto;
            width: 100px;
        }
        .logout-btn:hover {
            background-color: #d32f2f;
        }
    </style>
</head>
<body>
    <div class="container">
        <%
            // Retrieve admin name from session
            HttpSession session2 = request.getSession(false);
            String adminName = (session2 != null) ? (String) session2.getAttribute("adminName") : null;

            if (adminName == null) {
                // Redirect to login if session is invalid
                response.sendRedirect("adminAuth.jsp");
            }
        %>

        <h1>Welcome, <%= adminName %></h1>

        <!-- Logout Button -->
        <form action="LogoutServlet" method="post">
            <button  class="logout-btn">Logout</button>
        </form>

        <h2>Manage Cashiers</h2>
        <a href="CashierServlet">View Cashier List</a><br><br>
        <a href="AddCashier.jsp">Add Cashier List</a><br><br>

        
    </div>
</body>
</html>
