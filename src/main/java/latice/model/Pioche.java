package latice.model;

import java.util.ArrayList;
import java.util.List;

public class Pioche extends GroupeDeTuile{
	
	public Pioche(List<Tuile> touteLesTuileList) {
		super(touteLesTuileList);
	}

	public Pioche() {
		this(new ArrayList<Tuile>());
	}
}