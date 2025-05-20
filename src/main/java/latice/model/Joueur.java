package latice.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Joueur {
	private final String nom;
	private Integer points;
	private Integer nombreActionRestanteAJouer;
	private Integer nbTuilesPosees;
	private Rack rack;
	public Pioche pioche;
	
	//constructors
	public Joueur(String nom, Integer points, Integer actionsRestante, Integer nbTuilesPosees, Rack rack,
			Pioche pioche) {
		this.nom = nom;
		this.points = points;
		this.nombreActionRestanteAJouer = actionsRestante; //à déplacer dans maitre?
		this.nbTuilesPosees = nbTuilesPosees;
		this.rack = rack;
		this.pioche = pioche;
	}
	
	public Joueur(String nom,Pioche pioche) {
		this(nom, 0, 0, 0, new Rack(), pioche);
	}
	
	public Joueur(String nom) {
		this(nom, 0, 0, 0, new Rack(), new Pioche());
	}

	//comportement	
	public Joueur jouer() {
		//TODO joueur un tour
		
		/* regarde actions
		 * lance en fonction des action */
		
		Joueur suivant;
		suivant = finAction();
		return suivant;
	}
	
	public boolean poserTuile(Tuile tuilePosée, int indice, PlateauDeCase plateauDeCases, PlateauTuiles plateauDeTuiles) {
		Position positionPose = Position.position(indice);
		//if (
		return true;
	}
	
	public boolean siTuilePosableIci(Tuile tuilePosée, int indice, PlateauTuiles plateauDeTuiles) {
		boolean rep = false;
		Position positionPose = Position.position(indice);
		List<Position> positionAutours = positionPose.caseAutour();
		if (plateauDeTuiles.siTuileIci(positionPose)) {
			return false;
		}
		
		for (Position positionAutour : positionAutours) {
			if (plateauDeTuiles.siTuileIci(positionAutour)) {
				rep = true;
				if(plateauDeTuiles.donnerTuilesAPosition(positionAutour).getForme() 
					!= plateauDeTuiles.donnerTuilesAPosition(positionPose).getForme() 
					&& plateauDeTuiles.donnerTuilesAPosition(positionAutour).getCouleur() 
					!= plateauDeTuiles.donnerTuilesAPosition(positionPose).getCouleur()) {
				return false;
				}
			}
		}						
		return rep;
	}
	
	public void echangerRack(Integer nbTuiles) {
		//TODO echange de touts les tuiles dans le rack du joueur
	}
	
	public Boolean acheterAction() {
		if (this.points > 1) {
			this.nombreActionRestanteAJouer++;
			this.points = this.points - 2;
			return true;
		} else {
			return false;
		}
	}
	
	public void passerAction() {
		this.nombreActionRestanteAJouer--;
	}
	
	public Joueur finAction() { //tous ce qu'on doit faire après qu'un joueur ait joué une action (à compléter)
		if (this.nombreActionRestanteAJouer == 0) {
				//à l'autre joueur de jouer
			return null;
		} else {
			//le joueur continue
			return this;
		}
		
	}
	
	public void RemplirSonRack() {
		this.rack.remplirLeRack(this.pioche);
	}

	//getter et setter
	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Rack getRack() {
		return rack;
	}

	public void setRack(Rack rack) {
		this.rack = rack;
	}

	public Pioche getPioche() {
		return pioche;
	}

	public void setPioche(Pioche pioche) {
		this.pioche = pioche;
	}
}
