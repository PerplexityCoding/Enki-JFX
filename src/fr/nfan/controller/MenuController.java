package fr.nfan.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import fr.nfan.AnkiMainFx;
import fr.nfan.AnkiMainFx.State;
import fr.nfan.components.AnkiAddFact;
import fr.nfan.components.AnkiBrowser;
import fr.nfan.components.AnkiCardLayout;
import fr.nfan.components.AnkiCramMod;
import fr.nfan.components.AnkiDeckProperties;
import fr.nfan.components.AnkiDownloadPersonalDeck;
import fr.nfan.components.AnkiDownloadSharedDeck;
import fr.nfan.components.AnkiFileExport;
import fr.nfan.components.AnkiFileImport;
import fr.nfan.components.AnkiGraphs;
import fr.nfan.components.AnkiNewDeck;
import fr.nfan.components.AnkiPreferences;

public class MenuController {

	private AnkiMainFx mainFx;
	
	public MenuController() {
		this.mainFx = AnkiMainFx.getInstance();
	}
	
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
		mainFx.setPreferences(new AnkiPreferences());
	}
	
	@FXML
	public void onDownloadPersonalDeckClick(ActionEvent event) {
		new AnkiDownloadPersonalDeck();
	}
	
	@FXML
	public void onEditCurrentFactClick(ActionEvent event) {
		mainFx.changeState(State.EDIT_FACT);
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
		mainFx.changeState(State.STUDY_OPTIONS);
	}
}
