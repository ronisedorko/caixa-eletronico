package br.edu.utfpr.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.utfpr.util.Constants;

@WebServlet(urlPatterns = {"/", "/login"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/WEB-INF/view/login.jsp";
		
		if(request.getParameter("error") != null) {
			address += "?error";
		}
		
		request.getRequestDispatcher(address).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			request.login(username, password);
			
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			
			Cookie cookie = new Cookie("username", username);
			cookie.setMaxAge(-1);
			response.addCookie(cookie);
			
			String address = request.getContextPath() + "/user";
			if(request.isUserInRole(Constants.ADMIN)) {
				address = request.getContextPath() + "/admin/lista";
			}		
			
			response.sendRedirect(address);
		}
		catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/login?error");			
		}
		
	}

}