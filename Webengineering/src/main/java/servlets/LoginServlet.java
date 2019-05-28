package main.java.servlets;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.beans.UserBean;
import main.java.db.dbActions;

@WebServlet("/official/Login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Optional<UserBean> user = dbActions.login(request.getParameter("username"), request.getParameter("password"));
		RequestDispatcher rd;
		if (user.isPresent() && user.get().isLoggedIn()) {
			System.out.println("1");
			rd = request.getRequestDispatcher("indexLoggedIn.jsp");
		} else {
			System.out.println("2");
			rd = request.getRequestDispatcher("index.jsp");
			// TODO: set response message to be show at index.
		}
		rd.forward(request, response);
	}

}
