package com.lilbit12.calc;

public class Model {
	
	public long caclulate(long number1, long number2, char operator) {
		switch(operator) {
		case'+':
			return number1 + number2;
		case '-':
			return number1 - number2;
		}
		
		System.out.println("Unknkown operator - " + operator);
		return 0;
	}

}
