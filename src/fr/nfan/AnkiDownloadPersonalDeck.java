package fr.nfan;

import java.io.IOException;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AnkiDownloadPersonalDeck extends Stage {
	
	public AnkiDownloadPersonalDeck() {
		
		try {
			Parent ankiMainRoot = FXMLLoader.load(getClass().getResource("ui/download/AnkiDownloadPersonalDeck.fxml"),
				ResourceBundle.getBundle("Anki"));
			
			Scene scene = new Scene(ankiMainRoot, 450, 300);
			
			scene.getStylesheets().add("fr/nfan/ui/css/main.css");
			
			setTitle("Download Personal Deck - Anki JFX");
			setScene(scene);
			sizeToScene();
			show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
