package latice.model;

import java.util.HashMap;
import java.util.Map;

public class PlateauTuiles{
	private final Map<Position, Tuile> tuiles;
	
	
	public PlateauTuiles() {
		this.tuiles = new HashMap<>();
	}
	
	public Map<Position, Tuile> tuiles() {
		return tuiles;
	}

	public boolean siTuileIci(Position position) {
		return tuiles.containsKey(position);
	}

	public boolean siListTuileVide() {
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

	public Tuile donnerTuilesAPosition(Position position) {
		return tuiles.get(position);
	}
}