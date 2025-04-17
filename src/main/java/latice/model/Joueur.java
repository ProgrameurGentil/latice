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
		this.actionsRestante = actionsRestante;
		this.nbTuilesPosees = nbTuilesPosees;
		this.rack = rack;
		this.pioche = pioche;
	}
	
	public void piocher(Rack rack, Pioche pioche) {  //remplir la list rack à parti de la liste pioche jusqu'à rack.nombredetuille = 5// 
		int placevide;
		if (pioche.getTaille() < (5 - rack.getTaille()))
			for (placevide=pioche.getTaille();placevide>0;placevide--) {
				rack.add(pioche.remove(1));
			}
		else {
			for (placevide= (5 - rack.getTaille());placevide>0;placevide--) {
				rack.add(pioche.remove(1));
			}
		}
	}
	
	public void echangerRack() {
		//TODO
		/*créer list temporaire
		 * la replir avec le rack en le vidant
		 * piocher()
		 * vider la list temporaire dans la pioche
		 * poiche.melanger()
		 */
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
