package latice.model;

public class Tuile {
	private final Couleur couleur;
	private final Forme forme;
	
	public Tuile(Couleur couleur, Forme forme) {
		this.couleur = couleur;
		this.forme = forme;
	}

	@Override
	public String toString() {
		return forme+" de couleur "+couleur;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public Forme getForme() {
		return forme;
	}
}
