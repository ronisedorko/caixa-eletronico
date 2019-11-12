package br.edu.utfpr.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.utfpr.model.entity.Account;
import br.edu.utfpr.model.entity.User;
import br.edu.utfpr.model.service.UserService;
import br.edu.utfpr.util.MoneyUtil;

@WebServlet("/user/saldo")
public class BalanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/WEB-INF/view/user/balance.jsp";

		String userName = request.getUserPrincipal().getName();
		UserService userService = new UserService();
		User user = userService.getById(userName);
		Account account = user.getAccount();
		
		request.setAttribute("balance", MoneyUtil.format(account.getBalance()));
		
		request.getRequestDispatcher(address).forward(request, response);
	}
}
