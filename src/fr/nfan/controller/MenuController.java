package fr.nfan.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import fr.nfan.AnkiAddFact;
import fr.nfan.AnkiBrowser;
import fr.nfan.AnkiCardLayout;
import fr.nfan.AnkiCramMod;
import fr.nfan.AnkiDeckProperties;
import fr.nfan.AnkiDownloadPersonalDeck;
import fr.nfan.AnkiDownloadSharedDeck;
import fr.nfan.AnkiFileExport;
import fr.nfan.AnkiFileImport;
import fr.nfan.AnkiGraphs;
import fr.nfan.AnkiMainFx;
import fr.nfan.AnkiNewDeck;
import fr.nfan.AnkiMainFx.State;
import fr.nfan.AnkiPreferences;

public class MenuController {

	@FXML
	public void onOpenBrowserClick(ActionEvent event) {
		new AnkiBrowser("");
	}
	
	@FXML
	public void onExitClick(ActionEvent event) {
		
		/*
		 * Save decks
		 */
		
		/*
		 * Sync options
		 */
		
		Platform.exit();
	}
	
	@FXML
	public void onDeckPropertiesClick(ActionEvent event) {
		new AnkiDeckProperties();
	}
	
	@FXML
	public void onCardLayoutClick(ActionEvent event) {
		new AnkiCardLayout();
	}
	
	@FXML
	public void onDownloadSharedDeck(ActionEvent event) {
		new AnkiDownloadSharedDeck();
	}
	
	@FXML
	public void onGraphsClick(ActionEvent event) {
		new AnkiGraphs();
	}
	
	@FXML
	public void onImportClick(ActionEvent event) {
		new AnkiFileImport();
	}
	
	@FXML
	public void onExportClick(ActionEvent event) {
		new AnkiFileExport();
	}
	
	@FXML
	public void onCramClick(ActionEvent event) {
		new AnkiCramMod();
	}
	
	@FXML
	public void onPreferencesClick(ActionEvent event) {
		new AnkiPreferences();
	}
	
	@FXML
	public void onDownloadPersonalDeckClick(ActionEvent event) {
		new AnkiDownloadPersonalDeck();
	}
	
	@FXML
	public void onEditCurrentFactClick(ActionEvent event) {
		AnkiMainFx.changeState(State.EDIT_FACT);
	}
	
	@FXML
	public void onAddItemClick(ActionEvent event) {
		new AnkiAddFact();
	}
	
	@FXML
	public void onNewDeckClick(ActionEvent event) {
		new AnkiNewDeck();
	}
	
	@FXML
	public void onStartStudy(ActionEvent event) {
		AnkiMainFx.changeState(State.STUDY_OPTIONS);
	}
}
