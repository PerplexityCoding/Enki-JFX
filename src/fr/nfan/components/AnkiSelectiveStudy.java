package fr.nfan.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;

import com.ichi2.anki.model.Deck;

import fr.nfan.AnkiMainFx;


public class AnkiSelectiveStudy extends AnkiJFXComponent {

	public AnkiSelectiveStudy(Deck deck) {
		super("studyOptions/AnkiMainStudyOptionsSelectiveStudy.fxml", "Selective Study - Anki JFX", 380, 380);
		
		initOptions(deck);
		loadTags(deck);
	}
	
	public void initOptions(Deck deck) {
		
		RadioButton newCardSetting = (RadioButton) root.lookup("#newCardSetting");
		RadioButton reviewSetting = (RadioButton) root.lookup("#reviewSetting");
		RadioButton bothSetting = (RadioButton) root.lookup("#bothSetting");
		
		final Deck[] arrayTrick = new Deck[] {deck};
		EventHandler<ActionEvent> onChangeHandler = new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				loadTags(arrayTrick[0]);
			}
		};
		
		newCardSetting.setOnAction(onChangeHandler);
		reviewSetting.setOnAction(onChangeHandler);
		bothSetting.setOnAction(onChangeHandler);
	}
	
	private String[] split(String s) {
		if (s == null || s.length() == 0) {
			return new String[] {};
		}
		
		return s.split(" ");
	}
	
	public void loadTags(Deck deck) {
		RadioButton newCardSetting = (RadioButton) root.lookup("#newCardSetting");
		RadioButton reviewSetting = (RadioButton) root.lookup("#reviewSetting");
		RadioButton bothSetting = (RadioButton) root.lookup("#bothSetting");
		
		List<String> activeTags = new ArrayList<String>();
		List<String> inactiveTags = new ArrayList<String>();
		
		if (newCardSetting.isSelected() || bothSetting.isSelected()) {
			activeTags.addAll(Arrays.asList(split(deck.getVar("newActive"))));
			inactiveTags.addAll(Arrays.asList(split(deck.getVar("newInactive"))));
		}
		if (reviewSetting.isSelected() || bothSetting.isSelected()) {
			activeTags.addAll(Arrays.asList(split(deck.getVar("revActive"))));
			inactiveTags.addAll(Arrays.asList(split(deck.getVar("revInactive"))));
		}
		
		String[] tags = deck.allTags_();
		
		ListView<String> listTagActive = (ListView<String>) root.lookup("#listTagActive");
		listTagActive.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		if (! activeTags.isEmpty()) {
			listTagActive.setDisable(false);
			((CheckBox) root.lookup("#listTagActiveCheck")).setSelected(true);
		}
		
		for (int i = 0; i < tags.length; i++) {
			listTagActive.getItems().add(tags[i]);
			if (! activeTags.isEmpty() && activeTags.contains(tags[i])) {
				listTagActive.getSelectionModel().select(i);
			}
		}
		
		ListView<String> listTagInactive = (ListView<String>) root.lookup("#listTagInactive");
		listTagInactive.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		if (! inactiveTags.isEmpty()) {
			listTagInactive.setDisable(false);
			((CheckBox) root.lookup("#listTagInactiveCheck")).setSelected(true);
		}
		
		for (int i = 0; i < tags.length; i++) {
			listTagInactive.getItems().add(tags[i]);
			if (! inactiveTags.isEmpty() && inactiveTags.contains(tags[i])) {
				listTagInactive.getSelectionModel().select(i);
			}
		}
		
		
	}

}
