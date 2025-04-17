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
}

