package latice.application;

import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import latice.application.popup.PopUpMenu;
import latice.model.Joueur;
import latice.model.PlateauDeCase;
import latice.model.PlateauTuiles;
import latice.model.Rack;
import latice.model.Tuile;

public class Plateau extends Application{
	 private static final int colonnes = 9;
	 private static final int lignes = 9;
	 private static final double case_taille = 62.0;
	 private static final PlateauTuiles plateauTuile = new PlateauTuiles();
	 private static final PlateauDeCase plateauCase = PlateauDeCase.initialisationPlateauCase();
	 private static final Dnd dragAndDrop = new Dnd();
	 private Integer nbTour = LaticeMain.nbToursMax*2;
	 private Label lblNbToursRestants;
	 private Label lblNbTuileDansPiochedessu;
	 private Label lblNbTuileDansPiochedessou;
	 private Label lblNbActions;
	 private Label lblJoueur;
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
	        VBox vblblNbTuile = new VBox();
	        VBox vblblNbTours = new VBox();
	        VBox vboxbtnAction = new VBox();
	        VBox vbplarack = new VBox();
	        VBox vbactInfo = new VBox();
	        VBox vblblJoueur = new VBox();
	        VBox vblblActions = new VBox();
	        Button menuAction = boutonEnBois("Faire une Action");
	        
	        menuAction.setOnMouseClicked(event -> new PopUpMenu(joueur, plateauTuile).afficher() );
            
	        StackPane bottomPane = new StackPane(hbRack);
            
	        
	        try {
		        Media media = new Media(getClass().getResource("/video/background.mp4").toString());
		        MediaPlayer mediaPlayer = new MediaPlayer(media);
		        mediaPlayer.setAutoPlay(true);
		        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		        MediaView mediaView = new MediaView(mediaPlayer);
	
		        mediaView.setPreserveRatio(false);
		        mediaView.setFitWidth(1000);
		        mediaView.setFitHeight(700);
	
		        root.getChildren().add(mediaView);
		        
	        } catch (Exception e) {
	        	Rectangle bg = new Rectangle(800, 600);
		        bg.widthProperty().bind(root.widthProperty());
		        bg.heightProperty().bind(root.heightProperty());

		        FillTransition ft = new FillTransition(Duration.seconds(2), bg, Color.RED, Color.BLUE);
		        ft.setAutoReverse(true);
		        ft.setCycleCount(FillTransition.INDEFINITE);
		        ft.play();

		        root.getChildren().add(bg);
			}

	        
	        
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

	        vboxbtnAction.getChildren().add(menuAction);
	        //vboxbtnAction.setStyle("-fx-border-color: green;");
	        
	        lblNbToursRestants = new Label("Nombre de tours restants : " + this.nbTour);
	        lblNbToursRestants.setStyle("-fx-text-fill: yellow;");
	        lblNbToursRestants.setFont(Font.font("Georgia", 13));
	        
	        
	        lblNbTuileDansPiochedessu = new Label("Nombre de tuiles restantes dans");
	        lblNbTuileDansPiochedessou = new Label("la pioche de null : XX");
	        

	        lblNbTuileDansPiochedessou.setStyle("-fx-text-fill: yellow;");
	        lblNbTuileDansPiochedessou.setFont(Font.font("Georgia", 13));
	        
	        
	        lblNbTuileDansPiochedessu.setStyle("-fx-text-fill: yellow;");
	        lblNbTuileDansPiochedessu.setFont(Font.font("Georgia", 13));
	        
	        
	        lblNbActions = new Label("Nombre d'actions restantes : XX" );
	        lblNbActions.setStyle("-fx-text-fill: yellow;");
	        lblNbActions.setFont(Font.font("Georgia", 13));
	        
	        lblJoueur = new Label("XX");
	        lblJoueur.setStyle("-fx-text-fill: yellow;" + "-fx-font-weight: bold;");
	        lblJoueur.setFont(Font.font("Georgia", 25));
	        
	        vblblNbTuile.getChildren().addAll(lblNbTuileDansPiochedessu, lblNbTuileDansPiochedessou);
	        vblblNbTours.getChildren().add(lblNbToursRestants);
	        
	 
	        
	        vblblJoueur.getChildren().add(lblJoueur);
	        vblblActions.getChildren().add(lblNbActions);
	        
	        
	        vbInformations.getChildren().addAll(vblblNbTours, vblblNbTuile, vblblActions, vblblJoueur);
	        vblblNbTours.setAlignment(Pos.CENTER);
	        vblblNbTours.setTranslateY(-85);
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
	        
	        menuAction.setTranslateY(-25);
	        
	        vbInformations.setPrefHeight(200);
	        vbInformations.setPrefWidth(300);
	        //vbInformations.setStyle("-fx-border-color: red;");
	        
	        
	        root.setLeft(vbInformations);
	        vbInformations .setAlignment(Pos.CENTER);
	        vbInformations.setTranslateX(20);
	        

	        
	        vbactInfo.getChildren().addAll(vboxbtnAction, vblblNbTuile);
	        vbInformations.getChildren().add(vbactInfo);
	        
	        vboxbtnAction.setAlignment(Pos.CENTER);
	        vboxbtnAction.setTranslateY(-175);
	        
	        vblblNbTuile.setAlignment(Pos.CENTER);
	        vblblNbTuile.setTranslateY(-138);
	        
	        vblblActions.setAlignment(Pos.CENTER);
	        
	        
	        vblblJoueur.setTranslateY(115);
	        vblblJoueur.setAlignment(Pos.CENTER);
	        
	        
	        
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
	
	public void setJoueur(Joueur joueur) {
		joueur.setNombreActionRestanteAJouer(1);
		//System.out.println("nb action : " + joueur.getNombreActionRestanteAJouer());
		this.joueur = joueur;
		
		if (this.joueur == null) {
	        lblNbTuileDansPiochedessou = new Label("la pioche de null : XX");
        }else {
        	lblNbTuileDansPiochedessou.setText("la pioche de " + joueur.getNom() + " : " + joueur.getPioche().taille());
        }
		updateNbTour();
		lblJoueur.setText(joueur.getNom());
		updateNbActionsRestantes();
	}
	
	public void updateLabelPioche() {
		if (joueur != null) {
			//System.out.println(joueur.getPioche().taille());
			lblNbTuileDansPiochedessou.setText("la pioche de " + joueur.getNom() + " : " + joueur.getPioche().taille());
		}
	}
	
	public void updateNbTour() {
		if (this.nbTour < 10) {
			this.lblNbToursRestants.setStyle(this.lblNbToursRestants.getStyle() + "-fx-font-weight: bold;");
		}
		
		this.lblNbToursRestants.setText("Nombre de tours restants : " + this.nbTour);
		this.nbTour--;
	}
	
	public void updateNbActionsRestantes() {
		if (joueur != null) {
			this.lblNbActions.setText("Nombre d'actions restantes : " + joueur.getNombreActionRestanteAJouer());
		}
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
        	    "-fx-text-fill: lightblue;" +
        	    "-fx-font-weight: bold;");
		return bouton;
	}
	
	public static Label labelEnBois(String texte) {
		Label label = new Label(texte);
		label.setStyle("-fx-text-fill: black;" +
        		"-fx-background-radius: 15;" +
        		"-fx-background-image: url('/interface/cadreLabel.png');"+
        	    "-fx-background-size: cover;" +
        	    "-fx-background-size: 100% 100%;" +
        	    "-fx-background-position: center;" +
        	    "-fx-padding: 10 20;"+
        	    "-fx-background-repeat: no-repeat;" +
        	    "-fx-font-weight: bold;");
		return label;
	}
	
}
		
