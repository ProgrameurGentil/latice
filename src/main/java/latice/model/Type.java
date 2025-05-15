package latice.model;

public enum Type {
	SOLEIL("soleil"),
	LUNE("lune"),
	NORMAL("normal");
	
	private final String nom;
	
	Type(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return this.nom;
	}
}
