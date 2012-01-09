package fr.nfan;

import java.io.IOException;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AnkiBrowserFindDuplicates extends Stage {
	
	public AnkiBrowserFindDuplicates() {
		
		try {
			Parent ankiMainRoot = FXMLLoader.load(getClass().getResource("/fr/nfan/ui/browser/AnkiBrowserFindDuplicates.fxml"),
				ResourceBundle.getBundle("Anki"));
			
			Scene scene = new Scene(ankiMainRoot, 400, 300);
			
			scene.getStylesheets().add("fr/nfan/ui/css/main.css");
			
			setTitle("Find Duplicates - Anki JFX");
			setScene(scene);
			sizeToScene();
			show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
