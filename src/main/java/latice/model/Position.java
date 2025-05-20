package latice.model;

import java.util.Objects;

public class Position {
	private final Integer ligne;
	private final Integer colonne;
	
	public Position(Integer ligne, Integer colonne) {
		this.ligne = ligne;
		this.colonne = colonne;
	}

	public Integer getLigne() {
		return ligne;
	}

	public Integer getColonne() {
		return colonne;
	}	
	
	@Override
	public String toString() {
		return this.colonne+", "+this.ligne;
	}
	@Override
	public int hashCode() {
		return Objects.hash(colonne, ligne);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		return Objects.equals(colonne, other.colonne) && Objects.equals(ligne, other.ligne);
	}
}
