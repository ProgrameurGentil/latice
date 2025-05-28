package latice.application;


import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import latice.model.Constantes;
import latice.model.PlateauTuiles;
import latice.model.Position;
import latice.model.Tuile;

public class Dnd {
	public static void sourceDragAndDrop(ImageView source) {
		source.setOnDragDetected(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				Dragboard db = source.startDragAndDrop(TransferMode.ANY);
		        
		        ClipboardContent content = new ClipboardContent();
		        content.putImage(source.getImage());
		        content.putString(source.getImage().getUrl());
		        db.setContent(content);
		        
		        event.consume();
			}
			
		});
		
		source.setOnDragDone(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				if (event.getTransferMode() == TransferMode.MOVE) {
		            source.setImage(null);
		        }
		        event.consume();
			}
		});
	}
	
	public static void cibleDragAndDrop(ImageView cible, PlateauTuiles plateauTuiles) {
		cible.setOnDragOver(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				if (event.getGestureSource() != cible && event.getDragboard().hasImage()) {
		            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
		        }
				
		        event.consume();
			}
		});
		
		cible.setOnDragDropped(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				Dragboard db = event.getDragboard();
		        boolean success = false;
		        
		        if (db.hasImage()) {
		        	
					//System.out.println(obtenirTuileAvecUnChemin(db.getString())); //
					
					Position postionTuile =  new Position(GridPane.getColumnIndex(cible), GridPane.getRowIndex(cible));
					
					if (plateauTuiles.siTuilePosableIci(obtenirTuileAvecUnChemin(db.getString()), postionTuile)) {
						cible.setImage(db.getImage());
						cible.setOpacity(1);
						success = true;
						enleverDragAndDrop(cible);
						plateauTuiles.poser(postionTuile, obtenirTuileAvecUnChemin(db.getString()));
					}
		        }
		        
		        event.setDropCompleted(success);
		        event.consume();
			}
		}); 
		
		cible.setOnDragEntered(new EventHandler<DragEvent>() { 
			/* des modifs peuvent avoir lieux ici pour montrer si une tuile peut etre placer ou non */

			@Override
			public void handle(DragEvent event) {
				Dragboard db = event.getDragboard();
		        
		        if (db.hasImage()) {
		        	
		        	if (plateauTuiles.siTuilePosableIci(obtenirTuileAvecUnChemin(db.getString()), new Position(GridPane.getColumnIndex(cible), GridPane.getRowIndex(cible)))) {
			        	cible.setImage(db.getImage());
		        	} else {
		        		cible.setImage(new Image(getClass().getResource("/tuiles/tuile_interdite.png").toString()));
		        	}
		        	cible.setOpacity(0.5);
		        	//System.out.println("ligne :" + GridPane.getRowIndex(cible));
		        	//System.out.println("colonne :" + GridPane.getColumnIndex(cible));
		        	
		        }
		        
		        event.consume();
			}
		});
		
		cible.setOnDragExited(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
		        cible.setImage(null);
		        
		        event.consume();
			}
		});
	}
	
	private static void enleverDragAndDrop(ImageView image) {
		image.setOnDragOver(null);
		image.setOnDragDropped(null);
		image.setOnDragDetected(null);
		image.setOnDragDone(null);
		image.setOnDragEntered(null);
		image.setOnDragExited(null);
	}
	
	private static Tuile obtenirTuileAvecUnChemin(String chemin) {
		String base = "file:/D:/java/iut/saebut1/latice/target/classes";
		chemin = chemin.substring(base.length());
		Tuile tuile;
		Integer tailleTouteLesTuiles = Constantes.TOUTE_LES_TUILES.taille();
		
		for (int i=0 ; i<tailleTouteLesTuiles ; i++) {
			tuile = Constantes.TOUTE_LES_TUILES.obtenirTuile(i);
			if (tuile.obtenirLienVersImage().equals(chemin)) {
				return tuile;
			}
		}
		return new Tuile(null, null); // A changer
	}
	
}