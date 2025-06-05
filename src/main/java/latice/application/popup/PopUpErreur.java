package latice.application.popup;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import latice.application.Plateau;
import latice.application.audio.EffetDeSon;

public class PopUpErreur extends PopUp {

	public PopUpErreur(String titre, String message) {
		super(titre);
		
		Label labelErreur = Plateau.labelEnBois(message);
        Button boutonQuitter = Plateau.boutonEnBois("Quitter");
        
        boutonQuitter.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				fermer();
			}
		});
        
        labelErreur.setStyle(labelErreur.getStyle()
        				   + "-fx-padding: 10;"
    					   + "-fx-alignment: center;");
        
        
        root.getChildren().addAll(labelErreur, boutonQuitter);
        root.setAlignment(Pos.CENTER);
        VBox.setMargin(labelErreur, new Insets(10));    
        
	}
	
	@Override
	public void afficher() {
		EffetDeSon.jouerSonHaHa();
		super.afficher();
	}

}
