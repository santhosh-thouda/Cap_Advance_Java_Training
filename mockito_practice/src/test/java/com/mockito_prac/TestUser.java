package com.mockito_prac;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class TestUser {

	
	@Test
	void testPremiumUser() {
		
		UserRepository mockRepo = mock(UserRepository.class);
		
		User fakeuser=new User(2,"Allen",20000);
		
		when(mockRepo.findById(2)).thenReturn(fakeuser);
		
		
		
		UserService service=new UserService(mockRepo);
		
		String result=service.checkPremiumUser(2);
		
		assertEquals("PREMIUM USER", result);
		
	}

}