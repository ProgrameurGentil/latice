package latice.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlateauTuiles{
	private final Map<Position, Tuile> tuiles;
	
	
	public PlateauTuiles() {
		this.tuiles = new HashMap<>();
	}
	
	public Map<Position, Tuile> tuiles() {
		return tuiles;
	}

	public boolean siTuileIci(Position position) {
		return tuiles.containsKey(position);
	}

	public boolean siListTuileVide() {
		return tuiles.isEmpty();
	}

	public boolean poser(Position position, Tuile tuile) {
		if(tuiles.putIfAbsent(position, tuile) == null) {
			return true;
		}
		return false;
	}

	public void vider() {
		tuiles.clear();
	}

	public int combienDeTuiles() {
		return tuiles.size();
	}

	public Tuile donnerTuilesAPosition(Position position) {
		return tuiles.get(position);
	}
	
	public int combienDeTuileAutour(Position positionPose) {
		int nbTuilesAutour=0;
		List<Position> positionAutours = positionPose.caseAutour();
		for (Position positionAutour : positionAutours) {
			if (this.siTuileIci(positionAutour)) {
				nbTuilesAutour++;
			}
		}
		return nbTuilesAutour;
	}
	
	public boolean siTuilePosableIci(Tuile tuilePosée, Position positionPose) {
		boolean rep = false;
		List<Position> positionAutours = positionPose.caseAutour();
		if (this.siTuileIci(positionPose) || this.combienDeTuileAutour(positionPose) >0 ) {
			return false;
		}
		
		for (Position positionAutour : positionAutours) {
			if (this.siTuileIci(positionAutour)) {
				rep = true;
				if(this.donnerTuilesAPosition(positionAutour).getForme() 
					!= tuilePosée.getForme() 
					&& this.donnerTuilesAPosition(positionAutour).getCouleur() 
					!= tuilePosée.getCouleur()) {
				return false;
				}
			}
		}						
		return rep;
	}
}