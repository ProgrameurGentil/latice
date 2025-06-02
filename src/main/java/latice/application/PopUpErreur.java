package latice.application;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class PopUpErreur extends PopUp {

	public PopUpErreur(String titre, String message) {
		super(titre);
		
		Label labelErreur = new Label(message);
        Button boutonQuitter = Plateau.boutonEnBois("Quitter");
        
        boutonQuitter.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				fermer();
			}
		});
        
        labelErreur.setStyle("-fx-padding: 20; -fx-alignment: center;");
        
        vbox.getChildren().addAll(labelErreur, boutonQuitter);
        vbox.setAlignment(Pos.CENTER);
        
        
	}

}
