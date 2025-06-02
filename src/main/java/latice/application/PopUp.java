package latice.application;

import java.util.Collection;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopUp extends Stage{
	private final Integer largeur = 140;
	private final Integer longueur = 400;
	private VBox vbox = new VBox();
	
	public PopUp(String titre) {
		super();
		
		this.initModality(Modality.APPLICATION_MODAL);
        this.setTitle(titre);
		
        Image imgBackground = new Image(getClass().getResourceAsStream("/interface/fondPopUp.png"));
        BackgroundImage background = new BackgroundImage(
        		imgBackground,
                BackgroundRepeat.NO_REPEAT,  
                BackgroundRepeat.NO_REPEAT,  
                BackgroundPosition.DEFAULT,  
                new BackgroundSize(
                        558, 558, false, false, true, false));
        
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
	
	public void afficher() {
		this.showAndWait();
        this.setResizable(false);
	}
	
	public void fermer() {
		this.close();
	}
	
	public void ajouter(Node element) {
		this.vbox.getChildren().add(element);
	}
	
	public void ajouter(Collection<Node> elements) {
		this.vbox.getChildren().addAll(elements);
	}

	public Integer getLargeur() {
		return largeur;
	}

	public Integer getLongueur() {
		return longueur;
	}
	
	public Button boutonEnBois(String texte) {
		Button bouton = new Button(texte);
		bouton.setStyle("-fx-background-radius: 15;" +
        		"-fx-background-image: url('/Bouton/background_bouton.png');"+
        	    "-fx-background-size: cover;" +
        	    "-fx-background-size: 100% 100%;" +
        	    "-fx-background-position: center;" +
        	    "-fx-padding: 10 20;"+
        	    "-fx-background-repeat: no-repeat;" +
        	    "-fx-text-fill: lightblue;");
		return bouton;
	}
}
