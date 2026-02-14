package learn_jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.connectdatabase.EvenOrOdd;
import com.connectdatabase.Program;


public class ProgramTest {
	@ParameterizedTest
	@ValueSource(strings = {"tenet", "radar", "aba", "abcd"})
	public void isPalindrome(String str) {
		assertTrue(Program.isPalindrome(str));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1,-1,3,4,5})
	public void checkPositive(int n) {
		assertTrue(Program.checkPositive(n));
	}
	
	
	@ParameterizedTest
	@CsvSource({
		"1,2,3",
		"5,5,10",
		"5,3,7"
	})
	public void addTest(int a, int b, int expectedResult) {
		Program p = new Program();
		assertEquals(expectedResult, p.add(a, b));
	}
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/capgemini.csv", numLinesToSkip = 1)
	public void evenOrOddTest(String input, String expected) {
	    EvenOrOdd eoo = new EvenOrOdd();
	    String actualRes = eoo.evenOrOdd(Integer.parseInt(input));
	    assertEquals(expected, actualRes);
	}
}