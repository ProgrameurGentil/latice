package latice.model;

import java.util.ArrayList;
import java.util.Collections;

public class MaitreDuJeu {
	private Integer nb_tours;
	public ArrayList<Joueur> listeJoueurs;
	
	public Boolean gagner(Joueur joueur) {
		//TODO fonction qui retourne un boolean en si le joueur mit en parametre est gagnant
		return null;
	}
	public void lancerTour() {
		//TODO fonction qui lance un tour
	}
	public Joueur aQuiLeTour() {
		//TODO fonction qui retourne le joueur qui doit jouer
		return null;	
	}
	
	public ArrayList<Tuile> initTuiles() {
		ArrayList<Tuile> touteLesTuile = new ArrayList<Tuile>();
		
		for (Couleur couleur : Couleur.values()) {
			for (Forme forme : Forme.values()) {
				for (int count=0;count<2;count++) {
					touteLesTuile.add(new Tuile(couleur, forme));
				}
	        }
		}
		return touteLesTuile;
	}
	
	public void melangerTuiles(GroupeDeTuile tuiles){
		tuiles.melanger();
	}
	
	public void diviserTuilesEnDeux(ArrayList<Tuile> tuiles, ArrayList<Joueur> listeJoueurs) {
		ArrayList<Tuile> demiTuiles = new ArrayList<Tuile>();
		Integer taille = tuiles.size();
		Integer dividende = listeJoueurs.size();
		Integer debutDePioche = 0;
		Integer nb_decoupage = 0;
		Integer finDePioche;
 		for (Joueur joueur : listeJoueurs){ 
			finDePioche = (taille/dividende) * nb_decoupage;
			demiTuiles.addAll(tuiles.subList(debutDePioche, finDePioche));
			debutDePioche = finDePioche;
			nb_decoupage++;
			joueur.pioche = new Pioche(demiTuiles); // TODO
 		}
	}

	public void piocher5Tuiles(Pioche pioche, Rack rack) {

		Integer taille = pioche.taille();
		Integer i = 0;
		while (i < 5 && taille > 0 && rack.taille() < 5) {
			rack.ajouter(pioche.enlever(0));
            taille--;
            i++;
		}
	}
}

