package main.java.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.beans.GroupOverViewBean;
import main.java.db.DBActions;
import main.java.db.DBGroupActions;
import main.java.db.DBUserActions;
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
		GroupOverViewBean gOBean = new GroupOverViewBean();
		int userID = (int) req.getSession().getAttribute("userID");
		gOBean.setGroups(DBGroupActions.getGroupsForGroupOverview(userID));
		rd = req.getRequestDispatcher("groupOverview.jsp");
		rd.forward(req, resp);
	}
	

}