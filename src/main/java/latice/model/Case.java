package latice.model;

public class Case {
	private final Type type;
	private Tuile tuile;
	
	public Case( Type type, Tuile tuile) {
		this.type = type;
		this.tuile = tuile;
	}

	public Type getType() {
		return type;
	}
	
	public Boolean estOccupé() {
		//TODO
		return true;
	}
	
	public Position getPosition() {
		return position;
	}
	
}
