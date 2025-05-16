package latice.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroupeDeTuile {
	protected List<Tuile> tuiles;

	public GroupeDeTuile(List<Tuile> touteLesTuileList) {
		this.tuiles = touteLesTuileList;
	}

	public Integer taille() {
		return this.tuiles.size();
	}
	
	public Tuile enlever(Integer indice) {
		Tuile tuile = this.tuiles.get(indice);
		this.tuiles.remove((int) indice);
		return tuile;
	}
	
	public void ajouter(Tuile tuile) {
		this.tuiles.add(tuile);
	}
	
	public void melanger() {
		Collections.shuffle(this.tuiles);
	}
	
	public Tuile obtenirTuile(Integer indice) {
		return this.tuiles.get(indice);
	}

	@Override
	public String toString() {
		return "GroupeDeTuile [tuiles=" + tuiles + "]";
	}
	
	public List<Tuile> diviser(int debutDePioche, int finDePioche) {
		return this.tuiles.subList(debutDePioche, finDePioche);
	}
}
