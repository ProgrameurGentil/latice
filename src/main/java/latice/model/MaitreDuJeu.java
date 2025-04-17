package latice.model;

import java.util.ArrayList;
import java.util.Collections;

public class MaitreDuJeu {
	private Integer nb_tours;
	
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
	
	public ArrayList<Tuile> melangerTuiles(ArrayList<Tuile> tuiles){
		Collections.shuffle(tuiles);
		return tuiles;
	}
	
	public void diviserTuilesEnDeux(ArrayList<Tuile> tuiles, ArrayList<Tuile> demiTuiles1, ArrayList<Tuile> demiTuiles2) {
		Integer taille = tuiles.size();
		demiTuiles1 = new ArrayList<Tuile>(tuiles.subList(0, taille/2));
		demiTuiles2 = new ArrayList<Tuile>(tuiles.subList(taille/2, taille));
	}
	
	
	public ArrayList<Tuile> piocher5Tuiles(ArrayList<Tuile> pioche) {
		Integer taille = pioche.size();
		ArrayList<Tuile> rack = new ArrayList<>(pioche.subList(0, Math.min(5, pioche.size())));
		for (int i = 0; i < 5 && pioche.size()>0; i++) {
            pioche.remove(0);
        }
	    return rack;
	}
}

