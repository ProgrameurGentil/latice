package latice.model;

import java.util.ArrayList;
import java.util.List;
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
	
	public static Pioche initialisationTuiles() {
		List<Tuile> touteLesTuileList = new ArrayList<Tuile>();
		
		for (Couleur couleur : Couleur.values()) {
			for (Forme forme : Forme.values()) {
				for (int count=0;count<2;count++) {
					touteLesTuileList.add(new Tuile(couleur, forme));
				}
	        } 
		}
		Pioche touteLesTuilePioche = new Pioche(touteLesTuileList);
		return touteLesTuilePioche;
	}
}
