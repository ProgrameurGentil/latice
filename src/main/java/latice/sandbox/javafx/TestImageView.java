package latice.sandbox.javafx;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class TestImageView extends Application{
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		File file = new File(getClass().getResource("/tuiles/fleurs/fleur_bleu.png").toString());
		
		Image image = new Image(file.toURI().toURL().toString());
		ImageView imageview = new ImageView(image);
		
		System.out.println("Lien de l'image avec Image : " + image.getUrl());
		System.out.println("Lien de l'image avec ImageView : " + imageview.getImage().getUrl());
		try {
			Scene scene = new Scene(null);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			System.out.println();
		}
		
		
	}
}
