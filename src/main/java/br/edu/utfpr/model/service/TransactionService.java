package br.edu.utfpr.model.service;

import br.edu.utfpr.model.dao.TransactionDAO;
import br.edu.utfpr.model.entity.Transaction;

public class TransactionService extends AbstractService<Long, Transaction> {

	public TransactionService() {
		dao = new TransactionDAO();
	}
	
}
