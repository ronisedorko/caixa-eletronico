package br.edu.utfpr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.utfpr.model.entity.Role;
import br.edu.utfpr.model.entity.User;
import br.edu.utfpr.model.service.UserService;
import br.edu.utfpr.util.Constants;
import br.edu.utfpr.util.JPAUtil;
import br.edu.utfpr.util.Sha256Generator;

@WebServlet("/inicializar-banco")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	UserService userService = new UserService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JPAUtil.generateSchema();
		
		String password = "admin";
		final String hashed = Sha256Generator.generate(password);
		User admin = new User("admin", "admin@gmail.com", hashed);
		
		Role role = new Role(admin.getEmail(), Constants.ADMIN);
		userService.saveUserAndRole(admin, role);
	}

}
