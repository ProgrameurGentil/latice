package latice.application;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.application.Platform;
import latice.application.popup.PopUpGagnant;
import latice.model.Joueur;
import latice.model.MaitreDuJeu;
import latice.model.Pioche;
import latice.model.Tuile;

public class LaticeMain {
	private static Plateau plateau;
	private static List<Joueur> listeDeJoueurs = new ArrayList<Joueur>();
	private static Integer indiceDuJoueurQuiJoue;
	private static Integer nbTours = 0;
	public static final Integer NB_TOURS_MAX = 10;
	private static final MaitreDuJeu maitreDuJeu = new MaitreDuJeu();

	public static void main(String[] args) {
		final Pioche toutesLesTuiles = Tuile.initialisationTuiles();
		
		listeDeJoueurs.add(new Joueur("Joueur 1"));
		listeDeJoueurs.add(new Joueur("Joueur 2"));
		
		maitreDuJeu.diviseEtRepartiLesTuilesEnPioches(toutesLesTuiles, listeDeJoueurs);
		
		System.out.println(listeDeJoueurs.get(0).getPioche());
		System.out.println(listeDeJoueurs.get(1).getPioche());
		System.out.println(toutesLesTuiles.getTuiles());
		
		for (Joueur joueur : listeDeJoueurs) {
			joueur.remplirSonRack();
			//System.out.println(joueur.getRack().toString());
		}
		
		indiceDuJoueurQuiJoue = maitreDuJeu.quelJoueurCommence(listeDeJoueurs);
		
		// Lancement de la parite
		
		new Thread(() -> Application.launch(Plateau.class)).start();
		
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            plateau = Plateau.getInstance();
            if (plateau != null) {
            	Platform.runLater(() -> plateau.afficherlerackdujoueur(listeDeJoueurs.get(indiceDuJoueurQuiJoue)));
                executor.shutdown();
            } else {
                System.out.println("En attente de l'initialisation du Plateau...");
            }
        }, 0, 200, TimeUnit.MILLISECONDS);
		/**/
		
	}
	
	public static void joueurSuivant() {
		if ( (!nbTours.equals(NB_TOURS_MAX*listeDeJoueurs.size())) || maitreDuJeu.estCeQunJoueurAPLusDeTuiles(listeDeJoueurs)) {
			indiceDuJoueurQuiJoue = (indiceDuJoueurQuiJoue+1) % listeDeJoueurs.size();
			Joueur joueur = listeDeJoueurs.get(indiceDuJoueurQuiJoue);
			joueur.remplirSonRack();
			plateau.afficherlerackdujoueur(joueur);
			nbTours++;
		} else {
			System.out.println("Fin de la partie : nb de tours max atteint");
			finDeLaPartie();
		}
	}
	
	public static Integer getNbTours() {
		return nbTours;
	}
	
	private static void finDeLaPartie() {
		Joueur joueurQuiAGagne;
		if (maitreDuJeu.estCeQunJoueurAPLusDeTuiles(listeDeJoueurs)) {
			joueurQuiAGagne = maitreDuJeu.quelJoueurAPlusDeTuiles(listeDeJoueurs);
		} else {
			joueurQuiAGagne = maitreDuJeu.quelJoueurALeMoinsDeTuiles(listeDeJoueurs);
		}
		System.out.println(listeDeJoueurs.get(0).getNom() + " : pioche -> " + listeDeJoueurs.get(0).getPioche().taille() + " ; rack -> " + listeDeJoueurs.get(0).getRack().taille());
		System.out.println(listeDeJoueurs.get(1).getNom() + " : pioche -> " + listeDeJoueurs.get(1).getPioche().taille() + " ; rack -> " + listeDeJoueurs.get(1).getRack().taille());
		Plateau.getMusiqueDeFond().stop();
		new PopUpGagnant(joueurQuiAGagne).afficher();
	}
}
