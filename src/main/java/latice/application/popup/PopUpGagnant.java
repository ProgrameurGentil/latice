package latice.application.popup;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import latice.application.Plateau;
import latice.application.audio.EffetDeSon;
import latice.model.Joueur;

public class PopUpGagnant extends PopUp{

	public PopUpGagnant(Joueur joueur) {
		super("Partie gagné par " + joueur.getNom());

		Label labelJoueurGagnant = Plateau.labelEnBois("Bravo !! Le joueur " + joueur.getNom() + " a gagné la partie !!");
		
		labelJoueurGagnant.setStyle(labelJoueurGagnant.getStyle()
				   + "-fx-text-fill: yellow;");
		
		root.getChildren().add(labelJoueurGagnant);
		root.setAlignment(Pos.CENTER);
	}
	
	@Override
	public void afficher() {
		EffetDeSon.jouerSonVictoire();
		super.afficher();
	}
	
}
