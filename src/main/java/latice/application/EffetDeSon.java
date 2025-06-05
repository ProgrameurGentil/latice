package latice.application;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class EffetDeSon {
	
	private static final String ERREUR_MEDIA = "[ERREUR][EffetDeSon] : javafx.media n'est pas dans les arguments de la VM";
	private static final String ERREUR_EXCEPTION = "[ERREUR][EffetDeSon] : une exception a été levé";
	private static final String ERREUR_CHARGEMENET_MEDIA = "[ERREUR][EffetDeSon] : le son n'a pas été chargé";

	private static void achat() {
		Media media = new Media(EffetDeSon.class.getResource("/son/achat.mp3").toString());
	    MediaPlayer mediaPlayer = new MediaPlayer(media);
	    mediaPlayer.stop();
	    mediaPlayer.seek(Duration.ZERO);
	    mediaPlayer.play();
	}
	
	private static void haha() {
		Media media = new Media(EffetDeSon.class.getResource("/son/haha.mp3").toString());
	    MediaPlayer mediaPlayer = new MediaPlayer(media);
	    mediaPlayer.stop();
	    mediaPlayer.seek(Duration.ZERO);
	    mediaPlayer.play();
	}
	
	public static void joueurSonAchat() {
	    try {
	    	 achat();
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
	
	public static void joueurSonHaHa() {
	    try {
	    	haha();
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
}
