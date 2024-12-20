package com.project.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.DAO.AdminDAO;
import com.project.entity.Admin;

@WebServlet("/AdminSigninServlet")
public class AdminSigninServlet extends HttpServlet {
    private AdminDAO adminDAO = new AdminDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Admin admin = adminDAO.findByUsername(username);

        if (admin != null && admin.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", admin);
            
            session.setAttribute("adminName", admin.getUsername());

            // Redirect to dashboard
            response.sendRedirect("adminDashboard.jsp");
        } else {
        	// Set an error message for invalid credentials
            request.setAttribute("signinErrorMessage", "Invalid username or password.");
            request.getRequestDispatcher("adminAuth.jsp").forward(request, response);
        }
    }
}
