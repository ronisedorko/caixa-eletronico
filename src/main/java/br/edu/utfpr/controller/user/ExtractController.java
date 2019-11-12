package br.edu.utfpr.controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.utfpr.model.dto.TransactionDTO;
import br.edu.utfpr.model.entity.Transaction;
import br.edu.utfpr.model.entity.User;
import br.edu.utfpr.model.service.TransactionService;
import br.edu.utfpr.model.service.UserService;
import br.edu.utfpr.util.MoneyUtil;

@WebServlet("/user/extrato")
public class ExtractController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	TransactionService transactionService = new TransactionService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/WEB-INF/view/user/extract.jsp";
		
		String userName = request.getUserPrincipal().getName();
		UserService userService = new UserService();
		User user = userService.getById(userName);
		
		List<Transaction> transactions = transactionService.findAll();
		List<TransactionDTO> transactionDTOs = new ArrayList<>();
		
		for (Transaction transaction : transactions) {
			if (user.getAccount() == transaction.getAccount()) {
				TransactionDTO dto = new TransactionDTO(transaction.getDate(), transaction.getType(),
														MoneyUtil.format(transaction.getValue()));
				transactionDTOs.add(dto);
			}
		}
		
        request.setAttribute("transactions", transactionDTOs);
		
		request.getRequestDispatcher(address).forward(request, response);
	}

}
