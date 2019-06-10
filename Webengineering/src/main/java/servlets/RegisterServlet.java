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
		if (!req.getParameter("password1").equalsIgnoreCase(req.getParameter("password2"))) {
			req.setAttribute("registrationUnsuccessful", "Die eingegebenen Passwörter stimmen nicht überein.");
			rd = req.getRequestDispatcher("register.jsp");
		} else {
			if (DBActions.register(req.getParameter("fname"), req.getParameter("lname"), req.getParameter("uname"), //
					req.getParameter("email"), req.getParameter("password2"))) {
				rd = req.getRequestDispatcher("index.jsp");
			} else {
				req.setAttribute("registrationUnsuccessful", "Deine Registrierung war nicht erfolgreich, Benutzername oder Email ist schon vergeben.");
				rd = req.getRequestDispatcher("register.jsp");
			}
		}
		rd.forward(req, resp);

	}

}
