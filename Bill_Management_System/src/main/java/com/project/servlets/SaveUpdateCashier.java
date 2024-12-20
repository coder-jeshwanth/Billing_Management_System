package com.project.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.CashierDAO;

@WebServlet("/SaveUpdate")
public class SaveUpdateCashier extends HttpServlet {
	
	private CashierDAO cashierDAO = new CashierDAO();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id")); 
		String username = req.getParameter("username");
	    String password = req.getParameter("password");
	     
	     
	    cashierDAO.updatePassword(id,password);
	    
	    resp.sendRedirect("CashierServlet");
	     
	}
}
