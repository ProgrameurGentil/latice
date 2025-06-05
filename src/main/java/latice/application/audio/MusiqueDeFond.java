package latice.application.audio;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusiqueDeFond {
	private MediaPlayer mediaPlayer;
	private String etatMusique = null;
	
	private static final String ERREUR_MEDIA = "[ERREUR][MusiqueDeFond] : javafx.media n'est pas dans les arguments de la VM";
	private static final String ERREUR_EXCEPTION = "[ERREUR][MusiqueDeFond] : une exception a été levé";
	private static final String ERREUR_CHARGEMENET_MEDIA = "[ERREUR][MusiqueDeFond] : le son n'a pas été chargé";
	
	private static final String DOSSIER = "/audio/";
	
	private void musiqueFond1() {
		etatMusique = "debut";
	    Media mediaMusic = new Media(getClass().getResource(DOSSIER + "musicFond1.mp3").toString());
	    mediaPlayer = new MediaPlayer(mediaMusic);
	    mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	private void endgame() {
		etatMusique = "fin";
	    Media mediaMusic = new Media(getClass().getResource(DOSSIER + "endgame.mp3").toString());
	    mediaPlayer = new MediaPlayer(mediaMusic);
	    mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	public void lancerMusiqueDePartie() {
		try {
	    	 musiqueFond1();
		} catch (java.lang.IllegalAccessError e1) {
			System.out.println(ERREUR_MEDIA);
		} catch (java.lang.NoClassDefFoundError e2) {
			System.out.println(ERREUR_MEDIA);
		} catch (java.lang.NullPointerException e3) {
			System.out.println(ERREUR_CHARGEMENET_MEDIA);
		} catch (Exception e4) {
			System.out.println(ERREUR_EXCEPTION);
		}
	}
	
	public void lancerMusiqueDeFinPartie() {
		try {
	    	 endgame();
		} catch (java.lang.IllegalAccessError e1) {
			System.out.println(ERREUR_MEDIA);
		} catch (java.lang.NoClassDefFoundError e2) {
			System.out.println(ERREUR_MEDIA);
		} catch (java.lang.NullPointerException e3) {
			System.out.println(ERREUR_CHARGEMENET_MEDIA);
		} catch (Exception e4) {
			System.out.println(ERREUR_EXCEPTION);
		}
	}
	
	public void stop() {
		if ( !(etatMusique.equals(null)) ) {
			mediaPlayer.stop();
			etatMusique = null;
		}
	} 
	
	public String etat() {
		return etatMusique;
	}
	
}
