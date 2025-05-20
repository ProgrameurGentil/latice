package latice.application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
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
import javafx.stage.Stage;
import latice.model.Couleur;
import latice.model.Forme;
import latice.model.Joueur;
import latice.model.Pioche;
import latice.model.Rack;
import latice.model.Tuile;

public class Plateau extends Application{
	 private static final int colonnes = 9;
	 private static final int lignes = 9;
	 private static final double case_taille = 62.0;
	 private HBox rack = new HBox();
	 
	 public static void main(String[] args) {
	        launch(args);
	    }
	@Override
	public void start(Stage primaryStage) throws Exception{
			BorderPane root = new BorderPane();		
			rack.setStyle(
		            "-fx-border-width: 10;" + "-fx-border-radius: 15;" + "-fx-padding: 20;");
			rack.setPrefWidth(340);
			rack.setPrefHeight(85);
			rack.setMaxSize(350, 90);
			
			Image bgImage = new Image(getClass().getResourceAsStream("/rack/fond.png"));

			BackgroundImage backgroundImage = new BackgroundImage(
			    bgImage,
			    BackgroundRepeat.NO_REPEAT,
			    BackgroundRepeat.NO_REPEAT,
			    BackgroundPosition.CENTER,
			    new BackgroundSize(
			        350, 90, false, false, false, false)
			);

			rack.setBackground(new Background(backgroundImage));
			
			
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
	                Dnd.sourceDragAndDrop(imageView);
	                imageView.setFitHeight(case_taille);
	                imageView.setFitWidth(case_taille);
	                imageView.setPreserveRatio(true);
	                imageView.setPickOnBounds(true);

	                GridPane.setHgrow(imageView, Priority.ALWAYS);
	                GridPane.setVgrow(imageView, Priority.ALWAYS);

	                plateau.add(imageView, col, row);
	            }
	        }
	        Image img = new Image(getClass().getResourceAsStream("/plateau/plateau.png"));
	        BackgroundImage background = new BackgroundImage(
	        		img,
	                BackgroundRepeat.NO_REPEAT,  
	                BackgroundRepeat.NO_REPEAT,  
	                BackgroundPosition.DEFAULT,  
	                new BackgroundSize(
	                        558, 558, false, false, true, false));
	        plateau.setBackground(new Background(background));
	        
	        root.setCenter(plateau);
	        

	        VBox vb = new VBox();
	        
	        Label pointsJ1 = new Label("Points du joueur 1 : ");
	        Label pointsJ2 = new Label("Points du joueur 2 : ");
	        vb.getChildren().addAll(pointsJ1,pointsJ2);
	        root.setLeft(vb);
	        
	        vb.setAlignment(Pos.CENTER_LEFT);

	        StackPane bottomPane = new StackPane(rack);
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
		for(int i=0;i<5;i++) {
			Tuile tuile = rackDuJoueur.obtenirTuile(i);
			if (tuile != null) {
	            Image image = new Image(getClass().getResourceAsStream(tuile.obtenirLienVersImage()));
	            ImageView imageView = new ImageView(image);
	            Dnd.cibleDragAndDrop(imageView);
	            imageView.setFitWidth(62);
	            imageView.setFitHeight(62);
	            imageView.setPreserveRatio(true);
	            rack.getChildren().add(imageView);
	        }
		}
	}
}
		
