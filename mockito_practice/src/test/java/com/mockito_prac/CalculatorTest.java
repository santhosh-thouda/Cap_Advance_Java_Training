package com.mockito_prac;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

	// @Test
	public void addTest() {
		Calculator c = mock(Calculator.class);

		when(c.add(10, 20)).thenReturn(100);

		assertEquals(100, c.add(10, 20));
	}

	@Test
	public void addTest1() {
		Calculator c = mock(Calculator.class);

		when(c.add(anyInt(), anyInt())).thenReturn(100);

		assertEquals(100, c.add(20, 20));
		
		verify(c).add(20,20);
	}
}