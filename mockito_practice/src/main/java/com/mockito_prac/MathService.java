package com.mockito_prac;

public class MathService {

	private Calculator calculator;

    public MathService(Calculator calculator) {
        this.calculator = calculator;
    }

    public int doubleAddition(int a, int b) {
        int result = calculator.add(a, b);
        return result * 2;
    }
}