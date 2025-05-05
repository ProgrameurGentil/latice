package latice.model;

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
}
