package fr.nfan.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import fr.nfan.components.AnkiAddFact;
import fr.nfan.components.AnkiBrowserAddTags;
import fr.nfan.components.AnkiBrowserChangeModel;
import fr.nfan.components.AnkiBrowserDeleteTags;
import fr.nfan.components.AnkiBrowserFindAndReplace;
import fr.nfan.components.AnkiBrowserFindDuplicates;
import fr.nfan.components.AnkiBrowserFont;
import fr.nfan.components.AnkiBrowserGenerateCards;
import fr.nfan.components.AnkiBrowserReschedule;
import fr.nfan.components.AnkiCramMod;

public class BrowserMenuController {

	@FXML
	public void onAddTagsClick(ActionEvent event) {
		new AnkiBrowserAddTags();
	}
	
	@FXML
	public void onDeleteTagsClick(ActionEvent event) {
		new AnkiBrowserDeleteTags();
	}
	
	@FXML
	public void onAddFactClick(ActionEvent event) {
		new AnkiAddFact();
	}
	
	@FXML
	public void onGenerateCardsClick(ActionEvent event) {
		new AnkiBrowserGenerateCards();
	}
	
	@FXML
	public void onCramClick(ActionEvent event) {
		new AnkiCramMod();
	}
	
	@FXML
	public void onFindAndReplaceClick(ActionEvent event) {
		new AnkiBrowserFindAndReplace();
	}
	
	@FXML
	public void onFindDuplicatesClick(ActionEvent event) {
		new AnkiBrowserFindDuplicates();
	}
	
	@FXML
	public void onBrowserFontClick(ActionEvent event) {
		new AnkiBrowserFont();
	}
	
	@FXML
	public void onBrowserRescheduleClick(ActionEvent event) {
		new AnkiBrowserReschedule();
	}
	
	@FXML
	public void onBrowserChangeModelClick(ActionEvent event) {
		new AnkiBrowserChangeModel();
	}
	
}
