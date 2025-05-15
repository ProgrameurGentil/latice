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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import latice.model.Rack;
import latice.model.Tuile;

public class Plateau extends Application{
	 private static final int colonnes = 9;
	 private static final int lignes = 9;
	 private static final double case_taille = 62.0;
	 
	 public static void main(String[] args) {
	        launch(args);
	    }
	@Override
	public void start(Stage primaryStage) throws Exception{
			BorderPane root = new BorderPane();

	        GridPane plateau = new GridPane();
	        plateau.setGridLinesVisible(true);
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
	        
	        Image imgdr = new Image(getClass().getResourceAsStream("/tuiles/dauphins/dauphin_rose.png"));
	        Image imgrb = new Image(getClass().getResourceAsStream("/tuiles/dauphins/dauphin_rose.png"));
	        Image imgobf = new Image(getClass().getResourceAsStream("/tuiles/dauphins/dauphin_rose.png"));
	        Image imglv = new Image(getClass().getResourceAsStream("/tuiles/dauphins/dauphin_rose.png"));
	        Image imgpr = new Image(getClass().getResourceAsStream("/tuiles/dauphins/dauphin_rose.png"));
	        ImageView dbrs = new ImageView(imgdr);
	        ImageView dbrg = new ImageView(imgpr);
	        ImageView dbrb = new ImageView(imgrb);
	        ImageView dbobf = new ImageView(imgobf);
	        ImageView dblv = new ImageView(imglv);

	        VBox vb = new VBox();
	        
	        Label pointsJ1 = new Label("Points du joueur 1 : ");
	        Label pointsJ2 = new Label("Points du joueur 2 : ");
	        vb.getChildren().addAll(pointsJ1,pointsJ2);
	        root.setLeft(vb);
	        
	        vb.setAlignment(Pos.CENTER_LEFT);
	        
	        
	        HBox rack = new HBox();
	        rack.getChildren().addAll(dbrs, dbrg, dbrb, dbobf, dblv);
	        root.setBottom(rack);
	        rack.setAlignment(Pos.CENTER);
	        
			primaryStage.setTitle("Plateau Latice");
			Scene scene = new Scene(root, 1000, 700);
	        primaryStage.setScene(scene);
	        
	        primaryStage.setResizable(false);
	        primaryStage.show();
		
	}

	
}
		
