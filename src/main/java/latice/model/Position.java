package latice.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Position { // La postion est fait comme : Colonne ; Ligne
	private final Integer ligne;
	private final Integer colonne;
	
	public Position(Integer colonne, Integer ligne) {
		this.ligne = ligne;
		this.colonne = colonne;
	}

	public Integer getLigne() {
		return ligne;
	}

	public Integer getColonne() {
		return colonne;
	}	
	
//	public static Position position(int indice) {
//		// erreur, faire un execpetion
//		if (indice < 1 || indice > 81) {
//			System.out.println("indice inexistant sur plateau");
//			return new Position(0,0);
//		}
//		//le reste
//		int colonne = (indice / 9);
//		int ligne = (indice % 9);
//		if (ligne == 0) {
//			ligne = 8;
//			colonne--;
//		} else ligne--;
//		return new Position(colonne,ligne);
//	}
	public List<Position> positionAutour(){
		Position positionAuDessus = null;
		Position positionADroit = null;
		Position positionEnBas = null;
		Position positionAGauche = null;
		int colonne = this.getColonne();
		int ligne = this.getLigne();		
		if (colonne >= 0 && colonne <= 8 && ligne >= 0 && ligne <= 8) {

	        if (ligne > 0) {
	            positionAuDessus = new Position(colonne, ligne - 1);
	        }

	        if (colonne < 8) {
	            positionADroit = new Position(colonne + 1, ligne);
	        }

	        if (ligne < 8) {
	            positionEnBas = new Position(colonne, ligne + 1);
	        }

	        if (colonne > 0) {
	            positionAGauche = new Position(colonne - 1, ligne);
	        }

	    }
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
		//return Objects.equals(colonne, other.colonne) && Objects.equals(ligne, other.ligne);
		return colonne == other.getColonne() && ligne == other.getLigne();
	}
}
