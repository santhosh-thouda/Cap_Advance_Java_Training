package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.product.Calculator;

public class CalculatorTest {
	
	@Test
	public void divideTest() {
		Calculator c = new Calculator();
		int actualRes = c.divide(10, 2);
		
		assertEquals(5, actualRes);
	}
	
	@Test
	public void divideTestByZero() {
		Calculator c = new Calculator();
		int actualRes = c.divide(10, 0);
		
		assertEquals(0, actualRes);
	}
	
}