package fr.nfan.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import fr.nfan.AnkiAddFact;
import fr.nfan.AnkiBrowserAddTags;
import fr.nfan.AnkiBrowserChangeModel;
import fr.nfan.AnkiBrowserDeleteTags;
import fr.nfan.AnkiBrowserFindAndReplace;
import fr.nfan.AnkiBrowserFindDuplicates;
import fr.nfan.AnkiBrowserFont;
import fr.nfan.AnkiBrowserGenerateCards;
import fr.nfan.AnkiBrowserReschedule;
import fr.nfan.AnkiCramMod;

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
