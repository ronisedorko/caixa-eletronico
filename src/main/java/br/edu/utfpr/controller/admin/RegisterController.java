package br.edu.utfpr.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.utfpr.model.entity.Account;
import br.edu.utfpr.model.entity.Role;
import br.edu.utfpr.model.entity.User;
import br.edu.utfpr.model.service.UserService;
import br.edu.utfpr.util.Constants;
import br.edu.utfpr.util.Sha256Generator;

@WebServlet("/admin/cadastro")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserService userService = new UserService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/WEB-INF/view/admin/register.jsp";

		if(request.getParameter("error") != null) {
			address += "?error";
		}
		
		request.getRequestDispatcher(address).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		boolean isSuccess = validation(name, password);

		if (isSuccess) {
			final String hashed = Sha256Generator.generate(password);
			User user = new User("user", name, hashed);
			
			Account account = new Account("46656","46565",0L);			
			user.setAccount(account);
			
			Role role = new Role(user.getEmail(), Constants.USER);
			userService.saveUserAndRole(user, role);
			
			String address = request.getContextPath() + "/admin/lista";
			response.sendRedirect(address);
		} else {
			response.sendRedirect("cadastro?error");
		}
	}
	
	private boolean validation(String name, String password) {
		if(name == null || name.isEmpty()) {
			return false;
		}
		
		if(password == null || password.isEmpty()) {
			return false;
		}
		
		return true;
	}

}
