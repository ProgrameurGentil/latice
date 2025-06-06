package latice.application;

import javafx.animation.Animation;
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
import latice.application.audio.MusiqueDeFond;
import latice.application.popup.PopUpMenu;
import latice.model.Joueur;
import latice.model.PlateauDeCase;
import latice.model.PlateauTuiles;
import latice.model.Rack;
import latice.model.Tuile;

public class Plateau extends Application{
	 private static final int COLONNE = 9;
	 private static final int LIGNE = 9;
	 private static final double CASE_TAILLE = 62.0;
	 private static final PlateauTuiles PLATEAU_TUILE = new PlateauTuiles();
	 private static final PlateauDeCase PLATEAU_CASE = PlateauDeCase.initialisationPlateauCase();
	 private static final Dnd DRAG_AND_DROP = new Dnd();
	 private static final MusiqueDeFond MUSIQUE_DE_FOND = new MusiqueDeFond();
	 private Integer nbTour = LaticeMain.NB_TOURS_MAX*2;
	 private Label lblNbToursRestants;
	 private Label lblNbTuileDansPiochedessu;
	 private Label lblNbTuileDansPiochedessou;
	 private Label lblNbActions;
	 private Label lblJoueur;
	 private Joueur joueur = null;
	 
	 private HBox hbRack = new HBox();
	 
	 private static Plateau INSTANCE; 
	 public static Plateau getInstance() { return INSTANCE; }
	 
	 public static void main(String[] args) {
	        launch(args);
	    }
	@Override
	public void start(Stage primaryStage) throws Exception{
            Plateau.INSTANCE = this;
		
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
	        
	        menuAction.setOnMouseClicked(event -> new PopUpMenu(joueur, PLATEAU_TUILE).afficher() );
            
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
		        
	        } catch (java.lang.IllegalAccessError e1) { // tout ces testes d'erreurs sont obligatoires sinon ça ne fonctionne pas 
	        	backgroundRGB(root);
			} catch (java.lang.NoClassDefFoundError e2) {
				backgroundRGB(root);
			} catch (java.lang.NullPointerException e3) {
				backgroundRGB(root);
			} catch (Exception e4) {
				backgroundRGB(root);
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
			
			for (int col = 0; col < COLONNE; col++) {
	            ColumnConstraints colConst = new ColumnConstraints();
	            colConst.setMinWidth(CASE_TAILLE);
	            colConst.setPrefWidth(CASE_TAILLE);
	            colConst.setHgrow(Priority.NEVER);
	            plateau.getColumnConstraints().add(colConst);
	        }

	        for (int row = 0; row < LIGNE; row++) {
	            RowConstraints rowConst = new RowConstraints();
	            rowConst.setMinHeight(CASE_TAILLE);
	            rowConst.setPrefHeight(CASE_TAILLE);
	            rowConst.setVgrow(Priority.NEVER);
	            plateau.getRowConstraints().add(rowConst);
	        }

	        for (int row = 0; row < LIGNE; row++) {
	            for (int col = 0; col < COLONNE; col++) {
	                ImageView imageView = new ImageView();
	                DRAG_AND_DROP.cibleDragAndDrop(imageView, PLATEAU_TUILE, PLATEAU_CASE);
	                imageView.setFitHeight(CASE_TAILLE);
	                imageView.setFitWidth(CASE_TAILLE);
	                imageView.setPreserveRatio(true);
	                imageView.setPickOnBounds(true);

	                GridPane.setHgrow(imageView, Priority.ALWAYS);
	                GridPane.setVgrow(imageView, Priority.ALWAYS);

	                plateau.add(imageView, col, row); 
	            }
	        }

	        vboxbtnAction.getChildren().add(menuAction);
	        //vboxbtnAction.setStyle("-fx-border-color: green;");
	        
	        String couleurText = "-fx-text-fill: yellow;";
	        Font font = Font.font("Georgia", 13);
	        
	        lblNbToursRestants = new Label("Nombre de tours restants : " + this.nbTour);
	        lblNbToursRestants.setStyle(couleurText);
	        lblNbToursRestants.setFont(font);
	        
	        
	        lblNbTuileDansPiochedessu = new Label("Nombre de tuiles restantes dans");
	        lblNbTuileDansPiochedessou = new Label("la pioche de null : XX");
	        

	        lblNbTuileDansPiochedessou.setStyle(couleurText);
	        lblNbTuileDansPiochedessou.setFont(font);
	        
	        
	        lblNbTuileDansPiochedessu.setStyle(couleurText);
	        lblNbTuileDansPiochedessu.setFont(font);
	        
	        
	        lblNbActions = new Label("Nombre d'actions restantes : XX" );
	        lblNbActions.setStyle(couleurText);
	        lblNbActions.setFont(font);
	        
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
	        
	        MUSIQUE_DE_FOND.lancerMusiqueDePartie();
	        
			primaryStage.setTitle("Plateau Latice");
			Scene scene = new Scene(root, 1000, 700);
	        primaryStage.setScene(scene);
	        
	        primaryStage.setResizable(false);
	        primaryStage.show();
		
	}

	private void backgroundRGB(BorderPane root) {
		Rectangle bg = new Rectangle();
		bg.widthProperty().bind(root.widthProperty());
		bg.heightProperty().bind(root.heightProperty());

		FillTransition ft = new FillTransition(Duration.seconds(2), bg, Color.RED, Color.BLUE);
		ft.setAutoReverse(true);
		ft.setCycleCount(Animation.INDEFINITE);
		ft.play();

		root.getChildren().add(bg);
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
		DRAG_AND_DROP.setJoueur(joueur);
		for(int i=0;i<longueurDAffichage;i++) {
			Tuile tuile = rackDuJoueur.obtenirTuile(i);
			if (tuile != null) {
				try {
		            Image image = new Image(getClass().getResource(tuile.obtenirLienVersImage()).toString());
		            ImageView imageView = new ImageView(image);
		            DRAG_AND_DROP.sourceDragAndDrop(imageView, i);
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
			if (MUSIQUE_DE_FOND.etat() != "fin") {
				MUSIQUE_DE_FOND.stop();
				MUSIQUE_DE_FOND.lancerMusiqueDeFinPartie();
			}
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
	
	public static MusiqueDeFond getMusiqueDeFond() {
		return MUSIQUE_DE_FOND;
	}
	
}
		
