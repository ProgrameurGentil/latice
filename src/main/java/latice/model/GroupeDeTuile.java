package latice.model;

import java.util.ArrayList;

public abstract class GroupeDeTuile {
	private ArrayList<Tuile> tuiles;

	public GroupeDeTuile(ArrayList<Tuile> tuiles) {
		this.tuiles = tuiles;
	}

	public Integer getTaille() {
		return tuiles.size();
	}
	
	public void add(Tuile tuile) {
		tuiles.add(tuile);
	}
	
	public Tuile remove(int ind) {
		Tuile tuile = tuiles.remove(ind);
		return tuile;
	}
}
