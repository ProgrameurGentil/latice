package latice.model;

import java.util.HashMap;
import java.util.Map;

public class Plateau{
	private final Map<Position, Tuile> tuiles;

	private Joueur joueur1;
	private Joueur joueur2;
	
	
	public Plateau(Joueur joueur1, Joueur joueur2) {
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.tuiles = new HashMap<>();
	}
	
	public Map<Position, Tuile> tuiles() {
		return tuiles;
	}

	public boolean isTuileAt(Position position) {
		return tuiles.containsKey(position);
	}

	public boolean isEmpty() {
		return tuiles.isEmpty();
	}

	public boolean put(Position position, Tuile tuile) {
		if(tuiles.putIfAbsent(position, tuile) == null) {
			return true;
		}
		return false;
	}

	public void clear() {
		tuiles.clear();
	}

	public int howManyTuilesOnBoard() {
		return tuiles.size();
	}

	public Tuile tuileAt(Position position) {
		return tuiles.get(position);
	}

	public Tuile removeTuileAt(Position position) {
		return null;
		// TODO : one line instruction : see in javadoc ;-;
	}

	public String toAscii() {
		return "";
		// TODO
	}
}