package main.java.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.beans.SingleGroupBean;
import main.java.db.DBActions;
import main.java.db.DBGroupActions;
import main.java.pojos.GroupPojo;

@SuppressWarnings("serial")
@WebServlet("/group/singlegroup")
public class SingleGroupServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		GroupPojo group = DBActions
				.getUsersToGroup(DBGroupActions.findGroupById(Integer.parseInt(req.getParameter("groupID"))));
		SingleGroupBean singleBean = new SingleGroupBean(group.getGroupID());
		singleBean.setName(group.getGroupName());
		singleBean.setDescription(group.getGroupDescription());
		singleBean.setUsers(group.getUsers());

		req.setAttribute("singleGroup", singleBean);
		RequestDispatcher dispatcher = req.getRequestDispatcher("groupSingle.jsp");
		dispatcher.forward(req, resp);
	}

}
