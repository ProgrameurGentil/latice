package latice.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.List;

public class MaitreDuJeu {
	private Integer nb_tours;
	
	public Boolean gagner(Joueur joueur) {
		//TODO fonction qui retourne un boolean en si le joueur mit en parametre est gagnant
		return null;
	}
	public void lancerTour() {
		//TODO fonction qui lance un tour
	}
	public Joueur quelJoueurDoitJouer() {
		//TODO fonction qui retourne le joueur qui doit jouer
		return null;	
	}
	
	public void diviseEtRepartiLesTuilesEnPioches(Pioche touteLesTuile, List<Joueur> listeJoueurs) {
 		touteLesTuile.melanger();
	    int taille = touteLesTuile.taille();
	    int dividende = listeJoueurs.size();
	    int debutDePioche = 0;

	    for (int i = 0; i < listeJoueurs.size(); i++) {
	        int finDePioche = debutDePioche + (taille / dividende);
	        ArrayList<Tuile> piocheJoueur = new ArrayList<>(touteLesTuile.diviser(debutDePioche, finDePioche));
	        listeJoueurs.get(i).setPioche(new Pioche(piocheJoueur));
	        debutDePioche = finDePioche;
	    }
	}
}

