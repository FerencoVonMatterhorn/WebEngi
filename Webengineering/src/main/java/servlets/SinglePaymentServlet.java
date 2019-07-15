package main.java.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.beans.PaymentOverviewBean;
import main.java.pojos.PaymentPojo;

@WebServlet("/payment/SinglePayment")
public class SinglePaymentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getParameter("paymentID") != "") {
			System.out.println(req.getParameter("paymentID"));
		}

		PaymentOverviewBean bean = (PaymentOverviewBean) req.getSession().getAttribute("paymentOverview");

		String paymentIDString = req.getParameter("paymentID");

		int neededPaymentID = Integer.parseInt(paymentIDString);

		for (PaymentPojo payment : bean.getPayments()) {
			if (payment.getPaymentID() == neededPaymentID) {
				req.getSession().setAttribute("payment", payment);
			}
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("paymentSingle.jsp");

		dispatcher.forward(req, resp);
	}
}