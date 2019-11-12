package br.edu.utfpr.model.service;

import br.edu.utfpr.model.dao.AccountDAO;
import br.edu.utfpr.model.entity.Account;

public class AccountService extends AbstractService<Long, Account> {
	
	public AccountService() {
		dao = new AccountDAO();
	}

}
