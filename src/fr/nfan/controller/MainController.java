package fr.nfan.controller;

import java.util.prefs.Preferences;

import com.ichi2.anki.model.Deck;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import fr.nfan.AnkiMainFx;
import fr.nfan.AnkiMainFx.State;
import fr.nfan.components.AnkiPreferences;
import fr.nfan.components.AnkiSelectiveStudy;

public class MainController {

	private AnkiMainFx mainFx;
	
	public MainController() {
		this.mainFx = AnkiMainFx.getInstance();
	}
	
	@FXML
	public void onOpenDeck(ActionEvent event, Deck deck) {
		mainFx.setStudyOptionsValues(deck);
		mainFx.changeState(State.STUDY_OPTIONS);
	}
	
	@FXML
	public void onEditCart(ActionEvent event) {
		mainFx.changeState(State.EDIT_FACT);
	}
	
	@FXML
	public void onStartStudy(ActionEvent event) {
		mainFx.changeState(State.STUDY);
	}
	
	@FXML
	public void onShowResponse(ActionEvent event) {
		mainFx.changeState(State.STUDY_RESPONSE);
	}
	
	private void onResponse(ActionEvent event, int indice) {
		mainFx.changeState(State.STUDY);
	}
	
	@FXML
	public void onReponseAgain(ActionEvent event) {
		onResponse(event, 0);
	}
	
	@FXML
	public void onReponseGood(ActionEvent event) {
		onResponse(event, 1);
	}
	
	@FXML
	public void onReponseEasy(ActionEvent event) {
		onResponse(event, 2);
	}
	
	@FXML
	public void onReponseVeryEasy(ActionEvent event) {
		onResponse(event, 3);
	}
	
	@FXML
	public void cancel(ActionEvent event) {
		Button source = (Button) event.getSource();
		
		Scene scene = source.getScene();
		Stage stage = (Stage) scene.getWindow();
		
		stage.close();
	}
	
	@FXML
	public void changeSelectiveStudy(ActionEvent event, Deck deck) {
		new AnkiSelectiveStudy(deck);
	}
	
	public void savePreferences(ActionEvent event) {
		AnkiPreferences prefs = mainFx.getPreferences();
		prefs.storePropertes();
		prefs.close();
	}

}
