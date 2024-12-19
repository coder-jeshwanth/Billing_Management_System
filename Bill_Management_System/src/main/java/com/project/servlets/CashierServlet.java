package com.project.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.DAO.CashierDAO;
import com.project.entity.Cashier;

@WebServlet("/CashierServlet")
public class CashierServlet extends HttpServlet {
    private CashierDAO cashierDAO = new CashierDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cashier> cashiers = cashierDAO.findAll();
        request.setAttribute("cashiers", cashiers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cashierList.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Cashier cashier = new Cashier();
        cashier.setUsername(username);
        cashier.setPassword(password);

        cashierDAO.saveCashier(cashier);

        response.sendRedirect("adminDashboard.jsp");
    }
}