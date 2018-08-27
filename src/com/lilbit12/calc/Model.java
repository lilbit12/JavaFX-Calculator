package com.lilbit12.calc;

public class Model {

	public double caclulate(double number1, double number2, String operator) {
		switch(operator) {
		case"+":
			return (double)Math.round((number1 + number2) *100.0)/100.0;
		case "-":
			return (double)Math.round((number1 - number2) *100.0)/100.0;
		case "÷":
			if(number2 == 0)
				return 0;
			return (double)Math.round((number1 / number2) *100.0)/100.0;
		case"×":
			return (double)Math.round((number1 * number2) *100.0)/100.0;
		}


		System.out.println("Unknkown operator - " + operator);
		return 0;
	}

}

