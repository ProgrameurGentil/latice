package latice.model;

public class Joueur {
	private final String nom;
	private Integer points;
	private Integer actionsRestante;
	private Integer nbTuilesPosees;
	private Rack rack;
	private Pioche pioche;

	
	public Joueur(String nom, Integer points, Integer actionsRestante, Integer nbTuilesPosees, Rack rack,
			Pioche pioche) {
		this.nom = nom;
		this.points = points;
		this.actionsRestante = actionsRestante;
		this.nbTuilesPosees = nbTuilesPosees;
		this.rack = rack;
		this.pioche = pioche;
	}
	
	public void piocher(Rack rack, Pioche pioche) {
		//TODO
	}
	
	public void echangerRack(Rack rack, Pioche pioche) {
		//TODO
	}
	
	public Integer jouer(Rack rack, Tuile tuile, Case emplacement) {
		//TODO
		return 0;
	}
	
	public Integer acheterAction() {
		//TODO
		return 0;
	}
	
	public void passerAction() {
		//TODO
	}
	
	public Integer finAction() {
		//TODO
		return 0;
	}
}
