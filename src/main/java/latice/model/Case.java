package latice.model;

import java.util.Objects;

public class Case {
	private final Type type;
	private Tuile tuile;
	
	
	public Case( Type type, Tuile tuile) {
		this.type = type;
		this.tuile = tuile;
	}
	
	public Case( Type type) {
		this.type = type;
		this.tuile = null;
	}
	
	public Case() {
		this(Type.NORMAL, null);
	}
	
	public Type getType() {
		return type;
	}
	
	public String getSmallerType() {
		Type type = getType();
		if (type == Type.LUNE) {
			return "L";
		}
		if  (type == Type.NORMAL) {
			return "N";
		}
		if  (type == Type.SOLEIL) {
			return "S";
		}
		return "erreur";
	}
	
	public Boolean estOccupe() {
		//TODO
		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tuile, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Case other = (Case) obj;
		return Objects.equals(tuile, other.tuile) && type == other.type;
	}
	
	
	
}
