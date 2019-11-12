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

@WebServlet("/user/saque")
public class WithdrawController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/WEB-INF/view/user/withdraw.jsp";
		request.getRequestDispatcher(address).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String withdraw = request.getParameter("withdraw");
		Long withdrawValue = MoneyUtil.toLong(new Float(withdraw));
		
		String userName = request.getUserPrincipal().getName();
		UserService userService = new UserService();
		User user = userService.getById(userName);
		Account account = user.getAccount();
		
		if (withdrawValue > account.getBalance() || withdrawValue < 0) {
			throw new ServletException();
		}
		
		account.setBalance(account.getBalance() - withdrawValue);
		AccountService accountService = new AccountService();
		accountService.update(account);

		Transaction transaction = new Transaction(new Date(), Constants.DEBIT, withdrawValue, account);
		TransactionService transactionService = new TransactionService();
		transactionService.save(transaction);
		
		String address = request.getContextPath() + "/user/saque?sucess";
		response.sendRedirect(address);
	}
}
