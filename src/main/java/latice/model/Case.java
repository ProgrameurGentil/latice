package latice.model;

import java.util.Objects;

public class Case {
	private final Type type;
	
	
	public Case( Type type) {
		this.type = type;
	}
	
	
	public Case() {
		this(Type.NORMAL);
	}
	
	public Type getType() {
		return type;
	}
	
	public String ecrireCaseEnUneLettre() {
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

	@Override
	public int hashCode() {
		return Objects.hash(type);
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
		return type == other.type;
	}
	
	
}
