package main.java.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.beans.SinglePaymentBean;
import main.java.db.DBPaymentActions;
import main.java.pojos.PaymentPojo;

@SuppressWarnings("serial")
@WebServlet("/payment/SinglePayment")
public class SinglePaymentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int neededPaymentID = Integer.parseInt(req.getParameter("paymentID"));
		PaymentPojo paymentPojo = DBPaymentActions.findPaymentById(neededPaymentID);
		req.getSession().setAttribute("payment", paymentPojo);
		req.getSession().setAttribute("singlePaymentBean", new SinglePaymentBean(paymentPojo));
		RequestDispatcher dispatcher = req.getRequestDispatcher("paymentSingle.jsp");
		dispatcher.forward(req, resp);
	}
}
