package main.java.servlets;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.util.UserUtil;

@SuppressWarnings("serial")
@WebServlet("/user/EditProfile")
public class EditProfileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String, String> modalValues = new HashMap<>();
		Enumeration<String> params = request.getParameterNames();
		while (params.hasMoreElements()) {
			String paramName = params.nextElement();
			String paramValue = request.getParameter(paramName);
			modalValues.put(paramName, paramValue);
		}
		modalValues.put("userID", String.valueOf(request.getSession().getAttribute("userID")));
		UserUtil.updateProfile(modalValues);
		RequestDispatcher dispatcher = request.getRequestDispatcher("profile");
		dispatcher.forward(request, response);
	}
}
