package com.project.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.DAO.CashierDAO;

@WebServlet("/deleteCashier")
public class DeleteCashier extends HttpServlet {
	CashierDAO cashierDAO = new CashierDAO() ;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Retrieve admin name from session
        HttpSession session2 = req.getSession(false);
        String adminName = (session2 != null) ? (String) session2.getAttribute("adminName") : null;

        if (adminName == null) {
            // Redirect to login if session is invalid
            resp.sendRedirect("adminAuth.jsp");
        } else
        {
		int id = Integer.parseInt((String)req.getParameter("cashierId"));
        
		cashierDAO.deleteById(id);
		
		resp.sendRedirect("CashierServlet");
        }
        
        
	}
}
