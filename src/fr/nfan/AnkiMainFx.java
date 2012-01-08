package fr.nfan;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import com.ichi2.anki.model.Deck;
import com.ichi2.anki.service.DeckManager;

import fr.nfan.controller.MainController;

public class AnkiMainFx extends Application {
	
	public enum State {
		DECKS_LIST,
		STUDY_OPTIONS,
		EDIT_FACT,
		STUDY,
		STUDY_RESPONSE
	}

	private static Parent root;
	
	private VBox ankiMainDeck;
	
	private static State mainState;
	
	private MainController controller;
	
	@Override
	public void start(Stage primaryStage) {
		
		
		try {
			root = FXMLLoader.load(getClass().getResource("ui/AnkiMain.fxml"),
					ResourceBundle.getBundle("Anki", Locale.ENGLISH));
			
			Scene scene = new Scene(root, 660, 400);
			
			scene.getStylesheets().add("fr/nfan/ui/css/main.css");
			
			primaryStage.setTitle("Anki JFX");
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.show();
			
			mainState = State.DECKS_LIST;
			
			ankiMainDeck = (VBox) root.lookup("#ankiMainDeck");
			controller = new MainController();
			
			loadDecks();
			
			//new AnkiBrowser("");
			//new AnkiDeckProperties();
			//new AnkiCardLayout();
			//new AnkiDownloadSharedDeck();
			//new AnkiGraphs();
			//new AnkiFileImport();
			//new AnkiCramMod();
			//new AnkiFileExport();
			//new AnkiBrowserAddTags();
			//new AnkiPreferences();
			//new AnkiAddFact();
			//new AnkiBrowserFindAndReplace();
			//new AnkiBrowserFindDuplicates();
			//new AnkiBrowserFont();
			//new AnkiBrowserReschedule();
			//new AnkiBrowserChangeModel();
			//new AnkiDownloadPersonalDeck();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
	}
	
	public void loadDecks() {
		DeckManager deckManager = new DeckManager();
		Map<String, String> listAnkiDeck = deckManager.listAnkiDeck();
		
		GridPane gridPane = (GridPane) ankiMainDeck.lookup("GridPane");
		
		int i = 1;
		for (Entry<String, String> ankiDeck : listAnkiDeck.entrySet()) {
			
			Deck deck = DeckManager.getDeck(ankiDeck.getValue(), false, false, DeckManager.REQUESTING_ACTIVITY_DECKPICKER, true);
			if (deck == null) {
				// Log error
				continue;
			}
			
			Label name = new Label(ankiDeck.getKey());
			gridPane.add(name, 0, i);
			GridPane.setHgrow(name, Priority.ALWAYS);
			
			Label due = new Label(String.valueOf(deck.getDueCount()));
			gridPane.add(due, 1, i);
			
			Label newCount = new Label(String.valueOf(deck.getNewCount()));
			gridPane.add(newCount, 2, i);
			
			HBox buttonHBox = new HBox(5);
			
			Button openButton = new Button("Open");
			
			openButton.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					controller.onOpenDeck(event);
				}
			});
			
			buttonHBox.getChildren().add(openButton);
			buttonHBox.getChildren().add(new Button("Hide"));
			buttonHBox.getChildren().add(new Button("Delete"));
			
			gridPane.add(buttonHBox, 3, i);
			
			i++;
		}
		
	}
	
	public static State getMainState() {
		return mainState;
	}
	
	private static void changeState(State state, boolean visible) {
		if (state == State.DECKS_LIST) {
			root.lookup("#ankiMainDeck").setVisible(visible);
		}
			
		if (state == State.STUDY_OPTIONS) {
			root.lookup("#ankiStudyOptions").setVisible(visible);
		}
		
		if (state == State.EDIT_FACT) {
			root.lookup("#ankiEditFact").setVisible(visible);
		}
		
		if (state == State.STUDY) {
			root.lookup("#ankiMainStudyQuestion").setVisible(visible);
		}
		
		if (state == State.STUDY_RESPONSE) {
			root.lookup("#ankiMainStudyResponse").setVisible(visible);
		}
		
	}
	
	public static void changeState(State state) {
		changeState(mainState, false);
		changeState(state, true);
		mainState = state;
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
