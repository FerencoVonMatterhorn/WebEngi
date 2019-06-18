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
@WebServlet("/group/GroupOverviewServlet")
public class GroupOverviewServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd;
		UserPojo user = DBActions.findUserById((int) req.getSession().getAttribute("userID"));

		req.setAttribute("userPojo", user);

		rd = req.getRequestDispatcher("groupOverview.jsp");
		rd.forward(req, resp);
	}

}