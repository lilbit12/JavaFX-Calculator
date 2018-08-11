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
	private String[] numbers = {"1","2","3","4","5","6","7","8","9"};
	
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
	private void processOperator(ActionEvent event) {
		
		
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
		
	@FXML
	private void processFunctions(ActionEvent event) {
		String value = ((Button) event.getSource()).getText();

		if ("C".equals(value)) {
			number1 = 0;
			operator = "";

			output.setText("0");
		}
	}
	
	
	@FXML
	private void processKeys(KeyEvent event) {

		String tmp = event.getText();
		for (String s : numbers) {
			if (tmp.equals(s))
				processNumpad(s);
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
}
