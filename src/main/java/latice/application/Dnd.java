package latice.application;


import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

public class Dnd {
	public static void sourceDragAndDrop(ImageView source) {
		source.setOnDragDetected(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				Dragboard db = source.startDragAndDrop(TransferMode.ANY);
		        
		        ClipboardContent content = new ClipboardContent();
		        content.putImage(source.getImage());
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
	
	public static void cibleDragAndDrop(ImageView cible) {
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
		           cible.setImage(db.getImage());
		           cible.setOpacity(1);
		           success = true;
		           enleverDragAndDrop(cible);
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
		        	cible.setImage(db.getImage());
		        	cible.setOpacity(0.5);
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
}
