package com.mockito_prac;

public class UserService {

	  private UserRepository repository;

	    public UserService(UserRepository repository) {
	        this.repository = repository;
	    }

	    public String checkPremiumUser(int id) {

	        User user = repository.findById(id);

	        if (user == null) {
	            return "USER NOT FOUND";
	        }

	        if (user.getBalance() > 10000) {
	            return "PREMIUM USER";
	        }

	        return "NORMAL USER";
	    }
}