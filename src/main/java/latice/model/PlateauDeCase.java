package latice.model;

import java.util.HashMap;
import java.util.Map;

public class PlateauDeCase {
	private final Map<Position, Case> cases;
	
	public PlateauDeCase() {
		this.cases = new HashMap<>();
	}

	public Map<Position, Case> cases() {
		return cases;
	}
	
	public boolean siCaseIci(Position position) {
		return cases.containsKey(position);
	}

	public Case donnerLaCaseAPosition(Position position) {
		return cases.get(position);
	}
	
	public String toString() {
		int i;
		int j;
		String nom;
		String ligne;
		Case caseDePlus;
		String result = "";
		for (i=0;i<9;i++) {
			ligne = "";
			for (j=0;j<9;j++) {
				caseDePlus = this.donnerLaCaseAPosition(new Position(i,j));
				nom = caseDePlus.ecrireCaseEnUneLettre();
				ligne = ligne+" "+nom;
			}
			System.out.println(ligne);
		}
		return result;
	}
	
	public static PlateauDeCase initialisationPlateauCase() {
		PlateauDeCase plateau = new PlateauDeCase();
		
		int i;
		int j;
		Position position;
		for (i=0;i<Constantes.COLONNES;i++) {
			for (j=0;j<Constantes.LIGNES;j++) {
				position = new Position(i,j);
				plateau.cases().put(position, new Case(Type.NORMAL));
			}
		}
		
		for (Position positionSun : Constantes.POSITION_SOLEIL) {
			plateau.cases().replace(positionSun, new Case(Type.SOLEIL));
		}
	plateau.cases().replace(Constantes.CENTRE, new Case(Type.LUNE));
		
		return plateau;
	}
}

