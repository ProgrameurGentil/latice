package latice.model;

import java.util.HashMap;
import java.util.Map;

public class PlateauDeCase {
	private final Map<Position, Case> cases;
	
	public PlateauDeCase() {
		this.cases = new HashMap<>();
	}

	public Map<Position, Case> cases() {
		return cases;
	}
	
	public boolean put(Position position, Case caseDePlus) {
		if(cases.putIfAbsent(position, caseDePlus) == null) {
			return true;
		}
		return false;
	}
	
	public boolean isCaseAt(Position position) {
		return cases.containsKey(position);
	}

	public boolean isEmpty() {
		return cases.isEmpty();
	}

	public Case caseAt(Position position) {
		return cases.get(position);
	}

	public Case TurnToSun(Position position) {
		return null;
		// TODO : one line instruction : see in javadoc ;-;
	}

	public String toAscii() {
		return "";
		// TODO
	}
}

