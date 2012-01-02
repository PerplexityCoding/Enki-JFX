package fr.nfan;
import java.io.IOException;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AnkiMainFx extends Application {
	
	public enum State {
		DECKS_LIST,
		STUDY_OPTIONS,
		EDIT_FACT,
		STUDY,
		STUDY_RESPONSE
	}

	private static Parent root;
	
	private static State mainState;
	
	@Override
	public void start(Stage primaryStage) {
		
		
		try {
			root = FXMLLoader.load(getClass().getResource("ui/AnkiMain.fxml"),
					ResourceBundle.getBundle("Anki"));
			
			Scene scene = new Scene(root, 660, 400);
			
			
			scene.getStylesheets().add("fr/nfan/ui/css/main.css");
			
			primaryStage.setTitle("Anki JFX");
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.show();
			
			mainState = State.DECKS_LIST;
			
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
