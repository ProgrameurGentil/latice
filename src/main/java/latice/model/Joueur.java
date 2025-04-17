package latice.model;

public class Joueur {
	private final String nom;
	private Integer points;
	private Integer actionsRestante;
	private Integer nbTuilesPosees;
	
	public Joueur(String nom, Integer points, Integer actionsRestante, Integer nbTuilesPosees) {
		this.nom = nom;
		this.points = points;
		this.actionsRestante = actionsRestante;
		this.nbTuilesPosees = nbTuilesPosees;
	}
	
	public Joueur(String nom) {
		this(nom, 0, 0, 0);
	}
	
	public void piocher(Rack rack, Pioche pioche) {
		//TODO
	}
	
	public void echangerRack(Rack rack, Pioche pioche) {
		//TODO
	}
	
	public Integer jouer(Rack rack, Tuile tuile, Case emplacement) {
		//TODO
	}
	
	public Integer acheterAction() {
		//TODO
	}
	
	public void passerAction() {
		//TODO
	}
	
	public Integer finAction() {
		//TODO
	}
}
