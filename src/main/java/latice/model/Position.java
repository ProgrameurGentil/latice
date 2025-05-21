package latice.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
	
	public static Position position(int indice) {
		// erreur, faire un execpetion
		if (indice < 1 || indice > 81) {
			System.out.println("indice inexistant sur plateau");
			return new Position(0,0);
		}
		//le reste
		int colonne = (indice / 9);
		int ligne = (indice % 9);
		if (ligne == 0) {
			ligne = 8;
			colonne--;
		} else ligne--;
		return new Position(colonne,ligne);
	}
	
	public List<Position> caseAutour(){
		int colonne = this.getColonne();
		int ligne = this.getLigne();
		Position positionAuDessus = new Position(colonne,ligne-1);
		Position positionADroit = new Position(colonne+1,ligne);
		Position positionEnBas = new Position(colonne,ligne+1);
		Position positionAGauche = new Position(colonne-1,ligne);
		List<Position> caseAutours = new ArrayList<Position>(Arrays.asList(positionAuDessus,positionADroit,positionEnBas,positionAGauche));
		return caseAutours;
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
