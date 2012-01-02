package fr.nfan;

import java.io.IOException;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AnkiAddFact extends Stage {
	
	public AnkiAddFact() {
		try {
			Parent ankiMainRoot = FXMLLoader.load(getClass().getResource("ui/browser/AnkiBrowserAddFact.fxml"),
				ResourceBundle.getBundle("Anki"));
			
			Scene scene = new Scene(ankiMainRoot, 500, 400);
			
			scene.getStylesheets().add("fr/nfan/ui/css/main.css");
			
			setTitle("Add Fact - Anki JFX");
			setScene(scene);
			sizeToScene();
			show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
