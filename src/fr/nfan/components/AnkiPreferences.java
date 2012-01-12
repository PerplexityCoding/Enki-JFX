package fr.nfan.components;

import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.nfan.services.AnkiPreferencesService;


public class AnkiPreferences extends AnkiJFXComponent {
	
	public static Logger log = LoggerFactory.getLogger(AnkiPreferences.class);
	
	private ChoiceBox<String> language = null;
	private CheckBox showDividerQA = null;
	private CheckBox putSpaceQA = null;
	private CheckBox showNextTime = null;
	private CheckBox showDueCount = null;
	private CheckBox preventEdits = null;
	private CheckBox automaticalPlayAudio = null;
	private ChoiceBox<String> mediaWhere = null;

	private TextField ankiWebUsername = null;
	private PasswordField ankiWebPassword = null;
	private CheckBox syncDeckOpenClose = null;
	private CheckBox syncProgramOpenClose = null;
	private CheckBox disableSyncWhenMoved = null;
	private TextField proxyHost = null;
	private TextField proxyPort = null;
	private TextField proxyUsername = null;
	private PasswordField proxyPassword = null;
	
	private CheckBox saveAfterAnswering = null;
	private TextField saveAfterAnsweringCards = null;
	private CheckBox saveAfterAdding = null;
	private TextField saveAfterAddingCards = null;
	private CheckBox saveAfterClosing = null;
	private TextField howManyBackups = null;
	
	private CheckBox alternativeThemes = null;
	private CheckBox colourNextTimes = null;
	private CheckBox showTimer = null;
	private CheckBox showTrayIcon = null;
	private CheckBox stripHTML = null;
	private CheckBox showStudyOptions = null;
	private CheckBox openLastDeck = null;
	private CheckBox showDecksWithCardsFirst = null;
	private CheckBox optimizeForSmallScreen = null;
	private CheckBox deleteOriginalMediaOnAdd = null;
	private CheckBox addHidderCharToText = null;
	private TextField maxDeckNameLength = null;
	
	public AnkiPreferences() {
		super("preferences/AnkiPreferences.fxml", "Preferences - Anki JFX", 300, 360);
		initComponents();
		loadProperties();
	}
	
	@SuppressWarnings("unchecked")
	public void initComponents() {
		Node ankiPreferencesBasic = root.lookup("#ankiPreferencesBasic");
		language = (ChoiceBox<String>) ankiPreferencesBasic.lookup("#language");
		showDividerQA = (CheckBox) ankiPreferencesBasic.lookup("#showDividerQA");
		putSpaceQA = (CheckBox) ankiPreferencesBasic.lookup("#putSpaceQA");
		showNextTime = (CheckBox) ankiPreferencesBasic.lookup("#showNextTime");
		showDueCount = (CheckBox) ankiPreferencesBasic.lookup("#showDueCount");
		preventEdits = (CheckBox) ankiPreferencesBasic.lookup("#preventEdits");
		automaticalPlayAudio = (CheckBox) ankiPreferencesBasic.lookup("#automaticalPlayAudio");
		mediaWhere = (ChoiceBox<String>) ankiPreferencesBasic.lookup("#mediaWhere");
		
		Node ankiPreferencesNetwork = root.lookup("#ankiPreferencesNetwork");
		ankiWebUsername = (TextField) ankiPreferencesNetwork.lookup("#ankiWebUsername");
		ankiWebPassword = (PasswordField) ankiPreferencesNetwork.lookup("#ankiWebPassword");
		syncDeckOpenClose = (CheckBox) ankiPreferencesNetwork.lookup("#syncDeckOpenClose");
		syncProgramOpenClose = (CheckBox) ankiPreferencesNetwork.lookup("#syncProgramOpenClose");
		disableSyncWhenMoved = (CheckBox) ankiPreferencesNetwork.lookup("#disableSyncWhenMoved");
		proxyHost = (TextField) ankiPreferencesNetwork.lookup("#proxyHost");
		proxyPort = (TextField) ankiPreferencesNetwork.lookup("#proxyPort");
		proxyUsername = (TextField) ankiPreferencesNetwork.lookup("#proxyUsername");
		proxyPassword = (PasswordField) ankiPreferencesNetwork.lookup("#proxyPassword");
		
		Node ankiPreferencesSaving = root.lookup("#ankiPreferencesSaving");
		saveAfterAnswering = (CheckBox) ankiPreferencesSaving.lookup("#saveAfterAnswering");
		saveAfterAnsweringCards = (TextField) ankiPreferencesSaving.lookup("#saveAfterAnsweringCards");
		saveAfterAdding = (CheckBox) ankiPreferencesSaving.lookup("#saveAfterAdding");
		saveAfterAddingCards = (TextField) ankiPreferencesSaving.lookup("#saveAfterAddingCards");
		saveAfterClosing = (CheckBox) ankiPreferencesSaving.lookup("#saveAfterClosing");
		howManyBackups = (TextField) ankiPreferencesSaving.lookup("#howManyBackups");
		
		Node ankiPreferencesAdvanced = root.lookup("#ankiPreferencesAdvanced");
		alternativeThemes = (CheckBox) ankiPreferencesAdvanced.lookup("#alternativeThemes");
		colourNextTimes = (CheckBox) ankiPreferencesAdvanced.lookup("#colourNextTimes");
		showTimer = (CheckBox) ankiPreferencesAdvanced.lookup("#showTimer");
		showTrayIcon = (CheckBox) ankiPreferencesAdvanced.lookup("#showTrayIcon");
		stripHTML = (CheckBox) ankiPreferencesAdvanced.lookup("#stripHTML");
		showStudyOptions = (CheckBox) ankiPreferencesAdvanced.lookup("#showStudyOptions");
		openLastDeck = (CheckBox) ankiPreferencesAdvanced.lookup("#openLastDeck");
		showDecksWithCardsFirst = (CheckBox) ankiPreferencesAdvanced.lookup("#showDecksWithCardsFirst");
		optimizeForSmallScreen = (CheckBox) ankiPreferencesAdvanced.lookup("#optimizeForSmallScreen");
		deleteOriginalMediaOnAdd = (CheckBox) ankiPreferencesAdvanced.lookup("#deleteOriginalMediaOnAdd");
		addHidderCharToText = (CheckBox) ankiPreferencesAdvanced.lookup("#addHidderCharToText");
		maxDeckNameLength = (TextField) ankiPreferencesAdvanced.lookup("#maxDeckNameLength");
	}
	
	public void loadProperties() {
		language.getSelectionModel().select(AnkiPreferencesService.getStringValue("basic.language"));
		showDividerQA.setSelected(AnkiPreferencesService.getBooleanValue("basic.showDividerQA"));
		putSpaceQA.setSelected(AnkiPreferencesService.getBooleanValue("basic.putSpaceQA"));
		showNextTime.setSelected(AnkiPreferencesService.getBooleanValue("basic.showNextTime"));
		showDueCount.setSelected(AnkiPreferencesService.getBooleanValue("basic.showDueCount"));
		preventEdits.setSelected(AnkiPreferencesService.getBooleanValue("basic.preventEdits"));
		automaticalPlayAudio.setSelected(AnkiPreferencesService.getBooleanValue("basic.automaticalPlayAudio"));
		mediaWhere.getSelectionModel().select(AnkiPreferencesService.getIntValue("basic.mediaWhere"));
		
		ankiWebUsername.setText(AnkiPreferencesService.getStringValue("network.ankiWebUsername"));
		ankiWebPassword.setText(AnkiPreferencesService.getStringValue("network.ankiWebPassword"));
		syncDeckOpenClose.setSelected(AnkiPreferencesService.getBooleanValue("network.syncDeckOpenClose"));
		syncProgramOpenClose.setSelected(AnkiPreferencesService.getBooleanValue("network.syncProgramOpenClose"));
		disableSyncWhenMoved.setSelected(AnkiPreferencesService.getBooleanValue("network.disableSyncWhenMoved"));
		proxyHost.setText(AnkiPreferencesService.getStringValue("network.proxyHost"));
		proxyPort.setText(AnkiPreferencesService.getStringValue("network.proxyPort"));
		proxyUsername.setText(AnkiPreferencesService.getStringValue("network.proxyUsername"));
		proxyPassword.setText(AnkiPreferencesService.getStringValue("network.proxyPassword"));
		
		saveAfterAnswering.setSelected(AnkiPreferencesService.getBooleanValue("saving.saveAfterAnswering"));
		saveAfterAnsweringCards.setText(AnkiPreferencesService.getStringValue("saving.saveAfterAnsweringCards"));
		saveAfterAdding.setSelected(AnkiPreferencesService.getBooleanValue("saving.saveAfterAdding"));
		saveAfterAddingCards.setText(AnkiPreferencesService.getStringValue("saving.saveAfterAddingCards"));
		saveAfterClosing.setSelected(AnkiPreferencesService.getBooleanValue("saving.saveAfterClosing"));
		howManyBackups.setText(AnkiPreferencesService.getStringValue("saving.howManyBackups"));
		
		alternativeThemes.setSelected(AnkiPreferencesService.getBooleanValue("advanced.alternativeThemes"));
		colourNextTimes.setSelected(AnkiPreferencesService.getBooleanValue("advanced.colourNextTimes"));
		showTimer.setSelected(AnkiPreferencesService.getBooleanValue("advanced.showTimer"));
		showTrayIcon.setSelected(AnkiPreferencesService.getBooleanValue("advanced.showTrayIcon"));
		stripHTML.setSelected(AnkiPreferencesService.getBooleanValue("advanced.stripHTML"));
		showStudyOptions.setSelected(AnkiPreferencesService.getBooleanValue("advanced.showStudyOptions"));
		openLastDeck.setSelected(AnkiPreferencesService.getBooleanValue("advanced.openLastDeck"));
		showDecksWithCardsFirst.setSelected(AnkiPreferencesService.getBooleanValue("advanced.showDecksWithCardsFirst"));
		optimizeForSmallScreen.setSelected(AnkiPreferencesService.getBooleanValue("advanced.optimizeForSmallScreen"));
		deleteOriginalMediaOnAdd.setSelected(AnkiPreferencesService.getBooleanValue("advanced.deleteOriginalMediaOnAdd"));
		addHidderCharToText.setSelected(AnkiPreferencesService.getBooleanValue("advanced.addHidderCharToText"));
		maxDeckNameLength.setText(AnkiPreferencesService.getStringValue("advanced.maxDeckNameLength"));
	}
	
	public void storePropertes() {
		AnkiPreferencesService.put("basic.language", language.getSelectionModel().getSelectedItem());
		AnkiPreferencesService.put("basic.showDividerQA", showDividerQA.isSelected());
		AnkiPreferencesService.put("basic.putSpaceQA", putSpaceQA.isSelected());
		AnkiPreferencesService.put("basic.showNextTime", showNextTime.isSelected());
		AnkiPreferencesService.put("basic.showDueCount", showDueCount.isSelected());
		AnkiPreferencesService.put("basic.preventEdits", preventEdits.isSelected());
		AnkiPreferencesService.put("basic.automaticalPlayAudio", automaticalPlayAudio.isSelected());
		AnkiPreferencesService.put("basic.mediaWhere", mediaWhere.getSelectionModel().getSelectedIndex());
		
		AnkiPreferencesService.put("network.ankiWebUsername", ankiWebUsername.getText());
		AnkiPreferencesService.put("network.ankiWebPassword", ankiWebPassword.getText());
		AnkiPreferencesService.put("network.syncDeckOpenClose", syncDeckOpenClose.isSelected());
		AnkiPreferencesService.put("network.syncProgramOpenClose", syncProgramOpenClose.isSelected());
		AnkiPreferencesService.put("network.disableSyncWhenMoved", disableSyncWhenMoved.isSelected());
		AnkiPreferencesService.put("network.proxyHost", proxyHost.getText());
		AnkiPreferencesService.put("network.proxyPort", proxyPort.getText());
		AnkiPreferencesService.put("network.proxyUsername", proxyUsername.getText());
		AnkiPreferencesService.put("network.proxyPassword", proxyPassword.getText());
		
		AnkiPreferencesService.put("saving.saveAfterAnswering", saveAfterAnswering.isSelected());
		AnkiPreferencesService.put("saving.saveAfterAnsweringCards", saveAfterAnsweringCards.getText());
		AnkiPreferencesService.put("saving.saveAfterAdding", saveAfterAdding.isSelected());
		AnkiPreferencesService.put("saving.saveAfterAddingCards", saveAfterAddingCards.getText());
		AnkiPreferencesService.put("saving.saveAfterClosing", saveAfterClosing.isSelected());
		AnkiPreferencesService.put("saving.howManyBackups", howManyBackups.getText());
		
		AnkiPreferencesService.put("advanced.alternativeThemes", alternativeThemes.isSelected());
		AnkiPreferencesService.put("advanced.colourNextTimes", colourNextTimes.isSelected());
		AnkiPreferencesService.put("advanced.showTimer", showTimer.isSelected());
		AnkiPreferencesService.put("advanced.showTrayIcon", showTrayIcon.isSelected());
		AnkiPreferencesService.put("advanced.stripHTML", stripHTML.isSelected());
		AnkiPreferencesService.put("advanced.showStudyOptions", showStudyOptions.isSelected());
		AnkiPreferencesService.put("advanced.openLastDeck", openLastDeck.isSelected());
		AnkiPreferencesService.put("advanced.showDecksWithCardsFirst", showDecksWithCardsFirst.isSelected());
		AnkiPreferencesService.put("advanced.optimizeForSmallScreen", optimizeForSmallScreen.isSelected());
		AnkiPreferencesService.put("advanced.deleteOriginalMediaOnAdd", deleteOriginalMediaOnAdd.isSelected());
		AnkiPreferencesService.put("advanced.addHidderCharToText", addHidderCharToText.isSelected());
		AnkiPreferencesService.put("advanced.maxDeckNameLength", maxDeckNameLength.getText());
		
		AnkiPreferencesService.store();
	}
	
}
