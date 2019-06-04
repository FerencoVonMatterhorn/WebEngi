package main.java.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.beans.PaymentOverviewBean;

@WebServlet("/payment/paymentOverview")
public class PaymentOverviewServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PaymentOverviewBean bean = new PaymentOverviewBean();

		req.setAttribute("paymentOverview", bean);

		RequestDispatcher dispat = req.getRequestDispatcher("paymentOverview.jsp");

		dispat.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
