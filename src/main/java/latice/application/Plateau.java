package latice.application;


import javafx.application.Application;
import javafx.scene.Scene;
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
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

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
	        
			primaryStage.setTitle("Plateau Latice");
			Scene scene = new Scene(root, 1000, 700);
	        primaryStage.setScene(scene);

	        primaryStage.setResizable(false);
	        primaryStage.show();
		
	}
}
		
