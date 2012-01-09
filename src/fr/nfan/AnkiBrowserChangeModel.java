package fr.nfan;

import java.io.IOException;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AnkiBrowserChangeModel extends Stage {
	
	public AnkiBrowserChangeModel() {
		
		try {
			Parent ankiMainRoot = FXMLLoader.load(getClass().getResource("/fr/nfan/ui/browser/AnkiBrowserChangeModel.fxml"),
				ResourceBundle.getBundle("Anki"));
			
			Scene scene = new Scene(ankiMainRoot, 300, 250);
			
			scene.getStylesheets().add("fr/nfan/ui/css/main.css");
			
			setTitle("Change Model - Anki JFX");
			setScene(scene);
			sizeToScene();
			show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
