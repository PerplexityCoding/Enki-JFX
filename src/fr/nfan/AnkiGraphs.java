package fr.nfan;

import java.io.IOException;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AnkiGraphs extends Stage {
	
	public AnkiGraphs() {
		try {
			Parent ankiMainRoot = FXMLLoader.load(getClass().getResource("/fr/nfan/ui/graphs/AnkiGraphs.fxml"),
				ResourceBundle.getBundle("Anki"));
			
			Scene scene = new Scene(ankiMainRoot, 700, 500);
			
			scene.getStylesheets().add("fr/nfan/ui/css/main.css");
			
			setTitle("Anki JFX - Graphs");
			setScene(scene);
			sizeToScene();
			show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
