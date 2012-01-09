package fr.nfan.components;

import java.io.IOException;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AnkiJFXComponent extends Stage {

	protected Parent root;
	
	private final static String uiRootPath = "/fr/nfan/ui/";
	
	public AnkiJFXComponent(String uiPath, String title, int width, int height) {
		try {
			root = FXMLLoader.load(getClass().getResource(uiRootPath + uiPath),
				ResourceBundle.getBundle("Anki"));
			
			Scene scene = new Scene(root, width, height);
			
			scene.getStylesheets().add("fr/nfan/ui/css/main.css");
			
			setTitle(title);
			setScene(scene);
			sizeToScene();
			show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
