package fr.nfan.components.custom;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;

public class AnkiCheckBox extends CheckBox {

	private boolean unselected;
	
	public AnkiCheckBox() {
		setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				setUnselected(! isSelected());
			}
		});
	}
	
	public void setUnselected(boolean unselected) {
		this.unselected = unselected;
		
		
	}
	
	public boolean isUnselected() {
		return ! isSelected();
	}
}
