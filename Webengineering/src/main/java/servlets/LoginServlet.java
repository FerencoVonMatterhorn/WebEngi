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

	public LoginServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Optional<UserPojo> user = DBActions.login(req.getParameter("emailOrName"), req.getParameter("password"));
		RequestDispatcher rd;
		if (user.isPresent()) {
			HttpSession oldSession = req.getSession(false);
			if (oldSession != null) {
				oldSession.invalidate();
			}
			HttpSession newSession = req.getSession(true);
			newSession.setMaxInactiveInterval(10 * 60);
			newSession.setAttribute("userID", user.get().getId());
			newSession.setAttribute("userName", user.get().getUsername());

			req.setAttribute("userPojo", user.get());
			rd = req.getRequestDispatcher("indexLoggedIn.jsp");
		} else {
			req.setAttribute("message", "Benutzername oder Passwort ist falsch");
			rd = req.getRequestDispatcher("index.jsp");
		}
		rd.forward(req, resp);
	}

}
