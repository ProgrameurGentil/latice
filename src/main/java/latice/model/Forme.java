package latice.model;

public enum Forme {
	FLEUR("fleur"),
	PLUME("plume"),
	DAUPHIN("dauphin"),
	TORTUE("tortue"),
	OISEAU("oiseau"),
	LEZARD("lezard");
	
	private final String nom;
	
	Forme(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return this.nom;
	}
}
