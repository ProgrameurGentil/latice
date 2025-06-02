package latice.application.popup;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import latice.model.Joueur;

public class PopUpGagnant extends PopUp{

	public PopUpGagnant(Joueur joueur) {
		super("Partie gagné par " + joueur.getNom());

		Label labelJoueurGagnant = new Label("Bravo !! Le joueur " + joueur.getNom() + " a gagné la partie !!");
		
		labelJoueurGagnant.setStyle("-fx-text-fill: yellow;");
		
		root.getChildren().add(labelJoueurGagnant);
		root.setAlignment(Pos.CENTER);
	}
	
}
