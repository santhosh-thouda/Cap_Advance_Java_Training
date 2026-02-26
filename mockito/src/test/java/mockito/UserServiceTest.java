package mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock
	UserDao daomock;
	
	@InjectMocks
	UserService service;
	
	@Test
	public void typeOfUser() {
		// create mock object
		// UserDao daomock = mock(UserDao.class);
		
		User fakeObject = new User();
		fakeObject.setId(1);
		fakeObject.setBalance(2000);
		fakeObject.setName("Allen");
		when(daomock.findById(1)).thenReturn(fakeObject);
		
		User user1 = new User();
		user1.setId(2);
		user1.setBalance(1000);
		user1.setName("Miller");
		when(daomock.findById(2)).thenReturn(user1);
		
		// UserService service = new UserService(daomock);
		
		// injecting 
		String res = service.typeOfUser(1);
		assertEquals("regular user", res);
		
		String res1 = service.typeOfUser(2);
		assertEquals("new user", res1);
	}
}