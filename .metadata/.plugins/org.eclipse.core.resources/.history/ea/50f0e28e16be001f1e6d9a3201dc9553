<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.*" import="com.project.entity.Cashier" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cashier List</title>
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
    <h1>Cashier List</h1>
    <table border="1">
        <%
            List<Cashier> cashiers = (List<Cashier>) request.getAttribute("cashiers");
            if (cashiers != null) {
        %>
        <tr>
            	<th>id</th>
            	<th>userName</th>
            	<th>password</th>
            	<th>update</th>
            	<th>delete</th>
            	</tr>
        <%    	
                for (Cashier cashier : cashiers) {
        %>
        <tr>
            <td><%= cashier.getId() %></td>
            <td><%= cashier.getUsername() %></td>
            <td><%= cashier.getPassword() %></td>
            <td><a href="updateCashier?cashierId=<%=cashier.getId()%>">Update</a></td>
			 <td><a href="deleteCashier?cashierId=<%=cashier.getId()%>">Delete</a></td>
            
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="2">No cashiers found.</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
