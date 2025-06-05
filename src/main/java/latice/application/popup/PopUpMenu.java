package latice.application.popup;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import latice.application.EffetDeSon;
import latice.application.LaticeMain;
import latice.application.Plateau;
import latice.model.Joueur;
import latice.model.PlateauTuiles;

public class PopUpMenu extends PopUp {
	private Integer btn_taille = 175;
	VBox vbmenulbl = new VBox();
	public PopUpMenu(Joueur joueur, PlateauTuiles plateauTuiles) {
		super("Menu");
		
		Label lblpts;
        if (joueur != null) {
        	lblpts = Plateau.labelEnBois("Nombre de points du " + joueur.getNom() + " : " + joueur.getPoints() + " pnts");
        } else {
        	lblpts = Plateau.labelEnBois("Nombre de points du null : XX pnts");
        }
		

        Button btnpass = afficherbouttonDansMenu("Fin du tour", new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				if (joueur != null) {
					if (!(LaticeMain.getNbTours().equals(0) && joueur.getNbTuilesPosees().equals(0))) {
						LaticeMain.joueurSuivant();
						//System.out.println("le joueur passe son tour");
					} else {
						new PopUpErreur("Vous ne pouvez pas passer le tour", "Vous ne pouvez pas passer le tour.\nIl faut que vous jouez la premère tuile au centre").afficher();
					}
				}
			}
		}, "Cette action va finir votre tour");
        
        Button btnacheter = afficherbouttonDansMenu("Acheter une Action (2)", new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (joueur != null) {
					//System.out.println("Le joueur a choisi d'acheter");
					//System.out.println(joueur.verifierSiUnCoupEstPossible(plateauTuiles));
					if (joueur.getNombreActionRestanteAJouer() < joueur.verifierSiUnCoupEstPossible(plateauTuiles)) {
	
						if (!joueur.acheterAction()) {
							new PopUpErreur("Refus d'achat", "Vous ne pourvez pas acheter une action car \nvous n'avez pas assez de point").afficher();
						} else {
							EffetDeSon.jouerSonAchat();
						}
					} else {
						new PopUpErreur("Refus d'achat", "Vous ne pourvez pas acheter une action car \nil n'y plus de possibilité de placement").afficher();
					}
					Plateau plateau = Plateau.getInstance();
					plateau.updateNbActionsRestantes();
				}
				
			}
        	
        }, "Acheter une action pour joueur à nouveau");
        
        Button btnchangerRack = afficherbouttonDansMenu("Echanger son rack (2)", new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				//System.out.println("Le joueur a échanger son rack");
				if (joueur != null) {
					if (joueur.echangerRack()) {
						LaticeMain.joueurSuivant();
					} else {
						if (joueur.getPoints() < 2) {
							new PopUpErreur("Erreur dans la transaction", "Vous n'avez pas assez de points").afficher();
						} else {
							new PopUpErreur("Erreur dans la transaction", "Vous n'avez pas assez de tuiles dans votre pioche").afficher();
						}
					}
				}
			}
        	
        }, "Cette action passera votre tour");
        
        Button btnfermerAction = afficherbouttonDansMenu("retour", null, null);
        
        VBox vbBoutton1et2 = new VBox(10, btnacheter, btnpass);
        VBox vbBoutton3etfermer = new VBox(10, btnchangerRack, btnfermerAction);
        

        HBox menubouton = new HBox(15, vbBoutton1et2, vbBoutton3etfermer);
        
        vbmenulbl.getChildren().add(lblpts);
        vbmenulbl.setAlignment(Pos.CENTER);
        root.getChildren().addAll(vbmenulbl, menubouton);
        
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
