package main.java.servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.beans.GroupOverViewBean;
import main.java.db.DBGroupActions;
import main.java.pojos.GroupPojo;
import main.java.util.ActionUtil;

@SuppressWarnings("serial")
@WebServlet("/group/groupOverview")
public class GroupOverviewServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		RequestDispatcher rd;
		int userID = (int) req.getSession().getAttribute("userID");
		GroupOverViewBean gOBean = new GroupOverViewBean();
		List<GroupPojo> groups = DBGroupActions.findAllGroupsByUserID(userID);
		Collections.reverse(groups);
		gOBean.setGroups(groups);
		for (GroupPojo group : gOBean.getGroups()) {
			group.setUsers(ActionUtil.addUsersToGroupPojo(group).getUsers());
		}
		req.setAttribute("groupOverView", gOBean);
		rd = req.getRequestDispatcher("groupOverview.jsp");
		rd.forward(req, resp);
	}
}