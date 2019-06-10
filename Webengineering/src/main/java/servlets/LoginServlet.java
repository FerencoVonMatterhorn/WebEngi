package main.java.servlets;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.db.DBActions;
import main.java.pojos.UserPojo;

@SuppressWarnings("serial")
@WebServlet("/official/Login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Optional<UserPojo> user = DBActions.login(req.getParameter("emailOrName"), req.getParameter("password"));
		if (user.isPresent()) {
			HttpSession oldSession = req.getSession(false);
			if (oldSession != null) {
				oldSession.invalidate();
			}
			HttpSession newSession = req.getSession(true);
			// Max time the user is logged in
			newSession.setMaxInactiveInterval(10 * 60);
			newSession.setAttribute("userID", user.get().getId());
			resp.sendRedirect(req.getContextPath() + "/official/IndexLoggedIn");
		} else {
			RequestDispatcher rd;
			req.setAttribute("message", "Benutzername oder Passwort ist falsch");
			rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		}

	}
}
