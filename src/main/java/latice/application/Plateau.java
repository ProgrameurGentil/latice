package latice.application;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
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
	        plateau.setPrefSize(558, 544);
	        plateau.setMinSize(558, 544);
	        plateau.setMaxSize(558, 558);

	        for (int col = 0; col < colonnes; col++) {
	            ColumnConstraints colConst = new ColumnConstraints();
	            colConst.setMinWidth(10);
	            colConst.setPrefWidth(100);
	            colConst.setHgrow(Priority.SOMETIMES);
	            plateau.getColumnConstraints().add(colConst);
	        }

	        for (int row = 0; row < lignes; row++) {
	            RowConstraints rowConst = new RowConstraints();
	            rowConst.setMinHeight(10);
	            rowConst.setPrefHeight(30);
	            rowConst.setVgrow(Priority.SOMETIMES);
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
	        ImageView imgv = new ImageView();

	        root.setCenter(plateau);
			primaryStage.setTitle("Plateau Latice");
			
			root.getChildren().addAll(imgv);
			Scene scene = new Scene(root, 1000, 700);
	        primaryStage.setScene(scene);

	        primaryStage.setResizable(false);
	        primaryStage.show();
		
	}
}
		
