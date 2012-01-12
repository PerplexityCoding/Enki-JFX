package fr.nfan.components;

import java.util.HashMap;

import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import com.ichi2.anki.model.Deck;
import com.ichi2.anki.model.Model;


public class AnkiDeckProperties extends AnkiJFXComponent {

	private CheckBox synchronizeWithAnkiWeb = null;
	private TextField mediaUrl = null;
	private ListView<String> modelsList = null;
	private TextField veryHighPriority = null;
	private TextField highPriority = null;
	private TextField lowPriority = null;
	
	private TextArea latexHeader = null;
	private TextArea latexFooter = null;
	
	private TextField button1Delay = null;
	private TextField button1Multiplier = null;
	private TextField matureBonus = null;
	private TextField intialButton2Min = null;
	private TextField intialButton2Max = null;
	private TextField intialButton3Min = null;
	private TextField intialButton3Max = null;
	private TextField intialButton4Min = null;
	private TextField intialButton4Max = null;
	private TextField leechFailures = null;
	private TextField shiftMidnightBy = null;
	private TextField siblingDelayNewCard = null;
	private TextField siblingDelayReview = null;
	private CheckBox showFailedCardsEarly = null;
	private CheckBox suspendLeeches = null;
	private CheckBox perDayScheduling = null;
	
	private Deck deck;
	
	public AnkiDeckProperties(Deck deck) {
		super("deckProperties/AnkiDeckProperties.fxml", "Anki JFX - Deck Properties", 335, 385);
		if (deck == null) {
			throw new IllegalArgumentException("Deck must no be null");
		}
		this.deck = deck;
		
		initComponents();
		loadProperties();
	}
	
	@SuppressWarnings("unchecked")
	public void initComponents() {
		Node basicTab = (Node) root.lookup("#basicTab");
		
		synchronizeWithAnkiWeb = (CheckBox) basicTab.lookup("#synchronizeWithAnkiWeb");
		mediaUrl = (TextField) basicTab.lookup("#mediaUrl");
		modelsList = (ListView<String>) basicTab.lookup("#models");
		veryHighPriority = (TextField) basicTab.lookup("#veryHighPriority");
		highPriority = (TextField) basicTab.lookup("#highPriority");
		lowPriority = (TextField) basicTab.lookup("#lowPriority");
		
		Node latexTab = (Node) root.lookup("#latex");
		latexHeader = (TextArea) latexTab.lookup("#header");
		latexFooter = (TextArea) latexTab.lookup("#footer");
	
		Node advancedTab = (Node) root.lookup("#advancedTab");
		button1Delay = (TextField) advancedTab.lookup("#button1Delay");
		button1Multiplier = (TextField) advancedTab.lookup("#button1Multiplier");
		matureBonus = (TextField) advancedTab.lookup("#matureBonus");
		intialButton2Min = (TextField) advancedTab.lookup("#intialButton2Min");
		intialButton2Max = (TextField) advancedTab.lookup("#intialButton2Max");
		intialButton3Min = (TextField) advancedTab.lookup("#intialButton3Min");
		intialButton3Max = (TextField) advancedTab.lookup("#intialButton3Max");
		intialButton4Min = (TextField) advancedTab.lookup("#intialButton4Min");
		intialButton4Max = (TextField) advancedTab.lookup("#intialButton4Max");
		leechFailures = (TextField) advancedTab.lookup("#leechFailures");
		shiftMidnightBy = (TextField) advancedTab.lookup("#shiftMidnightBy");
		siblingDelayNewCard = (TextField) advancedTab.lookup("#siblingDelayNewCard");
		siblingDelayReview = (TextField) advancedTab.lookup("#siblingDelayReview");
		showFailedCardsEarly = (CheckBox) advancedTab.lookup("#showFailedCardsEarly");
		suspendLeeches = (CheckBox) advancedTab.lookup("#suspendLeeches");
		perDayScheduling = (CheckBox) advancedTab.lookup("#perDayScheduling");
	}
	
	public void loadProperties() {
		synchronizeWithAnkiWeb.setSelected(deck.getLastSync() != 0);
		mediaUrl.setText(deck.mediaDir());
		
		HashMap<Long, Model> models = Model.getModels(deck);
		for (Model m : models.values()) {
			modelsList.getItems().add(m.getName());
		}
		veryHighPriority.setText(deck.getHighPriority());
		highPriority.setText(deck.getMedPriority());
		lowPriority.setText(deck.getLowPriority());
		
		latexHeader.setText(deck.getVar("latexPre"));
		latexFooter.setText(deck.getVar("latexPost"));
		
		button1Delay.setText(String.valueOf(deck.getDelay0() / 60));
		button1Multiplier.setText(String.valueOf(deck.getDelay2() * 100));
		matureBonus.setText(String.valueOf(deck.getDelay1()));
		intialButton2Min.setText(String.valueOf(deck.getHardIntervalMin()));
		intialButton2Max.setText(String.valueOf(deck.getHardIntervalMax()));
		intialButton3Min.setText(String.valueOf(deck.getMidIntervalMin()));
		intialButton3Max.setText(String.valueOf(deck.getMidIntervalMax()));
		intialButton4Min.setText(String.valueOf(deck.getEasyIntervalMin()));
		intialButton4Max.setText(String.valueOf(deck.getEasyIntervalMax()));
		leechFailures.setText(String.valueOf(deck.getVar("leechFails")));
		shiftMidnightBy.setText(String.valueOf(deck.getUtcOffset() / 3600)); // FIXME: faux
		
		/*
		 * FIXME
		siblingDelayNewCard = (TextField) advancedTab.lookup("#siblingDelayNewCard");
		siblingDelayReview = (TextField) advancedTab.lookup("#siblingDelayReview");
		showFailedCardsEarly.setSelected(value) = (CheckBox) advancedTab.lookup("#showFailedCardsEarly");
		*/
		
		suspendLeeches.setSelected(deck.getSuspendLeeches());
		perDayScheduling.setSelected(deck.getPerDay());
	}

	public void storeProperties() {
		deck.setHighPriority(veryHighPriority.getText());
		deck.setMedPriority(highPriority.getText());
		deck.setLowPriority(lowPriority.getText());
		
		//FIXME: mediaUrl
		//FIXME: models
		
		deck.setVar("latexPre", latexHeader.getText());
		deck.setVar("latexPost", latexFooter.getText());
		
		deck.setDelay0(Long.valueOf(button1Delay.getText()) * 60l);
		deck.setDelay2(Double.valueOf(button1Multiplier.getText()) / 100d);
		deck.setDelay1(Long.valueOf(matureBonus.getText()));
		deck.setHardIntervalMin(Double.valueOf(intialButton2Min.getText()));
		deck.setHardIntervalMax(Double.valueOf(intialButton2Min.getText()));
		deck.setMidIntervalMin(Double.valueOf(intialButton3Min.getText()));
		deck.setMidIntervalMax(Double.valueOf(intialButton3Max.getText()));
		deck.setEasyIntervalMin(Double.valueOf(intialButton4Min.getText()));
		deck.setEasyIntervalMax(Double.valueOf(intialButton4Max.getText()));
		deck.setVar("leechFails", leechFailures.getText());
		
		
		//shiftMidnightBy.setText(String.valueOf(deck.getUtcOffset() / 3600)); // FIXME: faux
		/*
		 * FIXME
		siblingDelayNewCard = (TextField) advancedTab.lookup("#siblingDelayNewCard");
		siblingDelayReview = (TextField) advancedTab.lookup("#siblingDelayReview");
		showFailedCardsEarly.setSelected(value) = (CheckBox) advancedTab.lookup("#showFailedCardsEarly");
		*/
		
		deck.setSuspendLeeches(suspendLeeches.isSelected());
		deck.setPerDay(perDayScheduling.isSelected());
		
		deck.commitToDB();
	}
	
}
