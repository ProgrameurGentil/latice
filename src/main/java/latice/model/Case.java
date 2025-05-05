package latice.model;

public class Case {
	private Position position;
	private final Type type;
	private Tuile tuile;
	
	public Case(Position position, Type type, Tuile tuile) {
		this.position = position;
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
	
}
