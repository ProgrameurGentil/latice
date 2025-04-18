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
	
	public void melangerTuiles(ArrayList<Tuile> tuiles){
		Collections.shuffle(tuiles);
		//return tuiles; //pas obligatoire
	}
	
	public void diviserTuilesEnDeux(ArrayList<Tuile> tuiles, ArrayList<Tuile> demiTuiles1, ArrayList<Tuile> demiTuiles2) {
		Integer taille = tuiles.size();
		demiTuiles1.addAll(tuiles.subList(0, taille/2));
		demiTuiles2.addAll(tuiles.subList(taille/2, taille));
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

