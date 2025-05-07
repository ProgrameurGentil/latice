package latice.model;

import java.util.ArrayList;
import java.util.Collections;

public abstract class GroupeDeTuile {
	protected ArrayList<Tuile> tuiles;

	protected GroupeDeTuile(ArrayList<Tuile> tuiles) {
		this.tuiles = tuiles;
	}

	protected Integer taille() {
		return this.tuiles.size();
	}
	
	protected Tuile enlever(Integer indice) {
		Tuile tuile = this.tuiles.get(indice);
		this.tuiles.remove(indice);
		return tuile;
	}
	
	protected void ajouter(Tuile tuile) {
		this.tuiles.add(tuile);
	}
	
	protected void melanger() {
		Collections.shuffle(this.tuiles);
	}
	
	protected Tuile obtenirValeur(Integer indice) {
		return this.tuiles.get(indice);
	}

	@Override
	public String toString() {
		return "GroupeDeTuile [tuiles=" + tuiles + "]";
	}
	
}
