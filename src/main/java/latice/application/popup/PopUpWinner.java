package latice.application.popup;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import latice.model.Joueur;

public class PopUpWinner extends PopUp{

	public PopUpWinner(Joueur joueur) {
		super("Partie gagné par " + joueur.getNom());

		Label labelJoueurGagnant = new Label("Bravo !! Le joueur " + joueur.getNom() + " a gagné la partie !!");
		
		vbox.getChildren().add(labelJoueurGagnant);
		vbox.setAlignment(Pos.CENTER);
	}
	
}
