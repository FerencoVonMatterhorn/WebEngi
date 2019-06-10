package main.java.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.beans.SingleGroupBean;

@SuppressWarnings("serial")
@WebServlet("/group/singlegroup")
public class SingleGroupServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> users = new ArrayList<>();
		users.add("CK");
		users.add("CK2");

		SingleGroupBean singleGroupBean = new SingleGroupBean();
		singleGroupBean.setName("TestName");
		singleGroupBean.setDescription("TestDescription");
		singleGroupBean.setUsers(users);

		req.setAttribute("singleGroup", singleGroupBean);

		RequestDispatcher dispatcher;

		dispatcher = req.getRequestDispatcher("groupSingle.jsp");

		dispatcher.forward(req, resp);
	}

}
