package fr.nfan;

import java.io.IOException;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AnkiBrowserFindAndReplace extends Stage {
	
	public AnkiBrowserFindAndReplace() {
		
		try {
			Parent ankiMainRoot = FXMLLoader.load(getClass().getResource("ui/browser/AnkiBrowserFindAndReplace.fxml"),
				ResourceBundle.getBundle("Anki"));
			
			Scene scene = new Scene(ankiMainRoot, 300, 150);
			
			scene.getStylesheets().add("fr/nfan/ui/css/main.css");
			
			setTitle("Find And Replace - Anki JFX");
			setScene(scene);
			sizeToScene();
			show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
