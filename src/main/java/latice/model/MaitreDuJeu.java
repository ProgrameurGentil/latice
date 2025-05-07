package latice.model;

import java.util.ArrayList;
import java.util.Collections;

public class MaitreDuJeu {
	private Integer nb_tours;
	public ArrayList<Joueur> listeJoueurs;
	
	public Boolean gagner(Joueur joueur) {
		//TODO
		return null;
	}
	public void lancerTour() {
		//TODO
	}
	public Joueur aQuiLeTour() {
		//TODO
		return null;	
	}
	
	public ArrayList<Tuile> initTuiles() {
		ArrayList<Tuile> touteLesTuile = new ArrayList<Tuile>();
		for (int count=0;count<2;count++) {
			for (Couleur couleur : Couleur.values()) {
				for (Forme forme : Forme.values()) {
					touteLesTuile.add(new Tuile(couleur, forme));
				}
	        }
		}
		return touteLesTuile;
	}
	
	public void melangerTuiles(ArrayList<Tuile> tuiles){
		Collections.shuffle(tuiles);
		//return tuiles; //pas obligatoire
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
			joueur.pioche = new Pioche(demiTuiles);
 		}
	}

	public ArrayList<Tuile> piocher5Tuiles(ArrayList<Tuile> pioche, ArrayList<Tuile> rack) {

		Integer taille = pioche.size();
		for (int i = 0; i < 5 && taille>0 && rack.size() < 5; i++) {
            rack.add(pioche.remove(0));
            taille = pioche.size();
        }
	    return rack; 
	}
}

