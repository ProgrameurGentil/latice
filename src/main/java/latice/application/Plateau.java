package latice.application;

import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import latice.model.Joueur;
import latice.model.PlateauDeCase;
import latice.model.PlateauTuiles;
import latice.model.Rack;
import latice.model.Tuile;
import latice.application.PopUp;

public class Plateau extends Application{
	 private static final int colonnes = 9;
	 private static final int lignes = 9;
	 private static final double case_taille = 62.0;
	 private static final int btn_taille = 175;
	 private static final PlateauTuiles plateauTuile = new PlateauTuiles();
	 private static final PlateauDeCase plateauCase = PlateauDeCase.initialisationPlateauCase();
	 private static final Dnd dragAndDrop = new Dnd();
	 private Label lblNbTuileDansPiochedessu;
	 private Label lblNbTuileDansPiochedessou;
	 private Joueur joueur = null;
	 
	 private HBox hbRack = new HBox();
	 
	 private static Plateau instance; 
	 public static Plateau getInstance() { return instance; }
	 
	 public static void main(String[] args) {
	        launch(args);
	    }
	@Override
	public void start(Stage primaryStage) throws Exception{
            instance = this;
		
            BorderPane root = new BorderPane();
            GridPane plateau = new GridPane();
            plateau.setGridLinesVisible(false);
	        plateau.setMaxSize(555, 555);
            
	        VBox vbInformations = new VBox();
	        VBox vblblInforomation = new VBox();
	        VBox vboxbtnAction = new VBox();
	        VBox vbplarack = new VBox();
	        VBox vbactInfo = new VBox();
	        Button menuAction = boutonEnBois("Faire une Action");
	        
	        menuAction.setOnAction(e -> showMenuPopup());
            
	        
	        
	        StackPane bottomPane = new StackPane(hbRack);
            
	        Rectangle bg = new Rectangle(800, 600);
	        bg.widthProperty().bind(root.widthProperty());
	        bg.heightProperty().bind(root.heightProperty());

	        FillTransition ft = new FillTransition(Duration.seconds(2), bg, Color.RED, Color.BLUE);
	        ft.setAutoReverse(true);
	        ft.setCycleCount(FillTransition.INDEFINITE);
	        ft.play();

	        root.getChildren().add(bg);
            
	        Image imgPlateau = new Image(getClass().getResourceAsStream("/plateau/plateau.png"));
	        BackgroundImage background = new BackgroundImage(
	        		imgPlateau,
	                BackgroundRepeat.NO_REPEAT,  
	                BackgroundRepeat.NO_REPEAT,  
	                BackgroundPosition.DEFAULT,  
	                new BackgroundSize(
	                        558, 558, false, false, true, false));
	        plateau.setBackground(new Background(background));
            
	        Image bgImage = new Image(getClass().getResourceAsStream("/rack/fond.png"));
            
			hbRack.setPrefHeight(85);
			hbRack.setMaxSize(350, 90);
			
			
			hbRack.setPrefWidth(340);
		            
			hbRack.setStyle("-fx-border-width: 10;" + "-fx-border-radius: 15;" + "-fx-padding: 20;");
			
			BackgroundImage backgroundImage = new BackgroundImage(
			    bgImage,
			    BackgroundRepeat.NO_REPEAT,
			    BackgroundRepeat.NO_REPEAT,
			    BackgroundPosition.CENTER,
			    new BackgroundSize(
			        350, 90, false, false, false, false)
			);

			hbRack.setBackground(new Background(backgroundImage)); 
			
			for (int col = 0; col < colonnes; col++) {
	            ColumnConstraints colConst = new ColumnConstraints();
	            colConst.setMinWidth(case_taille);
	            colConst.setPrefWidth(case_taille);
	            colConst.setHgrow(Priority.NEVER);
	            plateau.getColumnConstraints().add(colConst);
	        }

	        for (int row = 0; row < lignes; row++) {
	            RowConstraints rowConst = new RowConstraints();
	            rowConst.setMinHeight(case_taille);
	            rowConst.setPrefHeight(case_taille);
	            rowConst.setVgrow(Priority.NEVER);
	            plateau.getRowConstraints().add(rowConst);
	        }

	        for (int row = 0; row < lignes; row++) {
	            for (int col = 0; col < colonnes; col++) {
	                ImageView imageView = new ImageView();
	                dragAndDrop.cibleDragAndDrop(imageView, plateauTuile, plateauCase);
	                imageView.setFitHeight(case_taille);
	                imageView.setFitWidth(case_taille);
	                imageView.setPreserveRatio(true);
	                imageView.setPickOnBounds(true);

	                GridPane.setHgrow(imageView, Priority.ALWAYS);
	                GridPane.setVgrow(imageView, Priority.ALWAYS);

	                plateau.add(imageView, col, row); 
	            }
	        }
	        

	        menuAction.setOnAction(e -> showMenuPopup());

	        vboxbtnAction.getChildren().add(menuAction);
	        //vboxbtnAction.setStyle("-fx-border-color: green;");
	        
	        
	        lblNbTuileDansPiochedessu = new Label("Nombre de tuiles restantes dans");
	        lblNbTuileDansPiochedessou = new Label("la pioche de null : XX");
	        

	        lblNbTuileDansPiochedessou.setStyle("-fx-text-fill: yellow;");
	        lblNbTuileDansPiochedessou.setFont(Font.font("Georgia", 13));
	        
	        
	        lblNbTuileDansPiochedessu.setStyle("-fx-text-fill: yellow;");
	        lblNbTuileDansPiochedessu.setFont(Font.font("Georgia", 13));
	        
	        
	        vblblInforomation.getChildren().addAll(lblNbTuileDansPiochedessu, lblNbTuileDansPiochedessou);
	        root.setLeft(vbInformations);
	        
	        
	        BackgroundImage bgImgInformations = new BackgroundImage(
	        	    new Image(getClass().getResource("/interface/cadre.png").toExternalForm()),
	        	    BackgroundRepeat.NO_REPEAT,
	        	    BackgroundRepeat.NO_REPEAT,
	        	    BackgroundPosition.DEFAULT,
	        	    new BackgroundSize(
	        	        100, 100,
	        	        true, true, 
	        	        true, false
	        	    )
	        	);

	        vbInformations.setBackground(new Background(bgImgInformations));
	        
	        
	        vbInformations.setPrefHeight(200);
	        vbInformations.setPrefWidth(300);
	        //vbInformations.setStyle("-fx-border-color: red;");
	        
	        
	        root.setLeft(vbInformations);
	        vbInformations .setAlignment(Pos.CENTER);
	        vbInformations.setTranslateX(20);
	        
	        vbactInfo.getChildren().addAll(vboxbtnAction, vblblInforomation);
	        vbInformations.getChildren().add(vbactInfo);
	        
	        vboxbtnAction.setAlignment(Pos.CENTER);
	        vboxbtnAction.setTranslateY(-170);
	        
	        vblblInforomation.setAlignment(Pos.CENTER);
	        vblblInforomation.setTranslateY(-110);
	        
	        
	        bottomPane.setAlignment(Pos.CENTER);
	        bottomPane.setPrefHeight(90); 
	        
	        bottomPane.setTranslateY(40);
	        bottomPane.setTranslateX(-50);
	        plateau.setTranslateX(-50);
	        plateau.setTranslateY(30);
	        vbplarack.getChildren().addAll(plateau, bottomPane);
	        root.setRight(vbplarack);
	        
	        
			primaryStage.setTitle("Plateau Latice");
			Scene scene = new Scene(root, 1000, 700);
	        primaryStage.setScene(scene);
	        
	        primaryStage.setResizable(false);
	        primaryStage.show();
		
	}

	public void afficherlerackdujoueur(Joueur joueur) {
		Rack rackDuJoueur = joueur.getRack();
		Integer tailleDuRackDuJoueur = joueur.getRack().taille();
		Integer longueurDAffichage = 5;
		hbRack.getChildren().clear();
		if (tailleDuRackDuJoueur < 5) {
			longueurDAffichage = tailleDuRackDuJoueur;
		}
		setJoueur(joueur);
		dragAndDrop.setJoueur(joueur);
		for(int i=0;i<longueurDAffichage;i++) {
			Tuile tuile = rackDuJoueur.obtenirTuile(i);
			if (tuile != null) {
				try {
		            Image image = new Image(getClass().getResource(tuile.obtenirLienVersImage()).toString());
		            ImageView imageView = new ImageView(image);
		            dragAndDrop.sourceDragAndDrop(imageView, i);
		            imageView.setFitWidth(62);
		            imageView.setFitHeight(62);
		            imageView.setPreserveRatio(true);
		            hbRack.getChildren().add(imageView);
				} catch(Exception e) {
					System.out.println(tuile.toString());
				}
	        }
		}
	}
	
	private void showMenuPopup() {
		Integer largeurFenetre = 400;
        Stage menuStage = new Stage();
        menuStage.initModality(Modality.APPLICATION_MODAL);
        menuStage.setTitle("Menu");
        
        Label lblpts;
        if (joueur != null) {
        	lblpts = new Label("Nombre de points du " + joueur.getNom() + " : " + joueur.getPoints() + " pnts");
        } else {
        	lblpts = new Label("Nombre de points du null : XX pnts");
        }
		
        Button btnpass = afficherbouttonDansMenu("Fin du tour", new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				if (joueur != null) {
					if (!(LaticeMain.getNbTours().equals(0) && joueur.getNbTuilesPosees().equals(0))) {
						LaticeMain.joueurSuivant();
						//System.out.println("le joueur passe son tour");
					} else {
						showErreurPopup("Vous ne pouvez pas passer le tour", "Vous ne pouvez pas passer le tour.\nIl faut que vous jouez la premère tuile au centre");
					}
				}
			}
		}, "Cette action va finir votre tour",menuStage);
        
        Button btnacheter = afficherbouttonDansMenu("Acheter une Action (2)", new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (joueur != null) {
					System.out.println("Le joueur a choisi d'acheter");
				}
				
			}
        	
        }, "Acheter une action pour joueur à nouveau",menuStage);
        
        Button btnchangerRack = afficherbouttonDansMenu("Echanger son rack (2)", new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				//System.out.println("Le joueur a échanger son rack");
				if (joueur != null) {
					if (joueur.echangerRack()) {
						LaticeMain.joueurSuivant();
					} else {
						if (joueur.getPoints() < 2) {
							showErreurPopup("Erreur dans la transaction", "Vous n'avez pas assez de points");
						} else {
							showErreurPopup("Erreur dans la transaction", "Vous n'avez pas assez de tuiles dans votre pioche");
						}
					}
				}
			}
        	
        }, "Cette action passera votre tour",menuStage);
        
        Button btnfermerAction = afficherbouttonDansMenu("retour", null, null, menuStage);
                
        VBox vbBoutton1et2 = new VBox(10, btnacheter, btnpass);
        VBox vbBoutton3etfermer = new VBox(10, btnchangerRack, btnfermerAction);
        

        HBox menubouton = new HBox(15, vbBoutton1et2, vbBoutton3etfermer);
        VBox menuaction = new VBox(lblpts, menubouton);
        lblpts.setTranslateX((largeurFenetre/2) - (largeurFenetre/4.5));       
        
        menubouton.setStyle("-fx-padding: 20; -fx-alignment: center;");
        lblpts.setAlignment(Pos.CENTER);
        
        menuaction.setStyle("-fx-background-radius: 15;" +
        		"-fx-background-image: url('/interface/fondPopUp.png');"+
        	    "-fx-background-size: cover;" +
        	    "-fx-background-size: 100% 100%;" +
        	    "-fx-background-position: center;" +
        	    "-fx-padding: 10 20;"+
        	    "-fx-background-repeat: no-repeat;" +
        	    "-fx-text-fill: lightblue;");
        

        Scene menuScene = new Scene(menuaction, largeurFenetre, 140);

        menuStage.setScene(menuScene);
        menuStage.showAndWait();
        menuStage.setResizable(false);
    }
	
	private Button afficherbouttonDansMenu(String string, EventHandler<MouseEvent> action, String descriptif, Stage stage) {
		
		final Button button = boutonEnBois(string);
		if (descriptif != null) {
			final Tooltip tooltip = new Tooltip(descriptif);
	        Tooltip.install(button, tooltip);
		}
		
		if (string != "retour") {
			button.setOnMousePressed(action);
			button.setOnMouseClicked(event -> {stage.close();});
			
		}else {
			button.setOnAction(e -> stage.close());
		}
		
		
		button.setMaxWidth(btn_taille);
        
		return button;
		
	}
	
	public void setJoueur(Joueur joueur) {
		joueur.setNombreActionRestanteAJouer(1);
		//System.out.println("nb action : " + joueur.getNombreActionRestanteAJouer());
		this.joueur = joueur;
		
		if (this.joueur == null) {
	        lblNbTuileDansPiochedessou = new Label("la pioche de null : XX");
        }else {
        	lblNbTuileDansPiochedessou.setText("la pioche de " + joueur.getNom() + " : " + joueur.getPioche().taille());
        }
	}
	
	public void updateLabelPioche() {
		if (joueur != null) {
			//System.out.println(joueur.getPioche().taille());
			lblNbTuileDansPiochedessou.setText("la pioche de " + joueur.getNom() + " : " + joueur.getPioche().taille());
		}
	}
	
	public void showWinnerPopup(Joueur joueur) {
        Stage winnerStage = new Stage();
        winnerStage.initModality(Modality.APPLICATION_MODAL);
        winnerStage.setTitle("Partie gagné par " + joueur.getNom());
        
        Label labelJoueurGagnant = new Label("Bravo !! Le joueur " + joueur.getNom() + " a gagné la partie !!");
        
        VBox vbox = new VBox(labelJoueurGagnant);
        //labelJoueurGagnant.setTranslateX((largeurFenetre/2) - (largeurFenetre/6.6667));       
        
        labelJoueurGagnant.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene winnerScene = new Scene(vbox, 400, 140);

        winnerStage.setScene(winnerScene);
        winnerStage.showAndWait();
        winnerStage.setResizable(false);
    }
	
	public void showErreurPopup(String titre, String message) {
        Stage erreurStage = new Stage();
        erreurStage.initModality(Modality.APPLICATION_MODAL);
        erreurStage.setTitle(titre);
        
        Label labelErreur = new Label(message);
        Button boutonQuitter = boutonEnBois("Quitter");
        
        boutonQuitter.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				erreurStage.close();
				
			}
		});
        
        VBox vbox = new VBox(labelErreur, boutonQuitter);      
        
        labelErreur.setStyle("-fx-padding: 20; -fx-alignment: center;");


        vbox.setAlignment(Pos.CENTER);

        Scene erreurScene = new Scene(vbox, 400, 140);

        erreurStage.setScene(erreurScene);
        erreurStage.showAndWait();
        erreurStage.setResizable(false);
    }
	
	public static Button boutonEnBois(String texte) {
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
		
