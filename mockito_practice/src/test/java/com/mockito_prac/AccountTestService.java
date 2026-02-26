package com.mockito_prac;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class AccountTestService {

	//@Test
    void testWithdrawSuccess() {

        AccountRepository mockRepo = mock(AccountRepository.class);

        // Fake account with 5000 balance
        when(mockRepo.findById(1))
                .thenReturn(new Account(1, 5000));

        AccountService service = new AccountService(mockRepo);

        String result = service.withdraw(1, 2000);

        assertEquals("SUCCESS", result);

        // Verify updateBalance was called
        verify(mockRepo).updateBalance(1, 3000);
    }
	
	@Test
	void testDatabaseError() {

	    AccountRepository mockRepo = mock(AccountRepository.class);

	    when(mockRepo.findById(1))
	            .thenThrow(new RuntimeException("DB ERROR"));

	    AccountService service = new AccountService(mockRepo);

	    assertThrows(RuntimeException.class, () -> {
	        service.withdraw(1, 100);
	    });
	}
}