package main.java.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/official/index")
public class IndexServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession oldSession = req.getSession();
		if (oldSession.getAttribute("userID") != null) {
			resp.sendRedirect(req.getContextPath() + "/official/IndexLoggedIn");
		} else {
			RequestDispatcher rd;
			rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		}
	}

}
