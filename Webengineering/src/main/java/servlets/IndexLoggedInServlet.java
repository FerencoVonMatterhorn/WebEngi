package main.java.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.db.DBGroupActions;
import main.java.db.DBPaymentActions;
import main.java.db.DBUserActions;
import main.java.pojos.UserPojo;

@SuppressWarnings("serial")
@WebServlet("/official/IndexLoggedIn")
public class IndexLoggedInServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		RequestDispatcher rd;
		UserPojo user = DBUserActions.findUserById((int) req.getSession().getAttribute("userID"));

		req.setAttribute("userPojo", user);
		req.setAttribute("groupPojo", DBGroupActions.findGroupForIndexLoggedInByUserId(user.getId()));
		req.setAttribute("paymentPojo", DBPaymentActions.findPaymentForIndexLoggedInByUserId(user.getId()));

		rd = req.getRequestDispatcher("indexLoggedIn.jsp");
		rd.forward(req, resp);
	}

}
