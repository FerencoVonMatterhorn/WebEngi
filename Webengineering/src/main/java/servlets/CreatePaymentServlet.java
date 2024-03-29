package main.java.servlets;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.util.PaymentUtil;

@SuppressWarnings("serial")
@WebServlet("/group/createPayment")
public class CreatePaymentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Map<String, String> modalValues = new HashMap<>();
		RequestDispatcher rd;
		Enumeration<String> params = req.getParameterNames();
		while (params.hasMoreElements()) {
			String paramName = params.nextElement();
			String paramValue = req.getParameter(paramName);
			modalValues.put(paramName, paramValue);
		}
		String userId = (String) req.getSession().getAttribute("UserID");
		String groupId = req.getParameter("groupID");
		modalValues.put("userId", userId);
		modalValues.put("groupId", groupId);
		int paymentID = PaymentUtil.createPayment(modalValues);
		rd = req.getRequestDispatcher("../payment/SinglePayment?paymentID=" + paymentID);
		rd.forward(req, resp);
	}
}