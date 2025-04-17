package latice.model;

public class Case {
	private Integer colonne;
	private Integer ligne;
	private final Type type;
	
	public Case(Integer colonne, Integer ligne, Type type) {
		this.colonne = colonne;
		this.ligne = ligne;
		this.type = type;
	}

	public Integer getColonne() {
		return colonne;
	}

	public void setColonne(Integer colonne) {
		this.colonne = colonne;
	}

	public Integer getLigne() {
		return ligne;
	}

	public void setLigne(Integer ligne) {
		this.ligne = ligne;
	}

	public Type getType() {
		return type;
	}
	
	public Boolean estOccupé() {
		//TODO
		return true;
	}
	
}
