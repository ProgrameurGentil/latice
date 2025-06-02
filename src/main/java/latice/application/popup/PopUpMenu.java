package latice.application.popup;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import latice.application.Plateau;
import latice.model.Joueur;

public class PopUpMenu extends PopUp {
	private Integer btn_taille = 175;

	public PopUpMenu(Joueur joueur) {
		super("Menu");
		
		Label lblpts;
        if (joueur != null) {
        	lblpts = new Label("Nombre de points du " + joueur.getNom() + " : " + joueur.getPoints() + " pnts");
        } else {
        	lblpts = new Label("Nombre de points du null : XX pnts");
        }
		
        Button btnpass = afficherbouttonDansMenu("Fin du tour", new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
			}
		}, "Cette action va finir votre tour");
        
        Button btnacheter = afficherbouttonDansMenu("Acheter une Action (2)", new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
			}
        	
        }, "Acheter une action pour joueur à nouveau");
        
        Button btnchangerRack = afficherbouttonDansMenu("Echanger son rack (2)", new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
			}
        	
        }, "Cette action passera votre tour");
        
        Button btnfermerAction = afficherbouttonDansMenu("retour", null, null);
        
        VBox vbBoutton1et2 = new VBox(10, btnacheter, btnpass);
        VBox vbBoutton3etfermer = new VBox(10, btnchangerRack, btnfermerAction);
        

        HBox menubouton = new HBox(15, vbBoutton1et2, vbBoutton3etfermer);
        
        vbox.getChildren().addAll(lblpts, menubouton);
        
        menubouton.setStyle("-fx-padding: 20; -fx-alignment: center;");
        lblpts.setAlignment(Pos.CENTER);
	}
	
	private Button afficherbouttonDansMenu(String string, EventHandler<MouseEvent> action, String descriptif) {
			
		final Button button = Plateau.boutonEnBois(string);
		if (descriptif != null) {
			final Tooltip tooltip = new Tooltip(descriptif);
	        Tooltip.install(button, tooltip);
		}
		
		if (string != "retour") {
			button.setOnMousePressed(action);
			button.setOnMouseClicked(event -> {fermer();});
			
		} else {
			button.setOnAction(e -> fermer());
		}
		
		
		button.setMaxWidth(btn_taille);
        
		return button;
	}

	public Integer getBtn_taille() {
		return btn_taille;
	}

	public void setBtn_taille(Integer btn_taille) {
		this.btn_taille = btn_taille;
	}
}
