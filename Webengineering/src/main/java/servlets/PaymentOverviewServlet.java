package main.java.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.beans.PaymentOverviewBean;

@SuppressWarnings("serial")
@WebServlet("/payment/paymentOverview")
public class PaymentOverviewServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		PaymentOverviewBean bean = (PaymentOverviewBean) req.getSession().getAttribute("paymentOverview");
		if (bean == null) {
			bean = new PaymentOverviewBean();
			req.getSession().setAttribute("paymentOverview", bean);
		}

		int userID = (int) req.getSession().getAttribute("userID");
		String page = req.getParameter("page");
		if (page != null) {
			bean.setShownPage(Integer.parseInt(page));
		}

		bean.calculatePages(userID);
		bean.getPaymentsForPage(userID);

		RequestDispatcher dispat = req.getRequestDispatcher("paymentOverview.jsp");

		dispat.forward(req, resp);
	}

}
