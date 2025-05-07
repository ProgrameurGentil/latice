package latice.model;

import java.util.ArrayList;
import java.util.Collections;

public abstract class GroupeDeTuile {
	private ArrayList<Tuile> tuiles;

	public GroupeDeTuile(ArrayList<Tuile> tuiles) {
		this.tuiles = tuiles;
	}

	public Integer taille() {
		return this.tuiles.size();
	}
	
	public Tuile enlever(Integer indice) {
		Tuile tuile = this.tuiles.get(indice);
		this.tuiles.remove(indice);
		return tuile;
	}
	
	public void ajouter(Tuile tuile) {
		this.tuiles.add(tuile);
	}
	
	public void melanger() {
		Collections.shuffle(this.tuiles);
	}
}
