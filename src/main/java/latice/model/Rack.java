package latice.model;

import java.util.ArrayList;
import java.util.List;

public class Rack extends GroupeDeTuile {

	private static final String LINE_BAR = "+--------------+";

	public Rack(List<Tuile> tuiles) {
		super(tuiles);
	}
	
	public Rack() {
		this(new ArrayList<Tuile>());
	}

	public void afficher() {
		System.out.println(LINE_BAR);
		for (Tuile tuile : this.tuiles) {
			System.out.println(tuile);
		}
		System.out.println(LINE_BAR);
	}
	
	public void remplirLeRack(Pioche pioche) {
		Integer taillePioche = pioche.taille();
		Integer tailleRack = this.taille();
		while (taillePioche > 0 && tailleRack < 5) {
			this.ajouter(pioche.enlever(0)); // peut avoir une erreur si le l'indice n'est pas trouvé
			taillePioche--;
			tailleRack++;
		}
	}
}
