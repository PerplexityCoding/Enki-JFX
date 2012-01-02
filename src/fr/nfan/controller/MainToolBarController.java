package fr.nfan.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import fr.nfan.AnkiAddFact;
import fr.nfan.AnkiBrowser;
import fr.nfan.AnkiCardLayout;
import fr.nfan.AnkiGraphs;
import fr.nfan.AnkiMainFx;
import fr.nfan.AnkiMainFx.State;

public class MainToolBarController {

	@FXML
	public void onAddFactClick(ActionEvent event) {
		new AnkiAddFact();
	}
	
	@FXML
	public void onEditFactClick(ActionEvent event) {
		AnkiMainFx.changeState(State.EDIT_FACT);
	}
	
	@FXML
	public void onCardLayoutClick(ActionEvent event) {
		new AnkiCardLayout();
	}
	
	@FXML
	public void onBrowserClick(ActionEvent event) {
		new AnkiBrowser("");
	}
	
	@FXML
	public void onStudyOptionsClick(ActionEvent event) {
		AnkiMainFx.changeState(State.STUDY_OPTIONS);
	}
	
	@FXML
	public void onStatsClick(ActionEvent event) {
		new AnkiGraphs();
	}
	
	@FXML
	public void onMarkCardClick(ActionEvent event) {
	}
	
	@FXML
	public void onPlayAudioClick(ActionEvent event) {
	}
	
	@FXML
	public void onCloseClick(ActionEvent event) {
		AnkiMainFx.changeState(State.DECKS_LIST);
	}
}
