package latice.model;

import java.util.ArrayList;

public class Pioche extends GroupeDeTuile{
	private GroupeDeTuile tuiles;
	
	public Pioche(ArrayList<Tuile> tuiles) {
		super(tuiles);
	}

	public Pioche() {
		this(new ArrayList<Tuile>());
	}
	
}
