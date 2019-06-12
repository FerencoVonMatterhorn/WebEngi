package main.java.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.db.DBActions;
import main.java.pojos.UserPojo;

@SuppressWarnings("serial")
@WebServlet("/official/IndexLoggedIn")
public class IndexLoggedInServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd;
		UserPojo user = DBActions.findUserById((int) req.getSession().getAttribute("userID"));

		req.setAttribute("paymentPojo", DBActions.getPaymentForIndexLoggedIn(user.getId()));
		req.setAttribute("userPojo", user);
		req.setAttribute("groupPojo", DBActions.indexLoggedInGroup(user.getId()));

		rd = req.getRequestDispatcher("indexLoggedIn.jsp");
		rd.forward(req, resp);
	}

}
