package latice.application;

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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
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
			hbRack.setPrefHeight(85);
			hbRack.setMaxSize(350, 90);
			
			Image bgImage = new Image(getClass().getResourceAsStream("/rack/fond.png"));
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
			

			PlateauTuiles plateauTuile = new PlateauTuiles(); // temporaire
			PlateauDeCase plateauCase = new PlateauDeCase();

			
			GridPane plateau = new GridPane();
	        plateau.setGridLinesVisible(false);
	        plateau.setMaxSize(555, 555);
	   
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
	                Dnd.cibleDragAndDrop(imageView, plateauTuile);
	                imageView.setFitHeight(case_taille);
	                imageView.setFitWidth(case_taille);
	                imageView.setPreserveRatio(true);
	                imageView.setPickOnBounds(true);

	                GridPane.setHgrow(imageView, Priority.ALWAYS);
	                GridPane.setVgrow(imageView, Priority.ALWAYS);

	                plateau.add(imageView, col, row);
	            }
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
	        
	        root.setCenter(plateau);
	        


	        VBox vbInformation = new VBox();

	        
	        VBox vb = new VBox();
	        VBox vblbl = new VBox();
	        VBox vboxbtn = new VBox();
	        Label pointsJ1 = new Label("Points du joueur 1 : ");
	        Label pointsJ2 = new Label("Points du joueur 2 : ");

	        Button menuAction = new Button("Faire une Action");
	        menuAction.setOnAction(e -> showMenuPopup());
	        
	        
	        vblbl.setStyle("-fx-border-color: red;");
	        pointsJ1.setTextFill(Color.RED);
	        

	        vboxbtn.getChildren().add(menuAction);
	        vboxbtn.setStyle("-fx-border-color: green;");
	        vblbl.getChildren().addAll(pointsJ1,pointsJ2);
	        vb.getChildren().addAll(vboxbtn, vblbl);
	        root.setLeft(vb);

	        
	        vbInformation.setStyle("-fx-border-color: red;");
	        vbInformation.getChildren().add(vb);
	        
	        root.setLeft(vbInformation);
	        vbInformation.setAlignment(Pos.CENTER_LEFT);

	        StackPane bottomPane = new StackPane(hbRack);
	        bottomPane.setAlignment(Pos.CENTER);
	        bottomPane.setPrefHeight(90); 
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
		if (tailleDuRackDuJoueur < 5) {
			longueurDAffichage = tailleDuRackDuJoueur;
		}
		for(int i=0;i<longueurDAffichage;i++) {
			Tuile tuile = rackDuJoueur.obtenirTuile(i);
			if (tuile != null) {
				try {
		            Image image = new Image(getClass().getResource(tuile.obtenirLienVersImage()).toString());
		            ImageView imageView = new ImageView(image);
		            Dnd.sourceDragAndDrop(imageView);
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
		
        Stage menuStage = new Stage();
        menuStage.initModality(Modality.APPLICATION_MODAL);
        menuStage.setTitle("Menu");

        Button btnpass = afficherboutton("passer son tour", "La joueur a passer son tour", menuStage); 
        Button btnacheter = afficherboutton("Acheter une Action (2)", "Le joueur a choisi d'acheter", menuStage);
        Button btnchangerRack = afficherboutton("Echanger son rack (2)", "Le joueur a échanger son rack", menuStage);
        Button btnfermerAction = afficherboutton("retour", null, menuStage);
                
        VBox vbBoutton1et2 = new VBox(10, btnacheter, btnpass);
        VBox vbBoutton3etfermer = new VBox(10, btnchangerRack, btnfermerAction);
        
        
        

        HBox menuaction = new HBox(15, vbBoutton1et2, vbBoutton3etfermer);
        
        
        menuaction.setStyle("-fx-padding: 20; -fx-alignment: center;");
        Scene menuScene = new Scene(menuaction, 400, 125);

        menuStage.setScene(menuScene);
        menuStage.showAndWait();
        menuStage.setResizable(false);
    }
	
	private Button afficherboutton(String string, String action, Stage stage) {
		
		final Button button = new Button(string);
		
		if (string != "retour") {
			button.setOnAction(e -> {
			System.out.println(action);
			stage.close();
			});
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
}
		
