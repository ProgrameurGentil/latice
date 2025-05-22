package latice.application;

import java.io.InputStream;

import javafx.scene.image.Image;
import latice.model.Tuile;

public class ImageTuile extends Image {
	private final InputStream url;
	private Tuile tuile;
	
	public ImageTuile(InputStream url, Tuile tuile) {
		super(url);
		this.url = url;
		this.tuile = tuile;
	}


	public InputStream url() {
		return url;
	}
	
	public Tuile tuile() {
		return this.tuile;
	}

}
