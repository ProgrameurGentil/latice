package latice.model;

import java.util.ArrayList;
import java.util.List;

public class Rack extends GroupeDeTuile {

	private static final String LINE_BAR = "+--------------+";

	public Rack(List<Tuile> tuiles) {
		super(tuiles);
		// Auto-generated constructor stub
	}
	
	public Rack() {
		this((List) new ArrayList<Tuile>());
	}

	public void afficher() {
		System.out.println(LINE_BAR);
		for (Tuile tuile : this.tuiles) {
			System.out.println(tuile);
		}
		System.out.println(LINE_BAR);
	}
}
