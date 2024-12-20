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

@WebServlet("/AdminSignupServlet")
public class AdminSignupServlet extends HttpServlet {
    private AdminDAO adminDAO = new AdminDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Check if the username already exists
        if (adminDAO.findByUsername(username) != null) {
            // Redirect back to signup page with an error message
        	request.setAttribute("signupErrorMessage", "Username already exists. Please choose another one.");
            request.getRequestDispatcher("adminAuth.jsp").forward(request, response);
            return;
        }

        // If username does not exist, save the admin
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);

        adminDAO.saveAdmin(admin);

        // Set session attribute and redirect to dashboard
        HttpSession session = request.getSession();
        session.setAttribute("adminName", admin.getUsername());

        response.sendRedirect("adminDashboard.jsp");
    }
}
