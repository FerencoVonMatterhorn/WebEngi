package main.java.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.beans.MonthlyPaymentBean;

@WebServlet("/payment/MonthlyPayment")
public class MonthlyPaymentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int userID = (int) req.getSession().getAttribute("userID");

		int monthlyPaymentID = Integer.parseInt(req.getParameter("monthlyPaymentID"));

		MonthlyPaymentBean bean = new MonthlyPaymentBean(monthlyPaymentID, userID);

		req.setAttribute("monthlyPayment", bean);

		RequestDispatcher dispatcher = req.getRequestDispatcher("monthlyPayment.jsp");

		dispatcher.forward(req, resp);
	}

}
