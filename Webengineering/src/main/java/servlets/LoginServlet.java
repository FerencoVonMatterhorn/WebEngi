package main.java.servlets;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.db.DBActions;
import main.java.pojos.UserPojo;

@SuppressWarnings("serial")
@WebServlet("/official/Login")
public class LoginServlet extends HttpServlet {

	public LoginServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Optional<UserPojo> user = DBActions.login(request.getParameter("username"), request.getParameter("password"));
		RequestDispatcher rd;
		if (user.isPresent() && user.get().isLoggedIn()) {
			// TODO: add bean to jsp
			rd = request.getRequestDispatcher("indexLoggedIn.jsp");
		} else {
			// TODO: add mesage login was NOT successfull
			rd = request.getRequestDispatcher("index.jsp");
		}
		rd.forward(request, response);
	}

}
