package br.edu.utfpr.model.dto;

public class AccountDTO {

    private String agency;
	private String account;
	private Long balance;
	
	public AccountDTO() {
		
	}
	
	public AccountDTO(String agency, String account, Long balance) {
		this.agency = agency;
		this.account = account;
		this.balance = balance;
	}
	
	public String getAgency() {
		return agency;
	}
	
	public void setAgency(String agency) {
		this.agency = agency;
	}
	
	public String getAccount() {
		return account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	
	public Long getBalance() {
		return balance;
	}
	
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	
}
