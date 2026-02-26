package com.mockito_prac;


public class AccountService {

	 private AccountRepository repository;

	    public AccountService(AccountRepository repository) {
	        this.repository = repository;
	    }

	    public String withdraw(int id, double amount) {

	        Account account = repository.findById(id);

	        if (account == null) {
	            return "ACCOUNT NOT FOUND";
	        }

	        if (account.getBalance() < amount) {
	            return "INSUFFICIENT FUNDS";
	        }

	        double newBalance = account.getBalance() - amount;

	        repository.updateBalance(id, newBalance);

	        return "SUCCESS";
	    }
}