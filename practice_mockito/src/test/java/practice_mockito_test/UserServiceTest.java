package practice_mockito_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import practice_mockito.Calculator;
import practice_mockito.MathService;
import practice_mockito.UsersDao;
import practice_mockito.UsersService;

public class UserServiceTest {
	
//	@Test
	public void testGetTypeOfCustomer() {
		UsersDao userdao = new UsersDao();
		UsersService userService=new UsersService(userdao);
		String actualRes = userService.typeOfUser(1);
		assertEquals("premium user",actualRes);
	}
	
	@Test
	public void testDoubleAddition() {
//		step1 -> create Fake object 
		Calculator calmock=mock(Calculator.class);
		
//		step2 -> what mock object should return
		when(calmock.add(6,6)).thenReturn(12);
		
//		step3 -> inject the mock reference
		MathService service=new MathService(calmock);
		int res = service.doubleAddition(6 , 6);
		
		assertEquals(24,res);
		
	}
}