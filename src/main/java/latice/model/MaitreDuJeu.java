package latice.model;

import java.util.ArrayList;
import java.util.List;

public class MaitreDuJeu {
	private Integer nb_tours;
	
	public Boolean gagner(Joueur joueur) {
		if (joueur.getPioche().taille() == 0 && joueur.getRack().taille() == 0) return null; 
		else return false;
	}
	
	public void lancerTour(List<Joueur> joueurs) {
		Joueur joueur = new Joueur("nom");
		while (this.gagner(joueur) != true) {	
			joueur = joueurs.get(0);
			while (joueur.getNombreActionRestanteAJouer() > 0) {
				//joueur = joueur.jouer();
			}
			
			joueur = joueurs.get(1);
			while (joueur.getNombreActionRestanteAJouer() > 0) {
				//joueur = joueur.jouer();
			}
		}
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
	
	public Integer quelJoueurCommence(List<Joueur> listeJoueurs) {
		return (int)(Math.random() * listeJoueurs.size());
	}
}

