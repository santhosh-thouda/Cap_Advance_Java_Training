package com.connectdatabase;

public class Program {
	public static boolean isPalindrome(String str) {
		StringBuilder s = new StringBuilder(str);
		return (s.reverse().toString().equals(str)) ? true : false;
	}
	
	public static boolean checkPositive(int n) {
		if(n > 0)return true;
		else return false;
	}
	
	public int add(int a, int b) {
		return a+b;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("tenet"));
	}
}
