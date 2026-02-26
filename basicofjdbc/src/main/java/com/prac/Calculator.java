package com.prac;

public class Calculator {
	public static int add(int a, int b) {
		return a+b;
	}
	
	public static String reverseString(String str) {
		String rev = "";
		
		for(int i = str.length()-1; i>=0; i--) {
			rev = rev + str.charAt(i);
		}
		return rev;
	}
	
	public static boolean isPalindrome(int n) {
		int temp = n;
		int rev = 0;
		
		while(n > 0) {
			int ld = n % 10;
			rev = rev * 10 + ld;
			n = n/10;
		}
		return temp == rev;
	}
	
	public static int fact(int n) {
		if(n == 1 || n == 0)return 1;
		return n * fact(n-1);
	}
	
	public static int div(int a, int b) {
		return a/b;
	}
}
