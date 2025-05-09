package latice.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PlateauDeCase {
	private final Map<Position, Case> cases;
	
	public PlateauDeCase() {
		this.cases = new HashMap<>();
	}

	public Map<Position, Case> cases() {
		return cases;
	}
	
	public boolean poser(Position position, Case caseDePlus) {
		if(cases.putIfAbsent(position, caseDePlus).equals(Constantes.caseDefault)) {
			return true;
		}
		return false;
	}
	
	public boolean siCaseIci(Position position) {
		return cases.containsKey(position);
	}

	public boolean siCaseEstVide() {
		return cases.isEmpty();
	}

	public Case caseAPosition(Position position) {
		return cases.get(position);
	}

	public Case mettreEnCaseSoleil(Position position) {
		return null;
		// TODO : one line instruction : see in javadoc ;-;
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
				caseDePlus = this.caseAPosition(new Position(i,j));
				nom = caseDePlus.getSmallerType();
				ligne = ligne+" "+nom;
			}
			System.out.println(ligne);
		}
		return result;
	}
}

