package com.mockito_prac;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class MathTestService {

	@Test
	 void testDoubleAddition() {

	      //Step 1: create a fake Object
		
		  Calculator mockc=mock(Calculator.class);
		  //step 2: tell the mock to return 
		  
		  when(mockc.add(5, 5)).thenReturn(10);
		  
		  //step 3: Inject Mock into service
		  
		  MathService service=new MathService(mockc);
		  
		  //step 4: Call method
		  int result=service.doubleAddition(5, 5);
		  //step 5: check result
		  assertEquals(20, result);
		  //step 6: verify method call
		  verify(mockc).add(5,5);
	    }
}