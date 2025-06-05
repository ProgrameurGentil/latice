package latice.application;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusiqueDeFond {
	MediaPlayer mediaPlayer;
	public void startMusic() {
	    Media mediaMusic = new Media(getClass().getResource("/audio/musicFond1.mp3").toString());
	    mediaPlayer = new MediaPlayer(mediaMusic);
	    mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	public void startEndGameMusic() {
	    Media mediaMusic = new Media(getClass().getResource("/audio/endgame.mp3").toString());
	    mediaPlayer = new MediaPlayer(mediaMusic);
	    mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
}
