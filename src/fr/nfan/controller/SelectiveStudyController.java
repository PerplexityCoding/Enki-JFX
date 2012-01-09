package fr.nfan.controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class SelectiveStudyController {
	
	@FXML
	public void onlistTagActiveCheck(Event event) {
		CheckBox checkBox = (CheckBox) event.getSource();
		
		Node node = (Node) checkBox.getParent().lookup("#listTagActive");
		node.setDisable(! checkBox.isSelected());
	}
	
	@FXML
	public void onlistTagInactiveCheck(Event event) {
		CheckBox checkBox = (CheckBox) event.getSource();
		
		Node node = (Node) checkBox.getParent().lookup("#listTagInactive");
		node.setDisable(! checkBox.isSelected());
	}
	
	@FXML
	public void onCancelClick(Event event) {
		Button source = (Button) event.getSource();
		
		Scene scene = source.getScene();
		Stage stage = (Stage) scene.getWindow();
		
		stage.close();
	}
	
}
