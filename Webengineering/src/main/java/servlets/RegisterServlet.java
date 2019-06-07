package main.java.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.db.DBActions;

@SuppressWarnings("serial")
@WebServlet("/official/Register")
public class RegisterServlet extends HttpServlet {

	public RegisterServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd;
		if (DBActions.register(req.getParameter("fname"), req.getParameter("lname"), req.getParameter("uname"), //
				req.getParameter("email"), req.getParameter("password2"))) {
			// TODO: add message reg was succesfull
			rd = req.getRequestDispatcher("index.jsp");
		} else {
			rd = req.getRequestDispatcher("register.jsp");
		}
		rd.forward(req, resp);

	}

}
