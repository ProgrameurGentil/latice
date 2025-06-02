package latice.application.popup;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopUp extends Stage{
	protected final Integer largeur = 140;
	protected final Integer longueur = 410;
	protected VBox vbox = new VBox();
	
	protected PopUp(String titre) {
		super();
		
		this.initModality(Modality.APPLICATION_MODAL);
        this.setTitle(titre);
        
        this.vbox.setStyle("-fx-background-radius: 15;" +
        		"-fx-background-image: url('/interface/fondPopUp.png');"+
        	    "-fx-background-size: cover;" +
        	    "-fx-background-size: 100% 100%;" +
        	    "-fx-background-position: center;" +
        	    "-fx-padding: 10 20;"+
        	    "-fx-background-repeat: no-repeat;" +
        	    "-fx-text-fill: lightblue;");

        
		Scene scene = new Scene(vbox, longueur, largeur);
        this.setScene(scene);
	}
	
	protected void afficher() {
		this.showAndWait();
        this.setResizable(false);
	}
	
	protected void fermer() {
		this.close();
	}

	protected Integer getLargeur() {
		return largeur;
	}

	protected Integer getLongueur() {
		return longueur;
	}
}
