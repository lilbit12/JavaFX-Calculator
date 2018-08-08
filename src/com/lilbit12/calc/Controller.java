package com.lilbit12.calc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class Controller {
	
	private Model model = new Model();
	
	@FXML
	private TextField output;
	
	
	@FXML
	private void processNumpad(ActionEvent event) {
		String value = ((Button)event.getSource()).getText();
		System.out.println(value);
		output.setText(String.valueOf(value));
	}
	
	
	

}
