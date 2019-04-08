package com.rjm.exception;

public class Example2 {

	public void ex2() {
		// 어린이집
		int num = 52;
		int num2 = 28;
		int result1 = num + num2;
		int result2 = num - num2;

		try {
			if (result1 > 99 || result2 < 0) {
				throw new MyException();
			}
		} catch (Exception e) {
			System.out.println("3자리 몰라요");
		}

	}

}
