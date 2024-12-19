package com.project.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.CashierDAO;
import com.project.entity.Cashier;

@WebServlet("/updateCashier")
public class UpdateCashierServlet extends HttpServlet {
    private CashierDAO cashierDAO = new CashierDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt((String)request.getParameter("cashierId"));
        
        Cashier cashier = cashierDAO.findById(id);
        request.setAttribute("cashier", cashier);
        request.getRequestDispatcher("editCashier.jsp").forward(request, response);
    }
}