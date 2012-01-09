package fr.nfan.components;

import java.io.IOException;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AnkiBrowserDeleteTags extends Stage {
	
	public AnkiBrowserDeleteTags() {
		
		try {
			Parent ankiMainRoot = FXMLLoader.load(getClass().getResource("/fr/nfan/ui/browser/AnkiBrowserDeleteTags.fxml"),
				ResourceBundle.getBundle("Anki"));
			
			Scene scene = new Scene(ankiMainRoot, 200, 90);
			
			scene.getStylesheets().add("fr/nfan/ui/css/main.css");
			
			setTitle("Delete Tags - Anki JFX");
			setScene(scene);
			sizeToScene();
			show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
