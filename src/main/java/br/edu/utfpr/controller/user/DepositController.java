package br.edu.utfpr.controller.user;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.utfpr.model.entity.Account;
import br.edu.utfpr.model.entity.Transaction;
import br.edu.utfpr.model.entity.User;
import br.edu.utfpr.model.service.AccountService;
import br.edu.utfpr.model.service.TransactionService;
import br.edu.utfpr.model.service.UserService;
import br.edu.utfpr.util.Constants;
import br.edu.utfpr.util.MoneyUtil;

@WebServlet("/user/deposito")
public class DepositController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/WEB-INF/view/user/deposit.jsp";
		request.getRequestDispatcher(address).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deposit = request.getParameter("deposit");
		Long depositValue = MoneyUtil.toLong(new Float(deposit));
		
		if (depositValue < 0) {
			throw new ServletException();
		}
		
		String userName = request.getUserPrincipal().getName();
		UserService userService = new UserService();
		User user = userService.getById(userName);
		Account account = user.getAccount();
		account.setBalance(depositValue + account.getBalance());
		AccountService accountService = new AccountService();
		accountService.update(account);
		
		Transaction transaction = new Transaction(new Date(), Constants.CREDIT, depositValue, account);
		TransactionService transactionService = new TransactionService();
		transactionService.save(transaction);
		
		String address = request.getContextPath() + "/user/deposito?sucess";
		response.sendRedirect(address);
	}
	
}
