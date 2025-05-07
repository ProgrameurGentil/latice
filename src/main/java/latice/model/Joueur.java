package latice.model;

import java.util.ArrayList;

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
		this.actionsRestante = actionsRestante; //
		this.nbTuilesPosees = nbTuilesPosees;
		this.rack = rack;
		this.pioche = pioche;
	}
	public Joueur(String nom) {
		this(nom, 0, 0, 0, new Rack(), new Pioche(new ArrayList<Tuile>()));
	}
		
	public void echangerRack(Integer nbTuiles) {
		//TODO echange de tuile dans le rack du joueur
	}
	
	public Integer jouer(Rack rack, Tuile tuile, Case emplacement) {
		//TODO joueur un tour
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
