package fr.nfan;

import java.io.IOException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import com.ichi2.anki.model.Deck;
import com.ichi2.anki.model.Stats;
import com.ichi2.anki.service.DeckManager;
import com.ichi2.utils.MathUtils;

import fr.nfan.components.AnkiDeckProperties;
import fr.nfan.components.AnkiPreferences;
import fr.nfan.controller.MainController;
import fr.nfan.services.AnkiPreferencesService;

public class AnkiMainFx extends Application {
	
	public enum State {
		DECKS_LIST,
		STUDY_OPTIONS,
		EDIT_FACT,
		STUDY,
		STUDY_RESPONSE
	}

	private static AnkiMainFx instance = null;
	
	private static Parent root;
	private VBox ankiMainDeck;
	private static State mainState;
	private MainController controller;
	
	private Deck activeDeck;
	
	/*
	 * Components
	 */
	private AnkiPreferences preferences;
	private AnkiDeckProperties deckProperties;
	
	public static AnkiMainFx getInstance() {
		return instance;
	}
	
	public AnkiMainFx() throws Exception {
		if (instance != null) {
			throw new Exception("this method should only called once; call getInstance to get references");
		}
		instance = this;
	}

	@Override
	public void start(Stage primaryStage) {
		
		try {
			root = FXMLLoader.load(getClass().getResource("/fr/nfan/ui/AnkiMain.fxml"),
					ResourceBundle.getBundle("strings/anki", Locale.ENGLISH));
			
			Scene scene = new Scene(root, 660, 400);
			
			scene.getStylesheets().add("fr/nfan/ui/css/main.css");
			
			primaryStage.setTitle("Anki JFX");
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.show();
			
			mainState = State.DECKS_LIST;
			
			ankiMainDeck = (VBox) root.lookup("#ankiMainDeck");
			controller = new MainController();
			
			AnkiPreferencesService.initProperties();
			
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
			//new AnkiSelectiveStudy();
			
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
			
			Deck deck = DeckManager.getDeck(ankiDeck.getValue(), false, false, DeckManager.REQUESTING_ACTIVITY_DECKPICKER, false);
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
			
			final Deck[] arrayTrick = new Deck[] {deck};
			openButton.setOnAction(new EventHandler<ActionEvent>() {
				
				private Deck deck = arrayTrick[0];
				
				@Override
				public void handle(ActionEvent event) {
					controller.onOpenDeck(event, deck);
				}
			});
			
			buttonHBox.getChildren().add(openButton);
			buttonHBox.getChildren().add(new Button("Hide"));
			buttonHBox.getChildren().add(new Button("Delete"));
			
			gridPane.add(buttonHBox, 3, i);
			
			i++;
		}
		
	}
	
	public void setStudyOptionsValues(Deck deck) {
		
		Node ankiStudyOptions = root.lookup("#ankiStudyOptions");
		
		TextField newCardsPerDay = (TextField) ankiStudyOptions.lookup("#newCardsPerDay");
		newCardsPerDay.setText(String.valueOf(deck.getNewCardsPerDay()));
		
		ChoiceBox<String> showNewCardOrder = (ChoiceBox<String>) ankiStudyOptions.lookup("#showNewCardOrder");
		showNewCardOrder.getSelectionModel().select(deck.getNewCardOrder());
		
		ChoiceBox<String> showNewCardOrderReviews = (ChoiceBox<String>) ankiStudyOptions.lookup("#showNewCardOrderReviews");
		showNewCardOrderReviews.getSelectionModel().select(deck.getNewCardSpacing());
		
		ChoiceBox<String> reviewsCardOrder = (ChoiceBox<String>) ankiStudyOptions.lookup("#reviewsCardOrder");
		reviewsCardOrder.getSelectionModel().select(deck.getRevCardOrder());
		
		ChoiceBox<String> reviewsFailedOrder = (ChoiceBox<String>) ankiStudyOptions.lookup("#reviewsFailedOrder");
		reviewsFailedOrder.getSelectionModel().select(deck.getFailedDelayedCount());
		
		Button changeNewStudyLimit = (Button) ankiStudyOptions.lookup("#changeNewStudyLimit");
		Button changeReviewStudyLimit = (Button) ankiStudyOptions.lookup("#changeReviewStudyLimit");
		
		Set<Button> changeStudyLimit = new HashSet<Button>();
		changeStudyLimit.add(changeNewStudyLimit);
		changeStudyLimit.add(changeReviewStudyLimit);
		
		for (Button button : changeStudyLimit) {
			
			final Deck[] arrayTrick = new Deck[] {deck};
			button.setOnAction(
				new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						controller.changeSelectiveStudy(event, arrayTrick[0]);
					};
				}
			);
			
		}
		
		TextField maxFailedCard = (TextField) ankiStudyOptions.lookup("#maxFailedCard");
		maxFailedCard.setText(String.valueOf(deck.getFailedCardMax()));
		
		setStudyOptionsTimeboxingValues(deck);
	}
	
	private String getDailyTime(Stats stats) {
		Double dailyTime = MathUtils.round(stats.getReviewTime() / 60, 2);
		String result = String.valueOf(dailyTime);
		if (dailyTime.doubleValue() != 0d) {
			result += "m";
		}
		
		return result;
	}
	
	public void setStudyOptionsTimeboxingValues(Deck deck) {
		Node ankiStudyOptions = root.lookup("#ankiStudyOptions");
		
		Stats todayStats = Stats.dailyStats(deck);
		Stats yesterdayStats = Stats.dailyStats(deck, 1);
		Stats globalStats = Stats.globalStats(deck);
		
		//((Label) ankiStudyOptions.lookup("#cardsDonePreviousSession")).setText();
		//((Label) ankiStudyOptions.lookup("#cardsDoneThisSession"))
		
		((Label) ankiStudyOptions.lookup("#cardsDoneYesterday")).setText(String.valueOf(yesterdayStats.getReps()));
		((Label) ankiStudyOptions.lookup("#cardsDoneToday")).setText(String.valueOf(todayStats.getReps()));
		
		((Label) ankiStudyOptions.lookup("#timeSpendYesterday")).setText(getDailyTime(yesterdayStats));
		((Label) ankiStudyOptions.lookup("#timeSpendToday")).setText(getDailyTime(todayStats));
		
		((Label) ankiStudyOptions.lookup("#reviewDueToday")).setText(String.valueOf(deck.getRevCount()));
		((Label) ankiStudyOptions.lookup("#newDueToday")).setText(String.valueOf(deck.getNewCountToday()));
		((Label) ankiStudyOptions.lookup("#newTotal")).setText(String.valueOf(deck.getNewCount(false)));
		
		((TextField) ankiStudyOptions.lookup("#sessionLimitMinutes")).setText(String.valueOf(deck.getSessionTimeLimit() / 60));
		((TextField) ankiStudyOptions.lookup("#sessionLimitQuestion")).setText(String.valueOf(deck.getSessionRepLimit()));
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
	
	public AnkiPreferences getPreferences() {
		return preferences;
	}

	public void setPreferences(AnkiPreferences preferences) {
		this.preferences = preferences;
	}
	
	public static void changeState(State state) {
		changeState(mainState, false);
		changeState(state, true);
		mainState = state;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public Deck getActiveDeck() {
		return activeDeck;
	}

	public void setActiveDeck(Deck activeDeck) {
		this.activeDeck = activeDeck;
	}

	public AnkiDeckProperties getDeckProperties() {
		return deckProperties;
	}

	public void setDeckProperties(AnkiDeckProperties deckProperties) {
		this.deckProperties = deckProperties;
	}
}
