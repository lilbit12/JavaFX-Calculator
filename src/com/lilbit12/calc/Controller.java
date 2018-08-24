package com.lilbit12.calc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Button;

public class Controller {


	private String operator ="";
	private double number1 = 0;
	private boolean start = true;
	private String[] numbers = {"1","2","3","4","5","6","7","8","9","0",","};
	private String[] operators = {"/", "*", "-", "+"};

	private Model model = new Model();

	@FXML
	private TextField output;


	@FXML
	private void processNumpad(ActionEvent event) {

		if (start) {
			output.setText("");
			start = false;
		}

		String value = ((Button)event.getSource()).getText();
		String tmp = output.getText();
		start = false;

		if (!output.getText().equals("0")) {
			output.setText(tmp.concat(value));
		} else {
			if (value.equals(",")) {
				output.setText(tmp.concat(value));
			} else {
				output.setText(value);
			}
		}

		if (value.equals(",")) {
			output.setText(tmp.concat("."));
		}

	}

	@FXML
	private void processButtonOperator(ActionEvent event) {


		String value = ((Button)event.getSource()).getText();

		if(!"=".equals(value)) {
			if (!operator.isEmpty())
				return;


			operator = value;
			number1 = Double.parseDouble(output.getText());
			output.setText("");
		} else {
			if (operator.isEmpty())
				return;

			output.setText(String.valueOf((model.caclulate(number1, Double.parseDouble(output.getText()), operator))));
			operator = "";
			start = false;

		}
	}


	private void clearOperations() {

			number1 = 0;
			operator = "";

			output.setText("0");
		}



	@FXML
	private void processKeys(KeyEvent event) {

		if (event.getCode() == KeyCode.DELETE){
			clearOperations();
		} else if(event.getCode() == KeyCode.ENTER){
			output.setText(String.valueOf((model.caclulate(number1, Double.parseDouble(output.getText()), operator))));
			operator = "";
			start = false;
		}

		String tmp = event.getText();
		System.out.println(event);
		String tmp2 = event.getCode().toString();
		System.out.println(tmp2);


		for (String s : numbers) {
			if (tmp.equals(s))
				processNumpad(s);
		}

		for (String s: operators){
			if (tmp.equals(s)){
				processOperator(s);
			}
		}

	}


	private void processNumpad(String value) {
		if (start) {
			output.setText("");
			start = false;
		}

		String tmp = output.getText();
		start = false;

		if (!output.getText().equals("0")) {
			output.setText(tmp.concat(value));
		} else {
			if (value.equals(",")) {
				output.setText(tmp.concat(value));
			} else {
				output.setText(value);
			}
		}

		if (value.equals(",")) {
			output.setText(tmp.concat("."));
		}
	}

	private void processOperator(String value){

		if(!"=".equals(value)) {
			if (!operator.isEmpty())
				return;


			operator = value;
			number1 = Double.parseDouble(output.getText());
			output.setText("");
		} else {
			if (operator.isEmpty())
				return;

			output.setText(String.valueOf((model.caclulate(number1, Double.parseDouble(output.getText()), operator))));
			operator = "";
			start = false;
		}
	}
}
