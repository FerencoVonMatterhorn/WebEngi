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
import main.java.pojos.GroupPojo;

@SuppressWarnings("serial")
@WebServlet("/group/groupOverview")
public class GroupOverviewServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd;
		int userID = (int) req.getSession().getAttribute("userID");
		
		GroupOverViewBean gOBean = new GroupOverViewBean();
		gOBean.setGroups(DBGroupActions.getGroupsForGroupOverview(userID));
		for (GroupPojo group: gOBean.getGroups()) {
			group.setUsers(DBActions.getUsersToGroup(group).getUsers());
		}
		System.out.println(gOBean.getGroups().get(0).getUsers());
		req.setAttribute("groupOverView", gOBean);
		// TODO: check if empty s. paymentoverview
		rd = req.getRequestDispatcher("groupOverview.jsp");
		rd.forward(req, resp);
	}

}