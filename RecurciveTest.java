package com.sgx.regsub.common;

public class RecurciveTest {

	public static void main(String[] args) {
		System.out.println(count8(8818));
	}

	public static int triangle(int rows) {
		System.out.println(rows);
		if (rows == 0)
			return 0;

		return rows + triangle(rows - 1);
	}

	public static int count7(int n) {
		System.out.println(n);
		if (n < 10)
			return n == 7 ? 1 : 0;
		

		return (n % 10 == 7 ? 1 : 0) + count7(n / 10);
	}

	public static int count8(int n) {
		System.out.println(n);
		if (n < 10) {
			return n == 8 ? 1 : 0;
		}

		int nextValue = (n % 10 == 8 ? 1 : 0);
		int next2Value = ((n / 10) % 10) == 8 ? 1 : 0;
		
		System.out.println(nextValue + "::" + next2Value);
		int combineValue = (nextValue == 1 && next2Value == nextValue) ? 1 : 0;

		return nextValue + combineValue + count8(n / 10);
	}

}
