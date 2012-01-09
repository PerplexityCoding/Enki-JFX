package fr.nfan.controller;

import fr.nfan.components.AnkiAddFact;
import fr.nfan.components.AnkiBrowserAddTags;
import fr.nfan.components.AnkiBrowserDeleteTags;
import fr.nfan.components.AnkiBrowserGenerateCards;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class BrowserToolBarController {

	@FXML
	public void onAddFactClick(ActionEvent event) {
		new AnkiAddFact();
	}
	
	@FXML
	public void onGenerateFactClick(ActionEvent event) {
		new AnkiBrowserGenerateCards();
	}
	
	@FXML
	public void onAddTagsClick(ActionEvent event) {
		new AnkiBrowserAddTags();
	}
	
	@FXML
	public void onDeleteTagsClick(ActionEvent event) {
		new AnkiBrowserDeleteTags();
	}
	
	@FXML
	public void onToogleMarkClick(ActionEvent event) {
	}
	
	@FXML
	public void onToogleSuspendClick(ActionEvent event) {
	}
	
	@FXML
	public void onDeleteClick(ActionEvent event) {
	}
	
}
