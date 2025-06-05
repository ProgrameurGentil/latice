package latice.model;

import java.util.ArrayList;
import java.util.List;

public class MaitreDuJeu {
	
	/*public Boolean gagner(Joueur joueur) {
		if (joueur.getPioche().taille() == 0 && joueur.getRack().taille() == 0) return true; 
		else return false;
	}*/
	
	
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
	
	public Boolean estCeQunJoueurAPLusDeTuiles(List<Joueur> listeDeJoueurs) {
		for (Joueur joueur : listeDeJoueurs) {
			if (joueur.nombreDeTuilesToTal().equals(0)) {
				return true;
			}
		}
		return false;
	}
	
	public Joueur quelJoueurAPlusDeTuiles(List<Joueur> listeDeJoueurs) {
		Joueur joueurGagnant = null;
		for (Joueur joueur : listeDeJoueurs) {
			if (joueur.nombreDeTuilesToTal().equals(0)) {
				joueurGagnant = joueur;
			}
		}
		return joueurGagnant;
	}
	
	public Joueur quelJoueurALeMoinsDeTuiles(List<Joueur> listeDeJoueurs) {
		Joueur joueurGagnant = listeDeJoueurs.get(0);
		for (int i = 1; i<listeDeJoueurs.size()-1 ;  i++ ) {
			if (listeDeJoueurs.get(i).nombreDeTuilesToTal() < joueurGagnant.nombreDeTuilesToTal()) {
				joueurGagnant = listeDeJoueurs.get(i);
			}
		}
		return joueurGagnant;
	}
}

