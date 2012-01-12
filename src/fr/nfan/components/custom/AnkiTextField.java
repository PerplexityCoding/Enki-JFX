package fr.nfan.components.custom;

import javafx.scene.control.TextField;

public class AnkiTextField extends TextField {

	public boolean enabled;
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
		setDisable(! enabled);
	}
	
	public boolean isEnabled() {
		return enabled;
	}
}
