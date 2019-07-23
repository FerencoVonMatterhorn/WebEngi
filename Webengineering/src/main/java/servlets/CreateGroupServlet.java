package main.java.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.util.GroupUtil;

@SuppressWarnings("serial")
@WebServlet("/official/createGroup")
public class CreateGroupServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String groupName = req.getParameter("groupName");
		String groupDescription = req.getParameter("groupDescription");
		String groupParticipants = req.getParameter("groupParticipants");
		int userID = (int) req.getSession().getAttribute("userID");
		GroupUtil.createGroup(groupName, groupDescription, groupParticipants, userID);
		resp.sendRedirect(req.getContextPath() + "/official/IndexLoggedIn");
	}

}
