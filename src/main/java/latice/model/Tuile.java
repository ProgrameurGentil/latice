package latice.model;

import java.util.Objects;

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
	
	public String obtenirLienVersImage() {
		return "/" + this.getForme() + "s/" + this.getForme() + "/" + this.getCouleur() + ".png";
	}

	@Override
	public int hashCode() {
		return Objects.hash(couleur, forme);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tuile other = (Tuile) obj;
		return couleur == other.couleur && forme == other.forme;
	}
}
