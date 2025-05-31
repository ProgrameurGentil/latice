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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import latice.model.Joueur;
import latice.model.PlateauDeCase;
import latice.model.PlateauTuiles;
import latice.model.Rack;
import latice.model.Tuile;

public class Plateau extends Application{
	 private static final int colonnes = 9;
	 private static final int lignes = 9;
	 private static final double case_taille = 62.0;
	 private static final int btn_taille = 175;
	 private static final PlateauTuiles plateauTuile = new PlateauTuiles();
	 private static final PlateauDeCase plateauCase = PlateauDeCase.initialisationPlateauCase();
	 private static final Dnd dragAndDrop = new Dnd();
	 private Label lblNbTuileDansPioche;
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
            
	        VBox vbInformation = new VBox();
	        VBox vb = new VBox();
	        VBox vblbl = new VBox();
	        VBox vboxbtn = new VBox();
	        Button menuAction = new Button("Faire une Action");
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
	        
	        root.setCenter(plateau);

	        menuAction.setOnAction(e -> showMenuPopup());
	        menuAction.setStyle("-fx-background-radius: 15;" +
	        		"-fx-background-image: url('/Bouton/background_bouton.png');"+
	        	    "-fx-background-size: cover;" +
	        	    "-fx-background-size: 100% 100%;" +
	        	    "-fx-background-position: center;" +
	        	    "-fx-padding: 10 20;"+
	        	    "-fx-background-repeat: no-repeat;" +
	        	    "-fx-text-fill: lightblue;");

	        vboxbtn.getChildren().add(menuAction);
	        vboxbtn.setStyle("-fx-border-color: green;");
	        
	        lblNbTuileDansPioche = new Label("Nombre de tuiles restantes dans la pioche de null : XX");
            
	        
	        lblNbTuileDansPioche.setStyle("-fx-text-fill: lightblue;");
	     
	        
	        vblbl.getChildren().add(lblNbTuileDansPioche);
	        vb.getChildren().addAll(vboxbtn, vblbl);
	        root.setLeft(vb);

	        vbInformation.setStyle("-fx-border-color: red;");
	        vbInformation.getChildren().add(vb);
	        
	        root.setLeft(vbInformation);
	        vbInformation.setAlignment(Pos.CENTER_LEFT);

	        bottomPane.setAlignment(Pos.CENTER);
	        bottomPane.setPrefHeight(90); 
	        
	        bottomPane.setTranslateY(-10);
	        bottomPane.setTranslateX(55);
	        root.setBottom(bottomPane);
	        
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
				if (!(LaticeMain.getNbTours().equals(0) && joueur.getNbTuilesPosees().equals(0))) {
					LaticeMain.joueurSuivant();
					//System.out.println("le joueur passe son tour");
				}
			}
		}, "Cette action va finir votre tour",menuStage);
        
        Button btnacheter = afficherbouttonDansMenu("Acheter une Action (2)", new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				System.out.println("Le joueur a choisi d'acheter");
				
			}
        	
        }, "Acheter une action pour joueur à nouveau",menuStage);
        
        Button btnchangerRack = afficherbouttonDansMenu("Echanger son rack (2)", new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				System.out.println("Le joueur a échanger son rack");
				
			}
        	
        }, "Cette action passera votre tour",menuStage);
        
        Button btnfermerAction = afficherbouttonDansMenu("retour", null, null, menuStage);
                
        VBox vbBoutton1et2 = new VBox(10, btnacheter, btnpass);
        VBox vbBoutton3etfermer = new VBox(10, btnchangerRack, btnfermerAction);
        

        HBox menubouton = new HBox(15, vbBoutton1et2, vbBoutton3etfermer);
        VBox menuaction = new VBox(lblpts, menubouton);
        lblpts.setTranslateX((largeurFenetre/2) - (largeurFenetre/4.5));       
        
        menubouton.setStyle("-fx-padding: 20; -fx-alignment: center;");
        

        Scene menuScene = new Scene(menuaction, largeurFenetre, 140);

        menuStage.setScene(menuScene);
        menuStage.showAndWait();
        menuStage.setResizable(false);
    }
	
	private Button afficherbouttonDansMenu(String string, EventHandler<MouseEvent> action, String descriptif, Stage stage) {
		
		final Button button = new Button(string);
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
		
		button.setStyle("-fx-background-radius: 15;" +
        		"-fx-background-image: url('/Bouton/background_bouton.png');"+
        	    "-fx-background-size: cover;" +
        	    "-fx-background-size: 100% 100%;" +
        	    "-fx-background-position: center;" +
        	    "-fx-padding: 10 20;"+
        	    "-fx-background-repeat: no-repeat;" +
        	    "-fx-text-fill: lightblue;");
        
        button.layoutBoundsProperty().addListener((obs, ancVal, nouvVal) -> {
            Rectangle clip = new Rectangle(nouvVal.getWidth(), nouvVal.getHeight());
            clip.setArcWidth(20);
            clip.setArcHeight(20);
            button.setClip(clip);
        });
		return button;
		
	}
	
	public void setJoueur(Joueur joueur) {
		joueur.setNombreActionRestanteAJouer(1);
		//System.out.println("nb action : " + joueur.getNombreActionRestanteAJouer());
		this.joueur = joueur;
		
		if (this.joueur == null) {
        	lblNbTuileDansPioche.setText("Nombre de tuiles restantes dans la pioche de null : XX");
        }else {
        	lblNbTuileDansPioche.setText("Nombre de tuiles restantes dans la pioche de " + joueur.getNom() + " : " + joueur.getPioche().taille());
        }
	}
	
	public void updateLabelPioche() {
		if (joueur != null) {
			//System.out.println(joueur.getPioche().taille());
			lblNbTuileDansPioche.setText("Nombre de tuiles restantes dans la pioche de " + joueur.getNom() + " : " + joueur.getPioche().taille());
		}
	}
	
	public void showWinnerPopup(Joueur joueur) {
		Integer largeurFenetre = 400;
        Stage winnerStage = new Stage();
        winnerStage.initModality(Modality.APPLICATION_MODAL);
        winnerStage.setTitle("Menu");
        
        Label labelJoueurGagnant = new Label("Bravo !! Le joueur " + joueur.getNom() + " a gagné la partie !!");
        
        VBox vbox = new VBox(labelJoueurGagnant);
        //labelJoueurGagnant.setTranslateX((largeurFenetre/2) - (largeurFenetre/6.6667));       
        
        labelJoueurGagnant.setStyle("-fx-padding: 20; -fx-alignment: center;");
        

        Scene winnerScene = new Scene(vbox, largeurFenetre, 140);

        winnerStage.setScene(winnerScene);
        winnerStage.showAndWait();
        winnerStage.setResizable(false);
    }
}
		
