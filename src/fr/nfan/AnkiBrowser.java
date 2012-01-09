package fr.nfan;

import java.io.IOException;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AnkiBrowser extends Stage {
	
	public AnkiBrowser(String deckName) {
		
		try {
			Parent ankiMainRoot = FXMLLoader.load(getClass().getResource("/fr/nfan/ui/browser/AnkiBrowser.fxml"),
				ResourceBundle.getBundle("Anki"));
			
			Scene scene = new Scene(ankiMainRoot, 600, 600);
			
			scene.getStylesheets().add("fr/nfan/ui/css/main.css");
			
			setTitle("Anki JFX - Cards Browser");
			setScene(scene);
			sizeToScene();
			show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
