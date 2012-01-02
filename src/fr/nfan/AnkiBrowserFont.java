package fr.nfan;

import java.io.IOException;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AnkiBrowserFont extends Stage {
	
	public AnkiBrowserFont() {
		
		try {
			Parent ankiMainRoot = FXMLLoader.load(getClass().getResource("ui/browser/AnkiBrowserFont.fxml"),
				ResourceBundle.getBundle("Anki"));
			
			Scene scene = new Scene(ankiMainRoot, 300, 130);
			
			scene.getStylesheets().add("fr/nfan/ui/css/main.css");
			
			setTitle("Browser Font - Anki JFX");
			setScene(scene);
			sizeToScene();
			show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
