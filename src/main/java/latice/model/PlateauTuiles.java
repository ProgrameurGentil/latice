package latice.model;

import java.util.HashMap;
import java.util.Map;

public class PlateauTuiles{
	private final Map<Position, Tuile> tuiles;

	private Joueur joueur1;
	private Joueur joueur2;
	
	
	public PlateauTuiles(Joueur joueur1, Joueur joueur2) {
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.tuiles = new HashMap<>();
	}
	
	public Map<Position, Tuile> tuiles() {
		return tuiles;
	}

	public boolean siTuileIci(Position position) {
		return tuiles.containsKey(position);
	}

	public boolean siVide() {
		return tuiles.isEmpty();
	}

	public boolean poser(Position position, Tuile tuile) {
		if(tuiles.putIfAbsent(position, tuile) == null) {
			return true;
		}
		return false;
	}

	public void vider() {
		tuiles.clear();
	}

	public int combienDeTuiles() {
		return tuiles.size();
	}

	public Tuile tuilesAPosition(Position position) {
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