package com.prac;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
	
	// @Test
	public void addTest() {
		int res = Calculator.add(20, 30);
	}
	
	// @Test
	public void reverseTest() {
		String actualres = Calculator.reverseString("data");
		// atad  ---> tad
		assertEquals("atad", actualres);
	}
	
	// @Test
	public void reverseNull() {
		String actualres = Calculator.reverseString(null);
		assertEquals(null, actualres);
	}
	
	// @Test
	public void isPalindromeTest() {
		boolean actualres = Calculator.isPalindrome(123);
		assertEquals(false, actualres);
	}
	
	// @Test
	public void factorial() {
		int actualres = Calculator.fact(5);
		assertEquals(120, actualres);
	}
	
	@Test
	public void testValidAge1() {
		Employee e = new Employee(10, "Santhu", 20, "CSE");
		assertTrue(e.isValidAge());
	}
	
	@Test
	public void testValidAge2() {
		Employee  e = new Employee(10, "Santhu", 18, "CSE");
		assertFalse(e.isValidAge());
	} 
	
	@Test
	public void testEEx() {
	    assertThrows(ArithmeticException.class, () -> Calculator.div(10, 0));
	}
}